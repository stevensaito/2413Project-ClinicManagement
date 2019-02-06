package application;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PatientViewController {
	
	@FXML Label patientname; 
	@FXML Label title; 
	@FXML Label healthcareid;
	@FXML Label sex;
	@FXML Label phone; 
	@FXML Label mobile;	
	@FXML Label email;
	@FXML Label address;
	@FXML Label ename;
	@FXML Label enumber;
	@FXML Label prescriptions;
	@FXML Label aprescriptions;
	@FXML Label aconditions;
	@FXML Label pconditions;
	@FXML Label appointment;
	
	Long hid = HomeController.getID();
	
	@FXML public void initialize() throws SQLException{		
		Statement myStmt = Main.conn.createStatement();
		ResultSet rs = myStmt.executeQuery("SELECT * FROM MillenniumHealthClinic.PatientTable WHERE HealthNumber = "+hid);
	
		while(rs.next()){
			String fullname = rs.getString("FirstName").trim()+ " " + rs.getString("LastName").trim();
			
			
			patientname.setText(fullname); 
			title.setText(rs.getString("Title"));
			healthcareid.setText(Long.toString(hid));
			sex.setText(rs.getString("Sex"));
			phone.setText(rs.getString("homePhoneNumber"));
			mobile.setText(rs.getString("Mobile"));;	
			email.setText(rs.getString("Email"));
			address.setText(rs.getString("HomeAddress"));
			ename.setText(rs.getString("EmergencyName"));
			enumber.setText(rs.getString("EmergencyNumber"));
			prescriptions.setText(rs.getString("PreviousPrescriptions"));
			aprescriptions.setText(rs.getString("ActivePrescriptions"));
			aconditions.setText(rs.getString("ActiveConditions"));;
			pconditions.setText(rs.getString("PreviousConditions"));;
			appointment.setText("Still need to implement this feature");;
			
		}
	}
	@FXML public void handleEditPatient(ActionEvent event) throws IOException{
		Functions.handleEditPatient(event);
	}

}
