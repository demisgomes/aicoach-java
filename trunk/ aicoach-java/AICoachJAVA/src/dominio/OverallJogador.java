package dominio;

public class OverallJogador {
	
	private int defensores, meias, atacantes, timeTodo;
	
	public OverallJogador(int defensores, int meias, int atacantes, int timeTodo){
		setDefensores(defensores);
		setMeias(meias);
		setAtacantes(atacantes);
		setTimeTodo(timeTodo);
	}
	
	public OverallJogador(){
		
	}
	
	

	public int getTimeTodo() {
		return timeTodo;
	}

	public void setTimeTodo(int timeTodo) {
		this.timeTodo = timeTodo;
	}

	public int getDefensores() {
		return defensores;
	}

	public void setDefensores(int defensores) {
		this.defensores = defensores;
	}

	public int getMeias() {
		return meias;
	}

	public void setMeias(int meias) {
		this.meias = meias;
	}

	public int getAtacantes() {
		return atacantes;
	}

	public void setAtacantes(int atacantes) {
		this.atacantes = atacantes;
	}
	
	
}
