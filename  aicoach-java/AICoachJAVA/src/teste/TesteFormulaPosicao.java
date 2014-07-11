package teste;

import gui.TelaInicial;
import gui.TelaTatica;

import java.util.ArrayList;

import negocio.FormulaPosicao;
import dominio.CaracteristicasJogadores;
import dominio.Jogador;
import dominio.Posicao;
import dominio.Time;

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
	
	
	//TESTE
	ArrayList<Jogador> jogadoresSantaCruz=new ArrayList<Jogador>();
	
	
	Time SantaCruz = new Time("Santa Cruz", jogadoresSantaCruz);
	
	CaracteristicasJogadores caracteristicasThiago = new CaracteristicasJogadores();
	ArrayList<Posicao> posicoesThiago=new ArrayList<Posicao>();
	
	caracteristicasThiago.setResistencia(1);
	caracteristicasThiago.setDefesas(9);
	caracteristicasThiago.setBolaParada(7);
	caracteristicasThiago.setDrible(2);
	caracteristicasThiago.setVelocidade(3);
	caracteristicasThiago.setCabeceio(6);
	caracteristicasThiago.setControleBola(5);
	caracteristicasThiago.setDesarme(4);
	caracteristicasThiago.setFinalizacao(2);
	caracteristicasThiago.setQualidadePasse(6);
	
	
	goleiro = new Posicao("goleiro", jogador, formula, 0, true);
	jogador.getPosicoes().add(goleiro);
	
	
	
	Jogador jogadorThiagoCardoso = new Jogador("Thiago Cardoso",SantaCruz, 90, (float)1.86, true, posicoesThiago, null, caracteristicasThiago);
	jogadorThiagoCardoso.setCaracteristicas(caracteristicasThiago);
	jogadorThiagoCardoso.getPosicoes().add(goleiro);
	jogadorThiagoCardoso.getPosicoes().get(0).setPontuacao(formula.calcularGL(jogadorThiagoCardoso));
	
	jogadoresSantaCruz.add(jogadorThiagoCardoso);
	
	System.out.println(jogadorThiagoCardoso.getPosicoes().get(0).getPontuacao()+" de thiago");
	
	
	//Jogador jogadorThiagoCardoso = new Jogador();
	//CaracteristicasJogadores caracteristicasThiago = new CaracteristicasJogadores();
	caracteristicas.setResistencia(1);
	caracteristicas.setDefesas(9);
	caracteristicas.setBolaParada(7);
	caracteristicas.setDrible(2);
	caracteristicas.setVelocidade(3);
	caracteristicas.setCabeceio(6);
	caracteristicas.setControleBola(5);
	caracteristicas.setDesarme(4);
	caracteristicas.setFinalizacao(2);
	caracteristicas.setQualidadePasse(6);
	
	
	goleiro = new Posicao("goleiro", jogador, formula, 0, true);
	
	
	

	//TelaInicial tela = new TelaInicial("tela tatica", 600, 300);
	}

}
