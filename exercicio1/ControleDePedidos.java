import java.util.List;
import java.util.ArrayList;

public class ControleDePedidos implements InterfaceSistemaDeControle {

	List<Pedido> pedidos; 
	
	public ControleDePedidos(){
		pedidos = new ArrayList<Pedido>();
	}
	
	public int CalculaQuantidadeDePedidosDoCliente(String nomeCliente){
		int cont = 0;
		for( Pedido aux : pedidos){
			if (aux.getCliente().getNome().equals(nomeCliente)){
				cont++;
			}
		}
		return cont;
	
	}
	
	public void adicionaPedido(Pedido p){
		this.pedidos.add( p );
	}
	
	public List<Pedido> pesquisaPedidosIncluindoProdutos(String CodProduto){
		List<Pedido> lista = new ArrayList<Pedido>();
		for( Pedido aux : pedidos){
			List<ItemDePedido> itens = aux.getItens();
			for (ItemDePedido it : itens){
				if(it.getCodProduto().equals(CodProduto)){
					lista.add(aux);
				}
			}
		}
		
		return lista;
	}
				
	
	public void removePedido (long numPedido){
	
		for( Pedido aux : pedidos){
			if ((aux.getNumeroDoPedido())==(numPedido)){
				pedidos.remove(aux);
			}
		}
	}				
					
}