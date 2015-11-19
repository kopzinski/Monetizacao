/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daointerface;

import entity.Conta;
import java.util.List;

/**
 *
 * @author Renan
 * @author kopinski
 */
public interface ContaDao {
    public void salvar(Conta c);
    public List<Conta> listar();  
}
