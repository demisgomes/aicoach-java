package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaInicial extends JFrame implements ActionListener {
	
	private JButton btnTime, btnCadastrarTime;
	
	
	public TelaInicial(String nome, int largura, int altura){
		super(nome);
		this.setSize(largura,altura);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		criarTela();
		setVisible(true);
	}

	private void criarTela() {
		JPanel painel = new JPanel();
		
		btnTime = new JButton("Time");
		btnTime.addActionListener(this);
		btnCadastrarTime = new JButton("CadastrarTime");
		btnCadastrarTime.addActionListener(this);
	
		
		painel.add(btnTime);
		painel.add(btnCadastrarTime);
		
		
		this.add(painel);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnTime){
			TelaListaTimes tela = new TelaListaTimes();
			tela.setVisible(true);
			this.dispose();
		}
		
	}

}
