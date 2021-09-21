package model;

public class Produto {
	private int id;
	private String nome;
	private int idCategoria;
	private double preco;
	private int quantidade;
	
	public Produto(int id, String nome, int cat, double preco, int quant){
		this.id = id;
		this.nome = nome;
		this.idCategoria = cat;
		this.preco = preco;
		this.quantidade = quant;
	}

	public Produto() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCategoria() {
		return this.idCategoria;
	}

	public void setCategoria(int categoria) {
		this.idCategoria = categoria;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
}
