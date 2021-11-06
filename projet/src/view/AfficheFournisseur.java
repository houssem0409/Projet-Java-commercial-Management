package view;

import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;

import model.CompteBancaire;
import model.Fournisseur;
import model.GlobalVariables;
import model.Produit;
import model.GlobalVariables;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Statement;

import database.DataBaseConnection;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

public class AfficheFournisseur extends javax.swing.JInternalFrame {

	JFrame frame;
	public JTable Table;
	private JTable table;
	private JTextField tfidfournisseur;
	private JTextField tfcode;
	private JTextField tfmatriculefiscale;
	private JTextField tfraisonsociale;
	private JTextField tfadresse;
	private JTextField tftelephonefix;
	private JTextField tftelephonemobil;
	private JTextField tffax;
	private JTextField tfemail;
	private JTextField tfwebsite;
	private JTextField tfetatfiscale;
	private JTextField tfidcomptebnq;
	private JTextField search;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				
					AfficheFournisseur window = new AfficheFournisseur();
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
	 * @throws HeadlessException 
	 * @throws ClassNotFoundException 
	 */
	public AfficheFournisseur() throws HeadlessException, SQLException, ClassNotFoundException {
		DataBaseConnection.connecter();
			initialize();
			refresh();
		 
		
		
	}
	private void refresh(){
		
	String req= "SELECT * FROM `fournisseur` ";
	ResultSet rs = null;
	try {
		rs = DataBaseConnection.executionQuery(req);
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}Table.setModel(DbUtils.resultSetToTableModel(rs));
	try {
		while(rs.next())
		{
			Table.setModel(DbUtils.resultSetToTableModel(rs));
		
		}
	} catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
	
	
	
	
}
	private void affichertableau(String term,String by) 
	{
		Statement stmt;
		try {
			stmt = (Statement) DataBaseConnection.connection.createStatement();
			String ref="where "+by+"='"+term+"'";
			if(search.getText().isEmpty()) {
			ResultSet result=stmt.executeQuery("SELECT * FROM fournisseur ");
			Table.setModel(DbUtils.resultSetToTableModel(result));

			}
			else{
				ResultSet result=stmt.executeQuery("SELECT * FROM fournisseur "+ref+"");
				Table.setModel(DbUtils.resultSetToTableModel(result));
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
		frame.getContentPane().setBackground(new Color(240, 240, 240));
		frame.setBounds(100, 100, 1013, 682);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	
		
		
		JButton show_bn = new JButton("Afficher");
		show_bn.setIcon(new ImageIcon("C:\\Users\\houssem\\Downloads\\refresh.png"));
		show_bn.setBackground(new Color(255, 255, 51));
		show_bn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String req= "SELECT * FROM `fournisseur` ";
				ResultSet rs = null;
				try {
					rs = DataBaseConnection.executionQuery(req);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}Table.setModel(DbUtils.resultSetToTableModel(rs));
				try {
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
		
		show_bn.setBounds(868, 89, 115, 38);
		frame.getContentPane().add(show_bn);
		
		Table = new JTable();
		Table.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(204, 204, 0), null, null, null));
		Table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Table.setForeground(new Color(0, 0, 0));
		Table.setBackground(new Color(255, 255, 204));
		Table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				DefaultTableModel model= (DefaultTableModel)Table.getModel();
				int selectedRowIndex = Table.getSelectedRow();
				
				tfidfournisseur.setText(model.getValueAt(selectedRowIndex, 0).toString());
				tfcode.setText(model.getValueAt(selectedRowIndex, 1).toString());
				tfmatriculefiscale.setText(model.getValueAt(selectedRowIndex, 2).toString());
				tfraisonsociale.setText(model.getValueAt(selectedRowIndex, 3).toString());
				tfadresse.setText(model.getValueAt(selectedRowIndex, 4).toString());
				tftelephonefix.setText(model.getValueAt(selectedRowIndex, 5).toString());
				tftelephonemobil.setText(model.getValueAt(selectedRowIndex, 6).toString());
				tffax.setText(model.getValueAt(selectedRowIndex, 7).toString());
				tfemail.setText(model.getValueAt(selectedRowIndex, 8).toString());
				tfwebsite.setText(model.getValueAt(selectedRowIndex, 9).toString());
				tfetatfiscale.setText(model.getValueAt(selectedRowIndex, 10).toString());
				tfidcomptebnq.setText(model.getValueAt(selectedRowIndex, 11).toString());
				
			}
		});
		Table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11", "New column"
			}
		));
		Table.setBounds(12, 101, 836, 274);
		frame.getContentPane().add(Table);
		
		table = new JTable();
		table.setBackground(Color.PINK);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"IdFournisseur", "code", "matriculefiscale", "raison sociale", "adresse", "tel fix", "tel mobil", "fax", "email", "website", "etat fiscale", "idComptebnq"},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table.setBounds(12, 83, 836, 16);
		frame.getContentPane().add(table);
		
		JButton edite_bn = new JButton("Modifier");
		edite_bn.setIcon(new ImageIcon("C:\\Users\\houssem\\Downloads\\pencil.png"));
		edite_bn.setBackground(new Color(255, 153, 51));
		edite_bn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent emo) {
				
				//******* modifier***************
				
				String codeFournisseur = tfcode.getText();
				String matriculeFiscale = tfmatriculefiscale.getText();
				String  raisonSociale = tfraisonsociale.getText();
				String adresse= tfadresse.getText();
				String idfurni= tfidfournisseur.getText();
				String telephonefixx= tftelephonefix.getText();
				String telephonemobilee= tftelephonemobil.getText();
				String faxx= tffax.getText();
				String etatfiss= tfetatfiscale.getText();
				String idbnq=tfidcomptebnq.getText();
				String email = tfemail.getText();
				String website = tfwebsite.getText();
				
				String msg = "";
				boolean verif = true;
				if(codeFournisseur.isEmpty())
				{
					tfcode.setForeground(Color.RED);
					verif = false;
				}
				if(matriculeFiscale.isEmpty())
				{
					tfmatriculefiscale.setForeground(Color.RED);
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
				if(idfurni.isEmpty())
				{
					tfidfournisseur.setForeground(Color.RED);
					verif = false;
				}
				if(telephonefixx.isEmpty())
				{
					tftelephonefix.setForeground(Color.RED);
					verif = false;
				}
				if(telephonemobilee.isEmpty())
				{
					tftelephonemobil.setForeground(Color.RED);
					verif = false;
				}
				if(faxx.isEmpty())
				{
					tffax.setForeground(Color.RED);
					verif = false;
				}
				if(etatfiss.isEmpty())
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
				
				int idfournisseur= Integer.parseInt(tfidfournisseur.getText());
				int telephoneFixe= Integer.parseInt(tftelephonefix.getText());
				int telephoneMobile= Integer.parseInt(tftelephonemobil.getText());
				int fax= Integer.parseInt(tffax.getText());
				int etatFiscale= Integer.parseInt(tfetatfiscale.getText());
				int idComptebnq=Integer.parseInt(tfidcomptebnq.getText());
				 Fournisseur fournisseur = new Fournisseur(codeFournisseur,matriculeFiscale,raisonSociale,adresse,telephoneFixe,
							telephoneMobile,fax,email,website,etatFiscale,idComptebnq);
				 try {
						if( fournisseur.editeFournisseur(idfournisseur))
							JOptionPane.showMessageDialog(null, "Fournisseur modifier avec succès.");
						     refresh();
					} catch (HeadlessException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		edite_bn.setBounds(868, 145, 115, 38);
		frame.getContentPane().add(edite_bn);
		
		JButton delete_bn = new JButton("Supprimer");
		delete_bn.setIcon(new ImageIcon("C:\\Users\\houssem\\Downloads\\delete.png"));
		delete_bn.setBackground(new Color(255, 0, 0));
		delete_bn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent es) {
				
				//*********** supprimer ****************
				String idi=tfidfournisseur.getText();
				
				String msg = "";
				boolean verif=true;
				if(idi.isEmpty())
				{
					tfidfournisseur.setForeground(Color.RED);
					verif = false;
				}
				if(!verif) {
					JOptionPane.showMessageDialog(null, "veillez selectionner un fournisseur!!");
					return;
				}
				int idd= Integer.parseInt(tfidfournisseur.getText());
				Fournisseur delfour=new Fournisseur();
			
					try {
						if(delfour.deleteFournisseur(idd) )
							  JOptionPane.showMessageDialog(null, "Fournisseur supprimer avec succès.");
						refresh();
						
					} catch (HeadlessException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						
					}
				
					
				}
				
			
		});
		delete_bn.setBounds(868, 202, 115, 38);
		frame.getContentPane().add(delete_bn);
		
		JLabel lblNewLabel = new JLabel("IdFournisseur");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel.setBounds(22, 391, 102, 22);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("code");
		lblNewLabel_1.setBounds(22, 430, 56, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("matricule Fiscale");
		lblNewLabel_2.setBounds(22, 472, 102, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Raison Sociale");
		lblNewLabel_3.setBounds(22, 512, 90, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Adresse");
		lblNewLabel_4.setBounds(22, 549, 56, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Telephone Mobile");
		lblNewLabel_5.setBounds(368, 391, 108, 16);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("telephone Fix");
		lblNewLabel_6.setBounds(22, 584, 102, 16);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Fax");
		lblNewLabel_7.setBounds(368, 430, 56, 16);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Email");
		lblNewLabel_8.setBounds(368, 472, 56, 16);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("WebSite");
		lblNewLabel_9.setBounds(368, 512, 97, 16);
		frame.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Etat Fiscale");
		lblNewLabel_10.setBounds(368, 549, 97, 16);
		frame.getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("idCompteBancaire");
		lblNewLabel_11.setBounds(368, 584, 121, 16);
		frame.getContentPane().add(lblNewLabel_11);
		
		tfidfournisseur = new JTextField();
		tfidfournisseur.setBounds(166, 388, 116, 22);
		frame.getContentPane().add(tfidfournisseur);
		tfidfournisseur.setColumns(10);
		
		tfcode = new JTextField();
		tfcode.setBounds(166, 427, 116, 22);
		frame.getContentPane().add(tfcode);
		tfcode.setColumns(10);
		
		tfmatriculefiscale = new JTextField();
		tfmatriculefiscale.setBounds(166, 469, 116, 22);
		frame.getContentPane().add(tfmatriculefiscale);
		tfmatriculefiscale.setColumns(10);
		
		tfraisonsociale = new JTextField();
		tfraisonsociale.setBounds(166, 509, 116, 22);
		frame.getContentPane().add(tfraisonsociale);
		tfraisonsociale.setColumns(10);
		
		tfadresse = new JTextField();
		tfadresse.setBounds(166, 546, 116, 22);
		frame.getContentPane().add(tfadresse);
		tfadresse.setColumns(10);
		
		tftelephonefix = new JTextField();
		tftelephonefix.setBounds(166, 581, 116, 22);
		frame.getContentPane().add(tftelephonefix);
		tftelephonefix.setColumns(10);
		
		tftelephonemobil = new JTextField();
		tftelephonemobil.setBounds(501, 388, 116, 22);
		frame.getContentPane().add(tftelephonemobil);
		tftelephonemobil.setColumns(10);
		
		tffax = new JTextField();
		tffax.setBounds(501, 427, 116, 22);
		frame.getContentPane().add(tffax);
		tffax.setColumns(10);
		
		tfemail = new JTextField();
		tfemail.setBounds(501, 469, 116, 22);
		frame.getContentPane().add(tfemail);
		tfemail.setColumns(10);
		
		tfwebsite = new JTextField();
		tfwebsite.setBounds(501, 509, 116, 22);
		frame.getContentPane().add(tfwebsite);
		tfwebsite.setColumns(10);
		
		tfetatfiscale = new JTextField();
		tfetatfiscale.setBounds(501, 549, 116, 22);
		frame.getContentPane().add(tfetatfiscale);
		tfetatfiscale.setColumns(10);
		
		tfidcomptebnq = new JTextField();
		tfidcomptebnq.setBounds(501, 584, 116, 22);
		frame.getContentPane().add(tfidcomptebnq);
		tfidcomptebnq.setColumns(10);
		
		JButton add_bn = new JButton("Ajouter");
		add_bn.setIcon(new ImageIcon("C:\\Users\\houssem\\Downloads\\plus.png"));
		add_bn.setBackground(new Color(0, 153, 255));
		add_bn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ea) {
				String codeFournisseur = tfcode.getText();
				String matriculeFiscale = tfmatriculefiscale.getText();
				String  raisonSociale = tfraisonsociale.getText();
				String adresse= tfadresse.getText();
				String telfix=tftelephonefix.getText();
				
				String telephonefixx=tftelephonefix.getText();
				String telephonemobilee= tftelephonemobil.getText();
				String telmobil=tftelephonemobil.getText();
				
				String faqs=tffax.getText();
				String faxx = tffax.getText();
				
				String email = tfemail.getText();
				String website = tfwebsite.getText();
				String etatfis=tfetatfiscale.getText();
				String etatfiss= tfetatfiscale.getText();
			
				String comptebnq= tfidcomptebnq.getText();
				String idbnq= tfidcomptebnq.getText();
				
				String msg = "";
				boolean verif = true;
				if(codeFournisseur.isEmpty())
				{
					tfcode.setForeground(Color.RED);
					verif = false;
				}
				if(matriculeFiscale.isEmpty())
				{
					tfmatriculefiscale.setForeground(Color.RED);
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
				if(telephonefixx.isEmpty())
				{
					tftelephonefix.setForeground(Color.RED);
					verif = false;
				}
				if(telephonemobilee.isEmpty())
				{
					tftelephonemobil.setForeground(Color.RED);
					verif = false;
				}
				if(faxx.isEmpty())
				{
					tffax.setForeground(Color.RED);
					verif = false;
				}
				if(etatfiss.isEmpty())
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
				int idcomptebnq= Integer.parseInt(tfidcomptebnq.getText());
				int etatFiscale= Integer.parseInt(tfetatfiscale.getText());
				int fax= Integer.parseInt(tffax.getText());
				int telephoneMobile= Integer.parseInt(tftelephonemobil.getText());
				int telephoneFixe= Integer.parseInt(tftelephonefix.getText());
				 Fournisseur fournisseur = new Fournisseur(codeFournisseur,matriculeFiscale,raisonSociale,adresse,telephoneFixe,
							telephoneMobile,fax,email,website,etatFiscale,idcomptebnq);
				 try {
						if( fournisseur.ajouterFournisseur())
							JOptionPane.showMessageDialog(null, "Fournisseur ajouté avec succès.");
						refresh();
					} catch (HeadlessException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				
				
			}
		});
		add_bn.setBounds(868, 270, 115, 32);
		frame.getContentPane().add(add_bn);
		
		JLabel lblNewLabel_12 = new JLabel("Gestion Fournisseur");
		lblNewLabel_12.setForeground(Color.BLUE);
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_12.setBounds(279, 13, 300, 32);
		frame.getContentPane().add(lblNewLabel_12);
		
		JButton comptebnq_bn = new JButton("Creer un compte bancaire");
		comptebnq_bn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idfournisseur= tfidfournisseur.getText();
				
				if(idfournisseur.isEmpty()) {
					JOptionPane.showMessageDialog(null, "selectionner un fournisseur !!");
				}else {
					int idfourni=Integer.parseInt(idfournisseur);
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
							   String req1= "UPDATE `fournisseur` SET `id_comptebnq`='"+idComptebnq+"' WHERE id_fournisseur="+idfourni+"";
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
		comptebnq_bn.setFont(new Font("Tahoma", Font.BOLD, 13));
		comptebnq_bn.setBounds(771, 408, 212, 80);
		frame.getContentPane().add(comptebnq_bn);
		String[] test = {"codeFournisseur","raisonSociale"};
		JComboBox cb_fournisseur = new JComboBox(test);
		cb_fournisseur.setBounds(605, 52, 108, 22);
		frame.getContentPane().add(cb_fournisseur);
		
		
		
		
		JButton search_bn = new JButton("Chercher");
		search_bn.setIcon(new ImageIcon("C:\\Users\\houssem\\Downloads\\search.png"));
		search_bn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ech) {
			
				affichertableau(search.getText(),cb_fournisseur.getSelectedItem().toString());
				
			}
		});
		search_bn.setBounds(727, 51, 121, 25);
		frame.getContentPane().add(search_bn);
		
		search = new JTextField();
		search.setBounds(478, 51, 115, 25);
		frame.getContentPane().add(search);
		search.setColumns(10);
		
	}
	public void remplirComboBox()
	{
		
	}
}
