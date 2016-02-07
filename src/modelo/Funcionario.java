package modelo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = " TB_FUNCIONARIO")
@PrimaryKeyJoinColumn(name = "ID_FUNCIONARIO")
@NamedQuery(name = "Funcionario.RetornaPorNome", query= " SELECT p FROM Funcionario p WHERE p.nome = :nome")
public class Funcionario extends Usuario {
    private static final long serialVersionUID = 1L;
    
    @Column(name = "nome")
    private String nome;
    
    public Funcionario(String nome, String tel){
        super(nome,tel);
        this.pedidos = new ArrayList<>();
        this.nome = nome;
        super.setTipo("F");
    }
    
    public Funcionario(){
        this.pedidos = new ArrayList<>();
    }
    
    @OneToMany(mappedBy = "funcionario", fetch = FetchType.LAZY)
    private List<Pedido> pedidos;
    
    public String getNome(){
        return super.getNome();
    }
    
    public boolean igual(Funcionario f){
        return (f.getNome().equals(this.getNome()));
    }
    
    @Override
    public String toString(){
        return this.nome;
    }
    
}
