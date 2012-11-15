package br.ufpb.sistemadepedidos;
import java.util.*;


public class ProgramaPrincipal {
	/*
	 * Professora este programa é feito para usuários bons, ou seja
	 * ele está sem tratamento de erros ! 
	 */
	
	private static Scanner entrada;

	public static void main(String[] args) {
		
		entrada = new Scanner(System.in);
		int compara = 1;
		System.out.println("Digite seu nome: ");
		String nome = entrada.next();
		Cliente c1 = new Cliente(nome);
		Pedido ped1 = new Pedido(1);
		ped1.setCliente(c1);
		ControleDePedidos controle = new ControleDePedidos();
		System.out.println("Para finalizar seu pedido digite 0 em todas as perguntas! ");
		while (compara != 0){
			System.out.println("O que você procura(Código do Produto)?");
			String cod = entrada.next();
			System.out.println("Qual a quantidade ? ");
			int quant = entrada.nextInt();
			System.out.println("Valor Unitário? ");
			double valor = entrada.nextDouble();
			ItemDePedido item1 = new ItemDePedido(cod,quant,valor);
			ped1.adicionaItem(item1);
			controle.adicionaPedido(ped1);
			if(cod.equals("0")){
				compara = 0;
			}
		}
		System.out.println("O total do seu pedido é: R$" + ped1.getValorTotal());
		
	}

}
