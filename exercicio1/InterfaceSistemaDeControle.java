import java.util.List;

interface InterfaceSistemaDeControle {

	public void adicionaPedido(Pedido p);
	
	public List<Pedido> pesquisaPedidosIncluindoProdutos(String CodProduto);
	
	public void removePedido (long numPedido);
	
}
