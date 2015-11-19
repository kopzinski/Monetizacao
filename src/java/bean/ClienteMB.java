package bean;

import dao.ClienteDaoJpa;
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
    private ClienteDaoJpa dao;
    private String cpf;

    public ClienteMB() {
        if(dao == null) {
            dao = new  ClienteDaoJpa();
        }
        clienteSelecionado = new Cliente();
        listaClientes = dao.listar();
        //listaClientes = Mocks.getClientesMock();
    }
    
    public String filtrar(){
        if(cpf.isEmpty()){
            listaClientes = dao.listar();
        } else {
            listaClientes = dao.listarPorCpf(cpf);
        }
        
        return("/admin/listaClientes?faces-redirect=true");    
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
        dao.salvar(clienteSelecionado);
        if(novo) {
            listaClientes.add(clienteSelecionado);
            clienteSelecionado = new Cliente();
        } 
        novo = true;
        return("/admin/listaClientes?faces-redirect=true");    
    }

    public void removerCliente(Cliente cliente) {
        dao.remover(cliente);
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    
}
