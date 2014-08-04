package negocio.view;

import gui.TelaTatica;

import java.util.Observable;
import java.util.Observer;

import controle.ControladorTatica;

import negocio.model.AlterarEsquema;


public	class ObservadorTime implements Observer{
		@Override
		public void update(Observable obs, Object obj) {
			ControladorTatica controlador = new ControladorTatica();
			AlterarEsquema aE=(AlterarEsquema)obs;	
			controlador.mostrarBotoes();
		}
		
		
	}
