package bean;

import dao.ClienteDaoJpa;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
//import mock.Mocks;
import entity.Cliente;

@ManagedBean(eager = true)
@ApplicationScoped 
public class MonetizacaoMB {
    private String cpfOrigem;
    private String cpfDestino;


    private Cliente clienteOrigem;
    private Cliente clienteDestino;
    private Double valor = 0.0;
    private Double saldoOrigem = 0.0;
    private Double saldoDestino = 0.0;
    private String dataTest;
    private List<Cliente> listaClientes;
    private ClienteDaoJpa clienteDao;


    
    public MonetizacaoMB() {
        if(clienteDao == null) {
            clienteDao = new ClienteDaoJpa();
        }
        if(listaClientes == null || listaClientes.isEmpty()) {
            listaClientes = clienteDao.listar();
        }
    }
    
    public Cliente findClienteByCpf (String cpf) {
        listaClientes = clienteDao.listarPorCpf(cpf);
        
        return null;
    }
    
    public String simularOperacao() {
        
        clienteOrigem = findClienteByCpf(cpfOrigem);
        clienteDestino = findClienteByCpf(cpfDestino);
        System.out.println("Kop! valor:" + valor);
        if(clienteOrigem != null && clienteOrigem.getConta() != null) {
            saldoOrigem = clienteOrigem.getConta().getSaldo() - valor;
        }
        if(clienteDestino != null && clienteDestino.getConta() != null) {
            saldoDestino = clienteDestino.getConta().getSaldo() + valor;
        }
        return "operacoes";
    }
    
    public String executarOperacao() {
        if(clienteOrigem != null && clienteOrigem.getConta() != null) {
            clienteOrigem.getConta().setSaldo(saldoOrigem);
        }
        if(clienteDestino != null && clienteDestino.getConta() != null) {
            clienteDestino.getConta().setSaldo(saldoDestino);
        }
        return "operacoes";
    }

    public Cliente getClienteOrigem() {
        return clienteOrigem;
    }

    public void setClienteOrigem(Cliente clienteOrigem) {
        this.clienteOrigem = clienteOrigem;
    }

    public Cliente getClienteDestino() {
        return clienteDestino;
    }

    public void setClienteDestino(Cliente clienteDestino) {
        this.clienteDestino = clienteDestino;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getSaldoOrigem() {
        return saldoOrigem;
    }

    public void setSaldoOrigem(Double saldoOrigem) {
        this.saldoOrigem = saldoOrigem;
    }

    public Double getSaldoDestino() {
        return saldoDestino;
    }

    public void setSaldoDestino(Double saldoDestino) {
        this.saldoDestino = saldoDestino;
    }

    public String getDataTest() {
        return dataTest;
    }

    public void setDataTest(String dataTest) {
        this.dataTest = dataTest;
    }
    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }    
        public String getCpfOrigem() {
        return cpfOrigem;
    }

    public void setCpfOrigem(String cpfOrigem) {
        this.cpfOrigem = cpfOrigem;
    }

    public String getCpfDestino() {
        return cpfDestino;
    }

    public void setCpfDestino(String cpfDestino) {
        this.cpfDestino = cpfDestino;
    }
}
