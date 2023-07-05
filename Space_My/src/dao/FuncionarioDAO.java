package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import factory.ConnectionFactory;
import model.Funcionário;

public class FuncionarioDAO {
	public void save(Funcionário funcionário) {
		String sql = "insert to funcionario values(?,?,?,?,?)";
				 
		Connection conn = null;
		PreparedStatement pstm = null;
				 
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setInt(1, funcionário.getId());
			pstm.setString(2, funcionário.getNome());
			pstm.setString(3, funcionário.getSexo());
			pstm.setString(4, funcionário.getSenha());
			pstm.setInt(5, funcionário.getTelefone());
			pstm.execute();
			if (pstm.getUpdateCount()>0)
					JOptionPane.showMessageDialog(null,"Cadstro do funcionário salvo com sucesso!");
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
		String sql = "delete from funcionario where id = ?";
		 
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.execute();
			if (pstm.getUpdateCount()>0)
					JOptionPane.showMessageDialog(null,"Exlusão do funcionario salva com sucesso!");
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
	public void update(Funcionário funcionário) {
		String sql = "upadate funcionario set nome = ?, departamento = ?, empresa = ?, senha = ? where id = ?";
		 
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setInt(5, funcionário.getId());
			pstm.setString(1, funcionário.getNome());
			pstm.setString(2, funcionário.getSexo());
			pstm.setString(3, funcionário.getSenha());
			pstm.setInt(4, funcionário.getTelefone());
			pstm.execute();
			if (pstm.getUpdateCount()>0)
					JOptionPane.showMessageDialog(null,"Edição do ? salva com sucesso!");
			else
					JOptionPane.showMessageDialog(null,"Não foi possível editar!!");
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
	public List<Funcionário> getFuncionario(){
		String sql = "insert to funcionario values(?,?,?,?,?)";
		 
		List<Funcionário> funcionarios = new ArrayList<Funcionário>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			rset = pstm.executeQuery();
				while(rset.next()){
				Funcionário funcionário = new Funcionário(null, null, null, 0, 0);
				pstm.setInt(1, funcionário.getId());
				pstm.setString(2, funcionário.getNome());
				pstm.setString(3, funcionário.getSexo());
				pstm.setString(4, funcionário.getSenha());
				pstm.setInt(5, funcionário.getTelefone());
				funcionarios.add(funcionário);
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
			return funcionarios;
	}
}
