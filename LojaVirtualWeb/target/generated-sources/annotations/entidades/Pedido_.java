package entidades;

import entidades.ClienteUsuario;
import entidades.Produto;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-19T08:46:41")
@StaticMetamodel(Pedido.class)
public class Pedido_ { 

    public static volatile SingularAttribute<Pedido, ClienteUsuario> Clienteusuario;
    public static volatile SingularAttribute<Pedido, Produto> produto;
    public static volatile SingularAttribute<Pedido, String> log;
    public static volatile SingularAttribute<Pedido, Long> id;
    public static volatile SingularAttribute<Pedido, Integer> quantidade;
    public static volatile SingularAttribute<Pedido, String> status;

}