package br.ufpb.sistemadepedidos;
import java.util.List;
/*
 *  Interface de um programa que controlará um sistema de pedidos de um restaurante.
 *  
 */
public interface InterfaceSistemaDeControle {
/*
 * Este método adiciona um pedido na lista.
 * @param Recebe um Pedido p;
 */
	public void adicionaPedido(Pedido p);
/*
 * Este método pesquisa no sistema um pedido.
 * @param Recebe uma codProduto que será pesquisado.
 * @return Lista com os pedidos encontrados de acordo com o codProduto
 */
	public List <Pedido> pesquisaPedidosIncluindoProduto(String codProduto);
/*
 * Este método remove um pedido.
 * @param recebe um número de pedido, o qual será pesquisado na lista e removido.
 * 
 */
	public void removePedido(long numeroPedido);
}
