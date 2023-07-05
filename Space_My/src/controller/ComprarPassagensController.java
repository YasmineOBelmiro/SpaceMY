package controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import dao.ClienteDAO;
import dao.ReservaDao;
import dao.VooDAO;
import factory.ConnectionFactory;
import model.Cliente;
import model.Reserva;
import model.Voo;
import view.CompraPassagens;
import view.MenuCliente;
/**
 * Controle da compra de passagens.
 * @author Yasmine.if
 *
 */
public class ComprarPassagensController {
	private CompraPassagens view;
	private Reserva reserva;
	/**
	 * Construtor da classe que recebe:
	 * @param view
	 * @param reserva
	 */
	public ComprarPassagensController(CompraPassagens view, Reserva reserva) {
		super();
		this.view = view;
		this.reserva = reserva;
		
	}
	//Inicia a visualização do frame.
	public void initView() {
		view.setVisible(true);
		view.setLocationRelativeTo(null);
		view.setResizable(false);
		initController();
		ItensCombox();
	}
	//Inicia o controle dos botões do frame.
	public void initController() {
		view.getBtnComprar().addActionListener(e-> {
			try {
				Comprar();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		view.getBtnContinuar().addActionListener(e -> {
			try {
				Continuar();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		view.getBtnReservar().addActionListener(e -> {
			try {
				Reserva();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		view.getBtnVisualizarVoos().addActionListener(e-> VisualizarTodos());
		view.getBtnVoltar().addActionListener(e-> Voltar());
	}
	//Volta para o menu do cliente.
	private void Voltar() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuClienteController c = new MenuClienteController(new MenuCliente());
					c.initView();
					view.dispose();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.toString());
				}
			}
		});
	}
	@SuppressWarnings("unchecked")
	private void Continuar() throws Exception {
		view.getPanel_4().setVisible(true);
		view.getPanel_3().removeAll();
		view.getCbAssento().removeAllItems();
		String sql,sql2;
		Connection conn = null;
		PreparedStatement pstm = null,pstm2 = null;
		ResultSet rset = null, rset2 = null;
					
			try {
				conn = ConnectionFactory.createConnectionToMySQL();
				sql = "select * from voo where origem_Destino = ?";
				pstm = (PreparedStatement) conn.prepareStatement(sql);
				pstm.setString(1, (String) view.getCbOrigem().getSelectedItem());
				rset = pstm.executeQuery();
						if(rset.next()) {
							sql2 = "select * from clienteVoo where numVoo = ? and dataVoo = ?";
							pstm2 = (PreparedStatement) conn.prepareStatement(sql2);
							pstm2.setInt(1,rset.getInt(1));
							pstm2.setString(2, view.getFtfDataPartida().getText());
							rset2 = pstm2.executeQuery();
							ReservaDao RDAO = new ReservaDao();
							boolean [] assentos = new boolean[rset.getInt(5)];
				
							 JButton[] a = new JButton[assentos.length];
							 for(int i = 0; i < a.length; i++) {
								if(rset2.next()) {
								 assentos[i] = false;
								}else assentos[i] = true;
							 }
							 for(int i = 0; i < a.length; i++)
							 {
								
								 if(assentos[i] == true) {
									 a[i] =  new JButton(new ImageIcon("icons//icone_assento.png"));
									 a[i].setText("A" + (i + 1));
									 a[i].setBounds(31, 59, 114, 59);
									 a[i].setForeground(new Color(226, 181, 232));
									 a[i].setFont(new Font("Times New Roman", Font.PLAIN, 15));
									 a[i].setBackground(new Color(82, 29, 88));
									 a[i].setEnabled(false);
									 view.getPanel_3().add(a[i]);
									 view.getCbAssento().addItem((i + 1));
								 }else if(assentos[i] == false){
									 a[i] =  new JButton(new ImageIcon("icons//icone_ocupado.png"));
									 a[i].setText("A" + (i + 1));
									 a[i].setBounds(31, 59, 114, 59);
									 a[i].setForeground(new Color(226, 181, 232));
									 a[i].setFont(new Font("Times New Roman", Font.PLAIN, 15));
									 a[i].setBackground(new Color(82, 29, 88));
									 a[i].setEnabled(false);
									 view.getPanel_3().add(a[i]);
								 }
							 }
						}

			}catch (SQLException erro) {
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
	}
	//Metodo que finaliza a compra do cliente.
	private void Comprar() throws Exception {
		//Faz verificação se os componentes que interagem com o cliente estão vazios e retorna uma mensagem de advertencia.
		
		if(view.getFtfNumCartao().getText().equals("")) {
			JOptionPane.showMessageDialog(null, "O campo do fabricante de telefone não pode ser vazio!");
			view.getFtfNumCartao().requestFocus();
			return;
		}
		else if(view.getFtfValidade().getText().equals("")) {
			JOptionPane.showMessageDialog(null, "O campo do ano não pode ser vazio!");
			view.getFtfValidade().requestFocus();
			return;
		}else if(view.getFttCVV().getText().equals("")) {
			JOptionPane.showMessageDialog(null, "O campo do modelo não pode ser vazio!");
			view.getFttCVV().requestFocus();
			return;
		}else if(view.getTextNome().getText().equals("")) {
			JOptionPane.showMessageDialog(null, "O campo do modelo não pode ser vazio!");
			view.getTextNome().requestFocus();
			return;
		}
		else {
			//Caso todos os compentes estiverem no padrão, a compra é finalizada
			JOptionPane.showMessageDialog(null, "Sua compra foi realizada com sucesso!!");
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						MenuClienteController c = new MenuClienteController(new MenuCliente());
						c.initView();
						view.dispose();
					} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.toString());
					}
				}	
		});
	        		   
		}
	}
	//Metodo que faz o cadastro de reserva do voo pelo cliente
	private void Reserva() throws Exception {
		
		
		
		//Deixando o tudo q ha dentro de panelDaReserva invisivel.
		PanelDaReservaInvisivel();
		String sql,senha;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
					
			try {
				conn = ConnectionFactory.createConnectionToMySQL();
				senha = JOptionPane.showInputDialog("Digite sua senha novamente:");
				
				sql = "select * from clientes where senha = ?";
				pstm = (PreparedStatement) conn.prepareStatement(sql);
				pstm.setString(1, senha);
				rset = pstm.executeQuery();
				//verifica se o cliente existe.
				if(rset.next()) {	
					view.getPanelPagamento().setVisible(true);
					view.getPanel_3().setVisible(false);
					view.getPanel_4().setVisible(false);
					salvar(senha);	
				}else {
					JOptionPane.showMessageDialog(null, "Senha está incorreta!Tente novamente!!");
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								ComprarPassagensController c = new ComprarPassagensController(new CompraPassagens(), new Reserva());
								c.initView();
								view.dispose();
							}catch (Exception e) {
								JOptionPane.showMessageDialog(null, e.toString());
							}
						}	
					});
				}
			}catch (SQLException erro) {
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
	}
	//Metodo que mostra todas as reservas em uma tabela
		private void VisualizarTodos() {
		VooDAO dao = new VooDAO();
		String [] colunas = {"Numero do voo","Origem/Destino","Valor da passagem","Matricula da nave"};
		DefaultTableModel modelo = new DefaultTableModel(null,colunas);
		view.setTabela(new JTable(modelo));
		
		DefaultTableModel dados = (DefaultTableModel) view.getTabela().getModel();
		List<Voo> voos = null;
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
			dado[3] = Integer.toString(v.getMatricula());
			dados.addRow(dado);
		}
		view.getTabela().setVisible(true);
		view.getScrollPane().setVisible(true);
		view.getScrollPane().setViewportView(view.getTabela());
	}

	@SuppressWarnings("unchecked")
	private void ItensCombox() {
		VooDAO VDAO = new VooDAO();
		
		for(Voo voo: VDAO.mostrarVoos()) {
			view.getCbOrigem().addItem(voo.toString());
		} 	
	}
	
	private void PanelDaReservaInvisivel() {
		view.getLblOrigem_Destino().setVisible(false);
		view.getLblDataDePartida().setVisible(false);
		view.getLblAaaammdd().setVisible(false);
		view.getBtnVisualizarVoos().setVisible(false);
		view.getBtnReservar().setVisible(false);
		view.getScrollPane().setVisible(false);
		view.getCbOrigem().setVisible(false);
		view.getFtfDataPartida().setVisible(false);
		view.getBtnContinuar().setVisible(false);
	}
	
	private void salvar(String senha) throws Exception {
		ClienteDAO clienteDao = new ClienteDAO();
		VooDAO vooDao = new VooDAO();
		List<Cliente> listClientes = clienteDao.ConfirmaçaoDeUsuario(senha);
		List<Voo> listVoos = vooDao.ConfirmacaoByOrigem_Destino((String) view.getCbOrigem().getSelectedItem());
	

		for(Cliente c : listClientes) {
			reserva.setIdCliente(c.getId());
		}
		
		for(Voo v: listVoos) {
			reserva.setNumVoo(v.getNumVoo());
			reserva.setData(view.getFtfDataPartida().getText());
			reserva.setAssento((int) view.getCbAssento().getSelectedItem());
		}				
		ReservaDao reservaDao = new ReservaDao();
		try {
			reservaDao.save(reserva);
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString());
		}
					
			
		List<Cliente> clientes = clienteDao.ConfirmaçaoDeUsuario(senha);
			for(Cliente c : clientes) {
				view.getLblNome_2().setText(c.getNome());
			}
			
		List<Voo> voos = vooDao.ConfirmacaoByOrigem_Destino((String)view.getCbOrigem().getSelectedItem());
			for(Voo v: voos) {
				view.getLblOrigem_destino1_1().setText(v.getOrigem_destino());
				view.getLblMatriculaDaNave_1().setText(Integer.toString(v.getMatricula()));
				view.getLblData_1().setText(view.getFtfDataPartida().getText());
				view.getLblNumeroDoVoo_1().setText(Integer.toString(v.getNumVoo()));
				view.getLblValor_1().setText(v.getValor().toString());
				view.getLblAssento_2().setText(view.getCbAssento().getSelectedItem().toString());
			}
	}
	
}			
  
 
