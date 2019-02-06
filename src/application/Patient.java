package application;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Patient {
	
	//if for cred??
	//to prescribe, 
	
	private StringProperty pfname; 
	private StringProperty plname; 
	private LongProperty phID;
	private StringProperty pdateOfBirth;
	private StringProperty ptitle;
	private StringProperty psex;
	private LongProperty phomePhone;
	private LongProperty pmobile;
	private StringProperty paddress;
	private StringProperty pzipCode;
	private StringProperty pcity;
	private StringProperty pprovince;
	private StringProperty pemail;
	private StringProperty peCName;
	private LongProperty peCNumber;
	
	public String getPfname(){
		return pfname.get();
	}
	
	public void setPfname(String pfname){
		this.pfname = new SimpleStringProperty(pfname);		
	}
	
	public String getPlname(){
		return plname.get();
	}
	
	public void setPlname(String plname){
		this.plname = new SimpleStringProperty(plname);		
	}
	
	public Long getPhID(){
		return phID.get();
	}
	
	public void setPhID(Long phID){
		this.phID = new SimpleLongProperty(phID);		
	}
	
	public String getPdateOfBirth(){
		return pdateOfBirth.get();
	}
	
	public void setPdateOfBirth(String pdateOfBirth){
		this.pdateOfBirth = new SimpleStringProperty(pdateOfBirth);		
	}
	
	public String getPtitle(){
		return ptitle.get();
	}
	
	public void setPtitle(String ptitle){
		this.ptitle = new SimpleStringProperty(ptitle);		
	}
	
	public String getPsex(){
		return psex.get();
	}
	
	public void setPsex(String psex){
		this.psex = new SimpleStringProperty(psex);		
	}
	
	public Long getPhomePhone(){
		return phomePhone.get();
	}
	
	public void setPhomePhone(Integer phomePhone){
		this.phomePhone = new SimpleLongProperty(phomePhone);		
	}
	
	public Long getPmobile(){
		return pmobile.get();
	}
	
	public void setPmobile(Integer pmobile){
		this.pmobile = new SimpleLongProperty(pmobile);		
	}
	
	public String getPaddress(){
		return paddress.get();
	}
	
	public void setPaddress(String paddress){
		this.paddress = new SimpleStringProperty(paddress);		
	}
	
	public String getPzipCode(){
		return pzipCode.get();
	}
	
	public void setPzipCode(String pzipCode){
		this.pzipCode = new SimpleStringProperty(pzipCode);		
	}
	
	public String getPcity(){
		return pcity.get();
	}
	
	public void setPcity(String pcity){
		this.pcity = new SimpleStringProperty(pcity);		
	}
	
	public String getPprovince(){
		return pprovince.get();
	}
	
	public void setPprovince(String pprovince){
		this.pprovince = new SimpleStringProperty(pprovince);		
	}
	
	public String getPemail(){
		return pemail.get();
	}
	
	public void setPemail(String pemail){
		this.pemail = new SimpleStringProperty(pemail);		
	}

	public String getPeCName(){
		return peCName.get();
	}
	
	public void setPeCName(String peCName){
		this.peCName = new SimpleStringProperty(peCName);		
	}
	
	public Long getPeCNumber(){
		return peCNumber.get();
	}
	
	public void setPeCNumber(Integer peCNumber){
		this.peCNumber = new SimpleLongProperty(peCNumber);		
	}

	//Constructor
	public Patient(String pfname, String plname, Long phID, String pdateOfBirth, String ptitle,
				String psex, Long phomePhone, Long pmobile, String paddress, String pzipCode,
				String pcity, String pprovince, String pemail, String peCName, Long peCNumber){
		this.pfname = new SimpleStringProperty(pfname);
		this.plname = new SimpleStringProperty(plname);
		this.phID = new SimpleLongProperty(phID);
		this.pdateOfBirth = new SimpleStringProperty(pdateOfBirth);
		this.ptitle = new SimpleStringProperty(ptitle);
		this.psex = new SimpleStringProperty(psex);
		this.phomePhone = new SimpleLongProperty(phomePhone);
		this.pmobile = new SimpleLongProperty(pmobile);
		this.paddress = new SimpleStringProperty(paddress);
		this.pzipCode = new SimpleStringProperty(pzipCode);
		this.pcity = new SimpleStringProperty(pcity);
		this.pprovince = new SimpleStringProperty(pprovince);
		this.pemail = new SimpleStringProperty(pemail);
		this.peCName = new SimpleStringProperty(peCName);
		this.peCNumber = new SimpleLongProperty(peCNumber);
	}
	
	
		//use this function to fill up the table before search function
		public static void fillPatient(ObservableList<Patient>listPatient) throws SQLException{
			Statement stmt = Main.conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM MillenniumHealthClinic.PatientTable");

			while(rs.next()){
				//Integer values need to be tested for NULL values, otherwise ERROR?
				Integer phone; 
				/*Integer mobile; 
				Integer EmergencyNumber; 
				*/
				
				//if(rs.getString("homePhone") != null)
				//	phone = Integer.parseInt(rs.getString("homePhone"));
				//else
				//	phone = 0; 
				/*
				if(rs.getString("Mobile") != null)
					mobile = Integer.parseInt(rs.getString("Mobile"));
				else
					mobile = 0; 
				
				if(rs.getString("EmergencyNumber") != null)
					EmergencyNumber = Integer.parseInt(rs.getString("EmergencyNumber"));
				else
					EmergencyNumber = 0; 
				
				*/
				
			listPatient.add(new Patient(
					rs.getString("FirstName"), 
					rs.getString("LastName"),
					Long.parseLong(rs.getString("HealthNumber")),
					rs.getString("DOB"),
					rs.getString("Title"),
					rs.getString("Sex"),
					Long.parseLong(rs.getString("homePhoneNumber")),
					123L,//Integer.parseInt(rs.getString("Mobile")),
					rs.getString("HomeAddress"),
					rs.getString("ZipCode"),
					rs.getString("City"),
					rs.getString("Province"),
					rs.getString("Email"),
					rs.getString("EmergencyName"),
					1235L//EmergencyNumber
					));
			}

	}


}
