package negocio;

import java.util.ArrayList;

import dominio.Jogador;
import dominio.OverallTime;
import dominio.Posicao;
import dominio.Tatica;
import dominio.Time;

public class AlgoritmoTatica {
	
	public void SugerirJogadores(Tatica tatica, Time time){
		
		ArrayList<Posicao> posicoes = tatica.getPosicoes();
		ArrayList<Jogador> jogadoresClone = new ArrayList<Jogador>();
		ArrayList<Posicao> posicoesRetorno = new ArrayList<Posicao>();
		
		
		
		for (Posicao posicao : posicoes) {
			int ptMaior=0;
			Posicao posicaoX = null;
			for(Jogador jogador : time.getJogadores()){
				for(Posicao posicaoComparada: jogador.getPosicoes()){
					if(posicao.getNome().equals(posicaoComparada.getNome()) && posicaoComparada.isPosicaoDeOrigem() && !jogadoresClone.contains(jogador)){
						if(ptMaior<posicaoComparada.getPontuacao()){
							
							ptMaior=posicaoComparada.getPontuacao();
							
							posicaoX=posicaoComparada;
							
			
							
						}
						
						
					}
					
				}
				
			}
			posicaoX.getJogador().setEscolhido(true);
			posicaoX.getJogador().setPosicaoAtual(posicaoX);
			
			jogadoresClone.add(posicaoX.getJogador());
			posicoesRetorno.add(posicaoX);
				
			
		}
		//todo
		tatica.setPosicoes(posicoesRetorno);
		time.setTatica(tatica);
		
		
		//return posicoesRetorno;	
	}
	
public void SugerirJogadores(Time time){
		
		ArrayList<Posicao> posicoes = time.getTatica().getPosicoes();
		ArrayList<Jogador> jogadoresClone = new ArrayList<Jogador>();
		ArrayList<Posicao> posicoesRetorno = new ArrayList<Posicao>();
		
		
		
		for (Posicao posicao : posicoes) {
			int ptMaior=0;
			Posicao posicaoX = null;
			for(Jogador jogador : time.getJogadores()){
				for(Posicao posicaoComparada: jogador.getPosicoes()){
					if(posicao.getNome().equals(posicaoComparada.getNome()) && posicaoComparada.isPosicaoDeOrigem() && !jogadoresClone.contains(jogador)){
						if(ptMaior<posicaoComparada.getPontuacao()){
							
							ptMaior=posicaoComparada.getPontuacao();
							
							posicaoX=posicaoComparada;
							
			
							
						}
						
						
					}
					
				}
				
			}
			posicaoX.getJogador().setEscolhido(true);
			posicaoX.getJogador().setPosicaoAtual(posicaoX);
			
			jogadoresClone.add(posicaoX.getJogador());
			posicoesRetorno.add(posicaoX);
				
			
		}
		//todo
		time.getTatica().setPosicoes(posicoesRetorno);
		time.setTatica(time.getTatica());
		
		
		//return posicoesRetorno;	
	}
	
	
	public Tatica SugerirTatica(){
		Tatica tatica = new Tatica();
		//todo
		return tatica;
	}
	
	public Jogador substituirJogador(Jogador jogador, Time time){
		Jogador jogadorSubstituto = new Jogador();
		Jogador jogadorX = new Jogador();
		int pontuacao = 0;
		for (int i = 0; i < time.getJogadores().size(); i++) {
			for (int j = 0; j < time.getJogadores().get(i).getPosicoes().size(); j++) {
				jogadorX = time.getJogadores().get(i);
				if(jogadorX.getPosicoes().get(j).getNome().equals(jogador.getPosicaoAtual().getNome()) && !jogadorX.isEscolhido() && pontuacao < jogadorX.getPosicoes().get(j).getPontuacao()){
					pontuacao = jogadorX.getPosicoes().get(j).getPontuacao();
					jogadorSubstituto = jogadorX;
					
				}
				
			}
	
		}	
		
		return jogadorSubstituto ;
	}
	
	private String gerarEstilodeJogoTime(){
		String estiloDeJogo = "";
		return estiloDeJogo;
	}
	
	private OverallTime gerarOverall(Time time){
		OverallTime overall = new OverallTime();
		Posicao posicao = new Posicao("");
		int velocidade = 0, finalizacao = 0, desarme = 0, passe = 0 , jogadoresVelocidade = 0 , 
				jogadoresFinalizacao = 0, jogadoresDesarme = 0, jogadoresPasse = 0;
		for (int i = 0; i < time.getJogadores().size(); i++) {
			posicao = time.getJogadores().get(i).getPosicaoAtual();
			if(posicao != null){
				if(posicao.getNome().toLowerCase().equals("lateral") || posicao.getNome().toLowerCase().equals("meia lateral") || posicao.getNome().toLowerCase().equals("ponta") 
						|| posicao.getNome().toLowerCase().equals("segundo atacante") ){
					velocidade += time.getJogadores().get(i).getCaracteristicas().getVelocidade();
					jogadoresVelocidade++;
				}
				if(posicao.getNome().toLowerCase().equals("centro avante") || posicao.getNome().toLowerCase().equals("segundo atacante") || posicao.getNome().toLowerCase().equals("meia atacante")
						|| posicao.getNome().toLowerCase().equals("ponta")){
					finalizacao += time.getJogadores().get(i).getCaracteristicas().getFinalizacao();
					jogadoresFinalizacao++;
					
				}
				
				if(posicao.getNome().toLowerCase().equals("zagueiro") || posicao.getNome().toLowerCase().equals("volante") || posicao.getNome().toLowerCase().equals("lateral")){
					desarme += time.getJogadores().get(i).getCaracteristicas().getDesarme();
					jogadoresDesarme++;
					
				}
				
				if(posicao.getNome().toLowerCase().equals("meia atacante") || posicao.getNome().toLowerCase().equals("meia central") || posicao.getNome().toLowerCase().equals("meia lateral") 
						|| posicao.getNome().toLowerCase().equals("volante")){
					passe += time.getJogadores().get(i).getCaracteristicas().getQualidadePasse();
					jogadoresPasse++;
					
				}
			}else{
				for (int j = 0; j < time.getJogadores().get(i).getPosicoes().size(); j++) {
					posicao = time.getJogadores().get(i).getPosicoes().get(j);
					if(posicao.isPosicaoDeOrigem() && (posicao.getNome().toLowerCase().equals("lateral") || posicao.getNome().toLowerCase().equals("meia lateral") || posicao.getNome().toLowerCase().equals("ponta") 
							|| posicao.getNome().toLowerCase().equals("segundo atacante")) ){
						velocidade += time.getJogadores().get(i).getCaracteristicas().getVelocidade();
						jogadoresVelocidade++;
					}
					if(posicao.isPosicaoDeOrigem() && (posicao.getNome().toLowerCase().equals("centro avante") || posicao.getNome().toLowerCase().equals("segundo atacante") || posicao.getNome().toLowerCase().equals("meia atacante")
							|| posicao.getNome().toLowerCase().equals("ponta"))){
						finalizacao += time.getJogadores().get(i).getCaracteristicas().getFinalizacao();
						jogadoresFinalizacao++;
						
					}
					
					if(posicao.isPosicaoDeOrigem() && (posicao.getNome().toLowerCase().equals("zagueiro") || posicao.getNome().toLowerCase().equals("volante") || posicao.getNome().toLowerCase().equals("lateral"))){
						desarme += time.getJogadores().get(i).getCaracteristicas().getDesarme();
						jogadoresDesarme++;
						
					}
					
					if(posicao.isPosicaoDeOrigem() && (posicao.getNome().toLowerCase().equals("meia atacante") || posicao.getNome().toLowerCase().equals("meia central") || posicao.getNome().toLowerCase().equals("meia lateral") 
							|| posicao.getNome().toLowerCase().equals("volante"))){
						passe += time.getJogadores().get(i).getCaracteristicas().getQualidadePasse();
						jogadoresPasse++;
						
					}
					
				}
			}
		}
		overall.setVelocidade(velocidade/jogadoresVelocidade);
		overall.setDesarme(desarme/jogadoresDesarme);
		overall.setFinalizacao(finalizacao/jogadoresFinalizacao);
		overall.setPasse(passe/jogadoresPasse);
		
		return overall;
	}

}
