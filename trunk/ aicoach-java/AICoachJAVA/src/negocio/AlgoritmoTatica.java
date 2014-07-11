package negocio;

import java.util.ArrayList;

import dominio.Jogador;
import dominio.Posicao;
import dominio.Tatica;
import dominio.Time;

public class AlgoritmoTatica {
	
	public ArrayList<Jogador> SugerirJogadores(Tatica tatica, Time time){
		ArrayList<Posicao> posicoes = tatica.getPosicoes();
		//ArrayList<Posicao> posicoesJogadores = time.getJogadores().get.getPosicoes();
		Posicao posicaoX = null;
		int ptMaior=0;
		for (Posicao posicao : posicoes) {
			
			for(Jogador jogador : time.getJogadores()){
				
				for(Posicao posicaoComparada: jogador.getPosicoes()){
					if(posicao.getNome().equals(posicaoComparada.getNome()) && posicaoComparada.isPosicaoDeOrigem()){
						
						if(ptMaior<posicao.getPontuacao()){
							
							ptMaior=posicaoComparada.getPontuacao();
							
							posicaoX=posicaoComparada;
							
						}
						
					}
				}
			}
			posicao=posicaoX;
				
			
		}
		//todo
		
		
		
		return null;	
	}
	
	public Tatica SugerirTatica(){
		Tatica tatica = new Tatica();
		//todo
		return tatica;
	}

}
