package negocio.view;

import gui.TelaTatica;

import java.util.Observable;
import java.util.Observer;

import negocio.model.AlterarEsquema;


public	class ObservadorTime implements Observer{
		@Override
		public void update(Observable obs, Object obj) {
			AlterarEsquema aE=(AlterarEsquema)obs;	
			TelaTatica.mostrarBotoes();
		}
		
		
	}
