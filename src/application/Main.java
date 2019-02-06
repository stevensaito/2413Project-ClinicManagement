package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Properties;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {
	public static Connection conn= Main.connect();
	private Stage primaryStage;
	static int cred;

	@Override
	public void start(Stage primaryStage){
		this.primaryStage = primaryStage;
		// Set TitleBar Title
		primaryStage.setTitle("Millennium Health Clinic");
		// Set Titlebar icon
		primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("Millennium-SmallLogo.png")));
		// show Window
		loginWindow();
	}

	public void loginWindow() {
		try {
			Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("LoginWindow.fxml"));
			// load returns top-level element of FXML file
			AnchorPane pane = loader.load();

			LoginController loginController = loader.getController();
			loginController.setMain(this);

			Scene scene = new Scene(pane, visualBounds.getWidth(), visualBounds.getHeight());

			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws SQLException {
		// Variables describing all aspects of the three tables

		// Variables similar across all tables
		// Columns
		String HomeNumber = "HomeNumber";
		String Email = "Email";
		String City = "City";
		String ZipCode = "ZipCode";
		String Address = "Address";
		String EmergencyNumber = "EmergencyNumber";
		String HealthNumber = "HealthNumber";
		String StaffID = "StaffID";
		String FirstName = "FirstName";
		String LastName = "LastName";
		String EmergencyName = "EmergencyName";
		String Mobile = "Mobile";
		String DOB = "DOB";
		String Title = "Title";
		String Province = "Province";
		String Sex = "Sex";
		String StartTime = "StartTime";

		// Variables specific to PatientTable
		// Columns
		String PatientTable = "PatientTable"; // Table name
		String ActivePrescriptions = "ActivePrescriptions";
		String PreviousPrescriptions = "PreviousPrescriptions";
		String ActiveConditions = "ActiveConditions";
		String PreviousConditions = "PreviousConditions";

		// Variables specific to Calendar
		// Columns
		String Calendar = "Calendar"; // Table name
		String DayOfWeek = "DayOfWeek";
		String NumericDate = "NumericDate";
		String Year = "Year";
	//	String StartTime = "StartTime";
		String EndTime = "EndTime";

		// Variables specific to Staff
		// Columns
		String Staff = "Staff"; // Table name
		String Password = "Password";
		String Role = "Role";

		// connect();
		launch(args);

	}
	
	// ----------------------------------------------------------------------------------------------------------------
	// This section contains all queries related to patients
	
	// We'll use this method to insert the information that will be taken over the phone
	// This HAS to be recorded down at the time of the call. If they want to add any information later,
	// use the "optionalInsert" method
	public static void insertInfo(String FirstName, String LastName, String HealthNumber, String StartTime) throws SQLException{
		Statement stmt = Main.conn.createStatement();
		stmt.executeQuery("INSERT INTO MillenniumHealthClinic.Patient (FirstName, LastName, HealthNumber, StartTime)"
				+ " Values(" + FirstName + "," + LastName +  "," + HealthNumber + "," + StartTime + ");");
	}
	
	// Use this if you want to add other info besides FirstName, LastName, Email, and HealthNumber
	public static void optionalInsert(String HomePhone, String Email, String City, String ZipCode, String HomeAddress, 
		String EmergencyNumber, String StaffID, String EmergencyName, String Mobile, String DOB, String Title, 
		String Province, String Sex) throws SQLException{
		
		Statement stmt = Main.conn.createStatement();
		stmt.executeQuery("INSERT INTO MillenniumHealthClinic.Patient (HomePhone, Email, City, ZipCode, HomeAddress,"
				+ "EmergencyNumber, StaffID, EmergencyName, Mobile, DOB, Title, Province, Sex)"
				+ " Values(" + HomePhone + "," + Email + "," + "," + City + "," + ZipCode + "," + 
				City + "," + ZipCode + "," + HomeAddress + "," + EmergencyNumber + "," + StaffID + "," + 
				EmergencyName + "," + Mobile + "," + DOB + "," + Title + "," + Province + "," + Sex + ");");
	}
	
	// Use this if you want to update other info besides FirstName, LastName, Email, and HealthNumber
		public static void optionalUpdate(Long Mobile, Long HomePhone, String Email, String City, String FirstName, String LastName, String ZipCode, String HomeAddress, 
			Long EmergencyNumber, 
			//String StaffID, 
			String EmergencyName, //String Mobile, 
			LocalDate DOB, String Title, 
			String Province, String Sex, Long HealthNumber) throws SQLException{
			
			Statement stmt = Main.conn.createStatement();
			stmt.executeUpdate("UPDATE MillenniumHealthClinic.PatientTable "
					+ "SET homePhoneNumber = " + HomePhone + ","
					+ "Email = '" + Email + "',"
					+ "City = '" + City + "',"
					+ "FirstName ='" +FirstName+ "', "
					+ "LastName = '" + LastName + "',"
					+ "ZipCode = '" + ZipCode + "',"
					+ "HomeAddress = '" + HomeAddress + "',"
					+ "EmergencyNumber = " + EmergencyNumber + ","
				//	+ "StaffID = " + StaffID + ","
					+ "EmergencyName = '" + EmergencyName + "',"
					+ "Mobile = " + Mobile + ","
					+ "DOB = '" + DOB + "',"
					+ "Title = '" + Title + "',"
					+ "Province = '" + Province + "',"
					+ "Sex = '" + Sex + "'"
					+ " WHERE HealthNumber =" + HealthNumber + ";");
					
		}
	
	// Use this method to insert any previous conditions or prescriptions the patient may have
	public static void conditionsPrescriptions(String ActivePrescriptions, String PreviousPrescriptions, 
		String ActiveConditions, String PreviousConditions) throws SQLException {
		
		Statement stmt = Main.conn.createStatement();
		stmt.executeQuery("INSERT INTO MillenniumHealthClinic.Patient (ActivePrescriptions, PreviousPrescriptions, "
				+ "ActiveConditions, PreviousConditions)"
				+ " Values(" + ActivePrescriptions + "," + PreviousPrescriptions + "," + ActiveConditions +  "," + 
				PreviousConditions + ");");
	}
	
	// Gets the list of all conditions and prescriptions
	public static void selectConditions(String table) throws SQLException {
		Statement stmt = Main.conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT ActivePrescriptions, PreviousPrescriptions, "
				+ "ActiveConditions, PreviousConditions FROM MillenniumHealthClinic.Patient);");
		while (rs.next()) {
			String select = rs.getString("ActivePrescriptions, PreviousPrescriptions,"
				+ "ActiveConditions, PreviousConditions");
			System.out.println(select + "\n");	
		}
	}

	// Method for selecting from SQL database
	public static void select(String column, String table) throws SQLException {
		Statement stmt = Main.conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT " + column + " FROM MillenniumHealthClinic." + table);
		while (rs.next()) {
			String select = rs.getString(column);
			System.out.println(select + "\n");
		}
	}

	// Method for updating SQL database
	// Format: UPDATE MillenniumHealthClinic."+ table + " SET "+ column + "="
	// +value+ " WHERE " + ID + "="+value2
	public static void update(String table, String column, String value, String ID, String value2) throws SQLException {
		Statement stmt = Main.conn.createStatement();
		int rs = stmt.executeUpdate("UPDATE MillenniumHealthClinic." + table + " SET " + column + "=" + value
				+ " WHERE " + ID + "=" + value2);
		System.out.println("Update complete\n");
	}
	
	// ----------------------------------------------------------------------------------------------------------------
		// This section contains all queries related to staff
	
		// Method for selecting staff from SQL database
		public static void selectStaff(String column, String table) throws SQLException {
			Statement stmt = Main.conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT " + column + " FROM MillenniumHealthClinic.Staff WHERE ");
			while (rs.next()) {
				String select = rs.getString(column);
				System.out.println(select + "\n");
			}
		}
		

		
		// Method for updating staff in SQL database
		public static void updateStaff(String table, String column, String value, String ID, String value2) throws SQLException {
			Statement stmt = Main.conn.createStatement();
			int rs = stmt.executeUpdate("UPDATE MillenniumHealthClinic." + table + " SET " + column + "=" + value
					+ " WHERE " + ID + "=" + value2);
			System.out.println("Update complete\n");
		}
		
		// This updates the operating hours table to set new doctors and whether or not they work a certain day
		public static void optionalUpdate(String doctor, String yesNo, String day, String setDay) throws SQLException{
			
			String doc1 = "Dr. H. Scheven";
			String doc2 = "Dr. L. Middel";
			String doc3 = "Dr. H. Hamza";
			String doc4 = "Dr. S. Saito";
		
			Statement stmt = Main.conn.createStatement();
			stmt.executeQuery("UPDATE MillenniumHealthClinic.OperatingHours "
					+ "SET " + doctor + "= " + yesNo	// SET ColumnName = Yes/No
					+ " WHERE Weekday =" + setDay + ";");	// WHERE weekday = Monday/Tuesday/Wednesday etc.. 		
			}
		
	// ----------------------------------------------------------------------------------------------------------------
	// This section contains all queries related to connections
		
		// This method makes the connection to the SQL database
		// This does NOT query anything
		public static Connection connect() {
		
		// Variables for most used values
		String userName = "kwantlen";
        String password = "kw@ntl3n";
        Connection conn = null;
        Properties connection = new Properties();
        connection.put("user", userName);
        connection.put("password", password);
        String url = "jdbc:sqlserver://info2413.database.windows.net:1433;database=MillenniumHealthClinic;"
        		+ "user=kwantlen@info2413;password=kw@ntl3n";

        // Try - catch
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("First try is good");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Second try is good - connection good");
        } catch (SQLException e1) {
            e1.printStackTrace();
            System.out.println("Error connecting to database");
        }
        
        return conn; 
	}


/*
 * Don't need this method, but keeping commented just in case public static
 * void delete(String column, String table, String value) throws
 * SQLException {
 * 
 * // Variables for most used values String userName = "kwantlen"; String
 * password = "kw@ntl3n"; Connection conn = null; Properties connection =
 * new Properties(); connection.put("user", userName);
 * connection.put("password", password); String url =
 * "jdbc:sqlserver://info2413.database.windows.net:1433;database=MillenniumHealthClinic;"
 * + "user=kwantlen@info2413;password=kw@ntl3n";
 * 
 * // Try - catch try {
 * Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
 * System.out.println("First try is good"); } catch (Exception e) {
 * e.printStackTrace(); } try { conn = DriverManager.getConnection(url);
 * System.out.println("Database connection successful"); } catch
 * (SQLException e1) { e1.printStackTrace();
 * System.out.println("Error connecting to database"); }
 * 
 * Statement stmt = conn.createStatement(); ResultSet rs =
 * stmt.executeQuery("DELETE FROM MillenniumHealthClinic."+ table +
 * "WHERE "+ column+ "='"+value+"'"); while (rs.next()) { String delete =
 * rs.getString(column); System.out.println(delete + "\n"); }
 * 
 * }
 */

//stmt.executeQuery("INSERT INTO MillenniumHealthClinic.PatientTable(Email, EmergencyNumber, ActivePrescriptions, PreviousPrescriptions, ActiveConditions, PreviousConditions, HealthNumber, StaffID, FirstName, LastName) Values('luise.middel@gmail.com' , 
		//89346, 'Active Prescription', 'PreviousPrescriptions', 'ActiveConditions', 'PreviousConditions', 45, 33, 'Luise', 'Middel')");
			
		/*stmt.executeQuery("INSERT INTO MillenniumHealthClinic." + table + " (Email, EmergencyNumber, ActivePrescriptions, PreviousPrescriptions, ActiveConditions, "
				+ "PreviousConditions, HealthNumber, StaffID, FirstName LastName) "
				+ "Values(" + "'" + Email + "' , " + EmergencyNumber + ", '" + ActivePrescriptions + "' ," + "'" + PreviousPrescriptions + "', '" + 
				ActiveConditions + "', '" + PreviousConditions + "', " + HealthNumber + ", " + StaffID + ", '" + FirstName + "', '" + LastName + "'");*/


}
