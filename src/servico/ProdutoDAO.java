/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import modelo.Produto;

/**
 *
 * @author Magalhães Oliveira
 */
public class ProdutoDAO extends DAOGenericoJPA<Long, Produto> {
    
    public Produto retornaPorNome(String nome){
        Produto resultado = new Produto();
        Query query = super.getEm().createNamedQuery("Produto.RetornaPorNome");
        
        query.setParameter("nome", nome);
        
        try{
            return (Produto) query.getSingleResult();
        }
        catch(NoResultException e){
            return resultado;
        }
    }
    
    @Override
    public boolean existe(Produto p){
        String query = "select e from Produto e";
        List<Produto> produtos = super.getEm().createQuery(query, Produto.class).getResultList();
        try{
            for(Produto produto : produtos){
                if(produto.igual(p)) return true;
            }
            return false;
        }
        catch(NoResultException e){
            return false;
        }
    }
}
