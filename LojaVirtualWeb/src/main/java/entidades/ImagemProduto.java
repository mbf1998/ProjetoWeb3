/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 *
 * @author marcosbrasil98
 */
@Entity
@Table(name="TB_IMGPRODUTO")
@Access(AccessType.FIELD)


public class ImagemProduto  implements Serializable {
  

   
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "IMGPRODUTO_ID")
private Long id;


@Lob
@Basic(fetch = FetchType.LAZY,optional = true)
@Column(name="IMGPRODUTO_IMAGEM")
private byte[] imagem;

@NotNull
@Column(name = "IMGPRODUTO_OUTRACOR")
private String outracor;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

  
    public String getOutraCor() {
        return outracor;
    }

    public void setOutraCor(String outraCor) {
        this.outracor = outraCor;
    }
    
  }