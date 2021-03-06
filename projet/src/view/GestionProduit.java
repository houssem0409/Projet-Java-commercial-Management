package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import model.GlobalVariables;

import java.awt.Font;
import java.awt.Color;

public class GestionProduit {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionProduit window = new GestionProduit();
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
	public GestionProduit() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 529, 405);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton add_bn = new JButton("Ajouter");
		add_bn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//***** ajouter****************
				try {
					AddProduit addprod= new AddProduit(GlobalVariables.ADDVALUE);
					addprod.setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		add_bn.setBackground(new Color(124, 252, 0));
		add_bn.setBounds(32, 80, 175, 105);
		frame.getContentPane().add(add_bn);
		
		JButton edit_bn = new JButton("Modifier");
		edit_bn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//*********** modifier***********
			}
		});
		edit_bn.setBackground(new Color(255, 140, 0));
		edit_bn.setBounds(286, 80, 175, 105);
		frame.getContentPane().add(edit_bn);
		
		JButton delete_bn = new JButton("Supprimer");
		delete_bn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//**********supprimer**********
			}
		});
		delete_bn.setBackground(new Color(255, 0, 0));
		delete_bn.setBounds(32, 198, 175, 111);
		frame.getContentPane().add(delete_bn);
		
		JButton affiche_bn = new JButton("Afficher");
		affiche_bn.setBackground(new Color(0, 191, 255));
		affiche_bn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//*********** afficher*************
				try {
					AfficheProduit affichprod= new AfficheProduit();
					affichprod.frame.setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		affiche_bn.setBounds(286, 198, 175, 111);
		frame.getContentPane().add(affiche_bn);
		
		JLabel lblGestionProduits = new JLabel("Gestion Produits");
		lblGestionProduits.setForeground(new Color(70, 130, 180));
		lblGestionProduits.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGestionProduits.setBounds(180, 25, 175, 23);
		frame.getContentPane().add(lblGestionProduits);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///********** back**********
			}
		});
		btnNewButton.setBounds(30, 322, 97, 25);
		frame.getContentPane().add(btnNewButton);
	}

}
