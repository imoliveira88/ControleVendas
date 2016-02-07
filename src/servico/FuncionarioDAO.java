/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import modelo.Funcionario;

/**
 *
 * @author Magalhães Oliveira
 */
public class FuncionarioDAO extends DAOGenericoJPA<Long, Funcionario> {
    
    @Override
    public boolean existe(Funcionario f){
        String query = "select e from Funcionario e";
        List<Funcionario> funcionarios = super.getEm().createQuery(query, Funcionario.class).getResultList();
        try{
            for(Funcionario funcionario : funcionarios){
                if(funcionario.igual(f)) return true;
            }
            return false;
        }
        catch(NoResultException e){
            return false;
        }
    }
    
    public Funcionario retornaPorNome(String nome){
        Funcionario resultado = new Funcionario();
        Query query = super.getEm().createNamedQuery("Funcionario.RetornaPorNome");
        
        query.setParameter("nome", nome);
        
        try{
            return (Funcionario) query.getSingleResult();
        }
        catch(NoResultException e){
            return resultado;
        }
    }
    
}
