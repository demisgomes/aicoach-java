package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

import dominio.Jogador;
import dominio.Posicao;

public class TelaJogador extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaJogador frame = new TelaJogador();
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
	public TelaJogador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JButton btnCaractersticas = new JButton("Caracter\u00EDsticas");
		btnCaractersticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCaractersticas.setBounds(37, 228, 131, 23);
		contentPane.add(btnCaractersticas);
		btnCaractersticas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				TelaCaracteristicas tela = new TelaCaracteristicas();
				tela.setVisible(true);
				dispose();
			
				
			}
		});
		
		JButton btnEstatsticas = new JButton("Estat\u00EDsticas");
		btnEstatsticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEstatsticas.setBounds(293, 228, 131, 23);
		contentPane.add(btnEstatsticas);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNome.setBounds(67, 11, 357, 23);
		contentPane.add(lblNome);
		
		JLabel lblIdade = new JLabel("Idade: ");
		lblIdade.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblIdade.setBounds(67, 45, 357, 23);
		contentPane.add(lblIdade);
		
		JLabel lblAltura = new JLabel("Altura: ");
		lblAltura.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAltura.setBounds(67, 79, 357, 23);
		contentPane.add(lblAltura);
		
		JLabel lblPeso = new JLabel("Peso: ");
		lblPeso.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPeso.setBounds(67, 113, 357, 23);
		contentPane.add(lblPeso);
		
		JLabel lblPosies = new JLabel("Posi\u00E7\u00F5es: ");
		lblPosies.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPosies.setBounds(67, 147, 357, 23);
		contentPane.add(lblPosies);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setIcon(new ImageIcon(TelaJogador.class.getResource("/imagens/campo.png")));
		lblNewLabel.setBounds(0, 0, 434, 262);
		contentPane.add(lblNewLabel);
		
		
		
		//PARA O CONTROLADOR
		Jogador j=Jogador.getJogadorEscolhido();
		lblNome.setText(j.getNome());
		lblAltura.setText(Float.toString(j.getAltura()));
		lblPeso.setText(Float.toString(j.getPeso()));
		lblIdade.setText(Integer.toString(j.getIdade()));
		String posicoes=" ";
		for(Posicao p : j.getPosicoes()){
			if(p.isPosicaoDeOrigem()){
				posicoes=posicoes+" "+p.getNome()+",";
			}
		}
		lblPosies.setText(posicoes.substring(0, posicoes.length()-1));
		
		
	}

	

	
	
}
