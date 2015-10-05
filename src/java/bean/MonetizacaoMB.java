package bean;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import model.Cliente;
import model.Produto;

@ManagedBean(eager = true)
@ApplicationScoped 
public class MonetizacaoMB {
    private Cliente clienteOrigem;
    private Cliente clienteDestino;
    private Double valor = 0.0;
    private Double saldoOrigem = 0.0;
    private Double saldoDestino = 0.0;
    
    public MonetizacaoMB() {
        
    }
    
    public void simularOperacao() {
        if(clienteOrigem != null && clienteOrigem.getConta() != null) {
            saldoOrigem = clienteOrigem.getConta().getSaldo() - valor;
        }
        if(clienteDestino != null && clienteDestino.getConta() != null) {
            saldoDestino = clienteDestino.getConta().getSaldo() + valor;
        }
    }
    
    public void executarOperacao() {
        if(clienteOrigem != null && clienteOrigem.getConta() != null) {
            clienteOrigem.getConta().setSaldo(saldoOrigem);
        }
        if(clienteDestino != null && clienteDestino.getConta() != null) {
            clienteDestino.getConta().setSaldo(saldoDestino);
        }
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
    
}
