package application;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class StaffAddController {
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
	TextField staffid;
	@FXML
	TextField emergencyname;
	@FXML
	TextField emergencynumber;
	@FXML
	Button cancelbutton;
	@FXML
	Button savebutton;
	@FXML
	ChoiceBox<String> sexbox;
	@FXML
	ChoiceBox<String> titlebox;
	@FXML
	ChoiceBox<String> provincebox;
	@FXML
	ChoiceBox<Integer> rolebox;
	@FXML
	PasswordField password;

	ObservableList<String> sexlist = FXCollections.observableArrayList("M", "F", "Other");
	ObservableList<String> titlelist = FXCollections.observableArrayList("", "Mr.", "Mrs.", "Ms.", "Prof.", "Dr.");
	ObservableList<String> provincelist = FXCollections.observableArrayList("BC", "ON", "QC", "NS", "NB", "MB", "PE",
			"SK", "AB", "NL");
	ObservableList<Integer> rolelist = FXCollections.observableArrayList(1, 2, 3, 4);

	@FXML
	public void initialize() {
		sexbox.setValue("M");
		sexbox.getItems().addAll(sexlist);
		titlebox.setValue("");
		titlebox.getItems().addAll(titlelist);
		provincebox.setValue("BC");
		provincebox.getItems().addAll(provincelist);
		rolebox.setValue(1);
		rolebox.getItems().addAll(rolelist);
	}

	// press Save button
	@FXML
	public void handleSaveStaff(ActionEvent event) throws IOException, SQLException {
		String ifirstname;
		String ilastname;
		Long iphone;
		String iaddress;
		String izipcode;
		String icity;
		String iprovince;
		String iemail;
		Integer istaffid;
		String iemergencyname;
		Long iemergencynumber;
		String isex;
		String ititle;
		Integer irole;
		String ipassword;

		// show warning if one of the required fields is empty
		if (firstname.getText().trim().isEmpty() || phone.getText().trim().isEmpty()
				|| address.getText().trim().isEmpty() || email.getText().trim().isEmpty() || staffid.getText().isEmpty()
				|| emergencynumber.getText().trim().isEmpty() || lastname.getText().trim().isEmpty()
				|| emergencyname.getText().trim().isEmpty() || password.getText().trim().isEmpty()) {
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
			iprovince = (String) provincebox.getSelectionModel().getSelectedItem();
			iemail = email.getText();
			iemergencyname = emergencyname.getText();
			iemergencynumber = Long.parseLong(emergencynumber.getText());
			istaffid = Integer.parseInt(staffid.getText());
			isex = (String) sexbox.getSelectionModel().getSelectedItem();
			ititle = (String) titlebox.getSelectionModel().getSelectedItem();
			irole = (Integer) rolebox.getSelectionModel().getSelectedItem();
			ipassword = password.getText();
			Functions.handleSaveStaff(event, ifirstname, ilastname, isex, ititle, iphone, iaddress, izipcode, icity,
					iprovince, iemail, iemergencyname, iemergencynumber, istaffid, ipassword, irole);
			handleCancelStaff(event);
		}
	}

	// press Cancel button
	@FXML
	public void handleCancelStaff(ActionEvent event) throws IOException {
		Stage stage = (Stage) cancelbutton.getScene().getWindow();
		stage.close();
	}
	
	@FXML public void handleEditStaff(ActionEvent event) throws IOException{
		Functions.handleEditPatient(event);
	}

}
