package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;

import dominio.Jogador;
import dominio.Time;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TelaJogadores extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaJogadores frame = new TelaJogadores();
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
	public TelaJogadores() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		String lista[]=new String[Time.getTime().getJogadores().size()]; 
		for (int i = 0; i < lista.length; i++) {
			lista[i]=Time.getTime().getJogadores().get(i).getNome();
		}
		
		// Adicionar jogadores na Jlist
		
		JScrollPane scrollPane = new JScrollPane();
		//scrollPane.setViewportView(list);
		scrollPane.setBounds(30, 40, 358, 220);
		scrollPane.setBackground(Color.yellow);
		contentPane.add(scrollPane);
		//JScrollPane scrollPane = new JScrollPane();
		final JList list = new JList(lista);
		scrollPane.setViewportView(list);
		list.setForeground(Color.BLACK);
		list.setBackground(SystemColor.menu);
		
		MouseListener mL=new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				if(e.getClickCount()==1){
					String selectedItem = (String) list.getSelectedValue();
					System.out.println(selectedItem);
					   Jogador.setJogadorEscolhido(Time.getTime().getJogadores().get(list.getSelectedIndex()));
			           TelaJogador t = new TelaJogador();
			           t.setVisible(true);
			           dispose();
				}
			}
			
		};
		list.addMouseListener(mL);
		/*MouseListener mouseListener = new MouseListener (){
			
		    public void mouseClicked(MouseEvent e) {
		        if (e.getClickCount() == 1) {


		           String selectedItem = (String) list.getSelectedValue();
		           // add selectedItem to your second list.
		           System.out.println(selectedItem);
		           TelaJogador t = new TelaJogador();
		           t.setVisible(true);
		           dispose();
		    }

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
*/
		
		list.setBackground(SystemColor.menu);
		
		JLabel lblJogadores = new JLabel("Jogadores");
		lblJogadores.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblJogadores.setBounds(168, 11, 106, 31);
		contentPane.add(lblJogadores);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaJogadores.class.getResource("/imagens/campo.png")));
		label.setBounds(0, 0, 434, 262);
		contentPane.add(label);
		
		
	}
}
