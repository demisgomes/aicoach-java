package dominio;

import java.util.ArrayList;

public class Tatica {
	
	private String nome;
	private ArrayList<Posicao> posicoes;
	private Time time;
	
	public Tatica(String nome, ArrayList<Posicao> posicoes){
		setNome(nome);
		setPosicoes(posicoes);
	}
	
	public Tatica(){
		
	}
	
	
	
	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Posicao> getPosicoes() {
		return posicoes;
	}

	public void setPosicoes(ArrayList<Posicao> posicoes) {
		this.posicoes = posicoes;
	}
	
	
	
	

}
