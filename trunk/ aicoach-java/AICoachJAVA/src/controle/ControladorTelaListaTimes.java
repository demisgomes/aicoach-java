package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import perssistencia.TimeDAO;

import gui.TelaListaTimes;
import gui.TelaTime;
import dominio.Time;

public class ControladorTelaListaTimes {
	
	final private TimeDAO tDAO=new TimeDAO();
	
	
	public String[] retornarListaTime(){
		final ArrayList <Time> listaTime=tDAO.retornarListaTimes();
		Time.setListaTimes(listaTime);
		String [] listaTimes=new String[listaTime.size()];
		for (int i = 0; i < listaTimes.length; i++) {
			listaTimes[i]=listaTime.get(i).getNome();
		}
		return listaTimes;
	}
	
	public void acaoNew(final TelaListaTimes telaLista){
		TelaListaTimes.getBtnNewButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Time time=tDAO.retornarTime(TelaListaTimes.getComboBox().getSelectedItem().toString());
				Time.setTime(time);
				TelaTime tela = new TelaTime();
				tela.setVisible(true);
				telaLista.dispose();
				
			}
		});
	}

}

