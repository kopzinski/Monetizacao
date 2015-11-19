package bean;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
//import mock.Mocks;
import entity.Cliente;

@ManagedBean(eager = true)
@ApplicationScoped 
public class ClienteMB {
    
    private boolean novo ;
    private List<Cliente> listaClientes;
    private Cliente clienteSelecionado;

    public ClienteMB() {
        clienteSelecionado = new Cliente();
        listaClientes = new ArrayList<>();
        //listaClientes = Mocks.getClientesMock();
    }

    public String novoCliente() {
        novo = true;
        clienteSelecionado = new Cliente();
        return("/admin/formClientes?faces-redirect=true");
    }

    public String editarCliente(Cliente u) {
        clienteSelecionado = u;
        novo = false;
        return("/admin/formClientes?faces-redirect=true");
    }
    
    public String salvarCliente() {
        if(novo) {
            listaClientes.add(clienteSelecionado);
            clienteSelecionado = new Cliente();
        } 
        novo = true;
        return("/admin/listaClientes?faces-redirect=true");    
    }

    public void removerCliente(Cliente cliente) {
        listaClientes.remove(cliente);
    }

    public boolean isNovo() {
        return novo;
    }
    public void setNovo(boolean novo) {
        this.novo = novo;
    }
    public Cliente getClienteSelecionado() {
        return clienteSelecionado;
    }
    public void setClienteSelecionado(Cliente clienteSelecionado) {
        this.clienteSelecionado = clienteSelecionado;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }
    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }    
    
    
}
