package br.ufpb.sistemadepedidos;
import java.util.List;
/*
 *  Interface de um programa que controlar� um sistema de pedidos de um restaurante.
 *  
 */
public interface InterfaceSistemaDeControle {
/*
 * Este m�todo adiciona um pedido na lista.
 * @param Recebe um Pedido p;
 */
	public void adicionaPedido(Pedido p);
/*
 * Este m�todo pesquisa no sistema um pedido.
 * @param Recebe uma codProduto que ser� pesquisado.
 * @return Lista com os pedidos encontrados de acordo com o codProduto
 */
	public List <Pedido> pesquisaPedidosIncluindoProduto(String codProduto);
/*
 * Este m�todo remove um pedido.
 * @param recebe um n�mero de pedido, o qual ser� pesquisado na lista e removido.
 * 
 */
	public void removePedido(long numeroPedido);
}
