/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import daointerface.ContaDao;
import entity.Conta;
import javax.persistence.EntityManager;
import util.JpaUtil;

/**
 *
 * @author Renan
 */
public class ContaDaoJpa implements ContaDao{

    @Override
    public void salvar(Conta c) {
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
}
