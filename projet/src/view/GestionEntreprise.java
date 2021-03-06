package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import view.AddEntreprise;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.GlobalVariables;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class GestionEntreprise extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionEntreprise frame = new GestionEntreprise();
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
	public GestionEntreprise() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AddEntreprise addentre = new AddEntreprise(GlobalVariables.ADDVALUE);
					addentre.setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBackground(new Color(124, 252, 0));
		btnNewButton.setBounds(36, 33, 121, 84);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Modifier");
		btnNewButton_1.setBounds(250, 33, 116, 84);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Supprimer");
		btnNewButton_2.setBounds(36, 130, 121, 81);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Afficher");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e3) {
				
				try {
					AfficherEntreprise affichentre = new AfficherEntreprise();
					affichentre.frame.setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_3.setBounds(250, 130, 116, 81);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("Gestion Entreprise");
		lblNewLabel.setForeground(new Color(0, 128, 128));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(108, 0, 186, 29);
		contentPane.add(lblNewLabel);
	}

}
