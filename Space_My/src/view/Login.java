package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
/**
 * clase de interface grafica de login
 * @author Luigi_IF
 *
 */
@SuppressWarnings("serial")
public class Login extends JFrame{
	private static final long serialVersionUID = -8230279135562236394L;
	private JPanel contentPane, panel, panel_2;
	private JTextField textUsuario;
	private JPasswordField passwordFieldLogin;
	private JButton btnLogin, btnCadastrar;
	private JLabel lblSemConta, lblSenha, lblSpaceMy, lblUsuario, lblIcone;
	public Login() {  
		initComponents();
	}
	public void initComponents() {
		setTitle("AirMy");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 737, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    BufferedImage backgroundImage = ImageIO.read(new File("icons//icone_wallpaper.jpg"));     
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
		panel.setBounds(0, 0, 723, 463);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		panel_2 =new JPanel();
		panel_2.setBounds(160, 10, 423, 439);
		panel_2.setBackground(new Color(29, 10, 31));
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		textUsuario = new JTextField();
		textUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textUsuario.setBackground(new Color(226, 181, 232));
		textUsuario.setBounds(70, 167, 279, 23);
		panel_2.add(textUsuario);
		textUsuario.setColumns(10);

		btnLogin = new JButton("Login");
		btnLogin.setIcon(new ImageIcon("AIRMY//icons//icone_Login.png"));
		btnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	}});
		
		btnLogin.setForeground(new Color(213, 146, 220));
		btnLogin.setBackground(new Color(82, 29, 88));
		btnLogin.setBounds(122, 255, 175, 30);
		btnLogin.setBorder(null);
		panel_2.add(btnLogin);
		
		passwordFieldLogin = new JPasswordField();
		passwordFieldLogin.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		passwordFieldLogin.setBackground(new Color(226, 181, 232));
		passwordFieldLogin.setBounds(70, 201, 279, 22);
		panel_2.add(passwordFieldLogin);
		
		lblSemConta = new JLabel("Não tem conta?");
		lblSemConta.setForeground(new Color(226, 181, 232));
		lblSemConta.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblSemConta.setBounds(205, 414, 99, 14);
		panel_2.add(lblSemConta);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setIcon(new ImageIcon("icons//icone_cadastro.png"));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {}});
		btnCadastrar.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnCadastrar.setForeground(new Color(213, 146, 220));
		btnCadastrar.setBackground(new Color(82, 29, 88));
		btnCadastrar.setBounds(314, 412, 99, 20);
		btnCadastrar.setBorder(null);
		panel_2.add(btnCadastrar);
		
		lblUsuario = new JLabel("");
		lblUsuario.setIcon(new ImageIcon("icons//icone_usuario.png"));
		lblUsuario.setBounds(40, 167, 20, 26);
		panel_2.add(lblUsuario);
		
		lblSenha = new JLabel("");
		lblSenha.setIcon(new ImageIcon("icons//icone_senha.png"));
		lblSenha.setBounds(40, 200, 20, 23);
		panel_2.add(lblSenha);
		
		lblSpaceMy = new JLabel("SpaceMy");
		lblSpaceMy.setForeground(new Color(213, 146, 220));
		lblSpaceMy.setFont(new Font("Segoe Print", Font.PLAIN, 25));
		lblSpaceMy.setBounds(157, 70, 112, 44);
		panel_2.add(lblSpaceMy);
		
		lblIcone = new JLabel("");
		lblIcone.setIcon(new ImageIcon("icons//icone_Logo.png"));
		lblIcone.setBounds(122, 71, 55, 56);
		panel_2.add(lblIcone);
	}
	public JButton getBtnLogin() {
		return btnLogin;
	}
	public void setBtnLogin(JButton btnLogin) {
		this.btnLogin = btnLogin;
	}
	public JButton getBtnCadastrar() {
		return btnCadastrar;
	}
	public void setBtnCadastrar(JButton btnCadastrar) {
		this.btnCadastrar = btnCadastrar;
	}
	public JTextField getTextUsuario() {
		return textUsuario;
	}
	public void setTextUsuario(JTextField textUsuario) {
		this.textUsuario = textUsuario;
	}
	public JPasswordField getPasswordFieldLogin() {
		return passwordFieldLogin;
	}
	public void setPasswordFieldLogin(JPasswordField passwordFieldLogin) {
		this.passwordFieldLogin = passwordFieldLogin;
	}
}
