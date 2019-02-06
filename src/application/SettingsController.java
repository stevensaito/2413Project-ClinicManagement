package application;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


	public class SettingsController {
		
		@FXML public Label username;
		@FXML public Label monstart;
		@FXML public Label tuestart;
		@FXML public Label wedstart;
		@FXML public Label thursstart;
		@FXML public Label fristart;
		@FXML public Label satstart;
		@FXML public Label sunstart;
		@FXML public Label monend;
		@FXML public Label tueend;
		@FXML public Label wedend;
		@FXML public Label thursend;
		@FXML public Label friend;
		@FXML public Label satend;
		@FXML public Label sunend;
		@FXML public Label monroom;
		@FXML public Label tueroom;
		@FXML public Label wedroom;
		@FXML public Label thursroom;
		@FXML public Label friroom;
		@FXML public Label satroom;
		@FXML public Label sunroom;
		@FXML public Label drmon;
		@FXML public Label drtue;
		@FXML public Label drwed;
		@FXML public Label drthurs;
		@FXML public Label drfri;
		@FXML public Label drsat;
		@FXML public Label drsun;
		
		@FXML public void initialize() throws SQLException{
			username.setText(LoginController.user);
			Statement stmt = Main.conn.createStatement();
			
			String doc1= ""; 
			String doc2= "";
			String doc3= "";
			String doc4= "";
			
				
			ResultSet rsmon2 = stmt.executeQuery("SELECT * FROM MillenniumHealthClinic.OperatingHours WHERE WeekDay ='Monday'");
			while(rsmon2.next()){
				if((rsmon2.getString("Dr. H. Scheven")).trim().equals("YES")){
					doc1 = "Dr. H. Scheven";
				}
				else{
					doc1 ="";
				}
				if((rsmon2.getString("Dr. L. Middel")).trim().equals("YES")){
					doc2 = "Dr. L. Middel";
				}
				else{
					doc2 ="";
				}
				if((rsmon2.getString("Dr. H. Hamza")).trim().equals("YES")){
					doc3 = "Dr. H. Hamza";
				}
				else{
					doc3 ="";
				}
				if((rsmon2.getString("Dr. S. Saito")).trim().equals("YES")){
					doc4 = "Dr. H. Hamza";
				}
				else{
					doc4 ="";
				}
			}
			
			drmon.setText(doc1 + " " + doc2 +" " +doc3 + " " + doc4);	
			
			
			
			ResultSet rstue2 = stmt.executeQuery("SELECT * FROM MillenniumHealthClinic.OperatingHours WHERE WeekDay ='Tuesday'");
			while(rstue2.next()){
				if((rstue2.getString("Dr. H. Scheven")).trim().equals("YES")){
					doc1 = "Dr. H. Scheven";
				}
				else{
					doc1 ="";
				}
				if((rstue2.getString("Dr. L. Middel")).trim().equals("YES")){
					doc2 = "Dr. L. Middel";
				}
				else{
					doc2 ="";
				}
				if((rstue2.getString("Dr. H. Hamza")).trim().equals("YES")){
					doc3 = "Dr. H. Hamza";
				}
				else{
					doc3 ="";
				}
				if((rstue2.getString("Dr. S. Saito")).trim().equals("YES")){
					doc4 = "Dr. S. Saito";
				}
				else{
					doc4 ="";
				}
			}
			
			drtue.setText(doc1 + " " + doc2 +" " +doc3 + " " + doc4);	
			
			ResultSet rswed2 = stmt.executeQuery("SELECT * FROM MillenniumHealthClinic.OperatingHours WHERE WeekDay ='Wednesday'");
			while(rswed2.next()){
				if((rswed2.getString("Dr. H. Scheven")).trim().equals("YES")){
					doc1 = "Dr. H. Scheven";
				}
				else{
					doc1 ="";
				}
				if((rswed2.getString("Dr. L. Middel")).trim().equals("YES")){
					doc2 = "Dr. L. Middel";
				}
				else{
					doc2 ="Test";
				}
				if((rswed2.getString("Dr. H. Hamza")).trim().equals("YES")){
					doc3 = "Dr. H. Hamza";
				}
				else{
					doc3 ="";
				}
				if((rswed2.getString("Dr. S. Saito")).trim().equals("YES")){
					doc4 = "Dr. S. Saito";
				}
				else{
					doc4 ="";
				}
			}
			
			drwed.setText(doc1 + " " + doc2 +" " +doc3 + " " + doc4);	
			
			
			ResultSet rsthurs2 = stmt.executeQuery("SELECT * FROM MillenniumHealthClinic.OperatingHours WHERE WeekDay ='Thursday'");
			while(rsthurs2.next()){
				if((rsthurs2.getString("Dr. H. Scheven")).trim().equals("YES")){
					doc1 = "Dr. H. Scheven";
				}
				else{
					doc1 ="";
				}
				if((rsthurs2.getString("Dr. L. Middel")).trim().equals("YES")){
					doc2 = "Dr. L. Middel";
				}
				else{
					doc2 ="Test";
				}
				if((rsthurs2.getString("Dr. H. Hamza")).trim().equals("YES")){
					doc3 = "Dr. H. Hamza";
				}
				else{
					doc3 ="";
				}
				if((rsthurs2.getString("Dr. S. Saito")).trim().equals("YES")){
					doc4 = "Dr. S. Saito";
				}
				else{
					doc4 ="";
				}
			}
			
			drthurs.setText(doc1 + " " + doc2 +" " +doc3 + " " + doc4);	
			
			ResultSet rsfri2 = stmt.executeQuery("SELECT * FROM MillenniumHealthClinic.OperatingHours WHERE WeekDay ='Friday'");
			while(rsfri2.next()){
				if((rsfri2.getString("Dr. H. Scheven")).trim().equals("YES")){
					doc1 = "Dr. H. Scheven";
				}
				else{
					doc1 ="";
				}
				if((rsfri2.getString("Dr. L. Middel")).trim().equals("YES")){
					doc2 = "Dr. L. Middel";
				}
				else{
					doc2 ="Test";
				}
				if((rsfri2.getString("Dr. H. Hamza")).trim().equals("YES")){
					doc3 = "Dr. H. Hamza";
				}
				else{
					doc3 ="";
				}
				if((rsfri2.getString("Dr. S. Saito")).trim().equals("YES")){
					doc4 = "Dr. S. Saito";
				}
				else{
					doc4 ="";
				}
			}
			
			drfri.setText(doc1 + " " + doc2 +" " +doc3 + " " + doc4);
			
			ResultSet rssat2 = stmt.executeQuery("SELECT * FROM MillenniumHealthClinic.OperatingHours WHERE WeekDay ='Saturday'");
			while(rssat2.next()){
				if((rssat2.getString("Dr. H. Scheven")).trim() == "YES"){
					doc1 = "Dr. H. Scheven";
				}
				else{
					doc1 ="";
				}
				if((rssat2.getString("Dr. L. Middel")).trim().equals("YES")){
					doc2 = "Dr. L. Middel";
				}
				else{
					doc2 ="Test";
				}
				if((rssat2.getString("Dr. H. Hamza")).trim().equals("YES")){
					doc3 = "Dr. H. Hamza";
				}
				else{
					doc3 ="";
				}
				if((rssat2.getString("Dr. S. Saito")).trim().equals("YES")){
					doc4 = "Dr. S. Saito";
				}
				else{
					doc4 ="";
				}
			}
			
			drsat.setText(doc1 + " " + doc2 +" " +doc3 + " " + doc4);	
			
			ResultSet rssun2 = stmt.executeQuery("SELECT * FROM MillenniumHealthClinic.OperatingHours WHERE WeekDay ='Sunday'");
			while(rssun2.next()){
				if((rssun2.getString("Dr. H. Scheven")).trim() == "YES"){
					doc1 = "Dr. H. Scheven";
				}
				else{
					doc1 ="";
				}
				if((rssun2.getString("Dr. L. Middel")).trim().equals("YES")){
					doc2 = "Dr. L. Middel";
				}
				else{
					doc2 ="Test";
				}
				if((rssun2.getString("Dr. H. Hamza")).trim().equals("YES")){
					doc3 = "Dr. H. Hamza";
				}
				else{
					doc3 ="";
				}
				if((rssun2.getString("Dr. S. Saito")).trim().equals("YES")){
					doc4 = "Dr. H. Hamza";
				}
				else{
					doc4 ="";
				}
			}
			
			drsun.setText(doc1 + " " + doc2 +" " +doc3 + " " + doc4);	
			
			ResultSet rsmon = stmt.executeQuery("SELECT * FROM MillenniumHealthClinic.OperatingHours WHERE WeekDay ='Monday'");
			while(rsmon.next()){
				monstart.setText(rsmon.getString("Open"));
				monend.setText(rsmon.getString("Close"));
				monroom.setText(rsmon.getString("RoomsAvailable"));
			}
			
			ResultSet rstue = stmt.executeQuery("SELECT * FROM MillenniumHealthClinic.OperatingHours WHERE WeekDay = 'Tuesday'");
			while(rstue.next()){
				tuestart.setText(rstue.getString("Open"));
				tueend.setText(rstue.getString("Close"));
				tueroom.setText(rstue.getString("RoomsAvailable"));
			}
			
			ResultSet rswed = stmt.executeQuery("SELECT * FROM MillenniumHealthClinic.OperatingHours WHERE WeekDay = 'Wednesday'");
			while(rswed.next()){
				wedstart.setText(rswed.getString("Open"));
				wedend.setText(rswed.getString("Close"));
				wedroom.setText(rswed.getString("RoomsAvailable"));
			}
			
			ResultSet rsthurs = stmt.executeQuery("SELECT * FROM MillenniumHealthClinic.OperatingHours WHERE WeekDay = 'Thursday'");
			while(rsthurs.next()){
				thursstart.setText(rsthurs.getString("Open"));
				thursend.setText(rsthurs.getString("Close"));
				thursroom.setText(rsthurs.getString("RoomsAvailable"));
			}
			
			ResultSet rsfri = stmt.executeQuery("SELECT * FROM MillenniumHealthClinic.OperatingHours WHERE WeekDay = 'Friday'");
			while(rsfri.next()){
				fristart.setText(rsfri.getString("Open"));
				friend.setText(rsfri.getString("Close"));
				friroom.setText(rsfri.getString("RoomsAvailable"));
			}
			
			ResultSet rssat = stmt.executeQuery("SELECT * FROM MillenniumHealthClinic.OperatingHours WHERE WeekDay = 'Saturday'");
			while(rssat.next()){
				satstart.setText(rssat.getString("Open"));
				satend.setText(rssat.getString("Close"));
				satroom.setText(rssat.getString("RoomsAvailable"));
			}
			
			ResultSet rssun = stmt.executeQuery("SELECT * FROM MillenniumHealthClinic.OperatingHours WHERE WeekDay = 'Sunday'");
			while(rssun.next()){
				sunstart.setText(rssun.getString("Open"));
				sunend.setText(rssun.getString("Close"));
				sunroom.setText(rssun.getString("RoomsAvailable"));
			}
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
		
		//press edit button
		@FXML public void handleEditSettings(ActionEvent event) throws IOException{
			Functions.handleEditSettings(event);
		}
		
		//press save button
		@FXML public void handleSaveSettings(ActionEvent event) throws IOException{
			Functions.handleSaveSettings(event);
		}
		
		//press cancel button
		@FXML public void handleCancelSettings(ActionEvent event) throws IOException{
			Functions.handleCancelSettings(event);
		}
}
