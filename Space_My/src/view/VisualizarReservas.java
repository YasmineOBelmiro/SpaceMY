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
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

public class VisualizarReservas extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane, panel,panel_1;
	private JLabel lblBuscarMatricula,lblSpaceMy,lblLogo;
	private JTextField textField;
	private JButton btnBuscar,btnVisualizar, btnVoltar;
	private JScrollPane scrollPane;
	private JTable tabela;
	private JButton btnExcluir;
	
	public VisualizarReservas() {
		initiComponents();
	}
	public void initiComponents() {
		setTitle("AirMy");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 868, 521);
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
		panel.setBounds(0, 0, 852, 482);
		contentPane.add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		panel_1 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_1, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_1, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_1, -10, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_1, -10, SpringLayout.EAST, panel);
		panel_1.setBackground(new Color(29, 10, 31));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 189, 812, 241);
		panel_1.add(scrollPane);
		scrollPane.setVisible(false);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textField.setColumns(10);
		textField.setBackground(new Color(226, 181, 232));
		textField.setBounds(129, 102, 298, 20);
		panel_1.add(textField);
		
		lblBuscarMatricula = new JLabel("Buscar Passagem");
		lblBuscarMatricula.setForeground(new Color(213, 146, 220));
		lblBuscarMatricula.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblBuscarMatricula.setBounds(10, 104, 109, 17);
		panel_1.add(lblBuscarMatricula);
		
		btnBuscar = new JButton("");
		btnBuscar.setBorder(null);
		btnBuscar.setIcon(new ImageIcon("icons\\icone_busca.png"));
		btnBuscar.setForeground(new Color(226, 181, 232));
		btnBuscar.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnBuscar.setBackground(new Color(82, 29, 88));
		btnBuscar.setBounds(380, 124, 47, 23);
		panel_1.add(btnBuscar);
		
		btnVisualizar = new JButton("Visualizar todos");
		btnVisualizar.setBorder(null);
		btnVisualizar.setForeground(new Color(226, 181, 232));
		btnVisualizar.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnVisualizar.setBackground(new Color(82, 29, 88));
		btnVisualizar.setBounds(10, 165, 133, 23);
		panel_1.add(btnVisualizar);
		
		btnVoltar = new JButton("");
		btnVoltar.setIcon(new ImageIcon("icons//icone_voltar.png"));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVoltar.setForeground(new Color(191, 252, 255));
		btnVoltar.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnVoltar.setBackground(new Color(29, 10, 31));
		btnVoltar.setBorder(null);
		btnVoltar.setBounds(0, 0, 32, 32);
		panel_1.add(btnVoltar);
		
		lblSpaceMy = new JLabel("SpaceMy");
		lblSpaceMy.setForeground(new Color(213, 146, 220));
		lblSpaceMy.setFont(new Font("Segoe Print", Font.PLAIN, 25));
		lblSpaceMy.setBounds(374, 11, 112, 44);
		panel_1.add(lblSpaceMy);
		
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("icons//icone_Logo.png"));
		lblLogo.setBounds(339, 12, 55, 56);
		panel_1.add(lblLogo);
		
		btnExcluir = new JButton("");
		btnExcluir.setIcon(new ImageIcon("icons\\icone_excluir.png"));
		btnExcluir.setForeground(new Color(226, 181, 232));
		btnExcluir.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnExcluir.setBorder(null);
		btnExcluir.setBackground(new Color(82, 29, 88));
		btnExcluir.setBounds(726, 165, 96, 23);
		panel_1.add(btnExcluir);
	}
	public JButton getBtnExcluir() {
		return btnExcluir;
	}
	public void setBtnExcluir(JButton btnExcluir) {
		this.btnExcluir = btnExcluir;
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
	public JTextField getTextField() {
		return textField;
	}
	public void setTextField(JTextField textField) {
		this.textField = textField;
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
	public JTable getTabela() {
		return tabela;
	}
	public void setTabela(JTable tabela) {
		this.tabela = tabela;
	}
	

}
