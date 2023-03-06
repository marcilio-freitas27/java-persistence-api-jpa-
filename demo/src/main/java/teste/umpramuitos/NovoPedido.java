package teste.umpramuitos;

import infra.DAO;
import modelo.basico.Produto;
import modelo.umpramuitos.ItemPedido;
import modelo.umpramuitos.Pedido;

public class NovoPedido {
    
    public static void main(String[] args) {
        
        DAO<Object> dao = new DAO<>();

        Pedido pedido = new Pedido();
        Produto produto = new Produto("Geladeira Inox Consul", 5375.77);
        ItemPedido item = new ItemPedido(pedido, produto, 5);
        dao.abrirTransacao()
            .incluirTransacao(produto)
            .incluirTransacao(pedido)
            .incluirTransacao(item)
            .fecharTransacao()
            .fechar();
    }
}
