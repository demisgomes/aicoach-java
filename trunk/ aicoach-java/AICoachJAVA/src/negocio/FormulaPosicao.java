package negocio;

import java.util.ArrayList;

import dominio.Jogador;
import dominio.Posicao;

public class FormulaPosicao {
	
	private static final int jogadorIdeal = 7;
	private static final int somaPesos = 55;
	
	public int calcularGL(Jogador jogador){
		int ressistencia = jogador.getCaracteristicas().getResistencia();
		int cabeceio = jogador.getCaracteristicas().getCabeceio();
		int finalizacao = jogador.getCaracteristicas().getFinalizacao();
		int velocidade = jogador.getCaracteristicas().getVelocidade();
		int bolaParada = jogador.getCaracteristicas().getBolaParada();
		int qualidadePasse = jogador.getCaracteristicas().getQualidadePasse();
		int controleBola = jogador.getCaracteristicas().getControleBola();
		int drible = jogador.getCaracteristicas().getDrible();
		int desarme = jogador.getCaracteristicas().getDesarme();
		int defesa = jogador.getCaracteristicas().getDefesas();
		
		float somaCaracteristicas = (ressistencia * 5) + (cabeceio*2) + (finalizacao*3) + (velocidade*6) +
				(bolaParada*7) + (qualidadePasse*8) + (controleBola*9) + (drible*1) + (desarme*4) + (defesa*10);
		
		float resultadoJogador = somaCaracteristicas/somaPesos;
		float pontuacaoFinal = (resultadoJogador/jogadorIdeal)*100;
		ArrayList<Posicao> posicoes = jogador.getPosicoes();
		for (int i = 0; i < posicoes.size(); i++) {
			if(posicoes.get(i).getNome().toLowerCase() == "goleiro" && posicoes.get(i).isPosicaoDeOrigem()){
				pontuacaoFinal =  (pontuacaoFinal * 1.1f);
				break;
			}else if(posicoes.size()-1 == i){
				pontuacaoFinal = (pontuacaoFinal *0.5f);
			}
		}
		
		
		//add no array da pontuacao de posicoes
		
		jogador.getPontuacaoPosicoes()[0]=(int)pontuacaoFinal;
		return (int) pontuacaoFinal;
	}
	
	public int calcularZG(Jogador jogador){
		int ressistencia = jogador.getCaracteristicas().getResistencia();
		int cabeceio = jogador.getCaracteristicas().getCabeceio();
		int finalizacao = jogador.getCaracteristicas().getFinalizacao();
		int velocidade = jogador.getCaracteristicas().getVelocidade();
		int bolaParada = jogador.getCaracteristicas().getBolaParada();
		int qualidadePasse = jogador.getCaracteristicas().getQualidadePasse();
		int controleBola = jogador.getCaracteristicas().getControleBola();
		int drible = jogador.getCaracteristicas().getDrible();
		int desarme = jogador.getCaracteristicas().getDesarme();
		int defesa = jogador.getCaracteristicas().getDefesas();
		
		float somaCaracteristicas = (ressistencia * 5) + (cabeceio*9) + (finalizacao*4) + (velocidade*8) +
				(bolaParada*3) + (qualidadePasse*7) + (controleBola*6) + (drible*2) + (desarme*10) + (defesa*1);
	
		float resultadoJogador = somaCaracteristicas/somaPesos;
	
		float pontuacaoFinal = (resultadoJogador/jogadorIdeal)*100;
		ArrayList<Posicao> posicoes = jogador.getPosicoes();
		for (int i = 0; i < posicoes.size(); i++) {
			if(posicoes.get(i).getNome().toLowerCase() == "zagueiro" && posicoes.get(i).isPosicaoDeOrigem()){
				pontuacaoFinal =  (pontuacaoFinal * 1.1f);
				break;
			}else if(posicoes.size()-1 == i){
				pontuacaoFinal = (pontuacaoFinal * 0.8f);
			}
		}
		//add no array da pontuacao de posicoes
		
		jogador.getPontuacaoPosicoes()[2]=(int)pontuacaoFinal;
		
		return (int) pontuacaoFinal;
		
	}
	
	public int calcularLT(Jogador jogador){
		int ressistencia = jogador.getCaracteristicas().getResistencia();
		int cabeceio = jogador.getCaracteristicas().getCabeceio();
		int finalizacao = jogador.getCaracteristicas().getFinalizacao();
		int velocidade = jogador.getCaracteristicas().getVelocidade();
		int bolaParada = jogador.getCaracteristicas().getBolaParada();
		int qualidadePasse = jogador.getCaracteristicas().getQualidadePasse();
		int controleBola = jogador.getCaracteristicas().getControleBola();
		int drible = jogador.getCaracteristicas().getDrible();
		int desarme = jogador.getCaracteristicas().getDesarme();
		int defesa = jogador.getCaracteristicas().getDefesas();
		
		float somaCaracteristicas = (ressistencia * 10) + (cabeceio*2) + (finalizacao*4) + (velocidade*9) +
				(bolaParada*6) + (qualidadePasse*8) + (controleBola*3) + (drible*5) + (desarme*7) + (defesa*1);
		
		float resultadoJogador = somaCaracteristicas/somaPesos;
		float pontuacaoFinal = (resultadoJogador/jogadorIdeal)*100;
		ArrayList<Posicao> posicoes = jogador.getPosicoes();
		for (int i = 0; i < posicoes.size(); i++) {
			if(posicoes.get(i).getNome().toLowerCase() == "lateral" && posicoes.get(i).isPosicaoDeOrigem()){
				pontuacaoFinal =  (pontuacaoFinal * 1.1f);
				break;
			}else if(posicoes.size()-1 == i){
				pontuacaoFinal = (pontuacaoFinal*0.8f);
			}
		}
		//add no array da pontuacao de posicoes
		
				jogador.getPontuacaoPosicoes()[1]=(int)pontuacaoFinal;
		
		return (int) pontuacaoFinal;
	}
	
	public int calcularMA(Jogador jogador){
		int ressistencia = jogador.getCaracteristicas().getResistencia();
		int cabeceio = jogador.getCaracteristicas().getCabeceio();
		int finalizacao = jogador.getCaracteristicas().getFinalizacao();
		int velocidade = jogador.getCaracteristicas().getVelocidade();
		int bolaParada = jogador.getCaracteristicas().getBolaParada();
		int qualidadePasse = jogador.getCaracteristicas().getQualidadePasse();
		int controleBola = jogador.getCaracteristicas().getControleBola();
		int drible = jogador.getCaracteristicas().getDrible();
		int desarme = jogador.getCaracteristicas().getDesarme();
		int defesa = jogador.getCaracteristicas().getDefesas();
		
		float somaCaracteristicas = (ressistencia * 5) + (cabeceio*2) + (finalizacao*6) + (velocidade*9) +
				(bolaParada*4) + (qualidadePasse*8) + (controleBola*7) + (drible*10) + (desarme*3) + (defesa*1);
		
		float resultadoJogador = somaCaracteristicas/somaPesos;
		float pontuacaoFinal = (resultadoJogador/jogadorIdeal)*100;
		ArrayList<Posicao> posicoes = jogador.getPosicoes();
		for (int i = 0; i < posicoes.size(); i++) {
			if(posicoes.get(i).getNome().toLowerCase() == "meia atacante" && posicoes.get(i).isPosicaoDeOrigem()){
				pontuacaoFinal =  (pontuacaoFinal * 1.1f);
				break;
			}else if(posicoes.size()-1 == i){
				pontuacaoFinal = (pontuacaoFinal*0.8f);
			}
		}
		
		//add no array da pontuacao de posicoes
		
				jogador.getPontuacaoPosicoes()[6]=(int)pontuacaoFinal;
		return (int) pontuacaoFinal;
	}
	
	public int calcularMC(Jogador jogador){
		int ressistencia = jogador.getCaracteristicas().getResistencia();
		int cabeceio = jogador.getCaracteristicas().getCabeceio();
		int finalizacao = jogador.getCaracteristicas().getFinalizacao();
		int velocidade = jogador.getCaracteristicas().getVelocidade();
		int bolaParada = jogador.getCaracteristicas().getBolaParada();
		int qualidadePasse = jogador.getCaracteristicas().getQualidadePasse();
		int controleBola = jogador.getCaracteristicas().getControleBola();
		int drible = jogador.getCaracteristicas().getDrible();
		int desarme = jogador.getCaracteristicas().getDesarme();
		int defesa = jogador.getCaracteristicas().getDefesas();
		
		float somaCaracteristicas = (ressistencia * 2) + (cabeceio*3) + (finalizacao*5) + (velocidade*4) +
				(bolaParada*7) + (qualidadePasse*10) + (controleBola*9) + (drible*8) + (desarme*6) + (defesa*1);
		
		float resultadoJogador = somaCaracteristicas/somaPesos;
		float pontuacaoFinal = (resultadoJogador/jogadorIdeal)*100;
		ArrayList<Posicao> posicoes = jogador.getPosicoes();
		for (int i = 0; i < posicoes.size(); i++) {
			if(posicoes.get(i).getNome().toLowerCase() == "meia central" && posicoes.get(i).isPosicaoDeOrigem()){
				pontuacaoFinal =  (pontuacaoFinal * 1.1f);
				break;
			}else if(posicoes.size()-1 == i){
				pontuacaoFinal = (pontuacaoFinal*0.8f);
			}
		}
		//add no array da pontuacao de posicoes
		
				jogador.getPontuacaoPosicoes()[4]=(int)pontuacaoFinal;
		
		return (int) pontuacaoFinal;
	}
	
	public int calcularML(Jogador jogador){
		int ressistencia = jogador.getCaracteristicas().getResistencia();
		int cabeceio = jogador.getCaracteristicas().getCabeceio();
		int finalizacao = jogador.getCaracteristicas().getFinalizacao();
		int velocidade = jogador.getCaracteristicas().getVelocidade();
		int bolaParada = jogador.getCaracteristicas().getBolaParada();
		int qualidadePasse = jogador.getCaracteristicas().getQualidadePasse();
		int controleBola = jogador.getCaracteristicas().getControleBola();
		int drible = jogador.getCaracteristicas().getDrible();
		int desarme = jogador.getCaracteristicas().getDesarme();
		int defesa = jogador.getCaracteristicas().getDefesas();
		
		float somaCaracteristicas = (ressistencia * 6) + (cabeceio*2) + (finalizacao*3) + (velocidade*8) +
				(bolaParada*5) + (qualidadePasse*9) + (controleBola*7) + (drible*10) + (desarme*4) + (defesa*1);
		
		float resultadoJogador = somaCaracteristicas/somaPesos;
		float pontuacaoFinal = (resultadoJogador/jogadorIdeal)*100;
		ArrayList<Posicao> posicoes = jogador.getPosicoes();
		for (int i = 0; i < posicoes.size(); i++) {
			if(posicoes.get(i).getNome().toLowerCase() == "meia lateral" && posicoes.get(i).isPosicaoDeOrigem()){
				pontuacaoFinal =  (pontuacaoFinal * 1.1f);
				break;
			}else if(posicoes.size()-1 == i){
				pontuacaoFinal = (pontuacaoFinal*0.8f);
			}
		}
		
		//add no array da pontuacao de posicoes
		
				jogador.getPontuacaoPosicoes()[5]=(int)pontuacaoFinal;
		
		return (int) pontuacaoFinal;
	}
	
	public int calcularVol(Jogador jogador){
		int ressistencia = jogador.getCaracteristicas().getResistencia();
		int cabeceio = jogador.getCaracteristicas().getCabeceio();
		int finalizacao = jogador.getCaracteristicas().getFinalizacao();
		int velocidade = jogador.getCaracteristicas().getVelocidade();
		int bolaParada = jogador.getCaracteristicas().getBolaParada();
		int qualidadePasse = jogador.getCaracteristicas().getQualidadePasse();
		int controleBola = jogador.getCaracteristicas().getControleBola();
		int drible = jogador.getCaracteristicas().getDrible();
		int desarme = jogador.getCaracteristicas().getDesarme();
		int defesa = jogador.getCaracteristicas().getDefesas();
		
		float somaCaracteristicas = (ressistencia * 6) + (cabeceio*7) + (finalizacao*2) + (velocidade*5) +
				(bolaParada*4) + (qualidadePasse*9) + (controleBola*8) + (drible*3) + (desarme*10) + (defesa*1);
		
		float resultadoJogador = somaCaracteristicas/somaPesos;
		float pontuacaoFinal = (resultadoJogador/jogadorIdeal)*100;
		ArrayList<Posicao> posicoes = jogador.getPosicoes();
		for (int i = 0; i < posicoes.size(); i++) {
			if(posicoes.get(i).getNome().toLowerCase() == "volante" && posicoes.get(i).isPosicaoDeOrigem()){
				pontuacaoFinal =  (pontuacaoFinal * 1.1f);
				break;
			}else if(posicoes.size()-1 == i){
				pontuacaoFinal = (pontuacaoFinal*0.8f);
			}
		}
		return (int) pontuacaoFinal;
		
	}
	
	public int calcularPT(Jogador jogador){
		int ressistencia = jogador.getCaracteristicas().getResistencia();
		int cabeceio = jogador.getCaracteristicas().getCabeceio();
		int finalizacao = jogador.getCaracteristicas().getFinalizacao();
		int velocidade = jogador.getCaracteristicas().getVelocidade();
		int bolaParada = jogador.getCaracteristicas().getBolaParada();
		int qualidadePasse = jogador.getCaracteristicas().getQualidadePasse();
		int controleBola = jogador.getCaracteristicas().getControleBola();
		int drible = jogador.getCaracteristicas().getDrible();
		int desarme = jogador.getCaracteristicas().getDesarme();
		int defesa = jogador.getCaracteristicas().getDefesas();
		
		float somaCaracteristicas = (ressistencia * 5) + (cabeceio*2) + (finalizacao*9) + (velocidade*10) +
				(bolaParada*4) + (qualidadePasse*8) + (controleBola*7) + (drible*6) + (desarme*3) + (defesa*1);
		
		float resultadoJogador = somaCaracteristicas/somaPesos;
		float pontuacaoFinal = (resultadoJogador/jogadorIdeal)*100;
		ArrayList<Posicao> posicoes = jogador.getPosicoes();
		for (int i = 0; i < posicoes.size(); i++) {
			if(posicoes.get(i).getNome().toLowerCase() == "ponta" && posicoes.get(i).isPosicaoDeOrigem()){
				pontuacaoFinal =  (pontuacaoFinal * 1.1f);
				break;
			}else if(posicoes.size()-1 == i){
				pontuacaoFinal = (pontuacaoFinal*0.8f);
			}
		}
		return (int) pontuacaoFinal;
	}
	
	public int calcularSA(Jogador jogador){
		int ressistencia = jogador.getCaracteristicas().getResistencia();
		int cabeceio = jogador.getCaracteristicas().getCabeceio();
		int finalizacao = jogador.getCaracteristicas().getFinalizacao();
		int velocidade = jogador.getCaracteristicas().getVelocidade();
		int bolaParada = jogador.getCaracteristicas().getBolaParada();
		int qualidadePasse = jogador.getCaracteristicas().getQualidadePasse();
		int controleBola = jogador.getCaracteristicas().getControleBola();
		int drible = jogador.getCaracteristicas().getDrible();
		int desarme = jogador.getCaracteristicas().getDesarme();
		int defesa = jogador.getCaracteristicas().getDefesas();
		
		float somaCaracteristicas = (ressistencia * 3) + (cabeceio*6) + (finalizacao*10) + (velocidade*8) +
				(bolaParada*4) + (qualidadePasse*5) + (controleBola*7) + (drible*8) + (desarme*2) + (defesa*1);
		
		float resultadoJogador = somaCaracteristicas/somaPesos;
		float pontuacaoFinal = (resultadoJogador/jogadorIdeal)*100;
		ArrayList<Posicao> posicoes = jogador.getPosicoes();
		for (int i = 0; i < posicoes.size(); i++) {
			if(posicoes.get(i).getNome().toLowerCase() == "segundo atacante" && posicoes.get(i).isPosicaoDeOrigem()){
				pontuacaoFinal =  (pontuacaoFinal * 1.1f);
				break;
			}else if(posicoes.size()-1 == i){
				pontuacaoFinal = (pontuacaoFinal*0.8f);
			}
		}
		//add no array da pontuacao de posicoes
		
				jogador.getPontuacaoPosicoes()[8]=(int)pontuacaoFinal;
		return (int) pontuacaoFinal;
	}
	
	public int calcularCA(Jogador jogador){
		int ressistencia = jogador.getCaracteristicas().getResistencia();
		int cabeceio = jogador.getCaracteristicas().getCabeceio();
		int finalizacao = jogador.getCaracteristicas().getFinalizacao();
		int velocidade = jogador.getCaracteristicas().getVelocidade();
		int bolaParada = jogador.getCaracteristicas().getBolaParada();
		int qualidadePasse = jogador.getCaracteristicas().getQualidadePasse();
		int controleBola = jogador.getCaracteristicas().getControleBola();
		int drible = jogador.getCaracteristicas().getDrible();
		int desarme = jogador.getCaracteristicas().getDesarme();
		int defesa = jogador.getCaracteristicas().getDefesas();
		
		float somaCaracteristicas = (ressistencia * 3) + (cabeceio*9) + (finalizacao*10) + (velocidade*7) +
				(bolaParada*4) + (qualidadePasse*5) + (controleBola*8) + (drible*6) + (desarme*2) + (defesa*1);
		
		float resultadoJogador = somaCaracteristicas/somaPesos;
		float pontuacaoFinal = (resultadoJogador/jogadorIdeal)*100;
		ArrayList<Posicao> posicoes = jogador.getPosicoes();
		for (int i = 0; i < posicoes.size(); i++) {
			if(posicoes.get(i).getNome().toLowerCase() == "centro avante" && posicoes.get(i).isPosicaoDeOrigem()){
				pontuacaoFinal =  (pontuacaoFinal * 1.1f);
				break;
				
				
			}else if(posicoes.size()-1 == i){
				pontuacaoFinal = (pontuacaoFinal*0.8f);
			}
		}
		
		//add no array da pontuacao de posicoes
		
				jogador.getPontuacaoPosicoes()[9]=(int)pontuacaoFinal;
		return (int) pontuacaoFinal;
	}
	
	public void calculeTodasPosicoes(Jogador jogador){
		
	}
	
	

}
