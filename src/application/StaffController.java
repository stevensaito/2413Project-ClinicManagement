package application;

import java.io.IOException;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

	//ADD ADD STAFF

	public class StaffController {
		
		
		public static Integer staff; 
			
		@FXML public Label username;
		@FXML private TextField name;
		@FXML private TextField staffid;
		
		//Table Elements
		@FXML private TableView<Staff> staffTable;
		@FXML private TableColumn<Staff, String> firstname;
		@FXML private TableColumn<Staff, String> lastname;
		@FXML private TableColumn<Staff, Integer> staffID;
		@FXML private TableColumn<Staff, String> title;
		@FXML private TableColumn<Staff, String> sex;
		@FXML private TableColumn<Staff, Long> homePhone;
		@FXML private TableColumn<Staff, Long> mobile;
		@FXML private TableColumn<Staff, String> address;
		@FXML private TableColumn<Staff, String> zipCode;
		@FXML private TableColumn<Staff, String> city;
		@FXML private TableColumn<Staff, String> province;
		@FXML private TableColumn<Staff, String> email;
		@FXML private TableColumn<Staff, Integer> role;
		public static ObservableList<Staff>listStaff = FXCollections.observableArrayList();
		
		@FXML
		public void initialize(){		
		username.setText(LoginController.user);
			
    	Staff.fillStaff(listStaff);
    	staffTable.setItems(listStaff);
    	
    	firstname.setCellValueFactory(new PropertyValueFactory<Staff, String>("sfname"));
    	lastname.setCellValueFactory(new PropertyValueFactory<Staff, String>("slname"));
    	staffID.setCellValueFactory(new PropertyValueFactory<Staff, Integer>("sstaffID"));
    	title.setCellValueFactory(new PropertyValueFactory<Staff, String>("stitle"));
    	sex.setCellValueFactory(new PropertyValueFactory<Staff, String>("ssex"));
    	homePhone.setCellValueFactory(new PropertyValueFactory<Staff, Long>("shomePhone"));
    	mobile.setCellValueFactory(new PropertyValueFactory<Staff, Long>("smobile"));
    	address.setCellValueFactory(new PropertyValueFactory<Staff, String>("saddress"));
    	zipCode.setCellValueFactory(new PropertyValueFactory<Staff, String>("szipCode"));
    	city.setCellValueFactory(new PropertyValueFactory<Staff, String>("scity"));
    	province.setCellValueFactory(new PropertyValueFactory<Staff, String>("sprovince"));
    	email.setCellValueFactory(new PropertyValueFactory<Staff, String>("semail"));
    	role.setCellValueFactory(new PropertyValueFactory<Staff, Integer>("srole"));
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
		
		//press Add staff button
		@FXML public void handleAddStaff(ActionEvent event) throws IOException{
			Functions.handleAddStaff(event);
		}
		
		//press edit button
		@FXML public void handleEditStaff(ActionEvent event) throws IOException{
			Functions.handleEditStaff(event);
		}
		
		//press search button
		@FXML public void handleSearchStaff(ActionEvent event) throws IOException, SQLException{
			String iname = name.getText(); 
			Integer istaffid;
			//
			if(staffid.getText().trim().isEmpty()){
				istaffid = null;
			}
			
			else{
				istaffid =  Integer.parseInt(staffid.getText()); 
			}
			
			//Search ID only
			if(name.getText().trim().isEmpty()){
				Functions.deleteTableContentStaff(listStaff);
				Functions.handleSearchStaff(event, istaffid);
			}
			//Search name only
			else if(staffid.getText().trim().isEmpty()){
				Functions.deleteTableContentStaff(listStaff);
				Functions.handleSearchStaff(event, iname);
			}
			else{
				Functions.deleteTableContentStaff(listStaff);
				Functions.handleSearchStaff(event, iname, istaffid);
			}
			
		}
		@FXML public void handleChooseStaff(MouseEvent event) throws IOException{
			//get healthcare id of double clicked row
			if (event.getClickCount() == 2 ){
			staff = staffTable.getSelectionModel().getSelectedItem().getSstaffID();
			Functions.handleViewStaff();
			}
		}
		
		public static Integer getstaff(){
			return staff;
		}
}
