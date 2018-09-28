package br.ufes.scap_tapestry.nucleo.controle;

import br.ufes.scap_tapestry.entities.Pessoa;

public interface VerificaPermissaoController {

	boolean verifica_secre(Pessoa pessoa_aux);

	boolean verifica_prof(Pessoa pessoa_aux);

	String getNotificacao();

	void setNotificacao(String notificacao);

}