package modelo;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "TB_CLIENTE")
@PrimaryKeyJoinColumn(name = "ID_CLIENTE")
@NamedQuery(name = "Cliente.RetornaPorNome", query= " SELECT p FROM Usuario p WHERE p.Tipo = 'C' AND p.nome = :nome")
public class Cliente extends Usuario {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    
    @Column(name = "PLACA")
    private String placa;
    
    @Column(name = "ENDERECO")
    private String endereco;
    
    public Cliente(String nome, String tel, String placa, String endereco){
        super(nome,tel);
        this.endereco = endereco;
        this.placa = placa;
        this.pedidos = new ArrayList<>();
        super.setTipo("C");
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        String oldPlaca = this.placa;
        this.placa = placa;
        changeSupport.firePropertyChange("placa", oldPlaca, placa);
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        String oldEndereco = this.endereco;
        this.endereco = endereco;
        changeSupport.firePropertyChange("endereco", oldEndereco, endereco);
    }
    
    public Cliente(){
        this.pedidos = new ArrayList<>();
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
