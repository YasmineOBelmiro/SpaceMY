package controller;
import java.awt.EventQueue;

import dao.ClienteDAO;
import dao.ReservaDao;
import model.*;
import view.*;
/**
 * Controla o menu do cliente
 * @author Yasmine.if
 *
 */
public class MenuClienteController {
	private MenuCliente view;
/**
 * Construtor da classe que recebe:
 * @param view
 */
	public MenuClienteController(MenuCliente view) {
		this.view = view;
		
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
		view.getBtnPerfil().addActionListener(e-> Perfil());
		view.getBtnComprarPassagens().addActionListener(e-> ComprarPassagens());
		view.getBtnSair().addActionListener(e-> Sair());
	}
	//Entra na tela do perfil do cliente
	private void Perfil() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PerfilClienteController c = new PerfilClienteController(new PerfilCliente(), new ClienteDAO(),new ReservaDao());
					c.initView();
					view.dispose();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//Entra na tela para comprar passagens
	private void ComprarPassagens() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComprarPassagensController c = new ComprarPassagensController(new CompraPassagens(), new Reserva());
					c.initView();
					view.dispose();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//Volta para a tela de Login.
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
