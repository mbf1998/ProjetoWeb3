/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import dao.ManagerDao;
import entidades.Administrador;
import entidades.ClienteUsuario;
import entidades.Produto;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author marcosbrasil98
 */
@ManagedBean(name = "loginController")
@SessionScoped
public class LoginController {
       private Administrador admLogado;
    private ClienteUsuario clienteLogado;

       private String email,senha;
       private ProdutoController p;
       private List<Produto> produto;

  
  
          

    public LoginController(Administrador admLogado, ClienteUsuario clienteLogado, ClienteUsuario cliente, String email, String senha, ProdutoController produto) {
        this.admLogado = admLogado;
        this.clienteLogado = clienteLogado;
        
        this.email = email;
        this.senha = senha;
        
        this.produto= p.lerTudo();
    }
      public LoginController(){
          this.email= null;
          this.senha=null;
      }

    public ProdutoController getP() {
        return p;
    }

    public void setP(ProdutoController p) {
        this.p = p;
    }

    public List<Produto> getProduto() {
        return produto;
    }

    public void setProduto(List<Produto> produto) {
        this.produto = produto;
    }
      
      
       public String realizarLoginAdm( String login, 
             String senha) {
        try {
            Administrador c = (Administrador) ManagerDao.getCurrentInstance()
                    .read("select c from UsuarioGeral c where c.email='" + login + "'"
                            + " and c.senha='" + senha + "'", Administrador.class).get(0);
            this.admLogado = c;
            
            System.out.println(c.getNome());
            
            FacesContext.getCurrentInstance().addMessage("", 
                    new FacesMessage("Bem vindo "+c.getNome()));
            
            
            
        } catch (IndexOutOfBoundsException in) {
            FacesContext.getCurrentInstance().addMessage("",
                    new FacesMessage("Bem vindo "+admLogado.getNome()));
             return "indexAdm.xhtml";
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("",
                    new FacesMessage("Bem vindo "+admLogado.getNome()));
             return "indexAdm.xhtml";
        }
        
        return "indexAdm.xhtml";
    }
 
    public String realizarLoginCliente( String login, 
             String senha) {
        try {
            ClienteUsuario c = (ClienteUsuario) ManagerDao.getCurrentInstance()
                    .read("select c from UsuarioGeral c where c.email='" + login + "'"
                            + " and c.senha='" + senha + "'", ClienteUsuario.class).get(0);
            this.clienteLogado = c;
            
           
            System.out.println(c.getNome());
            
            FacesContext.getCurrentInstance().addMessage("", 
                    new FacesMessage("Bem vindo "+c.getNome()));
            
            
            
        } catch (IndexOutOfBoundsException in) {
            FacesContext.getCurrentInstance().addMessage("",
                    new FacesMessage("Bem vindo"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("",
                    new FacesMessage("eu não sei o que aconteceu"));
        }
        
        return "indexCliente.xhtml";
    }
 
    public Administrador getAdmLogado() {
        return admLogado;
    }

    public void setAdmLogado(Administrador admLogado) {
        this.admLogado = admLogado;
    }

    public ClienteUsuario getClienteLogado() {
        return clienteLogado;
    }

    public void setClienteLogado(ClienteUsuario clienteLogado) {
        this.clienteLogado = clienteLogado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
  
}
