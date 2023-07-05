package controller;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import dao.NaveDAO;
import dao.VooDAO;
import factory.ConnectionFactory;
import model.Nave;
import model.Voo;
import view.CadastroVoo;
import view.MenuFuncionario;
/**
 * Controle de cadastro de voo.
 * @author Luigi.if
 *
 */
public class CadastroVooController {
	private CadastroVoo view;
	private VooDAO dao;
	/**
	 * Construtor da classe que recebe:
	 * @param view
	 * @param dao
	 */
	public CadastroVooController(CadastroVoo view,VooDAO dao) {
		super();
		this.view = view;
		this.dao = dao;
}
	//Inicia a visualização do frame.
	public void initView() {
		view.setVisible(true);
		view.setLocationRelativeTo(null);
		view.setResizable(false);
		initController();
		ItensCombox();
	}
	//Inicia a ação dos botões do frame.
	public void initController() {
		view.getBtnVoltar().addActionListener(e -> Voltar());
		view.getBtnSalvar().addActionListener(e -> Salvar());
	}
	//Volta pro menu do funcionario.
	private void Voltar() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuFuncionarioController c = new MenuFuncionarioController(new MenuFuncionario());
					c.initView();
					view.dispose();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.toString());
				}
			}
		});
	}
	//Metodo que faz o salvamento do casdastro do voo.
	private void Salvar() {
		//Faz verificação se os componentes que interagem com o funcionário estão vazios e retorna uma mensagem de advertencia.
		
		if(view.getTextValor().getText().equals("")) {
			JOptionPane.showMessageDialog(null, "O campo do ano não pode ser vazio!");
			view.getTextValor().requestFocus();
			return;
		}else if(view.getTextOrinDest().getText().equals("")) {
			JOptionPane.showMessageDialog(null, "O campo do modelo não pode ser vazio!");
			view.getTextOrinDest().requestFocus();
			return;
		}else if(verificaExistenciaNave() == false){
			JOptionPane.showMessageDialog(null, "Insira uma matricula de nave existente!");
			
		}else {
			/*Seta os atributos do voo, usando os componentes que interagem com o funcionário e faz o salvamento no
			banco de dados atravéz do VooDAO*/
			Voo voo = new Voo(0, null, null, 0, 0, null, null, null, 0);
			voo.setOrigem_destino(view.getTextOrinDest().getText());
			voo.setValor(Double.parseDouble( view.getTextValor().getText()));
			voo.setMatricula(Integer.parseInt( view.getCbMatricula().getSelectedItem().toString()));
			voo.setQtdAssento(Integer.parseInt( view.getTextAssentos().getText()));
			try {
				dao.save(voo);
				limparCampos();
			} catch (Exception e) {
				Logger.getLogger(CadastroVooController.class.getName()).log(Level.SEVERE, null, e);
			}
		}
		
	}
	@SuppressWarnings({ "unchecked", "unused" })
	private void ItensCombox() {
		NaveDAO  dao = new NaveDAO();
		
		for(Nave nave: dao.mostrarMatricula()) {
			view.getCbMatricula().addItem(nave.toString());
		} 	
	}
	private void limparCampos() {
		view.getTextAssentos().setText("");
		view.getTextOrinDest().setText("");
		view.getTextValor().setText("");
	}
	private boolean verificaExistenciaNave() {
		String sql = "select * from nave where matricula = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setInt(1, Integer.parseInt( view.getCbMatricula().getSelectedItem().toString()));
			rset = pstm.executeQuery();
				if(rset.next()){
					return true;
			} 
				
		}catch (Exception e) {
			 e.printStackTrace();
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
					e.printStackTrace();
				}
				 
		}
		return false;
		
	}
}
