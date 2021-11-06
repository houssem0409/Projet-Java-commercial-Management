package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import database.DataBaseConnection;
import model.BonLivraison;
import model.BonReception;
import net.proteanit.sql.DbUtils;

public class BonLivraisonFrame {

	
	public JFrame frame;
	private JTable table;
	static  JTextField tfidbon;
	private JTextField tfcode;
	private JTextField tfdatebon;
	private JTextField tfdaterecp;
	private JTextField tfadresserecp;
	private JTextField tfnumcommande;
	private JTextField tfidfacturefournisseur;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BonLivraisonFrame window = new BonLivraisonFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public BonLivraisonFrame() throws ClassNotFoundException, SQLException {
		DataBaseConnection.connecter();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1258, 710);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setBackground(new Color(153, 204, 255));
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"idBonlivraison", "code", "dateBon", "dateLivraison", "adresseLivraison", "numCommande", "idFacture"},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table.setBounds(376, 127, 821, 16);
		frame.getContentPane().add(table);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 2, 2);
		frame.getContentPane().add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("idBonReception");
		lblNewLabel.setBounds(28, 110, 93, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Code");
		lblNewLabel_1.setBounds(28, 156, 56, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("dateBon");
		lblNewLabel_3.setBounds(28, 208, 56, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("dateLivraison");
		lblNewLabel_4.setBounds(28, 274, 93, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("adresseLivraison");
		lblNewLabel_5.setBounds(28, 333, 107, 16);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("numCommande");
		lblNewLabel_6.setBounds(28, 380, 93, 16);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_8 = new JLabel("idFactureFournisseur");
		lblNewLabel_8.setBounds(28, 447, 129, 16);
		frame.getContentPane().add(lblNewLabel_8);
		
		tfidbon = new JTextField();
		tfidbon.setBounds(169, 107, 116, 22);
		frame.getContentPane().add(tfidbon);
		tfidbon.setColumns(10);
		
		tfcode = new JTextField();
		tfcode.setBounds(169, 153, 116, 22);
		frame.getContentPane().add(tfcode);
		tfcode.setColumns(10);
		
		tfdatebon = new JTextField();
		tfdatebon.setBounds(169, 205, 116, 22);
		frame.getContentPane().add(tfdatebon);
		tfdatebon.setColumns(10);
		
		tfdaterecp = new JTextField();
		tfdaterecp.setBounds(169, 274, 116, 22);
		frame.getContentPane().add(tfdaterecp);
		tfdaterecp.setColumns(10);
		
		tfadresserecp = new JTextField();
		tfadresserecp.setBounds(169, 330, 116, 22);
		frame.getContentPane().add(tfadresserecp);
		tfadresserecp.setColumns(10);
		
		tfnumcommande = new JTextField();
		tfnumcommande.setBounds(169, 377, 116, 22);
		frame.getContentPane().add(tfnumcommande);
		tfnumcommande.setColumns(10);
		
		tfidfacturefournisseur = new JTextField();
		tfidfacturefournisseur.setBounds(169, 444, 116, 22);
		frame.getContentPane().add(tfidfacturefournisseur);
		tfidfacturefournisseur.setColumns(10);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				DefaultTableModel model= (DefaultTableModel)table_1.getModel();
				int selectedRowIndex = table_1.getSelectedRow();
				
				tfidbon.setText(model.getValueAt(selectedRowIndex, 0).toString());
				tfcode.setText(model.getValueAt(selectedRowIndex, 1).toString());
				
				tfdatebon.setText(model.getValueAt(selectedRowIndex, 2).toString());
				tfdaterecp.setText(model.getValueAt(selectedRowIndex, 3).toString());
				tfadresserecp.setText(model.getValueAt(selectedRowIndex, 4).toString());
				tfnumcommande.setText(model.getValueAt(selectedRowIndex, 5).toString());
		
				tfidfacturefournisseur.setText(model.getValueAt(selectedRowIndex, 6).toString());
				
				
				
				
			}
		});
		table_1.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, null, null, null));
		table_1.setBackground(new Color(255, 204, 102));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table_1.setBounds(376, 142, 821, 467);
		frame.getContentPane().add(table_1);
		
		JLabel lblNewLabel_9 = new JLabel("Gestion des Bon Livraison");
		lblNewLabel_9.setForeground(Color.MAGENTA);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel_9.setBounds(436, 34, 377, 44);
		frame.getContentPane().add(lblNewLabel_9);
		
		JButton add_bn = new JButton("Ajouter");
		add_bn.setIcon(new ImageIcon("C:\\Users\\houssem\\Downloads\\shopping-cart.png"));
		add_bn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//***************** ajout ******************
				String code = tfcode.getText();
				String idbon = tfidbon.getText();
				
				String datebon= tfdatebon.getText();
				String daterecp=tfdaterecp.getText();
				
				String adresseRecp=tfadresserecp.getText();
				String numCommande= tfnumcommande.getText();
				
				
				String idFactureFournisseur=tfidfacturefournisseur.getText();
			
				
				String msg = "";
				boolean verif = true;
				
				if(code.isEmpty())
				{
					tfcode.setForeground(Color.RED);
					verif = false;
				}
				if(idbon.isEmpty())
				{
					tfidbon.setForeground(Color.RED);
					verif = false;
				}
			
				if(datebon.isEmpty())
				{
					tfdatebon.setForeground(Color.RED);
					verif = false;
				}
				if(daterecp.isEmpty())
				{
					tfdaterecp.setForeground(Color.RED);
					verif = false;
				}
				if(adresseRecp.isEmpty())
				{
					tfadresserecp.setForeground(Color.RED);
					verif = false;
				}
				if(numCommande.isEmpty())
				{
					tfnumcommande.setForeground(Color.RED);
					verif = false;
				}
				
				if(idFactureFournisseur.isEmpty())
				{
					tfidfacturefournisseur.setForeground(Color.RED);
					verif = false;
				}
			
		
				
				
				// à completer..
				
				if(!verif)
				{
					JOptionPane.showMessageDialog(null, "Vérifier les valeurs saisies!");
					return;
				}
			
			int numCommandee=Integer.parseInt(numCommande);
		
			int idFactureFournisseure=Integer.parseInt(idFactureFournisseur);
	
			 BonLivraison Bonrecp = new BonLivraison(code,datebon,daterecp,adresseRecp,numCommandee,idFactureFournisseure);
				
				 try {
						if( Bonrecp.ajouterBonLivraison())
							JOptionPane.showMessageDialog(null, "BonLivraison ajouté avec succès.");
					} catch (HeadlessException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				
				
			}
				
				
			
		});
		add_bn.setBounds(12, 527, 123, 86);
		frame.getContentPane().add(add_bn);
		
		JButton edite_bn = new JButton("Modifier");
		edite_bn.setIcon(new ImageIcon("C:\\Users\\houssem\\Downloads\\gear.png"));
		edite_bn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//*************** Modifier *******************
				String code = tfcode.getText();
				String idbon = tfidbon.getText();
				
				String datebon= tfdatebon.getText();
				String daterecp=tfdaterecp.getText();
				
				String adresseRecp=tfadresserecp.getText();
				String numCommande= tfnumcommande.getText();
				
				
				String idFactureFournisseur=tfidfacturefournisseur.getText();
			
				
				String msg = "";
				boolean verif = true;
				
				if(code.isEmpty())
				{
					tfcode.setForeground(Color.RED);
					verif = false;
				}
				if(idbon.isEmpty())
				{
					tfidbon.setForeground(Color.RED);
					verif = false;
				}
				
				if(datebon.isEmpty())
				{
					tfdatebon.setForeground(Color.RED);
					verif = false;
				}
				if(daterecp.isEmpty())
				{
					tfdaterecp.setForeground(Color.RED);
					verif = false;
				}
				if(adresseRecp.isEmpty())
				{
					tfadresserecp.setForeground(Color.RED);
					verif = false;
				}
				if(numCommande.isEmpty())
				{
					tfnumcommande.setForeground(Color.RED);
					verif = false;
				}
				
				if(idFactureFournisseur.isEmpty())
				{
					tfidfacturefournisseur.setForeground(Color.RED);
					verif = false;
				}
			
		
				
				
				// à completer..
				
				if(!verif)
				{
					JOptionPane.showMessageDialog(null, "Vérifier les valeurs saisies!");
					return;
				}
			
			int numCommandee=Integer.parseInt(numCommande);
			
			int idFactureFournisseure=Integer.parseInt(idFactureFournisseur);
			int id= Integer.parseInt(idbon);
			
	
	
			 BonLivraison Bonrecp = new BonLivraison(code,datebon,daterecp,adresseRecp,numCommandee,idFactureFournisseure);
				
				 try {
						if( Bonrecp.editeBonLivraison(id))
							JOptionPane.showMessageDialog(null, "BonLivraison Modifier avec succès.");
					} catch (HeadlessException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		
	});
		edite_bn.setBounds(147, 527, 108, 81);
		frame.getContentPane().add(edite_bn);
		
		JButton delete_bn = new JButton("Supprimer");
		delete_bn.setIcon(new ImageIcon("C:\\Users\\houssem\\Downloads\\delete.png"));
		delete_bn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//*************supprimer****************
				
				String idp=tfidbon.getText();
				if(idp.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "selectionner un Bon Livraison !!");
					
				}else {
					int idd= Integer.parseInt(tfidbon.getText());
					BonLivraison bnrec=new BonLivraison();
					try {
						if(bnrec.deleteBonLivraison(idd))
							JOptionPane.showMessageDialog(null, "Bon Livraison  supprimer avec succès.");
					} catch (HeadlessException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		});
		delete_bn.setBounds(267, 532, 97, 76);
		frame.getContentPane().add(delete_bn);
		
		JButton show_bn = new JButton("Actualiser");
		show_bn.setIcon(new ImageIcon("C:\\Users\\houssem\\Downloads\\refresh.png"));
		show_bn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String req= "SELECT * FROM `bonlivraison` ";
				ResultSet rs = null;
				try {
					rs = DataBaseConnection.executionQuery(req);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					table_1.setModel(DbUtils.resultSetToTableModel(rs));
					while(rs.next())
					{
						table_1.setModel(DbUtils.resultSetToTableModel(rs));
					
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
			}
		});
		show_bn.setBounds(1081, 75, 116, 39);
		frame.getContentPane().add(show_bn);
		
		JButton addligne = new JButton("Gestion ligne de bon");
		addligne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent elg) {
				String idbon=tfidbon.getText();
				if(idbon.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "selectionner un bon !!");
				}else {
		          try {
					LigneBonLivraisons lbl = new LigneBonLivraisons();
				    lbl.frame.setVisible(true);
					
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		          
				}
				
			}
				
			
		});
		addligne.setBounds(1044, 611, 153, 39);
		frame.getContentPane().add(addligne);
		
		JButton ajoutlignebon_bn = new JButton("Affiche ligne de bon");
		ajoutlignebon_bn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent elb) {
				String idbon=tfidbon.getText();
				if(idbon.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "selectionner un bon !!");
				}else {
			
				DetailsBonLivraison dbl;
				try {
					dbl = new DetailsBonLivraison();
					dbl.frame.setVisible(true);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			}
		});
		ajoutlignebon_bn.setBounds(914, 75, 155, 39);
		frame.getContentPane().add(ajoutlignebon_bn);
	}
}
