package model;

public class Funcionario {
	
	private int id;
	private String nome;
	private String senha;
	private String cpf;
	private String dataNasc;
	
	public Funcionario(int id, String nome, String senha, String dt, String cpf){
		this.id = id;
		this.nome = nome;
		this.senha = senha;
		this.dataNasc = dt;
		this.cpf = cpf;
	}
	
	public Funcionario(){
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", senha=" + this.senha
				+ ", dataNasc=" + dataNasc + ", cpf= " + this.cpf + "]";
	}	
}