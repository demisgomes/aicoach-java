package negocio.view;

import gui.TelaTatica;

import java.util.Observable;
import java.util.Observer;

import controle.ControladorTatica;

import negocio.model.CombateTatica;

public class ObservadorCombateTatica implements Observer {
	@Override
	public void update(Observable obs, Object obj) {
		ControladorTatica controlador = new ControladorTatica();
		CombateTatica cT=(CombateTatica) obs;	
		controlador.mostrarBotoes();
	}
	

}
