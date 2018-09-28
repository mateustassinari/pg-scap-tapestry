package br.ufes.scap_tapestry.nucleo.persistencia;

import java.util.List;

import br.ufes.scap_tapestry.entities.Relator;

public interface RelatorDAO extends BaseDAO<Relator> {
	
	Relator buscaId(String id_relator);
	
	Relator buscaPorAfastamento(String id_afastamento);
	
	List<Relator> listaRelatores();
}