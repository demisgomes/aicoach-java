package teste;

import java.util.ArrayList;

import negocio.FormulaPosicao;

import dominio.CaracteristicasJogadores;
import dominio.Jogador;
import dominio.Posicao;

public class TesteFormulaPosicao {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Jogador jogador = new Jogador();
		CaracteristicasJogadores caracteristicas = new CaracteristicasJogadores();
		caracteristicas.setResistencia(6);
		caracteristicas.setDefesas(10);
		caracteristicas.setBolaParada(2);
		caracteristicas.setDrible(3);
		caracteristicas.setVelocidade(8);
		caracteristicas.setCabeceio(1);
		caracteristicas.setControleBola(9);
		caracteristicas.setDesarme(4);
		caracteristicas.setFinalizacao(5);
		caracteristicas.setQualidadePasse(7);
			
	FormulaPosicao formula = new FormulaPosicao();
	ArrayList<Posicao> posicoes = new ArrayList<Posicao>();	
	Posicao goleiro = new Posicao("goleiro", jogador, formula, 0, true);
	Posicao posicao = new Posicao("", jogador, formula, 0, false);
	posicoes.add(goleiro);
	posicoes.add(posicao);
	
	jogador.setCaracteristicas(caracteristicas);
	jogador.setPosicoes(posicoes);

	
	goleiro.setPontuacao(formula.calcularGL(jogador));
	
	System.out.println(goleiro.getPontuacao());


	}

}
