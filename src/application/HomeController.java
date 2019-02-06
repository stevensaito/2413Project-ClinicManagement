package application;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;


	public class HomeController {
		
		@FXML public Label username;
		@FXML DatePicker datepicker; 
		//Table Elements
		@FXML private TableView<Appointment> appointmentTable;
		@FXML private TableColumn<Appointment, String> weekday;
		@FXML private TableColumn<Appointment, String> time;
		@FXML private TableColumn<Appointment, String> endTime;
		@FXML private TableColumn<Appointment, String> patient;
		@FXML private TableColumn<Appointment, Integer> healthcareid;
		@FXML private TableColumn<Appointment, Integer> staffid;
		
		public static Long hid; 
		 
		
		public static ObservableList<Appointment>listAppointment = FXCollections.observableArrayList();

		@FXML public void initialize() throws SQLException{
		username.setText(LoginController.user);
		Functions.deleteTableAppointment(listAppointment);
		LocalDateTime currentDate = LocalDateTime.now();
		Integer year = currentDate.getYear();
		Integer month = currentDate.getMonthValue();
		Integer day = currentDate.getDayOfMonth();
		String stringmonth;
		String stringday;
		//if value of the month is one digit, we need to add a 0, otherwise it can't compare
		int lengthmonth = String.valueOf(month).length();
		int lengthday = String.valueOf(day).length();
		if(lengthmonth == 1 ){
			stringmonth = "0"+month;
		}
		else
			stringmonth = Integer.toString(month);
		if(lengthday == 1 ){
			stringday = "0"+day;
		}
		else
			stringday = Integer.toString(day);
		
		String date  = year + "-" +stringmonth+ "-" +stringday; 
		Functions.handleCheckAppointment(date);
		appointmentTable.setItems(listAppointment);
		
		weekday.setCellValueFactory(new PropertyValueFactory<Appointment, String>("aweekday"));
    	time.setCellValueFactory(new PropertyValueFactory<Appointment, String>("atime"));
    	endTime.setCellValueFactory(new PropertyValueFactory<Appointment, String>("atimeEnd"));
    	patient.setCellValueFactory(new PropertyValueFactory<Appointment, String>("apatient"));
    	healthcareid.setCellValueFactory(new PropertyValueFactory<Appointment, Integer>("ahealthcareid"));
    	staffid.setCellValueFactory(new PropertyValueFactory<Appointment, Integer>("astaffid"));
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
		
		//press Search for specific date
		@FXML public void handleCheckAppointment(ActionEvent event) throws IOException, NumberFormatException, SQLException{
			LocalDate date = datepicker.getValue();
			Functions.deleteTableAppointment(listAppointment);
			Functions.handleCheckAppointment(event, date);
		}
		
		@FXML public void choosePatient(MouseEvent event) throws IOException{
			//get healthcare id of double clicked row
			if (event.getClickCount() == 2 ){
			hid = appointmentTable.getSelectionModel().getSelectedItem().getAhealthcareid();
			Functions.handleViewPatient();
			}
			
		}
		//View Patient uses this function to get get patient that has been clicked on 
		static public Long getID(){
			return hid;
		}
}
