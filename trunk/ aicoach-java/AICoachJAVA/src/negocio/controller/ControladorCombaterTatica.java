package negocio.controller;

import java.util.Observer;

import gui.TelaInserirCombaterTatica;
import negocio.AlgoritmoTatica;
import negocio.model.CombateTatica;
import negocio.view.ObservadorCombateTatica;
import negocio.view.ObservadorTime;
import perssistencia.TaticaDAO;
import dominio.Time;

public class ControladorCombaterTatica {
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
}
