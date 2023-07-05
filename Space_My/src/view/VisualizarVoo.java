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

public class VisualizarVoo extends JFrame{
	private JPanel contentPane,panel,panelImagem;
	private JTextField textField;
	private JButton btnBuscar,btnVisualizar,btnVoltar,btnExcluir;
	private JScrollPane scrollPane;
	private JLabel lblBuscarVoo,lblSpaceMy,lblLogo;
	private JTable tabela;

	
	public VisualizarVoo() {
		initComponents();
	}
	public void initComponents() {
		
		setTitle("AirMy");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 868, 521);
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
		panelImagem.setBounds(0, 0, 852, 482);
		contentPane.add(panelImagem);
		SpringLayout sl_panelImagem = new SpringLayout();
		panelImagem.setLayout(sl_panelImagem);
		
		panel = new JPanel();
		sl_panelImagem.putConstraint(SpringLayout.NORTH, panel, 10, SpringLayout.NORTH, panelImagem);
		sl_panelImagem.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, panelImagem);
		sl_panelImagem.putConstraint(SpringLayout.SOUTH, panel, -10, SpringLayout.SOUTH, panelImagem);
		sl_panelImagem.putConstraint(SpringLayout.EAST, panel, -10, SpringLayout.EAST, panelImagem);
		panel.setBackground(new Color(29, 10, 31));
		panelImagem.add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 189, 812, 241);
		panel.add(scrollPane);
		scrollPane.setVisible(false);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textField.setColumns(10);
		textField.setBackground(new Color(226, 181, 232));
		textField.setBounds(88, 104, 298, 20);
		panel.add(textField);
		
		lblBuscarVoo = new JLabel("Buscar voo");
		lblBuscarVoo.setForeground(new Color(213, 146, 220));
		lblBuscarVoo.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblBuscarVoo.setBounds(10, 104, 79, 17);
		panel.add(lblBuscarVoo);
		
		btnBuscar = new JButton("");
		btnBuscar.setBorder(null);
		btnBuscar.setIcon(new ImageIcon("icons\\icone_busca.png"));
		btnBuscar.setForeground(new Color(226, 181, 232));
		btnBuscar.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnBuscar.setBackground(new Color(82, 29, 88));
		btnBuscar.setBounds(339, 126, 47, 23);
		panel.add(btnBuscar);
		
		btnVisualizar = new JButton("Visualizar voos");
		btnVisualizar.setBorder(null);
		btnVisualizar.setForeground(new Color(226, 181, 232));
		btnVisualizar.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnVisualizar.setBackground(new Color(82, 29, 88));
		btnVisualizar.setBounds(10, 165, 128, 23);
		panel.add(btnVisualizar);
		
		btnVoltar = new JButton("");
		btnVoltar.setIcon(new ImageIcon("icons\\icone_voltar.png"));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVoltar.setForeground(new Color(191, 252, 255));
		btnVoltar.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnVoltar.setBackground(new Color(29, 10, 31));
		btnVoltar.setBounds(0, 0, 32, 32);
		btnVoltar.setBorder(null);
		panel.add(btnVoltar);
		
		lblSpaceMy = new JLabel("SpaceMy");
		lblSpaceMy.setForeground(new Color(213, 146, 220));
		lblSpaceMy.setFont(new Font("Segoe Print", Font.PLAIN, 25));
		lblSpaceMy.setBounds(374, 11, 112, 44);
		panel.add(lblSpaceMy);
		
		lblLogo = new JLabel("");
		lblLogo.setBounds(339, 12, 55, 56);
		panel.add(lblLogo);
		
		btnExcluir = new JButton("");
		btnExcluir.setIcon(new ImageIcon("icons\\icone_excluir.png"));
		btnExcluir.setForeground(new Color(226, 181, 232));
		btnExcluir.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnExcluir.setBorder(null);
		btnExcluir.setBackground(new Color(82, 29, 88));
		btnExcluir.setBounds(726, 165, 96, 23);
		panel.add(btnExcluir);
		
	}
	
	public JButton getBtnExcluir() {
		return btnExcluir;
	}
	public void setBtnExcluir(JButton btnExcluir) {
		this.btnExcluir = btnExcluir;
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
