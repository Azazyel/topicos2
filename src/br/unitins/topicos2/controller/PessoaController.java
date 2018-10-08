package br.unitins.topicos2.controller;

import java.util.List;
import javax.inject.Named;
import br.unitins.topicos2.Repository.PessoaRepository;
import br.unitins.topicos2.model.Pessoa;

@Named
@javax.faces.view.ViewScoped
public class PessoaController extends Controller<Pessoa> {

	private static final long serialVersionUID = 8637843622408548669L;


	private List<Pessoa> listaPessoa = null;

	public void limpar() {
		setEntity(null);
		listaPessoa = null;
	}
	
	public List<Pessoa> getListaPessoa() {
		PessoaRepository repository = new PessoaRepository(getEntityManager());
		if (listaPessoa == null)
			listaPessoa = repository.getPessoas();
		
		return listaPessoa;
	}

	public Pessoa getEntity() {
		if (entity == null)
			entity = new Pessoa();
		return entity;
	}

}
