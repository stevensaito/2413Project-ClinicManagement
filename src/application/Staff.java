package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public class Staff {
	private StringProperty sfname; 
	private StringProperty slname; 
	private IntegerProperty sstaffID;
	private StringProperty sdateOfBirth;
	private StringProperty stitle;
	private StringProperty ssex;
	private LongProperty shomePhone;
	private LongProperty smobile;
	private StringProperty saddress;
	private StringProperty szipCode;
	private StringProperty scity;
	private StringProperty sprovince;
	private StringProperty semail;
	private IntegerProperty srole;
	
	public String getSfname(){
		return sfname.get();
	}
	
	public void setSfname(String sfname){
		this.sfname = new SimpleStringProperty(sfname);		
	}
	
	public String getSlname(){
		return slname.get();
	}
	
	public void setSlname(String slname){
		this.slname = new SimpleStringProperty(slname);		
	}
	
	public Integer getSstaffID(){
		return sstaffID.get();
	}
	
	public void setSstaffID(Integer sstaffID){
		this.sstaffID = new SimpleIntegerProperty(sstaffID);		
	}
	
	public String getSdateOfBirth(){
		return sdateOfBirth.get();
	}
	
	public void setSdateOfBirth(String sdateOfBirth){
		this.sdateOfBirth = new SimpleStringProperty(sdateOfBirth);		
	}
	
	public String getStitle(){
		return stitle.get();
	}
	
	public void setStitle(String stitle){
		this.stitle = new SimpleStringProperty(stitle);		
	}
	
	public String getSsex(){
		return ssex.get();
	}
	
	public void setSsex(String ssex){
		this.ssex = new SimpleStringProperty(ssex);		
	}
	
	public Long getShomePhone(){
		return shomePhone.get();
	}
	
	public void setShomePhone(Integer shomePhone){
		this.shomePhone = new SimpleLongProperty(shomePhone);		
	}
	
	public Long getSmobile(){
		return smobile.get();
	}
	
	public void setSmobile(Integer smobile){
		this.smobile = new SimpleLongProperty(smobile);		
	}
	
	public String getSaddress(){
		return saddress.get();
	}
	
	public void setSaddress(String saddress){
		this.saddress = new SimpleStringProperty(saddress);		
	}
	
	public String getSzipCode(){
		return szipCode.get();
	}
	
	public void setSzipCode(String szipCode){
		this.szipCode = new SimpleStringProperty(szipCode);		
	}
	
	public String getScity(){
		return scity.get();
	}
	
	public void setScity(String scity){
		this.scity = new SimpleStringProperty(scity);		
	}
	
	public String getSprovince(){
		return sprovince.get();
	}
	
	public void setSprovince(String sprovince){
		this.sprovince = new SimpleStringProperty(sprovince);		
	}
	
	public String getSemail(){
		return semail.get();
	}
	
	public void setSemail(String semail){
		this.semail = new SimpleStringProperty(semail);		
	}

	public Integer getSrole(){
		return srole.get();
	}
	
	public void setSrole(Integer srole){
		this.srole = new SimpleIntegerProperty(srole);		
	}

	//Constructor
	public Staff(String sfname, String slname, Integer sstaffID, String stitle,
				String ssex, Long shomePhone, Long smobile, String saddress, String szipCode,
				String scity, String sprovince, String semail, Integer srole){
		this.sfname = new SimpleStringProperty(sfname);
		this.slname = new SimpleStringProperty(slname);
		this.sstaffID = new SimpleIntegerProperty(sstaffID);
		this.stitle = new SimpleStringProperty(stitle);
		this.ssex = new SimpleStringProperty(ssex);
		this.shomePhone = new SimpleLongProperty(shomePhone);
		this.smobile = new SimpleLongProperty(smobile);
		this.saddress = new SimpleStringProperty(saddress);
		this.szipCode = new SimpleStringProperty(szipCode);
		this.scity = new SimpleStringProperty(scity);
		this.sprovince = new SimpleStringProperty(sprovince);
		this.semail = new SimpleStringProperty(semail);
		this.srole = new SimpleIntegerProperty(srole);
	}
	
	
		public static void fillStaff(ObservableList<Staff>listStaff){
		//	listStaff.add(new Staff("Luise", "Middel", 3, "Ms", "F", 345678, 234567, "Test","Test","Test","Test","Test"));
		


	}


}
