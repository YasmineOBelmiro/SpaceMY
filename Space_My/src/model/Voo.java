package model;

public class Voo extends Nave{
	private int numVoo;
	private String origem_destino;
	private Double valor;
	public Voo(int numVoo, String origem_destino, Double valor, int qtdAssentos, int ano, String modelo, String operador, String fabricante, int matricula) {
		super(qtdAssentos, ano, modelo, operador, fabricante, matricula);
		this.numVoo = numVoo;
		this.origem_destino = origem_destino;
		
	}
	public int getNumVoo() {
		return numVoo;
	}
	public void setNumVoo(int numVoo) {
		this.numVoo = numVoo;
	}
		public String getOrigem_destino() {
		return origem_destino;
	}
	public void setOrigem_destino(String origem_destino) {
		this.origem_destino = origem_destino;
	}
		public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	@Override
	public String toString() {
		return getOrigem_destino() ;
	}
	
	
}
