package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import negocio.interfaces.InterfaceBotao;


import gui.TelaCaracteristicas;
import gui.TelaJogador;
import gui.TelaJogadores;
import gui.TelaTime;

public class ControladorJogador implements InterfaceBotao {

	@Override
	public void acaoBotao(final JFrame tela) {
		TelaJogador.getBtnCaractersticas().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaCaracteristicas telaCaracteristicas = new TelaCaracteristicas();
				telaCaracteristicas.setVisible(true);
				tela.dispose();
			}
		});
		
		TelaJogador.getBtnVoltar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaTime telaTime = new TelaTime();
				telaTime.setVisible(true);
				tela.dispose();
			}
		});
		
		TelaJogador.getBtnEstatsticas().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub		
			}
		});
		
	}

}
