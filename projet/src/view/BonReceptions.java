package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import database.DataBaseConnection;
import model.BonReception;
import model.Fournisseur;
import model.LigneBonReception;
import model.Produit;
import net.proteanit.sql.DbUtils;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class BonReceptions {

	public JFrame frame;
	private JTable table;
	static  JTextField tfidbon;
	private JTextField tfcode;
	private JTextField tfidfournisseur;
	private JTextField tfdatebon;
	private JTextField tfdaterecp;
	private JTextField tfadresserecp;
	private JTextField tfnumcommande;
	private JTextField tfidlignebonreception;
	private JTextField tfidfacturefournisseur;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BonReceptions window = new BonReceptions();
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
	public BonReceptions() throws ClassNotFoundException, SQLException {
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
				{"idBonRecept", "code", "idFournisseur", "dateBon", "dateReception", "adresseRecep", "numCommande", "idLigneBonRecp", "idFacture"},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
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
		
		JLabel lblNewLabel_2 = new JLabel("idFournisseur");
		lblNewLabel_2.setBounds(28, 206, 93, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("dateBon");
		lblNewLabel_3.setBounds(28, 250, 56, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("dateReception");
		lblNewLabel_4.setBounds(28, 298, 93, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("adresseRecp");
		lblNewLabel_5.setBounds(28, 350, 93, 16);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("numCommande");
		lblNewLabel_6.setBounds(28, 398, 93, 16);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("idLigneBonRecp");
		lblNewLabel_7.setBounds(28, 447, 93, 16);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("idFactureFournisseur");
		lblNewLabel_8.setBounds(28, 488, 129, 16);
		frame.getContentPane().add(lblNewLabel_8);
		
		tfidbon = new JTextField();
		tfidbon.setBounds(169, 107, 116, 22);
		frame.getContentPane().add(tfidbon);
		tfidbon.setColumns(10);
		
		tfcode = new JTextField();
		tfcode.setBounds(169, 153, 116, 22);
		frame.getContentPane().add(tfcode);
		tfcode.setColumns(10);
		
		tfidfournisseur = new JTextField();
		tfidfournisseur.setBounds(169, 203, 116, 22);
		frame.getContentPane().add(tfidfournisseur);
		tfidfournisseur.setColumns(10);
		
		tfdatebon = new JTextField();
		tfdatebon.setBounds(169, 247, 116, 22);
		frame.getContentPane().add(tfdatebon);
		tfdatebon.setColumns(10);
		
		tfdaterecp = new JTextField();
		tfdaterecp.setBounds(169, 295, 116, 22);
		frame.getContentPane().add(tfdaterecp);
		tfdaterecp.setColumns(10);
		
		tfadresserecp = new JTextField();
		tfadresserecp.setBounds(169, 347, 116, 22);
		frame.getContentPane().add(tfadresserecp);
		tfadresserecp.setColumns(10);
		
		tfnumcommande = new JTextField();
		tfnumcommande.setBounds(169, 395, 116, 22);
		frame.getContentPane().add(tfnumcommande);
		tfnumcommande.setColumns(10);
		
		tfidlignebonreception = new JTextField();
		tfidlignebonreception.setBounds(169, 444, 116, 22);
		frame.getContentPane().add(tfidlignebonreception);
		tfidlignebonreception.setColumns(10);
		
		tfidfacturefournisseur = new JTextField();
		tfidfacturefournisseur.setBounds(169, 485, 116, 22);
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
				tfidfournisseur.setText(model.getValueAt(selectedRowIndex, 2).toString());
				tfdatebon.setText(model.getValueAt(selectedRowIndex, 3).toString());
				tfdaterecp.setText(model.getValueAt(selectedRowIndex, 4).toString());
				tfadresserecp.setText(model.getValueAt(selectedRowIndex, 5).toString());
				tfnumcommande.setText(model.getValueAt(selectedRowIndex, 6).toString());
				tfidlignebonreception.setText(model.getValueAt(selectedRowIndex, 7).toString());
				tfidfacturefournisseur.setText(model.getValueAt(selectedRowIndex, 8).toString());
				
				
				
				
			}
		});
		table_1.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, null, null, null));
		table_1.setBackground(new Color(255, 204, 102));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table_1.setBounds(376, 141, 821, 467);
		frame.getContentPane().add(table_1);
		
		JLabel lblNewLabel_9 = new JLabel("Gestion des Bon Reception");
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
				String  idFournisseur = tfidfournisseur.getText();
				String datebon= tfdatebon.getText();
				String daterecp=tfdaterecp.getText();
				
				String adresseRecp=tfadresserecp.getText();
				String numCommande= tfnumcommande.getText();
				String idLigneBonReception=tfidlignebonreception.getText();
				
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
				if(idFournisseur.isEmpty())
				{
					tfidfournisseur.setForeground(Color.RED);
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
				if(idLigneBonReception.isEmpty())
				{
					tfidlignebonreception.setForeground(Color.RED);
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
			int IdFournisseur= Integer.parseInt(idFournisseur);
			int numCommandee=Integer.parseInt(numCommande);
			int idLigneBonReceptione=Integer.parseInt(idLigneBonReception);
			int idFactureFournisseure=Integer.parseInt(idFactureFournisseur);
	
			 BonReception Bonrecp = new BonReception(code,IdFournisseur,datebon,daterecp,adresseRecp,numCommandee,idLigneBonReceptione,idFactureFournisseure);
				
				 try {
						if( Bonrecp.ajouterBonReception())
							JOptionPane.showMessageDialog(null, "BonReception ajouté avec succès.");
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
				String  idFournisseur = tfidfournisseur.getText();
				String datebon= tfdatebon.getText();
				String daterecp=tfdaterecp.getText();
				
				String adresseRecp=tfadresserecp.getText();
				String numCommande= tfnumcommande.getText();
				String idLigneBonReception=tfidlignebonreception.getText();
				
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
				if(idFournisseur.isEmpty())
				{
					tfidfournisseur.setForeground(Color.RED);
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
				if(idLigneBonReception.isEmpty())
				{
					tfidlignebonreception.setForeground(Color.RED);
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
			int IdFournisseur= Integer.parseInt(idFournisseur);
			int numCommandee=Integer.parseInt(numCommande);
			int idLigneBonReceptione=Integer.parseInt(idLigneBonReception);
			int idFactureFournisseure=Integer.parseInt(idFactureFournisseur);
			int id= Integer.parseInt(idbon);
			
	
	
			 BonReception Bonrecp = new BonReception(code,IdFournisseur,datebon,daterecp,adresseRecp,numCommandee,idLigneBonReceptione,idFactureFournisseure);
				
				 try {
						if( Bonrecp.editeBonReception(id))
							JOptionPane.showMessageDialog(null, "BonReception Modifier avec succès.");
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
					JOptionPane.showMessageDialog(null, "selectionner un Bon Reception !!");
					
				}else {
					int idd= Integer.parseInt(tfidbon.getText());
					BonReception bnrec=new BonReception();
					try {
						if(bnrec.deleteBonReception(idd))
							JOptionPane.showMessageDialog(null, "Bon Reception  supprimer avec succès.");
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
				String req= "SELECT * FROM `bonreception` ";
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
					LigneBonReceptions lbr = new LigneBonReceptions();
				    lbr.frame.setVisible(true);
					
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
				}
			
				try {
					DetailsBon dbl=new DetailsBon();
					dbl.frame.setVisible(true);
					
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		ajoutlignebon_bn.setBounds(914, 75, 155, 39);
		frame.getContentPane().add(ajoutlignebon_bn);
	}
}
