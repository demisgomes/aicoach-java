package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class TelaTatica extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaTatica frame = new TelaTatica();
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
	public TelaTatica() {
		setTitle("Tela T\u00E1tica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 714, 568);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(TelaTatica.class.getResource("/imagens/campo.png")));
		lblNewLabel.setBounds(10, 92, 688, 438);
		contentPane.add(lblNewLabel);
		
		JButton btnSugerirTtica = new JButton("Sugerir T\u00E1tica");
		btnSugerirTtica.setBounds(27, 23, 135, 23);
		contentPane.add(btnSugerirTtica);
		
		JButton btnNewButton = new JButton("Alterar Esquema");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(27, 57, 135, 23);
		contentPane.add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(239, 24, 93, 20);
		contentPane.add(comboBox);
		
		JButton btnEscolherMelhoresJogadores = new JButton("Escolher Melhores Jogadores");
		btnEscolherMelhoresJogadores.setBounds(354, 23, 185, 23);
		contentPane.add(btnEscolherMelhoresJogadores);
	}
}
