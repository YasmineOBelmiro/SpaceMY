package controller;
import java.awt.EventQueue;

import javax.swing.JOptionPane;

import dao.ClienteDAO;
import dao.NaveDAO;
import dao.ReservaDao;
import dao.VooDAO;
import model.Cliente;
import model.Nave;
import model.Reserva;
import model.Voo;
import view.CadastroNave;
import view.CadastroVoo;
import view.Login;
import view.MenuFuncionario;
import view.VisualizarCliente;
import view.VisualizarNaves;
import view.VisualizarReservas;
import view.VisualizarVoo;
/**
 * Controla o menu do funcionario.
 * @author Yasmine.if
 *
 */
public class MenuFuncionarioController {
	private MenuFuncionario view;
	/**	 
	 *Construtor da classe que recebe:
	 * @param view
	 */
	public MenuFuncionarioController(MenuFuncionario view) {
		this.view = view;
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
		view.getBtnCadNave().addActionListener(e-> CadastroNave());
		view.getBtnVisNave().addActionListener(e-> VisualizarNaves());
		view.getBtnVisCliente().addActionListener(e-> VisualizarCliente());
		view.getBtnVisPassagens().addActionListener(e-> VisualizarPassagens());
		view.getBtnSair().addActionListener(e-> Sair());
		view.getBtnCadVoo().addActionListener(e -> CadastroVoo());
		view.getBtnVisualizarVoo().addActionListener(e-> VisualizarVoo());
	}
	//Entra na tela de cadastro de nave.
	private void CadastroNave() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroNaveController c = new CadastroNaveController(new CadastroNave(), new Nave(0, 0, null, null, null, 0));
					c.initView();
					view.dispose();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.toString());
				}
			}
		});
	}
	//Entra na tela de cadastro voo
	private void CadastroVoo() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroVooController c = new CadastroVooController(new CadastroVoo(),new VooDAO());
					c.initView();
					view.dispose();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//Entra na tela de visualizar todos os cadastro de naves existentes no banco de dados.
	private void VisualizarNaves() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizarNaveController c = new VisualizarNaveController(new VisualizarNaves(), new Nave(0, 0, null, null, null, 0), new NaveDAO());
					c.initView();
					view.dispose();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//Entra na tela de visualizar todos os cadastro de clientes existentes no banco de dados.
	private void VisualizarCliente() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizarClienteController c = new VisualizarClienteController(new VisualizarCliente(), new Cliente(),new ClienteDAO());
					c.initView();
					view.dispose();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//Entra na tela de visualizar todos os cadastro de reservas existentes no banco de dados.
	private void VisualizarPassagens() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizarReservasController c =  new VisualizarReservasController(new VisualizarReservas(), new ReservaDao(), new Reserva());
					c.initView();
					view.dispose();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//Entra na tela de visualizar todos os cadastro de voos existentes no banco de dados.
	private void VisualizarVoo() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizarVooController c = new VisualizarVooController(new VisualizarVoo(), new VooDAO(), new Voo(0, null, null, 0, 0, null, null, null, 0));
					c.initView();
					view.dispose();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//Volta para a tela de login.
	private void Sair() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginController c = new LoginController(new Login());
					c.initView();
					view.dispose();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
