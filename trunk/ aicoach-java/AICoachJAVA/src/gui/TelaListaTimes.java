package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;

import dominio.Time;
import perssistencia.TimeDAO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaListaTimes extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListaTimes frame = new TelaListaTimes();
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
	public TelaListaTimes() {
		setTitle("Tela Times");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 482, 174);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		TimeDAO tDAO=new TimeDAO();
		
		ArrayList <Time> listaTime=tDAO.retornarListaTimes();
		String [] listaTimes=new String[listaTime.size()];
		for (int i = 0; i < listaTimes.length; i++) {
			listaTimes[i]=listaTime.get(i).getNome();
		}
		JComboBox<String> comboBox = new JComboBox<String>(listaTimes);
		comboBox.setBounds(10, 26, 190, 29);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ac) {
					TelaTime tela = new TelaTime("Tela time", 600, 300);
					tela.setVisible(true);
					dispose();
			}
		});
		btnNewButton.setBounds(257, 29, 89, 26);
		contentPane.add(btnNewButton);
	}
}
