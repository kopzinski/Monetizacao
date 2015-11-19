package dao;

import daointerface.UsuarioDao;
import entity.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import util.JpaUtil;


/**
 *
 * @author Renan
 * @author kopzinski
 */
public class UsuarioDaoJpa implements UsuarioDao{


    @Override
    public void salvar(Usuario p) {
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
    public void remover(Usuario p) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();        
        em.remove(em.merge(p));
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Usuario buscarPorId(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        Usuario pessoa = em.find(Usuario.class, id);
        em.close();
        return (pessoa);
    }

    @Override
    public List<Usuario> listar() {
        EntityManager em = JpaUtil.getEntityManager();
        List<Usuario> listaPessoas = em.createQuery("SELECT u FROM Usuario u").getResultList();
        em.close();
        return (listaPessoas);
    }



}
