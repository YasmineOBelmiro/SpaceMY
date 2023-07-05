package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import factory.ConnectionFactory;
import model.*;

public class ReservaDao {
	public void save(Reserva reserva) {
		String sql = "insert into clienteVoo value(?,?,?,?,?)";
				 
		Connection conn = null;
		PreparedStatement pstm = null;
				 
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setInt(1, reserva.getIdReserva());
			pstm.setInt(2, reserva.getIdCliente());
			pstm.setInt(3, reserva.getNumVoo());
			pstm.setString(4, reserva.getData());
			pstm.setInt(5, reserva.getAssento());
			pstm.execute();
			if (pstm.getUpdateCount()>0)
					JOptionPane.showMessageDialog(null,"Cadastro da reserva salvo com sucesso! Adicione a forma de pagamento para finalizar sua compra!!");
			else
					JOptionPane.showMessageDialog(null,"Não foi possível cadastrar!!");
			}catch (Exception e) {
				 e.printStackTrace();
			}finally{
				 //Fecha as conexões
				 try{
					 if(pstm != null){
							pstm.close();
					 }
					 if(conn != null){
							conn.close();
					 }
					}catch(Exception e){
						e.printStackTrace();
					}
		}		 
	}
	public void removeByID(int id) {
		String sql = "delete from clientevoo where IdReserva = ?";
		 
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.execute();
			if (pstm.getUpdateCount()>0)
					JOptionPane.showMessageDialog(null,"Exlusão da reserva salva com sucesso!");
			else
					JOptionPane.showMessageDialog(null,"Não foi possível excluir!!");
			}catch (Exception e) {
				 e.printStackTrace();
			}finally{
				 try{
					 if(pstm != null){
							pstm.close();
					 }
					 if(conn != null){
							conn.close();
					 }
					}catch(Exception e){
						e.printStackTrace();
					}
		}		 
	}
	public List<Reserva> getReserva(){
		String sql = "select * from clienteVoo";
		 
		List<Reserva> reservas = new ArrayList<Reserva>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			rset = pstm.executeQuery();
				while(rset.next()){
				Reserva reserva = new Reserva();
				reserva.setIdReserva(rset.getInt(1));
				reserva.setIdCliente(rset.getInt(2));
				reserva.setNumVoo(rset.getInt(3));
				reserva.setData(rset.getString(4));
				reserva.setAssento(rset.getInt(5));
				reservas.add(reserva);
			}
				
		}catch (Exception e) {
			 e.printStackTrace();
		}finally {
			try{
				if(rset != null){
					rset.close();
				 }
				if(pstm != null){
					pstm.close();
				 }
				if(conn != null){
					conn.close();
				 }
				}catch(Exception e){
					e.printStackTrace();
				}	 
		}
			return reservas;
	}
	public List<Reserva> buscarByIdReserva(int id){
		String sql = "select * from clienteVoo where idReserva = ?";
		 
		List<Reserva> reservas = new ArrayList<Reserva>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();
				if(rset.next()){
				Reserva reserva = new Reserva();
				reserva.setIdReserva(rset.getInt(1));
				reserva.setIdCliente(rset.getInt(2));
				reserva.setNumVoo(rset.getInt(3));
				reserva.setData(rset.getString(4));
				reserva.setAssento(rset.getInt(5));
				reservas.add(reserva);
			}
				
		}catch (Exception e) {
			 e.printStackTrace();
		}finally {
			try{
				if(rset != null){
					rset.close();
				 }
				if(pstm != null){
					pstm.close();
				 }
				if(conn != null){
					conn.close();
				 }
				}catch(Exception e){
					e.printStackTrace();
				}	 
		}
			return reservas;
	}
	public List<Reserva> visualizarByIdCliente(int id){
		String sql = "select * from clienteVoo where idCliente = ?";
		Reserva reserva = new Reserva();
		List<Reserva> reservas = new ArrayList<Reserva>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();
				if(rset.next()){
				reserva.setIdReserva(rset.getInt(1));
				reserva.setIdCliente(rset.getInt(2));
				reserva.setNumVoo(rset.getInt(3));
				reserva.setData(rset.getString(4));
				reserva.setAssento(rset.getInt(5));
				reservas.add(reserva);
			}
				
		}catch (Exception e) {
			 e.printStackTrace();
		}finally {
			try{
				if(rset != null){
					rset.close();
				 }
				if(pstm != null){
					pstm.close();
				 }
				if(conn != null){
					conn.close();
				 }
				}catch(Exception e){
					e.printStackTrace();
				}	 
		}
			return reservas;
	}
	public List<Reserva> mostarAssentos(){
		String sql = "select assentos from clienteVoo";
		Reserva reserva = new Reserva();
		List<Reserva> reservas = new ArrayList<Reserva>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			rset = pstm.executeQuery();
				while(rset.next()){
				reserva.setAssento(rset.getInt(1));
				reservas.add(reserva);
			}
				
		}catch (Exception e) {
			 e.printStackTrace();
		}finally {
			try{
				if(rset != null){
					rset.close();
				 }
				if(pstm != null){
					pstm.close();
				 }
				if(conn != null){
					conn.close();
				 }
				}catch(Exception e){
					e.printStackTrace();
				}	 
		}
			return reservas;
	}
}
