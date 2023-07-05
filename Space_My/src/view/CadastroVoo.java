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
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;


public class CadastroVoo extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane, panel, panel_1;
	private JTextField textValor, textOrinDest;
	private JLabel lblFabricante, lblModelo, lblAno, lblSpaceMy, lblLogo;
	private JButton btnSalvar, btnVoltar;
	private JLabel lblQuantidadeDeAssentos;
	private JTextField textAssentos;
	private JComboBox CbMatricula;

	public CadastroVoo() throws ParseException {
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
		panel.setLayout(null);

		panel_1 = new JPanel();
		panel_1.setBounds(34, 48, 651, 361);
		panel_1.setBackground(new Color(29, 10, 31));
		panel.add(panel_1);
		panel_1.setLayout(null);

		textValor = new JTextField();
		textValor.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textValor.setColumns(10);
		textValor.setBackground(new Color(226, 181, 232));
		textValor.setBounds(310, 156, 214, 20);
		panel_1.add(textValor);

		lblFabricante = new JLabel("Origem/Destino:");
		lblFabricante.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFabricante.setForeground(new Color(213, 146, 220));
		lblFabricante.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblFabricante.setBounds(202, 124, 98, 20);
		panel_1.add(lblFabricante);

		lblModelo = new JLabel("Matricula:");
		lblModelo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblModelo.setForeground(new Color(213, 146, 220));
		lblModelo.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblModelo.setBounds(220, 186, 80, 20);
		panel_1.add(lblModelo);
		lblAno = new JLabel("Valor:");
		lblAno.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAno.setForeground(new Color(213, 146, 220));
		lblAno.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblAno.setBounds(220, 156, 80, 20);
		panel_1.add(lblAno);

		textOrinDest = new JTextField();
		textOrinDest.setBackground(new Color(226, 181, 232));
		textOrinDest.setBounds(310, 126, 214, 20);
		panel_1.add(textOrinDest);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setIcon(new ImageIcon("icons\\icone_salvar.png"));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSalvar.setForeground(new Color(213, 146, 220));
		btnSalvar.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnSalvar.setBackground(new Color(29, 10, 31));
		btnSalvar.setBounds(259, 272, 143, 23);
		btnSalvar.setBorder(null);
		panel_1.add(btnSalvar);

		btnVoltar = new JButton("");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVoltar.setIcon(new ImageIcon("icons\\icone_voltar.png"));
		btnVoltar.setForeground(new Color(213, 146, 220));
		btnVoltar.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnVoltar.setBackground(new Color(19, 10, 31));
		btnVoltar.setBounds(0, 0, 32, 32);
		btnSalvar.setBorder(null);
		panel_1.add(btnVoltar);

		lblSpaceMy = new JLabel("SpaceMy");
		lblSpaceMy.setForeground(new Color(213, 146, 220));
		lblSpaceMy.setFont(new Font("Segoe Print", Font.PLAIN, 25));
		lblSpaceMy.setBounds(294, 10, 112, 44);
		panel_1.add(lblSpaceMy);

		lblLogo = new JLabel("");
		lblLogo.setBounds(259, 11, 55, 56);
		panel_1.add(lblLogo);
		
		lblQuantidadeDeAssentos = new JLabel("Quantidade de assentos:");
		lblQuantidadeDeAssentos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblQuantidadeDeAssentos.setForeground(new Color(213, 146, 220));
		lblQuantidadeDeAssentos.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblQuantidadeDeAssentos.setBounds(147, 214, 153, 20);
		panel_1.add(lblQuantidadeDeAssentos);
		
		textAssentos = new JTextField();
		textAssentos.setBackground(new Color(226, 181, 232));
		textAssentos.setBounds(310, 216, 214, 20);
		panel_1.add(textAssentos);
		
		CbMatricula = new JComboBox();
		CbMatricula.setForeground(new Color(128, 0, 128));
		CbMatricula.setFont(new Font("Tahoma", Font.PLAIN, 16));
		CbMatricula.setBackground(new Color(226, 181, 232));
		CbMatricula.setBounds(310, 186, 214, 22);
		panel_1.add(CbMatricula);
	}

	public JTextField getTextValor() {
		return textValor;
	}

	public void setTextValor(JTextField textValor) {
		this.textValor = textValor;
	}

	public JTextField getTextOrinDest() {
		return textOrinDest;
	}

	public void setTextOrinDest(JTextField textOrinDest) {
		this.textOrinDest = textOrinDest;
	}

	public JButton getBtnSalvar() {
		return btnSalvar;
	}

	public JComboBox getCbMatricula() {
		return CbMatricula;
	}

	public void setCbMatricula(JComboBox cbMatricula) {
		CbMatricula = cbMatricula;
	}

	public void setBtnSalvar(JButton btnSalvar) {
		this.btnSalvar = btnSalvar;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JPanel getPanel_1() {
		return panel_1;
	}

	public void setPanel_1(JPanel panel_1) {
		this.panel_1 = panel_1;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public void setBtnVoltar(JButton btnVoltar) {
		this.btnVoltar = btnVoltar;
	}

	public JTextField getTextAssentos() {
		return textAssentos;
	}

	public void setTextAssentos(JTextField textAssentos) {
		this.textAssentos = textAssentos;
	}
	
}
