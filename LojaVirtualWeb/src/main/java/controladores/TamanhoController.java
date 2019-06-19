/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import dao.ManagerDao;
import entidades.Produto;
import entidades.TamanhoProduto;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author marcosbrasil98
 */
@ManagedBean(name = "tamanhoController")
@SessionScoped
public class TamanhoController implements Serializable{
    private TamanhoProduto tamanhoCadastro;
    private TamanhoProduto selTam;
    
    public TamanhoController(){
        this.tamanhoCadastro= new TamanhoProduto();
    }

    public TamanhoProduto getTamanhoCadastro() {
        return tamanhoCadastro;
    }

    public void setTamanhoCadastro(TamanhoProduto tamanhoCadastro) {
        this.tamanhoCadastro = tamanhoCadastro;
    }

    public TamanhoProduto getSelTam() {
        return selTam;
    }

    public void setSelTam(TamanhoProduto selTam) {
        this.selTam = selTam;
    }
    
    public String inserir(){    
        //this.estabelecimentoCadastro.setDataHora(this.dataAux.getTime());
        try{
          
          ManagerDao.getCurrentInstance().insert(this.tamanhoCadastro);
        this.tamanhoCadastro = new TamanhoProduto();
       
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Tamanho de produto cadastrado com sucesso!"));  
        FacesContext.getCurrentInstance().getExternalContext().redirect("indexAdm.xhtml");
        }
       catch(Exception e){
           System.out.println(e);
       }
        return "indexAdm.xhtml";
       }      
     public List<TamanhoProduto> lertudo(){
        return ManagerDao.getCurrentInstance().read("select t from TamanhoProduto t", TamanhoProduto.class);
    } 
     
        public void Update(){
        ManagerDao.getCurrentInstance().update(this.selTam);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O registro foi alterado com sucesso!"));
        
        
    }
      public void delete(){
        ManagerDao.getCurrentInstance().delete(this.selTam);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("registro deletado com sucesso!"));
        
    }
}
