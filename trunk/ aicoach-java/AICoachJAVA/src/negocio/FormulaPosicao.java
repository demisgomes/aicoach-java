package negocio;

import java.util.ArrayList;

import dominio.CaracteristicasJogadores;
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
		
		int somaCaracteristicas = (ressistencia * 5) + (cabeceio*2) + (finalizacao*3) + (velocidade*6) +
				(bolaParada*7) + (qualidadePasse*8) + (controleBola*9) + (drible*1) + (desarme*4) + (defesa*10);
		
		float resultadoJogador = somaCaracteristicas/somaPesos;
		float pontuacaoFinal = (resultadoJogador/jogadorIdeal)*100;
		ArrayList<Posicao> posicoes = jogador.getPosicoes();
		for (int i = 0; i < posicoes.size(); i++) {
			if(posicoes.get(i).getNome().toLowerCase() == "goleiro" && posicoes.get(i).isPosicaoDeOrigem()){
				pontuacaoFinal =  (pontuacaoFinal * 1.1f);
				
			}
		}
		return (int) pontuacaoFinal;
	}
	
	public int calcularZG(){
		//todo
		return 0;
	}
	
	public int calcularLT(){
		//todo
		return 0;
	}
	
	public int calcularMA(){
		//todo
		return 0;
	}
	
	public int calcularMC(){
		//todo
		return 0;
	}
	
	public int calcularML(){
		//todo
		return 0;
	}
	
	public int calcularSA(){
		//todo
		return 0;
	}
	
	public int calcularCA(){
		//todo
		return 0;
	}
	
	

}
