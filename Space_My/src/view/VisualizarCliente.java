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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

@SuppressWarnings("serial")
public class VisualizarCliente extends JFrame {

	private static final long serialVersionUID = 6657527154166231126L;
	private JPanel contentPane, panel, panel_2, panelAlterar;
	private JTextField textField, textNome, textEmail;
	private JScrollPane scrollPane;
	private JTable tabela;
	private JLabel lblPesquisar, lblNome, lblSexo, lblTelefone, lblEmail, lblSenha, lblConfirmeSenha, lblSpaceMy, lblLogo;
	private JButton btnVisualizar, btnBuscar, btnExcluir, btnAlterar, btnVoltar, btnSalvar;
	private JComboBox<?> cbSexo;
	private JFormattedTextField ftfTelefone;
	private JPasswordField passwordField, passwordField_2;


	public VisualizarCliente() throws ParseException {
		initComponents();
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void initComponents() throws ParseException {
		setTitle("AirMy");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 1294, 661);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel(){
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
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 1290, 664);
		contentPane.add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		panel_2 =  new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_2, 21, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_2, 20, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_2, -64, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_2, -31, SpringLayout.EAST, panel);
		panel_2.setBackground(new Color(29, 10, 31));
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 142, 812, 411);
		panel_2.add(scrollPane);
		scrollPane.setVisible(false);
		
		textField = new JTextField();
		textField.setForeground(new Color(128, 0, 128));
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textField.setColumns(10);
		textField.setBackground(new Color(226, 181, 232));
		textField.setBounds(113, 66, 298, 20);
		panel_2.add(textField);
		
		lblPesquisar = new JLabel("Buscar por id:");
		lblPesquisar.setForeground(new Color(213, 146, 220));
		lblPesquisar.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblPesquisar.setBounds(10, 69, 96, 14);
		panel_2.add(lblPesquisar);
		
		
		
		btnVisualizar = new JButton("Visualizar todos");
		btnVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
			}});
		btnVisualizar.setForeground(new Color(213, 146, 220));
		btnVisualizar.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnVisualizar.setBackground(new Color(82, 29, 88));
		btnVisualizar.setBounds(10, 119, 133, 23);
		btnVisualizar.setBorder(null);
		panel_2.add(btnVisualizar);
		
		btnBuscar = new JButton("");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {}});
		btnBuscar.setForeground(new Color(213, 146, 220));
		btnBuscar.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnBuscar.setBackground(new Color(82, 29, 88));
		btnBuscar.setBounds(315, 94, 96, 23);
		btnBuscar.setBorder(null);
		btnBuscar.setIcon(new ImageIcon("icons//icone_busca.png"));
		panel_2.add(btnBuscar);
		
		btnExcluir = new JButton("");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {}});
		btnExcluir.setForeground(new Color(213, 146, 220));
		btnExcluir.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnExcluir.setBackground(new Color(82, 29, 88));
		btnExcluir.setBounds(726, 119, 96, 23);
		btnExcluir.setBorder(null);
		btnExcluir.setIcon(new ImageIcon("icons//icone_excluir.png"));
		panel_2.add(btnExcluir);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {}});
		btnAlterar.setForeground(new Color(213, 146, 220));
		btnAlterar.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnAlterar.setBackground(new Color(82, 29, 88));
		btnAlterar.setBounds(623, 119, 96, 23);
		btnAlterar.setBorder(null);
		panel_2.add(btnAlterar);
		
		btnVoltar = new JButton("");
		btnVoltar.setIcon(new ImageIcon("icons//icone_voltar.png"));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {}});
		btnVoltar.setForeground(new Color(213, 146, 220));
		btnVoltar.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnVoltar.setBackground(new Color(19, 10, 31));
		btnVoltar.setBounds(0, 0, 32, 32);
		btnVoltar.setBorder(null);
		panel_2.add(btnVoltar);
		
		lblSpaceMy = new JLabel("SpaceMy");
		lblSpaceMy.setForeground(new Color(213, 146, 220));
		lblSpaceMy.setFont(new Font("Segoe Print", Font.PLAIN, 25));
		lblSpaceMy.setBounds(575, 24, 112, 44);
		panel_2.add(lblSpaceMy);
		
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("icons//icone_Logo.png"));
		lblLogo.setBounds(540, 25, 55, 56);
		panel_2.add(lblLogo);
		
		panelAlterar = new JPanel();
		panelAlterar.setLayout(null);
		panelAlterar.setBackground(new Color(29, 10, 31));
		panelAlterar.setBounds(823, 143, 407, 291);
		panel_2.add(panelAlterar);
		panelAlterar.setVisible(false);
		
		textNome = new JTextField();
		textNome.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textNome.setColumns(10);
		textNome.setBackground(new Color(226, 181, 232));
		textNome.setBounds(118, 41, 281, 20);
		panelAlterar.add(textNome);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textEmail.setColumns(10);
		textEmail.setBackground(new Color(226, 181, 232));
		textEmail.setBounds(118, 145, 281, 20);
		panelAlterar.add(textEmail);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		passwordField.setBackground(new Color(226, 181, 232));
		passwordField.setBounds(118, 175, 281, 20);
		panelAlterar.add(passwordField);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		passwordField_2.setBackground(new Color(226, 181, 232));
		passwordField_2.setBounds(118, 205, 281, 20);
		panelAlterar.add(passwordField_2);
		
		lblNome = new JLabel("Nome:");
		lblNome.setForeground(new Color(213, 146, 220));
		lblNome.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNome.setBounds(10, 44, 66, 14);
		panelAlterar.add(lblNome);
		
		lblSexo = new JLabel("Sexo:");
		lblSexo.setForeground(new Color(213, 146, 220));
		lblSexo.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblSexo.setBounds(10, 78, 66, 14);
		panelAlterar.add(lblSexo);
		
		lblTelefone = new JLabel("Telefone:");
		lblTelefone.setForeground(new Color(213, 146, 220));
		lblTelefone.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblTelefone.setBounds(10, 115, 66, 14);
		panelAlterar.add(lblTelefone);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setForeground(new Color(213, 146, 220));
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblEmail.setBounds(10, 148, 66, 14);
		panelAlterar.add(lblEmail);
		
		lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(new Color(213, 146, 220));
		lblSenha.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblSenha.setBounds(10, 181, 66, 14);
		panelAlterar.add(lblSenha);
		
		lblConfirmeSenha = new JLabel("Confirme senha:");
		lblConfirmeSenha.setForeground(new Color(213, 146, 220));
		lblConfirmeSenha.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblConfirmeSenha.setBounds(10, 208, 99, 14);
		panelAlterar.add(lblConfirmeSenha);
		
		cbSexo = new JComboBox();
		cbSexo.setModel(new DefaultComboBoxModel(new String[] {"Feminino", "Masculino ", "Outro"}));
		cbSexo.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		cbSexo.setBackground(new Color(226, 181, 232));
		cbSexo.setBounds(118, 75, 99, 22);
		panelAlterar.add(cbSexo);
		
		ftfTelefone = new JFormattedTextField(new MaskFormatter("(##)#####-####"));
		ftfTelefone.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		ftfTelefone.setBackground(new Color(226, 181, 232));
		ftfTelefone.setBounds(118, 112, 105, 20);
		panelAlterar.add(ftfTelefone);
		
		btnSalvar = new JButton("");
		btnSalvar.setForeground(new Color(213, 146, 220));
		btnSalvar.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnSalvar.setBackground(new Color(82, 29, 88));
		btnSalvar.setBounds(162, 245, 99, 23);
		btnSalvar.setBorder(null);
		btnSalvar.setIcon(new ImageIcon("icons//icone_salvar.png"));
		panelAlterar.add(btnSalvar);
	}
	
	public JTextField getTextField() {
		return textField;
	}
	public void setTextField(JTextField textField) {
		this.textField = textField;
	}
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}
	public JButton getBtnVisualizar() {
		return btnVisualizar;
	}
	public void setBtnVisualizar(JButton btnVisualizar) {
		this.btnVisualizar = btnVisualizar;
	}
	public JButton getBtnBuscar() {
		return btnBuscar;
	}
	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}
	public JButton getBtnExcluir() {
		return btnExcluir;
	}
	public void setBtnExcluir(JButton btnExcluir) {
		this.btnExcluir = btnExcluir;
	}
	public JButton getBtnAlterar() {
		return btnAlterar;
	}
	public void setBtnAlterar(JButton btnAlterar) {
		this.btnAlterar = btnAlterar;
	}
	public JButton getBtnVoltar() {
		return btnVoltar;
	}
	public void setBtnVoltar(JButton btnVoltar) {
		this.btnVoltar = btnVoltar;
	}
	public JTable getTabela() {
		return tabela;
	}
	public void setTabela(JTable tabela) {
		this.tabela = tabela;
	}
	public JPanel getPanelAlterar() {
		return panelAlterar;
	}
	public void setPanelAlterar(JPanel panelAlterar) {
		this.panelAlterar = panelAlterar;
	}
	public JButton getBtnSalvar() {
		return btnSalvar;
	}
	public void setBtnSalvar(JButton btnSalvar) {
		this.btnSalvar = btnSalvar;
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
	public JPasswordField getPasswordField() {
		return passwordField;
	}
	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}
	public JPasswordField getPasswordField_2() {
		return passwordField_2;
	}
	public void setPasswordField_2(JPasswordField passwordField_2) {
		this.passwordField_2 = passwordField_2;
	}
	
}
