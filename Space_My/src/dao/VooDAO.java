package dao;

import java.sql.*;
import java.util.*;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import factory.ConnectionFactory;
import model.*;

public class VooDAO {
	public void save(Voo voo) {
		String sql = "insert into voo value(?,?,?,?,?)";
				 
		Connection conn = null;
		PreparedStatement pstm = null;
				 
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setInt(1, voo.getNumVoo());
			pstm.setString(2, voo.getOrigem_destino());
			pstm.setDouble(3, voo.getValor());
			pstm.setInt(4, voo.getMatricula());
			pstm.setInt(5, voo.getQtdAssento());
			pstm.execute();
			if (pstm.getUpdateCount()>0)
					JOptionPane.showMessageDialog(null,"Cadstro do voo salvo com sucesso!");
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
	public void deleteByNumVoo( int numVoo) {
		String sql = "delete from voo where numVoo = ?";
		 
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setInt(1, numVoo);
			pstm.execute();
			if (pstm.getUpdateCount()>0)
					JOptionPane.showMessageDialog(null,"Exlusão do voo salva com sucesso!");
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
	public void update(Voo voo) {
		String sql = "upadate voo set numVoo = ?, origem_Destino = ?, valor = ?, matriculaNave = ?,assentos = ? where numVoo = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
				 
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setInt(1, voo.getNumVoo());
			pstm.setString(2, voo.getOrigem_destino());
			pstm.setDouble(3, voo.getValor());
			pstm.setInt(4, voo.getMatricula());
			pstm.setInt(5, voo.getQtdAssento());
			pstm.setInt(6, voo.getNumVoo());
			pstm.execute();
			if (pstm.getUpdateCount()>0)
					JOptionPane.showMessageDialog(null,"Cadstro do voo salvo com sucesso!");
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
	public List<Voo> getVoo(){
		String sql = "select * from voo";
		 
		List<Voo> voos = new ArrayList<Voo>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			rset = pstm.executeQuery();
				while(rset.next()){
				Voo voo = new Voo(0, null, null, 0, 0, null, null, null, 0);
				voo.setNumVoo(rset.getInt(1));
				voo.setOrigem_destino(rset.getString(2));
				voo.setValor(rset.getDouble(3));
				voo.setMatricula(rset.getInt(4));
				voo.setQtdAssento(rset.getInt(5));
				voos.add(voo);
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
			return voos;
	}

	public List<Voo> buscarByNumVoo(int numVoo){
		String sql = "select * from voo where numvoo = ?";
		 
		List<Voo> voos = new ArrayList<Voo>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setInt(1, numVoo);
			rset = pstm.executeQuery();
				while(rset.next()){
				Voo voo = new Voo(0, null, null, 0, 0, null, null, null, 0);
				voo.setNumVoo(rset.getInt(1));
				voo.setOrigem_destino(rset.getString(2));
				voo.setValor(rset.getDouble(3));
				voo.setMatricula(rset.getInt(4));
				voo.setQtdAssento(rset.getInt(5));
				voos.add(voo);
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
			return voos;
	}
	public List<Voo> mostrarVoos(){
		String sql = "select origem_Destino from voo";
		 
		List<Voo> voos = new ArrayList<Voo>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			rset = pstm.executeQuery();
				while(rset.next()){
				Voo voo = new Voo(0, null, null, 0, 0, null, null, null, 0);
				voo.setOrigem_destino(rset.getString(1));
				voos.add(voo);
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
			return voos;
	}
	public List<Voo> ConfirmacaoByOrigem_Destino(String origem_Destino) {
		String sql = "select * from voo where origem_Destino = ?";
		 
		List<Voo> voos = new ArrayList<Voo>();
		Voo voo = new Voo(0,null,null,0, 0,null,null,null,0);
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, origem_Destino);
			rset = pstm.executeQuery();
				while(rset.next()){
					voo.setNumVoo(rset.getInt(1));
					voo.setOrigem_destino(rset.getString(2));
					voo.setValor(rset.getDouble(3));
					voo.setMatricula(rset.getInt(4));
					voo.setQtdAssento(rset.getInt(5));
					voos.add(voo);
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
			return voos;
	}
}
