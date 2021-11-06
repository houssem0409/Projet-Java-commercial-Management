package model;

import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.Date;

import database.DataBaseConnection;

public class BonReception {
	private String code;
	private int idFournisseur;
	private String dateBon;
	private String dateReception;
	private String adresseRecp;
	private int numCommande;
	private int idLigneBonRecp;
	private int idFactureFournisseur;
	
	public BonReception() {
		
		
	}
	public BonReception(String code, int idFournisseur, String dateBon, String dateReception, String adresseRecp,
			int numCommande, int idLigneBonRecp, int idFactureFournisseur) {
		super();
		this.code = code;
		this.idFournisseur = idFournisseur;
		this.dateBon = dateBon;
		this.dateReception = dateReception;
		this.adresseRecp = adresseRecp;
		this.numCommande = numCommande;
		this.idLigneBonRecp = idLigneBonRecp;
		this.idFactureFournisseur = idFactureFournisseur;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getIdFournisseur() {
		return idFournisseur;
	}
	public void setIdFournisseur(int idFournisseur) {
		this.idFournisseur = idFournisseur;
	}
	public String getDateBon() {
		return dateBon;
	}
	public void setDateBon(String dateBon) {
		this.dateBon = dateBon;
	}
	public String getDateReception() {
		return dateReception;
	}
	public void setDateReception(String dateReception) {
		this.dateReception = dateReception;
	}
	public String getAdresseRecp() {
		return adresseRecp;
	}
	public void setAdresseRecp(String adresseRecp) {
		this.adresseRecp = adresseRecp;
	}
	public int getNumCommande() {
		return numCommande;
	}
	public void setNumCommande(int numCommande) {
		this.numCommande = numCommande;
	}
	public int getIdLigneBonRecp() {
		return idLigneBonRecp;
	}
	public void setIdLigneBonRecp(int idLigneBonRecp) {
		this.idLigneBonRecp = idLigneBonRecp;
	}
	public int getIdFactureFournisseur() {
		return idFactureFournisseur;
	}
	public void setIdFactureFournisseur(int idFactureFournisseur) {
		this.idFactureFournisseur = idFactureFournisseur;
	}
	
	public boolean ajouterBonReception() throws HeadlessException, SQLException
	{
		String req = "INSERT INTO `bonreception`(`code`, `idFournisseur`, `dateBon`, `dateReception`, `adresseRecp`, `numCommande`,`idLigneBonRecp`, `idFactureFournisseur`)  VALUES (' "+ code +" ' ,'" + idFournisseur + "'  ,'" +  dateBon + "' ,'" +  dateReception+ "' ,'"+adresseRecp+ "'," + numCommande+  "," + idLigneBonRecp+  "," + idFactureFournisseur + ")"; 
		
		//String req1 = "INSERT INTO `produit`( `name`, `password`) VALUES (' "+name+" ',' "+password+" ')");
		
		if(DataBaseConnection.executionUpdate(req) >0)
			return true;
		return false;
		
	}
	public boolean editeBonReception(int id) throws HeadlessException, SQLException
	{
		
		String req = "UPDATE `bonreception` SET `code`='"+code+"',`idFournisseur`='"+idFournisseur+"', `datebon`='"+dateBon+"',`dateReception`='"+dateReception+"', `adresseRecp`='"+adresseRecp+"',`numCommande`='"+numCommande+"', `idLigneBonRecp`='"+idLigneBonRecp+"',`idFactureFournisseur`='"+idFactureFournisseur+"'  WHERE id_bonreception="+id+""; 
		
		if(DataBaseConnection.executionUpdate(req) >0)
			return true;
		return false;
		
	}
	public boolean deleteBonReception(int idd) throws HeadlessException, SQLException
	{
		
		String req = "DELETE FROM `bonreception` WHERE id_BonReception="+idd+"";
		if(DataBaseConnection.executionUpdate(req) >0)
			return true;
		return false;
		
	}

}
