package model;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DataBaseConnection;

public class Entreprise {
	private String matriculeFiscale;
	private String raisonSociale;
	private String type;
	private String description;
	private String adresse;
	private int telephoneFixe;
	private int telephoneMobile;
	private int fax;
	private String email;
	private String website;
	private String etatFiscale;
	public Entreprise(String matriculeFiscale, String raisonSociale, String type, String description, String adresse,
			int telephoneFixe, int telephoneMobile, int fax, String email, String website, String etatFiscale) {
		super();
		this.matriculeFiscale = matriculeFiscale;
		this.raisonSociale = raisonSociale;
		this.type = type;
		this.description = description;
		this.adresse = adresse;
		this.telephoneFixe = telephoneFixe;
		this.telephoneMobile = telephoneMobile;
		this.fax = fax;
		this.email = email;
		this.website = website;
		this.etatFiscale = etatFiscale;
	}
	public String getMatriculeFiscale() {
		return matriculeFiscale;
	}
	public void setMatriculeFiscale(String matriculeFiscale) {
		this.matriculeFiscale = matriculeFiscale;
	}
	public String getRaisonSociale() {
		return raisonSociale;
	}
	public void setRaisonSociale(String raisonSociale) {
		this.raisonSociale = raisonSociale;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getTelephoneFixe() {
		return telephoneFixe;
	}
	public void setTelephoneFixe(int telephoneFixe) {
		this.telephoneFixe = telephoneFixe;
	}
	public int getTelephoneMobile() {
		return telephoneMobile;
	}
	public void setTelephoneMobile(int telephoneMobile) {
		this.telephoneMobile = telephoneMobile;
	}
	public int getFax() {
		return fax;
	}
	public void setFax(int fax) {
		this.fax = fax;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getEtatFiscale() {
		return etatFiscale;
	}
	public void setEtatFiscale(String etatFiscale) {
		this.etatFiscale = etatFiscale;
	}
	
	public boolean ajouterEntreprise() throws HeadlessException, SQLException
	{
		String req = "INSERT INTO `entreprise`(`matriculeFiscale`, `raisonSociale`, `type`, `description`, `adresse`, `telephoneFixe`, `telephoneMobile`, `fax`, `email`, `website`, `etatFiscale`)  VALUES (' "+ matriculeFiscale +" ' ,'" + raisonSociale+ "'  ,'" +  type + "' ,'" + description+ "' ,'"+adresse+ "'," + telephoneFixe +  "," + telephoneMobile+ "," + fax + "," + email + "," + website + "," + etatFiscale+ ")"; 
		
		//String req1 = "INSERT INTO `produit`( `name`, `password`) VALUES (' "+name+" ',' "+password+" ')");
		
		if(DataBaseConnection.executionUpdate(req) >0)
			return true;
		return false;
		
	}
	public static Entreprise getAllEntreprise() throws HeadlessException, SQLException
	{
		Entreprise entreprises= null;
		String req= "SELECT * FROM entreprise ";
		ResultSet rs= DataBaseConnection.executionQuery(req);
		while(rs.next())
		{
			entreprises= new Entreprise(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getString(9),rs.getString(10),rs.getString(11));
		}
	   return entreprises;
	}
}
