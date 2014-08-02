package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import dominio.Time;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class TelaTime extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaTime frame = new TelaTime();
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
	public TelaTime() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JButton btnNewButton = new JButton("Cadastrar Jogador");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastrarJogador tela = new TelaCadastrarJogador();
				tela.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(156, 53, 123, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Tática");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaTatica telaTatica= new TelaTatica();
				telaTatica.setVisible(true);
				dispose();
			}
			
		});
		btnNewButton_1.setBounds(156, 152, 123, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Jogadores");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			TelaJogadores t=new TelaJogadores();
			t.setVisible(true);
			dispose();
			}
		});
		btnNewButton_2.setBounds(156, 98, 123, 23);
		contentPane.add(btnNewButton_2);
	
		
		
		JLabel lblSantaCruz = new JLabel("Time");
		lblSantaCruz.setForeground(Color.WHITE);
		lblSantaCruz.setHorizontalAlignment(SwingConstants.CENTER);
		lblSantaCruz.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSantaCruz.setBounds(10, 11, 414, 31);
		contentPane.add(lblSantaCruz);
		
		lblSantaCruz.setText(Time.getTime().getNome());
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaTime.class.getResource("/imagens/campo.png")));
		lblNewLabel.setBounds(0, 0, 434, 262);
		contentPane.add(lblNewLabel);
	}
}
