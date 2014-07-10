package dominio;

import negocio.FormulaPosicao;

public class Posicao {
	
	private Jogador jogador;
	private String nome;
	private FormulaPosicao formula;
	private int pontuacao;
	
	public Posicao(String nome, Jogador jogador, FormulaPosicao formula, int pontuacao){
		setJogador(jogador);
		setNome(nome);
		setFormula(formula);
		setPontuacao(pontuacao);
		
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
