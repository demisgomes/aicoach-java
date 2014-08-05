package negocio.controller;

import javax.swing.JFrame;

import controle.ControladorCadastroJogador;
import controle.ControladorCadastroTatica;
import controle.ControladorCadastroTime;
import controle.ControladorCaracteristicas;
import controle.ControladorJogador;
import controle.ControladorJogadores;
import controle.ControladorTatica;
import controle.ControladorTelaInicial;
import controle.ControladorTelaListaTimes;
import controle.ControladorTelaPrincipal;
import dominio.Time;
import negocio.interfaces.InterfaceControladores;
import negocio.interfaces.InterfaceTatica;

public class Fachada implements InterfaceTatica, InterfaceControladores {

	@Override
	public void alterarEsquema(final JFrame tela) {
		ControladorAlterarEsquema controlador = new ControladorAlterarEsquema();
		controlador.acaoBotao(tela);
		
	}

	@Override
	public void combaterTatica(final JFrame tela) {
		ControladorCombaterTatica controlador = new ControladorCombaterTatica();
		controlador.acaoBotao(tela);
		
	}

	@Override
	public void taticas(JFrame tela) {
		ControladorTatica controlador = new ControladorTatica();
		controlador.acaoBotao(tela);
		
	}

	@Override
	public void criarJogador(JFrame tela) {
		ControladorCadastroJogador controlador = new ControladorCadastroJogador();
		controlador.acaoBotao(tela);
		
	}

	@Override
	public void criarTatica(JFrame tela) {
		ControladorCadastroTatica controlador = new ControladorCadastroTatica();
		controlador.acaoBotao(tela);
		
	}

	@Override
	public void criarTime(JFrame tela) {
		ControladorCadastroTime controlador = new ControladorCadastroTime();
		controlador.acaoBotao(tela);
		
	}

	@Override
	public void criarCaracteristicas(JFrame tela) {
		ControladorCaracteristicas controlador = new ControladorCaracteristicas();
		controlador.setCaracteristicas();
		controlador.acaoBotao(tela);
		
	}

	@Override
	public void inserirCaracteristicas(JFrame tela) {
		ControladorJogador controlador = new ControladorJogador();
		controlador.acaoBotao(tela);
		
	}

	@Override
	public void abrirListaJogadores(JFrame tela) {
		ControladorJogadores controlador = new ControladorJogadores();
		controlador.acaoBotao(tela);
		
	}

	@Override
	public void iniciarPrograma(JFrame tela) {
		ControladorTelaInicial controlador = new ControladorTelaInicial();
		controlador.acaoBotao(tela);
	}

	@Override
	public void escolherJogador(JFrame tela) {
		ControladorTelaListaTimes controlador = new ControladorTelaListaTimes();
		controlador.acaoBotao(tela);
		
	}

	@Override
	public void acoesTime(JFrame tela) {
		ControladorTelaPrincipal controlador = new ControladorTelaPrincipal();
		controlador.acaoBotao(tela);
		
	}

	
	

}
