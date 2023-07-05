package controller;

import java.awt.EventQueue;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.ReservaDao;
import model.Reserva;
import view.MenuFuncionario;
import view.VisualizarReservas;
/**
 * Controle de visualização de reservas
 * @author Yasmine.if
 *
 */
public class VisualizarReservasController {

	private VisualizarReservas view;
	private ReservaDao dao;
	private Reserva reserva;
	/**
	 * Construtor da classe que recebe:
	 * @param view
	 * @param dao
	 */
	public VisualizarReservasController(VisualizarReservas view, ReservaDao dao, Reserva reserva) {
		this.view = view;
		this.dao = dao;
		this.reserva = reserva;
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
		view.getBtnVisualizar().addActionListener(e-> VisualizarTodos());
		view.getBtnExcluir().addActionListener(e-> excluir());
		view.getBtnVoltar().addActionListener(e-> Voltar());
	}
	private void excluir() {
		if(view.getTextField().getText().equals("")) {
			JOptionPane.showMessageDialog(null, "O campo está vazio");
			view.getTextField().requestFocus();
			return;
		}
		reserva.setIdReserva(Integer.parseInt(view.getTextField().getText()));
		int n = JOptionPane.showConfirmDialog(null,"Você está deletando a nave " + reserva.getIdReserva() +
				". Deseja continuar com esta ação?", null, JOptionPane.YES_NO_OPTION);
		if(n == JOptionPane.YES_OPTION) {
			try {
				dao.removeByID(reserva.getIdReserva());
			} catch (Exception ex) {
				Logger.getLogger(VisualizarClienteController.class.getName()).log(Level.SEVERE, null, ex);
			}
			VisualizarTodos();
			view.getTextField().setText("");
		}
	}
	//busca uma reserva pelo id e adiciona o resultado na tabela
	private void Buscar() {
		if(view.getTextField().getText().equals("")) {
			JOptionPane.showMessageDialog(null, "O campo não pode ser vazio!!");
		}else {
			String [] colunas = {"Id de reserva","Id de cliente","Numero do voo","Data do voo","Número do assento"};
			DefaultTableModel modelo = new DefaultTableModel(null,colunas);
			view.setTabela(new JTable(modelo));
			
			DefaultTableModel dados = (DefaultTableModel) view.getTabela().getModel();
			List<Reserva> reservas = null;
				try {
					reservas = dao.buscarByIdReserva(Integer.parseInt(view.getTextField().getText()));
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.toString());
				}
			
			for(Reserva n:reservas) {
				String[] dado = new String[colunas.length];
				dado[0] = Integer.toString(n.getIdReserva());
				dado[1] = Integer.toString(n.getIdCliente());
				dado[2] = Integer.toString(n.getNumVoo());
				dado[3] = n.getData();
				dado[4] = Integer.toString(n.getAssento());
				dados.addRow(dado);
			}
			view.getTabela().setVisible(true);
			view.getScrollPane().setVisible(true);
			view.getScrollPane().setViewportView(view.getTabela());
			view.getTextField().setText("");
		}
		
	}
	//Adiciona dados de todas as reservas na tabela
	private void VisualizarTodos() {
		String [] colunas = {"Id de reserva","Id de cliente","Numero do voo","Data do voo","Numero do assento"};
		DefaultTableModel modelo = new DefaultTableModel(null,colunas);
		view.setTabela(new JTable(modelo));
		
		DefaultTableModel dados = (DefaultTableModel) view.getTabela().getModel();
		List<Reserva> reservas = null;
			try {
				reservas = dao.getReserva();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.toString());
			}
		
		for(Reserva n:reservas) {
			String[] dado = new String[colunas.length];
			dado[0] = Integer.toString(n.getIdReserva());
			dado[1] = Integer.toString(n.getIdCliente());
			dado[2] = Integer.toString(n.getNumVoo());
			dado[3] = n.getData();
			dado[4] = Integer.toString(n.getAssento());
			dados.addRow(dado);
		}
		view.getTabela().setVisible(true);
		view.getScrollPane().setVisible(true);
		view.getScrollPane().setViewportView(view.getTabela());
		
		
	}
	//retorna para o menu
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
	
	
}
