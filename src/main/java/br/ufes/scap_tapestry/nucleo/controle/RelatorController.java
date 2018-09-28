package br.ufes.scap_tapestry.nucleo.controle;

import br.ufes.scap_tapestry.entities.Afastamento;
import br.ufes.scap_tapestry.entities.Pessoa;

public interface RelatorController {

	boolean salva(String matricula);

	boolean verifica(Pessoa pessoa_aux, Afastamento afastamento);

	String getIdAfastamento();

	void setIdAfastamento(String idAfastamento);

	String getNotificacao();

	void setNotificacao(String notificacao);

}