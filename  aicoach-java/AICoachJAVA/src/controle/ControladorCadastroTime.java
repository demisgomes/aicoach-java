package controle;

import gui.TelaCriarTime;
import gui.TelaInicial;
import gui.TelaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import perssistencia.TimeDAO;
import dominio.Time;

public class ControladorCadastroTime {
	
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
	
	public void acaoCriar(final TelaCriarTime telaCriar){
		TelaCriarTime.getBtnCriar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				inserirTime();
				TelaPrincipal tela = new TelaPrincipal();
				tela.setVisible(true);
				telaCriar.dispose();
				
				
				
			}
		});
	}

}
