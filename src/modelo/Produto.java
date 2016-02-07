/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Magalhães Oliveira
 */
@Entity
@Table(name = "tb_produto")
@NamedQuery(name = "Produto.RetornaPorNome", query= " SELECT p FROM Produto p WHERE p.nome = :nome")
public class Produto implements Serializable{
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    
    public Produto(){};
    
    public Produto(String n, double p, double pdc, int est){
        this.nome = n;
        this.preco = p;
        this.precoCompra = pdc;
        this.quantidade = est;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRODUTO")
    private Long id;
    
    @Column(name = "PRODUTO_NOME")
    private String nome;
    
    @Column(name = "PRODUTO_PRECO")
    private double preco;
    
    @Column(name = "PRODUTO_PRECO_DE_COMPRA")
    private double precoCompra; //Lucro unitário: preco - precoCompra
    
    @Column(name = "PRODUTO_QTD_ESTOQUE")
    private int quantidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        Long oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getNome() {
        return nome;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(double precoCompra) {
        double oldPrecoCompra = this.precoCompra;
        this.precoCompra = precoCompra;
        changeSupport.firePropertyChange("precoCompra", oldPrecoCompra, precoCompra);
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        double oldPreco = this.preco;
        this.preco = preco;
        changeSupport.firePropertyChange("preco", oldPreco, preco);
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        int oldQuantidade = this.quantidade;
        this.quantidade = quantidade;
        changeSupport.firePropertyChange("quantidade", oldQuantidade, quantidade);
    }
    
    public boolean igual(Produto p){
        if(p == null) return false;
        return (p.getNome().equals(this.nome));
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
    @Override
    public String toString(){
        return this.nome;
    }
    
}
