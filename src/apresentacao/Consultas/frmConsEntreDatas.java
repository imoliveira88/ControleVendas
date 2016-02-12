package apresentacao.Consultas;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Magalhães Oliveira
 */
public class frmConsEntreDatas extends javax.swing.JFrame {

    /**
     * Creates new form frmConsEntreDatas
     */
    public frmConsEntreDatas() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        ControleVendasEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("ControleVendas").createEntityManager();
        pedidoQuery = java.beans.Beans.isDesignTime() ? null : ControleVendasEntityManager.createQuery("SELECT p FROM Pedido p");
        pedidoList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : pedidoQuery.getResultList();
        jLabel1 = new javax.swing.JLabel();
        data = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dataInicial = new javax.swing.JFormattedTextField(setMascara("##-##-####"));
        dataFinal = new javax.swing.JFormattedTextField(setMascara("##-##-####"));
        filtrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Consulta de Pedidos entre Datas");

        data.setText("Data Inicial:");

        jLabel2.setText("Data Final:");

        filtrar.setText("Filtrar");
        filtrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtrarActionPerformed(evt);
            }
        });

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, pedidoList, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Long.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${data}"));
        columnBinding.setColumnName("Data");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${funcionario}"));
        columnBinding.setColumnName("Funcionario");
        columnBinding.setColumnClass(modelo.Funcionario.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${cliente}"));
        columnBinding.setColumnName("Cliente");
        columnBinding.setColumnClass(modelo.Cliente.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${total}"));
        columnBinding.setColumnName("Total");
        columnBinding.setColumnClass(Double.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();

        jScrollPane1.setViewportView(jTable1);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Total do Período");

        total.setEditable(false);
        total.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        total.setForeground(new java.awt.Color(255, 0, 0));
        total.setBorder(null);
        total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(data, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(53, 53, 53)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(dataInicial, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                                    .addComponent(dataFinal))
                                .addGap(80, 80, 80)
                                .addComponent(filtrar)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(total))
                        .addGap(44, 44, 44))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(data)
                            .addComponent(dataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(dataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(filtrar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(205, 205, 205))))
        );

        bindingGroup.bind();

        pack();
    }

    private void totalActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
    }

    private void filtrarActionPerformed(java.awt.event.ActionEvent evt) {                                        
        String dataI = dataInicial.getText();
        String dataF = dataFinal.getText();
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        try {  
            
            Date result1 = formatter.parse(dataI);
            Date result2 = formatter.parse(dataF);
            
            pedidoQuery = ControleVendasEntityManager.createQuery("SELECT p FROM Pedido p WHERE p.data BETWEEN :data1 AND :data2");
            pedidoQuery.setParameter("data1",result1);
            pedidoQuery.setParameter("data2",result2);
            
            System.out.println("data2 " + dataF + "Formatado: " + result2.toString());
            
            
            pedidoList = pedidoQuery.getResultList();
            
            if (!pedidoList.isEmpty()) {
                
                Query queryTotal = ControleVendasEntityManager.createQuery("SELECT SUM(p.total) FROM Pedido p WHERE p.data BETWEEN :data1 AND :data2");
                queryTotal.setParameter("data1", result1);
                queryTotal.setParameter("data2", result2);

                if (result2.after(result1)) {
                    total.setText("R$ " + Double.parseDouble(queryTotal.getSingleResult().toString()));
                } else {
                    JOptionPane.showMessageDialog(null, "Erro!\nA data inicial informada é maior que a data final!");
                }
                
                org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, pedidoList, jTable1);
                org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
                columnBinding.setColumnName("Id");
                columnBinding.setColumnClass(Long.class);
                columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${data}"));
                columnBinding.setColumnName("Data");
                columnBinding.setColumnClass(java.util.Date.class);
                columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${funcionario}"));
                columnBinding.setColumnName("Funcionario");
                columnBinding.setColumnClass(modelo.Funcionario.class);
                columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${cliente}"));
                columnBinding.setColumnName("Cliente");
                columnBinding.setColumnClass(modelo.Cliente.class);
                columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${total}"));
                columnBinding.setColumnName("Total");
                columnBinding.setColumnClass(Double.class);
                bindingGroup.addBinding(jTableBinding);
                jTableBinding.bind();
            }
            else JOptionPane.showMessageDialog(null, "Não há pedidos no período informado!");
                       
        } catch (ParseException ex) {
            Logger.getLogger(frmConsEntreDatas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private MaskFormatter setMascara(String mascara){  
        MaskFormatter mask = null;  
        try{  
            mask = new MaskFormatter(mascara);                        
            }catch(java.text.ParseException ex){}  
        return mask;  
    }  

    private javax.persistence.EntityManager ControleVendasEntityManager;
    private javax.swing.JLabel data;
    private javax.swing.JFormattedTextField dataFinal;
    private javax.swing.JFormattedTextField dataInicial;
    private javax.swing.JButton filtrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private java.util.List<modelo.Pedido> pedidoList;
    private javax.persistence.Query pedidoQuery;
    private javax.swing.JTextField total;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
}
