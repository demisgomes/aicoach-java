package dominio;

import java.util.ArrayList;

public class Jogador {
	private int id;
	private String nome;
	private Time time;
	private int idade;
	private float peso, altura;
	private int temCondicao, ehDestro, escolhido;
	private ArrayList<Posicao> posicoes;
	private EstatisticasJogador estatisticas;
	private CaracteristicasJogadores caracteristicas;
	private Posicao posicaoAtual;
	private int idPosicaoTela;
	private int pontuacaoPosicaoAtual;
	
	private static Jogador jogadorEscolhido;
	
	
	public Jogador(String nome, Time time, float peso, float altura,  int temCondicao, 
			ArrayList<Posicao> posicoes, EstatisticasJogador estatisticas, CaracteristicasJogadores caracteristicas, int idade){
		setNome(nome);
		setTime(time);
		setIdade(idade);
		setPeso(peso);
		setAltura(altura);
		setTemCondicao(temCondicao);
		setPosicoes(posicoes);
		setEstatisticas(estatisticas);
		setCaracteristicas(caracteristicas);
		
	}
	
	//SEM IDADE
	
	public Jogador(String nome, Time time, float peso, float altura,  int temCondicao, 
			ArrayList<Posicao> posicoes, EstatisticasJogador estatisticas, CaracteristicasJogadores caracteristicas){
		setNome(nome);
		setTime(time);
		setPeso(peso);
		setAltura(altura);
		setTemCondicao(temCondicao);
		setPosicoes(posicoes);
		setEstatisticas(estatisticas);
		setCaracteristicas(caracteristicas);
		
	}
	
	public Jogador(String nome, float peso, float altura,  int idade){
		setNome(nome);
		setIdade(idade);
		setPeso(peso);
		setAltura(altura);
		
		
	}
	
	public Jogador(String nome, Time time, float peso, float altura,  int temCondicao, 
			ArrayList<Posicao> posicoes, EstatisticasJogador estatisticas, CaracteristicasJogadores caracteristicas, Posicao posicaoAtual, int idade){
		setNome(nome);
		setTime(time);
		setIdade(idade);
		setPeso(peso);
		setAltura(altura);
		setTemCondicao(temCondicao);
		setPosicoes(posicoes);
		setEstatisticas(estatisticas);
		setCaracteristicas(caracteristicas);
		setPosicaoAtual(posicaoAtual);
		
	}
	
	public Jogador(){
		
	}
	
	
	
	
	public int getTemCondicao() {
		return temCondicao;
	}

	public void setTemCondicao(int temCondicao) {
		this.temCondicao = temCondicao;
	}

	public int getEhDestro() {
		return ehDestro;
	}

	public void setEhDestro(int ehDestro) {
		this.ehDestro = ehDestro;
	}

	public int getEscolhido() {
		return escolhido;
	}

	public void setEscolhido(int escolhido) {
		this.escolhido = escolhido;
	}

	public Posicao getPosicaoAtual() {
		return posicaoAtual;
	}
	public void setPosicaoAtual(Posicao posicaoAtual) {
		this.posicaoAtual = posicaoAtual;
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}


	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	

	public ArrayList<Posicao> getPosicoes() {
		return posicoes;
	}

	public void setPosicoes(ArrayList<Posicao> posicoes) {
		this.posicoes = posicoes;
	}

	public EstatisticasJogador getEstatisticas() {
		return estatisticas;
	}

	public void setEstatisticas(EstatisticasJogador estatisticas) {
		this.estatisticas = estatisticas;
	}

	public CaracteristicasJogadores getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(CaracteristicasJogadores caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the idPosicaoTela
	 */
	public int getIdPosicaoTela() {
		return idPosicaoTela;
	}

	/**
	 * @param idPosicaoTela the idPosicaoTela to set
	 */
	public void setIdPosicaoTela(int idPosicaoTela) {
		this.idPosicaoTela = idPosicaoTela;
	}

	/**
	 * @return the pontuacaoPosicaoAtual
	 */
	public int getPontuacaoPosicaoAtual() {
		return pontuacaoPosicaoAtual;
	}

	/**
	 * @param pontuacaoPosicaoAtual the pontuacaoPosicaoAtual to set
	 */
	public void setPontuacaoPosicaoAtual(int pontuacaoPosicaoAtual) {
		this.pontuacaoPosicaoAtual = pontuacaoPosicaoAtual;
	}

	/**
	 * @return the jogadorEscolhido
	 */
	public static Jogador getJogadorEscolhido() {
		return jogadorEscolhido;
	}

	/**
	 * @param jogadorEscolhido the jogadorEscolhido to set
	 */
	public static void setJogadorEscolhido(Jogador jogadorEscolhido) {
		Jogador.jogadorEscolhido = jogadorEscolhido;
	}


	public void calculeTudo(){
		for(Posicao p: getPosicoes()){
			System.out.println(p.getNome());
			System.out.println(p.getFormula());
			p.setPontuacao(p.getFormula().calcularPontuacao(this));
		}
	}

	

}
