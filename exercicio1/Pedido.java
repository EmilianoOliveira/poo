import java.util.List;
import java.util.ArrayList;

public class Pedido {

	private long numeroDoPedido;
	private Cliente cliente;
	private List<ItemDePedido> itens;
	

	public Pedido ( long numPed, Cliente cliente){
		this.itens = new ArrayList<ItemDePedido>();
		this.numeroDoPedido = numPed;
		this.cliente = cliente;
	}
	
	public List<ItemDePedido> getItens(){
		return this.itens;
		
		}
	public void adicionaItem(ItemDePedido item){
		this.itens.add(item);
	}
	public long getNumeroDoPedido(){
		return this.numeroDoPedido;
	}
	public void setNumeroDoPedido( long novoNumero){
		this.numeroDoPedido = novoNumero;
	}
	public Cliente getCliente(){
		return this.cliente;
	}
	public void setCliente( Cliente novoCliente){
		this.cliente = novoCliente;
	}
}