package view;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
/**
 * classe com interface grafica do menu de funcionario
 * @author Luigi_IF
 *
 */
@SuppressWarnings("serial")
public class MenuFuncionario extends JFrame {

	private JPanel contentPane, panel, panel_2;
	private JButton btnCadNave, btnVisCliente, btnVisAero, btnVisPassagens, btnSair, btnCadVoo, btnVisualizarVoo;
	public JButton getBtnVisualizarVoo() {
		return btnVisualizarVoo;
	}
	public void setBtnVisualizarVoo(JButton btnVisualizarVoo) {
		this.btnVisualizarVoo = btnVisualizarVoo;
	}
	private JLabel lblSpaceMy;
	/**
	 * Create the frame.
	 */
	public MenuFuncionario() {
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
        };;
		panel.setBounds(0, 0, 721, 461);
		contentPane.add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		panel_2 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_2, 83, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_2, 164, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_2, -64, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_2, -162, SpringLayout.EAST, panel);
		panel_2.setBackground(new Color(29, 10, 31));
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		btnCadNave = new JButton("Cadastro de nave");
		btnCadNave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadNave.setForeground(new Color(213, 146, 220));
		btnCadNave.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnCadNave.setBackground(new Color(82, 29, 88));
		btnCadNave.setBounds(108, 75, 175, 23);
		btnCadNave.setBorder(null);
		panel_2.add(btnCadNave);
		
		btnVisCliente = new JButton("Visualizar Clientes");
		btnVisCliente.setBorder(null);
		btnVisCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVisCliente.setForeground(new Color(213, 146, 220));
		btnVisCliente.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnVisCliente.setBackground(new Color(82, 29, 88));
		btnVisCliente.setBounds(108, 142, 175, 23);
		panel_2.add(btnVisCliente);
		
		btnVisAero = new JButton("Visualizar naves\r\n");
		btnVisAero.setBorder(null);
		btnVisAero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnVisAero.setForeground(new Color(213, 146, 220));
		btnVisAero.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnVisAero.setBackground(new Color(82, 29, 88));
		btnVisAero.setBounds(108, 175, 175, 23);
		panel_2.add(btnVisAero);
		
		btnVisPassagens = new JButton("Visualizar passagens");
		btnVisPassagens.setBorder(null);
		btnVisPassagens.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVisPassagens.setForeground(new Color(213, 146, 220));
		btnVisPassagens.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnVisPassagens.setBackground(new Color(82, 29, 88));
		btnVisPassagens.setBounds(108, 208, 175, 23);
		panel_2.add(btnVisPassagens);
		
		btnSair = new JButton("Sair");
		btnSair.setBorder(null);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSair.setForeground(new Color(213, 146, 220));
		btnSair.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnSair.setBackground(new Color(82, 29, 88));
		btnSair.setBounds(108, 271, 175, 23);
		panel_2.add(btnSair);
		
		lblSpaceMy = new JLabel("SpaceMy");
		lblSpaceMy.setForeground(new Color(213, 146, 220));
		lblSpaceMy.setFont(new Font("Segoe Print", Font.PLAIN, 25));
		lblSpaceMy.setBounds(140, 21, 112, 44);
		panel_2.add(lblSpaceMy);
		
		btnCadVoo = new JButton("Cadastro de voo");
		btnCadVoo.setBorder(null);
		btnCadVoo.setForeground(new Color(213, 146, 220));
		btnCadVoo.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnCadVoo.setBackground(new Color(82, 29, 88));
		btnCadVoo.setBounds(108, 108, 175, 23);
		panel_2.add(btnCadVoo);
		
		btnVisualizarVoo = new JButton("Visualizar voos");
		btnVisualizarVoo.setBorder(null);
		btnVisualizarVoo.setForeground(new Color(213, 146, 220));
		btnVisualizarVoo.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnVisualizarVoo.setBackground(new Color(82, 29, 88));
		btnVisualizarVoo.setBounds(108, 239, 175, 23);
		panel_2.add(btnVisualizarVoo);
	}
	
	public JButton getBtnVisAero() {
		return btnVisAero;
	}
	public void setBtnVisAero(JButton btnVisAero) {
		this.btnVisAero = btnVisAero;
	}
	public JButton getBtnCadVoo() {
		return btnCadVoo;
	}
	public void setBtnCadVoo(JButton btnCadVoo) {
		this.btnCadVoo = btnCadVoo;
	}
	public JButton getBtnCadNave() {
		return btnCadNave;
	}
	public void setBtnCadNave(JButton btnCadNave) {
		this.btnCadNave = btnCadNave;
	}
	public JButton getBtnVisCliente() {
		return btnVisCliente;
	}
	public void setBtnVisCliente(JButton btnVisCliente) {
		this.btnVisCliente = btnVisCliente;
	}
	public JButton getBtnVisNave() {
		return btnVisAero;
	}
	public void setBtnVisNave(JButton btnVisAero) {
		this.btnVisAero = btnVisAero;
	}
	public JButton getBtnVisPassagens() {
		return btnVisPassagens;
	}
	public void setBtnVisPassagens(JButton btnVisPassagens) {
		this.btnVisPassagens = btnVisPassagens;
	}
	public JButton getBtnSair() {
		return btnSair;
	}
	public void setBtnSair(JButton btnSair) {
		this.btnSair = btnSair;
	}
}
