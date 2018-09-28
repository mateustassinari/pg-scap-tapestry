package br.ufes.scap_tapestry.nucleo.persistencia;

import javax.persistence.EntityManager;

public class JPABaseDAO<T> implements BaseDAO<T>{
	
	private EntityManager manager;
	
	public JPABaseDAO(EntityManager manager){
		this.manager = manager;
	}
	
	protected EntityManager getEntityManager() {
		return manager;
	}
	
	@Override
	public void salvar(T object) {
		manager.persist(object);
		
	}
	
	@Override
	public T merge(T object) {			
		manager.merge(object);
		return manager.merge(object);
		
	}
	
	@Override
	public void delete(T object) {		
		manager.remove(manager.merge(object));
	}

}