package br.unitins.topicos2.controller;

import java.io.Serializable;

import javax.persistence.EntityManager;

import br.unitins.topicos2.Repository.Repository;
import br.unitins.topicos2.factory.JPAFactory;
import br.unitins.topicos2.model.DefaultEntity;

public abstract class Controller<T extends DefaultEntity<T>> implements Serializable {
	
	private static final long serialVersionUID = 1590669890713345451L;

	private EntityManager em = null;
	
	protected T entity = null;
	
	public abstract T getEntity();
	
	public void setEntity(T entity) {
		this.entity = entity;
	}
	
	protected EntityManager getEntityManager() {
		if (em == null)
			em = JPAFactory.getEntityManager();
		return em;
	}
	
	public abstract void limpar();
	
	public T incluir() {
		Repository<T> repository = new Repository<T>(getEntityManager());
		getEntityManager().getTransaction().begin();
		T result = repository.save(getEntity());
		getEntityManager().getTransaction().commit();
		limpar();
		System.out.println("Incluir");
		return result;
	}
	
	public T alterar() {
		Repository<T> repository = new Repository<T>(getEntityManager());
		getEntityManager().getTransaction().begin();
		T result = repository.save(getEntity());
		getEntityManager().getTransaction().commit();
		limpar();
		System.out.println("Alterar");
		return result;
	}
	
	public void remover() {
		Repository<T> repository = new Repository<T>(getEntityManager());
		getEntityManager().getTransaction().begin();
		repository.remove(getEntity());
		getEntityManager().getTransaction().commit();
		limpar();
		System.out.println("Remover");
	}
}