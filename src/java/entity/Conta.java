/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author kopzinski
 * @author padilha
 */
@Entity
@Table(name = "conta")
public class Conta implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "numero")
    private String numero = "";
    
    @Column(name = "saldo")
    private Double saldo;
    
    @OneToMany(mappedBy = "conta")
    private List<Lancamento> lancamentos;

    public Conta() {
    }

    public Conta(String numero, Double saldo) {
        this.saldo = saldo;
        this.numero = numero;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the saldo
     */
    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Lancamento> getLancamentos() {
        return lancamentos;
    }

    public void setLancamentos(List<Lancamento> lancamentos) {
        this.lancamentos = lancamentos;
    }
    
}
