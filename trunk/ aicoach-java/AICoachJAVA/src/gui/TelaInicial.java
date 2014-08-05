package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import negocio.controller.Fachada;

import controle.ControladorCadastroTime;
import controle.ControladorTelaInicial;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaInicial extends JFrame {

	private JPanel contentPane;
	private static JButton btnNewButton;
	
	

	public static JButton getBtnNewButton() {
		return btnNewButton;
	}

	public static void setBtnNewButton(JButton btnNewButton) {
		TelaInicial.btnNewButton = btnNewButton;
	}

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
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
	public TelaInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(TelaInicial.class.getResource("/imagens/campo.png")));
		
		Fachada fachada = new Fachada();
		fachada.iniciarPrograma(this);
		
		//ControladorTelaInicial controlador = new ControladorTelaInicial();
		//controlador.acaoBotao(this);
		btnNewButton.setBounds(0, 0, 434, 262);
		//btnNewButton.setBackground(Color.TRANSLUCENT);
		contentPane.add(btnNewButton);
		
		
	}
	
}
