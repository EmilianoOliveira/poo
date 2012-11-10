public class TestePedido {


	public static void main ( String [] args){
	
	Cliente cli1 = new Cliente("Emiliano");
	ItemDePedido item1 = new ItemDePedido( 2, "Coca" , 4.0);
	ItemDePedido item2 = new ItemDePedido( 1, "Folheado" , 2.0);
	Pedido ped1 = new Pedido( 1 , cli1);
	Pedido ped2 = new Pedido(2, cli1);
	ped1.adicionaItem(item1);
	ped2.adicionaItem(item2);
	
	ControleDePedidos controle = new ControleDePedidos();
	controle.adicionaPedido(ped1);
	controle.adicionaPedido(ped2);
	if (controle.CalculaQuantidadeDePedidosDoCliente("Emiliano") == 2){
		System.out.println("Programa correto");
	}
	else {
		System.out.println("Programa incorreto");
	}
	
	}
}
	