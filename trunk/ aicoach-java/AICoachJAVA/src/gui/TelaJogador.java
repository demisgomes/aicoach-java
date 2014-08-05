package gui;

import java.awt.BorderLayout;
import java.awt.Color;
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

import controle.ControladorJogador;

import negocio.controller.ControladorCombaterTatica;
import negocio.controller.Fachada;

import dominio.Jogador;
import dominio.Posicao;

public class TelaJogador extends JFrame {

	private JPanel contentPane;
	private static JButton btnCaractersticas,btnEstatsticas,btnVoltar;
	
	
	public static JButton getBtnCaractersticas() {
		return btnCaractersticas;
	}

	public static void setBtnCaractersticas(JButton btnCaractersticas) {
		TelaJogador.btnCaractersticas = btnCaractersticas;
	}

	public static JButton getBtnEstatsticas() {
		return btnEstatsticas;
	}

	public static void setBtnEstatsticas(JButton btnEstatsticas) {
		TelaJogador.btnEstatsticas = btnEstatsticas;
	}

	public static JButton getBtnVoltar() {
		return btnVoltar;
	}

	public static void setBtnVoltar(JButton btnVoltar) {
		TelaJogador.btnVoltar = btnVoltar;
	}

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
		
		btnCaractersticas = new JButton("Caracter\u00EDsticas");
		
		btnCaractersticas.setBounds(37, 228, 131, 23);
		contentPane.add(btnCaractersticas);
		
		btnEstatsticas = new JButton("Estat\u00EDsticas");
		
		btnEstatsticas.setBounds(293, 228, 131, 23);
		contentPane.add(btnEstatsticas);
		
		btnVoltar = new JButton("Voltar");
		
		Fachada fachada = new Fachada();
		fachada.inserirCaracteristicas(this);
		//ControladorJogador controlador = new ControladorJogador();
		//controlador.acaoBotao(this);
		
		btnVoltar.setBounds(335, 13, 89, 23);
		contentPane.add(btnVoltar);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNome.setForeground(Color.white);
		lblNome.setBounds(67, 11, 357, 23);
		contentPane.add(lblNome);
		
		JLabel lblIdade = new JLabel("Idade: ");
		lblIdade.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblIdade.setForeground(Color.white);
		lblIdade.setBounds(67, 45, 357, 23);
		contentPane.add(lblIdade);
		
		JLabel lblAltura = new JLabel("Altura: ");
		lblAltura.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAltura.setForeground(Color.white);lblAltura.setBounds(67, 79, 357, 23);
		contentPane.add(lblAltura);
		
		JLabel lblPeso = new JLabel("Peso: ");
		lblPeso.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPeso.setBounds(67, 113, 357, 23);
		lblPeso.setForeground(Color.white);
		contentPane.add(lblPeso);
		
		JLabel lblPosies = new JLabel("Posi\u00E7\u00F5es: ");
		lblPosies.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPosies.setBounds(67, 147, 357, 23);
		lblPosies.setForeground(Color.white);
		contentPane.add(lblPosies);
		
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setIcon(new ImageIcon(TelaJogador.class.getResource("/imagens/campo.png")));
		lblNewLabel.setBounds(0, 0, 434, 262);
		contentPane.add(lblNewLabel);
		
		
		
		//PARA O CONTROLADOR
		Jogador j=Jogador.getJogadorEscolhido();
		lblNome.setText(j.getNome());
		lblAltura.setText(Float.toString(j.getAltura())+" m");
		lblPeso.setText(Float.toString(j.getPeso())+ "kg");
		lblIdade.setText(Integer.toString(j.getIdade())+" anos");
		String posicoes=" ";
		for(Posicao p : j.getPosicoes()){
			if(p.isPosicaoDeOrigem()){
				posicoes=posicoes+" "+p.getNome()+",";
			}
		}
		lblPosies.setText(posicoes.substring(0, posicoes.length()-1));
		
		
		
		
	}
}
