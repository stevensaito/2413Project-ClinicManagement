package application;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


	public class PatientsController {
		
		public Main main;
		
		@FXML Label username;
		@FXML Button addpatientbutton; 
		@FXML Button cancelbutton;
		// fxml for text input fields
		@FXML TextField nametextfield;
		@FXML TextField idtextfield;
		
		//Table Elements
		@FXML private TableView<Patient> patientTable;
		@FXML private TableColumn<Patient, String> firstname;
		@FXML private TableColumn<Patient, String> lastname;
		@FXML private TableColumn<Patient, Integer> healthcareID;
		@FXML private TableColumn<Patient, String> dateOfBirth;
		@FXML private TableColumn<Patient, String> title;
		@FXML private TableColumn<Patient, String> sex;
		@FXML private TableColumn<Patient, Integer> homePhone;
		@FXML private TableColumn<Patient, Integer> mobile;
		@FXML private TableColumn<Patient, String> address;
		@FXML private TableColumn<Patient, String> zipCode;
		@FXML private TableColumn<Patient, String> city;
		@FXML private TableColumn<Patient, String> province;
		@FXML private TableColumn<Patient, String> email;
		@FXML private TableColumn<Patient, String> econtactname;
		@FXML private TableColumn<Patient, Integer> econtactphone;
		
		public static ObservableList<Patient>listPatient = FXCollections.observableArrayList();
		
		@FXML
		public void initialize() throws SQLException{		
			//username.setText(LoginController.user);
	    	patientTable.setItems(listPatient);
	    	
	    	firstname.setCellValueFactory(new PropertyValueFactory<Patient, String>("pfname"));
	    	lastname.setCellValueFactory(new PropertyValueFactory<Patient, String>("plname"));
	    	healthcareID.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("phID"));
	    	dateOfBirth.setCellValueFactory(new PropertyValueFactory<Patient, String>("pdateOfBirth"));
	    	title.setCellValueFactory(new PropertyValueFactory<Patient, String>("ptitle"));
	    	sex.setCellValueFactory(new PropertyValueFactory<Patient, String>("psex"));
	    	homePhone.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("phomePhone"));
	    	mobile.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("pmobile"));
	    	address.setCellValueFactory(new PropertyValueFactory<Patient, String>("paddress"));
	    	zipCode.setCellValueFactory(new PropertyValueFactory<Patient, String>("pzipCode"));
	    	city.setCellValueFactory(new PropertyValueFactory<Patient, String>("pcity"));
	    	province.setCellValueFactory(new PropertyValueFactory<Patient, String>("pprovince"));
	    	email.setCellValueFactory(new PropertyValueFactory<Patient, String>("pemail"));
	    	econtactname.setCellValueFactory(new PropertyValueFactory<Patient, String>("peCName"));
	    	econtactphone.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("peCNumber"));
	   
		}
		
		//press home button
		@FXML public void handleHome(ActionEvent event) throws IOException{
			Functions.handleHome(event);
		}
		
		//press Patients button
		@FXML public void handlePatients(ActionEvent event) throws IOException{			
			Functions.handlePatients(event);
		}
		
		//press Staff button
		@FXML public void handleStaff(ActionEvent event) throws IOException{
			Functions.handleStaff(event);
		}
		
		//press Settings button
		@FXML public void handleSettings(ActionEvent event) throws IOException{
			Functions.handleSettings(event);
		}

		//press Logout button
		@FXML public void handleLogout(ActionEvent event) throws IOException{
			Functions.handleLogout(event);
		}
		
		//press Appointment button
		@FXML public void handleAppointment(ActionEvent event) throws IOException{
		Functions.handleAppointment(event);
		}
		
		//press Add Patient button
		@FXML public void handleAddPatient(ActionEvent event) throws IOException{
			Functions.handleAddPatient(event);
		}
		
		//press Edit button
		@FXML public void handleEditPatient(ActionEvent event) throws IOException{
			Functions.handleEditPatient(event);
		}
			
		//press Cancel button
		@FXML public void handleCancelPatient(ActionEvent event) throws IOException{
			 Stage stage = (Stage) cancelbutton.getScene().getWindow();
			    stage.close();
		}
		
		// press search button
		@FXML public void handleSearchPatient(ActionEvent event) throws IOException, SQLException{
			//saving input in variables
			String ilastname = nametextfield.getText(); 
			Long ihealthcareid;
			if(idtextfield.getText().trim().isEmpty()){
				ihealthcareid = null;
			}
			else{
				ihealthcareid =  Long.parseLong(idtextfield.getText()); 
			}
			
		// Search with ID input only	
			if(nametextfield.getText().trim().isEmpty()){
				Functions.deleteTableContent(listPatient);
				Functions.handleSearchPatient(event, ihealthcareid);
			}
			
		//search lastname only
			else if(idtextfield.getText().trim().isEmpty()){

				Functions.deleteTableContent(listPatient);
				Functions.handleSearchPatient(event, ilastname);
			}
			
			//Last name and ID entered
			else{
				Functions.deleteTableContent(listPatient);
				Functions.handleSearchPatient(event, ilastname, ihealthcareid);
			}		

	}
		@FXML public void handleChoosePatient(MouseEvent event) throws IOException{
			//get healthcare id of double clicked row
			if (event.getClickCount() == 2 ){
			HomeController.hid = patientTable.getSelectionModel().getSelectedItem().getPhID();
			Functions.handleViewPatient();
			}
		}
		
}
