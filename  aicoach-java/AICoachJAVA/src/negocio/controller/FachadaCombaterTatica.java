package negocio.controller;

import javax.swing.JFrame;

import negocio.interfaces.InterfaceCombaterTatica;

public class FachadaCombaterTatica implements InterfaceCombaterTatica {

	@Override
	public void combaterTatica(final JFrame tela, String func) {
		ControladorCombaterTatica controlador = new ControladorCombaterTatica();
		controlador.acaoBotao(tela);
	}

}
