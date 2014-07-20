package dominio;

public class EstiloDeJogo {
	
	private String nome;
	private float pontuacao;
	private OverallTime overallTime;
	private OverallJogador overallJogador;
	
	public OverallTime getOverallTime() {
		return overallTime;
	}

	public void setOverallTime(OverallTime overallTime) {
		this.overallTime = overallTime;
	}

	public OverallJogador getOverallJogador() {
		return overallJogador;
	}

	public void setOverallJogador(OverallJogador overallJogador) {
		this.overallJogador = overallJogador;
	}

	public EstiloDeJogo(String nome, float pontuacao){
		setNome(nome);
		setPontuacao(pontuacao);		
	}
	
	public EstiloDeJogo(){
		
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getPontuacao() {
		return pontuacao;
	}
	public void setPontuacao(float pontuacao) {
		this.pontuacao = pontuacao;
	}
	
	

}
