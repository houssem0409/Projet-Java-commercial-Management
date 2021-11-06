package model;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import database.DataBaseConnection;

public class LigneBonReception {
	private int idProduit;
	private int quantite;
    private int idBonReception;
    public LigneBonReception() {
    	
    }
	public LigneBonReception(int idProduit, int quantite, int idBonReception) {
		super();
		this.idProduit = idProduit;
		this.quantite = quantite;
		this.idBonReception = idBonReception;
	}
	public int getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public int getIdBonReception() {
		return idBonReception;
	}
	public void setIdBonReception(int idBonReception) {
		this.idBonReception = idBonReception;
	}
	public boolean ajouterLigneBonReception() throws HeadlessException, SQLException
	{
		String req = "INSERT INTO `lignebonreception`(`idProduit`, `quantite`, `idBonReception`)  VALUES (' "+ idProduit +" ' ,'" + quantite + "'  ,'" + idBonReception+ "' )"; 
		
		//String req1 = "INSERT INTO `produit`( `name`, `password`) VALUES (' "+name+" ',' "+password+" ')");
		
		if(DataBaseConnection.executionUpdate(req) >0)
			return true;
		return false;
		
	}

	public boolean editeLigneBonReception(int id) throws HeadlessException, SQLException
	{
		
		String req = "UPDATE `LigneBonReception` SET `idProduit`='"+idProduit+"',`quantite`='"+quantite+"', `idBonReception`='"+idBonReception+"' WHERE id_lignebonreception="+id+""; 
		
		if(DataBaseConnection.executionUpdate(req) >0)
			return true;
		return false;
		
	}
	public boolean deleteLigneBonReception(int idd) throws HeadlessException, SQLException
	{
		
		String req = "DELETE FROM `lignebonreception` WHERE id_lignebonreception="+idd+"";
		if(DataBaseConnection.executionUpdate(req) >0)
			return true;
		return false;
		
	}
	String aa;
	public String qteSelected(int id) throws SQLException {
		Statement stmt;
		stmt = (Statement) DataBaseConnection.connection.createStatement();
		String sq="Select stock from produit where id_produit="+id+"";
		ResultSet result= stmt.executeQuery(sq);
		if(result.next()) {
			 aa= result.getString(1);
			
		}
		return aa;
		
		
	}
	public boolean SustractStock(int id, int qtes,int qtesN) throws HeadlessException, SQLException
	{
		
		int qtess= qtes +qtesN;
		
		String req = "UPDATE `produit` SET `stock`='"+qtess+"' WHERE id_produit="+id+""; 
		
		if(DataBaseConnection.executionUpdate(req) >0)
			return true;
		return false;
		
	}
	

}
