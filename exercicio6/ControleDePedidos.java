package br.ufpb.sistemadepedidos;

import java.util.List;
import java.util.ArrayList;
import java.io.IOException;


public class ControleDePedidos implements InterfaceSistemaDeControle{
	private List<Pedido> pedidos;
	private GravadorDePedidos g1;


	public ControleDePedidos(){
		g1 = new GravadorDePedidos();
		carregarPedidos();
	}
	public void gravarPedidos(){
		try{
			g1.gravaPedido(pedidos);
		}
		catch(IOException e){
			System.err.println(e.getMessage());
		}
		
		
	}
	private void carregarPedidos(){
		try{
			pedidos = g1.lePedido();
		}
		catch(IOException e){
			System.err.println(e.getMessage());
			this.pedidos = new ArrayList<Pedido>();
		}
	}

	
	public int calculaQuantidadeDePedidosDoCliente(String nomeCliente){
		int quantidade = 0;
		for(Pedido p: this.pedidos){
			if(p.getCliente().getNome() == nomeCliente){
				quantidade++;
			}
		}
		return quantidade;
	}
	public void adicionaPedido(Pedido p){
		this.pedidos.add(p);
	}
	public List<Pedido> pesquisaPedidosIncuindoProduto(String codProduto){
		List<Pedido> aux = new ArrayList<Pedido>();
		for(Pedido p: this.pedidos){
			List<ItemDePedido> itens = p.getItens();
			for(ItemDePedido item:itens){
				if(item.getCodProduto().equals(codProduto)){
					aux.add(p);
					break;
				}
			}
		}
		return aux;
	}
	public void removePedido(long numPedido){
		for(Pedido p: this.pedidos){
			if(p.getNumeroDoPedido() == numPedido){
				this.pedidos.remove(p);
				break;
			}
		}
	}
}