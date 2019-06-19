/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import dao.ManagerDao;
import entidades.CorProduto;
import entidades.ImagemProduto;
import entidades.Produto;
import entidades.TamanhoProduto;
import entidades.TipoProduto;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author marcosbrasil98
 */
@ManagedBean(name = "produtoController")
@SessionScoped
public class ProdutoController implements Serializable{
    
    private Produto produtoPublico;
    private Produto produtoCadastro;
    private List<Produto> produto;
    private Long tam;
    private Long tip;
    private Long cor;
       
    private Produto selProd;

    public ProdutoController(Produto produtoPublico, Produto produtoCadastro, List<Produto> produto, List<TipoProduto> tp, List<CorProduto> cores, List<TamanhoProduto> tamanho, TipoProduto seltp, UploadedFile imagem, List<ImagemProduto> listaImagem, Produto selProd) {
        this.produtoPublico = produtoPublico;
        this.produtoCadastro = produtoCadastro;
        this.produto = produto;
       
        this.selProd = selProd;
    }
 
    
    public ProdutoController(){
        this.produtoCadastro = new Produto();
        this.produtoCadastro.setCorProduto(new CorProduto());
       // this.produtoCadastro.setTamanho(new ArrayList<TamanhoProduto>());
        this.produtoCadastro.setTipoProduto(new TipoProduto());
        this.produto = lerTudo();
       
        
    }

    public Produto getProdutoPublico() {
        return produtoPublico;
    }

    public void setProdutoPublico(Produto produtoPublico) {
        this.produtoPublico = produtoPublico;
    }

    public Produto getProdutoCadastro() {
        return produtoCadastro;
    }

   
    
    public Produto getSelProd() {
        return selProd;
    }

    public void setSelProd(Produto selProd) {
        this.selProd = selProd;
    }
    
    
    

    /*public List<SelectItem> ModificarTP(){
        List<SelectItem> lista = new ArrayList<SelectItem>();
        lista.add(new SelectItem("", ""));
        List<TipoProduto> teste = InstaniarTP();
        for(TipoProduto t : teste){
            lista.add(new SelectItem(t.getId(),t.getNome()));
        }
       return lista; 
    }    
    
   */
    public void setProdutoCadastro(Produto produtoCadastro) {
        this.produtoCadastro = produtoCadastro;
    }
    
    public List<Produto> lerTudo(){
        return ManagerDao.getCurrentInstance().read("select s from Produto s", Produto.class);
    }
   /* public List<CorProduto>lerCores(Long id){
         
        return ManagerDao.getCurrentInstance().read("select s from cor s where s.corproduto_fk=1", CorProduto.class);
    }*/
           
       public String inserir(){    
        //this.estabelecimentoCadastro.setDataHora(this.dataAux.getTime());
        try{
         this.produtoCadastro.setTamanhoProduto(tamanhoByid(this.tam));
          this.produtoCadastro.setCorProduto(CorByid(this.cor));
          this.produtoCadastro.setTipoProduto(tipobyId(this.tip));
          ManagerDao.getCurrentInstance().insert(this.produtoCadastro);
        this.produtoCadastro = new Produto();
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O produto cadastrado com sucesso!"));  
        FacesContext.getCurrentInstance().getExternalContext().redirect("indexAdm.xhtml");
        }
       catch(Exception e){
           System.out.println(e);
       }
        return "indexAdm.xhtml";
       }      
     public List<TamanhoProduto> lertudo(){
        return ManagerDao.getCurrentInstance().read("select t from Produto t", Produto.class);
    } 
     
        public void Update(){
        ManagerDao.getCurrentInstance().update(this.selProd);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O registro foi alterado com sucesso!"));
        
        
    }
        public TamanhoProduto tamanhoByid(Long tam){
         return (TamanhoProduto) ManagerDao.getCurrentInstance().read("select t from TamanhoProduto t where t.id='"+tam+"'",TamanhoProduto.class).get(0);
        }
         public CorProduto CorByid(Long cor){
         return (CorProduto) ManagerDao.getCurrentInstance().read("select t from CorProduto t where t.id='"+cor+"'",CorProduto.class).get(0);
        }
          public TipoProduto tipobyId(Long tip){
         return (TipoProduto) ManagerDao.getCurrentInstance().read("select t from TipoProduto t where t.id='"+tip+"'",TipoProduto.class).get(0);
        }
      public void delete(){
        ManagerDao.getCurrentInstance().delete(this.selProd);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("registro deletado com sucesso!"));
        
      }

    public List<Produto> getProduto() {
        return produto;
    }

    public void setProduto(List<Produto> produto) {
        this.produto = produto;
    }

    public Long getTam() {
        return tam;
    }

    public void setTam(Long tam) {
        this.tam = tam;
    }

    public Long getTip() {
        return tip;
    }

    public void setTip(Long tip) {
        this.tip = tip;
    }

    public Long getCor() {
        return cor;
    }

    public void setCor(Long cor) {
        this.cor = cor;
    }
        
    }

