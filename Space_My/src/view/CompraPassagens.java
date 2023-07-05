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
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
/**
 * classe com interface grafica de compra de passagens
 * @author Luigi_IF
 *
 */


@SuppressWarnings("serial")
public class CompraPassagens extends JFrame {

	private JPanel contentPane, panelComImagem,panelDaReserva, panelPagamento;
	@SuppressWarnings("rawtypes")
	private JComboBox CbOrigem;
	private JLabel lblOrigem_Destino,lblSpaceMy, lblLogo,lblDataDePartida,lblValidade,lbldadoscompra,lblAaaammdd,
				   lblNome,lblOrigem_destino1,lblMatriculaDaNave,lblData,lblNumeroDoVoo,lblValor,lblNumeroDoCarto,
				   lblFuncao,lblNome_2,lblOrigem_destino1_1,lblMatriculaDaNave_1,lblData_1,lblNumeroDoVoo_1,
				   lblValor_1,lblCvv,lblNomeCartao;
	private JButton btnContinuar, btnVisualizarVoos, btnComprar ;
	private JScrollPane scrollPane;
	private JFormattedTextField ftfDataPartida,ftfValidade, fttCVV, ftfNumCartao;
	private JTable tabela;
	private JTextField textNome;
	private JComboBox CbFuncao;
	private JButton btnVoltar;
	private JPanel panel_3;
	private JPanel panel_4;
	private JButton btnReservar;
	private JComboBox CbAssento;
	private JLabel lblEscolhaUmAssento;
	private JLabel lblAssento;
	private JLabel lblAssento_2;
	


	public CompraPassagens() throws Exception {
		initComponents();
	}
	public void initComponents() throws Exception {
		
		setTitle("AirMy");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 1109, 653);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelComImagem = new JPanel() {
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
		panelComImagem.setBackground(new Color(255, 255, 255));
		panelComImagem.setBounds(0, 0, 1095, 620);
		contentPane.add(panelComImagem);
		panelComImagem.setLayout(null);
		
		panelDaReserva = new JPanel();
		panelDaReserva.setBounds(31, 26, 1016, 552);
		panelDaReserva.setBackground(new Color(20, 10, 31));
		panelComImagem.add(panelDaReserva);
		panelDaReserva.setLayout(null);
		
		CbOrigem = new JComboBox();
		CbOrigem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		CbOrigem.setBounds(228, 333, 248, 22);
		CbOrigem.setForeground(new Color(128, 0, 128));
		CbOrigem.setBackground(new Color(226, 181, 232));
		panelDaReserva.add(CbOrigem);
		
		lblOrigem_Destino = new JLabel("Origem/Destino:");
		lblOrigem_Destino.setBounds(101, 333, 104, 20);
		lblOrigem_Destino.setForeground(new Color(213, 146, 220));
		lblOrigem_Destino.setBackground(new Color(255, 255, 255));
		lblOrigem_Destino.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panelDaReserva.add(lblOrigem_Destino);
		
		btnContinuar = new JButton("Continuar");
		btnContinuar.setIcon(new ImageIcon("C:\\Users\\Yasmine.if\\Downloads\\Space_My2\\Space_My\\icons\\icone_salvar.png"));
		btnContinuar.setBounds(319, 436, 145, 23);
		btnContinuar.setForeground(new Color(226, 181, 232));
		btnContinuar.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnContinuar.setBackground(new Color(82, 29, 88));
		btnContinuar.setBorder(null);
		panelDaReserva.add(btnContinuar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(91, 100, 589, 222);
		panelDaReserva.add(scrollPane);
		scrollPane.setVisible(false);
		
		lblSpaceMy = new JLabel("SpaceMy");
		lblSpaceMy.setBounds(538, 10, 112, 44);
		lblSpaceMy.setForeground(new Color(213, 146, 220));
		lblSpaceMy.setFont(new Font("Segoe Print", Font.PLAIN, 25));
		panelDaReserva.add(lblSpaceMy);
		
		lblLogo = new JLabel("");
		lblLogo.setBounds(506, 10, 55, 56);
		lblLogo.setIcon(new ImageIcon("icons\\icone_Logo.png"));
		panelDaReserva.add(lblLogo);
		
		btnVisualizarVoos = new JButton("Visualizar voos");
		btnVisualizarVoos.setBounds(91, 76, 133, 23);
		btnVisualizarVoos.setForeground(new Color(213, 146, 220));
		btnVisualizarVoos.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnVisualizarVoos.setBackground(new Color(82, 29, 88));
		btnVisualizarVoos.setBorder(null);
		panelDaReserva.add(btnVisualizarVoos);
		
		ftfDataPartida = new JFormattedTextField(new MaskFormatter("####/##/##"));
		ftfDataPartida.setBounds(227, 365, 104, 22);
		ftfDataPartida.setForeground(new Color(128, 0, 128));
		panelDaReserva.add(ftfDataPartida);
		ftfDataPartida.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		ftfDataPartida.setBackground(new Color(226, 181, 232));
		
		lblDataDePartida = new JLabel("Data de Partida:\r\n");
		lblDataDePartida.setBounds(101, 366, 104, 20);
		panelDaReserva.add(lblDataDePartida);
		lblDataDePartida.setForeground(new Color(213, 146, 220));
		lblDataDePartida.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblDataDePartida.setBackground(Color.WHITE);
		
		lblAaaammdd = new JLabel("AAAA/MM/DD");
		lblAaaammdd.setForeground(new Color(213, 146, 220));
		lblAaaammdd.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblAaaammdd.setBounds(334, 371, 120, 14);
		panelDaReserva.add(lblAaaammdd);
		
		btnVoltar = new JButton("");
		btnVoltar.setIcon(new ImageIcon("icons\\icone_voltar.png"));
		btnVoltar.setForeground(new Color(213, 146, 220));
		btnVoltar.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnVoltar.setBackground(new Color(29, 10, 31));
		btnVoltar.setBounds(10, 28, 32, 32);
		btnVoltar.setBorder(null);
		panelDaReserva.add(btnVoltar);
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(20, 10, 31));
		panel_3.setBounds(722, 57, 248, 360);
		panelDaReserva.add(panel_3);
		
		panel_4 = new JPanel();
		panel_4.setBackground(new Color(20, 10, 31));
		panel_4.setBounds(741, 423, 218, 96);
		panelDaReserva.add(panel_4);
		panel_4.setLayout(null);
		panel_4.setVisible(false);
		
		btnReservar = new JButton("Reservar");
		btnReservar.setBounds(31, 59, 148, 27);
		btnReservar.setForeground(new Color(226, 181, 232));
		btnReservar.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnReservar.setBackground(new Color(82, 29, 88));
		btnReservar.setBorder(null);
		panel_4.add(btnReservar);
		
		CbAssento = new JComboBox();
		CbAssento.setForeground(new Color(128, 0, 128));
		CbAssento.setFont(new Font("Tahoma", Font.PLAIN, 16));
		CbAssento.setBackground(new Color(226, 181, 232));
		CbAssento.setBounds(10, 27, 185, 22);
		panel_4.add(CbAssento);
		
		lblEscolhaUmAssento = new JLabel("Escolha um assento:");
		lblEscolhaUmAssento.setForeground(new Color(213, 146, 220));
		lblEscolhaUmAssento.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblEscolhaUmAssento.setBackground(Color.WHITE);
		lblEscolhaUmAssento.setBounds(10, 10, 169, 20);
		panel_4.add(lblEscolhaUmAssento);
		
		panelPagamento = new JPanel();
		panelPagamento.setBounds(101, 57, 587, 449);
		panelDaReserva.add(panelPagamento);
		panelPagamento.setBackground(new Color(20, 10, 31));
		panelPagamento.setVisible(false);
		
		btnComprar = new JButton("Finalizar comprar");
		btnComprar.setBounds(230, 382, 149, 27);
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panelPagamento.setLayout(null);
		btnComprar.setForeground(new Color(226, 181, 232));
		btnComprar.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnComprar.setBackground(new Color(128, 0, 128));
		btnComprar.setBorder(null);
		panelPagamento.add(btnComprar);
		
		lbldadoscompra = new JLabel("Dados da compras");
		lbldadoscompra.setForeground(new Color(213, 146, 220));
		lbldadoscompra.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbldadoscompra.setBackground(Color.WHITE);
		lbldadoscompra.setBounds(224, 10, 174, 20);
		panelPagamento.add(lbldadoscompra);
		
		lblNome = new JLabel("Nome:");
		lblNome.setForeground(new Color(213, 146, 220));
		lblNome.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNome.setBounds(10, 55, 148, 14);
		panelPagamento.add(lblNome);
		
		lblOrigem_destino1 = new JLabel("Origem/destino:");
		lblOrigem_destino1.setForeground(new Color(213, 146, 220));
		lblOrigem_destino1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblOrigem_destino1.setBounds(10, 79, 148, 14);
		panelPagamento.add(lblOrigem_destino1);
		
		lblMatriculaDaNave = new JLabel("Matricula da nave:");
		lblMatriculaDaNave.setForeground(new Color(213, 146, 220));
		lblMatriculaDaNave.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblMatriculaDaNave.setBounds(10, 103, 148, 14);
		panelPagamento.add(lblMatriculaDaNave);
		
		lblData = new JLabel("Data:");
		lblData.setForeground(new Color(213, 146, 220));
		lblData.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblData.setBounds(10, 127, 148, 14);
		panelPagamento.add(lblData);
		
		lblNumeroDoVoo = new JLabel("Numero: do voo:");
		lblNumeroDoVoo.setForeground(new Color(213, 146, 220));
		lblNumeroDoVoo.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNumeroDoVoo.setBounds(10, 151, 148, 14);
		panelPagamento.add(lblNumeroDoVoo);
		
		lblValor = new JLabel("Valor:");
		lblValor.setForeground(new Color(213, 146, 220));
		lblValor.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblValor.setBounds(10, 175, 148, 14);
		panelPagamento.add(lblValor);
		
		lblNumeroDoCarto = new JLabel("Numero do cartão");
		lblNumeroDoCarto.setForeground(new Color(213, 146, 220));
		lblNumeroDoCarto.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNumeroDoCarto.setBounds(129, 218, 118, 14);
		panelPagamento.add(lblNumeroDoCarto);
		
		lblValidade = new JLabel("Validade");
		lblValidade.setForeground(new Color(213, 146, 220));
		lblValidade.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblValidade.setBounds(129, 271, 73, 14);
		panelPagamento.add(lblValidade);
		
		lblCvv = new JLabel("CVV");
		lblCvv.setForeground(new Color(213, 146, 220));
		lblCvv.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblCvv.setBounds(240, 271, 46, 14);
		panelPagamento.add(lblCvv);
		
		ftfValidade = new JFormattedTextField(new MaskFormatter("####/##/##"));
		ftfValidade.setForeground(new Color(128, 0, 128));
		ftfValidade.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		ftfValidade.setBackground(new Color(226, 181, 232));
		ftfValidade.setBounds(129, 290, 78, 22);
		panelPagamento.add(ftfValidade);
		
		fttCVV = new JFormattedTextField(new MaskFormatter("###"));
		fttCVV.setForeground(new Color(128, 0, 128));
		fttCVV.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fttCVV.setBackground(new Color(226, 181, 232));
		fttCVV.setBounds(240, 290, 83, 22);
		panelPagamento.add(fttCVV);
		
		lblNomeCartao = new JLabel("Nome");
		lblNomeCartao.setForeground(new Color(213, 146, 220));
		lblNomeCartao.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNomeCartao.setBounds(129, 327, 118, 14);
		panelPagamento.add(lblNomeCartao);
		
		ftfNumCartao = new JFormattedTextField(new MaskFormatter("#### #### #### ####"));
		ftfNumCartao.setForeground(new Color(128, 0, 128));
		ftfNumCartao.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		ftfNumCartao.setBackground(new Color(226, 181, 232));
		ftfNumCartao.setBounds(129, 242, 305, 22);
		panelPagamento.add(ftfNumCartao);
		
		textNome = new JTextField();
		textNome.setForeground(new Color(128, 0, 128));
		textNome.setBackground(new Color(226, 181, 232));
		textNome.setBounds(129, 345, 317, 20);
		panelPagamento.add(textNome);
		textNome.setColumns(10);
		
		CbFuncao = new JComboBox();
		CbFuncao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		CbFuncao.setModel(new DefaultComboBoxModel(new String[] {"Débito", "Crédito"}));
		CbFuncao.setForeground(new Color(128, 0, 128));
		CbFuncao.setBackground(new Color(226, 181, 232));
		CbFuncao.setBounds(333, 291, 104, 22);
		panelPagamento.add(CbFuncao);
		
		lblFuncao = new JLabel("Função");
		lblFuncao.setForeground(new Color(213, 146, 220));
		lblFuncao.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblFuncao.setBounds(333, 271, 46, 14);
		panelPagamento.add(lblFuncao);
		
		lblNome_2 = new JLabel("");
		lblNome_2.setForeground(new Color(213, 146, 220));
		lblNome_2.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNome_2.setBounds(168, 55, 346, 14);
		panelPagamento.add(lblNome_2);
		
		lblOrigem_destino1_1 = new JLabel("");
		lblOrigem_destino1_1.setForeground(new Color(213, 146, 220));
		lblOrigem_destino1_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblOrigem_destino1_1.setBounds(168, 79, 346, 14);
		panelPagamento.add(lblOrigem_destino1_1);
		
		lblMatriculaDaNave_1 = new JLabel("");
		lblMatriculaDaNave_1.setForeground(new Color(213, 146, 220));
		lblMatriculaDaNave_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblMatriculaDaNave_1.setBounds(168, 103, 346, 14);
		panelPagamento.add(lblMatriculaDaNave_1);
		
		lblData_1 = new JLabel("");
		lblData_1.setForeground(new Color(213, 146, 220));
		lblData_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblData_1.setBounds(168, 127, 346, 14);
		panelPagamento.add(lblData_1);
		
		lblNumeroDoVoo_1 = new JLabel("");
		lblNumeroDoVoo_1.setForeground(new Color(213, 146, 220));
		lblNumeroDoVoo_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNumeroDoVoo_1.setBounds(168, 151, 346, 14);
		panelPagamento.add(lblNumeroDoVoo_1);
		
		lblValor_1 = new JLabel("");
		lblValor_1.setForeground(new Color(213, 146, 220));
		lblValor_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblValor_1.setBounds(168, 175, 346, 14);
		panelPagamento.add(lblValor_1);
		
		lblAssento = new JLabel("Valor:");
		lblAssento.setForeground(new Color(213, 146, 220));
		lblAssento.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblAssento.setBounds(10, 199, 148, 14);
		panelPagamento.add(lblAssento);
		
		lblAssento_2 = new JLabel("");
		lblAssento_2.setForeground(new Color(213, 146, 220));
		lblAssento_2.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblAssento_2.setBounds(168, 199, 346, 14);
		panelPagamento.add(lblAssento_2);
		
		
	}
	
	public JLabel getLblAssento_2() {
		return lblAssento_2;
	}
	public void setLblAssento_2(JLabel lblAssento_2) {
		this.lblAssento_2 = lblAssento_2;
	}
	public JPanel getPanelComImagem() {
		return panelComImagem;
	}
	public void setPanelComImagem(JPanel panelComImagem) {
		this.panelComImagem = panelComImagem;
	}
	public JPanel getPanelDaReserva() {
		return panelDaReserva;
	}
	public void setPanelDaReserva(JPanel panelDaReserva) {
		this.panelDaReserva = panelDaReserva;
	}
	public JPanel getPanelPagamento() {
		return panelPagamento;
	}
	public void setPanelPagamento(JPanel panelPagamento) {
		this.panelPagamento = panelPagamento;
	}
	public  JComboBox getCbOrigem() {
		return CbOrigem;
	}
	public  void setCbOrigem(JComboBox cbOrigem) {
		CbOrigem = cbOrigem;
	}
	public JLabel getLblOrigem_Destino() {
		return lblOrigem_Destino;
	}
	public void setLblOrigem_Destino(JLabel lblOrigem_Destino) {
		this.lblOrigem_Destino = lblOrigem_Destino;
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
	public JLabel getLblDataDePartida() {
		return lblDataDePartida;
	}
	public void setLblDataDePartida(JLabel lblDataDePartida) {
		this.lblDataDePartida = lblDataDePartida;
	}
	public JLabel getLblValidade() {
		return lblValidade;
	}
	public void setLblValidade(JLabel lblValidade) {
		this.lblValidade = lblValidade;
	}
	public JLabel getLbldadoscompra() {
		return lbldadoscompra;
	}
	public void setLbldadoscompra(JLabel lbldadoscompra) {
		this.lbldadoscompra = lbldadoscompra;
	}
	public JLabel getLblAaaammdd() {
		return lblAaaammdd;
	}
	public void setLblAaaammdd(JLabel lblAaaammdd) {
		this.lblAaaammdd = lblAaaammdd;
	}
	public JLabel getLblNome() {
		return lblNome;
	}
	public void setLblNome(JLabel lblNome) {
		this.lblNome = lblNome;
	}
	public JLabel getLblOrigem_destino1() {
		return lblOrigem_destino1;
	}
	public void setLblOrigem_destino1(JLabel lblOrigem_destino1) {
		this.lblOrigem_destino1 = lblOrigem_destino1;
	}
	public JLabel getLblMatriculaDaNave() {
		return lblMatriculaDaNave;
	}
	public void setLblMatriculaDaNave(JLabel lblMatriculaDaNave) {
		this.lblMatriculaDaNave = lblMatriculaDaNave;
	}
	public JLabel getLblData() {
		return lblData;
	}
	public void setLblData(JLabel lblData) {
		this.lblData = lblData;
	}
	public JLabel getLblNumeroDoVoo() {
		return lblNumeroDoVoo;
	}
	public void setLblNumeroDoVoo(JLabel lblNumeroDoVoo) {
		this.lblNumeroDoVoo = lblNumeroDoVoo;
	}
	public JLabel getLblValor() {
		return lblValor;
	}
	public void setLblValor(JLabel lblValor) {
		this.lblValor = lblValor;
	}
	public JLabel getLblNumeroDoCarto() {
		return lblNumeroDoCarto;
	}
	public void setLblNumeroDoCarto(JLabel lblNumeroDoCarto) {
		this.lblNumeroDoCarto = lblNumeroDoCarto;
	}
	public JLabel getLblFuncao() {
		return lblFuncao;
	}
	public void setLblFuncao(JLabel lblFuncao) {
		this.lblFuncao = lblFuncao;
	}
	public JLabel getLblNome_2() {
		return lblNome_2;
	}
	public void setLblNome_2(JLabel lblNome_2) {
		this.lblNome_2 = lblNome_2;
	}
	public JLabel getLblOrigem_destino1_1() {
		return lblOrigem_destino1_1;
	}
	public void setLblOrigem_destino1_1(JLabel lblOrigem_destino1_1) {
		this.lblOrigem_destino1_1 = lblOrigem_destino1_1;
	}
	public JLabel getLblMatriculaDaNave_1() {
		return lblMatriculaDaNave_1;
	}
	public void setLblMatriculaDaNave_1(JLabel lblMatriculaDaNave_1) {
		this.lblMatriculaDaNave_1 = lblMatriculaDaNave_1;
	}
	public JLabel getLblData_1() {
		return lblData_1;
	}
	public void setLblData_1(JLabel lblData_1) {
		this.lblData_1 = lblData_1;
	}
	public JLabel getLblNumeroDoVoo_1() {
		return lblNumeroDoVoo_1;
	}
	public void setLblNumeroDoVoo_1(JLabel lblNumeroDoVoo_1) {
		this.lblNumeroDoVoo_1 = lblNumeroDoVoo_1;
	}
	public JLabel getLblValor_1() {
		return lblValor_1;
	}
	public void setLblValor_1(JLabel lblValor_1) {
		this.lblValor_1 = lblValor_1;
	}
	public JLabel getLblCvv() {
		return lblCvv;
	}
	public void setLblCvv(JLabel lblCvv) {
		this.lblCvv = lblCvv;
	}
	public JLabel getLblNomeCartao() {
		return lblNomeCartao;
	}
	public void setLblNomeCartao(JLabel lblNomeCartao) {
		this.lblNomeCartao = lblNomeCartao;
	}
	public JButton getBtnContinuar() {
		return btnContinuar;
	}
	public void setBtnContinuar(JButton btnContinuar) {
		this.btnContinuar = btnContinuar;
	}
	public JButton getBtnVisualizarVoos() {
		return btnVisualizarVoos;
	}
	public void setBtnVisualizarVoos(JButton btnVisualizarVoos) {
		this.btnVisualizarVoos = btnVisualizarVoos;
	}
	public JButton getBtnComprar() {
		return btnComprar;
	}
	public void setBtnComprar(JButton btnComprar) {
		this.btnComprar = btnComprar;
	}
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}
	public JFormattedTextField getFtfDataPartida() {
		return ftfDataPartida;
	}
	public void setFtfDataPartida(JFormattedTextField ftfDataPartida) {
		this.ftfDataPartida = ftfDataPartida;
	}
	public JFormattedTextField getFtfValidade() {
		return ftfValidade;
	}
	public void setFtfValidade(JFormattedTextField ftfValidade) {
		this.ftfValidade = ftfValidade;
	}
	public JFormattedTextField getFttCVV() {
		return fttCVV;
	}
	public void setFttCVV(JFormattedTextField fttCVV) {
		this.fttCVV = fttCVV;
	}
	public JFormattedTextField getFtfNumCartao() {
		return ftfNumCartao;
	}
	public void setFtfNumCartao(JFormattedTextField ftfNumCartao) {
		this.ftfNumCartao = ftfNumCartao;
	}
	public JTable getTabela() {
		return tabela;
	}
	public void setTabela(JTable tabela) {
		this.tabela = tabela;
	}
	public JTextField getTextNome() {
		return textNome;
	}
	public void setTextNome(JTextField textNome) {
		this.textNome = textNome;
	}
	public JComboBox getCbFuncao() {
		return CbFuncao;
	}
	public void setCbFuncao(JComboBox cbFuncao) {
		CbFuncao = cbFuncao;
	}
	public JButton getBtnVoltar() {
		return btnVoltar;
	}
	public void setBtnVoltar(JButton btnVoltar) {
		this.btnVoltar = btnVoltar;
	}
	public  JPanel getPanel_3() {
		return panel_3;
	}
	public void setPanel_3(JPanel panel_3) {
		this.panel_3 = panel_3;
	}
	public JPanel getPanel_4() {
		return panel_4;
	}
	public void setPanel_4(JPanel panel_4) {
		this.panel_4 = panel_4;
	}
	public JButton getBtnReservar() {
		return btnReservar;
	}
	public void setBtnReservar(JButton btnReservar) {
		this.btnReservar = btnReservar;
	}
	public JComboBox getCbAssento() {
		return CbAssento;
	}
	public void setCbAssento(JComboBox cbAssento) {
		CbAssento = cbAssento;
	}
	public JLabel getLblEscolhaUmAssento() {
		return lblEscolhaUmAssento;
	}
	public void setLblEscolhaUmAssento(JLabel lblEscolhaUmAssento) {
		this.lblEscolhaUmAssento = lblEscolhaUmAssento;
	}
	
	
}
