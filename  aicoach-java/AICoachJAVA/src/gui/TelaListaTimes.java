package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;

import negocio.controller.Fachada;
import negocio.formulas.FormulaPosicao;
import dominio.Jogador;
import dominio.PontuacaoPosicao;
import dominio.Time;
import perssistencia.PontuacaoPosicaoDAO;
import perssistencia.TimeDAO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import controle.ControladorTelaListaTimes;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class TelaListaTimes extends JFrame {
	
	private static ControladorTelaListaTimes controlador = new ControladorTelaListaTimes();
	private JPanel contentPane;
	private static JButton btnNewButton;
	private static final JComboBox comboBox = new JComboBox(controlador.retornarListaTime());;
	
	
	
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
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
	}*/

	public static JButton getBtnNewButton() {
		return btnNewButton;
	}





	public static void setBtnNewButton(JButton btnNewButton) {
		TelaListaTimes.btnNewButton = btnNewButton;
	}





	public static JComboBox<String> getComboBox() {
		return comboBox;
	}









	/**
	 * Create the frame.
	 */
	public TelaListaTimes() {
		setTitle("Ai Coach");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 493, 292);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		comboBox.setBounds(43, 100, 190, 29);
		contentPane.add(comboBox);
		
		btnNewButton = new JButton("Confirmar");
		
		Fachada fachada = new Fachada();
		fachada.escolherJogador(this);
		
		//controlador.acaoBotao(this);
		/*btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ac) {
					FormulaPosicao form=new FormulaPosicao();
					PontuacaoPosicaoDAO ppDAO=new PontuacaoPosicaoDAO();
					//int breaktudo=0;
					for(Jogador j :time.getJogadores()){
						form.calculeTudo(j);
						for(int i=0;i<j.getPosicoes().size();i++){
							//System.out.println(j.getNome()+" "+ j.getPosicoes().get(i).getNome()+ " "+j.getPosicoes().get(i).getPontuacao()+ " "+ j.getPosicoes().get(i).isPosicaoDeOrigem());
							ppDAO.inserirPontuacaoPosicoesJogador(j);
						}
					}
					
					TelaTime tela = new TelaTime();
					tela.setVisible(true);
					dispose();
			}
		});*/
		btnNewButton.setBounds(340, 101, 89, 26);
		contentPane.add(btnNewButton);
		
		JLabel lblEscolhaUmTime = new JLabel("Escolha um time ");
		lblEscolhaUmTime.setForeground(Color.WHITE);
		lblEscolhaUmTime.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEscolhaUmTime.setBounds(184, 25, 228, 14);
		contentPane.add(lblEscolhaUmTime);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaListaTimes.class.getResource("/imagens/campo.png")));
		lblNewLabel.setBounds(0,0, 477, 254);
		contentPane.add(lblNewLabel);
	}
}
