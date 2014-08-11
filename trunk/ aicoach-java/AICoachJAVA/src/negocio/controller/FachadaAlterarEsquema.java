package negocio.controller;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Writer;

import javax.swing.JFrame;

import com.thoughtworks.xstream.XStream;

import dominio.Time;

import negocio.interfaces.InterfaceAlterarEsquema;

public class FachadaAlterarEsquema implements InterfaceAlterarEsquema {


	@Override
	public void alterarEsquema(final JFrame tela, String func) {
		
		
		ControladorAlterarEsquema controlador = new ControladorAlterarEsquema();
		controlador.acaoBotao(tela);
		
	}
	

}
