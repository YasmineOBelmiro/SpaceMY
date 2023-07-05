package controller;

import java.awt.EventQueue;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Date;
import javax.swing.JOptionPane;

import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;

import model.*;
import view.*;
import dao.*;
/**
 * Controle de cadastro de cliente
 * @author Yasmine.if
 *
 */
public class CadastroClienteController {
	private CadastroCliente view;
	private Cliente cliente;
/**
 * Construtor da classe que recebe:
 * @param tela = view
 * @param cliente = cliente
 */
	public CadastroClienteController(CadastroCliente tela,Cliente cliente) {
		this.view = tela;
		this.cliente = cliente;
	}
	/**
	 * Inicia a visualização do frame.
	 * @throws MySQLSyntaxErrorException
	 * @throws ParseException
	 */
	public void initView() throws MySQLSyntaxErrorException, ParseException {
		view.setVisible(true);
		view.setLocationRelativeTo(null);
		view.setResizable(false);
		initController();
	}
	
	//Inicia a ação dos botões do frame.
	public void initController() {
		view.getBtnSalvar().addActionListener(e-> {
			try {
				Salvar();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		view.getBtnSair().addActionListener(e-> Sair());
	}
	
	//Metodo que faz o salvamento do casdastro cliente.
	private void Salvar() throws ParseException {
	
		
		//Faz verificação se os componentes que interagem com o cliente estão vazios e retorna uma mensagem de advertencia.
	if(view.getTextNome().getText().equals("")) {
		JOptionPane.showMessageDialog(null, "O campo do nome não pode ser vazio!");
		view.getTextNome().requestFocus();
		return;
		}
		else if(view.getFtfNascimento().getText().equals("")){
			JOptionPane.showMessageDialog(null, "O campo da data de nascimento não pode ser vazio!");
			view.getFtfNascimento().requestFocus();
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
		else if((view.getPasswordFieldUsuario().getPassword().equals("") && view.getPasswordFieldConfirme().getPassword().equals(""))){
			JOptionPane.showMessageDialog(null, "Os campos de senha não podem ser vazios!");
			view.getPasswordFieldUsuario().requestFocus();
			view.getPasswordFieldConfirme().requestFocus();
			return;
			
		}else if(!new String(view.getPasswordFieldUsuario().getPassword()).equals(new String(view.getPasswordFieldConfirme().getPassword()))) {
			JOptionPane.showMessageDialog(null, "As senhas devem ser iguais!");
			view.getPasswordFieldUsuario().requestFocus();
			view.getPasswordFieldConfirme().requestFocus();
			return;
		}else {
			/*Seta os atributos do cliente, usando os componentes que interagem com o cliente e faz o salvamento no
			banco de dados atravéz do ClienteDAO*/
			
			
			
			cliente.setNome(view.getTextNome().getText().toUpperCase());
			cliente.setSenha(new String(view.getPasswordFieldConfirme().getPassword()));
			cliente.setEmail(view.getTextEmail().getText());
			cliente.setSexo((String)view.getCbSexo().getSelectedItem());
			cliente.setDataNascimento(view.getFtfNascimento().getText());
			cliente.setTelefone(view.getFtfTelefone().getText());
			ClienteDAO dao = new ClienteDAO();
				try {
					dao.save(cliente);
					limparCampos();
				}catch (NullPointerException e) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!!");
				}catch (Exception e) {
					  Logger.getLogger(CadastroClienteController.class.getName()).log(Level.SEVERE, null, e);
				}	
	}
  }
	private void limparCampos() {
		view.getTextNome().setText("");
		view.getPasswordFieldUsuario().setText("");
		view.getPasswordFieldConfirme().setText("");
		view.getTextEmail().setText("");
		view.getFtfNascimento().setText("");
		view.getFtfTelefone().setText("");
		
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
