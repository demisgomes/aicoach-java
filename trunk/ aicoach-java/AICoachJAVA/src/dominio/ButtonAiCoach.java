package dominio;

import java.awt.Button;
import java.awt.HeadlessException;

public class ButtonAiCoach extends Button {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private Jogador jogador;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	public ButtonAiCoach(String nomeBotao) throws HeadlessException {
		super(nomeBotao);
	}
	
	public ButtonAiCoach(){
		
	}

	/**
	 * @return the jogador
	 */
	public Jogador getJogador() {
		return jogador;
	}

	/**
	 * @param jogador the jogador to set
	 */
	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}
	
	
	
	
	
}
