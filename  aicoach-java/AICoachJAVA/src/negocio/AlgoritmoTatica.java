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
		ArrayList<Posicao> posicoesRetorno = new ArrayList<Posicao>();
		
		
		
		for (Posicao posicao : posicoes) {
			int ptMaior=0;
			Posicao posicaoX = null;
			for(Jogador jogador : time.getJogadores()){
				
				for(Posicao posicaoComparada: jogador.getPosicoes()){
					if(posicao.getNome().equals(posicaoComparada.getNome()) && posicaoComparada.isPosicaoDeOrigem() && !jogadoresClone.contains(jogador)){
						System.out.println("Entrei No mFI");
						System.out.println(jogador.getNome()+ " Joga de "+posicaoComparada.getNome()+" pontuacao de "+ posicaoComparada.getPontuacao());
						System.out.println(ptMaior+" "+posicaoComparada.getPontuacao());
						if(ptMaior<posicaoComparada.getPontuacao()){
							
							ptMaior=posicaoComparada.getPontuacao();
							
							posicaoX=posicaoComparada;
							jogadoresClone.add(jogador);
							
							System.out.println(posicaoX.getNome()+" "+posicaoX.getJogador().getNome());
							
						}
						posicoesRetorno.add(posicaoX);
						
					}
					
				}
				
			}
			
				
			
		}
		//todo
		
		
		
		return posicoesRetorno;	
	}
	
	public Tatica SugerirTatica(){
		Tatica tatica = new Tatica();
		//todo
		return tatica;
	}

}
