/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Magalhães Oliveira
 */

@Entity
@Table(name = "TB_ITEMPEDIDO")
public class ItemPedido implements Serializable{ 
    private static final long serialVersionUID = 1L;
    
    public ItemPedido(Produto p, int q, Pedido ped){
        this.produto= p;
        this.quantidade = q;
        this.pedido = ped;
        this.subtotal = p.getPreco()*q;
    }
    
    public ItemPedido(){
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ITEMPEDIDO")
    private Long id;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PRODUTO", referencedColumnName = "ID_PRODUTO")
    private Produto produto;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PEDIDO", referencedColumnName = "ID_PEDIDO")
    private Pedido pedido;
    
    @Column(name = "ITEMPEDIDO_QUANTIDADE")
    private int quantidade;
    
    @Column(name = "ITEMPEDIDO_SUBTOTAL")
    private double subtotal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getSubtotal() {
        return this.subtotal;
    }
    
}
