package dominio;

import negocio.FormulaPosicao;

public class Posicao {
	
	private Jogador jogador;
	private String nome;
	private FormulaPosicao formula;
	private int pontuacao, pontuacaParcial;
	private boolean posicaoDeOrigem;
	private int idPosicaoTela;
	
	public Posicao(String nome, Jogador jogador, FormulaPosicao formula, int pontuacao, boolean posicaoDeOrigem){
		setJogador(jogador);
		setNome(nome);
		setFormula(formula);
		setPontuacao(pontuacao);
		setPosicaoDeOrigem(posicaoDeOrigem);
		
		
		
	}	
	
	public Posicao(String nome, Jogador jogador, FormulaPosicao formula, int pontuacao, boolean posicaoDeOrigem, int pontuacaoParcial){
		setJogador(jogador);
		setNome(nome);
		setFormula(formula);
		setPontuacao(pontuacao);
		setPosicaoDeOrigem(posicaoDeOrigem);
		setPontuacaParcial(pontuacaoParcial);
		
		
	}	
	
	//inicializar sem jogador e pontuacao
	public Posicao(String nome, FormulaPosicao formula){
		setNome(nome);
		setFormula(formula);
		
	}
	
	public Posicao(String nome){
			setNome(nome);
			/*int posicaoTela=0;
			if(nome.toLowerCase().equals("Goleiro")){
				posicaoTela=1;
			}
			if(posicaoTela==2){
				setNome("Lateral");
			}
			if(posicaoTela==3){
				setNome("Zagueiro");
			}
			if(posicaoTela==4){
				setNome("Zagueiro");
			}
			if(posicaoTela==5){
				setNome("Zagueiro");
			}
			if(posicaoTela==6){
				setNome("Lateral");
			}
			if(posicaoTela==7){
				setNome("Lateral");
			}
			if(posicaoTela==8){
				setNome("Volante");
			}
			if(posicaoTela==9){
				setNome("Volante");
			}
			if(posicaoTela==10){
				setNome("Volante");
			}
			if(posicaoTela==11){
				setNome("Lateral");
			}
			if(posicaoTela==12){
				setNome("Meia Lateral");
			}
			if(posicaoTela==13){
				setNome("Meia Central");
			}
			if(posicaoTela==14){
				setNome("Meia Central");
			}
			if(posicaoTela==15){
				setNome("Meia Central");
			}
			if(posicaoTela==16){
				setNome("Meia Lateral");
			}
			if(posicaoTela==17){
				setNome("Meia Lateral");
			}
			if(posicaoTela==18){
				setNome("Meia Atacante");
			}
			if(posicaoTela==19){

				setNome("Meia Atacante");
			}
			if(posicaoTela==20){

				setNome("Meia Atacante");
			}
			if(posicaoTela==21){

				setNome("Meia Lateral");
			}
			if(posicaoTela==22){
				setNome("Ponta");
			}
			if(posicaoTela==23){

				setNome("Segundo Atacante");
			}
			if(posicaoTela==24){

				setNome("Centro Avante");
			}
			if(posicaoTela==25){

				setNome("Segundo Atacante");
			}
			if(posicaoTela==26){

				setNome("Ponta");
			}

*/			
	}
	
	public Posicao(int posicaoTela){
		if(posicaoTela==1){
			setNome("Goleiro");
		}
		if(posicaoTela==2){
			setNome("Lateral");
		}
		if(posicaoTela==3){
			setNome("Zagueiro");
		}
		if(posicaoTela==4){
			setNome("Zagueiro");
		}
		if(posicaoTela==5){
			setNome("Zagueiro");
		}
		if(posicaoTela==6){
			setNome("Lateral");
		}
		if(posicaoTela==7){
			setNome("Lateral");
		}
		if(posicaoTela==8){
			setNome("Volante");
		}
		if(posicaoTela==9){
			setNome("Volante");
		}
		if(posicaoTela==10){
			setNome("Volante");
		}
		if(posicaoTela==11){
			setNome("Lateral");
		}
		if(posicaoTela==12){
			setNome("Meia Lateral");
		}
		if(posicaoTela==13){
			setNome("Meia Central");
		}
		if(posicaoTela==14){
			setNome("Meia Central");
		}
		if(posicaoTela==15){
			setNome("Meia Central");
		}
		if(posicaoTela==16){
			setNome("Meia Lateral");
		}
		if(posicaoTela==17){
			setNome("Meia Lateral");
		}
		if(posicaoTela==18){
			setNome("Meia Atacante");
		}
		if(posicaoTela==19){

			setNome("Meia Atacante");
		}
		if(posicaoTela==20){

			setNome("Meia Atacante");
		}
		if(posicaoTela==21){

			setNome("Meia Lateral");
		}
		if(posicaoTela==22){
			setNome("Ponta");
		}
		if(posicaoTela==23){

			setNome("Segundo Atacante");
		}
		if(posicaoTela==24){

			setNome("Centro Avante");
		}
		if(posicaoTela==25){

			setNome("Segundo Atacante");
		}
		if(posicaoTela==26){

			setNome("Ponta");
		}
		
		setIdPosicaoTela(posicaoTela);
}
	public Posicao(){
		
	}
	
	

	public int getPontuacaParcial() {
		return pontuacaParcial;
	}

	public void setPontuacaParcial(int pontuacaParcial) {
		this.pontuacaParcial = pontuacaParcial;
	}

	public boolean isPosicaoDeOrigem() {
		return posicaoDeOrigem;
	}



	public void setPosicaoDeOrigem(boolean posicaoDeOrigem) {
		this.posicaoDeOrigem = posicaoDeOrigem;
	}



	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public FormulaPosicao getFormula() {
		return formula;
	}

	public void setFormula(FormulaPosicao formula) {
		this.formula = formula;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	/**
	 * @return the idPosicaoTela
	 */
	public int getIdPosicaoTela() {
		return idPosicaoTela;
	}

	/**
	 * @param idPosicaoTela the idPosicaoTela to set
	 */
	public void setIdPosicaoTela(int idPosicaoTela) {
		this.idPosicaoTela = idPosicaoTela;
	}
	
	
}
