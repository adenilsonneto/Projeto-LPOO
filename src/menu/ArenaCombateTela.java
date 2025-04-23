package menu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arenas.ArenaCombate;
import jogadores.Jogador;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ArenaCombateTela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private NomearJogadores nomearJogador1;
	private ArenaCombate arena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArenaCombateTela frame = new ArenaCombateTela(null);
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
	public ArenaCombateTela(ArrayList<Jogador> jogador) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1394, 752);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.nomearJogador1 = new NomearJogadores();
		this.arena = new ArenaCombate();
		this.arena.receberJogadores(jogador.get(0));
		this.arena.receberJogadores(jogador.get(1));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1387, 722);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblArenaCombate = new JLabel("New label");
		lblArenaCombate.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		lblArenaCombate.setForeground(new Color(255, 0, 0));
		lblArenaCombate.setBounds(661, 0, 230, 60);
		panel.add(lblArenaCombate);
		lblArenaCombate.setText("ARENA DE COMBATE");
		
		JButton btnCarta1 = new JButton("New button");
		btnCarta1.setBounds(101, 594, 105, 53);
		panel.add(btnCarta1);
		
		JButton btnCarta2 = new JButton("New button");
		btnCarta2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCarta2.setBounds(217, 594, 105, 53);
		panel.add(btnCarta2);
		
		JButton btnCarta3 = new JButton("New button");
		btnCarta3.setBounds(339, 594, 105, 53);
		panel.add(btnCarta3);
		
		JButton btnCarta4 = new JButton("New button");
		btnCarta4.setBounds(454, 594, 105, 53);
		panel.add(btnCarta4);
		
		JButton btnCarta5 = new JButton("New button");
		btnCarta5.setBounds(569, 594, 105, 53);
		panel.add(btnCarta5);
		
		JLabel lblmaoJogador1 = new JLabel("New label");
		lblmaoJogador1.setForeground(new Color(255, 0, 0));
		lblmaoJogador1.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		lblmaoJogador1.setBounds(111, 657, 563, 55);
		panel.add(lblmaoJogador1);
		lblmaoJogador1.setText("Mão de "+ arena.getArray().get(0).toString());
	}
}
