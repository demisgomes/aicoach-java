package dominio;

import java.util.ArrayList;


public class Time {
	
	private String nome;
	private ArrayList<Jogador> jogadores;
	
	public Time(String nome, ArrayList<Jogador> jogadores){
		setNome(nome);
		setJogadores(jogadores);
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(ArrayList<Jogador> jogadores) {
		this.jogadores = jogadores;
	}
	
	public void addJogador(Jogador jogador) {
		this.jogadores.add(jogador);
	}
	
	public void removerJogador(String nome) {
		int i = jogadores.size();
		for (int n = 0; n < i ;n++){
		Jogador j =	jogadores.get(n);
		if(!j.getNome().equals(nome)){
			// faz nada...
		}else{
			this.jogadores.remove(n);
		}
		}
	}
	
}
