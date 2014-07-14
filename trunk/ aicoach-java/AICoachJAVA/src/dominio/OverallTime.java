package dominio;

public class OverallTime {
	
	private int velocidade, finalizacao, passe, desarme;
	
	
	public OverallTime() {
		
	}
	
	public OverallTime(int velocidade, int finalizacao, int passe, int desarme) {
		setVelocidade(velocidade);
		setFinalizacao(finalizacao);
		setPasse(passe);
		setDesarme(desarme);
	}

	public int getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}

	public int getFinalizacao() {
		return finalizacao;
	}

	public void setFinalizacao(int finalizacao) {
		this.finalizacao = finalizacao;
	}

	public int getPasse() {
		return passe;
	}

	public void setPasse(int passe) {
		this.passe = passe;
	}

	public int getDesarme() {
		return desarme;
	}

	public void setDesarme(int desarme) {
		this.desarme = desarme;
	}
	
	
	

}
