package br.ufes.scap_tapestry.nucleo.aplicacao;

import br.ufes.scap_tapestry.entities.Pessoa;

public interface Usuario {

	void login(Pessoa usuario);

	boolean isLogado();

	String getMatricula();

	Pessoa getLogado();

	void logout();

}