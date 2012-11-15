package br.ufpb.sistemadepedidos;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * Este é o main que implementa a interface InterfaceSistemaDeControle
 */
public class ControleDePedidos implements InterfaceSistemaDeControle {

	private List <Pedido> pedidos;
	
	public ControleDePedidos(){
		this.pedidos = new ArrayList<Pedido>();
	}
	
	/*
	 * Este método calcula o número de pedidos feito pelo mesmo cliente.
	 * @param Recebe o nome do cliente a ser pesquisado.
	 * @return o número de pedidos
	 */
	
	public int calculaQuantidadeDePedidosDoCliente(String nomeCliente){
		
		int cont = 0;
		for (Pedido p: this.pedidos){
			if (p.getCliente().getNome().equals(nomeCliente)){
				cont++;
			}
		}
		return cont;
	}
	
	/*
	 * Este método adiciona um pedido p.
	 * @param recebe o pedido p.
	 * 
	 */

	public void adicionaPedido(Pedido p) {
		this.pedidos.add(p);

	}

	/*
	 * Este método pesquisa por um pedido através do codProduto
	 * @param recebe um codProduto que irá ser pesquisado.
	 * @return uma lista com os pedidos encontrados; 
	 */
	public List<Pedido> pesquisaPedidosIncluindoProduto(String codProduto) {
		List <Pedido> pedidosProcurados = new LinkedList<Pedido>();
		for (Pedido p: this.pedidos){
			List<ItemDePedido> itens = p.getItens();
			for (ItemDePedido it: itens){
				if (it.getCodProduto().equals(codProduto)){
					pedidosProcurados.add(p);
				}
			}
		}
		return pedidosProcurados;
	}

	/*
	 * Este método remove um Pedido do sistema.
	 * @param recebe numeroPedido o numero do pedido que irá ser pesquisado e removido
	 * 
	 */
	public void removePedido(long numeroPedido) {
		for (Pedido p: this.pedidos){
			if (p.getNumeroPedido()== numeroPedido){
				this.pedidos.remove(p);
				break;
			}
		}

	}
	
}
