package controller;

import java.awt.EventQueue;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.NaveDAO;
import dao.VooDAO;
import model.Nave;
import model.Voo;
import view.MenuFuncionario;
import view.VisualizarVoo;
/**
 * Controle de visualização de voo
 * @author Yasmine.if
 *
 */
public class VisualizarVooController {

	private VisualizarVoo view;
	private VooDAO dao;
	private Voo voo;
	/**
	 * Construtor da classe que recebe:
	 * @param view
	 * @param dao
	 * @param voo
	 */
	public VisualizarVooController( VisualizarVoo view,VooDAO dao,Voo voo) {
		super();
		 this.view = view;
		 this.dao = dao;
		 this.voo = voo;
		 
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
		view.getBtnBuscar().addActionListener(e-> buscar());
		view.getBtnVisualizar().addActionListener(e-> visualizar());
		view.getBtnExcluir().addActionListener(e-> excluir());
		view.getBtnVoltar().addActionListener(e-> voltar());
	}
	
	private void excluir() {
		if(view.getTextField().getText().equals("")) {
			JOptionPane.showMessageDialog(null, "O campo está vazio");
			view.getTextField().requestFocus();
			return;
		}
		voo.setNumVoo(Integer.parseInt(view.getTextField().getText()));
		int n = JOptionPane.showConfirmDialog(null,"Você está deletando a nave " + voo.getNumVoo() +
				". Deseja continuar com esta ação?", null, JOptionPane.YES_NO_OPTION);
		if(n == JOptionPane.YES_OPTION) {
			try {
				dao.deleteByNumVoo(voo.getNumVoo());
			} catch (Exception ex) {
				Logger.getLogger(VisualizarClienteController.class.getName()).log(Level.SEVERE, null, ex);
			}
			VisualizarTodos();
			view.getTextField().setText("");
		}
	}
	private void VisualizarTodos() {
		dao = new VooDAO();
		String [] colunas = {"Numero do voo","Origem/destino","Valor da passagem","Matricula da nave","Quatidade de assentos"};
		DefaultTableModel modelo = new DefaultTableModel(null,colunas);
		view.setTabela(new JTable(modelo));
		
		DefaultTableModel dados = (DefaultTableModel) view.getTabela().getModel();
		List<Voo> voos  = null;
			try {
				voos = dao.getVoo();
			} catch (Exception ex) {
				Logger.getLogger(VisualizarNaveController.class.getName()).log(Level.SEVERE, null, ex);
			}
		
		for(Voo v:voos) {
			String[] dado = new String[colunas.length];
			dado[0] = Integer.toString(v.getNumVoo());
			dado[1] = v.getOrigem_destino();
			dado[2] = v.getValor().toString();
			dado[3] = Integer.toString (v.getMatricula());
			dado[4] = Integer.toString (v.getQtdAssento());
					
			
			dados.addRow(dado);
		}
		view.getTabela().setVisible(true);
		view.getScrollPane().setVisible(true);
		view.getScrollPane().setViewportView(view.getTabela());
	}
	//volta para o menu
	private void voltar() {
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
	//Adiciona dados de todos os voos na tabela
	private void visualizar() {
		dao = new VooDAO();
		String [] colunas = {"Numero do voo","Origem/destino","Valor da passagem","Matricula da nave","Quatidade de assentos"};
		DefaultTableModel modelo = new DefaultTableModel(null,colunas);
		view.setTabela(new JTable(modelo));
		
		DefaultTableModel dados = (DefaultTableModel) view.getTabela().getModel();
		List<Voo> voos  = null;
			try {
				voos = dao.getVoo();
			} catch (Exception ex) {
				Logger.getLogger(VisualizarNaveController.class.getName()).log(Level.SEVERE, null, ex);
			}
		
		for(Voo v:voos) {
			String[] dado = new String[colunas.length];
			dado[0] = Integer.toString(v.getNumVoo());
			dado[1] = v.getOrigem_destino();
			dado[2] = v.getValor().toString();
			dado[3] = Integer.toString (v.getMatricula());
			dado[4] = Integer.toString (v.getQtdAssento());
					
			
			dados.addRow(dado);
		}
		view.getTabela().setVisible(true);
		view.getScrollPane().setVisible(true);
		view.getScrollPane().setViewportView(view.getTabela());
		view.getTextField().setText("");
		}
	//busca um voo pelo numero de voo e adiciona o resultado na tabela
	private void buscar() {
		if(view.getTextField().getText().equals("")) {
			JOptionPane.showMessageDialog(null, "O campo está vazio");
			view.getTextField().requestFocus();
			return;
		}
		dao = new VooDAO();
		String [] colunas = {"Numero do voo","Origem/destino","Valor da passagem","Matricula da nave","Quatidade de assentos"};
		DefaultTableModel modelo = new DefaultTableModel(null,colunas);
		view.setTabela(new JTable(modelo));
		
		DefaultTableModel dados = (DefaultTableModel) view.getTabela().getModel();
		List<Voo> voos  = null;
		
			try {
				voo.setNumVoo(Integer.parseInt(view.getTextField().getText()));
				voos = dao.buscarByNumVoo(voo.getNumVoo());
			} catch (Exception ex) {
				Logger.getLogger(VisualizarNaveController.class.getName()).log(Level.SEVERE, null, ex);
			}
		
		for(Voo v:voos) {
			String[] dado = new String[colunas.length];
			dado[0] = Integer.toString(v.getNumVoo());
			dado[1] = v.getOrigem_destino();
			dado[2] = v.getValor().toString();
			dado[3] = Integer.toString (v.getMatricula());
			dado[4] = Integer.toString (v.getQtdAssento());
			
			dados.addRow(dado);
		}
		view.getTabela().setVisible(true);
		view.getScrollPane().setVisible(true);
		view.getScrollPane().setViewportView(view.getTabela());
		view.getTextField().setText("");
	}

}
