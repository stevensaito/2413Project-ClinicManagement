package application;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class StaffEditController {
	@FXML
	TextField firstname;
	@FXML
	TextField lastname;
	@FXML
	TextField mobile;
	@FXML
	TextField phone;
	@FXML
	TextField address;
	@FXML
	TextField zipcode;
	@FXML
	TextField city;
	@FXML
	TextField email;
	@FXML
	TextField ename;
	@FXML
	TextField enumber;
	@FXML
	Label staffid;
	@FXML
	ChoiceBox<String> sexbox;
	@FXML
	ChoiceBox<String> titlebox;
	@FXML
	ChoiceBox<String> province;
	@FXML
	Button cancelbutton;
	@FXML
	Button updatebutton;

	Integer staff = StaffController.getstaff();
	
	// Combobox options
	ObservableList<String> sexlist = FXCollections.observableArrayList("M", "F", "Other");
	ObservableList<String> titlelist = FXCollections.observableArrayList("", "Mr.", "Mrs.", "Ms.", "Prof.", "Dr.");
	ObservableList<String> provincelist = FXCollections.observableArrayList("BC", "ON", "QC", "NS", "NB", "MB", "PE",
			"SK", "AB", "NL");
	
	
	Long hid = HomeController.hid;
	
	@FXML
	public void initialize() throws SQLException {
		sexbox.getItems().addAll(sexlist);
		titlebox.getItems().addAll(titlelist);
		province.getItems().addAll(provincelist);
		
		Statement myStmt = Main.conn.createStatement();
		ResultSet rs = myStmt.executeQuery("SELECT * FROM MillenniumHealthClinic.Staff WHERE StaffID = "+staff);
	
		while(rs.next()){	
			String prov = rs.getString("Province").trim();
			String sex = rs.getString("Sex").trim();
			String title = rs.getString("Title").trim();
			
			sexbox.setValue(sex);
			titlebox.setValue(title);
			province.setValue(prov);
			
			firstname.setText(rs.getString("FirstName")); 
			lastname.setText(rs.getString("LastName"));
			
			
			staffid.setText(rs.getString("Staffid"));
			phone.setText(rs.getString("PhoneNumber"));
			mobile.setText(rs.getString("Mobile"));;	
			email.setText(rs.getString("Email"));
			zipcode.setText(rs.getString("ZipCode"));
			city.setText(rs.getString("City"));
			address.setText(rs.getString("HomeAddress"));
			ename.setText(rs.getString("EmergencyName"));
			enumber.setText(rs.getString("EmergencyNumber"));
			
		}
	}		
	
	@FXML
	public void handleUpdateStaff(ActionEvent event) throws SQLException, IOException {
		if ( phone.getText().trim().isEmpty() || mobile.getText().trim().isEmpty()
				|| address.getText().trim().isEmpty() || email.getText().trim().isEmpty() 
				|| enumber.getText().trim().isEmpty() || lastname.getText().trim().isEmpty()
				|| ename.getText().trim().isEmpty()|| staffid.getText().trim().isEmpty()) {
		JOptionPane.showMessageDialog(null, "Please fill out all the required fields before saving");
		return;
		}
		else{
			Long HomePhone = Long.parseLong(phone.getText());
			Long Mobile = Long.parseLong(mobile.getText());
			String Email = email.getText();
			String City = city.getText();
			String FirstName = firstname.getText();
			String LastName = lastname.getText();
			String ZipCode = zipcode.getText();
			String HomeAddress = address.getText();
			Long EmergencyNumber = Long.parseLong(enumber.getText());
			String EmergencyName = ename.getText();
			String Title = (String) titlebox.getSelectionModel().getSelectedItem();
			String Province = (String) province.getSelectionModel().getSelectedItem();
			String Sex = (String) sexbox.getSelectionModel().getSelectedItem();
			
			
			Statement stmt = Main.conn.createStatement();
			stmt.executeUpdate("UPDATE MillenniumHealthClinic.Staff "
					+ "SET PhoneNumber = " + HomePhone + ","
					+ "Email = '" + Email + "',"
					+ "City = '" + City + "',"
					+ "FirstName = '" +FirstName + "', " 
					+ "LastName = '" + LastName + "',"
					+ "ZipCode = '" + ZipCode + "',"
					+ "HomeAddress = '" + HomeAddress + "',"
					+ "EmergencyNumber = " + EmergencyNumber + ","
				//	+ "StaffID = " + StaffID + ","
					+ "EmergencyName = '" + EmergencyName + "',"
					+ "Mobile = " + Mobile + ","
				//	+ "DOB = '" + DOB + "',"
					+ "Title = '" + Title + "',"
					+ "Province = '" + Province + "',"
					+ "Sex = '" + Sex + "'"
					+ " WHERE StaffID =" + staff + ";");
			handleCancelStaff(event);
		}		
		
		
		
		
	}
	
	// press Cancel button
		@FXML
		public void handleCancelStaff(ActionEvent event) throws IOException {
			Stage stage = (Stage) cancelbutton.getScene().getWindow();
			stage.close();
		}
}

