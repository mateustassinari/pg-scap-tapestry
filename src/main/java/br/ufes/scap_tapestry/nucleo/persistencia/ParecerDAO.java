package br.ufes.scap_tapestry.nucleo.persistencia;

import java.util.List;

import br.ufes.scap_tapestry.entities.Parecer;

public interface ParecerDAO extends BaseDAO<Parecer> {
	
	Parecer buscaId(String id_parecer);
	
	List<Parecer> buscaPorAfastamento(String id_afastamento);

}