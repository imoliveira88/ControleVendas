/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import modelo.*;

/**
 *
 * @author Magalhães Oliveira
 */
public class PedidoDAO extends DAOGenericoJPA<Long, Pedido>{

    @Override
    public boolean existe(Pedido entity) {
        return false;
    }
    
    //Checar se quantidade em estoque é maior que zero!!
    //Atualiza a quantidade em estoque
    public void fechaPedido(Pedido p){
        for(ItemPedido ip : p.getItens()){
            ProdutoDAO pd = new ProdutoDAO();
            Produto prod = pd.retornaPorNome(ip.getProduto().getNome());
            prod.setQuantidade(prod.getQuantidade()-ip.getQuantidade());
            pd.update(prod);
        }
    }
    
    public List<Pedido> pedidosPorCliente(Cliente c){
        List<Pedido> pedidos = new ArrayList<>();
        Query query = super.getEm().createNamedQuery("Pedido.PedidosPorCliente");
        
        query.setParameter("cliente", c);
        
        try{
            return query.getResultList();
        }
        catch(NoResultException e){
            return pedidos;
        }
    }
    
    public List<Pedido> pedidosPorFuncionario(Funcionario c){
        List<Pedido> pedidos = new ArrayList<>();
        Query query = super.getEm().createNamedQuery("Pedido.PedidosPorFuncionario");
        
        query.setParameter("funcionario", c);
        
        try{
            return query.getResultList();
        }
        catch(NoResultException e){
            return pedidos;
        }
    }
   
    
}
