package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TelaTatica extends JFrame {
	
	JButton btnSugerirJogadores;
	
	public TelaTatica(String nome, int largura, int altura){
		super(nome);
		this.setSize(largura, altura);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		criarTela();
		setVisible(true);
	}

	private void criarTela() {
		
		btnSugerirJogadores = new JButton("Sugerir Jogadores");
		
		JPanel painel = new JPanel();
		JTextArea txtJogadores = new JTextArea(50,500);
		
		painel.add(btnSugerirJogadores);
		painel.add(txtJogadores);
		this.add(painel);
	
		
		
		
	}

}
