/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import dao.ManagerDao;
import entidades.CorProduto;
import entidades.Produto;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author marcosbrasil98
 */
@ManagedBean(name = "produtoController")
@SessionScoped
public class ProdutoController implements Serializable{
    
    private Produto produtoPublico;
    private Produto produtoCadastro;
    
    public ProdutoController(){
        this.produtoCadastro = new Produto();
    }
    public List<Produto> lerTudo(){
        return ManagerDao.getCurrentInstance().read("select s from Produto s", Produto.class);
    }
   /* public List<CorProduto>lerCores(Long id){
         
        return ManagerDao.getCurrentInstance().read("select s from cor s where s.corproduto_fk=1", CorProduto.class);
    }*/
    
}
