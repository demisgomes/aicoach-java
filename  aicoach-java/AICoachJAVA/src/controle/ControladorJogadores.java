package controle;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import dominio.Jogador;
import dominio.Time;

import gui.TelaJogador;
import gui.TelaJogadores;

public class ControladorJogadores {
	
	public void opcoesJogador(final TelaJogadores tela){
		MouseListener mL = TelaJogadores.getmL();
		mL = new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				if(e.getClickCount()==1){
					String selectedItem = (String)TelaJogadores.getList().getSelectedValue();
					   Jogador.setJogadorEscolhido(Time.getTime().getJogadores().get(TelaJogadores.getList().getSelectedIndex()));
			           TelaJogador t = new TelaJogador();
			           t.setVisible(true);
			           tela.dispose();
			          
				}
			}
		};
		
		TelaJogadores.getList().addMouseListener(mL);
		
		
	}
	
	

}
