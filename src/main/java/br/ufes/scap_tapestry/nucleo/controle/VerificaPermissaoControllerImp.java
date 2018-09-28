package br.ufes.scap_tapestry.nucleo.controle;

import br.ufes.scap_tapestry.entities.Pessoa;

public class VerificaPermissaoControllerImp implements VerificaPermissaoController {

	private String notificacao = "";
	
	@Override
	public boolean verifica_secre(Pessoa pessoa_aux) {
		
		if(!(pessoa_aux.getTipoPessoa().equals("2"))) {
      		notificacao = "Somente secretários do departamento tem acesso a esssa tarefa";
      		return false;
		}
		return true;
	}
	
	@Override
	public boolean verifica_prof(Pessoa pessoa_aux) {
		
		if(!(pessoa_aux.getTipoPessoa().equals("1"))) {
			notificacao = "Somente professores tem acesso a essa tarefa";
			return false;
		}
		return true;
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
