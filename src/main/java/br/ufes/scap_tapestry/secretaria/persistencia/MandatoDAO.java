package br.ufes.scap_tapestry.secretaria.persistencia;

import java.util.List;

import br.ufes.scap_tapestry.entities.Mandato;
import br.ufes.scap_tapestry.nucleo.persistencia.BaseDAO;

public interface MandatoDAO extends BaseDAO<Mandato> {
	
	Mandato buscaId(String id_mandato);
	
	boolean checaMandato(String id_pessoa);
	
	List<Mandato> listaMandatos();

}