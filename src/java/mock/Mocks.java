/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mock;

import java.util.ArrayList;
import java.util.List;
import entity.Cliente;
import entity.Conta;

/**
 *
 * @author kopzinski
 */
public class Mocks {
    
    private static List<Cliente> clientes = new ArrayList<>();

    public static List<Cliente> getClientesMock() {
        if(clientes.isEmpty()) {
            clientes.add(new Cliente("paulo", "111111", "paulo@email.com", new Conta("111-1",  100.0)));
            clientes.add(new Cliente("eduardo", "222222", "eduardo@email.com", new Conta("222-2", 200.0)));
            clientes.add(new Cliente("mello", "333333", "mello@email.com", new Conta("333-3", 300.0)));
        }
        return clientes;
    }
    
    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
}
