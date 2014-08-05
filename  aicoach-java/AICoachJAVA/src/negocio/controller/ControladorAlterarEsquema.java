package negocio.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observer;

import javax.swing.JFrame;

import gui.TelaInserirAlterarEsquema;
import gui.TelaTatica;
import perssistencia.TaticaDAO;
import negocio.interfaces.InterfaceBotao;
import negocio.model.AlterarEsquema;
import negocio.view.ObservadorCombateTatica;
import negocio.view.ObservadorTime;
import dominio.Tatica;
import dominio.Time;

public class ControladorAlterarEsquema implements InterfaceBotao {
	private AlterarEsquema alterarEsquema;
	
	public void controlar(Time time){
		TaticaDAO tDAO=new TaticaDAO();
		System.out.println(TelaInserirAlterarEsquema.comboBoxFormacoes.getSelectedItem().toString());
		Tatica taticaNova=tDAO.retornarTatica(TelaInserirAlterarEsquema.comboBoxFormacoes.getSelectedItem().toString());
		int substituicoes=TelaInserirAlterarEsquema.comboBoxSubstituicoes.getSelectedIndex();
		AlterarEsquema a=new AlterarEsquema();
		//TelaTatica tela=new TelaTatica();
		Observer obs=new ObservadorTime();
		a.addObserver(obs);
		a.acao(time, substituicoes, taticaNova);
	}
	

	/**
	 * @return the alterarEsquema
	 */
	public AlterarEsquema getAlterarEsquema() {
		return alterarEsquema;
	}

	/**
	 * @param alterarEsquema the alterarEsquema to set
	 */
	public void setAlterarEsquema(AlterarEsquema alterarEsquema) {
		this.alterarEsquema = alterarEsquema;
	}


	@Override
	public void acaoBotao(JFrame tela) {
		TelaInserirAlterarEsquema.getBtnConfirmar().addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				controlar(TelaInserirAlterarEsquema.getTime());
			}
		});
	}
}
