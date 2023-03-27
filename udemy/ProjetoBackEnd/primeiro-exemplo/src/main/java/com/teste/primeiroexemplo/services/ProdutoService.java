package com.teste.primeiroexemplo.services;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.teste.primeiroexemplo.model.Produto;
import com.teste.primeiroexemplo.repository.ProdutoRepository;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;
  
       /**
      * metodo para retornar lista de produtos
       * @return retorna lista de produtos
       */
  
      public List<Produto> obterTodos(){
         return produtoRepository.obterTodos();
      }
  
          /**
       * metodo que retorn o produto encontrado pelo ID
       * @param id do produto que sera localizado
       * @return retorna um produto caso tenha encontrado
       */
  
      public  Optional <Produto> obterPorId(Integer id){
          return produtoRepository.obterPorId(id);
      }
          /**
       * metodo para adicionar produto na lista.
       * @param produto que sera adicionado.
       * @return retorna o produto que foi adicionado na lista.
       */
      public Produto adicionar(Produto produto){
         return produtoRepository.adicionar(produto);
      }
  
  
      /**
       * metodo para deletar o produto  por ID
       * @param id do produto a ser deletado.
       */
      public void deletar(Integer id){
          produtoRepository.deletar(id);
      }
  
      /**
       * metodo para atualizar o produto na lista
       * @param produto produto a ser atualizado
       * @return retorna o produto atualizado
       */
      public Produto atualizar ( Integer id, Produto produto){
      
        produto.setId(id);
  
        return produtoRepository.atualizar(produto);
  
      }
   
}
