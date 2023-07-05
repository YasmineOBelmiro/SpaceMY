package model;

public class Reserva {
	private int idReserva,idCliente,numVoo,assento;
	private String data;
	
	public int getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}
	
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	public int getNumVoo() {
		return numVoo;
	}
	public void setNumVoo(int numVoo) {
		this.numVoo = numVoo;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getAssento() {
		return assento;
	}
	public void setAssento(int assento) {
		this.assento = assento;
	}
	
}
