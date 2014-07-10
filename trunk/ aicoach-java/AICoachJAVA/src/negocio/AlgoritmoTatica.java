package negocio;

import java.util.ArrayList;

import dominio.Jogador;
import dominio.Posicao;
import dominio.Tatica;
import dominio.Time;

public class AlgoritmoTatica {
	
	
	public ArrayList<Jogador> SugerirJogadores(Tatica tatica, Time time){
		ArrayList<Posicao> posicoes = tatica.getPosicoes();
		for (int i = 0; i < posicoes.size(); i++) {
			//todo
		}
		return null;	
	}
	
	public Tatica SugerirTatica(){
		Tatica tatica = new Tatica();
		//todo
		return tatica;
	}

}
