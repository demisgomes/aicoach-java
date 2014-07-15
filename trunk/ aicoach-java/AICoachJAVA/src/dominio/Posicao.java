package dominio;

import negocio.FormulaPosicao;

public class Posicao {
	
	private Jogador jogador;
	private String nome;
	private FormulaPosicao formula;
	private int pontuacao, pontuacaParcial;
	private boolean posicaoDeOrigem;
	
	public Posicao(String nome, Jogador jogador, FormulaPosicao formula, int pontuacao, boolean posicaoDeOrigem){
		setJogador(jogador);
		setNome(nome);
		setFormula(formula);
		setPontuacao(pontuacao);
		setPosicaoDeOrigem(posicaoDeOrigem);
		
		
		
	}	
	
	public Posicao(String nome, Jogador jogador, FormulaPosicao formula, int pontuacao, boolean posicaoDeOrigem, int pontuacaoParcial){
		setJogador(jogador);
		setNome(nome);
		setFormula(formula);
		setPontuacao(pontuacao);
		setPosicaoDeOrigem(posicaoDeOrigem);
		setPontuacaParcial(pontuacaoParcial);
		
		
	}	
	
	//inicializar sem jogador e pontuacao
	public Posicao(String nome, FormulaPosicao formula){
		setNome(nome);
		setFormula(formula);
		
	}
	
	public Posicao(String nome){
			setNome(nome);
	}
	
	public Posicao(){
		
	}
	
	

	public int getPontuacaParcial() {
		return pontuacaParcial;
	}

	public void setPontuacaParcial(int pontuacaParcial) {
		this.pontuacaParcial = pontuacaParcial;
	}

	public boolean isPosicaoDeOrigem() {
		return posicaoDeOrigem;
	}



	public void setPosicaoDeOrigem(boolean posicaoDeOrigem) {
		this.posicaoDeOrigem = posicaoDeOrigem;
	}



	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public FormulaPosicao getFormula() {
		return formula;
	}

	public void setFormula(FormulaPosicao formula) {
		this.formula = formula;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
	
	
}
