package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import negocio.interfaces.InterfaceBotao;


import gui.TelaCriarTime;
import gui.TelaListaTimes;
import gui.TelaPrincipal;
import gui.TelaTime;

public class ControladorTelaPrincipal implements InterfaceBotao {
	
	
	@Override
	public void acaoBotao(final JFrame tela) {
		TelaPrincipal.getBtnCriarTime().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				TelaCriarTime telaTime = new TelaCriarTime();
				telaTime.setVisible(true);
				tela.dispose();
			}
		});
	}
	
	public void acaoTimes(final TelaPrincipal telaPrincipal ){
		TelaPrincipal.getBtnTimes().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				TelaListaTimes tela = new TelaListaTimes();
				tela.setVisible(true);
				telaPrincipal.dispose();
				
			}
		});
		
	}
	
	

}
