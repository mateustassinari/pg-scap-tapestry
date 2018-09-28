package br.ufes.scap_tapestry.nucleo.aplicacao;

import br.ufes.scap_tapestry.entities.Afastamento;
import br.ufes.scap_tapestry.entities.Relator;

public interface AplRelator {
	
	void salvar(Relator relator,Afastamento afastamento);
	
	Relator buscaPorAfastamento(String id_afastamento);

}