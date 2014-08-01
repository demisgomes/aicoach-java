package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.TelaCriarTime;
import gui.TelaListaTimes;
import gui.TelaPrincipal;
import gui.TelaTime;

public class ControladorTelaPrincipal {
	
	public void acaoCriarTime(final TelaPrincipal telaPrincipal){
		TelaPrincipal.getBtnCriarTime().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				TelaCriarTime tela = new TelaCriarTime();
				tela.setVisible(true);
				telaPrincipal.dispose();
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
