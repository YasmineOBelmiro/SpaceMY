package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;


/**
 * classe com interface grafica de cadastro
 * @author Luigi_IF
 *
 */
@SuppressWarnings("serial")
public class CadastroCliente extends JFrame {

	private JPanel contentPane, panel, panel_1;
	private JTextField textNome,textEmail;
	private JPasswordField passwordFieldUsuario, passwordFieldConfirme;
	private JLabel lblNome, lblSexo, lblDataDeNascimento, lblTelefone, lblEmail, lblSenha, lblConfirmeSenha, lblCadastro, lblSpaceMy,lblIcone;
	private JComboBox<?> cbSexo;
	private JFormattedTextField ftfTelefone, ftfNascimento;
	private JButton btnSalvar,btnSair;
	private JLabel lblAaaammdd;
	


	public CadastroCliente() throws  ParseException {
		initComponents();
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void initComponents() throws ParseException{
		setTitle("AirMy");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 739, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		 
		panel =  new JPanel() {
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
		panel.setBounds(0, 0, 725, 463);
		contentPane.add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBounds(47, 11, 620, 439);
		panel_1.setBackground(new Color(29, 10, 31));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		textNome = new JTextField();
		textNome.setBounds(252, 157, 281, 20);
		textNome.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textNome.setColumns(10);
		textNome.setBackground(new Color(226, 181, 232));
		panel_1.add(textNome);
		
		textEmail = new JTextField();
		textEmail.setBounds(252, 278, 281, 20);
		textEmail.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textEmail.setColumns(10);
		textEmail.setBackground(new Color(226, 181, 232));
		panel_1.add(textEmail);
		
		passwordFieldUsuario = new JPasswordField();
		passwordFieldUsuario.setBounds(252, 309, 281, 20);
		passwordFieldUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		passwordFieldUsuario.setBackground(new Color(226, 181, 232));
		panel_1.add(passwordFieldUsuario);
		
		passwordFieldConfirme = new JPasswordField();
		passwordFieldConfirme.setBounds(252, 337, 281, 20);
		passwordFieldConfirme.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		passwordFieldConfirme.setBackground(new Color(226, 181, 232));
		panel_1.add(passwordFieldConfirme);
		
		lblNome = new JLabel("Nome:");
		lblNome.setBounds(94, 157, 128, 14);
		lblNome.setForeground(new Color(213, 146, 220));
		lblNome.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_1.add(lblNome);
		
		lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(94, 188, 128, 14);
		lblSexo.setForeground(new Color(213, 146, 220));
		lblSexo.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_1.add(lblSexo);
		
		lblDataDeNascimento = new JLabel("Data de nascimento:");
		lblDataDeNascimento.setBounds(94, 219, 128, 14);
		lblDataDeNascimento.setForeground(new Color(213, 146, 220));
		lblDataDeNascimento.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_1.add(lblDataDeNascimento);
		
		lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(94, 250, 128, 14);
		lblTelefone.setForeground(new Color(213, 146, 220));
		lblTelefone.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_1.add(lblTelefone);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setIcon(new ImageIcon("icons//icone_usuario.png"));
		lblEmail.setBounds(94, 278, 128, 20);
		lblEmail.setForeground(new Color(213, 146, 220));
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_1.add(lblEmail);
		
		lblSenha = new JLabel("Senha:");
		lblSenha.setIcon(new ImageIcon("icons//icone_senha.png"));
		lblSenha.setBounds(94, 309, 128, 20);
		lblSenha.setForeground(new Color(213, 146, 220));
		lblSenha.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_1.add(lblSenha);
		
		lblConfirmeSenha = new JLabel("Confirme senha:");
		lblConfirmeSenha.setBounds(94, 337, 128, 14);
		lblConfirmeSenha.setForeground(new Color(213, 146, 220));
		lblConfirmeSenha.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_1.add(lblConfirmeSenha);
		
		cbSexo = new JComboBox();
		cbSexo.setBounds(252, 186, 99, 22);
		cbSexo.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		cbSexo.setBackground(new Color(226, 181, 232));
		cbSexo.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Feminino", "Outro"}));
		panel_1.add(cbSexo);
		
		ftfNascimento = new JFormattedTextField(new MaskFormatter("####/##/##"));
		ftfNascimento.setBounds(252, 216, 76, 20);
		ftfNascimento.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		ftfNascimento.setBackground(new Color(226, 181, 232));
		panel_1.add(ftfNascimento);
		
		ftfTelefone = new JFormattedTextField(new MaskFormatter("(##)#####-####"));
		ftfTelefone.setBounds(252, 247, 105, 20);
		ftfTelefone.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		ftfTelefone.setBackground(new Color(226, 181, 232));
		panel_1.add(ftfTelefone);

	
		btnSalvar = new JButton("Salvar");
		btnSalvar.setIcon(new ImageIcon("icons//icone_salvar.png"));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { }});
		
		btnSalvar.setBounds(261, 386, 120, 23);
		btnSalvar.setBorder(null);
		btnSalvar.setForeground(new Color(213, 146, 220));
		btnSalvar.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnSalvar.setBackground(new Color(29, 10, 31));
		panel_1.add(btnSalvar);
		
		lblCadastro = new JLabel("Cadastro");
		lblCadastro.setForeground(new Color(213, 146, 220));
		lblCadastro.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblCadastro.setBounds(268, 109, 89, 23);
		panel_1.add(lblCadastro);
		
		lblSpaceMy = new JLabel("SpaceMy");
		lblSpaceMy.setForeground(new Color(213, 146, 220));
		lblSpaceMy.setFont(new Font("Segoe Print", Font.PLAIN, 25));
		lblSpaceMy.setBounds(259, 36, 112, 44);
		panel_1.add(lblSpaceMy);
		
		lblIcone = new JLabel("");
		lblIcone.setIcon(new ImageIcon("icons//icone_Logo.png"));
		lblIcone.setBounds(224, 37, 55, 56);
		panel_1.add(lblIcone);
		
		lblAaaammdd = new JLabel("AAAA/MM/DD");
		lblAaaammdd.setForeground(new Color(213, 146, 220));
		lblAaaammdd.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblAaaammdd.setBounds(367, 250, 120, 14);
		panel_1.add(lblAaaammdd);
		
		btnSair = new JButton("");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSair.setIcon(new ImageIcon("icons\\icone_sair.png"));
		btnSair.setForeground(new Color(213, 146, 220));
		btnSair.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnSair.setBackground(new Color(29, 10, 31));
		btnSair.setBounds(10, 11, 30, 23);
		btnSair.setBorder(null);
		panel_1.add(btnSair);
	}
	public JTextField getTextNome() {
		return textNome;
	}
	public void setTextNome(JTextField textNome) {
		this.textNome = textNome;
	}
	public JTextField getTextEmail() {
		return textEmail;
	}
	public void setTextEmail(JTextField textEmail) {
		this.textEmail = textEmail;
	}
	public JPasswordField getPasswordFieldUsuario() {
		return passwordFieldUsuario;
	}
	public void setPasswordFieldUsuario(JPasswordField passwordFieldUsuario) {
		this.passwordFieldUsuario = passwordFieldUsuario;
	}
	public JPasswordField getPasswordFieldConfirme() {
		return passwordFieldConfirme;
	}
	public void setPasswordFieldConfirme(JPasswordField passwordFieldConfirme) {
		this.passwordFieldConfirme = passwordFieldConfirme;
	}
	public JComboBox<?> getCbSexo() {
		return cbSexo;
	}
	public void setCbSexo(JComboBox<?> cbSexo) {
		this.cbSexo = cbSexo;
	}
	public JFormattedTextField getFtfTelefone() {
		return ftfTelefone;
	}
	public void setFtfTelefone(JFormattedTextField ftfTelefone) {
		this.ftfTelefone = ftfTelefone;
	}
	public JFormattedTextField getFtfNascimento() {
		return ftfNascimento;
	}
	public void setFtfNascimento(JFormattedTextField ftfNascimento) {
		this.ftfNascimento = ftfNascimento;
	}
	public JButton getBtnSalvar() {
		return btnSalvar;
	}
	public void setBtnSalvar(JButton btnSalvar) {
		this.btnSalvar = btnSalvar;
	}
	public JButton getBtnSair() {
		return btnSair;
	}
	public void setBtnSair(JButton btnSair) {
		this.btnSair = btnSair;
	}
}
