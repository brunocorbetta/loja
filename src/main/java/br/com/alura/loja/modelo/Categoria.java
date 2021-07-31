package br.com.alura.loja.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // classe que mapeia o banco de dados chama entidade
@Table(name = "categorias")
public class Categoria {

	@Id // que dizer que essa é minha chave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) //geração automatica
	private Long id;
	private String nome;
	
	public Categoria() {
		
	}
	
	public Categoria(String nome) {
		this.nome = nome;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
