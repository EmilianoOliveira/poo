package br.ufpb.sistemadepedidos;

public class MainPedido {

		public static void main(String [] args){
			ControleDePedidos controle = new ControleDePedidos();
			
			Pedido p1 = new Pedido(1);
			p1.setCliente(new Cliente("João"));
			ItemDePedido item1 = new ItemDePedido("CocaCola",2,6.00);
			p1.adicionaItem(item1);
			
			Pedido p2 = new Pedido(2);
			p2.setCliente(new Cliente("João"));
			ItemDePedido item2 = new ItemDePedido("Almoço",1,4.00);
			p1.adicionaItem(item2);
			
			controle.adicionaPedido(p1);
			controle.adicionaPedido(p2);
			
			int qtd = controle.calculaQuantidadeDePedidosDoCliente("João");
			if(qtd == 2){
				System.out.println("Programa correto!");
			}
			else{
				System.out.println("Programa incorreto!");
			}
			controle.gravarPedidos();

		}
	} 
