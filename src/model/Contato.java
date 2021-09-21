package model;

public class Contato {
	private int id;
	private int idFuncionario;
	private int telefone;
	
	public Contato(int idFunc, int t, int id) {
		this.idFuncionario = idFunc;
		this.telefone = t;
		this.id = id;
	}

	public Contato() {
	}

	public int getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(int idFunc) {
		this.idFuncionario = idFunc;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
