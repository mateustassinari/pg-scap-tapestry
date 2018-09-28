package br.ufes.scap_tapestry.nucleo.controle;

import org.apache.tapestry5.ioc.annotations.Inject;

import br.ufes.scap_tapestry.nucleo.aplicacao.AplAfastamento;
import br.ufes.scap_tapestry.nucleo.aplicacao.AplRelator;
import br.ufes.scap_tapestry.entities.Afastamento;
import br.ufes.scap_tapestry.entities.Pessoa;
import br.ufes.scap_tapestry.entities.Relator;
import br.ufes.scap_tapestry.secretaria.aplicacao.AplMandato;
import br.ufes.scap_tapestry.secretaria.aplicacao.AplParentesco;
import br.ufes.scap_tapestry.secretaria.aplicacao.AplPessoa;

public class RelatorControllerImp implements RelatorController {

	private String idAfastamento;
	
	private String notificacao = "";

	@Inject
	private AplRelator aplRelator;

	@Inject
	private AplAfastamento aplAfastamento;

	@Inject
	private AplPessoa aplPessoa;

	@Inject
	private AplParentesco aplParentesco;
	
	@Inject
    private AplMandato aplMandato;

	@Override
	public boolean salva(String matricula) {
		
		Relator relator = new Relator();
		Afastamento afastamento = aplAfastamento.buscaId(idAfastamento);
		Pessoa pessoaaux = new Pessoa();
		pessoaaux = aplPessoa.buscaMatricula(matricula);
		
		if (pessoaaux == null || pessoaaux.getTipoPessoa().equals("2")) {
			notificacao = "Matrícula não existe ou o Relator não pode ser um secretário";
			return false;
		}
		
		if (aplParentesco.checaParentesco(afastamento.getSolicitante().getMatricula(),
				pessoaaux.getMatricula())) {
			notificacao = "Relator não pode ser um parente do solicitante do afastamento";
			return false;
		} 
		
		if(pessoaaux.getId_pessoa().toString().equals(afastamento.getSolicitante().getId_pessoa().toString())) {
			notificacao = "Relator não pode ser o solicitante do afastamento";
			return false;
		} else {
			relator.setRelator(pessoaaux);
			aplRelator.salvar(relator, afastamento);
			return true;
			}
	}
	
	@Override
	public boolean verifica(Pessoa pessoa_aux, Afastamento afastamento) {
		
		if(!(aplMandato.checaMandato(pessoa_aux.getId_pessoa().toString()))) {
			notificacao = "Somente o chefe do departamento tem acesso a essa tarefa";
  		  	return false;
		}
  	
		if(!afastamento.getSituacaoSolicitacao().getStatusAfastamento().equals("INICIADO")) {
			notificacao = "O afastamento não se encontra no status: INICIADO";
			return false;
		}
		return true;
	}

	@Override
	public String getIdAfastamento() {
		return idAfastamento;
	}

	@Override
	public void setIdAfastamento(String idAfastamento) {
		this.idAfastamento = idAfastamento;
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
