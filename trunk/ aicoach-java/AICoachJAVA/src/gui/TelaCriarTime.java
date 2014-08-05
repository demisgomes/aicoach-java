package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import negocio.controller.Fachada;

import controle.ControladorCadastroTime;

import perssistencia.TimeDAO;

import dominio.Time;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCriarTime extends JFrame {

	private JPanel contentPane;
	private static JTextField txtNomeTime;
	private static JButton btnCriar;

	/**
	 * Launch the application.
	 */
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCriarTime frame = new TelaCriarTime();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static JButton getBtnCriar() {
		return btnCriar;
	}

	public static void setBtnCriar(JButton btnCriar) {
		TelaCriarTime.btnCriar = btnCriar;
	}

	public static JTextField getTxtNomeTime() {
		return txtNomeTime;
	}

	public static void setTxtNomeTime(JTextField txtNomeTime) {
		TelaCriarTime.txtNomeTime = txtNomeTime;
	}

	/**
	 * Create the frame.
	 */
	public TelaCriarTime() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		txtNomeTime = new JTextField();
		txtNomeTime.setText("Nome");
		txtNomeTime.setBounds(176, 95, 86, 20);
		contentPane.add(txtNomeTime);
		txtNomeTime.setColumns(10);
		
		
		
		JLabel lblP = new JLabel("Cria\u00E7\u00E3o de Time");
		lblP.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblP.setForeground(Color.WHITE);
		lblP.setBounds(151, 28, 213, 29);
		contentPane.add(lblP);
		
		btnCriar = new JButton("Criar");
		//ControladorCadastroTime controlador = new ControladorCadastroTime();
		btnCriar.setBounds(176, 214, 89, 23);
		contentPane.add(btnCriar);
		//controlador.acaoBotao(this);
		Fachada fachada = new Fachada();
		fachada.criarTime(this);
		
		JLabel label = new JLabel("Criar Time");
		label.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label.setForeground(Color.WHITE);
		label.setIcon(new ImageIcon(TelaCriarTime.class.getResource("/imagens/campo.png")));
		label.setBounds(0, 0, 434, 262);
		contentPane.add(label);
		
		
	}
}
