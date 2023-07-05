package model;
/**
 * Classe que representa a aeronave que o cliente irá viajar
 * @author Yasmine.if
 *
 */

public class Nave {
	protected int qtdAssentos,ano;
	protected String modelo;
	protected String operador;
	protected String fabricante;
	protected int matricula;
	
	public Nave(int qtdAssentos, int ano, String modelo, String operador, String fabricante, int matricula) {
		super();

		this.qtdAssentos = qtdAssentos;
		this.ano = ano;
		this.modelo = modelo;
		this.operador = operador;
		this.fabricante = fabricante;
		this.matricula = matricula;
	}
	public int getQtdAssento() {
		return qtdAssentos;
	}
	public void setQtdAssento(int assento) {
		this.qtdAssentos = assento;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getOperador() {
		return operador;
	}
	public void setOperador(String operador) {
		this.operador = operador;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public String toString() {
		return Integer.toString(getMatricula());
	}
	
	
}
