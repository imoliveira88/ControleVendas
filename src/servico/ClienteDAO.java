/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import modelo.Cliente;

/**
 *
 * @author Magalhães Oliveira
 */
public class ClienteDAO extends DAOGenericoJPA<Long, Cliente> {
    
    @Override
    public boolean existe(Cliente p){
        String query = "select e from Cliente e";
        List<Cliente> clientes = super.getEm().createQuery(query, Cliente.class).getResultList();
        try{
            for(Cliente cliente : clientes){
                if(cliente.igual(p)) return true;
            }
            return false;
        }
        catch(NoResultException e){
            return false;
        }
    }
    
    public Cliente retornaPorNome(String nome){
        Cliente resultado = new Cliente();
        Query query = super.getEm().createNamedQuery("Cliente.RetornaPorNome");
        
        query.setParameter("nome", nome);
        
        try{
            return (Cliente) query.getSingleResult();
        }
        catch(NoResultException e){
            return resultado;
        }
    }
    
    public long getIdPorNome(String nome){
        Query query = super.getEm().createQuery("SELECT c.id from Cliente c WHERE c.nome = :nome");
        
        query.setParameter("nome", nome);
        
        try{
            return (long) query.getSingleResult();
        }
        catch(NoResultException e){
            return -1;
        }
    }
    
}
