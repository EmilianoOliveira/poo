public class ItemDePedido {

	private int quantidade;
	private String codProduto;
	private double valorUnitario;
	
	public ItemDePedido(){
		this(0 , " " , 0.0);
	}
	
	public ItemDePedido(int qtd, String cod, double valor) {
		this.quantidade = qtd;
		this.codProduto = cod;
		this.valorUnitario = valor;
	}

	
	public int getQuantidade(){
		return this.quantidade;
	}
	
	public void setQuantidade(int quan){
		this.quantidade = quan;
	}
	
	public String getCodProduto(){
		return this.codProduto;
	}
	
	public void setCodProduto( String cod){
		this.codProduto = cod;
	}
	public double getValorUnitario(){
		return this.valorUnitario;
	}
	
	public void setValorUnitario(double vu){
		this.valorUnitario = vu;
	}
}