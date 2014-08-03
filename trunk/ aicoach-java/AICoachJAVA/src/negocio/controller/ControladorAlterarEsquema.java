package negocio.controller;

import java.util.Observer;

import gui.TelaInserirAlterarEsquema;
import gui.TelaTatica;
import perssistencia.TaticaDAO;
import negocio.model.AlterarEsquema;
import negocio.view.ObservadorTime;
import dominio.Tatica;
import dominio.Time;

public class ControladorAlterarEsquema {
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
}
