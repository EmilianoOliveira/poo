package br.ufpb.sistemadepedidos;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * Este � o main que implementa a interface InterfaceSistemaDeControle
 */
public class ControleDePedidos implements InterfaceSistemaDeControle {

	private List <Pedido> pedidos;
	
	public ControleDePedidos(){
		this.pedidos = new ArrayList<Pedido>();
	}
	
	/*
	 * Este m�todo calcula o n�mero de pedidos feito pelo mesmo cliente.
	 * @param Recebe o nome do cliente a ser pesquisado.
	 * @return o n�mero de pedidos
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
	 * Este m�todo adiciona um pedido p.
	 * @param recebe o pedido p.
	 * 
	 */

	public void adicionaPedido(Pedido p) {
		this.pedidos.add(p);

	}

	/*
	 * Este m�todo pesquisa por um pedido atrav�s do codProduto
	 * @param recebe um codProduto que ir� ser pesquisado.
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
	 * Este m�todo remove um Pedido do sistema.
	 * @param recebe numeroPedido o numero do pedido que ir� ser pesquisado e removido
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
