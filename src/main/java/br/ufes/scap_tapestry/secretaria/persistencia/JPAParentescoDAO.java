package br.ufes.scap_tapestry.secretaria.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.QueryTimeoutException;

import br.ufes.scap_tapestry.entities.Parentesco;
import br.ufes.scap_tapestry.nucleo.persistencia.JPABaseDAO;

public class JPAParentescoDAO extends JPABaseDAO<Parentesco> implements ParentescoDAO{

	private EntityManager manager;

	public JPAParentescoDAO(EntityManager manager) {
		super(manager);
		this.manager = manager;
	}
	
	protected EntityManager getEntityManager() {
		return manager;
	}
	
	@Override
	public Parentesco buscaId(String id_parentesco) {
		Parentesco parentesco = new Parentesco();
		try{
			Query q = manager.createQuery("SELECT a FROM Parentesco a WHERE a.id_parentesco = " + id_parentesco);
			parentesco = (Parentesco)q.getSingleResult();
			return parentesco;
		}catch(NoResultException e1) {
			System.out.println("Pessoa inexistente");
		}catch(QueryTimeoutException e3){
			System.out.println("Query timmed out");
		}catch(Exception e4){
			e4.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean checaParentesco(String id_pessoa1, String id_pessoa2) {
		@SuppressWarnings("unused")
		Parentesco parentesco = new Parentesco();
		try{
			Query q = manager.createQuery("SELECT a FROM Parentesco a WHERE a.pessoa1.matricula = '" + id_pessoa1 + "' AND a.pessoa2.matricula = '" + id_pessoa2+"'");
			parentesco = (Parentesco)q.getSingleResult();
			return true;
		}catch(NoResultException e1) {
			System.out.println("Pessoa inexistente");
			return false;
		}catch(QueryTimeoutException e3){
			System.out.println("Query timmed out");
		}catch(Exception e4){
			e4.printStackTrace();
		}
		return false;
	}
		
}