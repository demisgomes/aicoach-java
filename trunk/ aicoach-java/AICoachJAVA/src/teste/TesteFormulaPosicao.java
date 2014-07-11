package teste;

import gui.TelaInicial;
import gui.TelaTatica;

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
		caracteristicas.setResistencia(1);
		caracteristicas.setDefesas(10);
		caracteristicas.setBolaParada(9);
		caracteristicas.setDrible(2);
		caracteristicas.setVelocidade(3);
		caracteristicas.setCabeceio(8);
		caracteristicas.setControleBola(5);
		caracteristicas.setDesarme(4);
		caracteristicas.setFinalizacao(6);
		caracteristicas.setQualidadePasse(7);
			
	FormulaPosicao formula = new FormulaPosicao();
	ArrayList<Posicao> posicoes = new ArrayList<Posicao>();	
	Posicao goleiro = new Posicao("goleiro", jogador, formula, 0, true);
	Posicao posicao = new Posicao("", jogador, formula, 0, false);
	posicoes.add(posicao);
	posicoes.add(goleiro);
	
	
	jogador.setCaracteristicas(caracteristicas);
	jogador.setPosicoes(posicoes);

	
	goleiro.setPontuacao(formula.calcularPT(jogador));
	
	System.out.println(goleiro.getPontuacao());
	
	//TelaInicial tela = new TelaInicial("tela tatica", 600, 300);


	}

}
