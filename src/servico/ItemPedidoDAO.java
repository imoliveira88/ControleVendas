/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import modelo.ItemPedido;

/**
 *
 * @author Magalhães Oliveira
 */
public class ItemPedidoDAO extends DAOGenericoJPA<Long, ItemPedido> {

    @Override
    public boolean existe(ItemPedido entity) {
        return false;
    }
    
}
