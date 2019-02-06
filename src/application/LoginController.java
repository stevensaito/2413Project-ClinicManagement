package application;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
	public static String user; 
	// views
	@FXML
	private Label label;
	@FXML
	private Label password;
	// message is invisible
	@FXML
	private Label message;
	@FXML
	private TextField field;
	@FXML
	private PasswordField passw;

	public Main main;

	// button Functions
	@FXML
	public void handleLogin(ActionEvent event) throws IOException, SQLException {

		// Save input in strings
		String username = field.getText();
		String password = passw.getText();

		// Connection connlogin = Main.connect();

		// Query to find password to specific StaffID - ? will be replaced by
		// userID
		String query = "SELECT * FROM MillenniumHealthClinic.Staff WHERE StaffID = ?";

		// create Statement
		Statement myStmt = Main.conn.createStatement();
		PreparedStatement preparedStatement = Main.conn.prepareStatement(query);

		// Statement myStmtRole = connlogin.createStatement();

		// Execute SQL Query
		ResultSet myRs = myStmt.executeQuery("SELECT * FROM MillenniumHealthClinic.Staff");

		// Process Results
		String usernameInDatabase = null;
		String passwordInDatabase = null;

		// create Variable that only turns to false, if username and password
		// correct
		boolean x = true;

		while (myRs.next()) {
			usernameInDatabase = myRs.getString("StaffID");

			// checks if username enters exists in the Database
			if (username.equals(usernameInDatabase)) {
				preparedStatement.setString(1, usernameInDatabase);

				// Resultset for query with username
				ResultSet myRsPassword = preparedStatement.executeQuery();

				while (myRsPassword.next()) {
					// Checks if password is correct for UserId that was entered
					passwordInDatabase = myRsPassword.getString("Password");
					if (passwordInDatabase.equals(password)) {
						x = false;
						//set global variable to role of user
						Main.cred = Integer.parseInt(myRs.getString("Role"));
						LoginController.user = myRs.getString("FirstName").trim() + " " + myRs.getString("LastName").trim();
						Functions.handleHome(event);
					} else {
						//wrong password
					}
				}
			}

			else {
				//System.out.println("You entered a wrong username");
			}
		}
		if (x) {
			message.setVisible(true);
			field.clear();
			passw.clear();
		}
	}

	public void setMain(Main main) {
		
	}
}
