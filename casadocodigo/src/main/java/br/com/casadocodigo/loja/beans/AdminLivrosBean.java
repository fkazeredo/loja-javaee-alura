package br.com.casadocodigo.loja.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.com.casadocodigo.loja.daos.AutorDao;
import br.com.casadocodigo.loja.daos.LivroDao;
import br.com.casadocodigo.loja.models.Autor;
import br.com.casadocodigo.loja.models.Livro;

@Named
@RequestScoped
public class AdminLivrosBean {

	@Inject
	private LivroDao livroDao;

	@Inject
	private AutorDao autorDao;
	
	@Inject
	private FacesContext context;

	private Livro livro = new Livro();

	private List<Integer> autoresId = new ArrayList<Integer>();

	@Transactional
	public String salvar() {
		for (Integer autorId : autoresId) {
			this.livro.addAutor(autorId);
		}
		this.livroDao.salvar(livro);

		this.context.getExternalContext().getFlash().setKeepMessages(true);
		this.context.addMessage(null, new FacesMessage("Livro cadastrado com sucesso"));

		return "/livros/lista?faces-redirect=true";
	}

	public List<Autor> getAutores() {
		return this.autorDao.listar();
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public LivroDao getLivroDao() {
		return livroDao;
	}

	public void setLivroDao(LivroDao livroDao) {
		this.livroDao = livroDao;
	}

	public List<Integer> getAutoresId() {
		return autoresId;
	}

	public void setAutoresId(List<Integer> autoresId) {
		this.autoresId = autoresId;
	}

}
