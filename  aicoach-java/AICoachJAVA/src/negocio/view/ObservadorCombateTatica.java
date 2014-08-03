package negocio.view;

import gui.TelaTatica;

import java.util.Observable;
import java.util.Observer;

import negocio.model.CombateTatica;

public class ObservadorCombateTatica implements Observer {
	@Override
	public void update(Observable obs, Object obj) {
		CombateTatica cT=(CombateTatica) obs;	
		TelaTatica.mostrarBotoes();
	}
	

}
