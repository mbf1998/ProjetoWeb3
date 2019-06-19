/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import dao.ManagerDao;
import entidades.Pedido;
import entidades.Produto;
import entidades.TamanhoProduto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author marcosbrasil98
 */
@ManagedBean(name = "pedidocontroller")
@SessionScoped
public class PedidoController implements Serializable{
    private Pedido pedidoCadastro;
    private Pedido selped;
    private List<Produto> produtos;
    
    
    public PedidoController(){
        this.pedidoCadastro = new Pedido();
        this.produtos = instanciar();
              
    }
           
       public void inserir(){    
        //this.estabelecimentoCadastro.setDataHora(this.dataAux.getTime());
        try{
          this.pedidoCadastro.setStatus("Em análise");
          this.pedidoCadastro.setLog("SEila");
          ManagerDao.getCurrentInstance().insert(this.pedidoCadastro);
        this.pedidoCadastro = new Pedido();
       
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O pedido cadastrado com sucesso!"));  
        FacesContext.getCurrentInstance().getExternalContext().redirect("indexCliente.xhtml");
        }
       catch(Exception e){
           System.out.println(e);
       }
        
       }      
     public List<Pedido> lertudo(){
        return ManagerDao.getCurrentInstance().read("select t from Pedido t", Pedido.class);
    } 
          public List<Produto> instanciar(){
        return ManagerDao.getCurrentInstance().read("select t from Produto t", Produto.class);
    } 
        public void update(){
        ManagerDao.getCurrentInstance().update(this.selped);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O registro foi alterado com sucesso!"));
        
        
    }
      public void delete(){
        ManagerDao.getCurrentInstance().delete(this.selped);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("registro deletado com sucesso!"));
        
      }

    public Pedido getPedidoCadastro() {
        return pedidoCadastro;
    }
    public void atualizarStatus(){
        this.selped.setStatus("Executado");
        ManagerDao.getCurrentInstance().update(this.selped);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O registro foi alterado com sucesso!"));
    }
public void atualizarStatusEnviado(){
        this.selped.setStatus("Enviado");
        ManagerDao.getCurrentInstance().update(this.selped);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O registro foi alterado com sucesso!"));
    }
    public void setPedidoCadastro(Pedido pedidoCadastro) {
        this.pedidoCadastro = pedidoCadastro;
    }

    public Pedido getSelped() {
        return selped;
    }

    public void setSelped(Pedido selped) {
        this.selped = selped;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
      
}
