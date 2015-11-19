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
 * @author kopzinski
 */

public class ContaDaoJpa implements ContaDao {

    @Override
    public void salvar(Conta p) {
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
}

