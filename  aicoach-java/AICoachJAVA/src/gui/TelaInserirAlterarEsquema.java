package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;

import negocio.AlgoritmoTatica;
import negocio.controller.ControladorAlterarEsquema;
import negocio.controller.Fachada;
import negocio.interfaces.InterfaceBotao;
import dominio.Posicao;
import dominio.Tatica;
import dominio.Time;
import perssistencia.TaticaDAO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaInserirAlterarEsquema extends JFrame {
	
	private static JButton btnConfirmar;
	private static Time time;
	public static JComboBox<Integer>comboBoxSubstituicoes;
	public static JComboBox<String>comboBoxFormacoes;
	
	
	
	
	
	public static Time getTime() {
		return time;
	}

	public static void setTime(Time time) {
		TelaInserirAlterarEsquema.time = time;
	}

	public static JButton getBtnConfirmar() {
		return btnConfirmar;
	}

	public static void setBtnConfirmar(JButton btnConfirmar) {
		TelaInserirAlterarEsquema.btnConfirmar = btnConfirmar;
	}

	public static JComboBox<Integer> getComboBoxSubstituicoes() {
		return comboBoxSubstituicoes;
	}

	public static void setComboBoxSubstituicoes(
			JComboBox<Integer> comboBoxSubstituicoes) {
		TelaInserirAlterarEsquema.comboBoxSubstituicoes = comboBoxSubstituicoes;
	}

	public static JComboBox<String> getComboBoxFormacoes() {
		return comboBoxFormacoes;
	}

	public static void setComboBoxFormacoes(JComboBox<String> comboBoxFormacoes) {
		TelaInserirAlterarEsquema.comboBoxFormacoes = comboBoxFormacoes;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInserirAlterarEsquema frame = new TelaInserirAlterarEsquema();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaInserirAlterarEsquema() {}
	public TelaInserirAlterarEsquema(final Time time) {
		setTitle("Alterar Esquema");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 235, 300);
		getContentPane().setLayout(null);
		TelaInserirAlterarEsquema.time=time;
		final TaticaDAO tDAO=new TaticaDAO();
		ArrayList<Tatica>listaTaticas=tDAO.retornarListaTaticas();
		final String[] formacoes= new String[listaTaticas.size()];
		
		for (int i = 0; i < formacoes.length; i++) {
			formacoes[i]=listaTaticas.get(i).getNome();
		}
		
		

	    comboBoxFormacoes = new JComboBox<String>(formacoes);
		comboBoxFormacoes.setBounds(34, 42, 120, 20);
		getContentPane().add(comboBoxFormacoes);
		
		Integer[] arraySub=new Integer[4];
		arraySub[0]=0;
		arraySub[1]=1;
		arraySub[2]=2;
		arraySub[3]=3;
		
	    comboBoxSubstituicoes = new JComboBox<Integer>(arraySub);
		comboBoxSubstituicoes.setBounds(34, 97, 120, 20);
		getContentPane().add(comboBoxSubstituicoes);
		
		btnConfirmar = new JButton("Confirmar");
		Fachada fachada = new Fachada();
		fachada.alterarEsquema(this);
		//ControladorAlterarEsquema controlador = new ControladorAlterarEsquema();
		//controlador.acaoBotao(this);
		/*btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControladorAlterarEsquema c=new ControladorAlterarEsquema();
				//c.getAlterarEsquema().addObserver(obs);
				c.controlar(time);
				Tatica taticaNova=tDAO.retornarTatica(comboBoxFormacoes.getSelectedItem().toString());
				int substituicoes=comboBoxSubstituicoes.getSelectedIndex();
				AlgoritmoTatica aTatica=new AlgoritmoTatica();
				
				aTatica.alterarEsquema(time, substituicoes, taticaNova);
				
				for (Posicao p : time.getTatica().getPosicoes()) {
					System.out.println(p.getNome()+" será "+ p.getJogador().getNome()+ " "+ p.getJogador().getPosicaoAtual().getPontuacao());
				}
				
				TelaTatica.daTelaInserir=true;
				TelaTatica tela=new TelaTatica();
				tela.setVisible(true);
				dispose();
			}
		});*/
		btnConfirmar.setBounds(34, 179, 109, 41);
		
		getContentPane().add(btnConfirmar);
	}
}
