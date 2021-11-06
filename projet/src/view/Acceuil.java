package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import view.GestionEntreprise;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Acceuil extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Acceuil frame = new Acceuil();
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
	public Acceuil() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1090, 715);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btngestionentreprise = new JButton("Gestion Entreprise");
		btngestionentreprise.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AfficherEntreprise gestentre = null;
				try {
					gestentre = new AfficherEntreprise();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				gestentre.frame.setVisible(true);
				
				
			}
		});
		btngestionentreprise.setIconTextGap(20);
		btngestionentreprise.setSize(new Dimension(10, 10));
		btngestionentreprise.setPreferredSize(new Dimension(118, 18));
		btngestionentreprise.setMinimumSize(new Dimension(85, 10));
		btngestionentreprise.setMaximumSize(new Dimension(90, 15));
		btngestionentreprise.setIcon(new ImageIcon("C:\\Users\\houssem\\Downloads\\enterprise.png"));
		btngestionentreprise.setBounds(46, 73, 318, 197);
		contentPane.add(btngestionentreprise);
		
		JButton btngestionfournisseur = new JButton("Gestion Fournisseur");
		btngestionfournisseur.setIcon(new ImageIcon("C:\\Users\\houssem\\Downloads\\provider.png"));
		btngestionfournisseur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				AfficheFournisseur gestfour = null;
				try {
					gestfour = new AfficheFournisseur();
				} catch (HeadlessException | ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				gestfour.frame.setVisible(true);
			}
		});
		btngestionfournisseur.setBounds(728, 73, 299, 197);
		contentPane.add(btngestionfournisseur);
		
		JButton btngestionclient = new JButton("Gestion Client");
		btngestionclient.setIcon(new ImageIcon("C:\\Users\\houssem\\Downloads\\customer.png"));
		btngestionclient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e2) {
				try {
					AfficheClient ac= new AfficheClient();
					ac.frame.setVisible(true);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btngestionclient.setBounds(46, 378, 320, 167);
		contentPane.add(btngestionclient);
		
		JButton btngestionproduit = new JButton("Gestion Produit");
		btngestionproduit.setIcon(new ImageIcon("C:\\Users\\houssem\\Downloads\\package.png"));
		btngestionproduit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e3) {
				try {
					AfficheProduit ap= new AfficheProduit();
					ap.frame.setVisible(true);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btngestionproduit.setBounds(707, 378, 299, 167);
		contentPane.add(btngestionproduit);
		
		JLabel lblGestionDesAchats = new JLabel("Gestion Commerciales");
		lblGestionDesAchats.setBackground(new Color(240, 240, 240));
		lblGestionDesAchats.setForeground(new Color(205, 92, 92));
		lblGestionDesAchats.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblGestionDesAchats.setBounds(341, 13, 393, 53);
		contentPane.add(lblGestionDesAchats);
		
		JLabel lblRealiserPar = new JLabel("Realiser par : houssem dalla");
		lblRealiserPar.setBackground(Color.WHITE);
		lblRealiserPar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRealiserPar.setForeground(Color.MAGENTA);
		lblRealiserPar.setBounds(46, 565, 252, 22);
		contentPane.add(lblRealiserPar);
		
		JLabel lblNewLabel_1 = new JLabel("Encadrer par : Mr Malek Ben Salem");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setForeground(Color.MAGENTA);
		lblNewLabel_1.setBounds(46, 592, 266, 28);
		contentPane.add(lblNewLabel_1);
		
		JButton btn_achat = new JButton("Achats");
		btn_achat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Factures f = null;
				try {
					f = new Factures();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				f.frame.setVisible(true);
				
				
			}
		});
		btn_achat.setIcon(new ImageIcon("C:\\Users\\houssem\\Downloads\\shopping-cart (1).png"));
		btn_achat.setBounds(376, 218, 160, 106);
		contentPane.add(btn_achat);
		
		JButton btnVentes = new JButton("Ventes");
		btnVentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FactureClientFrame fcf= new FactureClientFrame();
					fcf.frame.setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnVentes.setIcon(new ImageIcon("C:\\Users\\houssem\\Downloads\\trade.png"));
		btnVentes.setBounds(508, 337, 167, 106);
		contentPane.add(btnVentes);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\houssem\\Desktop\\t\u00E9l\u00E9charger11.jpg"));
		lblNewLabel.setBounds(12, 13, 1060, 642);
		contentPane.add(lblNewLabel);
	}
}
