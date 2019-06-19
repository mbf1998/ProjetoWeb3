/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import dao.ManagerDao;
import entidades.ClienteUsuario;
import entidades.EnderecoCliente;
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
@ManagedBean(name = "clienteUsuarioController")
@SessionScoped
public class ClienteController implements Serializable {
    
    private ClienteUsuario clienteCadastro;
    private ClienteUsuario selCliente;
    private ClienteUsuario clienteLogado;
    private Long idCliente;
    
     public ClienteController(){
        this.clienteCadastro = new ClienteUsuario();
        this.clienteCadastro.setEndereco(new EnderecoCliente());
    }
    
    public String inserirCliente(){    
        //this.estabelecimentoCadastro.setDataHora(this.dataAux.getTime());
        ManagerDao.getCurrentInstance().insert(this.clienteCadastro);
        System.out.println(this.clienteCadastro);
        this.clienteCadastro = new ClienteUsuario();
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Você foi cadastrado com sucesso!"));
        
        return "indexPublico.xhtml";
    }
   
   

    public void alterarCliente(ClienteUsuario c){
        ManagerDao.getCurrentInstance().update(c);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O registro foi alterado com sucesso!"));
        
        
    }
    
    public List<ClienteController> lerTudo(){
        return ManagerDao.getCurrentInstance().read("select c from Cliente c", ClienteUsuario.class);
    }
    
    public void deletar(){
        ManagerDao.getCurrentInstance().delete(this.selCliente);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("registro deletado com sucesso!"));
        
    }

    public ClienteUsuario getClienteCadastro() {
        return clienteCadastro;
    }

    public void setClienteCadastro(ClienteUsuario clienteCadastro) {
        this.clienteCadastro = clienteCadastro;
    }

    public ClienteUsuario getSelCliente() {
        return selCliente;
    }

    public void setSelCliente(ClienteUsuario selCliente) {
        this.selCliente = selCliente;
    }
    
}
