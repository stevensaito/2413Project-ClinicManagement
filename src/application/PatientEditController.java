package application;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

public class PatientEditController {
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
	Label healthcareid;
	@FXML
	TextField aprescription;
	@FXML
	TextField pprescription;
	@FXML
	TextField ccondition;
	@FXML
	TextField pcondition;
	@FXML
	ChoiceBox<String> sexbox;
	@FXML
	ChoiceBox<String> titlebox;
	@FXML
	ChoiceBox<String> province;
	@FXML
	DatePicker datepicker;
	@FXML
	Button cancelbutton;
	@FXML
	Button updatebutton;

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
		//province.setValue("BC");
		province.getItems().addAll(provincelist);
		
		Statement myStmt = Main.conn.createStatement();
		ResultSet rs = myStmt.executeQuery("SELECT * FROM MillenniumHealthClinic.PatientTable WHERE HealthNumber = "+hid);
		//setting textfields to db value
		while(rs.next()){
			String prov = rs.getString("Province").trim();
			
			//Birthdate string conversion to local date format
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate birthdate = LocalDate.parse(rs.getString("DOB"), dtf);
			
			province.setValue(prov);
			firstname.setText(rs.getString("FirstName")); 
			lastname.setText(rs.getString("LastName"));
			titlebox.setValue(rs.getString("Title"));
			healthcareid.setText(Long.toString(hid));
			sexbox.setValue(rs.getString("Sex"));
			phone.setText(rs.getString("homePhoneNumber"));
			mobile.setText(rs.getString("Mobile"));;	
			email.setText(rs.getString("Email"));
			zipcode.setText(rs.getString("ZipCode"));
			city.setText(rs.getString("City"));
			address.setText(rs.getString("HomeAddress"));
			ename.setText(rs.getString("EmergencyName"));
			enumber.setText(rs.getString("EmergencyNumber"));
			pprescription.setText(rs.getString("PreviousPrescriptions"));
			aprescription.setText(rs.getString("ActivePrescriptions"));
			ccondition.setText(rs.getString("ActiveConditions"));
			pcondition.setText(rs.getString("PreviousConditions"));
			datepicker.setValue(birthdate);
		}
			//appointment.setText("Still need to implement this feature");;
	}		
	
	@FXML
	public void handleUpdatePatient(ActionEvent event) throws SQLException, IOException {
		if ( phone.getText().trim().isEmpty() || datepicker.getValue() == null || mobile.getText().trim().isEmpty()
				|| address.getText().trim().isEmpty() || email.getText().trim().isEmpty() 
				|| enumber.getText().trim().isEmpty() || lastname.getText().trim().isEmpty() || firstname.getText().trim().isEmpty()
				|| ename.getText().trim().isEmpty()|| healthcareid.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please fill out all the required fields before saving");
			return;
		}
		else{
			Long HomePhone = Long.parseLong(phone.getText());
			String Email = email.getText();
			String City = city.getText();
			String FirstName = firstname.getText();
			String LastName = lastname.getText();
			String ZipCode = zipcode.getText();
			String HomeAddress = address.getText();
			Long EmergencyNumber = Long.parseLong(enumber.getText());
			//Integer StaffID = 
			String EmergencyName = ename.getText();
			Long Mobile = Long.parseLong(mobile.getText());
			LocalDate DOB = datepicker.getValue(); 
			String Title = (String) titlebox.getSelectionModel().getSelectedItem();
			String Province = (String) province.getSelectionModel().getSelectedItem();
			String Sex = (String) sexbox.getSelectionModel().getSelectedItem();
			String ActivePrescriptions = aprescription.getText();
			String PreviousPrescriptions = pprescription.getText();
			String Cconditions= ccondition.getText();
			String Pconditions = pcondition.getText();
			Main.optionalUpdate(Mobile, HomePhone, Email, City, FirstName, LastName, ZipCode, HomeAddress, EmergencyNumber, EmergencyName, DOB, Title, Province, Sex, hid);
			
			Statement stmt = Main.conn.createStatement();
			stmt.executeUpdate("UPDATE MillenniumHealthClinic.PatientTable "
					+ "SET ActivePrescriptions = '" + ActivePrescriptions + "',"
					+ "PreviousPrescriptions = '" +PreviousPrescriptions+ "', " 
					+ "ActiveConditions= '" +Cconditions+  "',"
					+ "PreviousConditions= '" +Pconditions+  "'"
					+ "WHERE HealthNumber =" + hid + ";");
					
			handleCancelPatient(event);
			
		}		
		
		
		
		
	}
	
	// press Cancel button
		@FXML
		public void handleCancelPatient(ActionEvent event) throws IOException {
			Stage stage = (Stage) cancelbutton.getScene().getWindow();
			stage.close();
		}
}

