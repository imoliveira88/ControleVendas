/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Magalhães Oliveira
 */
@Entity
@Table(name = "TB_PRODUTO", catalog = "PUBLIC", schema = "PUBLIC")
@NamedQueries({
    @NamedQuery(name = "TbProduto.findAll", query = "SELECT t FROM TbProduto t"),
    @NamedQuery(name = "TbProduto.findByIdProduto", query = "SELECT t FROM TbProduto t WHERE t.idProduto = :idProduto"),
    @NamedQuery(name = "TbProduto.findByProdutoNome", query = "SELECT t FROM TbProduto t WHERE t.produtoNome = :produtoNome"),
    @NamedQuery(name = "TbProduto.findByProdutoPreco", query = "SELECT t FROM TbProduto t WHERE t.produtoPreco = :produtoPreco"),
    @NamedQuery(name = "TbProduto.findByProdutoPrecoDeCompra", query = "SELECT t FROM TbProduto t WHERE t.produtoPrecoDeCompra = :produtoPrecoDeCompra"),
    @NamedQuery(name = "TbProduto.findByProdutoQtdEstoque", query = "SELECT t FROM TbProduto t WHERE t.produtoQtdEstoque = :produtoQtdEstoque")})
public class TbProduto implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PRODUTO")
    private Long idProduto;
    @Column(name = "PRODUTO_NOME")
    private String produtoNome;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRODUTO_PRECO")
    private Double produtoPreco;
    @Column(name = "PRODUTO_PRECO_DE_COMPRA")
    private Double produtoPrecoDeCompra;
    @Column(name = "PRODUTO_QTD_ESTOQUE")
    private Integer produtoQtdEstoque;

    public TbProduto() {
    }

    public TbProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        Long oldIdProduto = this.idProduto;
        this.idProduto = idProduto;
        changeSupport.firePropertyChange("idProduto", oldIdProduto, idProduto);
    }

    public String getProdutoNome() {
        return produtoNome;
    }

    public void setProdutoNome(String produtoNome) {
        String oldProdutoNome = this.produtoNome;
        this.produtoNome = produtoNome;
        changeSupport.firePropertyChange("produtoNome", oldProdutoNome, produtoNome);
    }

    public Double getProdutoPreco() {
        return produtoPreco;
    }

    public void setProdutoPreco(Double produtoPreco) {
        Double oldProdutoPreco = this.produtoPreco;
        this.produtoPreco = produtoPreco;
        changeSupport.firePropertyChange("produtoPreco", oldProdutoPreco, produtoPreco);
    }

    public Double getProdutoPrecoDeCompra() {
        return produtoPrecoDeCompra;
    }

    public void setProdutoPrecoDeCompra(Double produtoPrecoDeCompra) {
        Double oldProdutoPrecoDeCompra = this.produtoPrecoDeCompra;
        this.produtoPrecoDeCompra = produtoPrecoDeCompra;
        changeSupport.firePropertyChange("produtoPrecoDeCompra", oldProdutoPrecoDeCompra, produtoPrecoDeCompra);
    }

    public Integer getProdutoQtdEstoque() {
        return produtoQtdEstoque;
    }

    public void setProdutoQtdEstoque(Integer produtoQtdEstoque) {
        Integer oldProdutoQtdEstoque = this.produtoQtdEstoque;
        this.produtoQtdEstoque = produtoQtdEstoque;
        changeSupport.firePropertyChange("produtoQtdEstoque", oldProdutoQtdEstoque, produtoQtdEstoque);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduto != null ? idProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbProduto)) {
            return false;
        }
        TbProduto other = (TbProduto) object;
        if ((this.idProduto == null && other.idProduto != null) || (this.idProduto != null && !this.idProduto.equals(other.idProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.produtoNome;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
