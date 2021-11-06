package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Statement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.Choice;
import javax.swing.table.DefaultTableModel;

import database.DataBaseConnection;
import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import database.DataBaseConnection;
import model.CompteBancaire;
import model.FamilleProduit;
import model.GlobalVariables;
import model.Produit;
import net.proteanit.sql.DbUtils;

import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

public class AfficheProduit {

	JFrame frame;
	private JTable table;
	private JTable Table;
	private JTextField textFieldID;
	private JTextField tfreference;
	private JTextField tfdesignation;
	private JTextField tfunitemesure;
	private JTextField tfstock;
	private JTextField tfstockmin;
	private JTextField tfprix;
	private JTextField tftva;
	private JTextField search;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AfficheProduit window = new AfficheProduit();
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
	public AfficheProduit() throws ClassNotFoundException, SQLException {
		DataBaseConnection.connecter();
		initialize();
		Selected("alimentaire");
		
	}
	 String tab[] = new String[100];
	 int i=0;
	private String[] listeFamilleProduit() 
	{
		Statement stmt;
		try {
			stmt = (Statement) DataBaseConnection.connection.createStatement();
			String SQL ="SELECT DISTINCT designationFamille from familleproduit ";
			ResultSet result=stmt.executeQuery(SQL);
			
			while(result.next()) {
				tab[i]=result.getString(1);
				i++;
				}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return tab;
	}
	
	String fourid="";
	private String Selectedfour(String codeff) {
		
		 Statement stmt;
		try {
			stmt = (Statement) DataBaseConnection.connection.createStatement();
			String sql ="SELECT id_fournisseur from fournisseur where codeFournisseur='"+codeff+"'";
			ResultSet result=stmt.executeQuery(sql);
			 String fam;
			while(result.next()) {
				
				
				fourid=result.getString("id_fournisseur");
				
				
				System.out.println(famillep);
			}

		}catch (Exception e) {
			e.printStackTrace();
		}
		return fourid;
		

	}
	
	
	String famillep="";
	private String Selected(String famdig) {
		
		 Statement stmt;
		try {
			stmt = (Statement) DataBaseConnection.connection.createStatement();
			String sql ="SELECT id_familleProduit from familleproduit where designationFamille='"+famdig+"'";
			ResultSet result=stmt.executeQuery(sql);
			 String fam;
			while(result.next()) {
				
				
				famillep=result.getString("id_familleProduit");
				String familleProduit=famillep;
				
				System.out.println(famillep);
			}

		}catch (Exception e) {
			e.printStackTrace();
		}
		return famillep;
		

	}
	
	
	String tb[] = new String[100];
	 int j=0;
	private String[] listeFournisseurr() 
	{
		Statement stmt;
		try {
			stmt = (Statement) DataBaseConnection.connection.createStatement();
			String SQL ="SELECT DISTINCT codeFournisseur from fournisseur ";
			ResultSet result=stmt.executeQuery(SQL);
			
			while(result.next()) {
				tb[j]=result.getString(1);
				j++;
				}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return tb;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void affichertableau(String term,String by) 
	{
		Statement stmt;
		try {
			stmt = (Statement) DataBaseConnection.connection.createStatement();
			String ref="where "+by+"='"+term+"'";
			if(search.getText().isEmpty()) {
			ResultSet result=stmt.executeQuery("SELECT * FROM produit ");
			Table.setModel(DbUtils.resultSetToTableModel(result));

			}
			else{
				ResultSet result=stmt.executeQuery("SELECT * FROM produit "+ref+"");
				Table.setModel(DbUtils.resultSetToTableModel(result));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1099, 681);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gestion Des Produits");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(332, 24, 190, 16);
		frame.getContentPane().add(lblNewLabel);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		table.setBackground(new Color(255, 204, 0));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"idProduit", "reference", "designation", "unite Mesure", "Fournisseur", "Famille Produit", "Stock", "Stock min", "Prix","TVA"},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		JComboBox combofournisseur = new JComboBox(listeFournisseurr());
		JComboBox combofamille = new JComboBox(listeFamilleProduit());
		table.setBounds(33, 90, 891, 22);
		frame.getContentPane().add(table);
		Table = new JTable();
		Table.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		Table.setBackground(new Color(204, 255, 204));
		Table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				DefaultTableModel model= (DefaultTableModel)Table.getModel();
				int selectedRowIndex = Table.getSelectedRow();
				
				textFieldID.setText(model.getValueAt(selectedRowIndex, 0).toString());
				tfreference.setText(model.getValueAt(selectedRowIndex, 1).toString());
				tfdesignation.setText(model.getValueAt(selectedRowIndex, 2).toString());
				tfunitemesure.setText(model.getValueAt(selectedRowIndex, 3).toString());
				combofournisseur.setSelectedItem(model.getValueAt(selectedRowIndex, 4).toString());
				combofamille.setSelectedItem(model.getValueAt(selectedRowIndex, 5).toString());
				tfstock.setText(model.getValueAt(selectedRowIndex, 6).toString());
				tfstockmin.setText(model.getValueAt(selectedRowIndex, 7).toString());
				tfprix.setText(model.getValueAt(selectedRowIndex, 8).toString());
				tftva.setText(model.getValueAt(selectedRowIndex, 9).toString());
				
				
			}
		});
		Table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		Table.setBounds(33, 115, 891, 246);
		frame.getContentPane().add(Table);
		
		
		JButton back_bn = new JButton("back");
		back_bn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		back_bn.setBounds(33, 24, 125, 45);
		frame.getContentPane().add(back_bn);
		
		combofamille.setBounds(562, 397, 103, 22);
		frame.getContentPane().add(combofamille);
		
		JButton add_bn = new JButton("ajouter");
		add_bn.setIcon(new ImageIcon("C:\\Users\\houssem\\Downloads\\plus.png"));
		add_bn.setBackground(new Color(204, 255, 153));
		add_bn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//***********ajout********************
				
				String idp= textFieldID.getText();
				String reference = tfreference.getText();
				String designation = tfdesignation.getText();
				String uniteMesure = tfunitemesure.getText();
				String fournisseur =  Selectedfour(combofournisseur.getSelectedItem().toString());
				String familleProduit =Selected(combofamille.getSelectedItem().toString());
				
				String stockk= tfstock.getText();
				String stockminn= tfstockmin.getText();
				String prixx= tfprix.getText();
				String tvaa=tftva.getText();
				boolean verif = true;
				if(reference.isEmpty())
				{
					tfreference.setForeground(Color.RED);
					verif = false;
				}
				if(designation.isEmpty())
				{
					tfdesignation.setForeground(Color.RED);
					verif = false;
				}
				if(uniteMesure.isEmpty())
				{
					tfunitemesure.setForeground(Color.RED);
					verif = false;
				}
				
				if(idp.isEmpty())
				{
					textFieldID.setForeground(Color.RED);
					verif = false;
				}
				if(stockk.isEmpty())
				{
					tfstock.setForeground(Color.RED);
					verif = false;
				}
				if(stockminn.isEmpty())
				{
					tfstockmin.setForeground(Color.RED);
					verif = false;
				}
				if(prixx.isEmpty())
				{
					tfprix.setForeground(Color.RED);
					verif = false;
				}
				if(tvaa.isEmpty())
				{
					tftva.setForeground(Color.RED);
					verif = false;
				}
				
		 	// à completer..
				
				if(!verif)
				{
					JOptionPane.showMessageDialog(null, "Vérifier les valeurs saisies!");
					return;
				}
				
				int stock = Integer.parseInt(tfstock.getText());
				int stockMinimale = Integer.parseInt(tfstockmin.getText());
				int prixUnitaireHTaxe = Integer.parseInt(tfprix.getText());
				double tva = Double.parseDouble(tftva.getText());
				
				Produit newProduit = new Produit(reference, designation, 
						uniteMesure, fournisseur,familleProduit, stock,stockMinimale,
						prixUnitaireHTaxe, tva);
				
					try {
						if(newProduit.ajouterProduit())
							JOptionPane.showMessageDialog(null, "Produit ajouté avec succès.");
					} catch (HeadlessException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				
			}
		});
		add_bn.setBounds(944, 200, 125, 45);
		frame.getContentPane().add(add_bn);
		
		textFieldID = new JTextField();
		textFieldID.setBounds(198, 392, 116, 22);
		frame.getContentPane().add(textFieldID);
		textFieldID.setColumns(10);
		
		
		
		JButton update_bn = new JButton("modifier");
		update_bn.setIcon(new ImageIcon("C:\\Users\\houssem\\Downloads\\gear.png"));
		update_bn.setBackground(new Color(255, 204, 102));
		update_bn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent em1) {
				
				//*************** modifier******************
				
				String idp=textFieldID.getText();
				String reference = tfreference.getText();
				String designation = tfdesignation.getText();
				String uniteMesure = tfunitemesure.getText();
				String fournisseur = Selectedfour(combofournisseur.getSelectedItem().toString());
			  
			 
				 
				String familleProduit=Selected(combofamille.getSelectedItem().toString());
			    String stockk= tfstock.getText();
			    String stockminn= tfstockmin.getText();
			    String prixx= tfprix.getText();
			    String tvaa=tftva.getText();
			    boolean verif = true;
				if(reference.isEmpty())
				{
					tfreference.setForeground(Color.RED);
					verif = false;
				}
				if(designation.isEmpty())
				{
					tfdesignation.setForeground(Color.RED);
					verif = false;
				}
				if(uniteMesure.isEmpty())
				{
					tfunitemesure.setForeground(Color.RED);
					verif = false;
				}
			
				
				if(idp.isEmpty())
				{
					textFieldID.setForeground(Color.RED);
					verif = false;
				}
				if(stockk.isEmpty())
				{
					tfstock.setForeground(Color.RED);
					verif = false;
				}
				if(stockminn.isEmpty())
				{
					tfstockmin.setForeground(Color.RED);
					verif = false;
				}
				if(prixx.isEmpty())
				{
					tfprix.setForeground(Color.RED);
					verif = false;
				}
				if(tvaa.isEmpty())
				{
					tftva.setForeground(Color.RED);
					verif = false;
				}
				
				
			
		
				
				
				// à completer..
				
				if(!verif)
				{
					JOptionPane.showMessageDialog(null, "Vérifier les valeurs saisies!");
					return;
				}
				int id=Integer.parseInt(textFieldID.getText());
				int stock = Integer.parseInt(tfstock.getText());
				int stockMinimale = Integer.parseInt(tfstockmin.getText());
				int prixUnitaireHTaxe = Integer.parseInt(tfprix.getText()); 
				double tva = Double.parseDouble(tftva.getText());
				
				Produit newProduit = new Produit(reference, designation, 
						uniteMesure, fournisseur,familleProduit, stock,stockMinimale,
						prixUnitaireHTaxe, tva);
				try {
					if(newProduit.editeProduit(id))
						JOptionPane.showMessageDialog(null, "Produit modifier avec succès.");
				} catch (HeadlessException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		update_bn.setBounds(943, 258, 126, 45);
		frame.getContentPane().add(update_bn);
		
		JButton delete_bn = new JButton("Supprimer");
		delete_bn.setIcon(new ImageIcon("C:\\Users\\houssem\\Downloads\\delete.png"));
		delete_bn.setBackground(new Color(255, 153, 153));
		delete_bn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//*********** supprimer *************
				String idp=textFieldID.getText();
				if(idp.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "selectionner un produit !!");
					
				}else {
					int idd= Integer.parseInt(textFieldID.getText());
					Produit delprod=new Produit();
					try {
						if(delprod.deleteProduit(idd))
							JOptionPane.showMessageDialog(null, "Produit supprimer avec succès.");
					} catch (HeadlessException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		delete_bn.setBounds(944, 316, 125, 45);
		frame.getContentPane().add(delete_bn);
		
		JLabel lblNewLabel_1 = new JLabel("IDProduit");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_1.setBounds(56, 392, 80, 22);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Reference");
		lblNewLabel_2.setBounds(56, 443, 80, 19);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Designation");
		lblNewLabel_3.setBounds(56, 499, 80, 19);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Unite Mesure");
		lblNewLabel_4.setBounds(56, 541, 80, 19);
		frame.getContentPane().add(lblNewLabel_4);
		
		tfreference = new JTextField();
		tfreference.setBounds(198, 440, 116, 22);
		frame.getContentPane().add(tfreference);
		tfreference.setColumns(10);
		
		tfdesignation = new JTextField();
		tfdesignation.setBounds(198, 496, 116, 22);
		frame.getContentPane().add(tfdesignation);
		tfdesignation.setColumns(10);
		
		tfunitemesure = new JTextField();
		tfunitemesure.setBounds(198, 538, 116, 22);
		frame.getContentPane().add(tfunitemesure);
		tfunitemesure.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Fournisseur");
		lblNewLabel_5.setBounds(56, 592, 80, 16);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Famille Produit");
		lblNewLabel_6.setBounds(446, 400, 104, 16);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Stock");
		lblNewLabel_7.setBounds(446, 453, 56, 16);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Stock min");
		lblNewLabel_8.setBounds(446, 499, 56, 16);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Prix");
		lblNewLabel_9.setBounds(446, 544, 56, 16);
		frame.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("TVA");
		lblNewLabel_10.setBounds(446, 592, 56, 16);
		frame.getContentPane().add(lblNewLabel_10);
		
		tfstock = new JTextField();
		tfstock.setBounds(562, 452, 116, 22);
		frame.getContentPane().add(tfstock);
		tfstock.setColumns(10);
		
		tfstockmin = new JTextField();
		tfstockmin.setBounds(562, 496, 116, 22);
		frame.getContentPane().add(tfstockmin);
		tfstockmin.setColumns(10);
		
		tfprix = new JTextField();
		tfprix.setBounds(562, 541, 116, 22);
		frame.getContentPane().add(tfprix);
		tfprix.setColumns(10);
		
		tftva = new JTextField();
		tftva.setBounds(562, 589, 116, 22);
		frame.getContentPane().add(tftva);
		tftva.setColumns(10);
		
		JButton show_bn = new JButton("Actualiser");
		show_bn.setIcon(new ImageIcon("C:\\Users\\houssem\\Downloads\\refresh.png"));
		show_bn.setBackground(new Color(153, 204, 204));
		show_bn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String req= "SELECT * FROM `produit` ";
				ResultSet rs = null;
				try {
					rs = DataBaseConnection.executionQuery(req);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					Table.setModel(DbUtils.resultSetToTableModel(rs));
					while(rs.next())
					{
						Table.setModel(DbUtils.resultSetToTableModel(rs));
					
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
			}
		});
		show_bn.setBounds(944, 149, 125, 38);
		frame.getContentPane().add(show_bn);
		
		JButton addfamille_bn = new JButton("Admet une famille");
		addfamille_bn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//************ aadd famille****************
				String idprod= textFieldID.getText();
				
				if(idprod.isEmpty()) {
					JOptionPane.showMessageDialog(null, "selectionner un produit !!");
				}else {
					String codeFamille=JOptionPane.showInputDialog("donner le code Famille :");
					String designationFamille=JOptionPane.showInputDialog("donner designation Famille :");
				int codefam= Integer.parseInt(codeFamille);
				FamilleProduit famprod=new FamilleProduit(codefam,designationFamille);
				 try {
					if( famprod.ajouterFamilleProduit())
							JOptionPane.showMessageDialog(null, "la famille de produit ajouté avec succès.");
					} catch (HeadlessException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				 String req= "SELECT MAX(id_familleProduit) FROM `familleproduit`";
				 ResultSet rs = null;
				try {
					rs = DataBaseConnection.executionQuery(req);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				 try {
					if(rs.next()) {
						int idp=Integer.parseInt(idprod);
						 int idFamilleproduit=rs.getInt(1);
						 try {
							   String req1= "UPDATE `produit` SET `famille_produit`='"+idFamilleproduit+"' WHERE id_produit="+idp+"";
						       DataBaseConnection.executionUpdate(req1);
									
							} catch (HeadlessException | SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
					 }
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			}	
				
			
		});
		addfamille_bn.setBounds(884, 449, 173, 81);
		frame.getContentPane().add(addfamille_bn);
		
		JButton addup_bn = new JButton("Admet/modifier Fournisseur");
		addup_bn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//*********** addmet fournisseur **********
				String idprod= textFieldID.getText();
				if(idprod.isEmpty()) {
					JOptionPane.showMessageDialog(null, "selectionner un produit !!");
					}else {
						int idp=Integer.parseInt(idprod);
				String codeFournisseur=JOptionPane.showInputDialog("donner le code de fournisseur :");
				 String req= "SELECT id_fournisseur FROM `fournisseur` where codeFournisseur="+codeFournisseur+"";
				 ResultSet rs = null;
				try {
					rs = DataBaseConnection.executionQuery(req);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				 try {
					if(rs.next()) {
						 int idFournisseur=rs.getInt(1);
						 try {
							   String req1= "UPDATE `produit` SET `Fournisseur`='"+idFournisseur+"' WHERE id_produit="+idp+"";
						       DataBaseConnection.executionUpdate(req1);
									
							} catch (HeadlessException | SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
					 }
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
				
				
			}
		  
		});
		addup_bn.setBounds(854, 538, 203, 70);
		frame.getContentPane().add(addup_bn);
		
		
		String[] test = {"reference","designation","prix"};
		JComboBox comboprod = new JComboBox(test);
		
		JButton search_bn = new JButton("chercher");
		search_bn.setIcon(new ImageIcon("C:\\Users\\houssem\\Downloads\\search.png"));
		search_bn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				affichertableau(search.getText(),comboprod.getSelectedItem().toString());
			}
		});
		search_bn.setBounds(795, 63, 125, 25);
		frame.getContentPane().add(search_bn);
		
		

		comboprod.setBounds(663, 64, 120, 22);
		frame.getContentPane().add(comboprod);
		
		search = new JTextField();
		search.setBounds(488, 63, 163, 25);
		frame.getContentPane().add(search);
		search.setColumns(10);
		Statement stmt;
		try {
			stmt = (Statement) DataBaseConnection.connection.createStatement();
			String SQL ="SELECT DISTINCT designationFamille from familleproduit ";
			ResultSet result=stmt.executeQuery(SQL);
			 String tab[] = new String[100];
			while(result.next()) {
				
				
				System.out.println(tab[0]);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		 
		
		
	
		combofournisseur.setBounds(210, 589, 104, 22);
		frame.getContentPane().add(combofournisseur);
		
		
		
	}
}
