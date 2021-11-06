package controller;

import java.lang.reflect.Array;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Platform.exit;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Connection {

	

	    private final String User = "root";
	    private final String password = "";
	    String ipLocal = "localhost";

	    private String url = "jdbc:mysql://" + ipLocal + ":3306/mydatabasejava";
	    private Connection cnx;
	    private Statement st, jt;
	    private ResultSet rst;

	    public void DeleteAllElementTab(JTable T, int column, int row) {
	        int i = 0;
	        int j = 0;
	        while (i < row) {
	            while (j <= column) {
	                T.setValueAt("", i, j);
	                j++;
	            }
	            j = 0;
	            i++;
	        }

	    }

	    public void ConnexionIntoDataBase() {

	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            System.out.println("Driver OK");
	            try {
	                cnx = (Connection) DriverManager.getConnection(url, User, password);
	                System.out.println("successful connexion");
	            } catch (SQLException ex) {
	                Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
	                JOptionPane.showMessageDialog(null, " erreur connexion activer le serveur ou verifier "
	                        + "\nle configuration de  serveur");

	            } finally {
	                return;
	            }
	        } catch (ClassNotFoundException ex) {
	            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }
	    

}
