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
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
/**
 * classe com interface grafica do menu de cliente 
 * @author Luigi_IF
 *
 */
@SuppressWarnings("serial")
public class MenuCliente extends JFrame {

	private JPanel contentPane, panel, panel_1;
	private JButton btnPerfil, btnComprarPassagens, btnSair;
	private JLabel lblSpaceMy,lblIcone;
	

	public MenuCliente() throws ParseException {
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
		panel.setBounds(0, 0, 721, 461);
		contentPane.add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		panel_1 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_1, 83, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_1, 164, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_1, -64, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_1, -162, SpringLayout.EAST, panel);
		panel_1.setBackground(new Color(19, 10, 31));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		btnPerfil = new JButton("Perfil");
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {}});
		btnPerfil.setForeground(new Color(213, 146, 220));
		btnPerfil.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnPerfil.setBackground(new Color(82, 29, 88));
		btnPerfil.setBounds(103, 142, 175, 23);
		btnPerfil.setBorder(null);
		panel_1.add(btnPerfil);
		
		btnComprarPassagens = new JButton("Comprar passagem");
		btnComprarPassagens.setBorder(null);
		btnComprarPassagens.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {}});
		btnComprarPassagens.setForeground(new Color(213, 146, 220));
		btnComprarPassagens.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnComprarPassagens.setBackground(new Color(82, 29, 88));
		btnComprarPassagens.setBounds(103, 176, 175, 23);
		panel_1.add(btnComprarPassagens);
		
		btnSair = new JButton("Sair");
		btnSair.setBorder(null);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {}});
		btnSair.setForeground(new Color(213, 146, 220));
		btnSair.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnSair.setBackground(new Color(82, 29, 88));
		btnSair.setBounds(103, 212, 175, 23);
		panel_1.add(btnSair);
		
		lblSpaceMy = new JLabel("SpaceMy");
		lblSpaceMy.setForeground(new Color(213, 146, 220));
		lblSpaceMy.setFont(new Font("Segoe Print", Font.PLAIN, 25));
		lblSpaceMy.setBounds(152, 28, 112, 44);
		panel_1.add(lblSpaceMy);
		
		lblIcone = new JLabel("");
		lblIcone.setIcon(new ImageIcon("icons//icone_Logo.png"));
		lblIcone.setBounds(117, 29, 55, 56);
		panel_1.add(lblIcone);
	}
	public JButton getBtnPerfil() {
		return btnPerfil;
	}
	public void setBtnPerfil(JButton btnPerfil) {
		this.btnPerfil = btnPerfil;
	}
	public JButton getBtnComprarPassagens() {
		return btnComprarPassagens;
	}
	public void setBtnComprarPassagens(JButton btnComprarPassagens) {
		this.btnComprarPassagens = btnComprarPassagens;
	}
	public JButton getBtnSair() {
		return btnSair;
	}
	public void setBtnSair(JButton btnSair) {
		this.btnSair = btnSair;
	}

}
