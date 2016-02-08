package modelo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = " TB_FUNCIONARIO")
@PrimaryKeyJoinColumn(name = "ID_FUNCIONARIO")
@NamedQuery(name = "Funcionario.RetornaPorNome", query= " SELECT p FROM Usuario p WHERE p.Tipo = 'F' AND p.nome = :nome")
public class Funcionario extends Usuario {
    private static final long serialVersionUID = 1L;
    
    public Funcionario(String nome, String tel){
        super(nome,tel);
        this.pedidos = new ArrayList<>();
        super.setTipo("F");
    }
    
    public Funcionario(){
        this.pedidos = new ArrayList<>();
    }
    
    @OneToMany(mappedBy = "funcionario", fetch = FetchType.LAZY)
    private List<Pedido> pedidos;
    
    public boolean igual(Funcionario f){
        return (f.getNome().equals(this.getNome()));
    }
    
    @Override
    public String toString(){
        return this.nome;
    }
    
}
