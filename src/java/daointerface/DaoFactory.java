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

public class DaoFactory {

    public static ClienteDao getClienteDao() {
        return (new ClienteDaoJpa());
    }

    public static ProdutoDao getProdutoDao() {
        return (new ProdutoDaoJpa());
    }

    public static MonetizacaoDaoJpa geMonetizacaoDao() {
        return (new MonetizacaoDaoJpa());
    }
}
