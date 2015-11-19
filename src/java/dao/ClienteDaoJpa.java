package dao;

import daointerface.ClienteDao;
import entity.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
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
        ContaDaoJpa contaDao = new ContaDaoJpa();
        //salvando a conta primeiro
        contaDao.salvar(p.getConta());
        
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
        List<Cliente> listaProdutos = em.createQuery("SELECT c FROM Cliente c").getResultList();
        em.close();
        return (listaProdutos);        
    }
    
    
    public List<Cliente> listarPorCpf(String cpf) {
        EntityManager em = JpaUtil.getEntityManager();
        Query query = em.createQuery("SELECT c FROM Cliente c WHERE c.cpf = :cpf ");
        query.setParameter("cpf", cpf);
        List<Cliente> listaProdutos = query.getResultList();
        em.close();
        return (listaProdutos);        
    }    

}
