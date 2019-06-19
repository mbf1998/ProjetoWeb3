package entidades;

import entidades.EnderecoCliente;
import entidades.Pedido;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-19T07:26:38")
@StaticMetamodel(ClienteUsuario.class)
public class ClienteUsuario_ extends UsuarioGeral_ {

    public static volatile ListAttribute<ClienteUsuario, Pedido> pedidoUsuario;
    public static volatile SingularAttribute<ClienteUsuario, EnderecoCliente> endereco;
    public static volatile SingularAttribute<ClienteUsuario, String> fixo;
    public static volatile SingularAttribute<ClienteUsuario, String> celular;
    public static volatile SingularAttribute<ClienteUsuario, String> dataNascimento;

}