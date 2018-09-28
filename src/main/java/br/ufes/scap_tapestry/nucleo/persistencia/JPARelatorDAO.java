package br.ufes.scap_tapestry.nucleo.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.QueryTimeoutException;

import br.ufes.scap_tapestry.entities.Relator;

public class JPARelatorDAO extends JPABaseDAO<Relator> implements RelatorDAO{
	
	private EntityManager manager;
	
	public JPARelatorDAO(EntityManager manager) {
		super(manager);		
		this.manager = manager;
	}
	
	protected EntityManager getEntityManager() {
		return manager;
	}
	
	@Override
	public Relator buscaId(String id_relator) {
		Relator relator = new Relator();
		try{
			Query q = manager.createQuery("SELECT a FROM Relator a WHERE a.id_relator = " + id_relator);
			relator = (Relator)q.getSingleResult();
			return relator;
		}catch(NoResultException e1) {
			System.out.println("Relator inexistente");
		}catch(QueryTimeoutException e3){
			System.out.println("Query timmed out");
		}catch(Exception e4){
			e4.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Relator> listaRelatores() {
		return null;
	}

	@Override
	public Relator buscaPorAfastamento(String id_afastamento) {
		Relator relator = new Relator();
		try{
			Query q = manager.createQuery("SELECT a FROM Relator a WHERE a.afastamento = " + id_afastamento);
			relator = (Relator)q.getSingleResult();
			return relator;
		}catch(NoResultException e1) {
			System.out.println("Relator inexistente");
		}catch(QueryTimeoutException e3){
			System.out.println("Query timmed out");
		}catch(Exception e4){
			e4.printStackTrace();
		}
		return null;
	}
	
}