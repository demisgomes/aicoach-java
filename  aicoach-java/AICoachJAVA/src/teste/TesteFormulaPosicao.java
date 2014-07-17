package teste;

import gui.TelaInicial;
import gui.TelaTatica;

import java.util.ArrayList;

import javax.swing.text.Segment;

import perssistencia.JogadorDAO;
import perssistencia.TaticaDAO;

import negocio.AlgoritmoTatica;
import negocio.FormulaPosicao;
import dominio.CaracteristicasJogadores;
import dominio.EstiloDeJogo;
import dominio.Jogador;
import dominio.OverallJogador;
import dominio.OverallTime;
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

	
	goleiro.setPontuacao(formula.calcularGL(jogador));
	
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
	
	
	
	
	
	Jogador jogadorThiagoCardoso = new Jogador("Thiago Cardoso",SantaCruz, 90, (float)1.86, 1, posicoesThiago, null, caracteristicasThiago);
	jogadorThiagoCardoso.setCaracteristicas(caracteristicasThiago);
	

	goleiro = new Posicao("Goleiro", jogadorThiagoCardoso, formula, 0, true);
	jogador.getPosicoes().add(goleiro);
	jogadorThiagoCardoso.getPosicoes().add(goleiro);
	jogadorThiagoCardoso.getPosicoes().get(0).setPontuacao(formula.calcularGL(jogadorThiagoCardoso));
	
	System.out.println(jogadorThiagoCardoso.getPosicoes().get(0).getPontuacao()+" de thiago");
	
	
	//Jogador jogadorThiagoCardoso = new Jogador();
	//CaracteristicasJogadores caracteristicasThiago = new CaracteristicasJogadores();
	ArrayList<Posicao> posicoesNininho=new ArrayList<Posicao>();
	Jogador jogadorNininho = new Jogador("Nininho",SantaCruz, 65, (float)1.73, 1, posicoesNininho, null, caracteristicas);
	
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
	
	Jogador jogadorEvertonSena = new Jogador("Everton Sena",SantaCruz, 75, (float)1.81, 1, posicoesEvertonSena, null, caracteristicas);
	
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
	
	Jogador jogadorRenanFonseca = new Jogador("Renan Fonseca",SantaCruz, 75, (float)1.85, 1, posicoesRenanFonseca, null, caracteristicas);
	
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
	
	Jogador jogadorRenatinho = new Jogador("Renatinho",SantaCruz, 75, (float)1.85, 1, posicoesRenatinho, null, caracteristicas);
	
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
	
	Jogador jogadorSandroManoel = new Jogador("Sandro Manoel",SantaCruz, 69, (float)1.78, 1, posicoesSandroManoel, null, caracteristicas);
	
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
	
	Jogador jogadorDaniloPires = new Jogador("Danilo Pires",SantaCruz, 72, (float)1.73, 1, posicoesDaniloPires, null, caracteristicas);
	
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
	caracteristicas.setVelocidade(5);
	caracteristicas.setCabeceio(5);
	caracteristicas.setControleBola(6);
	caracteristicas.setDesarme(8);
	caracteristicas.setFinalizacao(5);
	caracteristicas.setQualidadePasse(6);
	
	Jogador jogadorMemo = new Jogador("Memo",SantaCruz, 69, (float)1.78, 1, posicoesMemo, null, caracteristicas);
	
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
	
	Jogador jogadorCarlosAlberto = new Jogador("Carlos Alberto",SantaCruz, 69, (float)1.78, 1, posicoesCarlosAlberto, null, caracteristicas);
	
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
	
	Jogador jogadorPingo = new Jogador("Pingo",SantaCruz, 69, (float)1.78, 1, posicoesPingo, null, caracteristicas);
	
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
	
	Jogador jogadorLeoGamalho = new Jogador("Léo Gamalho",SantaCruz, 69, (float)1.78, 1, posicoesLeoGamalho, null, caracteristicas);
	
	Posicao atLeoGamalho=new Posicao("Centro Avante", jogadorLeoGamalho, formula, 0, true);
	//goleiro = new Posicao("goleiro", jogador, formula, 0, true);
	jogadorLeoGamalho.setCaracteristicas(caracteristicas);
	atLeoGamalho.setPontuacao(formula.calcularCA(jogadorLeoGamalho));
	jogadorLeoGamalho.getPosicoes().add(atLeoGamalho);
	
ArrayList<Posicao> posicoesCacaRato=new ArrayList<Posicao>();
	
	caracteristicas.setResistencia(7);
	caracteristicas.setDefesas(1);
	caracteristicas.setBolaParada(4);
	caracteristicas.setDrible(10);
	caracteristicas.setVelocidade(6);
	caracteristicas.setCabeceio(5);
	caracteristicas.setControleBola(5);
	caracteristicas.setDesarme(5);
	caracteristicas.setFinalizacao(5);
	caracteristicas.setQualidadePasse(5);
	
	Jogador jogadorCacaRato = new Jogador("Caça Rato",SantaCruz, 69, (float)1.78, 1, posicoesCacaRato, null, caracteristicas);
	
	Posicao atCacaRato=new Posicao("Segundo Atacante", jogadorCacaRato, formula, 0, true);
	//goleiro = new Posicao("goleiro", jogador, formula, 0, true);
	jogadorCacaRato.setCaracteristicas(caracteristicas);
	atCacaRato.setPontuacao(formula.calcularSA(jogadorCacaRato));
	jogadorCacaRato.getPosicoes().add(atCacaRato);
	
	
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
	jogadoresSantaCruz.add(jogadorCacaRato);
	
	SantaCruz.setJogadores(jogadoresSantaCruz);
	
	for(Jogador jogadorSanta: SantaCruz.getJogadores()){
		System.out.println(jogadorSanta.getNome()+" tem pontuação de "+jogadorSanta.getPosicoes().get(0).getPontuacao()+" jogando de "+jogadorSanta.getPosicoes().get(0).getNome());
	}

	//TelaInicial tela = new TelaInicial("Tela Inicial", 600, 300);
	
	
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
	Tatica tatica1=new Tatica("4-4-2", posicoesTatica);
	SantaCruz.setTatica(tatica1);
	tatica.SugerirJogadores(SantaCruz);
	for (Posicao xxx: SantaCruz.getTatica().getPosicoes() ){
		System.out.println(xxx.getJogador().getNome()+" joga de "+ xxx.getNome());
	}
	Jogador j = new Jogador();
	j = tatica.substituirJogador(jogadorCacaRato, SantaCruz);
	
	System.out.println("--------------------------------------------------------");
	OverallTime overall = new OverallTime();
	
	overall = tatica.gerarOverallTime(SantaCruz);
	
	OverallJogador overallJogador = new OverallJogador();
	
	overallJogador = tatica.gerarOverallJogador(SantaCruz);
	
	EstiloDeJogo estilo = new EstiloDeJogo();
	 estilo = tatica.gerarEstilodeJogoTime(overall, overallJogador);
	 
	 int pont;
	pont = tatica.gerarPontuacaoParcial(SantaCruz);
	
	
	
	for(Posicao posicaoSub : SantaCruz.getTatica().getPosicoes()){
		if(posicaoSub.getJogador().equals(jogadorCacaRato)){
			//posicaoSub.setJogador(j);
		}
	}
	for (Posicao xxx: SantaCruz.getTatica().getPosicoes() ){
		System.out.println(xxx.getJogador().getNome()+" joga de "+ xxx.getNome());
	}
	

Posicao goleiro2=new Posicao("Goleiro");
Posicao lateralDireito1=new Posicao("Lateral");
Posicao lateralEsquerdo1=new Posicao("Lateral");
Posicao zagueiro3=new Posicao("Zagueiro");
Posicao zagueiro4=new Posicao("Zagueiro");
Posicao volante2=new Posicao("Volante");
Posicao meiaCentral3=new Posicao("Meia Central");
Posicao meiaAtacante1=new Posicao("Meia Atacante");
Posicao segundoAtacante1=new Posicao("Segundo Atacante");
Posicao segundoAtacante2=new Posicao("Segundo Atacante");
Posicao centroAvante1=new Posicao("Centro Avante");
	
ArrayList<Posicao> posicoesTatica2=new ArrayList<Posicao>();


	posicoesTatica2.add(goleiro2);
	posicoesTatica2.add(lateralDireito1);
	posicoesTatica2.add(lateralEsquerdo1);
	posicoesTatica2.add(zagueiro3);
	posicoesTatica2.add(zagueiro4);
	posicoesTatica2.add(volante2);
	posicoesTatica2.add(segundoAtacante2);
	posicoesTatica2.add(meiaCentral3);
	posicoesTatica2.add(meiaAtacante1);
	posicoesTatica2.add(segundoAtacante1);
	posicoesTatica2.add(centroAvante1);
	
	
	Tatica tatica2 = new Tatica("433", posicoesTatica2);
	
	ArrayList<Tatica> taticas = new ArrayList<Tatica>();
	taticas.add(tatica1);
	taticas.add(tatica2);
	

	
	
	System.out.println("----------------------------------------------");
	
	System.out.println("média de velocidade santa: "+overall.getVelocidade()+"média de desarme santa: "+overall.getDesarme()+"média de finalização santa: "+overall.getFinalizacao()+"média de passe santa: "+overall.getPasse());
	
	System.out.println("----------------------------------------------");
	
	System.out.println("média atacantes: "+overallJogador.getAtacantes()+" média meias: "+overallJogador.getMeias()+" média defensores "+overallJogador.getDefensores()+" media time todo: "+overallJogador.getTimeTodo());
	
	System.out.println("----------------------------------------------");
	
	System.out.println("estilo de jogo: "+estilo.getNome()+" pontuacao "+estilo.getPontuacao());
	
	System.out.println("----------------------------------------------");
	
	for (int i = 0; i < SantaCruz.getJogadores().size(); i++) {
		for (int k = 0; k < SantaCruz.getJogadores().get(i).getPosicoes().size(); k++) {
			if(SantaCruz.getJogadores().get(i).getPosicoes().get(k).isPosicaoDeOrigem()){
				System.out.println("pontuação parcial de: "+SantaCruz.getJogadores().get(i).getNome()+" "+SantaCruz.getJogadores().get(i).getPosicoes().get(k).getPontuacaParcial());
			}
			
		}
			
		}
	
Tatica tatica3 = new Tatica();
tatica3 = tatica.sugerirTatica(SantaCruz, taticas);
System.out.println("tatica selecionada: "+tatica3.getNome());


	
	TelaInicial tela = new TelaInicial("Tela Inicial", 300, 300);
	tela.setVisible(true);
	
	tatica1.setTime(SantaCruz);
	
	TaticaDAO taticaDAO = new TaticaDAO();
	taticaDAO.inserirTatica(tatica1);
	System.out.println(tatica1.getIdTatica());
	Tatica taticaNova = new Tatica();
	
	taticaNova = taticaDAO.retornarTatica(tatica1);
	System.out.println(taticaNova.getNome()+" "+ taticaNova.getIdTatica());


	
	}
	
}
	
	
	
	


