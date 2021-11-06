package view;

import java.awt.Color;
import java.awt.EventQueue;
import database.DataBaseConnection;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Client;
import model.FactureFournisseur;
import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Factures {

	public JFrame frame;
	private JTable table;
	private JScrollPane stable;
	private JButton add_bn;
	private JButton delete_bn;
	private JButton edite_bn;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JComboBox combotypefacture;
	private JTextField tfcode;
	private JTextField tfdatefacture;
	private JLabel lblNewLabel_4;
	private JComboBox combomodepayement;
	private JButton gestionbon_btn;
	private JLabel lblNewLabel_5;
	private JLabel labid;
	private JButton btnRefresh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Factures window = new Factures();
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
	public Factures() throws ClassNotFoundException, SQLException {
		DataBaseConnection.connecter();
		initialize();
		refresh();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1051, 665);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gestion De Factures");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 24));
		lblNewLabel.setBounds(348, 41, 414, 45);
		frame.getContentPane().add(lblNewLabel);
		
		stable = new JScrollPane();
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//****** mouse click*********************
				DefaultTableModel model= (DefaultTableModel)table.getModel();
				int selectedRowIndex = table.getSelectedRow();
			     labid.setText(model.getValueAt(selectedRowIndex, 0).toString());
				tfcode.setText(model.getValueAt(selectedRowIndex, 1).toString());
				tfdatefacture.setText(model.getValueAt(selectedRowIndex, 2).toString());
				combomodepayement.setSelectedItem(model.getValueAt(selectedRowIndex, 3).toString());
				combotypefacture.setSelectedItem(model.getValueAt(selectedRowIndex, 4).toString());
				
			}
		});
		stable.setBounds(292, 123, 685, 302);
		frame.getContentPane().add(stable);
		
		
		stable.setViewportView(table);
		String[] test= {"Chèque","Espèces","carte Bancaire"};
		combomodepayement = new JComboBox(test);
		combomodepayement.setBounds(148, 252, 110, 22);
		frame.getContentPane().add(combomodepayement);
		String[] test1= {"Facture BL","Facture Libre"};
		combotypefacture = new JComboBox(test1);
		combotypefacture.setBounds(148, 303, 110, 22);
		frame.getContentPane().add(combotypefacture);

		
		
		add_bn = new JButton("ajouter");
		add_bn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eadd) {
				String idd= labid.getText();
				String code = tfcode.getText();
				String dateFacture= tfdatefacture.getText();
				String modePayement= combomodepayement.getSelectedItem().toString();
				String type= combotypefacture.getSelectedItem().toString();
				
				String msg = "";
				boolean verif = true;
				if(code.isEmpty())
				{
					tfcode.setForeground(Color.RED);
					verif = false;
				}
				if(dateFacture.isEmpty())
				{
					tfdatefacture.setForeground(Color.RED);
					verif = false;
				}
				
				// à completer..
				
				if(!verif)
				{
					JOptionPane.showMessageDialog(null, "Vérifier les valeurs saisies!");
					return;
				}
				int id= Integer.parseInt(idd);
				FactureFournisseur ff= new FactureFournisseur(code,dateFacture,modePayement,type);
				 try {
						if(ff.ajouterFacture())
							JOptionPane.showMessageDialog(null, "factures ajouté avec succès.");
					} catch (HeadlessException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				
			}
			
		});
		add_bn.setBounds(875, 451, 108, 35);
		frame.getContentPane().add(add_bn);
		
		delete_bn = new JButton("supprimer");
		delete_bn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				///********* delete *************
				String id= labid.getText();
				
				
				
				if(id.isEmpty()) {
					JOptionPane.showMessageDialog(null, "selectionner un client !!");
				}else {
				int idd= Integer.parseInt(id);
				FactureFournisseur delclt=new FactureFournisseur();
				try {
					if(delclt.deleteFacture(idd))
						JOptionPane.showMessageDialog(null, "Facture supprimer avec succès.");
				} catch (HeadlessException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			}
		});
		delete_bn.setBounds(744, 451, 119, 35);
		frame.getContentPane().add(delete_bn);
		
		edite_bn = new JButton("Modifier");
		edite_bn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eed) {
				///************ modifier ************
				String idd= labid.getText();
				String code = tfcode.getText();
				String dateFacture= tfdatefacture.getText();
				String modePayement= combomodepayement.getSelectedItem().toString();
				String type= combotypefacture.getSelectedItem().toString();
				
				String msg = "";
				boolean verif = true;
				if(code.isEmpty())
				{
					tfcode.setForeground(Color.RED);
					verif = false;
				}
				if(dateFacture.isEmpty())
				{
					tfdatefacture.setForeground(Color.RED);
					verif = false;
				}
				
				// à completer..
				
				if(!verif)
				{
					JOptionPane.showMessageDialog(null, "Vérifier les valeurs saisies!");
					return;
				}
				int id= Integer.parseInt(idd);
				FactureFournisseur ff= new FactureFournisseur(code,dateFacture,modePayement,type);
				 try {
						if(ff.editeFacture(id))
							JOptionPane.showMessageDialog(null, "factures Modifier avec succès.");
					} catch (HeadlessException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				
			}
				
				
			
		});
		edite_bn.setBounds(622, 451, 110, 35);
		frame.getContentPane().add(edite_bn);
		
		lblNewLabel_1 = new JLabel("Code");
		lblNewLabel_1.setBounds(25, 138, 97, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Date Facture");
		lblNewLabel_2.setBounds(25, 196, 97, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Mode Payement");
		lblNewLabel_3.setBounds(25, 255, 97, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		
		
		tfcode = new JTextField();
		tfcode.setBounds(142, 138, 116, 22);
		frame.getContentPane().add(tfcode);
		tfcode.setColumns(10);
		
		tfdatefacture = new JTextField();
		tfdatefacture.setBounds(142, 193, 116, 22);
		frame.getContentPane().add(tfdatefacture);
		tfdatefacture.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Type Facture");
		lblNewLabel_4.setBounds(25, 306, 97, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		gestionbon_btn = new JButton("Gestion de Bon");
		gestionbon_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent egb) {
				//********** gestion de bon **********
				
				try {
					BonReceptions br=new BonReceptions();
					br.frame.setVisible(true);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		gestionbon_btn.setBounds(45, 537, 119, 35);
		frame.getContentPane().add(gestionbon_btn);
		
		lblNewLabel_5 = new JLabel("id");
		lblNewLabel_5.setBounds(25, 101, 56, 16);
		frame.getContentPane().add(lblNewLabel_5);
		
		labid = new JLabel("");
		labid.setBounds(142, 101, 56, 16);
		frame.getContentPane().add(labid);
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//*********refresh **********
				String req= "SELECT * FROM `facturefournisseur` ";
				ResultSet rs = null;
				try {
					rs = DataBaseConnection.executionQuery(req);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}table.setModel(DbUtils.resultSetToTableModel(rs));
				try {
					while(rs.next())
					{
						table.setModel(DbUtils.resultSetToTableModel(rs));
					
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});
		btnRefresh.setBounds(880, 85, 97, 25);
		frame.getContentPane().add(btnRefresh);
		
			}
	private void refresh(){
		
		String req= "SELECT * FROM `facturefournisseur` ";
		ResultSet rs = null;
		try {
			rs = DataBaseConnection.executionQuery(req);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}table.setModel(DbUtils.resultSetToTableModel(rs));
		try {
			while(rs.next())
			{
				table.setModel(DbUtils.resultSetToTableModel(rs));
			
			}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		
		
	}
}
