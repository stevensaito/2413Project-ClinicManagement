package application;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class StaffViewController {
	
	@FXML Label staffname; 
	@FXML Label title; 
	@FXML Label staffid;
	@FXML Label sex;
	@FXML Label phone; 
	@FXML Label mobile;	
	@FXML Label email;
	@FXML Label address;
	@FXML Label ename;
	@FXML Label enumber;
	@FXML Label role;
	
	Integer staff = StaffController.getstaff();
	
	@FXML public void initialize() throws SQLException{
		Statement myStmt = Main.conn.createStatement();
		ResultSet rs = myStmt.executeQuery("SELECT * FROM MillenniumHealthClinic.Staff WHERE StaffID = "+staff);
	
		while(rs.next()){		
			String fullName = rs.getString("FirstName").trim()+ " " + rs.getString("LastName").trim();
			
			staffname.setText(fullName); 
			title.setText(rs.getString("Title"));
			staffid.setText(Long.toString(staff));
			sex.setText(rs.getString("Sex"));
			phone.setText(rs.getString("PhoneNumber"));
			mobile.setText(rs.getString("Mobile"));;	
			email.setText(rs.getString("Email"));
			address.setText(rs.getString("HomeAddress"));
			ename.setText(rs.getString("EmergencyName"));
			enumber.setText(rs.getString("EmergencyNumber"));
			role.setText(rs.getString("Role"));
			
		}
	}
		@FXML public void handleEditStaff(ActionEvent event) throws IOException {
			Functions.handleEditStaff(event);
		}
}

