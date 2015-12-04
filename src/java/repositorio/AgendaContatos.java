/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ejb.Stateless;
import model.Contato;

/**
 *
 * @author lhries
 */
@Stateless
public class AgendaContatos {
    private List<Contato> listaContatos;

    public AgendaContatos() {
        listaContatos = new ArrayList<>();
        listaContatos.add(new Contato("Fulano","fulano@mail.com"));
        listaContatos.add(new Contato("Sicrano","sicrano@mail.com"));
    }
    
    public void adicionar(Contato c)   
    {
        listaContatos.add(c);
    }

    public List<Contato> getContatos() {
        return listaContatos;
    }
}
