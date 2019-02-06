package application;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Scanner;

import javax.swing.JOptionPane;


	public class AddAppointmentController {
		
		@FXML Label username; 
		@FXML ChoiceBox<Integer> starthourtimebox;
		@FXML ChoiceBox<Integer> startminutetimebox; 
		@FXML ChoiceBox<String> durationtimebox;
        @FXML ChoiceBox<String> doctorbox; 
        @FXML DatePicker datepicker;
        @FXML TextField name;
        @FXML TextField healthcareid;
		
        //defining combobox values
		ObservableList<Integer> hourList = FXCollections.observableArrayList(01,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24);
		ObservableList<Integer> minutelist = FXCollections.observableArrayList(00,05,10,15,20,25,30,35,40,45,50,55);
		ObservableList<String>durationlist = FXCollections.observableArrayList("10","30","60");
		
		public static ObservableList<String> listdoctor = FXCollections.observableArrayList();
		
		//gets doctor's names from database
		public void fillList(ObservableList<String> listdoctor) throws SQLException{
		Statement stmt = Main.conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM MillenniumHealthClinic.Staff WHERE Role = 3");
		while(rs.next()){
			String name = rs.getString("LastName");
			name = name.trim();
			Integer id = Integer.parseInt(rs.getString("StaffID"));
			String joined = "Dr. " + name + " - Staff ID: " + id; 
			listdoctor.add(joined);
		}
		}
		
		
		@FXML
		public void initialize() throws SQLException{ 	
			durationtimebox.setValue("10 minutes");
			durationtimebox.getItems().addAll(durationlist);
		    starthourtimebox.getItems().addAll(hourList);
		    startminutetimebox.getItems().addAll(minutelist); 
		    //initialize doctorlist 
		    fillList(listdoctor);
		    doctorbox.getItems().addAll(listdoctor);
		}
		
	
	
	
	 @FXML public void handleSaveAppointment(ActionEvent event) throws IOException, SQLException, ParseException{
		
		Long ihealthnumber;
		Integer istarthour; 
		Integer istartminute;
		String iduration; 
		LocalDate idate; 
		String iname;  
		Long ihealthcareid; 
		String idoctor; 
		String istarttime;
		DayOfWeek iweekday; 
		Integer id;
		
		
		//show warning if one of the required fields is empty
		if(name.getText().trim().isEmpty() || 
				name.getText().trim().isEmpty() || 
				datepicker.getValue() == null || 
				starthourtimebox.getSelectionModel().getSelectedItem() == null || 
				startminutetimebox.getSelectionModel().getSelectedItem() == null || 
				durationtimebox.getSelectionModel().getSelectedItem() == null ){
			
			JOptionPane.showMessageDialog(null, "Please fill your name");
			return; 
		}
		
		else{
			idate = datepicker.getValue();
			istarthour = starthourtimebox.getSelectionModel().getSelectedItem();
			istartminute = startminutetimebox.getSelectionModel().getSelectedItem();
			iduration = durationtimebox.getSelectionModel().getSelectedItem();
			iname = name.getText();
			ihealthcareid = Long.parseLong(healthcareid.getText());
			idoctor = doctorbox.getSelectionModel().getSelectedItem();
		
			//SimpleDateFormat istarttime = new SimpleDateFormat("H:m");
			//define start time 
			String test = istarthour.toString() + ":" + istartminute.toString(); 
			System.out.println(test);
			iweekday = idate.getDayOfWeek();
			
			// Get end time
			//Appointment end = new Appointment();
			String result = iduration;
			String endTime = Appointment.duration(istarthour, istartminute, result);
			
			// Get start time
			//int startTime = istarthour + istartminute;
			
			//extract Staff ID out of doctor name and turn to integer
			String numberOnly= idoctor.replaceAll("[^0-9]", "");
			id = Integer.parseInt(numberOnly);
			
			//test if healthcareid is in system, if not, create new Patient
			Boolean existance = false; 
			Statement stmt = Main.conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM MillenniumHealthClinic.PatientTable WHERE HealthNumber =" +ihealthcareid+";");
			while (rs.next()) {
				System.out.println("In Query");
				existance = true;
			}
			if(existance == true){
				System.out.println("in if");
				Functions.handleCreateAppointment(iweekday, idate, test, id, ihealthcareid, iname, endTime);
			}
			else{
				System.out.println("In else case");
				stmt.executeUpdate("INSERT INTO MillenniumHealthClinic.PatientTable(HealthNumber) VALUES (" +ihealthcareid+");");
				/* stmt.executeUpdate("INSERT INTO MillenniumHealthClinic.PatientTable(EndTime) VALUES ("+endTime+") "
						+ "WHERE HealthNumber = " + ihealthcareid+";"); */
				Functions.handleCreateAppointment(iweekday, idate, test,id, ihealthcareid, iname, endTime);
				// JOptionPane.showMessageDialog(null, "A new Patient has been added to the System");
				System.out.println("Pass");
			}
			//After creating Appointment, clear all the textfields by reloading view
			Functions.handleAppointment(event);
		} 
	 }
	 //(DayOfWeek, NumericDate, StartTime, StaffID, HealthNumber, Name)
	}
			
	
