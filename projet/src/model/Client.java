package model;

import java.awt.HeadlessException;
import java.sql.SQLException;

import database.DataBaseConnection;

public class Client {
	private String codeClient;
	private String matriculeFiscale;
	private String raisonSociale;
	private String type;
	private String adresse;
	private int telephoneFixe;
	private int telephoneMobile;
	private int fax;
	private String email;
	private String website;
	private String etatFiscale;
	private int idProduit;
	private int idComptebnq;
	public Client() {
		
	}
	public Client(String codeClient, String matriculeFiscale, String raisonSociale, String type, String adresse,
			int telephoneFixe, int telephoneMobile, int fax, String email, String website, String etatFiscale,
			int idProduit,int idComptebnq) {
		super();
		this.codeClient = codeClient;
		this.matriculeFiscale = matriculeFiscale;
		this.raisonSociale = raisonSociale;
		this.type = type;
		this.adresse = adresse;
		this.telephoneFixe = telephoneFixe;
		this.telephoneMobile = telephoneMobile;
		this.fax = fax;
		this.email = email;
		this.website = website;
		this.etatFiscale = etatFiscale;
		this.idProduit = idProduit;
		this.idComptebnq=idComptebnq;
	}
	public String getCodeClient() {
		return codeClient;
	}
	public void setCodeClient(String codeClient) {
		this.codeClient = codeClient;
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
	public int getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}
	public int getIdComptebnq() {
		return idComptebnq;
	}
	public void setIdComptebnq(int idComptebnq) {
		this.idComptebnq = idComptebnq;
	}

	public boolean ajouterClient() throws HeadlessException, SQLException
	{
		String req = "INSERT INTO `client`(`codeClient`, `matriculeFiscale`, `raisonSociale`,  `type`, `adresse`, `telephoneFixe`, `telephoneMobile`, `fax`, `email`,`website`,`etatFiscale`,`id_produit`,`id_comptebnq`)  VALUES (' "+ codeClient +" ' ,'" + matriculeFiscale + "'  ,'" +  raisonSociale + "' ,'" +  type + "' ,'" + adresse+ "' ,'"+telephoneFixe+ "','" + telephoneMobile +  "','" + fax + "','" + email + "','" + website + "','" + etatFiscale + "','"+ idProduit +"','"+ idComptebnq +"')"; 
		
		//String req1 = "INSERT INTO `produit`( `name`, `password`) VALUES (' "+name+" ',' "+password+" ')");
		
		if(DataBaseConnection.executionUpdate(req) >0)
			return true;
		return false;
		
	}
	public boolean editeClient(int id) throws HeadlessException, SQLException
	{
		
		String req = "UPDATE `client` SET `codeClient`='"+codeClient+"',`matriculeFiscale`='"+matriculeFiscale+"', `raisonSociale`='"+raisonSociale+"',`type`='"+type+"', `adresse`='"+adresse+"',`telephoneFixe`='"+telephoneFixe+"', `telephoneMobile`='"+telephoneMobile+"',`fax`='"+fax+"' ,`email`='"+email+"',`website`='"+website+"',`etatFiscale`='"+etatFiscale+"',`id_produit`='"+idProduit+"',`id_comptebnq`='"+idComptebnq+"' WHERE id_Client="+id+""; 
		
		if(DataBaseConnection.executionUpdate(req) >0)
			return true;
		return false;
		
	}
	public boolean deleteClient(int idd) throws HeadlessException, SQLException
	{
		
		String req = "DELETE FROM `client` WHERE id_client="+idd+"";
		if(DataBaseConnection.executionUpdate(req) >0)
			return true;
		return false;
		
	}

}
