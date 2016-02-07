/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Magalhães Oliveira
 */
@Table(name="TB_PEDIDO")
@Entity
@NamedQueries({
@NamedQuery(name = "Pedido.PedidosPorCliente", query= " SELECT p FROM Pedido p WHERE p.cliente = :cliente"),
@NamedQuery(name = "Pedido.PedidosPorFuncionario", query= " SELECT p FROM Pedido p WHERE p.funcionario = :funcionario")})
public class Pedido implements Serializable{
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    
    public Pedido(){
        this.total = 0;
        this.itens = new ArrayList<>();
        this.data = new Date();
    }
       
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PEDIDO")
    private Long id;
    
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private final List<ItemPedido> itens;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID_CLIENTE")
    private Cliente cliente;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_FUNCIONARIO", referencedColumnName = "ID_FUNCIONARIO")
    private Funcionario funcionario;
   
    @Column(name = "PEDIDO_DATA")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data;

    @Column(name = "PEDIDO_TOTAL") 
    private double total;

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        Long oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        Funcionario oldFuncionario = this.funcionario;
        this.funcionario = funcionario;
        changeSupport.firePropertyChange("funcionario", oldFuncionario, funcionario);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        Cliente oldCliente = this.cliente;
        this.cliente = cliente;
        changeSupport.firePropertyChange("cliente", oldCliente, cliente);
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void addItem(ItemPedido item) {
        this.itens.add(item);
        this.total += item.getSubtotal();
    }

    public double getTotal() {
        return this.total;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        Date oldData = this.data;
        this.data = data;
        changeSupport.firePropertyChange("data", oldData, data);
    }
    
    @Override
    public String toString(){
        return "ID" + this.id + this.data.getTime();
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
}
