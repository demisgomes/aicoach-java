package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import dominio.Time;

public class TelaTime extends JFrame implements ActionListener {
	
	private JButton btnJogadores, btnCadastrarJogadores, btnTatica;
	Time time;
	
	public TelaTime(String nome, int largura, int altura, Time time){
		super(nome);
		setSize(largura, altura);
		this.time=time;
		setTitle(time.getNome());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		criarTela();
		setVisible(true);
	}

	private void criarTela() {
		JPanel painel = new JPanel();
		
		btnJogadores = new JButton("Jogadores");
		btnJogadores.addActionListener(this);
		
		btnCadastrarJogadores = new JButton("Cadastrar jogadores");
		btnCadastrarJogadores.addActionListener(this);
		
		btnTatica = new JButton("Tatica");
		btnTatica.addActionListener(this);
		
		painel.add(btnJogadores);
		painel.add(btnCadastrarJogadores);
		painel.add(btnTatica);
		
		this.add(painel);
		
		
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnTatica){
			TelaTatica tela = new TelaTatica(time);
			tela.setVisible(true);
			this.dispose();
		}
		
	}
}
