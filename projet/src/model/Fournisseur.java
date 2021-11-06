package model;


import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import database.DataBaseConnection;

public class Fournisseur {

	// Les caractéristiques:
	private String codeFournisseur;
	private String matriculeFiscale;
	private String raisonSociale;
	private String adresse;
	private int telephoneFixe;
	private int telephoneMobile;
	private int fax;
	private String email;
	private String website;
	private int etatFiscale; // 1 ou 2 ou 3 (assujiti tva + fodec)
	private int idComptebnq;
	
	public Fournisseur() {
		
	}
	public Fournisseur(String codeFournisseur, String matriculeFiscale, String raisonSociale, String adresse,
			int telephoneFixe, int telephoneMobile, int fax, String email, String website, int etatFiscale , int idComptebnq) {
		super();
		this.codeFournisseur = codeFournisseur;
		this.matriculeFiscale = matriculeFiscale;
		this.raisonSociale = raisonSociale;
		this.adresse = adresse;
		this.telephoneFixe = telephoneFixe;
		this.telephoneMobile = telephoneMobile;
		this.fax = fax;
		this.email = email;
		this.website = website;
		this.etatFiscale = etatFiscale;
		this.idComptebnq=idComptebnq;
	}
	public String getCodeFournisseur() {
		return codeFournisseur;
	}
	public void setCodeFournisseur(String codeFournisseur) {
		this.codeFournisseur = codeFournisseur;
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
	public int getEtatFiscale() {
		return etatFiscale;
	}
	public void setEtatFiscale(int etatFiscale) {
		this.etatFiscale = etatFiscale;
	}
	public int getIdComptebnq() {
		return idComptebnq;
	}
	public void setIdComptebnq(int idComptebnq) {
		this.idComptebnq = idComptebnq;
	}
	/*public static Fournisseur getFournisseur(String codeFournisseur) throws SQLException
	{
	    Fournisseur currentFournisseur = null;
		String req = "select * from Fournisseur where code = '" + codeFournisseur + "'";
		ResultSet rs = DataBaseConnection.executionQuery(req);
		while(rs.next())
        {        	
			currentFournisseur = new Fournisseur(rs.getString(1),rs.getString(1));
        }
		return currentFournisseur;
	}*/
	public boolean ajouterFournisseur() throws HeadlessException, SQLException
	{
		String req = "INSERT INTO `fournisseur`(`codeFournisseur`, `matriculeFiscale`, `raisonSociale`, `adresse`, `telephoneFixe`, `telephoneMobile`, `fax`, `email`,`website`,`etatFiscale`,`id_comptebnq`)  VALUES (' "+ codeFournisseur +" ' ,'" + matriculeFiscale + "'  ,'" +  raisonSociale + "' ,'" + adresse+ "' ,'"+telephoneFixe+ "'," + telephoneMobile +  "," + fax + "," + email + "," + website + "," + etatFiscale + ",'" + idComptebnq + "')"; 
		
		//String req1 = "INSERT INTO `produit`( `name`, `password`) VALUES (' "+name+" ',' "+password+" ')");
		
		if(DataBaseConnection.executionUpdate(req) >0)
			return true;
		return false;
		
	}
	
	public boolean editeFournisseur(int id) throws HeadlessException, SQLException
	{
		
		String req = "UPDATE `fournisseur` SET `codeFournisseur`='"+codeFournisseur+"',`matriculeFiscale`='"+matriculeFiscale+"', `raisonSociale`='"+raisonSociale+"',`adresse`='"+adresse+"', `telephoneFixe`='"+telephoneFixe+"',`telephoneMobile`='"+telephoneMobile+"', `fax`='"+fax+"',`email`='"+email+"' ,`website`='"+website+"',`etatFiscale`='"+etatFiscale+"',`id_comptebnq`='"+idComptebnq+"' WHERE id_fournisseur="+id+""; 
		
		if(DataBaseConnection.executionUpdate(req) >0)
			return true;
		return false;
		
	}
	public boolean deleteFournisseur(int idd) throws HeadlessException, SQLException
	{
		
		String req = "DELETE FROM `fournisseur` WHERE id_fournisseur="+idd+"";
		if(DataBaseConnection.executionUpdate(req) >0)
			return true;
		return false;
		
	}
	
	 /*  public void AllFornisseur(JTable T) {
	        try {
	            
	            String sql = "select * from fornisseur";
	           ResultSet rst = DataBaseConnection.executionQuery(sql);
	            int i = 0, j;

	            while (rst.next()) {
	                j = 0;
	                T.setValueAt(rst.getInt("N_forn"), i, j);
	                j++;
	                T.setValueAt(rst.getString("nom_prenom").toString(), i, j);
	                j++;
	                T.setValueAt(rst.getString("N_telephone").toString(), i, j);
	                j++;
	                T.setValueAt(rst.getString("Adresse").toString(), i, j);
	                j++;
	                T.setValueAt(rst.getString("Ville").toString(), i, j);
	                j++;
	                i++;

	            }

	        } catch (SQLException ex) {
	            Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
	            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
	        }
	    }*/
	
	public static Fournisseur getAllFournisseur() throws HeadlessException, SQLException
	{
		Fournisseur fournisseurs= null;
		String req= "SELECT * FROM 'fournisseur' ";
		ResultSet rs= DataBaseConnection.executionQuery(req);
		while(rs.next())
		{
			fournisseurs= new Fournisseur(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getString(8),rs.getString(9),rs.getInt(10),rs.getInt(11));
		}
	   return fournisseurs;
	}
}
