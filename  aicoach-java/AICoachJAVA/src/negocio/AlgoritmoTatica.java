package negocio;

import java.util.ArrayList;
import java.util.Collections;

import perssistencia.TaticaDAO;
import perssistencia.TimeDAO;
import dominio.DiferencaTime;
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
			System.out.println(posicao.getIdPosicaoTela()+" "+posicao.getNome());
			for(Jogador jogador : time.getJogadores()){

				
				for(Posicao posicaoComparada: jogador.getPosicoes()){
					//System.out.println(jogador.getNome()+ " "+posicaoComparada.isPosicaoDeOrigem()+" "+posicaoComparada.getPontuacao());
					
					if(posicao.getNome().toLowerCase().equals(posicaoComparada.getNome().toLowerCase()) && posicaoComparada.getJogador().getEscolhido()==0/*posicaoComparada.isPosicaoDeOrigem()*/ && !jogadoresClone.contains(jogador)){
						if(ptMaior<posicaoComparada.getPontuacao()){
							
							ptMaior=posicaoComparada.getPontuacao();
							
							posicaoX=posicaoComparada;
							posicaoX.setIdPosicaoTela(posicao.getIdPosicaoTela());
			
							
						}
						
						
					}
					
				}
				
			}
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
		//TimeDAO timeDAO=new TimeDAO();
		//Time timeTemporario= timeDAO.retornarTime(time.getIdTime());
		TaticaDAO taticaDAO=new TaticaDAO();
		
		int maiorPontuacaoParcialMedia = 0, pontuacaoParcialMediaAtual = 0;
		for (int i = 0; i < taticas.size(); i++) {
			time.setTatica(taticas.get(i));
			//time.setTatica(taticaDAO.retornarTatica(taticas.get(i).getIdTatica()));
			for (int j = 0; j < time.getJogadores().size(); j++) {
				time.getJogadores().get(j).setEscolhido(0);
				
			}
			//time.setJogadores(timeTemporario.getJogadores());
			this.SugerirJogadores(time);
			pontuacaoParcialMediaAtual = this.gerarPontuacaoParcial(time);
			System.out.println("pontuacao media: "+pontuacaoParcialMediaAtual);
			if(pontuacaoParcialMediaAtual>=maiorPontuacaoParcialMedia){
				maiorPontuacaoParcialMedia = pontuacaoParcialMediaAtual;
				tatica= taticas.get(i);
				//tatica = taticaDAO.retornarTatica(taticas.get(i).getIdTatica());
				System.out.println("Maior pontuacao media"+maiorPontuacaoParcialMedia);
			}
		}
		time.setTatica(tatica);
		System.out.println(time.getEstiloDeJogo().getNome());
		return tatica;
	}
	
	public Tatica sugerirTatica(Time time, ArrayList<Tatica> taticas, EstiloDeJogo ej){
		Tatica tatica = new Tatica();
		int maiorPontuacaoParcialMedia = 0, pontuacaoParcialMediaAtual = 0;
		for (int i = 0; i < taticas.size(); i++) {
			time.setTatica(taticas.get(i));
			for (int j = 0; j < time.getJogadores().size(); j++) {
				time.getJogadores().get(j).setEscolhido(0);
				
			}
			this.SugerirJogadores(time);
			pontuacaoParcialMediaAtual = this.gerarPontuacaoParcial(time, ej);
			if(pontuacaoParcialMediaAtual>=maiorPontuacaoParcialMedia){
				maiorPontuacaoParcialMedia = pontuacaoParcialMediaAtual;
				tatica = taticas.get(i);
			}
		}
		time.setTatica(tatica);
		System.out.println(time.getEstiloDeJogo().getNome());
		return tatica;
	}
	

	public int gerarPontuacaoParcial(Time time){
		int pontuacaoParcialAtual = 0, qtdJogadores = 0, pontuacaoParcialMedia = 0, pontuacaoParcial = 0;
		Posicao posicao = new Posicao();
		EstiloDeJogo estilo = new EstiloDeJogo();
		estilo = this.gerarEstilodeJogoTime(this.gerarOverallTime(time), this.gerarOverallJogador(time));
		time.setEstiloDeJogo(estilo);
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
	
	public int gerarPontuacaoParcial(Time time, EstiloDeJogo estilo){
		int pontuacaoParcialAtual = 0, qtdJogadores = 0, pontuacaoParcialMedia = 0, pontuacaoParcial = 0;
		Posicao posicao = new Posicao();
		//EstiloDeJogo estilo = new EstiloDeJogo();
		//estilo = this.gerarEstilodeJogoTime(this.gerarOverallTime(time), this.gerarOverallJogador(time));
		time.setEstiloDeJogo(estilo);
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
				//System.out.println(jogadorX.getNome()+" "+jogadorX.getPosicoes().get(j).getPontuacao()+" "+jogadorX.getEscolhido());
				if(jogadorX.getPosicoes().get(j).getNome().toLowerCase().equals(jogador.getPosicaoAtual().getNome().toLowerCase()) && jogadorX.getEscolhido()==0 && pontuacao < jogadorX.getPosicoes().get(j).getPontuacao() && !jogador.equals(jogadorX)){
					//System.out.println("Depois do IF "+jogadorX.getNome()+" "+jogadorX.getPosicoes().get(j).getPontuacao());
					pontuacao = jogadorX.getPosicoes().get(j).getPontuacao();
					jogador.setEscolhido(0);
					jogadorSubstituto = jogadorX;
					jogadorSubstituto.setPosicaoAtual(jogadorX.getPosicoes().get(j));
					
				}
				
			}
	
		}
		jogadorSubstituto.setEscolhido(1);
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
		
		estilo.setOverallJogador(overallJogador);
		estilo.setOverallTime(overallTime);
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
	
	public void alterarEsquema(Time time, int substituicoes, Tatica novaTatica){
		for (int j = 0; j < time.getJogadores().size(); j++) {
			if(time.getJogadores().get(j).getEscolhido()==1){
				time.getJogadores().get(j).setEscolhido(0);
			}
			else{
				time.getJogadores().get(j).setEscolhido(2);
			}
		}
		
		ArrayList<Integer>listaPontos=new ArrayList<Integer>();
		
		time.setTatica(novaTatica);
		SugerirJogadores(time);
		int qtdSubstituicoes=substituicoes;
		for (int i = 0; i < time.getTatica().getPosicoes().size(); i++) {
			listaPontos.add(time.getTatica().getPosicoes().get(i).getPontuacao());
			
		}
		for (int j = 0; j < time.getJogadores().size(); j++) {
			if(time.getJogadores().get(j).getEscolhido()==2){
				time.getJogadores().get(j).setEscolhido(0);
			}
		}
		Collections.sort(listaPontos);
		for (int i = 0; i < qtdSubstituicoes; i++) {
			for(Posicao p:time.getTatica().getPosicoes()){
				if(p.getJogador()!=null){
					if(listaPontos.get(i)==p.getPontuacao()){
						Jogador j=p.getJogador();
						p.setJogador(substituirJogador(j, time));
						p.setPontuacao(p.getJogador().getPosicaoAtual().getPontuacao());
						j.setEscolhido(2);
						break;
						
					}
				}
			}
		}
		
		for (int j = 0; j < time.getJogadores().size(); j++) {
			if(time.getJogadores().get(j).getEscolhido()==2){
				time.getJogadores().get(j).setEscolhido(0);
			}
		}
		
	}
	
	public void substituirUmJogador(Time time, Jogador jogador, Tatica novaTatica){
		for (int j = 0; j < time.getJogadores().size(); j++) {
			if(time.getJogadores().get(j).getEscolhido()==1){
				time.getJogadores().get(j).setEscolhido(0);
			}
			else{
				time.getJogadores().get(j).setEscolhido(2);
			}
		}
		
		ArrayList<Integer>listaPontos=new ArrayList<Integer>();
		
		time.setTatica(novaTatica);
		SugerirJogadores(time);
		for (int i = 0; i < time.getTatica().getPosicoes().size(); i++) {
			listaPontos.add(time.getTatica().getPosicoes().get(i).getPontuacao());
			
		}
		for (int j = 0; j < time.getJogadores().size(); j++) {
			if(time.getJogadores().get(j).getEscolhido()==2){
				time.getJogadores().get(j).setEscolhido(0);
			}
		}
		Collections.sort(listaPontos);
			for(Posicao p:time.getTatica().getPosicoes()){
				if(p.getJogador()!=null){
					if(p.getJogador().equals(jogador)){
						Jogador j=p.getJogador();
						p.setJogador(substituirJogador(j, time));
						p.setPontuacao(p.getJogador().getPosicaoAtual().getPontuacao());
						j.setEscolhido(2);
						break;
						
					}
				}
			}
		
		
		for (int j = 0; j < time.getJogadores().size(); j++) {
			if(time.getJogadores().get(j).getEscolhido()==2){
				time.getJogadores().get(j).setEscolhido(0);
			}
		}
		
		
	}
	
	public void combaterTatica(Time meuTime, Time timeAdversario, ArrayList <Tatica> taticas){
		sugerirTatica(timeAdversario, taticas);
		EstiloDeJogo estiloAdversario=timeAdversario.getEstiloDeJogo();
		OverallTime overallTime =estiloAdversario.getOverallTime();
		OverallJogador overallJogador= estiloAdversario.getOverallJogador();
		
		Time timeTemporario=new Time();
		timeTemporario.setJogadores(meuTime.getJogadores());
		sugerirTatica(timeTemporario, taticas);
		
		OverallTime overallMeuTime =timeTemporario.getEstiloDeJogo().getOverallTime();
		OverallJogador overallMeuJogador= timeTemporario.getEstiloDeJogo().getOverallJogador();
		/*System.out.println(overallTime.getDesarme()+" "+overallTime.getFinalizacao()+" "+overallTime.getPasse()+" "+overallTime.getVelocidade());
		System.out.println(overallMeuTime.getDesarme()+" "+overallMeuTime.getFinalizacao()+" "+overallMeuTime.getPasse()+" "+overallMeuTime.getVelocidade());
		
		System.out.println(overallJogador.getDefensores()+" "+overallJogador.getMeias()+" "+overallJogador.getAtacantes()+" "+overallJogador.getTimeTodo());

		System.out.println(overallMeuJogador.getDefensores()+" "+overallMeuJogador.getMeias()+" "+overallMeuJogador.getAtacantes()+" "+overallMeuJogador.getTimeTodo());
		*/
		DiferencaTime dT=retorneDiferenca(overallMeuJogador.getTimeTodo(), overallJogador.getTimeTodo());
		
		EstiloDeJogo eJMeuTime=retorneEstiloComBaseNoAdversario(dT, overallJogador);
		TaticaDAO tDAO=new TaticaDAO();
		
		sugerirTatica(meuTime, tDAO.retornarListaTaticas(), eJMeuTime);
		//alterarEsquema(meuTime, 0, tDAO.retornarTatica(tatica.getNome()));
		//System.out.println(dT.getTipoDiferenca()+" "+dT.isMeuTimeFavorito());
		
		//System.out.println("Time temporário "+timeTemporario.getEstiloDeJogo().getNome());
		//System.out.println("Meu time "+meuTime.getEstiloDeJogo().getNome());
		
	}
	
	private DiferencaTime retorneDiferenca(int overallMeuTime, int overallAdversario){
		int diferenca=overallMeuTime-overallAdversario;
		String estiloDiferenca="equilíbrio";
		DiferencaTime d=null;
		if(diferenca>=-3 && diferenca <=3){
			estiloDiferenca="equilíbrio";
			d= new DiferencaTime(estiloDiferenca, false);
		}
		else{
			if(diferenca>0){
				if(diferenca>=3 && diferenca <=5){
					estiloDiferenca="leve vantagem";
				}
				
				if(diferenca>5 && diferenca <=10){
					estiloDiferenca="favoritismo";
				}

				if(diferenca>10){
					estiloDiferenca="muito favoritismo";
				}
				
				d= new DiferencaTime(estiloDiferenca, true);
			}
			
			if(diferenca<0){
				diferenca=diferenca*(-1);
				if(diferenca>=3 && diferenca <=5){
					estiloDiferenca="leve vantagem";
				}
				
				if(diferenca>5 && diferenca <=10){
					estiloDiferenca="favoritismo";
				}

				if(diferenca>10){
					estiloDiferenca="muito favoritismo";
				}
				d= new DiferencaTime(estiloDiferenca, false);
			}
		}
		
		return d;
		
	}
	
	private EstiloDeJogo retorneEstiloComBaseNoAdversario(DiferencaTime dT, OverallJogador overallTimeAdversario){
		EstiloDeJogo eJ=null;
		OverallJogador ov=overallTimeAdversario;
		ArrayList <Integer> listaOverall=new ArrayList<Integer>();
		listaOverall.add(ov.getDefensores());
		listaOverall.add(ov.getMeias());
		listaOverall.add(ov.getAtacantes());
		
		String ovMaior="", ovMenor="", tipoEstilo="contra ataque";
		int maior=0;
		int menor=2345;
		
		for (int i = 0; i < 3; i++) {
			if(listaOverall.get(i) > maior){
				maior = listaOverall.get(i);
				if(i==0){
					ovMaior="defensores";
				}
				if(i==1){
					ovMaior="meias";
				}
				if(i==2){
					ovMaior="atacantes";
				}	
			}
			if(listaOverall.get(i) < menor){
				menor = listaOverall.get(i);
				if(i==0){
					ovMenor="defensores";
				}
				if(i==1){
					ovMenor="meias";
				}
				if(i==2){
					ovMenor="atacantes";
				}	
			}
			
			
		}
		
		if(dT.isMeuTimeFavorito()){
			if(dT.getTipoDiferenca().equals("leve vantagem")){
				if(ovMenor.equals("defensores")){
					tipoEstilo="posse de bola";					
				}
				if(ovMenor.equals("meias")){
					tipoEstilo="posse de bola";					
				}
				if(ovMenor.equals("atacantes")){
					tipoEstilo="bola longa";					
				}
			}
			
			if(dT.getTipoDiferenca().equals("favoritismo")){
				if(ovMenor.equals("defensores")){
					tipoEstilo="bola longa";					
				}
				if(ovMenor.equals("atacantes")||ovMaior.equals("meias")){
					tipoEstilo="posse de bola";					
				}
			}
			
			if(dT.getTipoDiferenca().equals("muito favoritismo")){
				tipoEstilo="posse de bola";
			}
		}
		else{
			if(dT.getTipoDiferenca().equals("equilíbrio")){
				if(ovMenor.equals("defensores")){
					tipoEstilo="contra ataque";					
				}
				if(ovMenor.equals("meias")){
					tipoEstilo="posse de bola";					
				}
				if(ovMenor.equals("atacantes")){
					tipoEstilo="bola longa";					
				}
			}
			
			if(dT.getTipoDiferenca().equals("leve vantagem")){
				if(ovMaior.equals("defensores")){
					tipoEstilo="posse de bola";					
				}
				if(ovMaior.equals("meias")){
					tipoEstilo="bola longa";					
				}
				if(ovMaior.equals("atacantes")){
					tipoEstilo="posse bola";					
				}
			}
			
			if(dT.getTipoDiferenca().equals("favoritismo")){
				if(ovMaior.equals("defensores")){
					tipoEstilo="bola longa";					
				}
				if(ovMaior.equals("atacantes")||ovMaior.equals("meias")){
					tipoEstilo="contra ataque";					
				}
			}
			
			if(dT.getTipoDiferenca().equals("muito favoritismo")){
				tipoEstilo="retranca";
			}
		}
		
		eJ=new EstiloDeJogo(tipoEstilo, 0);
		return eJ;
		
		
	}

}
