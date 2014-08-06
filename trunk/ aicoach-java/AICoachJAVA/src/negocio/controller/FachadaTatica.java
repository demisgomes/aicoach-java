package negocio.controller;

import javax.swing.JFrame;

import controle.ControladorTatica;

import negocio.interfaces.InterfaceTatica;

public class FachadaTatica implements InterfaceTatica {

	@Override
	public void taticas(final JFrame tela) {
		ControladorTatica controlador = new ControladorTatica();
		controlador.acaoBotao(tela);
		
	}

}
