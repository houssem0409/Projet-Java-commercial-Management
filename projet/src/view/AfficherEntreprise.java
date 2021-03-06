package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.Choice;
import javax.swing.table.DefaultTableModel;

import database.DataBaseConnection;
import model.Entreprise;
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

public class AfficherEntreprise {

	JFrame frame;
	public JTable table;
	public JTable table_1;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AfficherEntreprise window = new AfficherEntreprise();
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
	public AfficherEntreprise() throws ClassNotFoundException, SQLException {
		 DataBaseConnection.connecter();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1295, 666);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 200, 0)));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Matricule.F", "Raison social", "type", "description", "adresse", "tel fixe", "tel mobile", "fax", "email", "web site", "Etat Fiscale"},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
			 },
			new String[] {
				
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, String.class
			};
			
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setBounds(12, 80, 1212, 365);
		frame.getContentPane().add(table);
		
		JLabel lblListeDesEntreprise = new JLabel("Liste Des Entreprises");
		lblListeDesEntreprise.setForeground(Color.BLUE);
		lblListeDesEntreprise.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblListeDesEntreprise.setBounds(395, 8, 282, 42);
		frame.getContentPane().add(lblListeDesEntreprise);
		
		JButton btnNewButton = new JButton("Afficher");
		btnNewButton.setBackground(new Color(127, 255, 212));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setForeground(new Color(165, 42, 42));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String req= "SELECT * FROM `entreprise` ";
				ResultSet rs = null;
				try {
					rs = DataBaseConnection.executionQuery(req);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					table.setModel(DbUtils.resultSetToTableModel(rs));
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
		btnNewButton.setBounds(1082, 502, 142, 42);
		frame.getContentPane().add(btnNewButton);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{" identreprise", "matricule fiscale", "raison sociale", "type", "description", "adresse", "tel fix", "tel mobile", "fax", "email", "site web", "etat fiscale"},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table_1.setBounds(12, 63, 1212, 16);
		frame.getContentPane().add(table_1);
		
		btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBackground(new Color(238, 130, 238));
		btnNewButton_1.setForeground(new Color(139, 69, 19));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBounds(895, 502, 134, 42);
		frame.getContentPane().add(btnNewButton_1);
	}
}
