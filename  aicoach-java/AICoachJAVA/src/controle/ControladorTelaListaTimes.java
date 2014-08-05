package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import negocio.interfaces.InterfaceBotao;

import perssistencia.TimeDAO;

import gui.TelaListaTimes;
import gui.TelaTime;
import dominio.Time;

public class ControladorTelaListaTimes implements InterfaceBotao {
	
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
	
	@Override
	public void acaoBotao(final JFrame tela) {
		TelaListaTimes.getBtnNewButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Time time=tDAO.retornarTime(TelaListaTimes.getComboBox().getSelectedItem().toString());
				Time.setTime(time);
				TelaTime telaTime = new TelaTime();
				telaTime.setVisible(true);
				tela.dispose();
				
			}
		});
		
	}

}

