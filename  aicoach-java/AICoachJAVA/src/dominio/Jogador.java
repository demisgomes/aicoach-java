package dominio;

import java.util.ArrayList;

public class Jogador {
	
	private String nome;
	private Time time;
	private int idade;
	private float peso, altura;
	private boolean temCondicao;
	private ArrayList<Posicao> posicoes;
	private EstatisticasJogador estatisticas;
	private CaracteristicasJogadores caracteristicas;
	
	public Jogador(String nome, Time time, float peso, float altura,  boolean temCondicao, 
			ArrayList<Posicao> posicoes, EstatisticasJogador estatisticas, CaracteristicasJogadores caracteristicas){
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
	
	public Jogador(){
		
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

	public boolean isTemCondicao() {
		return temCondicao;
	}

	public void setTemCondicao(boolean temCondicao) {
		this.temCondicao = temCondicao;
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
	
	

}
