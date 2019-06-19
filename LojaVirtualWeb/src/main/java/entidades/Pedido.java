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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name="TB_PEDIDO")
@Access(AccessType.FIELD)
@NamedQueries(
        {
            @NamedQuery(
                    name = "Pedido.PorLog",
                    query = "SELECT p FROM Pedido p WHERE p.log LIKE :log ORDER BY p.id"),
          
                        }
)
public class Pedido implements Serializable{
    


@Id
@GeneratedValue(strategy =GenerationType.IDENTITY )
@Column(name = "PEDIDO_ID",nullable = false)
private Long id;


@Size(max=20)
@Column(name = "PEDIDO_LOG")
private String log;


@Column(name = "PEDIDO_QUANTIDADE")
private Integer quantidade; 


@Column(name = "PEDIDO_STATUS")
private String status; 

@Valid
@ManyToOne(fetch = FetchType.LAZY,optional = false)
@JoinColumn(name = "CLIENTE_FK",referencedColumnName = "USUARIO_ID",insertable = true, updatable = true)
  private ClienteUsuario Clienteusuario;

/*@Valid
@ManyToMany
    @JoinTable(name="TB_PEDIDO_PRODUTO", joinColumns=
    {@JoinColumn(name="PEDIDO_ID")}, inverseJoinColumns=
      {@JoinColumn(name="PRODUTO_ID")})
   private List<Produto> produto;*/

@Valid
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "PRODUTO_FK", referencedColumnName = "PRODUTO_ID", insertable = true, updatable = true)
    private Produto produto;

public boolean possui(String log){
       return log.contains(log);
   }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public ClienteUsuario getUsuario() {
        return Clienteusuario;
    }

    public void setUsuario(ClienteUsuario usuario) {
        this.Clienteusuario = usuario;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

   

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ClienteUsuario getClienteusuario() {
        return Clienteusuario;
    }

    public void setClienteusuario(ClienteUsuario Clienteusuario) {
        this.Clienteusuario = Clienteusuario;
    }

}
