package entidades;

import entidades.CorProduto;
import entidades.ImagemProduto;
import entidades.TamanhoProduto;
import entidades.TipoProduto;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-19T08:46:41")
@StaticMetamodel(Produto.class)
public class Produto_ { 

    public static volatile SingularAttribute<Produto, Double> preco;
    public static volatile SingularAttribute<Produto, TamanhoProduto> tamanhoProduto;
    public static volatile SingularAttribute<Produto, String> nome;
    public static volatile SingularAttribute<Produto, Long> id;
    public static volatile SingularAttribute<Produto, CorProduto> corProduto;
    public static volatile SingularAttribute<Produto, TipoProduto> tipoProduto;
    public static volatile SingularAttribute<Produto, ImagemProduto> imagemProduto;
    public static volatile SingularAttribute<Produto, Integer> quantidade;
    public static volatile SingularAttribute<Produto, String> descricao;

}