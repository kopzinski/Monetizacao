package daointerface;

/**
 *
 * @author Renan
 * @author kopzinski
 */
import entity.Usuario;
import java.util.List;

public interface UsuarioDao {

    public void remover(Usuario p);

    public void salvar(Usuario p);

    public Usuario buscarPorId(Long id);

    public List<Usuario> listar();
}
