package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import factory.ConnectionFactory;
import model.Nave;
import model.Voo;

public class NaveDAO {
	public void save(Nave nave) {
		String sql = "insert into nave values(?,?,?,?,?,?)";
				 
		Connection conn = null;
		PreparedStatement pstm = null;
				 
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setInt(1, nave.getMatricula());
			pstm.setString(2, nave.getModelo());
			pstm.setString(3, nave.getOperador());
			pstm.setString(4, nave.getFabricante());
			pstm.setInt(5, nave.getAno());
			pstm.setInt(6, nave.getQtdAssento());
			pstm.execute();
			if (pstm.getUpdateCount()>0)
					JOptionPane.showMessageDialog(null,"Cadastro da nave salvo com sucesso!");
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
	public void deleteByMatricula(int matricula) {
		String sql = "delete from nave where matricula = ?";
		 
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setInt(1, matricula);
			pstm.execute();
			if (pstm.getUpdateCount()>0)
					JOptionPane.showMessageDialog(null,"Exlusão da nave salva com sucesso!");
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
	public List<Nave> getNave(){
		String sql = "select * from nave";
		 
		List<Nave> aeronaves = new ArrayList<Nave>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			rset = pstm.executeQuery();
				while(rset.next()){
				Nave aeronave = new Nave(0, 0, null, null, null, 0);
				aeronave.setMatricula(rset.getInt(1));
				aeronave.setModelo(rset.getString(2));
				aeronave.setOperador(rset.getString(3));
				aeronave.setFabricante(rset.getString(4));
				aeronave.setAno(rset.getInt(5)); 
				aeronave.setQtdAssento(rset.getInt(6));
				aeronaves.add(aeronave);
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
			return aeronaves;
	}
	public List<Nave> buscarByMatricula(int matricula){
		String sql = "select * from nave where matricula = ?";
		 
		List<Nave> aeronaves = new ArrayList<Nave>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setInt(1, matricula);
			rset = pstm.executeQuery();
				if(rset.next()){
				Nave aeronave = new Nave(0, 0, null, null, null, 0);
				aeronave.setMatricula(rset.getInt(1));
				aeronave.setModelo(rset.getString(2));
				aeronave.setOperador(rset.getString(3));
				aeronave.setFabricante(rset.getString(4));
				aeronave.setAno(rset.getInt(5)); 
				aeronave.setQtdAssento(rset.getInt(6)); 
				aeronaves.add(aeronave);
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
			return aeronaves;
	}
	public List<Nave> mostrarMatricula(){
		String sql = "select matricula from nave";
		
		List<Nave> naves = new ArrayList<Nave>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			rset = pstm.executeQuery();
				while(rset.next()){
				Nave nave = new Nave(0, 0, null, null, null, 0);
				nave.setMatricula(rset.getInt(1));
				naves.add(nave);
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
			return naves;
		
	}
}
