package modelo;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "TB_CLIENTE")
@PrimaryKeyJoinColumn(name = "ID_CLIENTE")
@NamedQuery(name = "Cliente.RetornaPorNome", query= " SELECT p FROM Cliente p WHERE p.nome = :nome")
public class Cliente extends Usuario {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    
    @Column(name = "nome")
    private String nome;
    
    public Cliente(String nome, String tel){
        super(nome,tel);
        this.pedidos = new ArrayList<>();
        this.nome = nome;
        super.setTipo("C");
    }
    
    public Cliente(){
        this.pedidos = new ArrayList<>();
    }
    
    public String getNome(){
        return super.getNome();
    }
    
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<Pedido> pedidos;

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void addPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public boolean igual(Cliente c){
        return (c.getNome().equals(this.getNome()));
    }
    
    @Override
    public String toString(){
        return this.nome;
    }
    
}
