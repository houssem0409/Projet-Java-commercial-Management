package model;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DataBaseConnection;
import database.DataBaseTableNames;

public class FamilleProduit {
	
	// LEs caractéristiques:
	private int codeFamille;
	private String designationFamille;
	public FamilleProduit(int codeFamille, String designationFamille) {
		super();
		this.codeFamille = codeFamille;
		this.designationFamille = designationFamille;
	}
	public int getCodeFamille() {
		return codeFamille;
	}
	public void setCodeFamille(int codeFamille) {
		this.codeFamille = codeFamille;
	}
	public String getDesignationFamille() {
		return designationFamille;
	}
	public void setDesignationFamille(String designationFamille) {
		this.designationFamille = designationFamille;
	}
	
	public static FamilleProduit getFamilleProduit(int codeFamille) throws SQLException
	{
		FamilleProduit currentFamilleProduit = null;
		String req = "select * from " + DataBaseTableNames.FAMILLEPRODUIT +
		" where code = " + codeFamille;
		ResultSet rs = DataBaseConnection.executionQuery(req);
		while(rs.next())
        {        	
			currentFamilleProduit = new FamilleProduit(rs.getInt(1),rs.getString(2));
        }
		return currentFamilleProduit;
	}
	public boolean ajouterFamilleProduit() throws HeadlessException, SQLException
	{
		String req = "INSERT INTO `familleproduit`(`codeFamille`, `designationFamille`)  VALUES (' "+ codeFamille +" ' ,'" + designationFamille+ "' )"; 
		
		//String req1 = "INSERT INTO `produit`( `name`, `password`) VALUES (' "+name+" ',' "+password+" ')");
		
		if(DataBaseConnection.executionUpdate(req) >0)
			return true;
		return false;
		
	}
	
}
