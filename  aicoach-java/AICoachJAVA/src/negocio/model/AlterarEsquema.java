package negocio.model;

import java.util.Observable;

import dominio.Tatica;
import dominio.Time;

import negocio.AlgoritmoTatica;


public class AlterarEsquema extends Observable {
	
	public void acao(Time time, int substituicoes, Tatica novaTatica){
		AlgoritmoTatica a=new AlgoritmoTatica();
		a.alterarEsquema(time, substituicoes, novaTatica);
		setChanged();
		notifyObservers();
	}
	
}
