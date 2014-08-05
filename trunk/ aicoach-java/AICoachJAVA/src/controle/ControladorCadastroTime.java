package controle;

import gui.TelaCriarTime;
import gui.TelaInicial;
import gui.TelaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import negocio.interfaces.InterfaceBotao;

import perssistencia.TimeDAO;
import dominio.Time;

public class ControladorCadastroTime implements InterfaceBotao {
	
	private TimeDAO timeDAO = new TimeDAO();
	
	private void inserirTime(){
		String nome;
		nome = TelaCriarTime.getTxtNomeTime().getText();
		
		Time time = new Time();
		time.setNome(nome);
		
		inserirTime(time);
		
	}
	
	
	private void inserirTime(Time time){
		timeDAO.inserirTime(time);
		
	}


	@Override
	public void acaoBotao(final JFrame tela) {
	TelaCriarTime.getBtnCriar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				inserirTime();
				TelaPrincipal telaPrincipal = new TelaPrincipal();
				telaPrincipal.setVisible(true);
				tela.dispose();	
			}
		});		
	}

}
