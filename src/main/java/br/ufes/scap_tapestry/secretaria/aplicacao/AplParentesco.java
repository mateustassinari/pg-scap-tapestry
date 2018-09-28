package br.ufes.scap_tapestry.secretaria.aplicacao;

import br.ufes.scap_tapestry.entities.TipoParentesco;

public interface AplParentesco {
	
	void salvar(String matricula1,String matricula2,TipoParentesco tipo);
	
	boolean checaParentesco(String matricula1,String matricula2);
	
}