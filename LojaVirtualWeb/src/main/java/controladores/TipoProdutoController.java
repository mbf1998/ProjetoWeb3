/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import dao.ManagerDao;
import entidades.TipoProduto;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author marcosbrasil98
 */
@ManagedBean(name = "tipoprodutocontroller")
@SessionScoped
public class TipoProdutoController implements Serializable {
     private TipoProduto tipocadastro;
    private TipoProduto seltp;
    public List<TipoProduto> tp ;

    public List<TipoProduto> getTp() {
        return tp;
    }

    public void setTp(List<TipoProduto> tp) {
        this.tp = lerTudoTipoProduto();
    }
    
  
    public TipoProdutoController(){
          this.tipocadastro = new TipoProduto();
          
    }
    public TipoProduto getTipocadastro() {
        return tipocadastro;
    }

    public void setTipocadastro(TipoProduto tipocadastro) {
        this.tipocadastro = tipocadastro;
    }

    public TipoProduto getSeltp() {
        return seltp;
    }

    public void setSeltp(TipoProduto seltp) {
        this.seltp = seltp;
    }
    
     public void inserirTipoProduto(){    
        //this.estabelecimentoCadastro.setDataHora(this.dataAux.getTime());
        try{
          ManagerDao.getCurrentInstance().insert(this.tipocadastro);
        this.tipocadastro = new TipoProduto();
        System.out.println(this.tipocadastro);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Tipo de produto cadastrado com sucesso!"));  
        FacesContext.getCurrentInstance().getExternalContext().redirect("indexAdm.xhtml");
        }
       catch(Exception e){
           System.out.println(e);
       }
      



       }      
     public List<TipoProduto> lerTudoTipoProduto(){
        return ManagerDao.getCurrentInstance().read("select t from TipoProduto t", TipoProduto.class);
    } 
     
public void AlterarTP(){
        ManagerDao.getCurrentInstance().update(this.seltp);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O registro foi alterado com sucesso!"));
        
        
    }
      public void deletarTP(){
        ManagerDao.getCurrentInstance().delete(this.seltp);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("registro deletado com sucesso!"));
        
    }
}
