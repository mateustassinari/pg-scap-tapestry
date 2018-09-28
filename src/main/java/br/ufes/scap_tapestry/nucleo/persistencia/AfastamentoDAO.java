package br.ufes.scap_tapestry.nucleo.persistencia;

import java.util.List;

import br.ufes.scap_tapestry.entities.Afastamento;
import br.ufes.scap_tapestry.nucleo.persistencia.BaseDAO;

public interface AfastamentoDAO extends BaseDAO<Afastamento> {

	Afastamento buscaId(String id_afastamento);
	
	List<Afastamento> listaAfastamentos();

}