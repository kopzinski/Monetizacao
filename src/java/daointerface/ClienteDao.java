/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daointerface;

/**
 *
 * @author Renan
 */
import entity.Cliente;
import java.util.List;

public interface ClienteDao {
    public void remover(Cliente p);
    public void salvar(Cliente p);
    public Cliente buscarPorId(Long id);
    public List<Cliente> listar();                
}
