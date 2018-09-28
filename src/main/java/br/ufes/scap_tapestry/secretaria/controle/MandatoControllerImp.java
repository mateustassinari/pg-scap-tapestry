package br.ufes.scap_tapestry.secretaria.controle;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.tapestry5.ioc.annotations.Inject;

import br.ufes.scap_tapestry.entities.Mandato;
import br.ufes.scap_tapestry.entities.Pessoa;
import br.ufes.scap_tapestry.secretaria.aplicacao.AplMandato;
import br.ufes.scap_tapestry.secretaria.aplicacao.AplPessoa;

public class MandatoControllerImp implements MandatoController {

	private String notificacao = "";
	
	@Inject
	private AplMandato aplMandato;
	
	@Inject
    private AplPessoa aplPessoa;
		
	@Override
	public boolean salva(String matricula, Date data_iniMandato, Date data_fimMandato) throws ParseException {
		
		Pessoa pessoa = new Pessoa();
		List<Mandato> mandato = new ArrayList<Mandato>();				
		pessoa = aplPessoa.buscaMatricula(matricula);
		mandato = aplMandato.busca();
		if(pessoa == null) {
			notificacao = "Matrícula não existe";							
			return false;
		}
		
		if(pessoa.getTipoPessoa().equals("1")) {				

			Calendar cal = Calendar.getInstance();
			Calendar cal2 = Calendar.getInstance();

			cal.setTime((data_iniMandato));
			cal2.setTime((data_fimMandato));

			if(cal.after(cal2)) {
				notificacao = "Data de início não pode ser superior a Data final";							
				return false;
			}

			if(!mandato.isEmpty()) {
				System.out.println(mandato);
				if(cal.before(mandato.get(0).getData_fim()) || cal.equals(mandato.get(0).getData_fim())) {									
					notificacao = "Já existe um mandato cadastrado";
					return false;
				}
			}

			Mandato novoMandato = new Mandato();			
			novoMandato.setData_inicio(cal);
			novoMandato.setData_fim(cal2);
			aplMandato.salvar(novoMandato, matricula);
			return true;
			
		} else {
			notificacao = "Somente professores podem ser chefes do departamento";
			return false;
		}
		
	}

	@Override
	public String getNotificacao() {
		return notificacao;
	}

	@Override
	public void setNotificacao(String notificacao) {
		this.notificacao = notificacao;
	}
	
}