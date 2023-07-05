package controller;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import factory.ConnectionFactory;
import model.Cliente;
import view.CadastroCliente;
import view.Login;
import view.MenuCliente;
import view.MenuFuncionario;
/**
 * Controle do login.
 * @author Yasmine.if
 *
 */
public class LoginController {
	private Login view;
	/**
	 * Construtor da classe que recebe:
	 * @param tela
	 */
	public LoginController(Login tela) {
		this.view = tela;
	}
	//Inicia a visualização do frame.
	public void initView() {
		view.setVisible(true);
		view.setLocationRelativeTo(null);
		view.setResizable(false);
		initController();
	}
	//Inicia a ação dos botões do frame.
	public void initController() {
		view.getBtnLogin().addActionListener(e-> {
			try {
				Logar();
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e.toString());
			}
		});
		view.getBtnCadastrar().addActionListener(e-> {
			try {
				Cadastrar();
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e.toString());
			}
		});
	}
	//Faz login verificando a existencia do funcionario ou do cliente;
	private void Logar() throws Exception {
		if(verificaExistenciaFuncionario() == true) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						MenuFuncionarioController c = new MenuFuncionarioController(new MenuFuncionario());				
						c.initView();
						view.dispose();
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}else if(verificaExistenciaCliente() == true) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						MenuClienteController c = new MenuClienteController(new MenuCliente());
						c.initView();
						view.dispose();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			
		}else JOptionPane.showMessageDialog(null, "Este usuario não existe ou a senha esta incorreta!");
	}
	//Entra na janela de casdastro
	private void Cadastrar() throws Exception {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroClienteController c = new CadastroClienteController(new CadastroCliente(), new Cliente());
					c.initView();
					view.dispose();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//Verifica a existencia do funcionario consultando o mysql.
	public boolean verificaExistenciaFuncionario() throws Exception {
		String sql;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			sql = "select * from funcionario where id = ? and senha = ?";
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, view.getTextUsuario().getText().toUpperCase());
			pstm.setString(2, new String(view.getPasswordFieldLogin().getPassword()));
			rset = pstm.executeQuery();
			if(rset.next()) {
				if(view.getTextUsuario().getText().equals("191103")) JOptionPane.showMessageDialog(null, "Seja bem vinda, Yasmine Belmiro!");
				else JOptionPane.showMessageDialog(null, "Seja bem vindo, Marcos Luigi!");
				return true;
			}	
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, erro.toString());
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
					JOptionPane.showMessageDialog(null, e.toString());
			}
		}
		return false;
	}
	//Verifica a existencia do cliente consultando o mysql.
	public boolean verificaExistenciaCliente() throws Exception {
		String sql;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			sql = "select * from clientes where email = ? and senha = ?";
			pstm  = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, view.getTextUsuario().getText().toUpperCase());
			pstm.setString(2, new String(view.getPasswordFieldLogin().getPassword()));
			rset = pstm.executeQuery();
			if(rset.next()) {
				return true;		
			}
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, erro.toString());
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
					JOptionPane.showMessageDialog(null, e.toString());
			}
		}
		return false;
	}	
}
