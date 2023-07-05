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

import model.*;
import view.*;
import dao.*;
import factory.ConnectionFactory;
/**
 * Controle de visualização e manipulação de naves
 * @author Yasmine.if
 *
 */
public class VisualizarNaveController {
	private VisualizarNaves view;
	private Nave nave;
	private NaveDAO dao;
	/**
	 * Construtor da classe que recebe:
	 * @param view
	 * @param nave
	 * @param dao
	 */
	public VisualizarNaveController(VisualizarNaves view, Nave nave, NaveDAO dao) {
		this.view = view;
		this.nave = nave;
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
		view.getBtnBuscar().addActionListener(e-> Buscar());
		view.getBtnExcluir().addActionListener(e-> Excluir());		
		view.getBtnVisualizar().addActionListener(e-> VisualizarTodos());
		view.getBtnVoltar().addActionListener(e-> Voltar());
	}
	//busca uma nave pela matricula e adiciona o resultado na tabela
	private void Buscar() {
		if(view.getTextField().getText().equals("")) {
			JOptionPane.showMessageDialog(null, "O campo está vazio");
			view.getTextField().requestFocus();
			return;
		}
		dao = new NaveDAO();
		String [] colunas = {"Matrícula","Operador","Fabricante","Ano","Modelo","Qt de assentos"};
		DefaultTableModel modelo = new DefaultTableModel(null,colunas);
		view.setTabela(new JTable(modelo));
		
		DefaultTableModel dados = (DefaultTableModel) view.getTabela().getModel();
		List<Nave> naves = null;
		view.getTabela().getColumnModel().getColumn(0).setPreferredWidth(1);
		view.getTabela().getColumnModel().getColumn(1).setPreferredWidth(1);
		view.getTabela().getColumnModel().getColumn(2).setPreferredWidth(1);
		view.getTabela().getColumnModel().getColumn(3).setPreferredWidth(1);
		view.getTabela().getColumnModel().getColumn(4).setPreferredWidth(1);
		view.getTabela().getColumnModel().getColumn(5).setPreferredWidth(1);
			try {
				nave.setMatricula(Integer.parseInt(view.getTextField().getText()));
				naves = dao.buscarByMatricula(nave.getMatricula());
			} catch (Exception ex) {
				Logger.getLogger(VisualizarNaveController.class.getName()).log(Level.SEVERE, null, ex);
			}
		
		for(Nave n:naves) {
			String[] dado = new String[colunas.length];
			dado[0] = Integer.toString(n.getMatricula());
			dado[1] = n.getModelo();
			dado[2] = n.getOperador();
			dado[3] = n.getFabricante();
			dado[4] = Integer.toString(n.getAno()); 
			dado[5] = Integer.toString(n.getQtdAssento());
			dados.addRow(dado);
		}
		view.getTabela().setVisible(true);
		view.getScrollPane().setVisible(true);
		view.getScrollPane().setViewportView(view.getTabela());
		view.getTextField().setText("");
	}
	//faz exclusao da nave
	private void Excluir() {
		if(view.getTextField().getText().equals("")) {
			JOptionPane.showMessageDialog(null, "O campo está vazio");
			view.getTextField().requestFocus();
			return;
		}
		nave.setMatricula(Integer.parseInt(view.getTextField().getText()));
		int n = JOptionPane.showConfirmDialog(null,"Você está deletando a nave " + nave.getMatricula() +
				". Deseja continuar com esta ação?", null, JOptionPane.YES_NO_OPTION);
		if(n == JOptionPane.YES_OPTION) {
			try {
				dao.deleteByMatricula(nave.getMatricula());
			} catch (Exception ex) {
				Logger.getLogger(VisualizarClienteController.class.getName()).log(Level.SEVERE, null, ex);
			}
			VisualizarTodos();
			view.getTextField().setText("");
		}
	}
	//Adiciona dados de todas as naves na tabela
	private void VisualizarTodos() {
		dao = new NaveDAO();
		String [] colunas = {"Matrícula","Modelo","Operador","Fabricante","Ano","Qt de assentos"};
		DefaultTableModel modelo = new DefaultTableModel(null,colunas);
		view.setTabela(new JTable(modelo));
		
		DefaultTableModel dados = (DefaultTableModel) view.getTabela().getModel();
		List<Nave> naves = null;
		view.getTabela().getColumnModel().getColumn(0).setPreferredWidth(1);
		view.getTabela().getColumnModel().getColumn(1).setPreferredWidth(1);
		view.getTabela().getColumnModel().getColumn(2).setPreferredWidth(1);
		view.getTabela().getColumnModel().getColumn(3).setPreferredWidth(1);
		view.getTabela().getColumnModel().getColumn(4).setPreferredWidth(1);
		view.getTabela().getColumnModel().getColumn(5).setPreferredWidth(1);
			try {
				naves = dao.getNave();
			} catch (Exception ex) {
				Logger.getLogger(VisualizarNaveController.class.getName()).log(Level.SEVERE, null, ex);
			}
		
		for(Nave n:naves) {
			String[] dado = new String[colunas.length];
			dado[0] = Integer.toString(n.getMatricula());
			dado[1] = n.getModelo();
			dado[2] = n.getOperador();
			dado[3] = n.getFabricante();
			dado[4] = Integer.toString(n.getAno());
			dado[5] = Integer.toString(n.getQtdAssento());
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
	//Faz verificação da existencia da matricula da nave.
	public boolean VerificaMatricula() throws Exception {
		String sql = "select * from nave where matricula = ?";
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
