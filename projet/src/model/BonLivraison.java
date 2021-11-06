package model;

import java.awt.HeadlessException;
import java.sql.SQLException;

import database.DataBaseConnection;

public class BonLivraison {

	private String code;
	private String dateBon;
	private String dateLivraison;
	private String adresseBon;
	private int numCommande;
	
	private int idFactureClient;
	
	public BonLivraison() {
		
	}

	
	public BonLivraison(String code, String dateBon, String dateLivraison, String adresseBon, int numCommande,
			int idFactureClient) {
		super();
		this.code = code;
		this.dateBon = dateBon;
		this.dateLivraison = dateLivraison;
		this.adresseBon = adresseBon;
		this.numCommande = numCommande;
		this.idFactureClient = idFactureClient;
	}
	
	
	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getDateBon() {
		return dateBon;
	}


	public void setDateBon(String dateBon) {
		this.dateBon = dateBon;
	}


	public String getDateLivraison() {
		return dateLivraison;
	}


	public void setDateLivraison(String dateLivraison) {
		this.dateLivraison = dateLivraison;
	}


	public String getAdresseBon() {
		return adresseBon;
	}


	public void setAdresseBon(String adresseBon) {
		this.adresseBon = adresseBon;
	}


	public int getNumCommande() {
		return numCommande;
	}


	public void setNumCommande(int numCommande) {
		this.numCommande = numCommande;
	}


	public int getIdFactureClient() {
		return idFactureClient;
	}


	public void setIdFactureClient(int idFactureClient) {
		this.idFactureClient = idFactureClient;
	}


	public boolean ajouterBonLivraison() throws HeadlessException, SQLException
	{
		String req = "INSERT INTO `bonlivraison`(`code`, `dateBon`, `dateLivraison`, `adresseBon`, `numCommande`, `idFactureClient`)  VALUES (' "+ code +" '   ,'" +  dateBon + "' ,'" +  dateLivraison+ "' ,'"+adresseBon+ "'," + numCommande+  "," + idFactureClient + ")"; 
		
		//String req1 = "INSERT INTO `produit`( `name`, `password`) VALUES (' "+name+" ',' "+password+" ')");
		
		if(DataBaseConnection.executionUpdate(req) >0)
			return true;
		return false;
		
	}
	public boolean editeBonLivraison(int id) throws HeadlessException, SQLException
	{
		
		String req = "UPDATE `bonlivraison` SET `code`='"+code+"', `datebon`='"+dateBon+"',`dateLivraison`='"+dateLivraison+"', `adresseBon`='"+adresseBon+"',`numCommande`='"+numCommande+"',`idFactureClient`='"+idFactureClient+"'  WHERE id_bonlivraison="+id+""; 
		
		if(DataBaseConnection.executionUpdate(req) >0)
			return true;
		return false;
		
	}
	public boolean deleteBonLivraison(int idd) throws HeadlessException, SQLException
	{
		
		String req = "DELETE FROM `bonlivraison` WHERE id_bonlivraison="+idd+"";
		if(DataBaseConnection.executionUpdate(req) >0)
			return true;
		return false;
		
	}

}
