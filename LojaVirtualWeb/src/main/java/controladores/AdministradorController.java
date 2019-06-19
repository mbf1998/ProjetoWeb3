/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import dao.ManagerDao;
import entidades.Administrador;
import entidades.CorProduto;
import entidades.ImagemProduto;
import entidades.Produto;
import entidades.TamanhoProduto;
import entidades.TipoProduto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author marcosbrasil98
 */
@ManagedBean(name = "administradorController")
@SessionScoped
public class AdministradorController implements Serializable {
    
  private Produto prodCadastro;
  private Produto selProd;
  private CorProduto corCadastro;
  private CorProduto selCor;
  private TamanhoProduto tamCadastro;
  private TamanhoProduto seltam;
  private TipoProduto tipoProdutoCadastro;
  private TipoProduto seltp=null;
 
  

    public AdministradorController() {
        this.prodCadastro = new Produto();
        this.corCadastro = new CorProduto();
        this.tamCadastro = new TamanhoProduto();
        this.tipoProdutoCadastro = new TipoProduto();
       
        
    }
    
     public void inserirProduto(){    
        //this.estabelecimentoCadastro.setDataHora(this.dataAux.getTime());
        ManagerDao.getCurrentInstance().insert(this.prodCadastro);
        this.prodCadastro = new Produto();
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Produto cadastrado com sucesso!"));
        
        
    }
     public void inserirCor(CorProduto cor){    
        //this.estabelecimentoCadastro.setDataHora(this.dataAux.getTime());
        
        ManagerDao.getCurrentInstance().insert(cor);
        this.corCadastro = new CorProduto();
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cor cadastrado com sucesso!"));
        
        
    }

     public void inserirTamanho(){    
        //this.estabelecimentoCadastro.setDataHora(this.dataAux.getTime());
        ManagerDao.getCurrentInstance().insert(this.tamCadastro);
        this.tamCadastro = new TamanhoProduto();
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Tamanho cadastrado com sucesso!"));
        
        
    }

     public void inserirTipoProduto(){    
        //this.estabelecimentoCadastro.setDataHora(this.dataAux.getTime());
        try{
          ManagerDao.getCurrentInstance().insert(this.tipoProdutoCadastro);
        this.tipoProdutoCadastro = new TipoProduto();
        System.out.println(this.tipoProdutoCadastro);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Tipo de produto cadastrado com sucesso!"));  
        }
       catch(Exception e){
           System.out.println(e);
       }
             
        
        
    }
     public void AlterarCor(){
         ManagerDao.getCurrentInstance().update(this.selCor);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O registro foi alterado com sucesso!"));
        
     }
     public void AlterarTP(){
        ManagerDao.getCurrentInstance().update(this.seltp);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O registro foi alterado com sucesso!"));
        
        
    }
      public void deletarTP(){
        ManagerDao.getCurrentInstance().delete(this.seltp);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("registro deletado com sucesso!"));
        
    }
      public void deletarCor(){
        ManagerDao.getCurrentInstance().delete(this.selCor);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("registro deletado com sucesso!"));
        
    }
        
    

       public List<Produto> lerTudoProduto(){
        return ManagerDao.getCurrentInstance().read("select P from Produto P", Produto.class);
    }
    
       public List<CorProduto> lerTudoCor(){
        return ManagerDao.getCurrentInstance().read("select tam from CorProduto tam", CorProduto.class);
    }
    public List<TamanhoProduto> lerTudoTamanhoProdutos(){
        return ManagerDao.getCurrentInstance().read("select tam from TamanhoProduto tam", TamanhoProduto.class);
    }
    public List<TipoProduto> lerTudoTipoProduto(){
        return ManagerDao.getCurrentInstance().read("select t from TipoProduto t", TipoProduto.class);
    }
    
    public Produto getProdCadastro() {
        return prodCadastro;
    }

    public void setProdCadastro(Produto prodCadastro) {
        this.prodCadastro = prodCadastro;
    }

    public Produto getSelProd() {
        return selProd;
    }

    public void setSelProd(Produto selProd) {
        this.selProd = selProd;
    }

    public CorProduto getCorCadastro() {
        return corCadastro;
    }

    public void setCorCadastro(CorProduto corCadastro) {
        this.corCadastro = corCadastro;
    }

    public CorProduto getSelCor() {
        return selCor;
    }

    public void setSelCor(CorProduto selCor) {
        this.selCor = selCor;
    }

    public TamanhoProduto getTamCadastro() {
        return tamCadastro;
    }

    public void setTamCadastro(TamanhoProduto tamCadastro) {
        this.tamCadastro = tamCadastro;
    }

    public TamanhoProduto getSeltam() {
        return seltam;
    }

    public void setSeltam(TamanhoProduto seltam) {
        this.seltam = seltam;
    }

    public TipoProduto getTipoProdutoCadastro() {
        return tipoProdutoCadastro;
    }

    public void setTipoProdutoCadastro(TipoProduto tipoProdutoCadastro) {
        this.tipoProdutoCadastro = tipoProdutoCadastro;
    }

    public TipoProduto getSeltp() {
        return seltp;
    }

    public void setSeltp(TipoProduto seltp) {
        this.seltp = seltp;
    }
    

}
