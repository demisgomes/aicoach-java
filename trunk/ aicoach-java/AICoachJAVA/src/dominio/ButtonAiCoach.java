package dominio;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import controle.ControladorTatica;

import perssistencia.TaticaDAO;

import negocio.AlgoritmoTatica;
import negocio.controller.Fachada;

public class ButtonAiCoach extends JButton {

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
		super.setContentAreaFilled(false);
		setOpaque(true);
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setBackground(Color.yellow);
				int n=JOptionPane.showConfirmDialog(null, getJogador().getNome()+"\n"+getJogador().getPosicaoAtual().getNome()+"\n"+jogador.getAltura()+"m\n"+jogador.getIdade()+" anos\nVocê deseja substitui-lo?");
				if(n==JOptionPane.YES_OPTION){
					AlgoritmoTatica tatica= new AlgoritmoTatica();
					TaticaDAO taDAO=new TaticaDAO();
					tatica.substituirUmJogador(Time.getTime(), jogador, taDAO.retornarTatica(Time.getTime().getTatica().getNome()));
					
					ControladorTatica.mostrarBotoes();
				}
				//else{
					////setBackground(Color.green);
				//}
				
			}
		});
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
