package model;

public class Cliente {
	
	private int id;
	private String nome;
	private String nomeMae;
	private String dataNasc;
	private String cpf;
	
	public Cliente(int id, String nome, String nomeM, String dt, String c){
		this.id = id;
		this.nome = nome;
		this.nomeMae = nomeM;
		this.dataNasc = dt;
		this.cpf = c;
	}
	
	public Cliente(){
	}

	public int getId() {
		return id;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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
		return "Cliente [id=" + id + ", nome=" + nome + ", Nome da mãe=" + nomeMae
				+ ", dataNasc=" + dataNasc + "cpf=" + cpf + "]";
	}
	
	
}
