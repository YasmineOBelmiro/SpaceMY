package controller;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import dao.ClienteDAO;
import factory.ConnectionFactory;
import model.Cliente;
import view.MenuFuncionario;
import view.VisualizarCliente;
/**
 * Controle de visualização e manipulação de cliente
 * @author Yasmine.if
 *
 */
public class VisualizarClienteController {
	private  VisualizarCliente view;
	private Cliente cliente;
	private ClienteDAO dao;
	/**
	 * Construtor da classe que recebe:
	 * @param tela
	 * @param cliente
	 * @param dao
	 */
	public VisualizarClienteController(VisualizarCliente tela, Cliente cliente, ClienteDAO dao) {
		this.view = tela;
		this.cliente = cliente;
		this.dao = dao;
	}
	//Inicia a visualização do frame.
	public void initView(){
		view.setVisible(true);
		view.setLocationRelativeTo(null);
		view.setResizable(false);
		initController();
	}
	//Inicia a ação dos botões do frame.
	public void initController() {
		view.getBtnAlterar().addActionListener(e-> {
			try {
				Alterar();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		view.getBtnBuscar().addActionListener(e-> {
			try {
				Buscar();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		view.getBtnExcluir().addActionListener(e-> {
			try {
				Excluir();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});		
		view.getBtnVisualizar().addActionListener(e-> {
			try {
				VisualizarTodos();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		view.getBtnVoltar().addActionListener(e-> Voltar());
		view.getBtnSalvar().addActionListener(e->SalvarAlteração());
	}
	//Abre a tela de alteração
	private void Alterar() throws Exception {
		if(VerificaID() == true) {
			view.getPanelAlterar().setVisible(true);
			List<Cliente> clientes = dao.buscarById(Integer.parseInt(view.getTextField().getText()));
			for(Cliente c:clientes) {
				view.getTextNome().setText(c.getNome());
				view.getCbSexo().setSelectedItem(c.getSexo());
				view.getFtfTelefone().setText(c.getTelefone());
				view.getTextEmail().setText(c.getEmail());
				view.getPasswordField().setText(c.getSenha());
				view.getPasswordField_2().setText(c.getSenha());
			}
		}
	}
	//busca um usuario pelo id e adiciona o resultado na tabela
	private void Buscar() throws Exception {
		if(VerificaID() == true) {
					dao = new ClienteDAO();
					String [] colunas = {"Id","Nome","Sexo","Data de nascimento","Telefone","Email","Senha"};
					DefaultTableModel modelo = new DefaultTableModel(null,colunas);
					view.setTabela(new JTable(modelo));
					
					DefaultTableModel dados = (DefaultTableModel) view.getTabela().getModel();
					List<Cliente> clientes = null;
					view.getTabela().getColumnModel().getColumn(0).setPreferredWidth(1);
					view.getTabela().getColumnModel().getColumn(2).setPreferredWidth(1);
					view.getTabela().getColumnModel().getColumn(3).setPreferredWidth(1);
					view.getTabela().getColumnModel().getColumn(4).setPreferredWidth(1);
					view.getTabela().getColumnModel().getColumn(6).setPreferredWidth(1);
						
						try {
							cliente.setId(Integer.parseInt(view.getTextField().getText()));
							clientes = dao.buscarById(cliente.getId());
						} catch (Exception ex) {
							Logger.getLogger(VisualizarClienteController.class.getName()).log(Level.SEVERE, null, ex);
						
						}
					
						for(Cliente c:clientes) {
							String[] dado = new String[colunas.length];
							dado[0] = Integer.toString(c.getId());
							dado[1] = c.getNome();
							dado[2] = c.getSexo();
							dado[3] = c.getDataNascimento().toString();
							dado[4] = c.getTelefone();
							dado[5] = c.getEmail();
							dado[6] = c.getSenha();
							dados.addRow(dado);
						}
					view.getTabela().setVisible(true);
					view.getScrollPane().setVisible(true);
					view.getScrollPane().setViewportView(view.getTabela());
					view.getTextField().setText("");
		}
}
	//permirte excluir um usuario
	private void Excluir() throws Exception {
		if(VerificaID() == true) {
			cliente.setId(Integer.parseInt(view.getTextField().getText()));
			int n = JOptionPane.showConfirmDialog(null,"Você está deletando o usuário " + cliente.getId()+
					". Deseja continuar com esta ação?", null, JOptionPane.YES_NO_OPTION);
			if(n == JOptionPane.YES_OPTION) {
				try {
					dao.deleteById(cliente.getId());
				} catch (Exception ex) {
					Logger.getLogger(VisualizarClienteController.class.getName()).log(Level.SEVERE, null, ex);
				}
				VisualizarTodos();
				view.getTextField().setText("");
			}
		}
	}
	//Adiciona dados de todos os clientes na tabela
	private void VisualizarTodos() throws Exception  {
			dao = new ClienteDAO();
			String [] colunas = {"Id","Nome","Sexo","Data de nascimento","Telefone","Email","Senha"};
			DefaultTableModel modelo = new DefaultTableModel(null,colunas);
			view.setTabela(new JTable(modelo));
			
			DefaultTableModel dados = (DefaultTableModel) view.getTabela().getModel();
			List<Cliente> clientes = null;
			view.getTabela().getColumnModel().getColumn(0).setPreferredWidth(1);
			view.getTabela().getColumnModel().getColumn(2).setPreferredWidth(1);
			view.getTabela().getColumnModel().getColumn(3).setPreferredWidth(1);
			view.getTabela().getColumnModel().getColumn(4).setPreferredWidth(1);
			view.getTabela().getColumnModel().getColumn(6).setPreferredWidth(1);
				try {
					clientes = dao.getCliente();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.toString());
				}
			
			for(Cliente c:clientes) {
				String[] dado = new String[colunas.length];
				dado[0] = Integer.toString(c.getId());
				dado[1] = c.getNome();
				dado[2] = c.getSexo();
				dado[3] = c.getDataNascimento().toString();
				dado[4] = c.getTelefone();
				dado[5] = c.getEmail();
				dado[6] = c.getSenha();
				dados.addRow(dado);
			}
			view.getTabela().setVisible(true);
			view.getScrollPane().setVisible(true);
			view.getScrollPane().setViewportView(view.getTabela());
			view.getTextField().setText("");
	}
	//volta para o menu
	private void Voltar() {
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
	}
	//Permite a alteração de usuario 
	private void SalvarAlteração() {
		try {
			if(view.getTextNome().getText().equals("")) {
				JOptionPane.showMessageDialog(null, "O campo do nome não pode ser vazio!");
				view.getTextNome().requestFocus();
				return;
				}
				else if(view.getFtfTelefone().getText().equals("")) {
					JOptionPane.showMessageDialog(null, "O campo do número de telefone não pode ser vazio!");
					view.getFtfTelefone().requestFocus();
					return;
				}
				else if(view.getTextEmail().getText().equals("")) {
					JOptionPane.showMessageDialog(null, "O campo do email não pode ser vazio!");
					view.getTextEmail().requestFocus();
					return;
				}
				else if((view.getPasswordField().getPassword().equals("") && view.getPasswordField_2().getPassword().equals(""))){
					JOptionPane.showMessageDialog(null, "Os campos de senha não podem ser vazios!");
					view.getPasswordField().requestFocus();
					view.getPasswordField_2().requestFocus();
					return;
					
				}else if(!new String(view.getPasswordField().getPassword()).equals(new String(view.getPasswordField_2().getPassword()))) {
					JOptionPane.showMessageDialog(null, "As senhas devem ser iguais!");
					view.getPasswordField().requestFocus();
					view.getPasswordField_2().requestFocus();
					return;
				}else {
					if(VerificaID() == true) {
						cliente.setNome(view.getTextNome().getText().toUpperCase());
						cliente.setSenha(new String(view.getPasswordField_2().getPassword()));
						cliente.setEmail(view.getTextEmail().getText());
						cliente.setSexo((String)view.getCbSexo().getSelectedItem());
						cliente.setTelefone(view.getFtfTelefone().getText());
						cliente.setId(Integer.parseInt(view.getTextField().getText()));
						ClienteDAO dao = new ClienteDAO();
						dao.update(cliente);
						VisualizarTodos();
					}
					view.getPanelAlterar().setVisible(false);
					view.getTextField().setText("");
				}
		}catch (Exception e) {
			  Logger.getLogger(VisualizarClienteController.class.getName()).log(Level.SEVERE, null, e);
		}	
	}
	//Faz verificação da existencia do id do cliente.
	public boolean VerificaID() throws Exception {
		String sql = "select * from clientes where id = ?";
		PreparedStatement pstm = null;
		ResultSet rset = null;
		Connection conn = null;
		
		try {	
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setInt(1, Integer.parseInt(view.getTextField().getText()));
			rset = pstm.executeQuery();
				if(rset.next()) {
					return true;
				}else 
					JOptionPane.showMessageDialog(null, "Este usuario não existe!");
				return false;
			}catch (SQLException erro) {
				JOptionPane.showMessageDialog(null, erro.toString());
			}catch (NumberFormatException erro) {
				JOptionPane.showMessageDialog(null, "O campo está vazio!!");
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
