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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

public class CadastroNave extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane, panel, panel_1;
	private JTextField textOperador, textFabricante, textModelo, textAssentos, textAno;
	private JLabel lblOperador, lblFabricante, lblModelo, lblAssentos, lblAno, lblSpaceMy;
	private JButton btnSalvar, btnVoltar;

	public CadastroNave() throws ParseException {
		initComponents();
	}

	@SuppressWarnings("serial")
	public void initComponents() throws ParseException {
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
		panel.setBounds(0, 0, 721, 461);
		contentPane.add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		panel_1 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_1, 59, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_1, 50, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_1, -97, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_1, -45, SpringLayout.EAST, panel);
		panel_1.setBackground(new Color(29, 10, 31));
		panel.add(panel_1);
		panel_1.setLayout(null);

		lblOperador = new JLabel("Operador:");
		lblOperador.setForeground(new Color(213, 146, 220));
		lblOperador.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblOperador.setBounds(168, 110, 80, 14);
		panel_1.add(lblOperador);

		textOperador = new JTextField();
		textOperador.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textOperador.setColumns(10);
		textOperador.setBackground(new Color(226, 181, 232));
		textOperador.setBounds(258, 109, 214, 20);
		panel_1.add(textOperador);

		lblFabricante = new JLabel("Fabricante:");
		lblFabricante.setForeground(new Color(213, 146, 220));
		lblFabricante.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblFabricante.setBounds(168, 142, 80, 14);
		panel_1.add(lblFabricante);

		textFabricante = new JTextField();
		textFabricante.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textFabricante.setColumns(10);
		textFabricante.setBackground(new Color(226, 181, 232));
		textFabricante.setBounds(258, 140, 214, 20);
		panel_1.add(textFabricante);

		lblModelo = new JLabel("Modelo:");
		lblModelo.setForeground(new Color(213, 146, 220));
		lblModelo.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblModelo.setBounds(168, 206, 80, 14);
		panel_1.add(lblModelo);

		textModelo = new JTextField();
		textModelo.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textModelo.setColumns(10);
		textModelo.setBackground(new Color(226, 181, 232));
		textModelo.setBounds(258, 203, 90, 20);
		panel_1.add(textModelo);

		lblAssentos = new JLabel("Assentos:");
		lblAssentos.setForeground(new Color(213, 146, 220));
		lblAssentos.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblAssentos.setBounds(168, 235, 80, 14);
		panel_1.add(lblAssentos);

		textAssentos = new JTextField();
		textAssentos.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textAssentos.setColumns(10);
		textAssentos.setBackground(new Color(226, 181, 232));
		textAssentos.setBounds(258, 232, 54, 20);

		panel_1.add(textAssentos);
		lblAno = new JLabel("Ano:");
		lblAno.setForeground(new Color(213, 146, 220));
		lblAno.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblAno.setBounds(168, 175, 80, 14);
		panel_1.add(lblAno);

		textAno = new JTextField();
		textAno.setBackground(new Color(226, 181, 232));
		textAno.setBounds(258, 170, 80, 23);
		panel_1.add(textAno);

		btnSalvar = new JButton("Salvar");

		btnSalvar.setIcon(new ImageIcon("icons//icone_salvar.png"));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSalvar.setForeground(new Color(213, 146, 220));
		btnSalvar.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnSalvar.setBackground(new Color(29, 10, 31));
		btnSalvar.setBounds(490, 263, 126, 32);
		btnSalvar.setBorder(null);
		panel_1.add(btnSalvar);

		lblSpaceMy = new JLabel("SpaceMy");
		lblSpaceMy.setForeground(new Color(213, 146, 220));
		lblSpaceMy.setFont(new Font("Segoe Print", Font.PLAIN, 25));
		lblSpaceMy.setBounds(258, 11, 112, 44);
		panel_1.add(lblSpaceMy);

		btnVoltar = new JButton("");

		btnVoltar.setIcon(new ImageIcon("icons//icone_voltar.png"));
		btnVoltar.setForeground(new Color(213, 146, 220));
		btnVoltar.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnVoltar.setBackground(new Color(29, 10, 31));
		btnVoltar.setBounds(10, 11, 37, 32);
		btnVoltar.setBorder(null);
		panel_1.add(btnVoltar);
	}

	public JTextField getTextOperador() {
		return textOperador;
	}

	public void setTextOperador(JTextField textOperador) {
		this.textOperador = textOperador;
	}

	public JTextField getTextFabricante() {
		return textFabricante;
	}

	public void setTextFabricante(JTextField textFabricante) {
		this.textFabricante = textFabricante;
	}

	public JTextField getTextModelo() {
		return textModelo;
	}

	public void setTextModelo(JTextField textModelo) {
		this.textModelo = textModelo;
	}

	public JTextField getTextAssentos() {
		return textAssentos;
	}

	public void setTextAssentos(JTextField textAssentos) {
		this.textAssentos = textAssentos;
	}

	public JTextField getFtfAno() {
		return textAno;
	}

	public void setFtfAno(JTextField ftfAno) {
		this.textAno = ftfAno;
	}

	public JButton getBtnSalvar() {
		return btnSalvar;
	}

	public void setBtnSalvar(JButton btnSalvar) {
		this.btnSalvar = btnSalvar;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public void setBtnVoltar(JButton btnVoltar) {
		this.btnVoltar = btnVoltar;
	}

}
