package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

public class TelaJogadores extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaJogadores frame = new TelaJogadores();
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
	public TelaJogadores() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setBackground(new Color(255, 255, 255));
		list.setBounds(37, 44, 358, 207);
		list.setBackground(Color.BLACK);
		contentPane.add(list);
		
		// Adicionar jogadores na Jlist
		
		JLabel lblJogadores = new JLabel("Jogadores");
		lblJogadores.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblJogadores.setBounds(168, 11, 106, 31);
		contentPane.add(lblJogadores);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaJogadores.class.getResource("/imagens/campo.png")));
		label.setBounds(0, 0, 434, 262);
		contentPane.add(label);
	}
}
