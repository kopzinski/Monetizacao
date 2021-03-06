package bean;

import dao.UsuarioDaoJpa;
import entity.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(eager = true)
@ApplicationScoped 
public class UsuarioMB {

    private List<Usuario> listaUsuarios;
    private Usuario usuarioSelecionado;
    private UsuarioDaoJpa dao;

    public UsuarioMB() {
        if(dao == null) {
            dao = new UsuarioDaoJpa();
        }
        
        usuarioSelecionado = new Usuario();
        listaUsuarios = dao.listar();
        listaUsuarios.add(new Usuario("admin", "admin"));
        
    }

    public Usuario getUsuarioSelecionado() {
        return usuarioSelecionado;
    }

    public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
        this.usuarioSelecionado = usuarioSelecionado;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    

    public String novoUsuario(){
        usuarioSelecionado=new Usuario();
        return("/admin/formularioCadastro?faces-redirect=true");
    }

    public String adicionarUsuario()
    {
        listaUsuarios.add(usuarioSelecionado);
        dao.salvar(usuarioSelecionado);
        return(this.novoUsuario());
    }

    public String editarUsuario(Usuario u){
        usuarioSelecionado = u;
        return("/admin/formularioEdicao?faces-redirect=true");
    }
    public String atualizarUsuario()
    {
        dao.salvar(usuarioSelecionado);
        return("/admin/index?faces-redirect=true");
    }

    public void removerUsuario(Usuario usuario){
        dao.remover(usuario);
        listaUsuarios.remove(usuario);
    }

}
