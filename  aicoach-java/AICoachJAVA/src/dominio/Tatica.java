package dominio;

import java.util.ArrayList;

public class Tatica {
	

	//private Tatica QuatroQuatroDois=new Tatica("4-4-2", null);
	ArrayList<Posicao> posicoesTatica=new ArrayList<Posicao>();
	
	private String nome;
	private ArrayList<Posicao> posicoes;
	private Time time;
	private int idTatica;
	
	public Tatica(String nome, ArrayList<Posicao> posicoes){
		setNome(nome);
		setPosicoes(posicoes);
	}
	
	public Tatica(int idTatica,String nome, ArrayList<Posicao> posicoes, Time time){
		setNome(nome);
		setPosicoes(posicoes);
		setIdTatica(idTatica);
		setTime(time);
	}
	
	public Tatica(int idTatica,String nome, ArrayList<Posicao> posicoes){
		setNome(nome);
		setPosicoes(posicoes);
		setIdTatica(idTatica);
	}
	
	public Tatica(){
		
	}
	
	
	
	public int getIdTatica() {
		return idTatica;
	}

	public void setIdTatica(int idTatica) {
		this.idTatica = idTatica;
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
	
	
	
	/*
	 * Posicao goleiro=new Posicao("Goleiro");
		Posicao lateralDireito=new Posicao("Lateral");
		Posicao lateralEsquerdo=new Posicao("Lateral");
		Posicao zagueiro1=new Posicao("Zagueiro");
		Posicao zagueiro2=new Posicao("Zagueiro");
		Posicao zagueiro3=new Posicao("Zagueiro");
		Posicao volante1=new Posicao("Volante");
		Posicao volante2=new Posicao("Volante");
		Posicao meiaCentral1=new Posicao("Meia Central");
		Posicao meiaCentral2=new Posicao("Meia Central");
		Posicao meiaAtacante=new Posicao("Meia Atacante");
		Posicao meiaLateralDireito=new Posicao("Meia Lateral");
		Posicao meiaLateralEsquerdo=new Posicao("Meia Lateral");
		Posicao segundoAtacante=new Posicao("Segundo Atacante");
		Posicao pontaEsquerda=new Posicao("Ponta");
		Posicao pontaDireita=new Posicao("Ponta");
		Posicao centroAvante=new Posicao("Centro Avante");
	 */
	

}
