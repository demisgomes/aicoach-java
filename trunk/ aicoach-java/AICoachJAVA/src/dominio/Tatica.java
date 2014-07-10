package dominio;

import java.util.ArrayList;

public class Tatica {
	
	private String nome;
	private ArrayList<Posicao> posicoes;
	
	public Tatica(String nome, ArrayList<Posicao> posicoes){
		setNome(nome);
		setPosicoes(posicoes);
	}
	
	public Tatica(){
		
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
