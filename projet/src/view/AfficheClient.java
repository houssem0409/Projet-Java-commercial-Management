package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Statement;

import database.DataBaseConnection;
import model.Client;
import model.CompteBancaire;
import model.GlobalVariables;
import model.Produit;
import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

public class AfficheClient {

	public JFrame frame;
	private JTable table;
	private JTable table_1;
	private JTextField textFieldID;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JTextField tfcodeclient;
	private JTextField tfmatriculefiscale;
	private JTextField tfraisonsociale;
	private JTextField tftype;
	private JTextField tfadresse;
	private JTextField tftelfix;
	private JTextField tftelmobil;
	private JTextField tffax;
	private JTextField tfemail;
	private JTextField tfwebsite;
	private JTextField tfetatfiscale;
	private JTextField tfidproduit;
	private JLabel lblNewLabel_13;
	private JTextField tfidcomptebnq;
	private JButton comptebnq_bn;
	private JTextField search;
	private JButton btnNewButton;
	private JComboBox combo_client;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AfficheClient window = new AfficheClient();
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
	public AfficheClient() throws ClassNotFoundException, SQLException {
		DataBaseConnection.connecter();
		initialize();
	}

	private void affichertableau(String term,String by) 
	{
		Statement stmt;
		try {
			stmt = (Statement) DataBaseConnection.connection.createStatement();
			String ref="where "+by+"='"+term+"'";
			if(search.getText().isEmpty()) {
			ResultSet result=stmt.executeQuery("SELECT * FROM client ");
			table_1.setModel(DbUtils.resultSetToTableModel(result));

			}
			else{
				ResultSet result=stmt.executeQuery("SELECT * FROM client "+ref+"");
				table_1.setModel(DbUtils.resultSetToTableModel(result));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1128, 632);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblListeDesClients = new JLabel("Gestion Des Clients ");
		lblListeDesClients.setForeground(Color.BLUE);
		lblListeDesClients.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblListeDesClients.setBounds(391, 27, 330, 41);
		frame.getContentPane().add(lblListeDesClients);
		
		table = new JTable();
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		table.setBackground(new Color(153, 255, 153));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"idClient", "Code Client", "MatriculFiscale", "RaisonSocial", "Type", "adresse", "tel fix", "tel Mobil", "Fax", "Email", "WebSite", "Etat Fiscale", "idProduit", "idComptebnq"},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table.setBounds(12, 94, 940, 16);
		frame.getContentPane().add(table);
		
		table_1 = new JTable();
		table_1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		table_1.setBackground(new Color(255, 255, 153));
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DefaultTableModel model= (DefaultTableModel)table_1.getModel();
				int selectedRowIndex = table_1.getSelectedRow();
				
				textFieldID.setText(model.getValueAt(selectedRowIndex, 0).toString());
				tfcodeclient.setText(model.getValueAt(selectedRowIndex, 1).toString());
				tfmatriculefiscale.setText(model.getValueAt(selectedRowIndex, 2).toString());
				tfraisonsociale.setText(model.getValueAt(selectedRowIndex, 3).toString());
				tftype.setText(model.getValueAt(selectedRowIndex, 4).toString());
				tfadresse.setText(model.getValueAt(selectedRowIndex, 5).toString());
				tftelfix.setText(model.getValueAt(selectedRowIndex, 6).toString());
				tftelmobil.setText(model.getValueAt(selectedRowIndex, 7).toString());
				tffax.setText(model.getValueAt(selectedRowIndex, 8).toString());
				tfemail.setText(model.getValueAt(selectedRowIndex, 9).toString());
				tfwebsite.setText(model.getValueAt(selectedRowIndex, 10).toString());
				tfetatfiscale.setText(model.getValueAt(selectedRowIndex, 11).toString());
				tfidproduit.setText(model.getValueAt(selectedRowIndex, 12).toString());
				tfidcomptebnq.setText(model.getValueAt(selectedRowIndex, 13).toString());
				
				
			}
		});
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table_1.setBounds(12, 111, 940, 251);
		frame.getContentPane().add(table_1);
		
		JButton back_bn = new JButton("Back");
		back_bn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		back_bn.setBounds(35, 18, 102, 36);
		frame.getContentPane().add(back_bn);
		
		JButton affiche_bn = new JButton("Afficher");
		affiche_bn.setIcon(new ImageIcon("C:\\Users\\houssem\\Downloads\\refresh.png"));
		affiche_bn.setBackground(new Color(204, 255, 204));
		affiche_bn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				///********************afficher tous clients****************
				String req= "SELECT * FROM `client` ";
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
		affiche_bn.setBounds(966, 128, 120, 53);
		frame.getContentPane().add(affiche_bn);
		
		
			
			textFieldID = new JTextField();
			textFieldID.setBounds(207, 385, 116, 22);
			frame.getContentPane().add(textFieldID);
			textFieldID.setColumns(10);
			
			lblNewLabel = new JLabel("idClient");
			lblNewLabel.setForeground(new Color(204, 0, 0));
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
			lblNewLabel.setBounds(58, 388, 116, 16);
			frame.getContentPane().add(lblNewLabel);
			
			lblNewLabel_1 = new JLabel("Code Client");
			lblNewLabel_1.setBounds(58, 429, 116, 16);
			frame.getContentPane().add(lblNewLabel_1);
			
			lblNewLabel_2 = new JLabel("Matricule Fiscale");
			lblNewLabel_2.setBounds(58, 468, 116, 16);
			frame.getContentPane().add(lblNewLabel_2);
			
			lblNewLabel_3 = new JLabel("Raison Sociale");
			lblNewLabel_3.setBounds(58, 501, 116, 16);
			frame.getContentPane().add(lblNewLabel_3);
			
			lblNewLabel_4 = new JLabel("Type");
			lblNewLabel_4.setBounds(58, 535, 116, 16);
			frame.getContentPane().add(lblNewLabel_4);
			
			lblNewLabel_5 = new JLabel("Adresse");
			lblNewLabel_5.setBounds(367, 388, 99, 16);
			frame.getContentPane().add(lblNewLabel_5);
			
			lblNewLabel_6 = new JLabel("tel Fix");
			lblNewLabel_6.setBounds(367, 429, 99, 16);
			frame.getContentPane().add(lblNewLabel_6);
			
			lblNewLabel_7 = new JLabel("tel Mobile");
			lblNewLabel_7.setBounds(367, 468, 99, 16);
			frame.getContentPane().add(lblNewLabel_7);
			
			lblNewLabel_8 = new JLabel("fax");
			lblNewLabel_8.setBounds(367, 511, 99, 16);
			frame.getContentPane().add(lblNewLabel_8);
			
			lblNewLabel_9 = new JLabel("Email");
			lblNewLabel_9.setBounds(367, 543, 99, 16);
			frame.getContentPane().add(lblNewLabel_9);
			
			lblNewLabel_10 = new JLabel("web site");
			lblNewLabel_10.setBounds(620, 391, 95, 16);
			frame.getContentPane().add(lblNewLabel_10);
			
			lblNewLabel_11 = new JLabel("Etat Fiscale");
			lblNewLabel_11.setBounds(620, 429, 95, 16);
			frame.getContentPane().add(lblNewLabel_11);
			
			lblNewLabel_12 = new JLabel("IdProduit");
			lblNewLabel_12.setBounds(620, 468, 95, 16);
			frame.getContentPane().add(lblNewLabel_12);
			
			tfcodeclient = new JTextField();
			tfcodeclient.setBounds(207, 426, 116, 22);
			frame.getContentPane().add(tfcodeclient);
			tfcodeclient.setColumns(10);
			
			tfmatriculefiscale = new JTextField();
			tfmatriculefiscale.setBounds(207, 465, 116, 22);
			frame.getContentPane().add(tfmatriculefiscale);
			tfmatriculefiscale.setColumns(10);
			
			tfraisonsociale = new JTextField();
			tfraisonsociale.setBounds(207, 498, 116, 22);
			frame.getContentPane().add(tfraisonsociale);
			tfraisonsociale.setColumns(10);
			
			tftype = new JTextField();
			tftype.setBounds(207, 537, 116, 22);
			frame.getContentPane().add(tftype);
			tftype.setColumns(10);
			
			tfadresse = new JTextField();
			tfadresse.setBounds(478, 385, 116, 22);
			frame.getContentPane().add(tfadresse);
			tfadresse.setColumns(10);
			
			tftelfix = new JTextField();
			tftelfix.setBounds(478, 426, 116, 22);
			frame.getContentPane().add(tftelfix);
			tftelfix.setColumns(10);
			
			tftelmobil = new JTextField();
			tftelmobil.setBounds(478, 465, 116, 22);
			frame.getContentPane().add(tftelmobil);
			tftelmobil.setColumns(10);
			
			tffax = new JTextField();
			tffax.setBounds(478, 508, 116, 22);
			frame.getContentPane().add(tffax);
			tffax.setColumns(10);
			
			tfemail = new JTextField();
			tfemail.setBounds(478, 543, 116, 22);
			frame.getContentPane().add(tfemail);
			tfemail.setColumns(10);
			
			tfwebsite = new JTextField();
			tfwebsite.setBounds(727, 385, 116, 22);
			frame.getContentPane().add(tfwebsite);
			tfwebsite.setColumns(10);
			
			tfetatfiscale = new JTextField();
			tfetatfiscale.setBounds(727, 426, 116, 22);
			frame.getContentPane().add(tfetatfiscale);
			tfetatfiscale.setColumns(10);
			
			tfidproduit = new JTextField();
			tfidproduit.setBounds(727, 465, 116, 22);
			frame.getContentPane().add(tfidproduit);
			tfidproduit.setColumns(10);
			
			JButton add_bn = new JButton("Ajouter");
			add_bn.setIcon(new ImageIcon("C:\\Users\\houssem\\Downloads\\plus.png"));
			add_bn.setBackground(new Color(153, 255, 102));
			add_bn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//**********ajout************************
					
					
					String codeClient= tfcodeclient.getText();
					String matriculeFiscale= tfmatriculefiscale.getText();
					String raisonSociale= tfraisonsociale.getText();
					String type = tftype.getText();
					String adresse= tfadresse.getText();
					String telephoneFixe= tftelfix.getText();
					String telephoneMobile=tftelmobil.getText();
					String fax=tffax.getText();
					
					String email= tfemail.getText();
					String website= tfwebsite.getText();
					String etatFiscale= tfetatfiscale.getText();
					String idprod=tfidproduit.getText();
					String idbnq=tfidcomptebnq.getText();
					
					String msg = "";
					boolean verif = true;
					
					if(codeClient.isEmpty())
					{
						tfcodeclient.setForeground(Color.RED);
						verif = false;
					}
					if(matriculeFiscale.isEmpty())
					{
						tfmatriculefiscale.setForeground(Color.RED);
						verif = false;
					}
					if(type.isEmpty())
					{
						tftype.setForeground(Color.RED);
						verif = false;
					}
					if(raisonSociale.isEmpty())
					{
						tfraisonsociale.setForeground(Color.RED);
						verif = false;
					}
					if(adresse.isEmpty())
					{
						tfadresse.setForeground(Color.RED);
						verif = false;
					}
					if(email.isEmpty())
					{
						tfemail.setForeground(Color.RED);
						verif = false;
					}
					if(website.isEmpty())
					{
						tfwebsite.setForeground(Color.RED);
						verif = false;
					}
					if(telephoneFixe.isEmpty())
					{
						tftelfix.setForeground(Color.RED);
						verif = false;
					}
					if(telephoneMobile.isEmpty())
					{
						tftelmobil.setForeground(Color.RED);
						verif = false;
					}
					if(fax.isEmpty())
					{
						tffax.setForeground(Color.RED);
						verif = false;
					}
					if(etatFiscale.isEmpty())
					{
						tfetatfiscale.setForeground(Color.RED);
						verif = false;
					}
					if(idbnq.isEmpty())
					{
						tfidcomptebnq.setForeground(Color.RED);
						verif = false;
					}
				
			
					
					
					// à completer..
					
					if(!verif)
					{
						JOptionPane.showMessageDialog(null, "Vérifier les valeurs saisies!");
						return;
					}
					int idClient= Integer.parseInt(textFieldID.getText());
					int telFixe = Integer.parseInt(tftelfix.getText());
					int telMobile = Integer.parseInt(tftelmobil.getText());
					int faxx = Integer.parseInt(tffax.getText());
					int idProduit= Integer.parseInt(tfidproduit.getText());
					int idComptebnq= Integer.parseInt(tfidcomptebnq.getText());
					
					 Client client= new Client(codeClient,matriculeFiscale,raisonSociale,type,adresse,telFixe,telMobile,faxx,email,website,etatFiscale,idProduit,idComptebnq);
					 try {
							if(client.ajouterClient())
								JOptionPane.showMessageDialog(null, "Client ajouté avec succès.");
						} catch (HeadlessException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}
			});
			add_bn.setBounds(964, 203, 122, 59);
			frame.getContentPane().add(add_bn);
			
			JButton edite_bn = new JButton("Modifier");
			edite_bn.setIcon(new ImageIcon("C:\\Users\\houssem\\Downloads\\pencil.png"));
			edite_bn.setBackground(new Color(255, 255, 153));
			edite_bn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//***************modifier*******************
					
					
					String codeClient= tfcodeclient.getText();
					String matriculeFiscale= tfmatriculefiscale.getText();
					String raisonSociale= tfraisonsociale.getText();
					String type = tftype.getText();
					String adresse= tfadresse.getText();
					String telfixx= tftelfix.getText();
					String telmobile=tftelmobil.getText();
					String faxx= tffax.getText();
					
					String email= tfemail.getText();
					String website= tfwebsite.getText();
					String etatFiscale= tfetatfiscale.getText();
					String idprod= tfidproduit.getText();
					String idbnq= tfidcomptebnq.getText();
					
					String idclte=textFieldID.getText();
					String msg = "";
					boolean verif = true;
					if(codeClient.isEmpty())
					{
						tfcodeclient.setForeground(Color.RED);
						verif = false;
					}
					if(matriculeFiscale.isEmpty())
					{
						tfmatriculefiscale.setForeground(Color.RED);
						verif = false;
					}
					if(type.isEmpty())
					{
						tftype.setForeground(Color.RED);
						verif = false;
					}
					if(raisonSociale.isEmpty())
					{
						tfraisonsociale.setForeground(Color.RED);
						verif = false;
					}
					if(adresse.isEmpty())
					{
						tfadresse.setForeground(Color.RED);
						verif = false;
					}
					if(email.isEmpty())
					{
						tfemail.setForeground(Color.RED);
						verif = false;
					}
					if(website.isEmpty())
					{
						tfwebsite.setForeground(Color.RED);
						verif = false;
					}
					if(telfixx.isEmpty())
					{
						tftelfix.setForeground(Color.RED);
						verif = false;
					}
					if(telmobile.isEmpty())
					{
						tftelmobil.setForeground(Color.RED);
						verif = false;
					}
					if(faxx.isEmpty())
					{
						tffax.setForeground(Color.RED);
						verif = false;
					}
					if(etatFiscale.isEmpty())
					{
						tfetatfiscale.setForeground(Color.RED);
						verif = false;
					}
					if(idbnq.isEmpty())
					{
						tfidcomptebnq.setForeground(Color.RED);
						verif = false;
					}
				
			
					
					
					// à completer..
					
					if(!verif)
					{
						JOptionPane.showMessageDialog(null, "Vérifier les valeurs saisies!");
						return;
					}
					if(idclte.isEmpty()){
					    	JOptionPane.showMessageDialog(null, "selectionner un client !!");
					}else {
						int idClient= Integer.parseInt(textFieldID.getText());
						int telephoneFixe = Integer.parseInt(tftelfix.getText());
						int telephoneMobile = Integer.parseInt(tftelmobil.getText());
						int fax = Integer.parseInt(tffax.getText());
						int idProduit= Integer.parseInt(tfidproduit.getText());
						int idComptebnq= Integer.parseInt(tfidcomptebnq.getText());
                        Client client= new Client(codeClient,matriculeFiscale,raisonSociale,type,adresse,telephoneFixe,telephoneMobile,fax,email,website,etatFiscale,idProduit,idComptebnq);
					    try {
							if(client.editeClient(idClient))
								JOptionPane.showMessageDialog(null, "Client modifier avec succès.");
						    } catch (HeadlessException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
					}	
				}
			});
			edite_bn.setBounds(964, 275, 122, 53);
			frame.getContentPane().add(edite_bn);
			
			JButton delete_bn = new JButton("Supprimer");
			delete_bn.setIcon(new ImageIcon("C:\\Users\\houssem\\Downloads\\delete.png"));
			delete_bn.setBackground(new Color(255, 153, 153));
			delete_bn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//*************supprimer****************
					String id= textFieldID.getText();
					if(id.isEmpty()) {
						JOptionPane.showMessageDialog(null, "selectionner un client !!");
					}else {
					int idd= Integer.parseInt(textFieldID.getText());
					Client delclt=new Client();
					try {
						if(delclt.deleteClient(idd))
							JOptionPane.showMessageDialog(null, "Client supprimer avec succès.");
					} catch (HeadlessException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}
				}
					
			});
			delete_bn.setBounds(964, 341, 122, 53);
			frame.getContentPane().add(delete_bn);
			
			lblNewLabel_13 = new JLabel("idComptebnq");
			lblNewLabel_13.setBounds(620, 511, 95, 16);
			frame.getContentPane().add(lblNewLabel_13);
			
			tfidcomptebnq = new JTextField();
			tfidcomptebnq.setBounds(727, 511, 116, 22);
			frame.getContentPane().add(tfidcomptebnq);
			tfidcomptebnq.setColumns(10);
			
			comptebnq_bn = new JButton("Cr\u00E9er un Compte Bancaire");
			comptebnq_bn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ec) {
					String idclient= textFieldID.getText();
					
					if(idclient.isEmpty()) {
						JOptionPane.showMessageDialog(null, "selectionner un client !!");
					}else {
						int idclt=Integer.parseInt(idclient);
					String nombanque=JOptionPane.showInputDialog("donner nom de la banque :");
					String agence=JOptionPane.showInputDialog("donner l'agence :");
					String rip=JOptionPane.showInputDialog("donner le rip :");
					double Rip = Double.parseDouble(rip);
					CompteBancaire ctebnq=new CompteBancaire(nombanque,agence,Rip);
					 try {
						if( ctebnq.ajouterCompteBancaire())
								JOptionPane.showMessageDialog(null, "Compte Bancaire ajouté avec succès.");
						} catch (HeadlessException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					 String req= "SELECT MAX(id_comptebancaire) FROM `comptebancaire`";
					 ResultSet rs = null;
					try {
						rs = DataBaseConnection.executionQuery(req);
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					 try {
						if(rs.next()) {
							 int idComptebnq=rs.getInt(1);
							 try {
								   String req1= "UPDATE `client` SET `id_comptebnq`='"+idComptebnq+"' WHERE id_client="+idclt+"";
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
			comptebnq_bn.setBounds(903, 519, 183, 36);
			frame.getContentPane().add(comptebnq_bn);
			
			search = new JTextField();
			search.setBounds(613, 60, 102, 30);
			frame.getContentPane().add(search);
			search.setColumns(10);
			
			String[] test = {"codeClient","type"};
			combo_client = new JComboBox(test);
			combo_client.setBounds(727, 62, 97, 26);
			frame.getContentPane().add(combo_client);
			
			btnNewButton = new JButton("chercher");
			btnNewButton.setIcon(new ImageIcon("C:\\Users\\houssem\\Downloads\\search.png"));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ek) {
					
					affichertableau(search.getText(),combo_client.getSelectedItem().toString());
				}
			});
			btnNewButton.setBounds(836, 60, 116, 28);
			frame.getContentPane().add(btnNewButton);
			
			
			
		
	}
}
