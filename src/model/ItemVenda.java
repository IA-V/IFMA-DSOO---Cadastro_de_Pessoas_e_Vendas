package model;

public class ItemVenda {
	private int id;
	private int idVenda;
	private int idProduto;
	private int quantidade;
	
	public ItemVenda(int idVenda, int idProduto, int quant, int id) {
		this.idVenda = idVenda;
		this.idProduto = idProduto;
		this.quantidade = quant;
		this.id = id;
	}
	
	public ItemVenda() {
	}

	public int getIdVenda() {
		return idVenda;
	}
	
	public void setIdVenda(int id) {
		this.idVenda = id;
	}
	
	public int getIdProduto() {
		return idProduto;
	}
	
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
