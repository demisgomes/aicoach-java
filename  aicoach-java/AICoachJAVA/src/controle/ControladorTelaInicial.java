package controle;

import gui.TelaInicial;
import gui.TelaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorTelaInicial {
	public void acaoInicial(final TelaInicial telaInicial){
		TelaInicial.getBtnNewButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				TelaPrincipal tela = new TelaPrincipal();
				tela.setVisible(true);
				telaInicial.dispose();
				
				
				
			}
		});
	}

}
