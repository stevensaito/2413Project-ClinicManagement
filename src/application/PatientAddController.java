package application;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PatientAddController {
	@FXML
	TextField firstname;
	@FXML
	TextField lastname;
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
	TextField healthcareid;
	@FXML
	ChoiceBox<String> sexbox;
	@FXML
	ChoiceBox<String> titlebox;
	@FXML
	ChoiceBox<String> province;
	//@FXML
	//ChoiceBox<String> province;
	@FXML
	DatePicker datepicker;
	@FXML
	Button cancelbutton;
	@FXML
	Button savebutton;

	// Combobox options
	ObservableList<String> sexlist = FXCollections.observableArrayList("M", "F", "Other");
	ObservableList<String> titlelist = FXCollections.observableArrayList("", "Mr.", "Mrs.", "Ms.", "Prof.", "Dr.");
	ObservableList<String> provincelist = FXCollections.observableArrayList("BC", "ON", "QC", "NS", "NB", "MB", "PE",
			"SK", "AB", "NL");
	
	@FXML
	public void initialize() {
		sexbox.setValue("M");
		sexbox.getItems().addAll(sexlist);
		titlebox.setValue("");
		titlebox.getItems().addAll(titlelist);
		province.setValue("BC");
		province.getItems().addAll(provincelist);
	}

	// press Save button
	@FXML
	public void handleSavePatient(ActionEvent event) throws IOException, SQLException {
		String ifirstname;
		String ilastname;
		Long iphone;
		String iaddress;
		String izipcode;
		String icity;
		String iprovince;
		String iemail;
		String iename;
		Long ienumber;
		String isex;
		String ititle;
		Long ihealthcare;
		LocalDate idate; 

		// show warning if one of the required fields is empty
		if (firstname.getText().trim().isEmpty() || phone.getText().trim().isEmpty() || datepicker.getValue() == null
				|| address.getText().trim().isEmpty() || email.getText().trim().isEmpty() 
				|| enumber.getText().trim().isEmpty() || lastname.getText().trim().isEmpty()
				|| ename.getText().trim().isEmpty()|| healthcareid.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please fill out all the required fields before saving");
			return;
		}

		else {
			ifirstname = firstname.getText();
			ilastname = lastname.getText();
			iphone = Long.parseLong(phone.getText());
			iaddress = address.getText();
			izipcode = zipcode.getText();
			icity = city.getText();
			iprovince = (String) province.getSelectionModel().getSelectedItem();
			iemail = email.getText();
			iename = ename.getText();
			ienumber = Long.parseLong(enumber.getText());
			isex = (String) sexbox.getSelectionModel().getSelectedItem();
			ititle = (String) titlebox.getSelectionModel().getSelectedItem();
			ihealthcare = Long.parseLong(healthcareid.getText());
			idate = datepicker.getValue();
			Functions.handleSavePatient(ifirstname, ilastname, ihealthcare, isex, ititle, iphone, iaddress, izipcode, icity, iprovince, iemail, iename, ienumber, idate);
			handleCancelPatient(event);
		}
		//Functions.handleSavePatient(event);
	}

	// press Cancel button
	@FXML
	public void handleCancelPatient(ActionEvent event) throws IOException {
		Stage stage = (Stage) cancelbutton.getScene().getWindow();
		stage.close();
	}
}
