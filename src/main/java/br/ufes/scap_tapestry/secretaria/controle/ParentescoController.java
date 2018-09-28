package br.ufes.scap_tapestry.secretaria.controle;

import br.ufes.scap_tapestry.entities.TipoParentesco;

public interface ParentescoController {

	boolean salva(String matricula2, TipoParentesco tipo);

	String getMatricula1();

	void setMatricula1(String matricula1);

	String getNotificacao();

	void setNotificacao(String notificacao);

}