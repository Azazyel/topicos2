package br.unitins.topicos2.controller;

import java.io.Serializable;

import javax.persistence.EntityManager;

import br.unitins.topicos2.Repository.PessoaRepository;
import br.unitins.topicos2.factory.JPAFactory;
import br.unitins.topicos2.model.Pessoa;

public abstract class Controller implements Serializable {
	
	
	private static final long serialVersionUID = 1590669890713345451L;

private EntityManager em = null;
	
	protected Pessoa entity = null;
	
	public abstract Pessoa getEntity();
	
	public void setEntity(Pessoa entity) {
		this.entity = entity;
	}
	
	protected EntityManager getEntityManager() {
		if (em == null)
			em = JPAFactory.getEntityManager();
		return em;
	}
	
	public abstract void limpar();
	
	public void incluir() {
		PessoaRepository repository = new PessoaRepository(getEntityManager());
		getEntityManager().getTransaction().begin();
		repository.save(getEntity());
		getEntityManager().getTransaction().commit();
		limpar();
		System.out.println("Incluir");
	}
	
	public void alterar() {
		PessoaRepository repository = new PessoaRepository(getEntityManager());
		getEntityManager().getTransaction().begin();
		repository.save(getEntity());
		getEntityManager().getTransaction().commit();
		limpar();
		System.out.println("Alterar");
	}
	
	public void remover() {
		PessoaRepository repository = new PessoaRepository(getEntityManager());
		getEntityManager().getTransaction().begin();
		repository.remove(getEntity());
		getEntityManager().getTransaction().commit();
		limpar();
		System.out.println("Remover");
	}
}