/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import daointerface.ProdutoDao;
import entity.Produto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import util.JpaUtil;

/**
 *
 * @author Renan
 */
public class ProdutoDaoJpa implements ProdutoDao {
    

    @Override
    public void salvar(Produto p) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        if (p.getId() == null) {
            em.persist(p);
        } else {
            em.merge(p);
        }
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public void remover(Produto p) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();        
        em.remove(em.merge(p));
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Produto buscarPorId(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        Produto produto = em.find(Produto.class, id);
        em.close();
        return (produto);
    }
    
    @Override
    public List<Produto> pesquisarPorNome(String keyword){
        EntityManager em = JpaUtil.getEntityManager();
        Query query = em.createQuery("SELECT p FROM Produto p "
                        + "WHERE UPPER(p.nome) LIKE :keyword "
                        + "ORDER BY p.nome");
        query.setParameter("keyword", "%" + keyword.toUpperCase() + "%");        
        List<Produto> listaProdutos = query.getResultList(); 
        
        em.close();
        return (listaProdutos);
    }

    @Override
    public List<Produto> listar() {
        EntityManager em = JpaUtil.getEntityManager();
        List<Produto> listaProdutos = em.createQuery("SELECT p FROM Produto p ORDER BY p.nome").getResultList();
        em.close();
        return (listaProdutos);
    }

}
