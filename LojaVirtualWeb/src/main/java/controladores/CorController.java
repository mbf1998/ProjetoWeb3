/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

/**
 *
 * @author marcosbrasil98
 */

import dao.ManagerDao;
import entidades.CorProduto;
import entidades.TipoProduto;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "corController")
@SessionScoped
public class CorController implements Serializable {
    
    private CorProduto corCadastro;
    private CorProduto selcor;
    
     
public CorController(){
    this.corCadastro = new CorProduto();
}

    public CorProduto getCorCadastro() {
        return corCadastro;
    }

    public void setCorCadastro(CorProduto corCadastro) {
        this.corCadastro = corCadastro;
    }

    public CorProduto getSelcor() {
        return selcor;
    }

    public void setSelcor(CorProduto selcor) {
        this.selcor = selcor;
    }
  public String inserir(){    
        //this.estabelecimentoCadastro.setDataHora(this.dataAux.getTime());
        try{
          ManagerDao.getCurrentInstance().insert(this.corCadastro);
        this.corCadastro = new CorProduto();
        System.out.println(this.corCadastro);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cor de produto cadastrado com sucesso!"));  
        FacesContext.getCurrentInstance().getExternalContext().redirect("indexAdm.xhtml");
        }
       catch(Exception e){
           System.out.println(e);
       }
        return "indexAdm.xhtml";
       }      
     public List<CorProduto> lertudo(){
        return ManagerDao.getCurrentInstance().read("select t from CorProduto t", CorProduto.class);
    } 
     
        public void Update(){
        ManagerDao.getCurrentInstance().update(this.selcor);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O registro foi alterado com sucesso!"));
        
        
    }
      public void delete(){
        ManagerDao.getCurrentInstance().delete(this.selcor);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("registro deletado com sucesso!"));
        
    }

}
