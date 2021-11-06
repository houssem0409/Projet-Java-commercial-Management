package view;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DataBaseConnection;
import net.proteanit.sql.DbUtils;

import javax.swing.JFrame;
import javax.swing.JTable;

import com.mysql.jdbc.Statement;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;

public class DetailsBon {

	public JFrame frame;
	private JTable table;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JLabel lab_total;
	private JLabel lab_datebon;
	private JLabel lblNewLabel_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DetailsBon window = new DetailsBon();
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
	public DetailsBon() throws ClassNotFoundException, SQLException {
		DataBaseConnection.connecter();
		initialize();
		
		BonReceptions.tfidbon.getText();
		int id=Integer.parseInt(BonReceptions.tfidbon.getText());
		detailsbons(id);
		 detailbon2(id);
		 Total(id);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1066, 927);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(180, 284, 431, 426);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		lblNewLabel = new JLabel("Date Du Bon Reception :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(180, 169, 190, 20);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_2 = new JLabel("Total :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(451, 736, 81, 25);
		frame.getContentPane().add(lblNewLabel_2);
		
		lab_total = new JLabel("New label");
		lab_total.setBounds(544, 739, 81, 20);
		frame.getContentPane().add(lab_total);
		
		lab_datebon = new JLabel("New label");
		lab_datebon.setBounds(382, 172, 226, 16);
		frame.getContentPane().add(lab_datebon);
		
		lblNewLabel_6 = new JLabel("Bon Reception");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_6.setBounds(327, 55, 125, 26);
		frame.getContentPane().add(lblNewLabel_6);
		
		lblNewLabel_3 = new JLabel("Adresse Reception :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(180, 202, 132, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_5 = new JLabel("Date Reception :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(180, 231, 115, 16);
		frame.getContentPane().add(lblNewLabel_5);
		
		lab_adressereception = new JLabel("New label");
		lab_adressereception.setBounds(382, 203, 150, 16);
		frame.getContentPane().add(lab_adressereception);
		
		lab_datereception = new JLabel("New label");
		lab_datereception.setBounds(382, 232, 207, 16);
		frame.getContentPane().add(lab_datereception);
		
		lblNewLabel_8 = new JLabel("Numero de Commande :");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(180, 255, 168, 16);
		frame.getContentPane().add(lblNewLabel_8);
		
		lab_numcommande = new JLabel("New label");
		lab_numcommande.setBounds(382, 255, 226, 16);
		frame.getContentPane().add(lab_numcommande);
	}
	public void detailsbons(int id) {
		String req= "SELECT reference,designation,prix,uniteMesure,tva,quantite FROM `lignebonreception`,`produit` where lignebonreception.idBonReception="+id+" and lignebonReception.idProduit=produit.id_produit  ";
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
	String tab[] = new String[100];
	 int i=0;
	 private JLabel lblNewLabel_3;
	 private JLabel lblNewLabel_5;
	 private JLabel lab_adressereception;
	 private JLabel lab_datereception;
	 private JLabel lblNewLabel_8;
	 private JLabel lab_numcommande;
	public void detailbon2(int id) {
		
		Statement stmt;
		try {
			stmt = (Statement) DataBaseConnection.connection.createStatement();
			String req= "SELECT dateBon,dateReception,adresseRecp,numCommande FROM `bonreception` where id_bonreception="+id+" ";
			ResultSet result=stmt.executeQuery(req);
			while(result.next()) {
				String a= result.getString(1);
				String dr=result.getString(2);
				String ar=result.getString(3);
				String nc=result.getString(4);
				
				lab_datebon.setText(a);
				lab_datereception.setText(dr);
				lab_adressereception.setText(ar);
				lab_numcommande.setText(nc);
				
			}
		      
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	int total=0;
	public void Total(int id) throws SQLException {
		String req= "SELECT prix,quantite FROM `lignebonreception`,`produit` where lignebonreception.idBonReception="+id+" and lignebonreception.idProduit=produit.id_produit  ";
		ResultSet rs = null;
		try {
			rs = DataBaseConnection.executionQuery(req);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while(rs.next()) {
			total=total+(Integer.parseInt(rs.getString(1)) * Integer.parseInt(rs.getString(2)));
			String t=Integer.toString(total);
			lab_total.setText(t);
		}
		
		
	}
	}


