package model;

import java.awt.HeadlessException;
import java.sql.SQLException;

import database.DataBaseConnection;

public class CompteBancaire {

	private String nomBanque;
	private String agence;
	private double rip;
	public CompteBancaire(String nomBanque, String agence, double rip) {
		super();
		this.nomBanque = nomBanque;
		this.agence = agence;
		this.rip = rip;
	}
	public String getNomBanque() {
		return nomBanque;
	}
	public void setNomBanque(String nomBanque) {
		this.nomBanque = nomBanque;
	}
	public String getAgence() {
		return agence;
	}
	public void setAgence(String agence) {
		this.agence = agence;
	}
	public double getRip() {
		return rip;
	}
	public void setRip(double rip) {
		this.rip = rip;
	}
	
	public boolean ajouterCompteBancaire() throws HeadlessException, SQLException
	{
		String req = "INSERT INTO `comptebancaire`(`nomBanque`, `agence`, `rip`)  VALUES (' "+ nomBanque +" ' ,'" + agence + "'  ,'" +  rip + "' )"; 
		
		//String req1 = "INSERT INTO `produit`( `name`, `password`) VALUES (' "+name+" ',' "+password+" ')");
		
		if(DataBaseConnection.executionUpdate(req) >0)
			return true;
		return false;
		
	}
	
}
