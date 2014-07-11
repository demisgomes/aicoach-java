package teste;

import gui.TelaInicial;
import gui.TelaTatica;

import java.util.ArrayList;

import negocio.AlgoritmoTatica;
import negocio.FormulaPosicao;
import dominio.CaracteristicasJogadores;
import dominio.Jogador;
import dominio.Posicao;
import dominio.Tatica;
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
	
	
	goleiro = new Posicao("Goleiro", jogador, formula, 0, true);
	jogador.getPosicoes().add(goleiro);
	
	
	
	Jogador jogadorThiagoCardoso = new Jogador("Thiago Cardoso",SantaCruz, 90, (float)1.86, true, posicoesThiago, null, caracteristicasThiago);
	jogadorThiagoCardoso.setCaracteristicas(caracteristicasThiago);
	jogadorThiagoCardoso.getPosicoes().add(goleiro);
	jogadorThiagoCardoso.getPosicoes().get(0).setPontuacao(formula.calcularGL(jogadorThiagoCardoso));
	

	
	System.out.println(jogadorThiagoCardoso.getPosicoes().get(0).getPontuacao()+" de thiago");
	
	
	//Jogador jogadorThiagoCardoso = new Jogador();
	//CaracteristicasJogadores caracteristicasThiago = new CaracteristicasJogadores();
	ArrayList<Posicao> posicoesNininho=new ArrayList<Posicao>();
	Jogador jogadorNininho = new Jogador("Nininho",SantaCruz, 65, (float)1.73, true, posicoesNininho, null, caracteristicas);
	
	caracteristicas.setResistencia(8);
	caracteristicas.setDefesas(1);
	caracteristicas.setBolaParada(5);
	caracteristicas.setDrible(6);
	caracteristicas.setVelocidade(7);
	caracteristicas.setCabeceio(3);
	caracteristicas.setControleBola(5);
	caracteristicas.setDesarme(5);
	caracteristicas.setFinalizacao(4);
	caracteristicas.setQualidadePasse(6);
	
	Posicao lateral=new Posicao("Lateral", jogadorNininho, formula, 0, true);
	//goleiro = new Posicao("goleiro", jogador, formula, 0, true);
	jogadorNininho.setCaracteristicas(caracteristicas);
	lateral.setPontuacao(formula.calcularLT(jogadorNininho));
	jogadorNininho.getPosicoes().add(lateral);
	
	
	ArrayList<Posicao> posicoesEvertonSena=new ArrayList<Posicao>();
	
	caracteristicas.setResistencia(7);
	caracteristicas.setDefesas(1);
	caracteristicas.setBolaParada(4);
	caracteristicas.setDrible(3);
	caracteristicas.setVelocidade(6);
	caracteristicas.setCabeceio(7);
	caracteristicas.setControleBola(5);
	caracteristicas.setDesarme(7);
	caracteristicas.setFinalizacao(5);
	caracteristicas.setQualidadePasse(5);
	
	Jogador jogadorEvertonSena = new Jogador("Everton Sena",SantaCruz, 75, (float)1.81, true, posicoesEvertonSena, null, caracteristicas);
	
	Posicao zagueiro=new Posicao("Zagueiro", jogadorEvertonSena, formula, 0, true);
	//goleiro = new Posicao("goleiro", jogador, formula, 0, true);
	jogadorEvertonSena.setCaracteristicas(caracteristicas);
	zagueiro.setPontuacao(formula.calcularZG(jogadorEvertonSena));
	jogadorEvertonSena.getPosicoes().add(zagueiro);
	
	
	
ArrayList<Posicao> posicoesRenanFonseca=new ArrayList<Posicao>();
	
	caracteristicas.setResistencia(6);
	caracteristicas.setDefesas(1);
	caracteristicas.setBolaParada(5);
	caracteristicas.setDrible(3);
	caracteristicas.setVelocidade(5);
	caracteristicas.setCabeceio(9);
	caracteristicas.setControleBola(5);
	caracteristicas.setDesarme(8);
	caracteristicas.setFinalizacao(5);
	caracteristicas.setQualidadePasse(5);
	
	Jogador jogadorRenanFonseca = new Jogador("Renan Fonseca",SantaCruz, 75, (float)1.85, true, posicoesRenanFonseca, null, caracteristicas);
	
	Posicao zagueiroRenan=new Posicao("Zagueiro", jogadorRenanFonseca, formula, 0, true);
	//goleiro = new Posicao("goleiro", jogador, formula, 0, true);
	jogadorRenanFonseca.setCaracteristicas(caracteristicas);
	zagueiroRenan.setPontuacao(formula.calcularZG(jogadorRenanFonseca));
	jogadorRenanFonseca.getPosicoes().add(zagueiroRenan);
	
	
	
ArrayList<Posicao> posicoesRenatinho=new ArrayList<Posicao>();
	
	caracteristicas.setResistencia(7);
	caracteristicas.setDefesas(1);
	caracteristicas.setBolaParada(6);
	caracteristicas.setDrible(6);
	caracteristicas.setVelocidade(7);
	caracteristicas.setCabeceio(2);
	caracteristicas.setControleBola(7);
	caracteristicas.setDesarme(5);
	caracteristicas.setFinalizacao(6);
	caracteristicas.setQualidadePasse(6);
	
	Jogador jogadorRenatinho = new Jogador("Renatinho",SantaCruz, 75, (float)1.85, true, posicoesRenatinho, null, caracteristicas);
	
	Posicao latRenatinho=new Posicao("Lateral", jogadorRenatinho, formula, 0, true);
	//goleiro = new Posicao("goleiro", jogador, formula, 0, true);
	jogadorRenatinho.setCaracteristicas(caracteristicas);
	latRenatinho.setPontuacao(formula.calcularLT(jogadorRenatinho));
	jogadorRenatinho.getPosicoes().add(latRenatinho);
	
	
ArrayList<Posicao> posicoesSandroManoel=new ArrayList<Posicao>();
	
	caracteristicas.setResistencia(7);
	caracteristicas.setDefesas(1);
	caracteristicas.setBolaParada(6);
	caracteristicas.setDrible(4);
	caracteristicas.setVelocidade(7);
	caracteristicas.setCabeceio(5);
	caracteristicas.setControleBola(7);
	caracteristicas.setDesarme(9);
	caracteristicas.setFinalizacao(4);
	caracteristicas.setQualidadePasse(6);
	
	Jogador jogadorSandroManoel = new Jogador("Sandro Manoel",SantaCruz, 69, (float)1.78, true, posicoesSandroManoel, null, caracteristicas);
	
	Posicao volSandroManoel=new Posicao("Volante", jogadorSandroManoel, formula, 0, true);
	//goleiro = new Posicao("goleiro", jogador, formula, 0, true);
	jogadorSandroManoel.setCaracteristicas(caracteristicas);
	volSandroManoel.setPontuacao(formula.calcularVol(jogadorSandroManoel));
	jogadorSandroManoel.getPosicoes().add(volSandroManoel);
	
	
ArrayList<Posicao> posicoesDaniloPires=new ArrayList<Posicao>();
	
	caracteristicas.setResistencia(7);
	caracteristicas.setDefesas(1);
	caracteristicas.setBolaParada(4);
	caracteristicas.setDrible(5);
	caracteristicas.setVelocidade(7);
	caracteristicas.setCabeceio(5);
	caracteristicas.setControleBola(6);
	caracteristicas.setDesarme(8);
	caracteristicas.setFinalizacao(6);
	caracteristicas.setQualidadePasse(6);
	
	Jogador jogadorDaniloPires = new Jogador("Danilo Pires",SantaCruz, 72, (float)1.73, true, posicoesDaniloPires, null, caracteristicas);
	
	Posicao mcDaniloPires=new Posicao("Meia Central", jogadorDaniloPires, formula, 0, true);
	//goleiro = new Posicao("goleiro", jogador, formula, 0, true);
	jogadorDaniloPires.setCaracteristicas(caracteristicas);
	mcDaniloPires.setPontuacao(formula.calcularMC(jogadorDaniloPires));
	jogadorDaniloPires.getPosicoes().add(mcDaniloPires);
	
	
ArrayList<Posicao> posicoesMemo=new ArrayList<Posicao>();
	
	caracteristicas.setResistencia(7);
	caracteristicas.setDefesas(1);
	caracteristicas.setBolaParada(6);
	caracteristicas.setDrible(5);
	caracteristicas.setVelocidade(7);
	caracteristicas.setCabeceio(5);
	caracteristicas.setControleBola(6);
	caracteristicas.setDesarme(8);
	caracteristicas.setFinalizacao(5);
	caracteristicas.setQualidadePasse(6);
	
	Jogador jogadorMemo = new Jogador("Memo",SantaCruz, 69, (float)1.78, true, posicoesMemo, null, caracteristicas);
	
	Posicao mcMemo=new Posicao("Meia Central", jogadorMemo, formula, 0, true);
	//goleiro = new Posicao("goleiro", jogador, formula, 0, true);
	jogadorMemo.setCaracteristicas(caracteristicas);
	mcMemo.setPontuacao(formula.calcularMC(jogadorMemo));
	jogadorMemo.getPosicoes().add(mcMemo);
	
	
ArrayList<Posicao> posicoesCarlosAlberto=new ArrayList<Posicao>();
	
	caracteristicas.setResistencia(6);
	caracteristicas.setDefesas(1);
	caracteristicas.setBolaParada(6);
	caracteristicas.setDrible(8);
	caracteristicas.setVelocidade(8);
	caracteristicas.setCabeceio(5);
	caracteristicas.setControleBola(7);
	caracteristicas.setDesarme(5);
	caracteristicas.setFinalizacao(7);
	caracteristicas.setQualidadePasse(7);
	
	Jogador jogadorCarlosAlberto = new Jogador("Carlos Alberto",SantaCruz, 69, (float)1.78, true, posicoesCarlosAlberto, null, caracteristicas);
	
	Posicao maCarlosAlberto=new Posicao("Meia Atacante", jogadorCarlosAlberto, formula, 0, true);
	//goleiro = new Posicao("goleiro", jogador, formula, 0, true);
	jogadorCarlosAlberto.setCaracteristicas(caracteristicas);
	maCarlosAlberto.setPontuacao(formula.calcularMA(jogadorCarlosAlberto));
	jogadorCarlosAlberto.getPosicoes().add(maCarlosAlberto);
	
	
ArrayList<Posicao> posicoesPingo=new ArrayList<Posicao>();
	
	caracteristicas.setResistencia(7);
	caracteristicas.setDefesas(1);
	caracteristicas.setBolaParada(4);
	caracteristicas.setDrible(5);
	caracteristicas.setVelocidade(8);
	caracteristicas.setCabeceio(5);
	caracteristicas.setControleBola(5);
	caracteristicas.setDesarme(5);
	caracteristicas.setFinalizacao(5);
	caracteristicas.setQualidadePasse(5);
	
	Jogador jogadorPingo = new Jogador("Pingo",SantaCruz, 69, (float)1.78, true, posicoesPingo, null, caracteristicas);
	
	Posicao atPingo=new Posicao("Segundo Atacante", jogadorPingo, formula, 0, true);
	//goleiro = new Posicao("goleiro", jogador, formula, 0, true);
	jogadorPingo.setCaracteristicas(caracteristicas);
	atPingo.setPontuacao(formula.calcularSA(jogadorPingo));
	jogadorPingo.getPosicoes().add(atPingo);
	
	
ArrayList<Posicao> posicoesLeoGamalho=new ArrayList<Posicao>();
	
	caracteristicas.setResistencia(5);
	caracteristicas.setDefesas(1);
	caracteristicas.setBolaParada(5);
	caracteristicas.setDrible(6);
	caracteristicas.setVelocidade(6);
	caracteristicas.setCabeceio(8);
	caracteristicas.setControleBola(7);
	caracteristicas.setDesarme(4);
	caracteristicas.setFinalizacao(7);
	caracteristicas.setQualidadePasse(6);
	
	Jogador jogadorLeoGamalho = new Jogador("Léo Gamalho",SantaCruz, 69, (float)1.78, true, posicoesLeoGamalho, null, caracteristicas);
	
	Posicao atLeoGamalho=new Posicao("Centro Avante", jogadorLeoGamalho, formula, 0, true);
	//goleiro = new Posicao("goleiro", jogador, formula, 0, true);
	jogadorLeoGamalho.setCaracteristicas(caracteristicas);
	atLeoGamalho.setPontuacao(formula.calcularCA(jogadorLeoGamalho));
	jogadorLeoGamalho.getPosicoes().add(atLeoGamalho);
	
	jogadoresSantaCruz.add(jogadorThiagoCardoso);
	jogadoresSantaCruz.add(jogadorNininho);
	jogadoresSantaCruz.add(jogadorEvertonSena);
	jogadoresSantaCruz.add(jogadorRenanFonseca);
	jogadoresSantaCruz.add(jogadorRenatinho);
	jogadoresSantaCruz.add(jogadorSandroManoel);
	jogadoresSantaCruz.add(jogadorDaniloPires);
	jogadoresSantaCruz.add(jogadorMemo);
	jogadoresSantaCruz.add(jogadorCarlosAlberto);
	jogadoresSantaCruz.add(jogadorPingo);
	jogadoresSantaCruz.add(jogadorLeoGamalho);
	
	
	
	for(Jogador jogadorSanta: SantaCruz.getJogadores()){
		System.out.println(jogadorSanta.getNome()+" tem pontuação de "+jogadorSanta.getPosicoes().get(0).getPontuacao()+" jogando de "+jogadorSanta.getPosicoes().get(0).getNome());
	}

	//TelaInicial tela = new TelaInicial("tela tatica", 600, 300);
	
	
	ArrayList<Posicao> posicoesTatica=new ArrayList<Posicao>();
	
	Posicao goleiro1=new Posicao("Goleiro");
	Posicao lateralDireito=new Posicao("Lateral");
	Posicao lateralEsquerdo=new Posicao("Lateral");
	Posicao zagueiro1=new Posicao("Zagueiro");
	Posicao zagueiro2=new Posicao("Zagueiro");
	Posicao volante1=new Posicao("Volante");
	Posicao meiaCentral1=new Posicao("Meia Central");
	Posicao meiaCentral2=new Posicao("Meia Central");
	Posicao meiaAtacante=new Posicao("Meia Atacante");
	Posicao segundoAtacante=new Posicao("Segundo Atacante");
	Posicao centroAvante=new Posicao("Centro Avante");
	
	posicoesTatica.add(goleiro1);
	posicoesTatica.add(lateralDireito);
	posicoesTatica.add(lateralEsquerdo);
	posicoesTatica.add(zagueiro1);
	posicoesTatica.add(zagueiro2);
	posicoesTatica.add(volante1);
	posicoesTatica.add(meiaCentral1);
	posicoesTatica.add(meiaCentral2);
	posicoesTatica.add(meiaAtacante);
	posicoesTatica.add(segundoAtacante);
	posicoesTatica.add(centroAvante);
	
	AlgoritmoTatica tatica=new AlgoritmoTatica();
	Tatica taticaNow=new Tatica("4-4-2", posicoesTatica);
	ArrayList<Posicao> listaGerada=tatica.SugerirJogadores(taticaNow, SantaCruz);
	
	for (Posicao xxx: listaGerada ){
		System.out.println(xxx.getJogador()+" joga de "+ xxx.getNome());
	}
	}

}
