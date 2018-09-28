package br.ufes.scap_tapestry.secretaria.controle;

import org.apache.tapestry5.ioc.annotations.Inject;

import br.ufes.scap_tapestry.entities.Pessoa;
import br.ufes.scap_tapestry.entities.TipoParentesco;
import br.ufes.scap_tapestry.secretaria.aplicacao.AplParentesco;
import br.ufes.scap_tapestry.secretaria.aplicacao.AplPessoa;

public class ParentescoControllerImp implements ParentescoController {

	private String matricula1;
	
	private String notificacao = "";

	@Inject
	private AplPessoa aplPessoa;
	
	@Inject
	private AplParentesco aplParentesco;
	
	@Override
	public boolean salva(String matricula2,TipoParentesco tipo) {
		
		Pessoa pessoaaux = new Pessoa();
		pessoaaux = aplPessoa.buscaMatricula(matricula2);
		if(pessoaaux == null){
			notificacao = "Matrícula não existe";
			return false;
		}
		if(matricula1.equals(pessoaaux.getMatricula())) {
			notificacao = "Não é possível cadastrar parentesco com uma pessoa";
			return false;
		}
		
		if(pessoaaux.getTipoPessoa().equals("1")) {
			if(aplParentesco.checaParentesco(matricula1,matricula2)) {
				notificacao = "Parentesco já foi cadastrado";
				return false;
			}
			aplParentesco.salvar(matricula1,matricula2,tipo);
			return true;
		} else {
			notificacao =  "É possivel cadastrar parentesco somente entre professores";
			return false;
			}
	}
	
	@Override
	public String getMatricula1() {
		return matricula1;
	}

	@Override
	public void setMatricula1(String matricula1) {
		this.matricula1 = matricula1;
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