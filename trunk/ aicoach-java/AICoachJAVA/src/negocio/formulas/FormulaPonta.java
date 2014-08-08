package negocio.formulas;

import java.util.ArrayList;

import dominio.Jogador;
import dominio.Posicao;

public class FormulaPonta extends FormulaPosicao{

	@Override
	public int calcularPontuacao(Jogador jogador) {
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
		
		float resultadoJogador = somaCaracteristicas/getSomapesos();
		float pontuacaoFinal = (resultadoJogador/getJogadorideal())*100;
		ArrayList<Posicao> posicoes = jogador.getPosicoes();
		for (int i = 0; i < posicoes.size(); i++) {
			if(posicoes.get(i).getNome().toLowerCase().equals("ponta") && posicoes.get(i).isPosicaoDeOrigem()){
				pontuacaoFinal =  (pontuacaoFinal * 1.1f);
				break;
			}else if(posicoes.size()-1 == i){
				pontuacaoFinal = (pontuacaoFinal*0.8f);
			}
		}
		return (int) pontuacaoFinal;
	
	}

}
