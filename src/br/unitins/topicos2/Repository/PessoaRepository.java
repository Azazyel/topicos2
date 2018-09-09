package br.unitins.topicos2.Repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.unitins.topicos2.model.Pessoa;

public class PessoaRepository {
	
	private EntityManager em;
	
	public PessoaRepository(EntityManager em) {
		this.em = em;
	}
	
	public EntityManager getEntityManager() {
		return em;
	}
	
	public void save(Pessoa entity) {
		getEntityManager().merge(entity);
	}
	
	public void remove(Pessoa entity) {
		getEntityManager().remove(entity);
	}
	
	@SuppressWarnings("unchecked")
	public List<Pessoa> getPessoas() {
		List<Pessoa> Lista = getEntityManager().createQuery("Select p From Pessoa p Order by p.id desc").getResultList();
			if (Lista == null)
				Lista = new ArrayList<Pessoa>();
		return Lista;
	}

	
}
