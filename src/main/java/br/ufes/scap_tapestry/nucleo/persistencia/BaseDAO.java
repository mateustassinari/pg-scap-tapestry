package br.ufes.scap_tapestry.nucleo.persistencia;

public interface BaseDAO<T> {
	
	void salvar (T object);
	
	T merge(T object);
	
	void delete(T object);

}