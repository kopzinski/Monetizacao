package bean;

import model.Usuario;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class LoginMB {

    private String login, senha;
    private Usuario usuarioLogado;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public boolean estaLogado() {
        return (usuarioLogado != null);
    }

    public boolean eAdmin() {
        return (this.estaLogado() && this.getUsuarioLogado().isAdmin());
    }

    public String verificaLogin() {
        //Pega o contexto do JSF - serve agora e depois para mensagem.
        FacesContext contexto = FacesContext.getCurrentInstance();
        //Obt�m o usuarioMB criado pelo servidor (n�vel de aplica��o)
        UsuarioMB usuarioMB = (UsuarioMB) contexto.getExternalContext().getApplicationMap().get("usuarioMB");
        //A partir do usuarioMB do servidor, pegamos a lista de usu�rios cadastrados no sistema
        List<Usuario> listaUsuarios = usuarioMB.getListaUsuarios();

        for (Usuario usuario : listaUsuarios) {
            if (usuario.verificaLogin(login, senha)) {
                usuarioLogado = usuario;
                if (usuario.isAdmin()) {
                    return ("/admin/index?faces-redirect=true");
                } else {
                    return ("usuario/index?faces-redirect=true");
                }
            }
        }
        FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Login inv�lido!", "Usu�rio ou senha est�o errados!");
        contexto.addMessage("idMensagem", mensagem);
        return ("/login");
    }

    public String realizaLogout() {
        usuarioLogado = null;
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return ("/login?faces-redirect=true");
    }

}
