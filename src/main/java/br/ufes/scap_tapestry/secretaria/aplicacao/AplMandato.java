package br.ufes.scap_tapestry.secretaria.aplicacao;

import java.util.List;


import br.ufes.scap_tapestry.entities.Mandato;

public interface AplMandato {
	
	void salvar(Mandato novoMandato,String matricula);
	
	boolean checaMandato(String id_pessoa);
	
	List<Mandato> busca();
		
}