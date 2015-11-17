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
import entity.Produto;
import java.util.List;

public interface ProdutoDao {

    public void remover(Produto p);

    public void salvar(Produto p);

    public Produto buscarPorId(Long id);

    public List<Produto> pesquisarPorNome(String keyword);

    public List<Produto> listar();
}
