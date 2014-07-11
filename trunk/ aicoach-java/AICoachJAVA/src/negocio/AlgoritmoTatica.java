package negocio;

import java.util.ArrayList;

import dominio.Jogador;
import dominio.Posicao;
import dominio.Tatica;
import dominio.Time;

public class AlgoritmoTatica {
	
	public ArrayList<Posicao> SugerirJogadores(Tatica tatica, Time time){
		
		ArrayList<Posicao> posicoes = tatica.getPosicoes();
		ArrayList<Jogador> jogadoresClone = new ArrayList<Jogador>();
		
		
		
		for (Posicao posicao : posicoes) {
			int ptMaior=0;
			Posicao posicaoX = null;
			for(Jogador jogador : jogadoresClone){
				
				for(Posicao posicaoComparada: jogador.getPosicoes()){
					if(posicao.getNome().equals(posicaoComparada.getNome()) && posicaoComparada.isPosicaoDeOrigem()){
						System.out.println("Entrei No mFI");
						System.out.println(jogador.getNome()+ " Joga de "+posicaoComparada.getNome()+" pontuacao de "+ posicaoComparada.getPontuacao());
						System.out.println(ptMaior+" "+posicaoComparada.getPontuacao());
						if(ptMaior<posicaoComparada.getPontuacao()){
							
							ptMaior=posicaoComparada.getPontuacao();
							
							posicaoX=posicaoComparada;
							jogadoresClone.remove(jogador);
							System.out.println(posicaoX.getNome()+" "+posicaoX.getJogador().getNome());
							
						}
						
					}
				}
			}
			posicao=posicaoX;
				
			
		}
		//todo
		
		
		
		return posicoes;	
	}
	
	public Tatica SugerirTatica(){
		Tatica tatica = new Tatica();
		//todo
		return tatica;
	}

}
