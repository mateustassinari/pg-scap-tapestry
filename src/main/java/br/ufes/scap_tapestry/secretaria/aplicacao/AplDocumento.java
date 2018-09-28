package br.ufes.scap_tapestry.secretaria.aplicacao;

import java.util.List;

import br.ufes.scap_tapestry.entities.Documento;

public interface AplDocumento {
	
	void salvar(Documento documento);
	
	Documento buscaId(String id_documento);
	
	List<Documento> buscaPorAfastamento(String id_afastamento);
	
}