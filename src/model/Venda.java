package model;

public class Venda {
	private int id;
	private String data;
	private int idFuncionario;
	
	public Venda(int id, String data, int idFuncionario) {
		this.id = id;
		this.data = data;
		this.idFuncionario = idFuncionario;
	}

	public Venda() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
}
