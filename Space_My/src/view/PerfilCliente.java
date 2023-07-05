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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class PerfilCliente extends JFrame {

	private JPanel contentPane, panel, panel_2;
	private JLabel lblNome, lblTelefone, lblEmail, lblDataDeNascimento, lblSexo, lblSpaceMy, lblLogo;
	private JScrollPane scrollPane;
	private JButton btnVoltar;
	private JTable tabela;
	public PerfilCliente(){
		initConponents();
	}
	public void initConponents(){
		
		setTitle("SpaceMy");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 820, 504);
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
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 804, 472);
		contentPane.add(panel);
		panel.setLayout(null);
		
		panel_2 = new JPanel();
		panel_2.setBounds(62, 10, 656, 441);
		panel_2.setBackground(new Color(19, 10, 31));
		panel.add(panel_2);
		panel_2.setLayout(null);
		panel_2.setVisible(false);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 235, 636, 169);
		panel_2.add(scrollPane);
		scrollPane.setVisible(false);
		
		lblNome = new JLabel("");
		lblNome.setBounds(166, 72, 294, 14);
		lblNome.setForeground(new Color(226, 181, 232));
		lblNome.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_2.add(lblNome);
		
		lblTelefone = new JLabel("");
		lblTelefone.setBounds(166, 96, 294, 14);
		lblTelefone.setForeground(new Color(226, 181, 232));
		lblTelefone.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_2.add(lblTelefone);
		
		lblEmail = new JLabel("");
		lblEmail.setBounds(166, 120, 294, 14);
		lblEmail.setForeground(new Color(226, 181, 232));
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_2.add(lblEmail);
		
		lblDataDeNascimento = new JLabel("");
		lblDataDeNascimento.setBounds(166, 144, 294, 14);
		lblDataDeNascimento.setForeground(new Color(226, 181, 232));
		lblDataDeNascimento.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_2.add(lblDataDeNascimento);
		
		lblSexo = new JLabel("");
		lblSexo.setBounds(166, 168, 294, 14);
		lblSexo.setForeground(new Color(226, 181, 232));
		lblSexo.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_2.add(lblSexo);
		
		lblSpaceMy = new JLabel("SpaceMy");
		lblSpaceMy.setBounds(291, 11, 112, 44);
		lblSpaceMy.setForeground(new Color(213, 146, 220));
		lblSpaceMy.setFont(new Font("Segoe Print", Font.PLAIN, 25));
		panel_2.add(lblSpaceMy);
		
		lblLogo = new JLabel("");
		lblLogo.setBounds(256, 12, 55, 56);
		lblLogo.setIcon(new ImageIcon("icons//icone_Logo.png"));
		panel_2.add(lblLogo);
		
		btnVoltar = new JButton("");
		btnVoltar.setBounds(0, 0, 32, 32);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVoltar.setIcon(new ImageIcon("icons//icone_voltar.png"));
		btnVoltar.setForeground(new Color(213, 146, 220));
		btnVoltar.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnVoltar.setBackground(new Color(19, 10, 31));
		btnVoltar.setBorder(null);
		panel_2.add(btnVoltar);
		
		JLabel lblNome_1 = new JLabel("Nome:");
		lblNome_1.setForeground(new Color(226, 181, 232));
		lblNome_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNome_1.setBounds(10, 72, 55, 14);
		panel_2.add(lblNome_1);
		
		JLabel lblTelefone_1 = new JLabel("Telefone:");
		lblTelefone_1.setForeground(new Color(226, 181, 232));
		lblTelefone_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblTelefone_1.setBounds(10, 96, 66, 14);
		panel_2.add(lblTelefone_1);
		
		JLabel lblEmail_1 = new JLabel("Email:");
		lblEmail_1.setForeground(new Color(226, 181, 232));
		lblEmail_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblEmail_1.setBounds(10, 120, 48, 14);
		panel_2.add(lblEmail_1);
		
		JLabel lblDataDeNascimento_1 = new JLabel("Data de nascimento:");
		lblDataDeNascimento_1.setForeground(new Color(226, 181, 232));
		lblDataDeNascimento_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblDataDeNascimento_1.setBounds(10, 144, 126, 14);
		panel_2.add(lblDataDeNascimento_1);
		
		JLabel lblSexo_1 = new JLabel("Sexo:");
		lblSexo_1.setForeground(new Color(226, 181, 232));
		lblSexo_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblSexo_1.setBounds(10, 168, 99, 14);
		panel_2.add(lblSexo_1);
		
		JLabel lblMinhasReservas = new JLabel("Minhas reservas:");
		lblMinhasReservas.setForeground(new Color(226, 181, 232));
		lblMinhasReservas.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblMinhasReservas.setBounds(10, 211, 99, 14);
		panel_2.add(lblMinhasReservas);
	}
	public JButton getBtnVoltar() {
		return btnVoltar;
	}
	public void setBtnVoltar(JButton btnVoltar) {
		this.btnVoltar = btnVoltar;
	}
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}
	
	public JLabel getLblNome() {
		return lblNome;
	}
	public void setLblNome(JLabel lblNome) {
		this.lblNome = lblNome;
	}
	public JLabel getLblTelefone() {
		return lblTelefone;
	}
	public void setLblTelefone(JLabel lblTelefone) {
		this.lblTelefone = lblTelefone;
	}
	public JLabel getLblEmail() {
		return lblEmail;
	}
	public void setLblEmail(JLabel lblEmail) {
		this.lblEmail = lblEmail;
	}
	public JLabel getLblDataDeNascimento() {
		return lblDataDeNascimento;
	}
	public void setLblDataDeNascimento(JLabel lblDataDeNascimento) {
		this.lblDataDeNascimento = lblDataDeNascimento;
	}
	public JLabel getLblSexo() {
		return lblSexo;
	}
	public void setLblSexo(JLabel lblSexo) {
		this.lblSexo = lblSexo;
	}
	public JLabel getLblSpaceMy() {
		return lblSpaceMy;
	}
	public void setLblSpaceMy(JLabel lblSpaceMy) {
		this.lblSpaceMy = lblSpaceMy;
	}
	public JLabel getLblLogo() {
		return lblLogo;
	}
	public void setLblLogo(JLabel lblLogo) {
		this.lblLogo = lblLogo;
	}
	
	public JPanel getPanel_2() {
		return panel_2;
	}
	public void setPanel_2(JPanel panel_2) {
		this.panel_2 = panel_2;
	}
	public JTable getTabela() {
		return tabela;
	}
	public void setTabela(JTable tabela) {
		this.tabela = tabela;
	}
}
