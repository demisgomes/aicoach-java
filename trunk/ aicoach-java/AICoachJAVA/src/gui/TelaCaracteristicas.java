package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import controle.ControladorCaracteristicas;

import negocio.controller.Fachada;
import negocio.formulas.FormulaPosicao;

import perssistencia.CaracteristicaDAO;
import perssistencia.PontuacaoPosicaoDAO;

import dominio.CaracteristicasJogadores;
import dominio.Jogador;

public class TelaCaracteristicas extends JFrame {

	private JPanel contentPane;
	private static JButton btnConfirmar;
	private static JComboBox cBRessistencia,cBVelocidade,cBFinalizacao,cBControleBola,cBDesarme,cBQualidadePasse,cBCabeceio,
	cBBolaParada,cBDrible,cBDefesa;
	
	
	
	

	public static JComboBox getcBRessistencia() {
		return cBRessistencia;
	}

	public static void setcBRessistencia(JComboBox cBRessistencia) {
		TelaCaracteristicas.cBRessistencia = cBRessistencia;
	}

	public static JComboBox getcBVelocidade() {
		return cBVelocidade;
	}

	public static void setcBVelocidade(JComboBox cBVelocidade) {
		TelaCaracteristicas.cBVelocidade = cBVelocidade;
	}

	public static JComboBox getcBFinalizacao() {
		return cBFinalizacao;
	}

	public static void setcBFinalizacao(JComboBox cBFinalizacao) {
		TelaCaracteristicas.cBFinalizacao = cBFinalizacao;
	}

	public static JComboBox getcBControleBola() {
		return cBControleBola;
	}

	public static void setcBControleBola(JComboBox cBControleBola) {
		TelaCaracteristicas.cBControleBola = cBControleBola;
	}

	public static JComboBox getcBDesarme() {
		return cBDesarme;
	}

	public static void setcBDesarme(JComboBox cBDesarme) {
		TelaCaracteristicas.cBDesarme = cBDesarme;
	}

	public static JComboBox getcBQualidadePasse() {
		return cBQualidadePasse;
	}

	public static void setcBQualidadePasse(JComboBox cBQualidadePasse) {
		TelaCaracteristicas.cBQualidadePasse = cBQualidadePasse;
	}

	public static JComboBox getcBCabeceio() {
		return cBCabeceio;
	}

	public static void setcBCabeceio(JComboBox cBCabeceio) {
		TelaCaracteristicas.cBCabeceio = cBCabeceio;
	}

	public static JComboBox getcBBolaParada() {
		return cBBolaParada;
	}

	public static void setcBBolaParada(JComboBox cBBolaParada) {
		TelaCaracteristicas.cBBolaParada = cBBolaParada;
	}

	public static JComboBox getcBDrible() {
		return cBDrible;
	}

	public static void setcBDrible(JComboBox cBDrible) {
		TelaCaracteristicas.cBDrible = cBDrible;
	}

	public static JComboBox getcBDefesa() {
		return cBDefesa;
	}

	public static void setcBDefesa(JComboBox cBDefesa) {
		TelaCaracteristicas.cBDefesa = cBDefesa;
	}

	public static JButton getBtnConfirmar() {
		return btnConfirmar;
	}

	public static void setBtnConfirmar(JButton btnConfirmar) {
		TelaCaracteristicas.btnConfirmar = btnConfirmar;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCaracteristicas frame = new TelaCaracteristicas();
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
	public TelaCaracteristicas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("finaliza\u00E7\u00E3o");
		lblNewLabel.setBounds(6, 96, 50, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblBolaParada = new JLabel("bola parada");
		lblBolaParada.setBounds(228, 96, 62, 14);
		contentPane.add(lblBolaParada);
		
		JLabel lblRessistncia = new JLabel("ressist\u00EAncia");
		lblRessistncia.setBounds(10, 11, 66, 14);
		contentPane.add(lblRessistncia);
		
		JLabel lblQualidadeDoPasse = new JLabel("qualidade do passe");
		lblQualidadeDoPasse.setBounds(229, 11, 99, 14);
		contentPane.add(lblQualidadeDoPasse);
		
		JLabel lblVelocidade = new JLabel("velocidade");
		lblVelocidade.setBounds(6, 53, 66, 14);
		contentPane.add(lblVelocidade);
		
		JLabel lblCabeceio = new JLabel("cabeceio");
		lblCabeceio.setBounds(228, 53, 66, 14);
		contentPane.add(lblCabeceio);
		
		JLabel lblControleDeBola = new JLabel("controle de bola");
		lblControleDeBola.setBounds(6, 134, 87, 14);
		contentPane.add(lblControleDeBola);
		
		JLabel lblDrible = new JLabel("drible");
		lblDrible.setBounds(228, 134, 66, 14);
		contentPane.add(lblDrible);
		
		JLabel lblDesarme = new JLabel("desarme");
		lblDesarme.setBounds(6, 176, 66, 14);
		contentPane.add(lblDesarme);
		
		JLabel lblDefesa = new JLabel("defesa");
		lblDefesa.setBounds(224, 176, 66, 14);
		contentPane.add(lblDefesa);
		
		
		
		Integer [] lista=new Integer[10];
		for (int i = 0; i < lista.length; i++) {
			lista[i]=i+1;
		}
		
		cBRessistencia = new JComboBox(lista);
		cBRessistencia.setBounds(103, 8, 80, 20);
		contentPane.add(cBRessistencia);
		
		cBVelocidade = new JComboBox(lista);
		cBVelocidade.setBounds(103, 50, 80, 20);
		contentPane.add(cBVelocidade);
		
		cBFinalizacao = new JComboBox(lista);
		cBFinalizacao.setBounds(103, 93, 80, 20);
		contentPane.add(cBFinalizacao);
		
		cBControleBola = new JComboBox(lista);
		cBControleBola.setBounds(103, 131, 80, 20);
		contentPane.add(cBControleBola);
		
		cBDesarme = new JComboBox(lista);
		cBDesarme.setBounds(103, 173, 80, 20);
		contentPane.add(cBDesarme);
		
		cBQualidadePasse = new JComboBox(lista);
		cBQualidadePasse.setBounds(338, 8, 80, 20);
		contentPane.add(cBQualidadePasse);
		
		cBCabeceio = new JComboBox(lista);
		cBCabeceio.setBounds(338, 50, 80, 20);
		contentPane.add(cBCabeceio);
		
		cBBolaParada = new JComboBox(lista);
		cBBolaParada.setBounds(338, 93, 80, 20);
		contentPane.add(cBBolaParada);
		
		cBDrible = new JComboBox(lista);
		cBDrible.setBounds(338, 134, 80, 20);
		contentPane.add(cBDrible);
		
		cBDefesa = new JComboBox(lista);
		cBDefesa.setBounds(338, 173, 80, 20);
		contentPane.add(cBDefesa);
		
		
		//LÓGICA A SER IMPLEMENTADA NO CONTROLADOR
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(160, 228, 89, 23);
		
		Fachada fachada = new Fachada();
		fachada.criarCaracteristicas(this);
		
		//ControladorCaracteristicas controlador = new ControladorCaracteristicas();
		//controlador.setCaracteristicas();
		//controlador.acaoBotao(this);
		
		
		contentPane.add(btnConfirmar);
		
	}
}
