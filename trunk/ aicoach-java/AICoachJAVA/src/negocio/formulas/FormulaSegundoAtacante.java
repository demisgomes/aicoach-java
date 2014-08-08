package negocio.formulas;

import java.util.ArrayList;

import dominio.Jogador;
import dominio.Posicao;

public class FormulaSegundoAtacante extends FormulaPosicao{

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
		
		float somaCaracteristicas = (ressistencia * 3) + (cabeceio*6) + (finalizacao*10) + (velocidade*8) +
				(bolaParada*4) + (qualidadePasse*5) + (controleBola*7) + (drible*8) + (desarme*2) + (defesa*1);
		
		float resultadoJogador = somaCaracteristicas/getSomapesos();
		float pontuacaoFinal = (resultadoJogador/getJogadorideal())*100;
		ArrayList<Posicao> posicoes = jogador.getPosicoes();
		for (int i = 0; i < posicoes.size(); i++) {
			if(posicoes.get(i).getNome().toLowerCase().equals("segundo atacante") && posicoes.get(i).isPosicaoDeOrigem()){
				pontuacaoFinal =  (pontuacaoFinal * 1.1f);
				break;
			}else if(posicoes.size()-1 == i){
				pontuacaoFinal = (pontuacaoFinal*0.8f);
			}
		}
		//add no array da pontuacao de posicoes
		
		return (int) pontuacaoFinal;
	}

}
