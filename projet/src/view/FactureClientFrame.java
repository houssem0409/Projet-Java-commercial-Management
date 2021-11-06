package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import database.DataBaseConnection;
import model.FactureClient;
import model.FactureFournisseur;
import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class FactureClientFrame {

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
	private JLabel lblNewLabel_6;
	private JTextField tfidclient;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FactureClientFrame window = new FactureClientFrame();
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
	public FactureClientFrame() throws ClassNotFoundException, SQLException {
		DataBaseConnection.connecter();
		initialize();
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
			     tfidclient.setText(model.getValueAt(selectedRowIndex, 2).toString());
				 tfdatefacture.setText(model.getValueAt(selectedRowIndex, 3).toString());
				combomodepayement.setSelectedItem(model.getValueAt(selectedRowIndex, 4).toString());
				combotypefacture.setSelectedItem(model.getValueAt(selectedRowIndex, 5).toString());
				
			}
		});
		stable.setBounds(292, 123, 685, 302);
		frame.getContentPane().add(stable);
		
		
		stable.setViewportView(table);
		String[] test= {"Chèque","Espèces","carte Bancaire"};
		combomodepayement = new JComboBox(test);
		combomodepayement.setBounds(148, 274, 110, 22);
		frame.getContentPane().add(combomodepayement);
		String[] test1= {"Facture BL","Facture Libre"};
		combotypefacture = new JComboBox(test1);
		combotypefacture.setBounds(148, 328, 110, 22);
		frame.getContentPane().add(combotypefacture);

		
		
		add_bn = new JButton("ajouter");
		add_bn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eadd) {
				String idd= labid.getText();
				String code = tfcode.getText();
				String idClient=tfidclient.getText();
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
				int idclt=Integer.parseInt(idClient);
				
				FactureClient ff= new FactureClient(code,idclt,dateFacture,modePayement,type);
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
				FactureClient ff= new FactureClient();
				try {
					if(ff.deleteFacture(idd))
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
				String idClient=tfidclient.getText();
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
				int idclt=Integer.parseInt(idClient);
				int id= Integer.parseInt(idd);
				FactureClient ff= new FactureClient(code,idclt,dateFacture,modePayement,type);
				 try {
						if(ff.editeFacture(id))
							JOptionPane.showMessageDialog(null, "factures ajouté avec succès.");
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
		lblNewLabel_2.setBounds(25, 231, 97, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Mode Payement");
		lblNewLabel_3.setBounds(25, 277, 97, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		
		
		tfcode = new JTextField();
		tfcode.setBounds(142, 138, 116, 22);
		frame.getContentPane().add(tfcode);
		tfcode.setColumns(10);
		
		tfdatefacture = new JTextField();
		tfdatefacture.setBounds(148, 228, 116, 22);
		frame.getContentPane().add(tfdatefacture);
		tfdatefacture.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Type Facture");
		lblNewLabel_4.setBounds(25, 331, 97, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		gestionbon_btn = new JButton("Gestion de Bon");
		gestionbon_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent egb) {
				//********** gestion de bon **********
				
				BonLivraisonFrame bl;
				try {
					bl = new BonLivraisonFrame();
					bl.frame.setVisible(true);
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
				refresh();
			}
		});
		btnRefresh.setBounds(880, 85, 97, 25);
		frame.getContentPane().add(btnRefresh);
		
		lblNewLabel_6 = new JLabel("idClient");
		lblNewLabel_6.setBounds(25, 176, 56, 16);
		frame.getContentPane().add(lblNewLabel_6);
		
		tfidclient = new JTextField();
		tfidclient.setBounds(142, 173, 116, 22);
		frame.getContentPane().add(tfidclient);
		tfidclient.setColumns(10);
		
			}
	private void refresh(){
		
		String req= "SELECT * FROM `factureclient` ";
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
