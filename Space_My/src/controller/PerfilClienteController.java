package controller;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import dao.ClienteDAO;
import dao.ReservaDao;
import factory.ConnectionFactory;
import model.Cliente;
import model.Reserva;
import view.MenuCliente;
import view.PerfilCliente;
/**
 * Controla o perfil do cliente
 * @author Yasmine.if
 *
 */
public class PerfilClienteController {
	private PerfilCliente view;
	private ClienteDAO clienteDao;
	private ReservaDao reservaDao;
/**
 * Construtor da classe que recebe:
 * @param view
 * @param clienteDao
 * @param reservaDao
 */
	public PerfilClienteController(PerfilCliente view, ClienteDAO clienteDao, ReservaDao reservaDao) {
		super();
		this.view = view;
		this.clienteDao = clienteDao;
		this.reservaDao = reservaDao;
	}
	//Inicia a visualização do frame.
	public void initView() throws Exception {
		view.setVisible(true);
		view.setLocationRelativeTo(null);
		view.setResizable(false);
		initController();
	}	
	//Inicia a ação dos botões do frame.
	public void initController() throws Exception {
		view.getBtnVoltar().addActionListener(e-> Voltar());
		BuscarDados();
	}
	//Retorna para o menu do cliente
	public void Voltar() {
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
	/*Busca o cliente no banco de dados, adiciona seus dados na tela e 
	 a adiciona os dados dos voos reservados pelo cliente na tabela*/
	private void BuscarDados() throws Exception {
		String sql, senha;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
					try {	
						senha = JOptionPane.showInputDialog("Digite sua senha novamente:");
						conn = ConnectionFactory.createConnectionToMySQL();
						sql = "select * from clientes where senha = ?";
						pstm = (PreparedStatement) conn.prepareStatement(sql);
						pstm.setString(1, senha);
						rset = pstm.executeQuery();
						//verifica a existencia do cliente
						if(rset.next()) {
							view.getPanel_2().setVisible(true);
							
							String [] colunas = {"Id de reserva","Id de cliente","Numero do voo","Data do voo","Numero do assento"};
							DefaultTableModel modelo = new DefaultTableModel(null,colunas);
							view.setTabela(new JTable(modelo));
								
							DefaultTableModel dados = (DefaultTableModel) view.getTabela().getModel();
							List<Reserva> reservas = null;
								try {
									reservas = reservaDao.visualizarByIdCliente(rset.getInt(1));
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
								
								view.getTabela().setVisible(true);
								view.getScrollPane().setVisible(true);
								view.getScrollPane().setViewportView(view.getTabela());
							}

						}else if(senha == null) {
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

						}else{
							JOptionPane.showMessageDialog(null, "Senha está incorreta!Tente novamente!!");
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
						List<Cliente> clientes = clienteDao.ConfirmaçaoDeUsuario(senha);
						for(Cliente c : clientes) {
						
							view.getLblEmail().setText(c.getEmail());
							view.getLblNome().setText(c.getNome());
							view.getLblDataDeNascimento().setText(c.getDataNascimento().toString());
							view.getLblSexo().setText(c.getSexo());
							view.getLblTelefone().setText(c.getTelefone());
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
}
