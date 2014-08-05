package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import negocio.controller.Fachada;


import controle.ControladorCadastroJogador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastrarJogador extends JFrame {

	private static  JPanel contentPane;
	private static  JTextField txtNome;
	private static  JTextField txtIdade;
	private static  JTextField txtPeso;
	private static  JTextField txtAltura;
	private static JCheckBox chckbGoleiro, chckbxZagueiro, chckbxLateralDireito, 
	chckbxVolante, chckbxLateralEsquerdo, chckbxMeiaCentral, chckbxMeiaLateral, chckbxMeiaAtacante,
	chckbxPonta, chckbxSegundoAtacante, chckbxCentroAvante;
	private static JButton btnConfirmar;
	/**
	 * Launch the application.
	 */
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarJogador frame = new TelaCadastrarJogador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static JCheckBox getChckbGoleiro() {
		return chckbGoleiro;
	}

	public static void setChckbGoleiro(JCheckBox chckbGoleiro) {
		TelaCadastrarJogador.chckbGoleiro = chckbGoleiro;
	}

	public static JCheckBox getChckbxZagueiro() {
		return chckbxZagueiro;
	}

	public static void setChckbxZagueiro(JCheckBox chckbxZagueiro) {
		TelaCadastrarJogador.chckbxZagueiro = chckbxZagueiro;
	}

	public static JCheckBox getChckbxLateralDireito() {
		return chckbxLateralDireito;
	}

	public static void setChckbxLateralDireito(JCheckBox chckbxLateralDireito) {
		TelaCadastrarJogador.chckbxLateralDireito = chckbxLateralDireito;
	}

	public static JCheckBox getChckbxVolante() {
		return chckbxVolante;
	}

	public static void setChckbxVolante(JCheckBox chckbxVolante) {
		TelaCadastrarJogador.chckbxVolante = chckbxVolante;
	}

	public static JCheckBox getChckbxLateralEsquerdo() {
		return chckbxLateralEsquerdo;
	}

	public static void setChckbxLateralEsquerdo(JCheckBox chckbxLateralEsquerdo) {
		TelaCadastrarJogador.chckbxLateralEsquerdo = chckbxLateralEsquerdo;
	}

	public static JCheckBox getChckbxMeiaCentral() {
		return chckbxMeiaCentral;
	}

	public static void setChckbxMeiaCentral(JCheckBox chckbxMeiaCentral) {
		TelaCadastrarJogador.chckbxMeiaCentral = chckbxMeiaCentral;
	}

	public static JCheckBox getChckbxMeiaLateral() {
		return chckbxMeiaLateral;
	}

	public static void setChckbxMeiaLateral(JCheckBox chckbxMeiaLateral) {
		TelaCadastrarJogador.chckbxMeiaLateral = chckbxMeiaLateral;
	}

	public static JCheckBox getChckbxMeiaAtacante() {
		return chckbxMeiaAtacante;
	}

	public static void setChckbxMeiaAtacante(JCheckBox chckbxMeiaAtacante) {
		TelaCadastrarJogador.chckbxMeiaAtacante = chckbxMeiaAtacante;
	}

	public static JCheckBox getChckbxPonta() {
		return chckbxPonta;
	}

	public static void setChckbxPonta(JCheckBox chckbxPonta) {
		TelaCadastrarJogador.chckbxPonta = chckbxPonta;
	}

	public static JCheckBox getChckbxSegundoAtacante() {
		return chckbxSegundoAtacante;
	}

	public static void setChckbxSegundoAtacante(JCheckBox chckbxSegundoAtacante) {
		TelaCadastrarJogador.chckbxSegundoAtacante = chckbxSegundoAtacante;
	}

	public static JCheckBox getChckbxCentroAvante() {
		return chckbxCentroAvante;
	}

	public static void setChckbxCentroAvante(JCheckBox chckbxCentroAvante) {
		TelaCadastrarJogador.chckbxCentroAvante = chckbxCentroAvante;
	}

	public static JButton getBtnConfirmar() {
		return btnConfirmar;
	}

	public static void setBtnConfirmar(JButton btnConfirmar) {
		TelaCadastrarJogador.btnConfirmar = btnConfirmar;
	}

	public static JTextField getTxtNome() {
		return txtNome;
	}

	public static void setTxtNome(JTextField txtNome) {
		TelaCadastrarJogador.txtNome = txtNome;
	}

	public static JTextField getTxtIdade() {
		return txtIdade;
	}

	public static void setTxtIdade(JTextField txtIdade) {
		TelaCadastrarJogador.txtIdade = txtIdade;
	}

	public static JTextField getTxtPeso() {
		return txtPeso;
	}

	public static void setTxtPeso(JTextField txtPeso) {
		TelaCadastrarJogador.txtPeso = txtPeso;
	}

	public static JTextField getTxtAltura() {
		return txtAltura;
	}

	public static void setTxtAltura(JTextField txtAltura) {
		TelaCadastrarJogador.txtAltura = txtAltura;
	}

	/**
	 * Create the frame.
	 */
	public TelaCadastrarJogador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNome = new JTextField();
		txtNome.setText("nome");
		txtNome.setBounds(10, 11, 280, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtIdade = new JTextField();
		txtIdade.setText("idade");
		txtIdade.setBounds(10, 42, 66, 20);
		contentPane.add(txtIdade);
		txtIdade.setColumns(10);
		
		txtPeso = new JTextField();
		txtPeso.setText("peso");
		txtPeso.setColumns(10);
		txtPeso.setBounds(114, 42, 66, 20);
		contentPane.add(txtPeso);
		
		txtAltura = new JTextField();
		txtAltura.setText("altura");
		txtAltura.setColumns(10);
		txtAltura.setBounds(224, 42, 66, 20);
		contentPane.add(txtAltura);
		
		 chckbGoleiro = new JCheckBox("goleiro");
		chckbGoleiro.setBounds(10, 86, 97, 23);
		contentPane.add(chckbGoleiro);
		
		chckbxZagueiro = new JCheckBox("zagueiro");
		chckbxZagueiro.setBounds(10, 112, 97, 23);
		contentPane.add(chckbxZagueiro);
		
		chckbxLateralDireito = new JCheckBox("lateral direito");
		chckbxLateralDireito.setBounds(10, 138, 97, 23);
		contentPane.add(chckbxLateralDireito);
		
		chckbxLateralEsquerdo = new JCheckBox("lateral esquerdo");
		chckbxLateralEsquerdo.setBounds(10, 164, 103, 23);
		contentPane.add(chckbxLateralEsquerdo);
		
		chckbxVolante = new JCheckBox("volante");
		chckbxVolante.setBounds(130, 86, 97, 23);
		contentPane.add(chckbxVolante);
		
		chckbxMeiaCentral = new JCheckBox("meia central");
		chckbxMeiaCentral.setBounds(130, 112, 97, 23);
		contentPane.add(chckbxMeiaCentral);
		
		chckbxMeiaLateral = new JCheckBox("meia lateral");
		chckbxMeiaLateral.setBounds(130, 138, 97, 23);
		contentPane.add(chckbxMeiaLateral);
		
		chckbxMeiaAtacante = new JCheckBox("meia atacante");
		chckbxMeiaAtacante.setBounds(130, 164, 97, 23);
		contentPane.add(chckbxMeiaAtacante);
		
		chckbxPonta = new JCheckBox("ponta");
		chckbxPonta.setBounds(236, 86, 97, 23);
		contentPane.add(chckbxPonta);
		
		chckbxSegundoAtacante = new JCheckBox("segundo atacante");
		chckbxSegundoAtacante.setBounds(236, 112, 113, 23);
		contentPane.add(chckbxSegundoAtacante);
		
		chckbxCentroAvante = new JCheckBox("centro avante");
		chckbxCentroAvante.setBounds(236, 138, 97, 23);
		contentPane.add(chckbxCentroAvante);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(152, 228, 89, 23);
		contentPane.add(btnConfirmar);
		
		Fachada fachada = new Fachada();
		fachada.criarJogador(this);
		//ControladorCadastroJogador controlador = new ControladorCadastroJogador();
		//controlador.acaoBotao(this);
		
	}
}
