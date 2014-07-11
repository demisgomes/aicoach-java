package dominio;

import java.util.ArrayList;

public class Tatica {
	

	//private Tatica QuatroQuatroDois=new Tatica("4-4-2", null);
	ArrayList<Posicao> posicoesTatica=new ArrayList<Posicao>();
	
	/*public Tatica getQuatroQuatroDois() {
		posicoesTatica.clear();
		Posicao goleiro=new Posicao("Goleiro");
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
		
		posicoesTatica.add(goleiro);
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
		
		//QuatroQuatroDois.setPosicoes(posicoesTatica);
		return QuatroQuatroDois;
	}

	public Tatica getCincoQuatroUm() {
		posicoesTatica.clear();
		Posicao goleiro=new Posicao("Goleiro");
		Posicao lateralDireito=new Posicao("Lateral");
		Posicao lateralEsquerdo=new Posicao("Lateral");
		Posicao zagueiro1=new Posicao("Zagueiro");
		Posicao zagueiro2=new Posicao("Zagueiro");
		Posicao zagueiro3=new Posicao("Zagueiro");
		Posicao volante1=new Posicao("Volante");
		Posicao meiaCentral1=new Posicao("Meia Central");
		Posicao meiaCentral2=new Posicao("Meia Central");
		Posicao meiaAtacante=new Posicao("Meia Atacante");
		Posicao centroAvante=new Posicao("Centro Avante");
		
		posicoesTatica.add(goleiro);
		posicoesTatica.add(lateralDireito);
		posicoesTatica.add(lateralEsquerdo);
		posicoesTatica.add(zagueiro1);
		posicoesTatica.add(zagueiro2);
		posicoesTatica.add(zagueiro3);
		posicoesTatica.add(volante1);
		posicoesTatica.add(meiaCentral1);
		posicoesTatica.add(meiaCentral2);
		posicoesTatica.add(meiaAtacante);
		posicoesTatica.add(centroAvante);
		
		CincoQuatroUm.setPosicoes(posicoesTatica);
		return CincoQuatroUm;
	}

	public Tatica getQuatroCincoUm() {
		posicoesTatica.clear();
		Posicao goleiro=new Posicao("Goleiro");
		Posicao lateralDireito=new Posicao("Lateral");
		Posicao lateralEsquerdo=new Posicao("Lateral");
		Posicao zagueiro1=new Posicao("Zagueiro");
		Posicao zagueiro2=new Posicao("Zagueiro");
		Posicao volante1=new Posicao("Volante");
		Posicao meiaCentral1=new Posicao("Meia Central");
		Posicao meiaAtacante=new Posicao("Meia Atacante");
		Posicao meiaLateralDireito=new Posicao("Meia Lateral");
		Posicao meiaLateralEsquerdo=new Posicao("Meia Lateral");
		Posicao centroAvante=new Posicao("Centro Avante");
		
		posicoesTatica.add(goleiro);
		posicoesTatica.add(lateralDireito);
		posicoesTatica.add(lateralEsquerdo);
		posicoesTatica.add(zagueiro1);
		posicoesTatica.add(zagueiro2);
		posicoesTatica.add(volante1);
		posicoesTatica.add(meiaCentral1);
		posicoesTatica.add(meiaLateralDireito);
		posicoesTatica.add(meiaLateralEsquerdo);
		posicoesTatica.add(meiaAtacante);
		posicoesTatica.add(centroAvante);
		
		QuatroCincoUm.setPosicoes(posicoesTatica);
		return QuatroCincoUm;
	}

	public Tatica getQuatroTresTres() {
		posicoesTatica.clear();
		Posicao goleiro=new Posicao("Goleiro");
		Posicao lateralDireito=new Posicao("Lateral");
		Posicao lateralEsquerdo=new Posicao("Lateral");
		Posicao zagueiro1=new Posicao("Zagueiro");
		Posicao zagueiro2=new Posicao("Zagueiro");
		Posicao volante1=new Posicao("Volante");
		Posicao meiaCentral1=new Posicao("Meia Central");
		Posicao meiaAtacante=new Posicao("Meia Atacante");
		Posicao pontaEsquerda=new Posicao("Ponta");
		Posicao pontaDireita=new Posicao("Ponta");
		Posicao centroAvante=new Posicao("Centro Avante");
		
		posicoesTatica.add(goleiro);
		posicoesTatica.add(lateralDireito);
		posicoesTatica.add(lateralEsquerdo);
		posicoesTatica.add(zagueiro1);
		posicoesTatica.add(zagueiro2);
		posicoesTatica.add(volante1);
		posicoesTatica.add(meiaCentral1);
		posicoesTatica.add(meiaAtacante);
		posicoesTatica.add(pontaDireita);
		posicoesTatica.add(pontaEsquerda);
		posicoesTatica.add(centroAvante);
		
		QuatroTresTres.setPosicoes(posicoesTatica);
		return QuatroTresTres;
	}

	public Tatica getTresCincoDois() {
		posicoesTatica.clear();
		Posicao goleiro=new Posicao("Goleiro");
		Posicao zagueiro1=new Posicao("Zagueiro");
		Posicao zagueiro2=new Posicao("Zagueiro");
		Posicao zagueiro3=new Posicao("Zagueiro");
		Posicao volante1=new Posicao("Volante");
		Posicao meiaCentral1=new Posicao("Meia Central");
		Posicao meiaAtacante=new Posicao("Meia Atacante");
		Posicao meiaLateralDireito=new Posicao("Meia Lateral");
		Posicao meiaLateralEsquerdo=new Posicao("Meia Lateral");
		Posicao segundoAtacante=new Posicao("Segundo Atacante");
		Posicao centroAvante=new Posicao("Centro Avante");
		
		posicoesTatica.add(goleiro);
		posicoesTatica.add(zagueiro1);
		posicoesTatica.add(zagueiro2);
		posicoesTatica.add(zagueiro3);
		posicoesTatica.add(volante1);
		posicoesTatica.add(meiaCentral1);
		posicoesTatica.add(meiaAtacante);
		posicoesTatica.add(meiaLateralDireito);
		posicoesTatica.add(meiaLateralEsquerdo);
		posicoesTatica.add(segundoAtacante);
		posicoesTatica.add(centroAvante);
		
		TresCincoDois.setPosicoes(posicoesTatica);
		return TresCincoDois;
	}

	public Tatica getTresSeisUm() {
		posicoesTatica.clear();
		Posicao goleiro=new Posicao("Goleiro");
		Posicao zagueiro1=new Posicao("Zagueiro");
		Posicao zagueiro2=new Posicao("Zagueiro");
		Posicao zagueiro3=new Posicao("Zagueiro");
		Posicao volante1=new Posicao("Volante");
		Posicao volante2=new Posicao("Volante");
		Posicao meiaCentral1=new Posicao("Meia Central");
		Posicao meiaAtacante=new Posicao("Meia Atacante");
		Posicao meiaLateralDireito=new Posicao("Meia Lateral");
		Posicao meiaLateralEsquerdo=new Posicao("Meia Lateral");
		Posicao centroAvante=new Posicao("Centro Avante");
		
		posicoesTatica.add(goleiro);
		posicoesTatica.add(zagueiro1);
		posicoesTatica.add(zagueiro2);
		posicoesTatica.add(zagueiro3);
		posicoesTatica.add(volante1);
		posicoesTatica.add(volante2);
		posicoesTatica.add(meiaCentral1);
		posicoesTatica.add(meiaAtacante);
		posicoesTatica.add(meiaLateralDireito);
		posicoesTatica.add(meiaLateralEsquerdo);
		
		posicoesTatica.add(centroAvante);
		
		TresSeisUm.setPosicoes(posicoesTatica);
		return TresSeisUm;
	}

	private final Tatica CincoQuatroUm=new Tatica("5-4-1", null);

	private final Tatica QuatroCincoUm=new Tatica("4-5-1", null);

	private final Tatica QuatroTresTres=new Tatica("4-3-3", null);

	private final Tatica TresCincoDois=new Tatica("3-5-2", null);

	private final Tatica TresSeisUm=new Tatica("3-6-1", null);*/
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
