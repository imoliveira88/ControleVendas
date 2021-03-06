/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.Funcionario;
import modelo.ItemPedido;
import modelo.Pedido;
import servico.ClienteDAO;
import servico.FuncionarioDAO;
import servico.PedidoDAO;
import servico.ProdutoDAO;

/**
 *
 * @author Magalhães Oliveira
 */
public class frmNovoPedido extends javax.swing.JFrame {

    private Pedido ped;
    
    /**
     * Creates new form frmNovoPedido
     */
    public frmNovoPedido() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">   
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        ControleVendasEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("ControleVendas").createEntityManager();
        tbFuncionarioQuery = java.beans.Beans.isDesignTime() ? null : ControleVendasEntityManager.createQuery("SELECT t FROM Funcionario t");
        tbFuncionarioList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : tbFuncionarioQuery.getResultList();
        clienteQuery = java.beans.Beans.isDesignTime() ? null : ControleVendasEntityManager.createQuery("SELECT c FROM Cliente c");
        clienteList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : clienteQuery.getResultList();
        tbProdutoQuery = java.beans.Beans.isDesignTime() ? null : ControleVendasEntityManager.createQuery("SELECT t FROM Produto t");
        tbProdutoList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : tbProdutoQuery.getResultList();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        funcionario = new javax.swing.JComboBox();
        cliente = new javax.swing.JComboBox();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        produto = new javax.swing.JComboBox();
        quantidade = new javax.swing.JTextField();
        botaoAdiciona = new javax.swing.JButton();
        botaoFechar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLabel1.setText("Novo Pedido");

        jLabel2.setText("Funcionario:");

        jLabel3.setText("Cliente: ");

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tbFuncionarioList, funcionario);
        bindingGroup.addBinding(jComboBoxBinding);

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, clienteList, cliente);
        bindingGroup.addBinding(jComboBoxBinding);

        jLabel4.setText("Itens do Pedido");

        jLabel5.setText("Item: ");

        jLabel6.setText("Quantidade: ");

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tbProdutoList, produto);
        bindingGroup.addBinding(jComboBoxBinding);

        quantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantidadeActionPerformed(evt);
            }
        });

        botaoAdiciona.setText("Adicionar Item");
        botaoAdiciona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAdicionaActionPerformed(evt);
            }
        });

        botaoFechar.setText("Fechar Pedido");
        botaoFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoFecharActionPerformed(evt);
            }
        });

        jLabel7.setText("Total");

        total.setEditable(false);
        total.setFont(new java.awt.Font("Tahoma", 0, 24));
        total.setBorder(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(funcionario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cliente, 0, 146, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jSeparator2)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(8, 8, 8)
                            .addComponent(botaoAdiciona)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                            .addComponent(botaoFechar))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6))
                            .addGap(55, 55, 55)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(produto, 0, 152, Short.MAX_VALUE)
                                .addComponent(quantidade)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
            .addGroup(layout.createSequentialGroup())    
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(funcionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(produto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoAdiciona)
                    .addComponent(botaoFechar))
                .addGap(42, 42, 42)
        ));

        bindingGroup.bind();

        pack();
    }// </editor-fold>  

    private void quantidadeActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }

    private void botaoAdicionaActionPerformed(java.awt.event.ActionEvent evt) {                                              
        if(this.ped == null) this.ped = new Pedido();
        ItemPedido ip = new ItemPedido(new ProdutoDAO().retornaPorNome(produto.getSelectedItem().toString()),Integer.parseInt(quantidade.getText()),ped);
        ped.addItem(ip);
        
        JOptionPane.showMessageDialog(null,"Item salvo com sucesso!");

        quantidade.setText("");
        total.setText("R$ " + ped.getTotal());
    }

    private void botaoFecharActionPerformed(java.awt.event.ActionEvent evt) {                                            
        PedidoDAO pd =  new PedidoDAO();
        Cliente cl = new ClienteDAO().retornaPorNome(cliente.getSelectedItem().toString());
        ped.setCliente(cl);
        Funcionario f1 = new FuncionarioDAO().retornaPorNome(funcionario.getSelectedItem().toString());
        ped.setFuncionario(f1);
        pd.fechaPedido(ped);
        pd.save(ped);
        
        this.geraArquivo();
        
        JOptionPane.showMessageDialog(null,"Pedido registrado! Consulte o arquivo txt!");
        
        total.setText("");
    }

    private void geraArquivo(){
        
        String nome = this.ped.toString() + ".txt";
        
        try {
            
            try (FileWriter arq = new FileWriter(nome)) {
                PrintWriter gravarArq = new PrintWriter(arq);
                
                gravarArq.println("Número do Pedido: " + this.ped.getId());
                gravarArq.println("Data do Pedido: " + this.ped.getData());
                gravarArq.println();
                gravarArq.println("-------------------------------------------------------");
                gravarArq.println("Cliente: " + this.ped.getCliente().toString());
                gravarArq.println("Funcionario: " + this.ped.getFuncionario().toString());
                gravarArq.println("-------------------------------------------------------");
                gravarArq.println();
                
                gravarArq.println("Descrição dos itens:");
                gravarArq.println();
                
                for(ItemPedido item : this.ped.getItens()){
                    gravarArq.println("Item: " + item.getProduto().getNome());
                    gravarArq.println("Preço Unitário: R$ " + item.getProduto().getPreco());
                    gravarArq.println("Quantidade: " + item.getQuantidade());
                    gravarArq.println("Subtotal: R$ " + item.getSubtotal());
                    gravarArq.println();
                    gravarArq.println();
                }
                
                gravarArq.println("TOTAL DO PEDIDO: R$ " + this.ped.getTotal());
                
                arq.close();

            }
        } catch (IOException ioe) {
            System.out.println("Deu bronca!");
        }
    }
    

    // Variables declaration - do not modify
    private javax.persistence.EntityManager ControleVendasEntityManager;
    private javax.swing.JButton botaoAdiciona;
    private javax.swing.JButton botaoFechar;
    private javax.swing.JComboBox cliente;
    private java.util.List<modelo.Cliente> clienteList;
    private javax.persistence.Query clienteQuery;
    private javax.swing.JComboBox funcionario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JComboBox produto;
    private javax.swing.JTextField quantidade;
    private java.util.List<modelo.Funcionario> tbFuncionarioList;
    private javax.persistence.Query tbFuncionarioQuery;
    private java.util.List<modelo.Produto> tbProdutoList;
    private javax.persistence.Query tbProdutoQuery;
    private javax.swing.JTextField total;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration 

}
