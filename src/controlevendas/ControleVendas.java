/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlevendas;

import apresentacao.*;
import modelo.*;
import servico.*;

/**
 *
 * @author Magalhães Oliveira
 */
public class ControleVendas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Cliente c = new Cliente("Igor Magalhães","9935-1313");
        ClienteDAO cl = new ClienteDAO();
        cl.save(c);
        
        Funcionario f = new Funcionario("Carlitos","5456-9765");
        FuncionarioDAO fd = new FuncionarioDAO();
        fd.save(f);
        
        Produto p = new Produto("Pão",12.5,10,50);
        ProdutoDAO pd = new ProdutoDAO();
        pd.save(p);
        
        Pedido ped = new Pedido();
        ped.setCliente(c);
        ped.setFuncionario(f);
        
        ItemPedido ip = new ItemPedido(p,3,ped);
        ped.addItem(ip);
        
        PedidoDAO pdao = new PedidoDAO();
        //pdao.save(ped);

        //pdao.fechaPedido(ped);*/

        JFrameAplicacao jFrameAplicacao = new JFrameAplicacao(); // Cria o Frame principal
        jFrameAplicacao.setLocationRelativeTo(null); // Frame no centro 
        jFrameAplicacao.setVisible(true); // Mostra o Frame
    }
    
}
