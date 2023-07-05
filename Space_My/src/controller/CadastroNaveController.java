package controller;

import java.awt.EventQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import dao.NaveDAO;
import model.Nave;
import view.*;
/**
 * Controle de cadastro de nave
 * @author Yasmine.if
 *
 */
public class CadastroNaveController {
	private CadastroNave view;
	private Nave nave;
	/**
	 * Construtor da classe que recebe:
	 * @param view 
	 * @param nave
	 */
	public CadastroNaveController(CadastroNave view, Nave nave) {
		this.view = view;
		this.nave = nave;
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
		view.getBtnSalvar().addActionListener(e-> Salvar());
		view.getBtnVoltar().addActionListener(e-> Voltar());
	}
	//Metodo que faz o salvamento do casdastro nave.
	private void Salvar() {
		//Faz verificação se os componentes que interagem com o funcionário estão vazios e retorna uma mensagem de advertencia.
		if(view.getTextOperador().getText().equals("")){
			JOptionPane.showMessageDialog(null, "O campo do operador não pode ser vazio!");
			view.getTextOperador().requestFocus();
			return;
		}
		else if(view.getTextFabricante().getText().equals("")) {
			JOptionPane.showMessageDialog(null, "O campo do fabricante de telefone não pode ser vazio!");
			view.getTextFabricante().requestFocus();
			return;
		}
		else if(view.getFtfAno().getText().equals("")) {
			JOptionPane.showMessageDialog(null, "O campo do ano não pode ser vazio!");
			view.getFtfAno().requestFocus();
			return;
		}else if(view.getTextModelo().getText().equals("")) {
			JOptionPane.showMessageDialog(null, "O campo do modelo não pode ser vazio!");
			view.getTextModelo().requestFocus();
			return;
		}else if(view.getTextAssentos().getText().equals("")) {
			JOptionPane.showMessageDialog(null, "O campo dos assentos não pode ser vazio!");
			view.getTextAssentos().requestFocus();
			return;
		}else {
			/*Seta os atributos da nave, usando os componentes que interagem com o funcionario e faz o salvamento no
			banco de dados atravéz do NaveDAO*/
			nave = new Nave(0, 0, null, null, null, 0);
			nave.setModelo(view.getTextModelo().getText().toUpperCase());
			nave.setOperador(view.getTextOperador().getText().toUpperCase());
			nave.setFabricante(view.getTextFabricante().getText().toUpperCase());
			nave.setAno(Integer.parseInt(view.getFtfAno().getText()));
			nave.setQtdAssento(Integer.parseInt(view.getTextAssentos().getText()));
			NaveDAO dao = new NaveDAO();
			try {
				dao.save(nave);
				limparCampos();
			} catch (Exception e) {
				Logger.getLogger(CadastroNaveController.class.getName()).log(Level.SEVERE, null, e);
			}
			
		}
	}
	private void limparCampos() {
		view.getTextOperador().setText("");
		view.getTextFabricante().setText("");
		view.getFtfAno().setText("");
		view.getTextModelo().setText("");
		view.getTextAssentos().setText("");
		
	}
	//Volta para a tela do menu do funcionario.
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
