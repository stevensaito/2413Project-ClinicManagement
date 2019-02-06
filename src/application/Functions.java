package application;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.DayOfWeek;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Functions {

	// Restrictions
	// 1 = Doctor
	// 2 = Admin Staff
	// 3 = Nurse
	// 4 = Administrator

	// press home button
	@FXML
	public static void handleHome(ActionEvent event) throws IOException {
		// retrieves screen size
		Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
		Parent patients_page_parent = FXMLLoader.load(Main.class.getResource("homeWindow.fxml"));

		// Sets scene to what's in fxml file and sets window size to screen size
		Scene patients_page_scene = new Scene(patients_page_parent, visualBounds.getWidth(), visualBounds.getHeight());

		Stage secondarystage = (Stage) (((Node) event.getSource()).getScene().getWindow());
		secondarystage.setScene(patients_page_scene);
		secondarystage.show();

	}

	// press Patients button
	@FXML
	public static void handlePatients(ActionEvent event) throws IOException {
		if (Main.cred == 3) {
			JOptionPane.showMessageDialog(null, "You do not have access to this feature");
		} else {
			Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
			Parent patients_page_parent = FXMLLoader.load(Main.class.getResource("PatientsWindow.fxml"));

			Scene patients_page_scene = new Scene(patients_page_parent, visualBounds.getWidth(),
					visualBounds.getHeight());

			Stage secondarystage = (Stage) (((Node) event.getSource()).getScene().getWindow());
			secondarystage.setScene(patients_page_scene);
			secondarystage.show();
		}
	}

	// press Staff button
	@FXML
	public static void handleStaff(ActionEvent event) throws IOException {
		if (Main.cred == 3) {
			JOptionPane.showMessageDialog(null, "You do not have access to this feature");
		} else {
			Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
			Parent patients_page_parent = FXMLLoader.load(Main.class.getResource("StaffWindow.fxml"));
			Scene patients_page_scene = new Scene(patients_page_parent, visualBounds.getWidth(),
					visualBounds.getHeight());

			Stage secondarystage = (Stage) (((Node) event.getSource()).getScene().getWindow());
			secondarystage.setScene(patients_page_scene);
			secondarystage.show();
		}
	}

	// press Settings button
	@FXML
	public static void handleSettings(ActionEvent event) throws IOException {
		if (Main.cred == 3) {
			JOptionPane.showMessageDialog(null, "You do not have access to this feature");
		} else {
			// retrieves screen size
			Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
			Parent patients_page_parent = FXMLLoader.load(Main.class.getResource("SettingsWindow.fxml"));

			// Sets scene to what's in fxml file and sets window size to screen
			// size
			Scene patients_page_scene = new Scene(patients_page_parent, visualBounds.getWidth(),
					visualBounds.getHeight());

			Stage secondarystage = (Stage) (((Node) event.getSource()).getScene().getWindow());
			secondarystage.setScene(patients_page_scene);
			secondarystage.show();
		}
	}

	// press Logout Button
	@FXML
	public static void handleLogout(ActionEvent event) throws IOException {
		// retrieves screen size
		Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
		Parent patients_page_parent = FXMLLoader.load(Main.class.getResource("LoginWindow.fxml"));

		// Sets scene to what's in fxml file and sets window size to screen size
		Scene patients_page_scene = new Scene(patients_page_parent, visualBounds.getWidth(), visualBounds.getHeight());

		Stage secondarystage = (Stage) (((Node) event.getSource()).getScene().getWindow());
		secondarystage.setScene(patients_page_scene);
		secondarystage.show();

	}

	// press Appointment button
	@FXML
	public static void handleAppointment(ActionEvent event) throws IOException {
		if (Main.cred == 3) {
			JOptionPane.showMessageDialog(null, "You do not have access to this feature");
		} else {
			FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("AddAppointmentWindow.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root1));
			// Set TitleBar Title
			stage.setTitle("New Appointment");
			// Set Titlebar icon
			stage.getIcons().add(new Image("file:Millennium-SmallLogo.png"));
			stage.show();
		}
	}

	// Don't need to check for privileges again, because nurses already don't
	// have access to create button
	@FXML
	public static void handleCreateAppointment(DayOfWeek iweekday, LocalDate idate, String istarttime, Integer id,
			Long ihealthcareid, String iname, String end) throws SQLException {
		Statement stmt = Main.conn.createStatement();
		
		stmt.executeUpdate( "INSERT INTO MillenniumHealthClinic.Calendar (DOW, NumericDate, StartTime, StaffID, HealthNumber, Name, EndTime) "
				+ "VALUES ('"+iweekday+"', '"+idate+"', '" + istarttime+"', '"+id+"', '"+ihealthcareid+"', '"+iname+"','"+end+"');");
		
		
		
		
		/*stmt.executeUpdate("INSERT INTO MillenniumHealthClinic.Calendar (DOW) VALUES ('"+iweekday+"');");
		stmt.executeUpdate("INSERT INTO MillenniumHealthClinic.Calendar (NumericDate) VALUES ("+idate+");");
		stmt.executeUpdate("INSERT INTO MillenniumHealthClinic.Calendar (StartTime) VALUES ("+istarttime+");");
		stmt.executeUpdate("INSERT INTO MillenniumHealthClinic.Calendar (StaffID) VALUES ("+id+");");
		stmt.executeUpdate("INSERT INTO MillenniumHealthClinic.Calendar (HealthNumber) VALUES ("+ihealthcareid+");");
		stmt.executeUpdate("INSERT INTO MillenniumHealthClinic.Calendar (Name) VALUES ("+iname+");");*/
		
		
		 
	}

	// press edit button on patient page
	@FXML
	public static void handleEditPatient(ActionEvent event) throws IOException {
		if (Main.cred == 3) {
			JOptionPane.showMessageDialog(null, "You do not have access to this feature");
		} else {
			Parent patients_page_parent = FXMLLoader.load(Main.class.getResource("PatientSingleViewEditWindow.fxml"));

			Scene patients_page_scene = new Scene(patients_page_parent);

			Stage secondarystage = (Stage) (((Node) event.getSource()).getScene().getWindow());
			secondarystage.setScene(patients_page_scene);
			secondarystage.show();
		}
	}	
	
	// press save button on patient page, no need to test privileges again
	@FXML
	public static void handleSavePatient(String ifirstname, String ilastname, Long ihealthcareid, String isex,
			String ititle, Long iphone, String iaddress, String izipcode, String icity, String iprovince, String iemail,
			String iename, Long ienumber, LocalDate idate) throws IOException, SQLException {
		Statement stmt = Main.conn.createStatement();
		stmt.executeUpdate(
				"INSERT INTO MillenniumHealthClinic.PatientTable (FirstName, LastName, HealthNumber, Sex, Title, homePhoneNumber, HomeAddress, ZipCode, City, Province, Email, EmergencyName, EmergencyNumber, DOB) "
						+ "VALUES('" + ifirstname + "', '" + ilastname + "', " + ihealthcareid + ", '" + isex + "', '"
						+ ititle + "', " + iphone + ", '" + iaddress + "', '" + izipcode + "', '" + icity + "', '"
						+ iprovince + "', '" + iemail + "', '" + iename + "', " + ienumber + ", '" + idate + "')");
	}

	@FXML
	public static void handleViewPatient() throws IOException {
		if (Main.cred == 3) {
			JOptionPane.showMessageDialog(null, "You do not have access to this feature");
		} else {
			FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("PatientSingleViewWindow.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root1));
			// Set TitleBar Title
			stage.setTitle("Patient");
			// Set Titlebar icon
			stage.getIcons().add(new Image("file:Millennium-SmallLogo.png"));
			stage.show();
		}
	}
	@FXML
	public static void handleViewStaff() throws IOException {
		if (Main.cred == 3) {
			JOptionPane.showMessageDialog(null, "You do not have access to this feature");
		} else {
			FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("StaffViewWindow.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root1));
			// Set TitleBar Title
			stage.setTitle("Staff");
			// Set Titlebar icon
			stage.getIcons().add(new Image("file:Millennium-SmallLogo.png"));
			stage.show();
		}
	}

	// press edit button on settings page
	public static void handleEditSettings(ActionEvent event) throws IOException {
		if (Main.cred != 4) {
			JOptionPane.showMessageDialog(null, "You do not have access to this feature");
		} else {
			FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("SettingsEditWindow.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root1));
			// Set TitleBar Title
			stage.setTitle("Settings");
			// Set Titlebar icon
			stage.getIcons().add(new Image("file:Millennium-SmallLogo.png"));
			stage.show();
		}
	}

	// press save button on settings page
	public static void handleSaveSettings(ActionEvent event) throws IOException {
		Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
		Parent patients_page_parent = FXMLLoader.load(Main.class.getResource("SettingsWindow.fxml"));

		// Sets scene to what's in FXML file and sets window size to screen size
		Scene patients_page_scene = new Scene(patients_page_parent, visualBounds.getWidth(), visualBounds.getHeight());

		Stage secondarystage = (Stage) (((Node) event.getSource()).getScene().getWindow());
		secondarystage.setScene(patients_page_scene);
		secondarystage.show();

	}

	// press cancel button on settings page
	public static void handleCancelSettings(ActionEvent event) throws IOException {
		Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
		Parent patients_page_parent = FXMLLoader.load(Main.class.getResource("SettingsWindow.fxml"));

		// Sets scene to what's in FXML file and sets window size to screen size
		Scene patients_page_scene = new Scene(patients_page_parent, visualBounds.getWidth(), visualBounds.getHeight());

		Stage secondarystage = (Stage) (((Node) event.getSource()).getScene().getWindow());
		secondarystage.setScene(patients_page_scene);
		secondarystage.show();

	}

	// This function is overloaded
	public static void handleSearchStaff(ActionEvent event, Integer istaffid) throws SQLException {
		Statement stmt = Main.conn.createStatement();
		ResultSet rsID = stmt.executeQuery("SELECT * FROM MillenniumHealthClinic.Staff WHERE StaffID =" + istaffid);
		while (rsID.next()) {

			// set integer variables to NULL, if field is empty, otherwise error
			Long mobile;
			if (rsID.getString("Mobile") == null) {
				mobile = 0L;
			} else {
				mobile = Long.parseLong(rsID.getString("Mobile"));
			}

			Long homenumber;
			if (rsID.getString("PhoneNumber") == null) {
				homenumber = 0L;
			} else {
				homenumber = Long.parseLong(rsID.getString("PhoneNumber"));
			}

			StaffController.listStaff.add(new Staff(rsID.getString("FirstName"), rsID.getString("LastName"),
					Integer.parseInt(rsID.getString("StaffID")), rsID.getString("Title"), rsID.getString("Sex"),
					homenumber, mobile, rsID.getString("HomeAddress"), rsID.getString("Zipcode"),
					rsID.getString("City"), rsID.getString("Province"), rsID.getString("Email"), Integer.parseInt(rsID.getString("Role"))));
		}
	}

	// search with lastname
	public static void handleSearchStaff(ActionEvent event, String iname) throws SQLException {
		Statement stmt = Main.conn.createStatement();
		ResultSet rsID = stmt
				.executeQuery("SELECT * FROM MillenniumHealthClinic.Staff WHERE LastName = '" + iname + "'");
		while (rsID.next()) {

			// set integer variables to NULL, if field is empty, otherwise error
			Long mobile;
			if (rsID.getString("Mobile") == null) {
				mobile = 0L;
			} else {
				mobile = Long.parseLong(rsID.getString("Mobile"));
			}

			Long homenumber;
			if (rsID.getString("PhoneNumber") == null) {
				homenumber = 0L;
			} else {
				homenumber = Long.parseLong(rsID.getString("PhoneNumber"));
			}

			StaffController.listStaff.add(new Staff(rsID.getString("FirstName"), rsID.getString("LastName"),
					Integer.parseInt(rsID.getString("StaffID")), rsID.getString("Sex"), rsID.getString("Title"),
					homenumber, mobile, rsID.getString("HomeAddress"), rsID.getString("Zipcode"),
					rsID.getString("City"), rsID.getString("Province"), rsID.getString("Email"), Integer.parseInt(rsID.getString("Role"))));
		}
	}

	// search with lastname and id
	public static void handleSearchStaff(ActionEvent event, String iname, Integer istaffid) throws SQLException {
		Statement stmt = Main.conn.createStatement();
		ResultSet rsID = stmt.executeQuery(
				"SELECT * FROM MillenniumHealthClinic.Staff WHERE LastName = '" + iname + "' AND StaffID =" + istaffid);
		while (rsID.next()) {

			// set integer variables to NULL, if field is empty, otherwise error
			Long mobile;
			if (rsID.getString("Mobile") == null) {
				mobile = 0L;
			} else {
				mobile = Long.parseLong(rsID.getString("Mobile"));
			}

			Long homenumber;
			if (rsID.getString("PhoneNumber") == null) {
				homenumber = 0L;
			} else {
				homenumber = Long.parseLong(rsID.getString("PhoneNumber"));
			}
			StaffController.listStaff.add(new Staff(rsID.getString("FirstName"), rsID.getString("LastName"),
					Integer.parseInt(rsID.getString("StaffID")), rsID.getString("Sex"), rsID.getString("Title"),
					homenumber, mobile, rsID.getString("HomeAddress"), rsID.getString("Zipcode"),
					rsID.getString("City"), rsID.getString("Province"), rsID.getString("Email"), Integer.parseInt(rsID.getString("Role"))));
		}
	}

	public static void deleteTableContentStaff(ObservableList<Staff> listStaff) {
		int i = 0;
		int size = listStaff.size();
		while (i <= (size - 1)) {
			listStaff.remove(0);
			i++;
		}
	}

	// press addstaff button on staff page
	public static void handleAddStaff(ActionEvent event) throws IOException {
		if (Main.cred == 3) {
			JOptionPane.showMessageDialog(null, "You do not have access to this feature");
		} else {
			FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("StaffAddWindow.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root1));
			// Set TitleBar Title
			stage.setTitle("New Employee");
			// Set Titlebar icon
			stage.getIcons().add(new Image("file:Millennium-SmallLogo.png"));
			stage.show();
		}
	}

	// press save button on staff page
	public static void handleSaveStaff(ActionEvent event, String ifirstname, String ilastname, String isex,
			String ititle, Long iphone, String iaddress, String izipcode, String icity, String iprovince, String iemail,
			String iemergencyname, Long iemergencynumber, Integer istaffid, String ipassword, Integer irole)
			throws IOException, SQLException {
		Statement stmt = Main.conn.createStatement();
		stmt.executeUpdate(
				"INSERT INTO MillenniumHealthClinic.Staff (FirstName, LastName, Sex, Title, PhoneNumber, HomeAddress, Zipcode, city, province, Email, EmergencyName, EmergencyNumber, StaffID, Password, Role) "
						+ "VALUES('" + ifirstname + "', '" + ilastname + "', '" + isex + "', '" + ititle + "', "
						+ iphone + ", '" + iaddress + "', '" + izipcode + "', '" + icity + "', '" + iprovince + "', '"
						+ iemail + "', '" + iemergencyname + "', " + iemergencynumber + ", " + istaffid + ", '"
						+ ipassword + "', " + irole + ")");
	}

	// press edit button on staff page
	public static void handleEditStaff(ActionEvent event) throws IOException {
		if (Main.cred == 3) {
			JOptionPane.showMessageDialog(null, "You do not have access to this feature");
		} else {
			Parent patients_page_parent = FXMLLoader.load(Main.class.getResource("StaffEditWindow.fxml"));

			Scene patients_page_scene = new Scene(patients_page_parent);

			Stage secondarystage = (Stage) (((Node) event.getSource()).getScene().getWindow());
			secondarystage.setScene(patients_page_scene);
			secondarystage.show();
		}
	}

	// press add button on patient page, overload function
	public static void handleAddPatient(ActionEvent event) throws IOException {
		if (Main.cred == 3) {
			JOptionPane.showMessageDialog(null, "You do not have access to this feature");
		} else {
			FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("PatientSingleViewAddWindow.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root1));
			// Set TitleBar Title
			stage.setTitle("New Patient");
			// Set Titlebar icon
			stage.getIcons().add(new Image("file:Millennium-SmallLogo.png"));
			stage.show();

		}
	}

	public static void handleSearchPatient(ActionEvent event, Long ihealthcareid) throws SQLException {
		Statement stmt = Main.conn.createStatement();
		ResultSet rsID = stmt
				.executeQuery("SELECT * FROM MillenniumHealthClinic.PatientTable WHERE HealthNumber =" + ihealthcareid);
		while (rsID.next()) {
			// set integer variables to NULL, if field is empty, otherwise error
			Long mobile;
			if (rsID.getString("Mobile") == null) {
				mobile = 0L;
			} else {
				mobile = Long.parseLong(rsID.getString("Mobile"));
			}

			Long homenumber;
			if (rsID.getString("homePhoneNumber") == null) {
				homenumber = 0L;
			} else {
				homenumber = Long.parseLong(rsID.getString("homePhoneNumber"));
			}

			Long enumber;
			if (rsID.getString("EmergencyNumber") == null) {
				enumber = 7623L;
			} else {
				enumber = Long.parseLong(rsID.getString("EmergencyNumber"));
			}
			PatientsController.listPatient.add(new Patient(rsID.getString("FirstName"), rsID.getString("LastName"),
					Long.parseLong(rsID.getString("HealthNumber")), rsID.getString("DOB"), rsID.getString("Title"),
					rsID.getString("Sex"), homenumber, mobile, rsID.getString("HomeAddress"), rsID.getString("ZipCode"),
					rsID.getString("City"), rsID.getString("Province"), rsID.getString("Email"),
					rsID.getString("EmergencyName"), enumber));
			;
		}
	}

	public static void handleSearchPatient(ActionEvent event, String ilastname) throws SQLException {
		Statement stmt = Main.conn.createStatement();
		ResultSet rsName = stmt.executeQuery(
				"SELECT * FROM MillenniumHealthClinic.PatientTable WHERE LastName =" + "'" + ilastname + "'");
		while (rsName.next()) {
			// set integer variables to NULL, if field is empty, otherwise error
			Long mobile;
			if (rsName.getString("Mobile") == null) {
				mobile = 0L;
			} else {
				mobile = Long.parseLong(rsName.getString("Mobile"));
			}

			Long homenumber;
			if (rsName.getString("homePhoneNumber") == null) {
				homenumber = 0L;
			} else {
				homenumber = Long.parseLong(rsName.getString("homePhoneNumber"));
			}

			Long enumber;
			if (rsName.getString("EmergencyNumber") == null) {
				enumber = 7623L;
			} else {
				enumber = Long.parseLong(rsName.getString("EmergencyNumber"));
			}

			PatientsController.listPatient.add(new Patient(rsName.getString("FirstName"), rsName.getString("LastName"),
					Long.parseLong(rsName.getString("HealthNumber")), rsName.getString("DOB"),
					rsName.getString("Title"), rsName.getString("Sex"), homenumber, mobile,
					rsName.getString("HomeAddress"), rsName.getString("ZipCode"), rsName.getString("City"),
					rsName.getString("Province"), rsName.getString("Email"), rsName.getString("EmergencyName"),
					enumber));
			;
		}
	}

	public static void handleSearchPatient(ActionEvent event, String ilastname, Long ihealthcareid)
			throws SQLException {
		Statement stmt = Main.conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM MillenniumHealthClinic.PatientTable WHERE LastName =" + "'"
				+ ilastname + "'" + " AND HealthNumber =" + "'" + ihealthcareid + "'");

		while (rs.next()) {
			// set integer variables to NULL, if field is empty, otherwise error
			Long mobile;
			if (rs.getString("Mobile") == null) {
				mobile = 0L;
			} else {
				mobile = Long.parseLong(rs.getString("Mobile"));
			}

			Long homenumber;
			if (rs.getString("homePhoneNumber") == null) {
				homenumber = 0L;
			} else {
				homenumber = Long.parseLong(rs.getString("homePhoneNumber"));
			}

			Long enumber;
			if (rs.getString("EmergencyNumber") == null) {
				enumber = 7623L;
			} else {
				enumber = Long.parseLong(rs.getString("EmergencyNumber"));
			}

			PatientsController.listPatient.add(new Patient(rs.getString("FirstName"), rs.getString("LastName"),
					Long.parseLong(rs.getString("HealthNumber")), rs.getString("DOB"), rs.getString("Title"),
					rs.getString("Sex"), homenumber, mobile, rs.getString("HomeAddress"), rs.getString("ZipCode"),
					rs.getString("City"), rs.getString("Province"), rs.getString("Email"),
					rs.getString("EmergencyName"), enumber));
			;
		}
	}

	// removes content of Patient Table
	public static void deleteTableContent(ObservableList<Patient> listPatient) {
		int i = 0;
		int size = listPatient.size();
		while (i <= (size - 1)) {
			listPatient.remove(0);
			i++;
		}
	}

	public static void handleCheckAppointment(ActionEvent envent, LocalDate date) throws NumberFormatException, SQLException {
		Statement stmt = Main.conn.createStatement();
		ResultSet rs = stmt
				.executeQuery("SELECT * FROM MillenniumHealthClinic.Calendar WHERE NumericDate = '" + date + "'");
		Long healthcareid;
		Integer staff;
		while (rs.next()) {
			healthcareid = Long.parseLong(rs.getString("HealthNumber"));
			staff = Integer.parseInt(rs.getString("StaffID"));

			HomeController.listAppointment.add(new Appointment(rs.getString("DOW"), rs.getString("StartTime"),
					rs.getString("EndTime"), rs.getString("Name"), healthcareid, staff));
		}
	}

	// Display dates of current date, initializes table without button click
	public static void handleCheckAppointment(String date) throws NumberFormatException, SQLException {
		Statement stmt = Main.conn.createStatement();
		ResultSet rs = stmt
				.executeQuery("SELECT * FROM MillenniumHealthClinic.Calendar WHERE NumericDate = '" + date + "'");
		Long healthcareid;
		Integer staff;

		while (rs.next()) {
			healthcareid = Long.parseLong(rs.getString("HealthNumber"));
			staff = Integer.parseInt(rs.getString("StaffID"));

			HomeController.listAppointment.add(new Appointment(rs.getString("DOW"), rs.getString("StartTime"),
					rs.getString("EndTime"), rs.getString("Name"), healthcareid, staff));
		}
	}
	
	//deletes content of appointment table
	public static void deleteTableAppointment(ObservableList<Appointment> listappointment) {
		int i = 0;
		int size = listappointment.size();
		while (i <= (size - 1)) {
			listappointment.remove(0);
			i++;
		}
	}


	/*public static void handleCreateAppointment(ActionEvent event, String iname, DayOfWeek iweekday, LocalDate idate,
			String startTime, Integer id, Long ihealthcareid, String endTime) {
		// TODO Auto-generated method stub */
		
}

