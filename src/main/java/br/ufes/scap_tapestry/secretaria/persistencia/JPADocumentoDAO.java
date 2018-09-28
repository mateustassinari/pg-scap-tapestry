package br.ufes.scap_tapestry.secretaria.persistencia;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.QueryTimeoutException;
import br.ufes.scap_tapestry.entities.Documento;
import br.ufes.scap_tapestry.nucleo.persistencia.JPABaseDAO;

public class JPADocumentoDAO extends JPABaseDAO<Documento> implements DocumentoDAO {

	private EntityManager manager;

	public JPADocumentoDAO(EntityManager manager) {
		super(manager);
		this.manager = manager;
	}
	
	protected EntityManager getEntityManager() {
		return manager;
	}
	
	@Override
	public Documento buscaId(String id_documento) {
		Documento documento = new Documento();
		try{
			Query q = manager.createQuery("SELECT a FROM Documento a WHERE a.id_documento = " + id_documento);
			documento = (Documento)q.getSingleResult();
			return documento;
		}catch(NoResultException e1) {
			System.out.println("documento inexistente");
		}catch(QueryTimeoutException e3){
			System.out.println("Query timmed out");
		}catch(Exception e4){
			e4.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Documento> buscaPorAfastamento(String id_afastamento) {
		List<Documento> lista = new ArrayList<Documento>();
		try{
			Query q = manager.createQuery("SELECT a FROM Documento a WHERE a.afastamento = " + id_afastamento);
			lista = q.getResultList();
			return lista;
		}catch(NoResultException e1) {
			System.out.println("documento inexistente");
		}catch(QueryTimeoutException e3){
			System.out.println("Query timmed out");
		}catch(Exception e4){
			e4.printStackTrace();
		}
		return null;
	}
	
}