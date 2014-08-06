package negocio.controller;

import javax.swing.JFrame;

import negocio.interfaces.InterfaceAlterarEsquema;

public class FachadaAlterarEsquema implements InterfaceAlterarEsquema {

	@Override
	public void alterarEsquema(final JFrame tela) {
		ControladorAlterarEsquema controlador = new ControladorAlterarEsquema();
		controlador.acaoBotao(tela);
		
	}
	

}
