package negocio.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observer;

import javax.swing.JFrame;

import gui.TelaInserirCombaterTatica;
import negocio.AlgoritmoTatica;
import negocio.interfaces.InterfaceBotao;
import negocio.model.CombateTatica;
import negocio.view.ObservadorCombateTatica;
import negocio.view.ObservadorTime;
import perssistencia.TaticaDAO;
import dominio.Time;

public class ControladorCombaterTatica implements InterfaceBotao {
	public void controlar(Time time){
		TaticaDAO tDAO=new TaticaDAO();
		Time timeEscolhido=Time.getListaTimes().get(TelaInserirCombaterTatica.comboBox.getSelectedIndex());
		AlgoritmoTatica aTatica=new AlgoritmoTatica();
		//aTatica.combaterTatica(TelaInserirCombaterTatica.time, timeEscolhido, tDAO.retornarListaTaticas());
		CombateTatica c=new CombateTatica();
		Observer obs=new ObservadorCombateTatica();
		c.addObserver(obs);
		c.acao(TelaInserirCombaterTatica.time, timeEscolhido, tDAO.retornarListaTaticas());
	}
	
	@Override
	public void acaoBotao(JFrame tela) {
		TelaInserirCombaterTatica.getBtnCombater().addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				controlar(TelaInserirCombaterTatica.time);
			}
		});
	}
}
