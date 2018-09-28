package br.ufes.scap_tapestry.secretaria.persistencia;

import br.ufes.scap_tapestry.entities.Parentesco;
import br.ufes.scap_tapestry.nucleo.persistencia.BaseDAO;

public interface ParentescoDAO extends BaseDAO<Parentesco>{
	
	Parentesco buscaId(String id_parentesco);
	
	Boolean checaParentesco(String id_pessoa1, String id_pessoa2);

}