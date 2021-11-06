package model;

import java.awt.HeadlessException;
import java.sql.SQLException;

import database.DataBaseConnection;

public class FactureFournisseur {

	private String code;
	private String dateFacture;
	private String modePayement;
	private String type;
	public FactureFournisseur() {
		
	}
	public FactureFournisseur(String code, String dateFacture, String modePayement, String type) {
		super();
		this.code = code;
		this.dateFacture = dateFacture;
		this.modePayement = modePayement;
		this.type = type;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDateFacture() {
		return dateFacture;
	}
	public void setDateFacture(String dateFacture) {
		this.dateFacture = dateFacture;
	}
	public String getModePayement() {
		return modePayement;
	}
	public void setModePayement(String modePayement) {
		this.modePayement = modePayement;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public boolean ajouterFacture() throws HeadlessException, SQLException
	{
		String req = "INSERT INTO `facturefournisseur`(`code`, `dateFacture`, `modePayement`, `typeFacture`)  VALUES (' "+ code +" ' ,'" + dateFacture + "'  ,'" + modePayement + "' ,'" + type+ "' )"; 
		
		//String req1 = "INSERT INTO `produit`( `name`, `password`) VALUES (' "+name+" ',' "+password+" ')");
		
		if(DataBaseConnection.executionUpdate(req) >0)
			return true;
		return false;
		
	}
	public boolean editeFacture(int id) throws HeadlessException, SQLException
	{
		
		String req = "UPDATE `facturefournisseur` SET `code`='"+code+"',`dateFacture`='"+dateFacture+"', `modePayement`='"+modePayement+"',`typeFacture`='"+type+"'  WHERE id_facturefournisseur="+id+""; 
		
		if(DataBaseConnection.executionUpdate(req) >0)
			return true;
		return false;
		
	}
	public boolean deleteFacture(int idd) throws HeadlessException, SQLException
	{
		
		String req = "DELETE FROM `facturefournisseur` WHERE id_facturefournisseur="+idd+"";
		if(DataBaseConnection.executionUpdate(req) >0)
			return true;
		return false;
		
	}


	
	
}
