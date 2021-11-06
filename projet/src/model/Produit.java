package model;

import java.awt.HeadlessException;
import java.sql.SQLException;
import java.sql.Statement;
import controller.Connection;
import database.DataBaseConnection;
import database.DataBaseTableNames;


public class Produit {
	
	private String reference;
	private String designation;
	private String uniteMesure;
	private String fournisseur;
	private String  familleProduit;
	int stock;
	int stockMinimale;
	int prixUnitaireHTaxe;
	double tva;
	Connection cnx= new Connection();
	public Produit() {
		
	}
	public Produit(String reference, String designation, String uniteMesure, String fournisseur,
			String familleProduit, int stock,int stockMinimale, int prixUnitaireHTaxe, double tva) {
		super();
		
		this.reference = reference;
		this.designation = designation;
		this.uniteMesure = uniteMesure;
		this.fournisseur = fournisseur;
		this.familleProduit = familleProduit;
		this.stock = stock;
		this.stockMinimale=stockMinimale;
		this.prixUnitaireHTaxe = prixUnitaireHTaxe;
		this.tva = tva;
	}
	
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getUniteMesure() {
		return uniteMesure;
	}
	public void setUniteMesure(String uniteMesure) {
		this.uniteMesure = uniteMesure;
	}
	public String getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(String fournisseur) {
		this.fournisseur = fournisseur;
	}
	public String getFamilleProduit() {
		return familleProduit;
	}
	public void setFamilleProduit(String familleProduit) {
		this.familleProduit = familleProduit;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getStockMinimale() {
		return stockMinimale;
	}
	public void setStockMinimale(int stockMinimale) {
		this.stockMinimale = stockMinimale;
	}
	public int getPrixUnitaireHTaxe() {
		return prixUnitaireHTaxe;
	}
	public void setPrixUnitaireHTaxe(int prixUnitaireHTaxe) {
		this.prixUnitaireHTaxe = prixUnitaireHTaxe;
	}
	public double getTva() {
		return tva;
	}
	public void setTva(double tva) {
		this.tva = tva;
	}
	
	/* public boolean ajouterProduit(Produit prod ) throws HeadlessException, SQLException
	{
		 st = cnx.createStatement();
		String req = "INSERT INTO `produit`( `id_produit`, `reference`, `designation`"
                + ",`fournisseur`, `famille_produit`, `stock`"+ ",`prix`, `tva`) "
                + "VALUES ('" + prod.idProduit + "'," + "'" + prod.reference+ "','" + prod.designation + "'"
                + ",'" + prod.fournisseur + "','" + prod.familleProduit + "','" + prod.stock + "','" + prod.prixUnitaireHTaxe+"' , '" +prod.tva+"' )";
		
		if(DataBaseConnection.executionUpdate(req) >0)
			return true;
		return false;
		
	}*/
	
	public boolean ajouterProduit() throws HeadlessException, SQLException
	{
		String req = "INSERT INTO `produit`(`reference`, `designation`, `uniteMesure`, `fournisseur`, `famille_produit`, `stock`,`stockMinimale`, `prix`, `tva`)  VALUES (' "+ reference +" ' ,'" + designation + "'  ,'" +  uniteMesure + "' ,'" +  fournisseur+ "' ,'"+familleProduit+ "'," + stock +  "," + stockMinimale+  "," + prixUnitaireHTaxe + "," + tva + ")"; 
		
		//String req1 = "INSERT INTO `produit`( `name`, `password`) VALUES (' "+name+" ',' "+password+" ')");
		
		if(DataBaseConnection.executionUpdate(req) >0)
			return true;
		return false;
		
	}

	public boolean editeProduit(int id) throws HeadlessException, SQLException
	{
		
		String req = "UPDATE `produit` SET `reference`='"+reference+"',`designation`='"+designation+"', `uniteMesure`='"+uniteMesure+"',`fournisseur`='"+fournisseur+"', `famille_produit`='"+familleProduit+"',`stock`='"+stock+"', `stockMinimale`='"+stockMinimale+"',`prix`='"+prixUnitaireHTaxe+"' ,`tva`='"+tva+"' WHERE id_produit="+id+""; 
		
		if(DataBaseConnection.executionUpdate(req) >0)
			return true;
		return false;
		
	}
	public boolean deleteProduit(int idd) throws HeadlessException, SQLException
	{
		
		String req = "DELETE FROM `produit` WHERE id_produit="+idd+"";
		if(DataBaseConnection.executionUpdate(req) >0)
			return true;
		return false;
		
	}
	

}
