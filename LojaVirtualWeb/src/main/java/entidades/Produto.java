/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.Valid;
/**
 *
 * @author marcosbrasil98
 */
@Entity
@Table(name = "TB_PRODUTO")
@Access(AccessType.FIELD)
@NamedQueries(
        {
            @NamedQuery(
                    name = "Produto.PorNome",
                    query = "SELECT p FROM Produto p WHERE p.nome LIKE :nome ORDER BY p.quantidade"
            )
        

        }
)
public class Produto implements Serializable {
 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUTO_ID")
    private Long id;
    
    @NotNull
    @Size(max = 30)
    @Column(name = "PRODUTO_NOME")
    private String nome;

    @Lob
    @Size(max = 300)
    @Column(name = "PRODUTO_DESCRICAO")
    private String descricao;

    @NotNull
    @Column(name = "PRODUTO_QUANTIDADE")
    private Integer quantidade;

    @NotNull
    @Column(name = "PRODUTO_PRECO")
    private double preco;

    @Valid
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "CORPRODUTO_FK", referencedColumnName = "CORPRODUTO_ID", insertable = true, updatable = true)
    private CorProduto corProduto;

    @Valid
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "PRODUTO_TIPOPRODUTOFK", referencedColumnName = "TIPOPRODUTO_ID", insertable = true, updatable = true)
    private TipoProduto tipoProduto;
    
    @Valid
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "IMAGEM_FK", referencedColumnName = "IMGPRODUTO_ID", insertable = true, updatable = true)
    private ImagemProduto imagemProduto;
    
    @Valid
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "TAMANHO_FK", referencedColumnName = "TAMANHOPRODUTO_ID", insertable = true, updatable = true)
    private TamanhoProduto tamanhoProduto;
  
    
   
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(TipoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public CorProduto getCorProduto() {
        return corProduto;
    }

    public void setCorProduto(CorProduto corProduto) {
        this.corProduto = corProduto;
    }

    public ImagemProduto getImagemProduto() {
        return imagemProduto;
    }

    public void setImagemProduto(ImagemProduto imagemProduto) {
        this.imagemProduto = imagemProduto;
    }

    public TamanhoProduto getTamanhoProduto() {
        return tamanhoProduto;
    }

    public void setTamanhoProduto(TamanhoProduto tamanhoProduto) {
        this.tamanhoProduto = tamanhoProduto;
    }
    
}

    
