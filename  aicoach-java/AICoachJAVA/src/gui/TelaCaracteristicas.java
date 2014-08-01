package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class TelaCaracteristicas extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCaracteristicas frame = new TelaCaracteristicas();
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
	public TelaCaracteristicas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("finaliza\u00E7\u00E3o");
		lblNewLabel.setBounds(6, 96, 50, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblBolaParada = new JLabel("bola parada");
		lblBolaParada.setBounds(228, 96, 62, 14);
		contentPane.add(lblBolaParada);
		
		JLabel lblRessistncia = new JLabel("ressist\u00EAncia");
		lblRessistncia.setBounds(10, 11, 66, 14);
		contentPane.add(lblRessistncia);
		
		JLabel lblQualidadeDoPasse = new JLabel("qualidade do passe");
		lblQualidadeDoPasse.setBounds(229, 11, 99, 14);
		contentPane.add(lblQualidadeDoPasse);
		
		JLabel lblVelocidade = new JLabel("velocidade");
		lblVelocidade.setBounds(6, 53, 66, 14);
		contentPane.add(lblVelocidade);
		
		JLabel lblCabeceio = new JLabel("cabeceio");
		lblCabeceio.setBounds(228, 53, 66, 14);
		contentPane.add(lblCabeceio);
		
		JLabel lblControleDeBola = new JLabel("controle de bola");
		lblControleDeBola.setBounds(6, 134, 87, 14);
		contentPane.add(lblControleDeBola);
		
		JLabel lblDrible = new JLabel("drible");
		lblDrible.setBounds(228, 134, 66, 14);
		contentPane.add(lblDrible);
		
		JLabel lblDesarme = new JLabel("desarme");
		lblDesarme.setBounds(6, 176, 66, 14);
		contentPane.add(lblDesarme);
		
		JLabel lblDefesa = new JLabel("defesa");
		lblDefesa.setBounds(224, 176, 66, 14);
		contentPane.add(lblDefesa);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(160, 228, 89, 23);
		contentPane.add(btnConfirmar);
		
		JComboBox cBRessistencia = new JComboBox();
		cBRessistencia.setBounds(103, 8, 80, 20);
		contentPane.add(cBRessistencia);
		
		JComboBox cBVelocidade = new JComboBox();
		cBVelocidade.setBounds(103, 50, 80, 20);
		contentPane.add(cBVelocidade);
		
		JComboBox cBFinalizacao = new JComboBox();
		cBFinalizacao.setBounds(103, 93, 80, 20);
		contentPane.add(cBFinalizacao);
		
		JComboBox cBControleBola = new JComboBox();
		cBControleBola.setBounds(103, 131, 80, 20);
		contentPane.add(cBControleBola);
		
		JComboBox cBDesarme = new JComboBox();
		cBDesarme.setBounds(103, 173, 80, 20);
		contentPane.add(cBDesarme);
		
		JComboBox cBQualidadePasse = new JComboBox();
		cBQualidadePasse.setBounds(338, 8, 80, 20);
		contentPane.add(cBQualidadePasse);
		
		JComboBox cBCabeceio = new JComboBox();
		cBCabeceio.setBounds(338, 50, 80, 20);
		contentPane.add(cBCabeceio);
		
		JComboBox cBBolaParada = new JComboBox();
		cBBolaParada.setBounds(338, 93, 80, 20);
		contentPane.add(cBBolaParada);
		
		JComboBox cBDrible = new JComboBox();
		cBDrible.setBounds(338, 134, 80, 20);
		contentPane.add(cBDrible);
		
		JComboBox cBDefesa = new JComboBox();
		cBDefesa.setBounds(338, 173, 80, 20);
		contentPane.add(cBDefesa);
	}
}
