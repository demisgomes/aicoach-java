package controle;

import gui.TelaInicial;
import gui.TelaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import negocio.interfaces.InterfaceBotao;


public class ControladorTelaInicial implements InterfaceBotao {
	@Override
	public void acaoBotao(final JFrame tela) {
		TelaInicial.getBtnNewButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				TelaPrincipal telaPrincipal = new TelaPrincipal();
				telaPrincipal.setVisible(true);
				tela.dispose();
				
				
				
			}
		});
		
	}

}
