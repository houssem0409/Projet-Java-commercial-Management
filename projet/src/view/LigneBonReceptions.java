package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Statement;

import database.DataBaseConnection;
import model.BonReception;
import model.LigneBonReception;
import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;

public class LigneBonReceptions {

	public JFrame frame;
	private JTable table;
	private JTable table_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField tfidlignebonrecp;
	private JTextField tfidproduit;
	private JTextField tfquantite;
	private JTextField tfidbonreception;
	private JComboBox comboproduit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LigneBonReceptions window = new LigneBonReceptions();
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
	public LigneBonReceptions() throws ClassNotFoundException, SQLException {
		DataBaseConnection.connecter();
		initialize();
		
		tfidbonreception.setText(BonReceptions.tfidbon.getText());
		
		

	}

	String tab[] = new String[100];
	 int i=0;
	private String[] listeProduit() 
	{
		Statement stmt;
		try {
			stmt = (Statement) DataBaseConnection.connection.createStatement();
			String SQL ="SELECT DISTINCT designation from produit ";
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

	String famillep="";
	private String Selected(String famdig) {
		
		 Statement stmt;
		try {
			stmt = (Statement) DataBaseConnection.connection.createStatement();
			String sql ="SELECT id_produit from produit where designation='"+famdig+"'";
			ResultSet result=stmt.executeQuery(sql);
			 String fam;
			while(result.next()) {
				
				
				famillep=result.getString("id_produit");
				String familleProduit=famillep;
				
				System.out.println(famillep);
			}

		}catch (Exception e) {
			e.printStackTrace();
		}
		return famillep;
		

	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1007, 737);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("lignes Bon Reception");
		lblNewLabel.setForeground(new Color(102, 51, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel.setBounds(392, 45, 404, 53);
		frame.getContentPane().add(lblNewLabel);
		
		table = new JTable();
		table.setBackground(new Color(230, 230, 250));
		table.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.GRAY, Color.GRAY));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"idligneBonR", "idProduit", "quantite", "idBonReception"},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		table.setBounds(295, 129, 474, 15);
		frame.getContentPane().add(table);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model= (DefaultTableModel)table_1.getModel();
				int selectedRowIndex = table_1.getSelectedRow();
				
				tfidlignebonrecp.setText(model.getValueAt(selectedRowIndex, 0).toString());
				tfidproduit.setText(model.getValueAt(selectedRowIndex, 1).toString());
				tfquantite.setText(model.getValueAt(selectedRowIndex, 2).toString());
				tfidbonreception.setText(model.getValueAt(selectedRowIndex, 3).toString());
			
				
				
			}
		});
		table_1.setBackground(new Color(224, 255, 255));
		table_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		table_1.setBounds(295, 145, 474, 176);
		frame.getContentPane().add(table_1);
		
		btnNewButton = new JButton("ajouter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//********** ajouter*************
				String idlignebonRecp=tfidlignebonrecp.getText();
				String idproduitt=Selected(comboproduit.getSelectedItem().toString());
				String quantitee=tfquantite.getText();
				String idbonreception=tfidbonreception.getText();
				String msg="";
                 boolean verif = true;
				
				
				if(idlignebonRecp.isEmpty()) {
					tfidlignebonrecp.setForeground(Color.RED);
					verif = false;
					
				}
				if(quantitee.isEmpty())
				{
					tfquantite.setForeground(Color.RED);
					verif = false;
				}
				if(idbonreception.isEmpty())
				{
					tfidbonreception.setForeground(Color.RED);
					verif = false;
				}
				
				if(!verif)
				{
					JOptionPane.showMessageDialog(null, "Vérifier les valeurs saisies!");
					return;
				}
				int idlignebnre= Integer.parseInt(idlignebonRecp);
				int quantiter= Integer.parseInt(quantitee);
				int idbonrecp =Integer.parseInt(idbonreception);
				int idprod=Integer.parseInt(idproduitt);
				
				LigneBonReception LBR =new LigneBonReception(idprod,quantiter,idbonrecp);
				try {
					int qter=Integer.parseInt(LBR.qteSelected(idprod));
					 try {
							if( LBR.ajouterLigneBonReception() && LBR.SustractStock(idprod, qter,quantiter) )
								JOptionPane.showMessageDialog(null, "Ligne de bon Reception ajouté avec succès.");
						} catch (HeadlessException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				
				
				
			}
		});
		btnNewButton.setBounds(822, 177, 97, 41);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("Modifier");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///******************* Modifier **************
				String idlignebonRecp=tfidlignebonrecp.getText();
				String idproduitt=Selected(comboproduit.getSelectedItem().toString());
				String quantitee=tfquantite.getText();
				String idbonreception=tfidbonreception.getText();
				String msg="";
                 boolean verif = true;
				
				
				if(idlignebonRecp.isEmpty()) {
					tfidlignebonrecp.setForeground(Color.RED);
					verif = false;
					
				}
				if(quantitee.isEmpty())
				{
					tfquantite.setForeground(Color.RED);
					verif = false;
				}
				if(idbonreception.isEmpty())
				{
					tfidbonreception.setForeground(Color.RED);
					verif = false;
				}
				
				if(!verif)
				{
					JOptionPane.showMessageDialog(null, "Vérifier les valeurs saisies!");
					return;
				}
				int idlignebnre= Integer.parseInt(idlignebonRecp);
				int quantiter= Integer.parseInt(quantitee);
				int idbonrecp =Integer.parseInt(idbonreception);
				int idprod=Integer.parseInt(idproduitt);
				LigneBonReception LBR =new LigneBonReception(idprod,quantiter,idbonrecp);
				 try {
						if( LBR.editeLigneBonReception(idlignebnre))
							JOptionPane.showMessageDialog(null, "Ligne de bon Reception ajouté avec succès.");
					} catch (HeadlessException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
			}
		});
		btnNewButton_1.setBounds(822, 231, 97, 40);
		frame.getContentPane().add(btnNewButton_1);
		
		comboproduit = new JComboBox(listeProduit());
		comboproduit.setBounds(166, 217, 92, 22);
		frame.getContentPane().add(comboproduit);
		
		btnNewButton_2 = new JButton("Supprimer");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//////****************** Supprimer ***********
				String idp=tfidlignebonrecp.getText();
				if(idp.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "selectionner un ligne de Bon Reception !!");
					
				}else {
					int idd= Integer.parseInt(tfidlignebonrecp.getText());
				LigneBonReception lbr= new LigneBonReception();
					try {
						if(lbr.deleteLigneBonReception(idd))
							JOptionPane.showMessageDialog(null, "Ligne Bon Reception  supprimer avec succès.");
					} catch (HeadlessException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		});
		btnNewButton_2.setBounds(822, 284, 97, 37);
		frame.getContentPane().add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Actualider");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//********, actualiser**********
				String req= "SELECT * FROM `lignebonreception` ";
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
		btnNewButton_3.setBounds(822, 129, 97, 41);
		frame.getContentPane().add(btnNewButton_3);
		
		lblNewLabel_1 = new JLabel("IdLigneBonReception");
		lblNewLabel_1.setBounds(12, 144, 118, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("idProduit");
		lblNewLabel_2.setBounds(12, 189, 56, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("quantite");
		lblNewLabel_3.setBounds(12, 243, 56, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("idBonReception");
		lblNewLabel_4.setBounds(12, 294, 97, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		tfidlignebonrecp = new JTextField();
		tfidlignebonrecp.setBounds(133, 141, 130, 22);
		frame.getContentPane().add(tfidlignebonrecp);
		tfidlignebonrecp.setColumns(10);
		
		tfidproduit = new JTextField();
		tfidproduit.setBounds(137, 186, 126, 22);
		frame.getContentPane().add(tfidproduit);
		tfidproduit.setColumns(10);
		
		tfquantite = new JTextField();
		tfquantite.setBounds(137, 240, 126, 22);
		frame.getContentPane().add(tfquantite);
		tfquantite.setColumns(10);
		
		tfidbonreception = new JTextField();
		tfidbonreception.setBounds(133, 291, 130, 22);
		frame.getContentPane().add(tfidbonreception);
		tfidbonreception.setColumns(10);
	}
}
