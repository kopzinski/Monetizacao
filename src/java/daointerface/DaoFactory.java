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
import dao.ClienteDaoJpa;
import dao.ProdutoDaoJpa;
import dao.MonetizacaoDaoJpa;
import dao.UsuarioDaoJpa;

public class DaoFactory {

    public static ClienteDao getClienteDao() {
        return (new ClienteDaoJpa());
    }

    public static ProdutoDao getProdutoDao() {
        return (new ProdutoDaoJpa());
    }

    public static MonetizacaoDaoJpa getMonetizacaoDao() {
        return (new MonetizacaoDaoJpa());
    }
    
    public static UsuarioDaoJpa getUsuarioDao() {
        return (new UsuarioDaoJpa());
    }
}
