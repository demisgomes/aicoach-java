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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaInserirCombaterTatica extends JFrame {

	private JPanel contentPane;
	private static Time time;

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
		String [] listaTimes=new String[Time.getListaTimes().size()];
		int countlista=0;
		for (int i = 0; i < listaTimes.length; i++) {
			if(Time.getListaTimes().get(i).getIdTime()!=time.getIdTime()){
				listaTimes[countlista]=Time.getListaTimes().get(i).getNome();
				countlista++;
			}		
		}
		final JComboBox <String> comboBox = new JComboBox<String>(listaTimes);
		comboBox.setBounds(20, 32, 167, 20);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Combater");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Time timeEscolhido=Time.getListaTimes().get(comboBox.getSelectedIndex());
				TaticaDAO tDAO=new TaticaDAO();
				AlgoritmoTatica aTatica=new AlgoritmoTatica();
				aTatica.combaterTatica(TelaInserirCombaterTatica.time, timeEscolhido, tDAO.retornarListaTaticas());
				
				TelaTatica.daTelaInserir=true;
				TelaTatica tela=new TelaTatica(TelaInserirCombaterTatica.time);
				tela.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(54, 100, 95, 35);
		contentPane.add(btnNewButton);
		
		
		
		
	}
}
