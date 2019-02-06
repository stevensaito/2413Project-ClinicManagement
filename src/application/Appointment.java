package application;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public class Appointment {
	
	private StringProperty aweekday; 
	private StringProperty atime; 
	private StringProperty atimeEnd;
	private StringProperty apatient; 
	private LongProperty ahealthcareid;
	private IntegerProperty astaffid;
	
	public String getAweekday(){
		return aweekday.get();
	}
	
	public void setAweekday(String aweekday){
		this.aweekday = new SimpleStringProperty(aweekday);		
	}
	
	public String getAtime(){
		return atime.get();
	}
	
	public void setAtime(String atime){
		this.atime = new SimpleStringProperty(atime);		
	}
	
	public String getAtimeEnd(){
		return atimeEnd.get();
	}
	
	public void setAtimeEnd(String atimeEnd){
		this.atimeEnd = new SimpleStringProperty(atimeEnd);		
	}
	
	public Long getAhealthcareid(){
		return ahealthcareid.get();
	}
	
	public void setAhealthcareid(Long ahealthcareid){
		this.ahealthcareid = new SimpleLongProperty(ahealthcareid);		
	}
	
	public Integer getAstaffid(){
		return astaffid.get();
	}
	
	public void setAstaffid(Integer astaffid){
		this.astaffid = new SimpleIntegerProperty(astaffid);		
	}
	
	public String getApatient(){
		return apatient.get();
	}
	
	public void setApatient(String apatient){
		this.apatient = new SimpleStringProperty(apatient);		
	}
	
	
	//Constructor
	public Appointment(String aweekday, String atime, String atimeEnd, String apatient, Long ahealthcareid, Integer astaffid){
		this.aweekday = new SimpleStringProperty(aweekday);
		this.atime = new SimpleStringProperty(atime);
		this.atimeEnd = new SimpleStringProperty(atimeEnd);
		this.apatient = new SimpleStringProperty(apatient);
		this.ahealthcareid = new SimpleLongProperty(ahealthcareid);
		this.astaffid = new SimpleIntegerProperty(astaffid);
		
	}
	
	public Appointment() {
		// TODO Auto-generated constructor stub
	}

	public static void fillAppointment(ObservableList<Appointment> listAppointment) throws SQLException{
		Statement stmt = Main.conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM MillenniumHealthClinic.Calendar");
		while(rs.next()){
			//Can be deleted once all values in the database != null
			Long healthcareid;
			Integer staff;
			if(rs.getString("HealthNumber") == null)
			{
				healthcareid = 0L; 
			}
			else{
				healthcareid = Long.parseLong(rs.getString("HealthNumber"));
			}
			if(rs.getString("StaffID") == null)
			{
				staff = 0; 
			}
			else{
				staff = Integer.parseInt(rs.getString("StaffID"));
			}
			listAppointment.add(new Appointment(
					rs.getString("DayOfWeek"), 
					rs.getString("StartTime"),
					rs.getString("EndTime"),
					rs.getString("Name"),
					healthcareid,
					staff
					));
		}
	}


	// Method for taking the start time of appointment, converting to int, adding duration
	// and returning the string back
	public static String duration (int hour, int minute, int result) throws ParseException {
		
		// Variables
		String endTime = "";
		int endTimeInt = 0;
		String startTimePassed = hour + ":" + minute;
		int duration = result;
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
		Date d = (Date) dateFormat.parse(startTimePassed); 
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		calendar.add(Calendar.MINUTE, result);
		String newTime = dateFormat.format(calendar.getTime());
		
		return newTime;
	}

	public static String duration(Integer istarthour, Integer istartminute, String result) {
		// TODO Auto-generated method stub
		return null;
	} 
} 
	// get time from GUI
/*	public void time() {
		String time = timetextfield.getText(); 
		String start = " ";
		if(timetextfield.getText().trim().isEmpty()){
			start = null;
		}
		else{
			start =  Integer.parseInt(timetextfield.getText()); 
		}*/

	
	/* TEST 
	 * one
	 * two
	 * three*/

