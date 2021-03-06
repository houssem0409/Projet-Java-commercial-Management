package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionClient {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionClient window = new GestionClient();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GestionClient() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 554, 383);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton add_bn = new JButton("Ajouter");
		add_bn.setBackground(new Color(50, 205, 50));
		add_bn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				/// *****************ajout ***************
			}
		});
		add_bn.setBounds(26, 64, 200, 97);
		frame.getContentPane().add(add_bn);
		
		JButton edit_bn = new JButton("Modifier");
		edit_bn.setBackground(new Color(255, 140, 0));
		edit_bn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		     ////******************** edit ****************
			}
		});
		edit_bn.setBounds(295, 64, 193, 97);
		frame.getContentPane().add(edit_bn);
		
		JButton delete_bn = new JButton("Supprimer");
		delete_bn.setBackground(new Color(255, 0, 0));
		delete_bn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///***************supprimer **************
			}
		});
		delete_bn.setBounds(26, 189, 200, 91);
		frame.getContentPane().add(delete_bn);
		
		JButton affiche_bn = new JButton("Afficher");
		affiche_bn.setBackground(new Color(0, 191, 255));
		affiche_bn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//***** afficher********************
			}
		});
		affiche_bn.setBounds(295, 189, 193, 91);
		frame.getContentPane().add(affiche_bn);
		
		JLabel lblNewLabel = new JLabel("Gestion Clients");
		lblNewLabel.setForeground(new Color(34, 139, 34));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(184, 13, 158, 32);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//************ back****************
			}
		});
		btnBack.setBounds(26, 298, 97, 25);
		frame.getContentPane().add(btnBack);
	}

}
