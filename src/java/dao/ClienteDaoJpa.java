/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import daointerface.ClienteDao;
import entity.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import util.JpaUtil;

/**
 *
 * @author Renan
 */
public class ClienteDaoJpa implements ClienteDao {

    @Override
    public void salvar(Cliente c) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        if (c.getId() == null) {
            em.persist(c);
        } else {
            em.merge(c);
        }
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public void remover(Cliente c) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(c));
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        Cliente cliente = em.find(Cliente.class, id);
        em.close();
        return (cliente);
    }

    @Override
    public List<Cliente> listar() {
        EntityManager em = JpaUtil.getEntityManager();
        List<Cliente> listaClientes = em.createQuery("SELECT c FROM Cliente c").getResultList();
        em.close();
        return (listaClientes);
    }

}
