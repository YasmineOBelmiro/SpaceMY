package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import factory.ConnectionFactory;
import model.Cliente;

public class ClienteDAO {
	public void save(Cliente cliente) {
		String sql = "insert into clientes values(?,?,?,?,?,?,?)";
				 
		Connection conn = null;
		PreparedStatement pstm = null;
	
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setInt(1, cliente.getId());
			pstm.setString(2, cliente.getNome());
			pstm.setString(3, cliente.getSenha());
			pstm.setString(4, cliente.getEmail());
			pstm.setString(5, cliente.getSexo());
			pstm.setString(6, cliente.getDataNascimento());
			pstm.setString(7, cliente.getTelefone());
			pstm.execute();
			if (pstm.getUpdateCount()>0)
					JOptionPane.showMessageDialog(null,"Cadstro do cliente salvo com sucesso!");
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
	public void deleteById(int id) {
		String sql = "delete from clientes where id = ?";
		 
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.execute();
			if (pstm.getUpdateCount()>0)
					JOptionPane.showMessageDialog(null,"Exlusão do cliente salva com sucesso!");
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
	public void update(Cliente cliente) {
		String sql = "update clientes set nome = ?, senha = ?, email = ?, sexo = ?, telefone = ? where id = ?";
		 
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getSenha());
			pstm.setString(3, cliente.getEmail());
			pstm.setString(4, cliente.getSexo());
			pstm.setString(5, cliente.getTelefone());
			pstm.setInt(6, cliente.getId());
			pstm.execute();
			if (pstm.getUpdateCount()>0) {
					JOptionPane.showMessageDialog(null,"Edição do cliente salva com sucesso!");
			}else {
					JOptionPane.showMessageDialog(null,"Não foi possível editar!!");
				}
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
	public List<Cliente> getCliente(){
		String sql = "select * from clientes";
		 
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			rset = pstm.executeQuery();
				while(rset.next()){
				Cliente cliente = new Cliente();
				cliente.setId(rset.getInt(1));
				cliente.setNome(rset.getString(2));
				cliente.setSenha(rset.getString(3));
				cliente.setEmail(rset.getString(4));
				cliente.setSexo(rset.getString(5));
				cliente.setDataNascimento(rset.getString(6));
				cliente.setTelefone(rset.getString(7));
				clientes.add(cliente);
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
			return clientes;
	}
	public List<Cliente> buscarById(int id){
		String sql = "select * from clientes where id = ?";
		 
		List<Cliente> clientes = new ArrayList<Cliente>();
		Cliente cliente = new Cliente();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();
				while(rset.next()){
				
				cliente.setId(rset.getInt(1));
				cliente.setNome(rset.getString(2));
				cliente.setSenha(rset.getString(3));
				cliente.setEmail(rset.getString(4));
				cliente.setSexo(rset.getString(5));
				cliente.setDataNascimento(rset.getString(6));
				cliente.setTelefone(rset.getString(7));
				clientes.add(cliente);
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
			return clientes;
	}
	public List<Cliente> ConfirmaçaoDeUsuario(String senha){
		String sql = "select * from clientes where senha = ?";
		 
		List<Cliente> clientes = new ArrayList<Cliente>();
		Cliente cliente = new Cliente();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, senha);
			rset = pstm.executeQuery();
				while(rset.next()){
				
				cliente.setId(rset.getInt(1));
				cliente.setNome(rset.getString(2));
				cliente.setSenha(rset.getString(3));
				cliente.setEmail(rset.getString(4));
				cliente.setSexo(rset.getString(5));
				cliente.setDataNascimento(rset.getString(6));
				cliente.setTelefone(rset.getString(7));
				clientes.add(cliente);
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
			return clientes;
	}
}
