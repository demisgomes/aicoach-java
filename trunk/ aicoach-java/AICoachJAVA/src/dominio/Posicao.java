package dominio;

import negocio.formulas.FormulaCentroAvante;
import negocio.formulas.FormulaGoleiro;
import negocio.formulas.FormulaLateral;
import negocio.formulas.FormulaMeiaAtacante;
import negocio.formulas.FormulaMeiaCentral;
import negocio.formulas.FormulaMeiaLateral;
import negocio.formulas.FormulaPonta;
import negocio.formulas.FormulaPosicao;
import negocio.formulas.FormulaSegundoAtacante;
import negocio.formulas.FormulaVolante;
import negocio.formulas.FormulaZagueiro;

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
			if(nome.toLowerCase().equals("lateral direito") || nome.toLowerCase().equals("lateral esquerdo") || nome.toLowerCase().equals("lateral")){
				nome="lateral";
				setFormula(new FormulaLateral());
			}
			if(nome.toLowerCase().equals("goleiro")){
				setFormula(new FormulaGoleiro());
			}
			if(nome.toLowerCase().equals("zagueiro")){
				setFormula(new FormulaZagueiro());
			}
			if(nome.toLowerCase().equals("volante")){
				setFormula(new FormulaVolante());
			}
			if(nome.toLowerCase().equals("meia central")){
				setFormula(new FormulaMeiaCentral());
			}
			if(nome.toLowerCase().equals("meia lateral")){
				setFormula(new FormulaMeiaLateral());
			}
			if(nome.toLowerCase().equals("meia atacante")){
				setFormula(new FormulaMeiaAtacante());
			}
			if(nome.toLowerCase().equals("ponta")){
				setFormula(new FormulaPonta());
			}
			if(nome.toLowerCase().equals("segundo atacante")){
				setFormula(new FormulaSegundoAtacante());
			}
			if(nome.toLowerCase().equals("centro avante")){
				setFormula(new FormulaCentroAvante());
			}

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
			setFormula(new FormulaGoleiro());
		}
		if(posicaoTela==2){
			setNome("Lateral");
			setFormula(new FormulaLateral());
		}
		if(posicaoTela==3){
			setNome("Zagueiro");
			setFormula(new FormulaZagueiro());
		}
		if(posicaoTela==4){
			setNome("Zagueiro");
			setFormula(new FormulaZagueiro());
		}
		if(posicaoTela==5){
			setNome("Zagueiro");
			setFormula(new FormulaZagueiro());
		}
		if(posicaoTela==6){
			setNome("Lateral");
			setFormula(new FormulaLateral());
		}
		if(posicaoTela==7){
			setNome("Lateral");
			setFormula(new FormulaLateral());
		}
		if(posicaoTela==8){
			setNome("Volante");
			setFormula(new FormulaVolante());
		}
		if(posicaoTela==9){
			setNome("Volante");
			setFormula(new FormulaVolante());
		}
		if(posicaoTela==10){
			setNome("Volante");
			setFormula(new FormulaVolante());
		}
		if(posicaoTela==11){
			setNome("Lateral");
			setFormula(new FormulaLateral());
		}
		if(posicaoTela==12){
			setNome("Meia Lateral");
			setFormula(new FormulaMeiaLateral());
		}
		if(posicaoTela==13){
			setNome("Meia Central");
			setFormula(new FormulaMeiaCentral());
		}
		if(posicaoTela==14){
			setNome("Meia Central");
			setFormula(new FormulaMeiaCentral());
		}
		if(posicaoTela==15){
			setNome("Meia Central");
			setFormula(new FormulaMeiaCentral());
		}
		if(posicaoTela==16){
			setNome("Meia Lateral");
			setFormula(new FormulaMeiaLateral());
		}
		if(posicaoTela==17){
			setNome("Meia Lateral");
			setFormula(new FormulaMeiaLateral());
		}
		if(posicaoTela==18){
			setNome("Meia Atacante");
			setFormula(new FormulaMeiaAtacante());
		}
		if(posicaoTela==19){

			setNome("Meia Atacante");
			setFormula(new FormulaMeiaAtacante());
		}
		if(posicaoTela==20){

			setNome("Meia Atacante");
			setFormula(new FormulaMeiaAtacante());
		}
		if(posicaoTela==21){

			setNome("Meia Lateral");
			setFormula(new FormulaMeiaLateral());
		}
		if(posicaoTela==22){
			setNome("Ponta");
			setFormula(new FormulaPonta());
		}
		if(posicaoTela==23){

			setNome("Segundo Atacante");
			setFormula(new FormulaSegundoAtacante());
		}
		if(posicaoTela==24){

			setNome("Centro Avante");
			setFormula(new FormulaCentroAvante());
		}
		if(posicaoTela==25){

			setNome("Segundo Atacante");
			setFormula(new FormulaSegundoAtacante());
		}
		if(posicaoTela==26){

			setNome("Ponta");
			setFormula(new FormulaPonta());
		}
		
		setIdPosicaoTela(posicaoTela);
		
}
	public Posicao(){
		
	}
	
	public Posicao(String nome, Jogador jogador){
		setNome(nome);
		setJogador(jogador);
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
