package br.unitins.topicos2.Repository;

import javax.persistence.EntityManager;

import br.unitins.topicos2.model.DefaultEntity;

public class Repository<T extends DefaultEntity<T>> {
	
	private EntityManager em = null;
	
	public Repository(EntityManager em) {
		this.em = em;
	}
	
	protected EntityManager getEntityManager() {
		return em;
	}
	
	public T save(T entity) {
		return getEntityManager().merge(entity);
	}
	
	public void remove(T entity) {
		getEntityManager().remove(entity);
	}
	
}
