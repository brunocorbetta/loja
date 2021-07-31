package br.com.alura.loja.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.modelo.Produto;

public class ProdutoDAO {

	private EntityManager em;

	public ProdutoDAO(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Produto produto) { //para inserir
		this.em.persist(produto);
	}

	public void remover(Produto produto) { //para remover
		this.em.remove(produto);
	}

	public void atualizar(Produto produto) { //sai do banco de dados para eu poder atualizar de novo
		this.em.merge(produto);
	}

	public Produto bucarPorId(Long id) {
		return em.find(Produto.class, id);  // busca usando p hibernete
	}

	public List<Produto> buscarTodos() {
		String jpql = "SELECT p FROM Produto p"; // usando filtros com o jpql que uma sql orientado a objetos
		return em.createQuery(jpql, Produto.class).getResultList(); 
	}

    public List<Produto> buscarPorNomeDaCategoria(String nome) {
        String jpql = "SELECT p FROM Produto p WHERE p.nome = :nome";
        return em.createQuery(jpql, Produto.class)
                .setParameter("nome", nome)
                .getResultList();             
    }
    
    public BigDecimal buscarPorNome(String nome) {
        String jpql = "SELECT p.preco FROM Produto p WHERE p.categoria.nome = :nome";
            return em.createQuery(jpql, BigDecimal.class)
                        .setParameter("nome", nome)
                        .getSingleResult();
        }
}
