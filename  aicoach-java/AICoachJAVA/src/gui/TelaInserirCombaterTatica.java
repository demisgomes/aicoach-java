package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dominio.Time;

import javax.swing.JButton;

import perssistencia.TaticaDAO;
import perssistencia.TimeDAO;
import negocio.AlgoritmoTatica;
import negocio.controller.ControladorCombaterTatica;
import negocio.controller.Fachada;
import negocio.controller.FachadaCombaterTatica;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaInserirCombaterTatica extends JFrame {

	private JPanel contentPane;
	public static Time time;
	public static JComboBox<String> comboBox;
	private static JButton btnCombater;
	
	
	public static JButton getBtnCombater() {
		return btnCombater;
	}

	public static void setBtnCombater(JButton btnCombater) {
		TelaInserirCombaterTatica.btnCombater = btnCombater;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInserirCombaterTatica frame = new TelaInserirCombaterTatica();
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
	public TelaInserirCombaterTatica() {}
	public TelaInserirCombaterTatica(Time time) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 277, 334);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		TimeDAO timeDAO=new TimeDAO();
		TelaInserirCombaterTatica.time=timeDAO.retornarTime(time.getIdTime());
		String [] listaTimes=new String[Time.getListaTimes().size()-1];
		int countlista=0;
		for (int i = 0; i < Time.getListaTimes().size(); i++) {
			if(Time.getListaTimes().get(i).getIdTime()!=time.getIdTime()){
				listaTimes[countlista]=Time.getListaTimes().get(i).getNome();
				countlista++;
			}		
		}
		comboBox = new JComboBox<String>(listaTimes);
		comboBox.setBounds(20, 32, 167, 20);
		contentPane.add(comboBox);
		
		btnCombater = new JButton("Combater");
		FachadaCombaterTatica fachada = new FachadaCombaterTatica();
		fachada.combaterTatica(this, "combaterTatica");
		//ControladorCombaterTatica controlador = new ControladorCombaterTatica();
		//controlador.acaoBotao(this);
		/*btnCombater.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControladorCombaterTatica c=new ControladorCombaterTatica();
				c.controlar(TelaInserirCombaterTatica.time);
				Time timeEscolhido=Time.getListaTimes().get(comboBox.getSelectedIndex());
				TaticaDAO tDAO=new TaticaDAO();
				AlgoritmoTatica aTatica=new AlgoritmoTatica();
				aTatica.combaterTatica(TelaInserirCombaterTatica.time, timeEscolhido, tDAO.retornarListaTaticas());
				//aTatica.alterarEsquema(TelaInserirCombaterTatica.time, 0, tDAO.retornarTatica(time.getTatica().getNome()));
				TelaTatica.daTelaInserir=true;
				TelaTatica.naoSalvar=true;
				Time time=TelaInserirCombaterTatica.time;
				TelaTatica tela=new TelaTatica();
				tela.setVisible(true);
				dispose();
			}
		});*/
		btnCombater.setBounds(54, 100, 95, 35);
		contentPane.add(btnCombater);
		
		
		
		
	}
}
