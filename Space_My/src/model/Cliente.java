package model;

public class Cliente {
	 private String nome, senha, email, sexo , telefone;
	 private int id;
	 private String dataNascimento;
	
	public String getNome() {
		return nome;
	}
	public String getSenha() {
		return senha;
	}
	public String getEmail() {
		return email;
	}
	public String getSexo() {
		return sexo;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public String getTelefone() {
		return telefone;
	}
	
	public int getId() {
		return id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	 

}
