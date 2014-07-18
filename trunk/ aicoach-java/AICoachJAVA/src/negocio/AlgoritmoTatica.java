package negocio;

import java.util.ArrayList;

import dominio.EstiloDeJogo;
import dominio.Jogador;
import dominio.OverallJogador;
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
							posicaoX.setIdPosicaoTela(posicao.getIdPosicaoTela());
							
			
							
						}
						
						
					}
					
				}
				
			}
			posicaoX.getJogador().setEscolhido(1);
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
					//System.out.println(jogador.getNome()+ " "+posicaoComparada.isPosicaoDeOrigem()+" "+posicao.getPontuacao());
					if(posicao.getNome().equals(posicaoComparada.getNome()) && posicaoComparada.isPosicaoDeOrigem() && !jogadoresClone.contains(jogador)){
						if(ptMaior<posicaoComparada.getPontuacao()){
							
							ptMaior=posicaoComparada.getPontuacao();
							
							posicaoX=posicaoComparada;
							posicaoX.setIdPosicaoTela(posicao.getIdPosicaoTela());
			
							
						}
						
						
					}
					
				}
				
			}
			System.out.println(posicaoX.getNome());
			if(posicaoX.getJogador().getEscolhido() == 0){
				posicaoX.getJogador().setEscolhido(1);
				posicaoX.getJogador().setPosicaoAtual(posicaoX);
			
				jogadoresClone.add(posicaoX.getJogador());
				posicoesRetorno.add(posicaoX);
			}
			
		}
		//todo
		time.getTatica().setPosicoes(posicoesRetorno);
		time.setTatica(time.getTatica());
		
		
		//return posicoesRetorno;	
	}
	
	public Tatica sugerirTatica(Time time, ArrayList<Tatica> taticas){
		Tatica tatica = new Tatica();
		int maiorPontuacaoParcialMedia = 0, pontuacaoParcialMediaAtual = 0;
		for (int i = 0; i < taticas.size(); i++) {
			time.setTatica(taticas.get(i));
			for (int j = 0; j < time.getJogadores().size(); j++) {
				time.getJogadores().get(j).setEscolhido(0);
				
			}
			this.SugerirJogadores(time);
			pontuacaoParcialMediaAtual = this.gerarPontuacaoParcial(time);
			System.out.println("pontuacao media: "+pontuacaoParcialMediaAtual);
			if(pontuacaoParcialMediaAtual>=maiorPontuacaoParcialMedia){
				maiorPontuacaoParcialMedia = pontuacaoParcialMediaAtual;
				tatica = taticas.get(i);
				System.out.println("Maior pontuacao media"+maiorPontuacaoParcialMedia);
			}
		}
		time.setTatica(tatica);
		
		return tatica;
	}
	

	public int gerarPontuacaoParcial(Time time){
		int pontuacaoParcialAtual = 0, qtdJogadores = 0, pontuacaoParcialMedia = 0, pontuacaoParcial = 0;
		Posicao posicao = new Posicao();
		EstiloDeJogo estilo = new EstiloDeJogo();
		estilo = this.gerarEstilodeJogoTime(this.gerarOverallTime(time), this.gerarOverallJogador(time));
		
		for (int i = 0; i < time.getTatica().getPosicoes().size(); i++) {
			posicao = time.getTatica().getPosicoes().get(i);
			if(posicao != null){
			if(estilo.getNome().toLowerCase().equals("contra ataque")){
				if(posicao.getNome().toLowerCase().equals("lateral") || posicao.getNome().toLowerCase().equals("meia lateral")
						||  posicao.getNome().toLowerCase().equals("meia atacante") || posicao.getNome().toLowerCase().equals("meia central")
						|| posicao.getNome().toLowerCase().equals("segundo atacante") || posicao.getNome().toLowerCase().equals("centro avante")
						|| posicao.getNome().toLowerCase().equals("ponta")){
					
					pontuacaoParcialAtual = posicao.getJogador().getCaracteristicas().getVelocidade() * 4 + posicao.getJogador().getCaracteristicas().getQualidadePasse()*2+ 
							posicao.getJogador().getCaracteristicas().getFinalizacao()*3+posicao.getJogador().getCaracteristicas().getDesarme()+posicao.getPontuacao();
					
					pontuacaoParcial+=pontuacaoParcialAtual;
					System.out.println(pontuacaoParcialAtual+" "+posicao.getNome()+" "+posicao.getJogador().getNome());
					posicao.setPontuacaParcial(pontuacaoParcialAtual);
					qtdJogadores++;
				}
			}
			if(estilo.getNome().toLowerCase().equals("retranca")){
				if(posicao.getNome().toLowerCase().equals("lateral") || posicao.getNome().toLowerCase().equals("meia lateral")
						 || posicao.getNome().toLowerCase().equals("meia central")
						|| posicao.getNome().toLowerCase().equals("zagueiro")
						|| posicao.getNome().toLowerCase().equals("volante")){
					
					pontuacaoParcialAtual = posicao.getJogador().getCaracteristicas().getVelocidade() * 1 + posicao.getJogador().getCaracteristicas().getQualidadePasse()*2+ 
							posicao.getJogador().getCaracteristicas().getFinalizacao()*3+posicao.getJogador().getCaracteristicas().getDesarme()*4+posicao.getPontuacao();
					
					pontuacaoParcial+=pontuacaoParcialAtual;
					System.out.println(pontuacaoParcialAtual+" "+posicao.getNome()+" "+posicao.getJogador().getNome());
					posicao.setPontuacaParcial(pontuacaoParcialAtual);
					qtdJogadores++;
				}
			}
			if(estilo.getNome().toLowerCase().equals("bola longa")){
				if(posicao.getNome().toLowerCase().equals("lateral") || posicao.getNome().toLowerCase().equals("meia lateral")
						 || posicao.getNome().toLowerCase().equals("segundo atacante")
						|| posicao.getNome().toLowerCase().equals("ponta") || posicao.getNome().toLowerCase().equals("meia central")){
					
					pontuacaoParcialAtual = posicao.getJogador().getCaracteristicas().getVelocidade() * 4 + posicao.getJogador().getCaracteristicas().getQualidadePasse()*3+ 
							posicao.getJogador().getCaracteristicas().getFinalizacao()*2+posicao.getJogador().getCaracteristicas().getDesarme()*1+posicao.getPontuacao();
					
					pontuacaoParcial+=pontuacaoParcialAtual;
					System.out.println(pontuacaoParcialAtual+" "+posicao.getNome()+" "+posicao.getJogador().getNome());
					posicao.setPontuacaParcial(pontuacaoParcialAtual);
					qtdJogadores++;
				}
			}
			
			if(estilo.getNome().toLowerCase().equals("posse de bola")){
				if(posicao.getNome().toLowerCase().equals("meia atacante") || posicao.getNome().toLowerCase().equals("meia central")
						|| posicao.getNome().toLowerCase().equals("segundo atacante") || posicao.getNome().toLowerCase().equals("volante")
						){
					
					pontuacaoParcialAtual = posicao.getJogador().getCaracteristicas().getVelocidade() * 3 + posicao.getJogador().getCaracteristicas().getQualidadePasse()*4+ 
							posicao.getJogador().getCaracteristicas().getFinalizacao()*2+posicao.getJogador().getCaracteristicas().getDesarme()+posicao.getPontuacao();
					
					pontuacaoParcial +=pontuacaoParcialAtual;
					System.out.println(pontuacaoParcialAtual+" "+posicao.getNome()+" "+posicao.getJogador().getNome());
					posicao.setPontuacaParcial(pontuacaoParcialAtual);
					qtdJogadores++;
				}
				
			}
				
			/*}else{
				if(estilo.getNome().toLowerCase().equals("contra ataque")){
						for (int j = 0; j < time.getJogadores().get(i).getPosicoes().size(); j++) {
							posicao = time.getJogadores().get(i).getPosicoes().get(j);
							if(posicao.getNome().toLowerCase().equals("lateral") || posicao.getNome().toLowerCase().equals("meia lateral")
									||  posicao.getNome().toLowerCase().equals("meia atacante") || posicao.getNome().toLowerCase().equals("meia central")
									|| posicao.getNome().toLowerCase().equals("segundo atacante") || posicao.getNome().toLowerCase().equals("centro avante")
									|| posicao.getNome().toLowerCase().equals("ponta")){
								
								pontuacaoParcialAtual = posicao.getJogador().getCaracteristicas().getVelocidade() * 4 + posicao.getJogador().getCaracteristicas().getQualidadePasse()*2+ 
										posicao.getJogador().getCaracteristicas().getFinalizacao()*3+posicao.getJogador().getCaracteristicas().getDesarme()+posicao.getPontuacao();
								
								pontuacaoParcial+=pontuacaoParcialAtual;
								
								posicao.setPontuacaParcial(pontuacaoParcialAtual);
								qtdJogadores++;
							}
							
							
						}
						
					
						
				}
				
				if(estilo.getNome().toLowerCase().equals("retranca")){
					
						for (int j = 0; j < time.getJogadores().get(i).getPosicoes().size(); j++) {
							posicao = time.getJogadores().get(i).getPosicoes().get(j);
							if(posicao.getNome().toLowerCase().equals("lateral") || posicao.getNome().toLowerCase().equals("meia lateral")
									 || posicao.getNome().toLowerCase().equals("meia central")
									|| posicao.getNome().toLowerCase().equals("zagueiro")
									|| posicao.getNome().toLowerCase().equals("volante")){
								
								pontuacaoParcialAtual = posicao.getJogador().getCaracteristicas().getVelocidade() * 1 + posicao.getJogador().getCaracteristicas().getQualidadePasse()*2+ 
										posicao.getJogador().getCaracteristicas().getFinalizacao()*3+posicao.getJogador().getCaracteristicas().getDesarme()*4+posicao.getPontuacao();
								
								pontuacaoParcial+=pontuacaoParcialAtual;
								
								posicao.setPontuacaParcial(pontuacaoParcialAtual);
								qtdJogadores++;
							}
							
						}
						
				}
				if(estilo.getNome().toLowerCase().equals("bola longa")){
						for (int j = 0; j < time.getJogadores().get(i).getPosicoes().size(); j++) {
							posicao = time.getJogadores().get(i).getPosicoes().get(j);
							if(posicao.getNome().toLowerCase().equals("lateral") || posicao.getNome().toLowerCase().equals("meia lateral")
									 || posicao.getNome().toLowerCase().equals("segundo atacante")
									|| posicao.getNome().toLowerCase().equals("ponta") || posicao.getNome().toLowerCase().equals("meia central")){
								
								pontuacaoParcialAtual = posicao.getJogador().getCaracteristicas().getVelocidade() * 4 + posicao.getJogador().getCaracteristicas().getQualidadePasse()*3+ 
										posicao.getJogador().getCaracteristicas().getFinalizacao()*2+posicao.getJogador().getCaracteristicas().getDesarme()*1+posicao.getPontuacao();
								
								pontuacaoParcial+=pontuacaoParcialAtual;
								
								posicao.setPontuacaParcial(pontuacaoParcialAtual);
								qtdJogadores++;
							}
							
						}
						
						
				}
				if(estilo.getNome().toLowerCase().equals("posse de bola")){
						for (int j = 0; j < time.getJogadores().get(i).getPosicoes().size(); j++) {
							posicao = time.getJogadores().get(i).getPosicoes().get(j);
							if(posicao.getNome().toLowerCase().equals("meia atacante") || posicao.getNome().toLowerCase().equals("meia central")
									|| posicao.getNome().toLowerCase().equals("segundo atacante") || posicao.getNome().toLowerCase().equals("volante")
									){
								
								pontuacaoParcialAtual = posicao.getJogador().getCaracteristicas().getVelocidade() * 3 + posicao.getJogador().getCaracteristicas().getQualidadePasse()*4+ 
										posicao.getJogador().getCaracteristicas().getFinalizacao()*2+posicao.getJogador().getCaracteristicas().getDesarme()+posicao.getPontuacao();
								
								pontuacaoParcial +=pontuacaoParcialAtual;
								
								posicao.setPontuacaParcial(pontuacaoParcialAtual);
								qtdJogadores++;
							}
							
							
						}
						
						
				}*/
				
				
			}
		}
		
		pontuacaoParcialMedia = pontuacaoParcial/qtdJogadores;
		return pontuacaoParcialMedia;
		
	}
	
	public Jogador substituirJogador(Jogador jogador, Time time){
		Jogador jogadorSubstituto = new Jogador();
		Jogador jogadorX = new Jogador();
		int pontuacao = 0;
		for (int i = 0; i < time.getJogadores().size(); i++) {
			for (int j = 0; j < time.getJogadores().get(i).getPosicoes().size(); j++) {
				jogadorX = time.getJogadores().get(i);
				if(jogadorX.getPosicoes().get(j).getNome().equals(jogador.getPosicaoAtual().getNome()) && jogadorX.getEscolhido()==0 && pontuacao < jogadorX.getPosicoes().get(j).getPontuacao()){
					pontuacao = jogadorX.getPosicoes().get(j).getPontuacao();
					jogadorX.setEscolhido(1);
					jogador.setEscolhido(0);
					jogadorSubstituto = jogadorX;
					
				}
				
			}
	
		}	
		
		return jogadorSubstituto ;
	}
	
	public EstiloDeJogo gerarEstilodeJogoTime(OverallTime overallTime, OverallJogador overallJogador){
		EstiloDeJogo estilo = new EstiloDeJogo();
		ArrayList<EstiloDeJogo> estilosDeJogo = new ArrayList<EstiloDeJogo>();
		int retranca = 0, bolaLonga = 0, posseBola = 0, contraAtaque = 0, maior = 0;
		float retrancaJogador = 0, bolaLongaJogador = 0, posseBolaJogador = 0, contraAtaqueJogador = 0;
		retranca = overallTime.getVelocidade()*1+overallTime.getPasse()*2+overallTime.getFinalizacao()*3+overallTime.getDesarme()*4;
		bolaLonga = overallTime.getVelocidade()*4+overallTime.getPasse()*3+overallTime.getFinalizacao()*2+overallTime.getDesarme()*1;
		posseBola = overallTime.getVelocidade()*3+overallTime.getPasse()*4+overallTime.getFinalizacao()*2+overallTime.getDesarme()*1;
		contraAtaque = overallTime.getVelocidade()*4+overallTime.getPasse()*2+overallTime.getFinalizacao()*3+overallTime.getDesarme()*1;
		
		
		retrancaJogador = ((overallJogador.getDefensores() * 3 + overallJogador.getMeias()*2 + overallJogador.getAtacantes() *1)/6)-overallJogador.getTimeTodo();
		bolaLongaJogador = ((overallJogador.getDefensores() * 2 + overallJogador.getMeias()*1 + overallJogador.getAtacantes() *3)/6)-overallJogador.getTimeTodo();
		posseBolaJogador = ((overallJogador.getDefensores() * 1 + overallJogador.getMeias()*3 + overallJogador.getAtacantes() *2)/6)-overallJogador.getTimeTodo();
		contraAtaqueJogador = ((overallJogador.getDefensores() * 1 + overallJogador.getMeias()*2 + overallJogador.getAtacantes() *3)/6)-overallJogador.getTimeTodo();
		
		EstiloDeJogo estiloRetranca = new EstiloDeJogo("Retranca",retranca+retrancaJogador);
		EstiloDeJogo estiloBolaLonga = new EstiloDeJogo("Bola longa", bolaLonga+bolaLongaJogador);
		EstiloDeJogo estiloPosseBola = new EstiloDeJogo("Posse de bola", posseBola+posseBolaJogador);
		EstiloDeJogo estiloContraAtaque = new EstiloDeJogo("Contra ataque", contraAtaque+contraAtaqueJogador);
		
		
		estilosDeJogo.add(estiloContraAtaque);
		estilosDeJogo.add(estiloPosseBola);
		estilosDeJogo.add(estiloBolaLonga);
		estilosDeJogo.add(estiloRetranca);
		
		for (int i = 0; i < estilosDeJogo.size(); i++) {
			if(estilosDeJogo.get(i).getPontuacao() > maior){
				maior = (int) estilosDeJogo.get(i).getPontuacao();
				estilo = estilosDeJogo.get(i);	
			}
			
		}
		
		return estilo;
	}
	
	public OverallTime gerarOverallTime(Time time){
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
					System.out.println(velocidade);
					System.out.println(jogadoresVelocidade);
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
	
	public OverallJogador gerarOverallJogador(Time time){
		OverallJogador overall = new OverallJogador();
		Posicao posicao = new Posicao();
		int defensores = 0,qtdDefensores = 0, meias = 0, qtdMeias = 0, atacantes = 0, qtdAtacantes = 0;
		for (int i = 0; i < time.getJogadores().size(); i++) {
			posicao = time.getJogadores().get(i).getPosicaoAtual();
			if(posicao != null){
				if(posicao.getNome().toLowerCase().equals("zagueiro") || posicao.getNome().toLowerCase().equals("lateral") || posicao.getNome().toLowerCase().equals("volante")){
					defensores += time.getJogadores().get(i).getPosicaoAtual().getPontuacao();
					qtdDefensores++;
				}
				
				if(posicao.getNome().toLowerCase().equals("meia central") || posicao.getNome().toLowerCase().equals("meia atacante") || posicao.getNome().toLowerCase().equals("meia lateral")){
					meias += time.getJogadores().get(i).getPosicaoAtual().getPontuacao();
					qtdMeias++;	
				}
				
				if(posicao.getNome().toLowerCase().equals("segundo atacante") || posicao.getNome().toLowerCase().equals("centro avante") || posicao.getNome().toLowerCase().equals("ponta") ){
					atacantes += time.getJogadores().get(i).getPosicaoAtual().getPontuacao();
					qtdAtacantes++;
				}
				
			}
			
			else{
				for (int j = 0; j < time.getJogadores().get(i).getPosicoes().size(); j++) {
					posicao = time.getJogadores().get(i).getPosicoes().get(j);
					if(posicao.isPosicaoDeOrigem() && (posicao.getNome().toLowerCase().equals("zagueiro") || 
							posicao.getNome().toLowerCase().equals("lateral") || posicao.getNome().toLowerCase().equals("volante"))){
						defensores += time.getJogadores().get(i).getPosicoes().get(j).getPontuacao();
						qtdDefensores++;
					}
					
					if(posicao.isPosicaoDeOrigem() && (posicao.getNome().toLowerCase().equals("meia central") || 
							posicao.getNome().toLowerCase().equals("meia atacante") || posicao.getNome().toLowerCase().equals("meia lateral"))){
						meias += time.getJogadores().get(i).getPosicoes().get(j).getPontuacao();
						qtdMeias++;	
					}
					
					if(posicao.isPosicaoDeOrigem() && (posicao.getNome().toLowerCase().equals("segundo atacante") || 
							posicao.getNome().toLowerCase().equals("centro avante") || posicao.getNome().toLowerCase().equals("ponta"))){
						atacantes += time.getJogadores().get(i).getPosicoes().get(j).getPontuacao();
						qtdAtacantes++;
					}
				}
				
			}	
			
		}
		overall.setAtacantes(atacantes/qtdAtacantes);
		overall.setDefensores(defensores/qtdDefensores);
		overall.setMeias(meias/qtdMeias);
		overall.setTimeTodo((atacantes + meias + defensores)/(qtdAtacantes+qtdMeias+qtdDefensores));
		return overall;
	}

}
