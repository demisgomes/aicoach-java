package gui;

import javax.swing.JFrame;

public class TelaTime extends JFrame {
	
	public TelaTime(String nome, int largura, int altura){
		super(nome);
		setSize(largura, altura);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
