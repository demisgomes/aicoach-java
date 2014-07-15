package dominio;

public class EstiloDeJogo {
	
	private String nome;
	private float pontuacao;
	
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
