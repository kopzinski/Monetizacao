package dao;

import daointerface.ClienteDao;
import entity.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import util.JpaUtil;

/**
 *
 * @author Renan
 * @author kopzinski
 */
public class ClienteDaoJpa implements ClienteDao {

    @Override
    public void remover(Cliente p) {
                EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();        
        em.remove(em.merge(p));
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void salvar(Cliente p) {
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
    public Cliente buscarPorId(Long id) {
              EntityManager em = JpaUtil.getEntityManager();
        Cliente produto = em.find(Cliente.class, id);
        em.close();
        return (produto);
    }

    @Override
    public List<Cliente> listar() {
        EntityManager em = JpaUtil.getEntityManager();
        List<Cliente> listaProdutos = em.createQuery("SELECT p FROM Cliente ").getResultList();
        em.close();
        return (listaProdutos);        
    }

}
