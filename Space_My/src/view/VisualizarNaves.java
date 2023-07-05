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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class VisualizarNaves extends JFrame {

	private static final long serialVersionUID = 2850974246745107554L;
	private JPanel contentPane, panelImagem, panel;
	private JTextField textField;
	private JScrollPane scrollPane;
	private JLabel lblBuscarMatricula;
	private JTable tabela;
	private JButton btnBuscar, btnVisualizar, btnExcluir, btnVoltar;
	private JLabel lblSpaceMy;
	private JLabel lblLogo;

	public VisualizarNaves() {
		initComponents();
	}
	public void initComponents() {
		setTitle("AirMy");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 962, 661);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelImagem =  new JPanel() {
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
		panelImagem.setBackground(new Color(255, 255, 255));
		panelImagem.setBounds(0, 0, 953, 624);
		contentPane.add(panelImagem);
		SpringLayout sl_panelImagem = new SpringLayout();
		panelImagem.setLayout(sl_panelImagem);
		
		panel = new JPanel();
		sl_panelImagem.putConstraint(SpringLayout.NORTH, panel, 26, SpringLayout.NORTH, panelImagem);
		sl_panelImagem.putConstraint(SpringLayout.WEST, panel, 22, SpringLayout.WEST, panelImagem);
		sl_panelImagem.putConstraint(SpringLayout.SOUTH, panel, -27, SpringLayout.SOUTH, panelImagem);
		sl_panelImagem.putConstraint(SpringLayout.EAST, panel, -37, SpringLayout.EAST, panelImagem);
		panel.setBackground(new Color(29, 10, 31));
		panelImagem.add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 145, 812, 411);
		panel.add(scrollPane);
		scrollPane.setVisible(false);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textField.setColumns(10);
		textField.setBackground(new Color(226, 181, 232));
		textField.setBounds(140, 82, 298, 20);
		panel.add(textField);
		
		lblBuscarMatricula = new JLabel("Buscar por matrícula:");
		lblBuscarMatricula.setForeground(new Color(213, 146, 220));
		lblBuscarMatricula.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblBuscarMatricula.setBounds(10, 85, 133, 14);
		panel.add(lblBuscarMatricula);
		
		btnBuscar = new JButton("");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuscar.setForeground(new Color(226, 181, 232));
		btnBuscar.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnBuscar.setBackground(new Color(82, 29, 88));
		btnBuscar.setBounds(342, 112, 96, 23);
		btnBuscar.setBorder(null);
		btnBuscar.setIcon(new ImageIcon("icons//icone_busca.png"));
		panel.add(btnBuscar);
		
		btnVisualizar = new JButton("Visualizar todos");
		btnVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVisualizar.setForeground(new Color(226, 181, 232));
		btnVisualizar.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnVisualizar.setBackground(new Color(82, 29, 88));
		btnVisualizar.setBounds(40, 119, 133, 23);
		btnVisualizar.setBorder(null);
		panel.add(btnVisualizar);
		
		btnExcluir = new JButton("");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExcluir.setForeground(new Color(226, 181, 232));
		btnExcluir.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnExcluir.setBackground(new Color(82, 29, 88));
		btnExcluir.setBounds(756, 119, 96, 23);
		btnExcluir.setBorder(null);
		btnExcluir.setIcon(new ImageIcon("icons//icone_excluir.png"));
		panel.add(btnExcluir);
		
		btnVoltar = new JButton("");
		btnVoltar.setIcon(new ImageIcon("icons\\icone_voltar.png"));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVoltar.setForeground(new Color(226, 181, 232));
		btnVoltar.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnVoltar.setBackground(new Color(29, 10, 31));
		btnVoltar.setBounds(10, 10, 32, 32);
		btnVoltar.setBorder(null);
		panel.add(btnVoltar);
		
		lblSpaceMy = new JLabel("SpaceMy");
		lblSpaceMy.setForeground(new Color(213, 146, 220));
		lblSpaceMy.setFont(new Font("Segoe Print", Font.PLAIN, 25));
		lblSpaceMy.setBounds(397, 10, 112, 44);
		panel.add(lblSpaceMy);
		
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("icons\\icone_Logo.png"));
		lblLogo.setBounds(362, 11, 55, 56);
		panel.add(lblLogo);
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
	public JButton getBtnBuscar() {
		return btnBuscar;
	}
	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}
	public JButton getBtnVisualizar() {
		return btnVisualizar;
	}
	public void setBtnVisualizar(JButton btnVisualizar) {
		this.btnVisualizar = btnVisualizar;
	}
	public JButton getBtnExcluir() {
		return btnExcluir;
	}
	public void setBtnExcluir(JButton btnExcluir) {
		this.btnExcluir = btnExcluir;
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

}
