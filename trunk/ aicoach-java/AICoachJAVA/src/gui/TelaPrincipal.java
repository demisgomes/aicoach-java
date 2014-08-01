package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import controle.ControladorTelaPrincipal;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private static JButton btnCriarTime,btnTimes;
	private JLabel lblNewLabel;
	private JLabel label;
	
	

	public static JButton getBtnCriarTime() {
		return btnCriarTime;
	}

	public static void setBtnCriarTime(JButton btnCriarTime) {
		TelaPrincipal.btnCriarTime = btnCriarTime;
	}

	public static JButton getBtnTimes() {
		return btnTimes;
	}

	public static void setBtnTimes(JButton btnTimes) {
		TelaPrincipal.btnTimes = btnTimes;
	}

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnTimes = new JButton("Times");
		ControladorTelaPrincipal controlador = new ControladorTelaPrincipal();
		controlador.acaoTimes(this);
		btnTimes.setBounds(176, 139, 89, 23);
		contentPane.add(btnTimes);
		
		btnCriarTime = new JButton("Criar Time");
		controlador.acaoCriarTime(this);
		btnCriarTime.setBounds(176, 91, 89, 23);
		contentPane.add(btnCriarTime);
		
		label = new JLabel("AiCoach");
		label.setFont(new Font("Tahoma", Font.BOLD, 25));
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(0, 11, 434, 38);
		contentPane.add(label);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/campo.png")));
		lblNewLabel.setBounds(0, 0, 434, 262);
		contentPane.add(lblNewLabel);
		
		
	}

}
