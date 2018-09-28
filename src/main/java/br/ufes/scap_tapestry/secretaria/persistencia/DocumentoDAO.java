package br.ufes.scap_tapestry.secretaria.persistencia;

import java.util.List;

import br.ufes.scap_tapestry.entities.Documento;
import br.ufes.scap_tapestry.nucleo.persistencia.BaseDAO;

public interface DocumentoDAO extends BaseDAO<Documento> {
	
	Documento buscaId(String id_documento);
	
	List<Documento> buscaPorAfastamento(String id_afastamento);
	
}