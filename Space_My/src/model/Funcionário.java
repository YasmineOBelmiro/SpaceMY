package model;

public class Funcionário {
	private String nome, sexo, senha;
	private int id, telefone;
	
	public Funcionário(String nome, String sexo, String senha, int id, int telefone) {
		this.nome = nome;
		this.sexo = sexo;
		this.senha = senha;
		this.id = id;
		this.telefone = telefone;
	}
	public String getNome() {
		return nome;
	}
	public String getSexo() {
		return sexo;
	}
	public String getSenha() {
		return senha;
	}
	public int getId() {
		return id;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
}
