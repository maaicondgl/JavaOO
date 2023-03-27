package com.teste.primeiroexemplo.repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.teste.primeiroexemplo.model.Produto;

@Repository
public class ProdutoRepository {

   private List<Produto> produtos = new ArrayList<Produto>();
   private Integer ultimoId = 0;

    /**
     *  Metodo para retorna lista de produtos
     * @return lista de produtos
     */

    public List<Produto> obterTodos() {
     return  produtos;

    }
    /**
     * metodo que retorn o produto encontrado pelo ID
     * @param id do produto que sera localizado
     * @return retorna um produto caso tenha encontrado
     */

    public  Optional<Produto> obterPorId(Integer id){
       return produtos
           .stream()
           .filter(produto -> produto.getId() == id)
           .findFirst();  
    }

    /**
     * metodo para adicionar produto na lista.
     * @param produto que sera adicionado.
     * @return retorna o produto que foi adicionado na lista.
     */
    public Produto adicionar(Produto produto){
        ultimoId++;
        produto.setId(ultimoId);
        produtos.add(produto);
        return produto;
    }


    /**
     * metodo para deletar o produto  por ID
     * @param id do produto a ser deletado.
     */
    public void deletar(Integer id){
        produtos.removeIf(produto -> produto.getId() == id);
    }

    /**
     * metodo para atualizar o produto na lista
     * @param produto produto a ser atualizado
     * @return retorna o produto atualizado
     */
    public Produto atualizar (Produto produto){
        // encontrar produto na lista
        Optional<Produto> produtoEncontrado = obterPorId(produto.getId());
        if(produtoEncontrado.isEmpty()){
            throw new InputMismatchException("Produto não encontrado");
        }

        deletar(produto.getId());
        produtos.add(produto);
        return produto;

    }
}
