package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import dominio.ButtonAiCoach;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;

import java.awt.Color;
import java.util.ArrayList;

public class TelaTatica extends JFrame {

	private JPanel contentPane;
	private ArrayList<Integer> listaIdPosicoes=new ArrayList<Integer>();

	ArrayList<ButtonAiCoach> listaBotoes = new ArrayList<ButtonAiCoach>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaTatica frame = new TelaTatica();
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
	public TelaTatica() {
		setTitle("Tela T\u00E1tica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 714, 568);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		JButton btnSugerirTtica = new JButton("Sugerir T\u00E1tica");
		btnSugerirTtica.setBounds(27, 23, 135, 23);
		contentPane.add(btnSugerirTtica);
		
		JButton btnNewButtonAiCoach = new JButton("Alterar Esquema");
		btnNewButtonAiCoach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButtonAiCoach.setBounds(27, 57, 135, 23);
		contentPane.add(btnNewButtonAiCoach);
		
		final String[] formacoes= new String[6];
		formacoes[0]="4-4-2";
		formacoes[1]="3-5-2";
		formacoes[2]="4-3-3";
		formacoes[3]="4-5-1";
		formacoes[4]="3-6-1";
		formacoes[5]="5-3-2";
		
		

		
		final JComboBox comboBox = new JComboBox<String>(formacoes);
		comboBox.setBounds(239, 24, 93, 20);
		contentPane.add(comboBox);
		
		
		
		ButtonAiCoach btnGL = new ButtonAiCoach("GL");
		btnGL.setBackground(Color.GRAY);
		
		btnGL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnGL.setBounds(50, 277, 45, 43);
		btnGL.setId(1);
		listaBotoes.add(btnGL);
		contentPane.add(btnGL);
		
		
		ButtonAiCoach btnZc_2 = new ButtonAiCoach("ZC");
		btnZc_2.setBackground(Color.GRAY);
		btnZc_2.setBounds(130, 203, 45, 43);
		btnZc_2.setId(5);
		listaBotoes.add(btnZc_2);
		contentPane.add(btnZc_2);
		
		ButtonAiCoach btnZc = new ButtonAiCoach("ZC");
		btnZc.setBackground(Color.GRAY);
		btnZc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnZc.setId(3);
		listaBotoes.add(btnZc);
		btnZc.setBounds(130, 361, 45, 43);
		contentPane.add(btnZc);
		
		
		
		ButtonAiCoach btnLd = new ButtonAiCoach("LD");
		btnLd.setBackground(Color.GRAY);
		btnLd.setBounds(130, 463, 45, 43);
		btnLd.setId(2);
		listaBotoes.add(btnLd);
		contentPane.add(btnLd);
		
		ButtonAiCoach btnZc_1 = new ButtonAiCoach("ZC");
		btnZc_1.setBackground(Color.GRAY);
		btnZc_1.setBounds(130, 277, 45, 43);
		btnZc_1.setId(4);
		listaBotoes.add(btnZc_1);
		contentPane.add(btnZc_1);
		
		ButtonAiCoach btnLe = new ButtonAiCoach("LE");
		btnLe.setId(6);
		btnLe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLe.setBackground(Color.GRAY);
		btnLe.setBounds(130, 113, 45, 43);
		listaBotoes.add(btnLe);
		contentPane.add(btnLe);
		
		ButtonAiCoach btnVol = new ButtonAiCoach("VOL");
		btnVol.setBackground(Color.GRAY);
		btnVol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVol.setBounds(225, 373, 51, 43);
		btnVol.setId(8);
		listaBotoes.add(btnVol);
		contentPane.add(btnVol);
		
		
		ButtonAiCoach btnVol_1 = new ButtonAiCoach("VOL");
		btnVol_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVol_1.setBackground(Color.GRAY);
		btnVol_1.setBounds(225, 277, 51, 43);
		btnVol_1.setId(9);
		listaBotoes.add(btnVol_1);
		contentPane.add(btnVol_1);
		
		ButtonAiCoach btnVol_2 = new ButtonAiCoach("VOL");
		btnVol_2.setBackground(Color.GRAY);
		btnVol_2.setBounds(225, 203, 51, 43);
		btnVol_2.setId(10);
		listaBotoes.add(btnVol_2);
		contentPane.add(btnVol_2);
		
		ButtonAiCoach btnLd_1 = new ButtonAiCoach("LD");
		btnLd_1.setBackground(Color.GRAY);
		btnLd_1.setBounds(225, 463, 45, 43);
		btnLd_1.setId(7);
		listaBotoes.add(btnLd_1);
		contentPane.add(btnLd_1);
		
		ButtonAiCoach btnLe_1 = new ButtonAiCoach("LE");
		btnLe_1.setId(11);
		btnLe_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLe_1.setBackground(Color.GRAY);
		btnLe_1.setBounds(225, 113, 45, 43);
		listaBotoes.add(btnLe_1);
		contentPane.add(btnLe_1);
		
		ButtonAiCoach btnMld = new ButtonAiCoach("MLD");
		btnMld.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMld.setBackground(Color.GRAY);
		btnMld.setId(12);
		listaBotoes.add(btnMld);
		btnMld.setBounds(322, 463, 58, 43);
		
		contentPane.add(btnMld);
		
		ButtonAiCoach btnMc = new ButtonAiCoach("MC");
		btnMc.setBackground(Color.GRAY);
		btnMc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMc.setId(13);
		btnMc.setBounds(322, 373, 51, 43);
		listaBotoes.add(btnMc);
		contentPane.add(btnMc);
		
		ButtonAiCoach btnMc_1 = new ButtonAiCoach("MC");
		btnMc_1.setBackground(Color.GRAY);
		btnMc_1.setBounds(322, 277, 51, 43);
		btnMc_1.setId(14);
		listaBotoes.add(btnMc_1);
		contentPane.add(btnMc_1);
		
		ButtonAiCoach btnMc_2 = new ButtonAiCoach("MC");
		btnMc_2.setBackground(Color.GRAY);
		btnMc_2.setBounds(322, 203, 51, 43);
		btnMc_2.setId(15);
		listaBotoes.add(btnMc_2);
		contentPane.add(btnMc_2);
		
		ButtonAiCoach btnMle = new ButtonAiCoach("MLE");
		btnMle.setBackground(Color.GRAY);
		btnMle.setBounds(322, 113, 58, 43);
		btnMle.setId(16);
		listaBotoes.add(btnMle);
		contentPane.add(btnMle);
		
		ButtonAiCoach btnMle_1 = new ButtonAiCoach("MLE");
		btnMle_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMle_1.setBackground(Color.GRAY);
		btnMle_1.setBounds(423, 113, 58, 43);
		btnMle_1.setId(21);
		listaBotoes.add(btnMle_1);
		contentPane.add(btnMle_1);
		
		ButtonAiCoach btnMat_2 = new ButtonAiCoach("MAT");
		btnMat_2.setBackground(Color.GRAY);
		btnMat_2.setBounds(423, 203, 58, 43);
		btnMat_2.setId(20);
		listaBotoes.add(btnMat_2);
		contentPane.add(btnMat_2);
		
		ButtonAiCoach btnMat_1 = new ButtonAiCoach("MAT");
		btnMat_1.setBackground(Color.GRAY);
		btnMat_1.setBounds(423, 277, 58, 43);
		btnMat_1.setId(19);
		listaBotoes.add(btnMat_1);
		contentPane.add(btnMat_1);
		
		ButtonAiCoach btnMat = new ButtonAiCoach("MAT");
		btnMat.setBackground(Color.GRAY);
		btnMat.setBounds(423, 373, 58, 43);
		btnMat.setId(18);
		listaBotoes.add(btnMat);
		contentPane.add(btnMat);
		
		ButtonAiCoach btnMld_1 = new ButtonAiCoach("MLD");
		btnMld_1.setBackground(Color.GRAY);
		btnMld_1.setBounds(423, 463, 58, 43);
		btnMld_1.setId(17);
		listaBotoes.add(btnMld_1);
		contentPane.add(btnMld_1);
		
		ButtonAiCoach btnPte = new ButtonAiCoach("PTE");
		btnPte.setBackground(Color.GRAY);
		btnPte.setBounds(534, 113, 59, 43);
		btnPte.setId(26);
		listaBotoes.add(btnPte);
		contentPane.add(btnPte);
		
		ButtonAiCoach btnSa_1 = new ButtonAiCoach("SA");
		btnSa_1.setBackground(Color.GRAY);
		btnSa_1.setBounds(534, 203, 45, 43);
		btnSa_1.setId(25);
		listaBotoes.add(btnSa_1);
		contentPane.add(btnSa_1);
		
		ButtonAiCoach btnCa = new ButtonAiCoach("CA");
		btnCa.setBounds(548, 277, 51, 43);
		btnCa.setBackground(Color.GRAY);
		btnCa.setId(24);
		listaBotoes.add(btnCa);
		contentPane.add(btnCa);
		
		ButtonAiCoach btnSa = new ButtonAiCoach("SA");
		btnSa.setBackground(Color.GRAY);
		btnSa.setBounds(534, 361, 45, 43);
		btnSa.setId(23);
		listaBotoes.add(btnSa);
		contentPane.add(btnSa);
		
		ButtonAiCoach btnPtd = new ButtonAiCoach("PTD");
		btnPtd.setBackground(Color.GRAY);
		btnPtd.setBounds(534, 463, 59, 43);
		btnPtd.setId(22);
		listaBotoes.add(btnPtd);
		contentPane.add(btnPtd);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaTatica.class.getResource("/imagens/campo.png")));
		lblNewLabel.setBounds(37, 81, 688, 438);
		contentPane.add(lblNewLabel);
		
JButton btnEscolherMelhoresJogadores = new JButton("Escolher Melhores Jogadores");
		
		btnEscolherMelhoresJogadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for(int j=0;j<listaBotoes.size();j++){
					listaBotoes.get(j).setVisible(false);
					listaBotoes.get(j).setBackground(Color.GRAY);
				}
				
				if(formacoes[comboBox.getSelectedIndex()].equals("4-4-2")){
					listaIdPosicoes.clear();
					listaIdPosicoes.add(1);
					listaIdPosicoes.add(2);
					listaIdPosicoes.add(3);
					listaIdPosicoes.add(5);
					listaIdPosicoes.add(6);
					listaIdPosicoes.add(9);
					listaIdPosicoes.add(13);
					listaIdPosicoes.add(15);
					listaIdPosicoes.add(19);
					listaIdPosicoes.add(25);
					listaIdPosicoes.add(24);
					
				}
				
				if(formacoes[comboBox.getSelectedIndex()].equals("3-5-2")){
					
					listaIdPosicoes.clear();
					listaIdPosicoes.add(1);
					listaIdPosicoes.add(4);
					listaIdPosicoes.add(3);
					listaIdPosicoes.add(5);
					listaIdPosicoes.add(12);
					listaIdPosicoes.add(9);
					listaIdPosicoes.add(13);
					listaIdPosicoes.add(16);
					listaIdPosicoes.add(19);
					listaIdPosicoes.add(25);
					listaIdPosicoes.add(24);
				}
				
				if(formacoes[comboBox.getSelectedIndex()].equals("4-3-3")){
					listaIdPosicoes.clear();
					listaIdPosicoes.add(1);
					listaIdPosicoes.add(2);
					listaIdPosicoes.add(3);
					listaIdPosicoes.add(5);
					listaIdPosicoes.add(6);
					listaIdPosicoes.add(9);
					listaIdPosicoes.add(13);
					listaIdPosicoes.add(19);
					listaIdPosicoes.add(22);
					listaIdPosicoes.add(26);
					listaIdPosicoes.add(24);
					
				}

				if(formacoes[comboBox.getSelectedIndex()].equals("5-3-2")){
					
					listaIdPosicoes.clear();
					listaIdPosicoes.add(1);
					listaIdPosicoes.add(7);
					listaIdPosicoes.add(3);
					listaIdPosicoes.add(5);
					listaIdPosicoes.add(4);
					listaIdPosicoes.add(11);
					listaIdPosicoes.add(9);
					listaIdPosicoes.add(15);
					listaIdPosicoes.add(19);
					listaIdPosicoes.add(25);
					listaIdPosicoes.add(24);
				}

				if(formacoes[comboBox.getSelectedIndex()].equals("4-5-1")){
					
					listaIdPosicoes.clear();
					listaIdPosicoes.add(1);
					listaIdPosicoes.add(2);
					listaIdPosicoes.add(3);
					listaIdPosicoes.add(5);
					listaIdPosicoes.add(6);
					listaIdPosicoes.add(9);
					listaIdPosicoes.add(13);
					listaIdPosicoes.add(17);
					listaIdPosicoes.add(21);
					listaIdPosicoes.add(19);
					listaIdPosicoes.add(24);
				}

				if(formacoes[comboBox.getSelectedIndex()].equals("3-6-1")){
					
					listaIdPosicoes.clear();
					listaIdPosicoes.add(1);
					listaIdPosicoes.add(4);
					listaIdPosicoes.add(3);
					listaIdPosicoes.add(5);
					listaIdPosicoes.add(10);
					listaIdPosicoes.add(8);
					listaIdPosicoes.add(14);
					listaIdPosicoes.add(19);
					listaIdPosicoes.add(17);
					listaIdPosicoes.add(21);
					listaIdPosicoes.add(24);
				}
				
				
				for(int i=0;i<11;i++){
					for(int j=0;j<listaBotoes.size();j++){
						System.out.println(listaIdPosicoes.get(i)+ " "+ listaBotoes.get(j).getId());
						if(listaIdPosicoes.get(i)==listaBotoes.get(j).getId()){
							listaBotoes.get(j).setBackground(Color.GREEN);
							break;
						}
					}
				}
				
				for(int j=0;j<listaBotoes.size();j++){
					if(listaBotoes.get(j).getBackground()==Color.green){
						listaBotoes.get(j).setVisible(true);
					}
				}
						
			}
		});
		
		for(int j=0;j<listaBotoes.size();j++){
			listaBotoes.get(j).setVisible(false);
		}
		btnEscolherMelhoresJogadores.setBounds(354, 23, 185, 23);
		contentPane.add(btnEscolherMelhoresJogadores);
		
		
		
	}
}
