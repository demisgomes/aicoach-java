package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dominio.ButtonAiCoach;
import dominio.Posicao;
import dominio.Tatica;
import dominio.Time;

import javax.swing.JButton;
import javax.swing.JTextField;

import negocio.controller.Fachada;

import controle.ControladorCadastroTatica;

import perssistencia.TaticaDAO;
import perssistencia.TimeDAO;

public class TelaCriarTatica extends JFrame {

	private JPanel contentPane;
	private static ButtonAiCoach btnGL,btnZc_2,btnZc,btnLd,btnZc_1,btnLe,btnVol,btnVol_1,btnVol_2,btnLd_1,
	btnLe_1,btnMld,btnMc,btnMc_1,btnMc_2,btnMle,btnMle_1,btnMat_2,btnMat_1,btnMat,btnMld_1,btnPte,btnSa_1,
	btnCa,btnPtd;
	private static JButton btnNewButton,btnVoltar;
	private static ArrayList<Posicao> listaPosicaoTaticaNova =  new ArrayList<Posicao>();
	private static JTextField textField;
	

	public static JTextField getTextField() {
		return textField;
	}

	public static void setTextField(JTextField textField) {
		TelaCriarTatica.textField = textField;
	}

	public static JButton getBtnNewButton() {
		return btnNewButton;
	}

	public static void setBtnNewButton(JButton btnNewButton) {
		TelaCriarTatica.btnNewButton = btnNewButton;
	}

	public static JButton getBtnVoltar() {
		return btnVoltar;
	}

	public static void setBtnVoltar(JButton btnVoltar) {
		TelaCriarTatica.btnVoltar = btnVoltar;
	}

	public static ArrayList<Posicao> getListaPosicaoTaticaNova() {
		return listaPosicaoTaticaNova;
	}

	public static void setListaPosicaoTaticaNova(
			ArrayList<Posicao> listaPosicaoTaticaNova) {
		TelaCriarTatica.listaPosicaoTaticaNova = listaPosicaoTaticaNova;
	}

	public static ButtonAiCoach getBtnGL() {
		return btnGL;
	}

	public static void setBtnGL(ButtonAiCoach btnGL) {
		TelaCriarTatica.btnGL = btnGL;
	}

	public static ButtonAiCoach getBtnZc_2() {
		return btnZc_2;
	}

	public static void setBtnZc_2(ButtonAiCoach btnZc_2) {
		TelaCriarTatica.btnZc_2 = btnZc_2;
	}

	public static ButtonAiCoach getBtnZc() {
		return btnZc;
	}

	public static void setBtnZc(ButtonAiCoach btnZc) {
		TelaCriarTatica.btnZc = btnZc;
	}

	public static ButtonAiCoach getBtnLd() {
		return btnLd;
	}

	public static void setBtnLd(ButtonAiCoach btnLd) {
		TelaCriarTatica.btnLd = btnLd;
	}

	public static ButtonAiCoach getBtnZc_1() {
		return btnZc_1;
	}

	public static void setBtnZc_1(ButtonAiCoach btnZc_1) {
		TelaCriarTatica.btnZc_1 = btnZc_1;
	}

	public static ButtonAiCoach getBtnLe() {
		return btnLe;
	}

	public static void setBtnLe(ButtonAiCoach btnLe) {
		TelaCriarTatica.btnLe = btnLe;
	}

	public static ButtonAiCoach getBtnVol() {
		return btnVol;
	}

	public static void setBtnVol(ButtonAiCoach btnVol) {
		TelaCriarTatica.btnVol = btnVol;
	}

	public static ButtonAiCoach getBtnVol_1() {
		return btnVol_1;
	}

	public static void setBtnVol_1(ButtonAiCoach btnVol_1) {
		TelaCriarTatica.btnVol_1 = btnVol_1;
	}

	public static ButtonAiCoach getBtnVol_2() {
		return btnVol_2;
	}

	public static void setBtnVol_2(ButtonAiCoach btnVol_2) {
		TelaCriarTatica.btnVol_2 = btnVol_2;
	}

	public static ButtonAiCoach getBtnLd_1() {
		return btnLd_1;
	}

	public static void setBtnLd_1(ButtonAiCoach btnLd_1) {
		TelaCriarTatica.btnLd_1 = btnLd_1;
	}

	public static ButtonAiCoach getBtnLe_1() {
		return btnLe_1;
	}

	public static void setBtnLe_1(ButtonAiCoach btnLe_1) {
		TelaCriarTatica.btnLe_1 = btnLe_1;
	}

	public static ButtonAiCoach getBtnMld() {
		return btnMld;
	}

	public static void setBtnMld(ButtonAiCoach btnMld) {
		TelaCriarTatica.btnMld = btnMld;
	}

	public static ButtonAiCoach getBtnMc() {
		return btnMc;
	}

	public static void setBtnMc(ButtonAiCoach btnMc) {
		TelaCriarTatica.btnMc = btnMc;
	}

	public static ButtonAiCoach getBtnMc_1() {
		return btnMc_1;
	}

	public static void setBtnMc_1(ButtonAiCoach btnMc_1) {
		TelaCriarTatica.btnMc_1 = btnMc_1;
	}

	public static ButtonAiCoach getBtnMc_2() {
		return btnMc_2;
	}

	public static void setBtnMc_2(ButtonAiCoach btnMc_2) {
		TelaCriarTatica.btnMc_2 = btnMc_2;
	}

	public static ButtonAiCoach getBtnMle() {
		return btnMle;
	}

	public static void setBtnMle(ButtonAiCoach btnMle) {
		TelaCriarTatica.btnMle = btnMle;
	}

	public static ButtonAiCoach getBtnMle_1() {
		return btnMle_1;
	}

	public static void setBtnMle_1(ButtonAiCoach btnMle_1) {
		TelaCriarTatica.btnMle_1 = btnMle_1;
	}

	public static ButtonAiCoach getBtnMat_2() {
		return btnMat_2;
	}

	public static void setBtnMat_2(ButtonAiCoach btnMat_2) {
		TelaCriarTatica.btnMat_2 = btnMat_2;
	}

	public static ButtonAiCoach getBtnMat_1() {
		return btnMat_1;
	}

	public static void setBtnMat_1(ButtonAiCoach btnMat_1) {
		TelaCriarTatica.btnMat_1 = btnMat_1;
	}

	public static ButtonAiCoach getBtnMat() {
		return btnMat;
	}

	public static void setBtnMat(ButtonAiCoach btnMat) {
		TelaCriarTatica.btnMat = btnMat;
	}

	public static ButtonAiCoach getBtnMld_1() {
		return btnMld_1;
	}

	public static void setBtnMld_1(ButtonAiCoach btnMld_1) {
		TelaCriarTatica.btnMld_1 = btnMld_1;
	}

	public static ButtonAiCoach getBtnPte() {
		return btnPte;
	}

	public static void setBtnPte(ButtonAiCoach btnPte) {
		TelaCriarTatica.btnPte = btnPte;
	}

	public static ButtonAiCoach getBtnSa_1() {
		return btnSa_1;
	}

	public static void setBtnSa_1(ButtonAiCoach btnSa_1) {
		TelaCriarTatica.btnSa_1 = btnSa_1;
	}

	public static ButtonAiCoach getBtnCa() {
		return btnCa;
	}

	public static void setBtnCa(ButtonAiCoach btnCa) {
		TelaCriarTatica.btnCa = btnCa;
	}

	public static ButtonAiCoach getBtnPtd() {
		return btnPtd;
	}

	public static void setBtnPtd(ButtonAiCoach btnPtd) {
		TelaCriarTatica.btnPtd = btnPtd;
	}


	public ButtonAiCoach getBtnSa() {
		return btnSa;
	}

	public void setBtnSa(ButtonAiCoach btnSa) {
		this.btnSa = btnSa;
	}

	/**
	 * Launch the application.
	 */
	
	
	ButtonAiCoach btnSa;
	Time time;
	ArrayList<ButtonAiCoach> listaBotoes = new ArrayList<ButtonAiCoach>();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCriarTatica frame = new TelaCriarTatica();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCriarTatica(){}
	public TelaCriarTatica(final Time time) {
		setTitle("Criar T\u00E1tica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 714, 568);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.time=time;
		TimeDAO timeDAO=new TimeDAO();
		timeDAO.retornarTime(time.getIdTime());
		
		listaPosicaoTaticaNova.clear();
	
		btnGL = new ButtonAiCoach("GL");
		btnGL.setBackground(Color.GREEN);
		
		listaPosicaoTaticaNova.add(new Posicao(1));
		contentPane.setLayout(null);
		btnGL.setBounds(42, 277, 64, 54);
		btnGL.setId(1);
		listaBotoes.add(btnGL);
		contentPane.add(btnGL);
		
		
		btnZc_2 = new ButtonAiCoach("ZC");
		btnZc_2.setBackground(Color.GRAY);
		btnZc_2.setBounds(128, 192, 58, 54);
		btnZc_2.setId(5);

		listaBotoes.add(btnZc_2);
		contentPane.add(btnZc_2);
		
		btnZc = new ButtonAiCoach("ZC");
		btnZc.setBackground(Color.GRAY);
		
		btnZc.setId(3);
		listaBotoes.add(btnZc);
		btnZc.setBounds(128, 361, 58, 55);
		contentPane.add(btnZc);
		
		
		
		btnLd = new ButtonAiCoach("LD");
		btnLd.setBackground(Color.GRAY);
		btnLd.setBounds(130, 452, 56, 54);
		btnLd.setId(2);
		
		listaBotoes.add(btnLd);
		contentPane.add(btnLd);
		
		btnZc_1 = new ButtonAiCoach("ZC");
		btnZc_1.setBackground(Color.GRAY);
		btnZc_1.setBounds(128, 277, 58, 54);
		btnZc_1.setId(4);
		
		listaBotoes.add(btnZc_1);
		contentPane.add(btnZc_1);
		
		btnLe = new ButtonAiCoach("LE");
		btnLe.setId(6);
	
		btnLe.setBackground(Color.GRAY);
		btnLe.setBounds(130, 113, 56, 54);
		listaBotoes.add(btnLe);
		contentPane.add(btnLe);
		
		btnVol = new ButtonAiCoach("VOL");
		btnVol.setBackground(Color.GRAY);
		
		btnVol.setBounds(225, 373, 58, 54);
		btnVol.setId(8);
		listaBotoes.add(btnVol);
		contentPane.add(btnVol);
		
		
		btnVol_1 = new ButtonAiCoach("VOL");
		
		btnVol_1.setBackground(Color.GRAY);
		btnVol_1.setBounds(225, 277, 58, 54);
		btnVol_1.setId(9);
		listaBotoes.add(btnVol_1);
		contentPane.add(btnVol_1);
		
		btnVol_2 = new ButtonAiCoach("VOL");
		btnVol_2.setBackground(Color.GRAY);
		btnVol_2.setBounds(225, 192, 58, 54);
		btnVol_2.setId(10);
		
		listaBotoes.add(btnVol_2);
		contentPane.add(btnVol_2);
		
		btnLd_1 = new ButtonAiCoach("LD");
		btnLd_1.setBackground(Color.GRAY);
		btnLd_1.setBounds(225, 452, 58, 54);
		btnLd_1.setId(7);
		
		listaBotoes.add(btnLd_1);
		contentPane.add(btnLd_1);
		
		btnLe_1 = new ButtonAiCoach("LE");
		btnLe_1.setId(11);
	
		btnLe_1.setBackground(Color.GRAY);
		btnLe_1.setBounds(225, 113, 58, 54);
		listaBotoes.add(btnLe_1);
		contentPane.add(btnLe_1);
		
		btnMld = new ButtonAiCoach("MLD");
		
		btnMld.setBackground(Color.GRAY);
		btnMld.setId(12);
		listaBotoes.add(btnMld);
		
		btnMld.setBounds(322, 452, 58, 54);
		
		contentPane.add(btnMld);
		
		btnMc = new ButtonAiCoach("MC");
		btnMc.setBackground(Color.GRAY);
	
		btnMc.setId(13);
		btnMc.setBounds(322, 373, 58, 54);
		listaBotoes.add(btnMc);
		contentPane.add(btnMc);
		
		btnMc_1 = new ButtonAiCoach("MC");
		btnMc_1.setBackground(Color.GRAY);
		btnMc_1.setBounds(322, 277, 58, 54);
		btnMc_1.setId(14);
		
		listaBotoes.add(btnMc_1);
		contentPane.add(btnMc_1);
		
		btnMc_2 = new ButtonAiCoach("MC");
		btnMc_2.setBackground(Color.GRAY);
		btnMc_2.setBounds(322, 192, 58, 54);
		btnMc_2.setId(15);
	
		listaBotoes.add(btnMc_2);
		contentPane.add(btnMc_2);
		
		btnMle = new ButtonAiCoach("MLE");
		btnMle.setBackground(Color.GRAY);
		btnMle.setBounds(322, 113, 58, 54);
		btnMle.setId(16);
		
		listaBotoes.add(btnMle);
		contentPane.add(btnMle);
		
		btnMle_1 = new ButtonAiCoach("MLE");

		btnMle_1.setBackground(Color.GRAY);
		btnMle_1.setBounds(423, 113, 58, 54);
		btnMle_1.setId(21);
		listaBotoes.add(btnMle_1);
		contentPane.add(btnMle_1);
		
		btnMat_2 = new ButtonAiCoach("MAT");
		btnMat_2.setBackground(Color.GRAY);
		btnMat_2.setBounds(423, 192, 58, 54);
		btnMat_2.setId(20);
	
		listaBotoes.add(btnMat_2);
		contentPane.add(btnMat_2);
		
		btnMat_1 = new ButtonAiCoach("MAT");
		btnMat_1.setBackground(Color.GRAY);
		btnMat_1.setBounds(423, 277, 58, 54);
		btnMat_1.setId(19);
		
		listaBotoes.add(btnMat_1);
		contentPane.add(btnMat_1);
		
		btnMat = new ButtonAiCoach("MAT");
		btnMat.setBackground(Color.GRAY);
		btnMat.setBounds(423, 373, 58, 54);
		btnMat.setId(18);
		
		listaBotoes.add(btnMat);
		contentPane.add(btnMat);
		
		btnMld_1 = new ButtonAiCoach("MLD");
		btnMld_1.setBackground(Color.GRAY);
		btnMld_1.setBounds(423, 452, 58, 54);
		btnMld_1.setId(17);
		
		listaBotoes.add(btnMld_1);
		contentPane.add(btnMld_1);
		
		btnPte = new ButtonAiCoach("PTE");
		btnPte.setBackground(Color.GRAY);
		btnPte.setBounds(534, 113, 59, 54);
		btnPte.setId(26);
	
		listaBotoes.add(btnPte);
		contentPane.add(btnPte);
		
		btnSa_1 = new ButtonAiCoach("SA");
		btnSa_1.setBackground(Color.GRAY);
		btnSa_1.setBounds(534, 203, 59, 54);
		btnSa_1.setId(25);
	
		listaBotoes.add(btnSa_1);
		contentPane.add(btnSa_1);
		
		btnCa = new ButtonAiCoach("CA");
		btnCa.setBounds(548, 277, 64, 63);
		btnCa.setBackground(Color.GRAY);
		btnCa.setId(24);
		
		listaBotoes.add(btnCa);
		contentPane.add(btnCa);
		
		btnSa = new ButtonAiCoach("SA");
		btnSa.setBackground(Color.GRAY);
		btnSa.setBounds(534, 361, 59, 55);
		btnSa.setId(23);
		
		listaBotoes.add(btnSa);
		contentPane.add(btnSa);
		
		btnPtd = new ButtonAiCoach("PTD");
		btnPtd.setBackground(Color.GRAY);
		btnPtd.setBounds(534, 452, 59, 54);
		btnPtd.setId(22);
		
		
		listaBotoes.add(btnPtd);
		contentPane.add(btnPtd);
		
		btnNewButton = new JButton("Criar ");
	
		btnNewButton.setBounds(296, 11, 101, 33);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(171, 14, 104, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(88, 20, 46, 14);
		contentPane.add(lblNome);
		
		btnVoltar = new JButton("Voltar");
		
		btnVoltar.setBounds(471, 16, 89, 23);
		contentPane.add(btnVoltar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaTatica.class.getResource("/imagens/campo.png")));
		lblNewLabel.setBounds(10, 45, 688, 520);
		contentPane.add(lblNewLabel);
		
		Fachada fachada = new Fachada();
		fachada.criarTatica(this);
		
		//ControladorCadastroTatica controlador = new ControladorCadastroTatica();
		//controlador.acaoBotao(this);
		
	}
	
}
