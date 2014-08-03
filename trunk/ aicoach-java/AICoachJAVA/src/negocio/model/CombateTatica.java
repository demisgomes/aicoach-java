package negocio.model;

import gui.TelaInserirCombaterTatica;
import gui.TelaTatica;

import java.util.ArrayList;
import java.util.Observable;

import dominio.Tatica;
import dominio.Time;

import negocio.AlgoritmoTatica;


public class CombateTatica extends Observable {
	
	public void acao(Time meuTime, Time timeAdversario, ArrayList<Tatica>taticas){
		AlgoritmoTatica a=new AlgoritmoTatica();
		//a.alterarEsquema(time, substituicoes, novaTatica);
		a.combaterTatica(meuTime, timeAdversario, taticas);
		TelaTatica.time=TelaInserirCombaterTatica.time;
		setChanged();
		notifyObservers();
	}
}