package br.com.casadocodigo.loja.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String titulo;

	@Lob
	private String descricao;
	private BigDecimal preco;
	private Integer numeroDePaginas;

	@ManyToMany
	private List<Autor> autores = new ArrayList<Autor>();

	public void addAutor(Integer autorId) {
		this.autores.add(new Autor(autorId));
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Integer getNumeroDePaginas() {
		return numeroDePaginas;
	}

	public void setNumeroDePaginas(Integer numeroDePaginas) {
		this.numeroDePaginas = numeroDePaginas;
	}

	public List<Autor> getAutores() {
		return Collections.unmodifiableList(this.autores);
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	@Override
	public String toString() {
		return "Livro [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", preco=" + preco
				+ ", numeroDePaginas=" + numeroDePaginas + ", autores=" + autores + "]";
	}

	public Livro() {
	}

}
