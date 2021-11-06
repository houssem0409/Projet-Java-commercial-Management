package model;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import database.DataBaseConnection;

public class LigneBonLivraison {
	private int idProduit;
	private int quantite;
    private int idBonLivraison;
    public LigneBonLivraison() {
    	
    }
	public LigneBonLivraison(int idProduit, int quantite, int idBonLivraison) {
		super();
		this.idProduit = idProduit;
		this.quantite = quantite;
		this.idBonLivraison = idBonLivraison;
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
		return idBonLivraison;
	}
	public void setIdBonReception(int idBonReception) {
		this.idBonLivraison = idBonReception;
	}
    
    
	
	public boolean ajouterLigneBonLivraison() throws HeadlessException, SQLException
	{
		String req = "INSERT INTO `lignebonlivraison`(`idProduit`, `quantite`, `idBonLivraison`)  VALUES (' "+ idProduit +" ' ,'" + quantite + "'  ,'" + idBonLivraison+ "' )"; 
		
		//String req1 = "INSERT INTO `produit`( `name`, `password`) VALUES (' "+name+" ',' "+password+" ')");
		
		if(DataBaseConnection.executionUpdate(req) >0)
			return true;
		return false;
		
	}

	public boolean editeLigneBonLivraison(int id) throws HeadlessException, SQLException
	{
		
		String req = "UPDATE `LigneBonLivraison` SET `idProduit`='"+idProduit+"',`quantite`='"+quantite+"', `idBonReception`='"+idBonLivraison+"' WHERE id_lignebonlivraison="+id+""; 
		
		if(DataBaseConnection.executionUpdate(req) >0)
			return true;
		return false;
		
	}
	public boolean deleteLigneBonLivraison(int idd) throws HeadlessException, SQLException
	{
		
		String req = "DELETE FROM `lignebonlivraison` WHERE id_lignebonlivraison="+idd+"";
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
		
		int qtess= qtes -qtesN;
		
		String req = "UPDATE `produit` SET `stock`='"+qtess+"' WHERE id_produit="+id+""; 
		
		if(DataBaseConnection.executionUpdate(req) >0)
			return true;
		return false;
		
	}
	



}
