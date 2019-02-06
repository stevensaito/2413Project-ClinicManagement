package application;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class SettingsEditController {
	@FXML Button cancelbutton;
	@FXML Button savebutton;
	@FXML ComboBox monstart;
	@FXML ComboBox tuestart;
	@FXML ComboBox wedstart;
	@FXML ComboBox thursstart;
	@FXML ComboBox fristart;
	@FXML ComboBox satstart;
	@FXML ComboBox sunstart;
	@FXML ComboBox monend;
	@FXML ComboBox tueend;
	@FXML ComboBox wedend;
	@FXML ComboBox thursend;
	@FXML ComboBox friend;
	@FXML ComboBox satend;
	@FXML ComboBox sunend;
	@FXML ComboBox monrooms;
	@FXML ComboBox tuerooms;
	@FXML ComboBox wedrooms;
	@FXML ComboBox thursrooms;
	@FXML ComboBox frirooms;
	@FXML ComboBox satrooms;
	@FXML ComboBox sunrooms;
	
	@FXML ComboBox midmon;
	@FXML ComboBox midtue;
	@FXML ComboBox midwed;
	@FXML ComboBox midthurs;
	@FXML ComboBox midfri;
	@FXML ComboBox midsat;
	@FXML ComboBox midsun;
	
	@FXML ComboBox samon;
	@FXML ComboBox satue;
	@FXML ComboBox sawed;
	@FXML ComboBox sathurs;
	@FXML ComboBox safri;
	@FXML ComboBox sasat;
	@FXML ComboBox sasun;
	
	@FXML ComboBox scmon;
	@FXML ComboBox sctue;
	@FXML ComboBox scwed;
	@FXML ComboBox scthurs;
	@FXML ComboBox scfri;
	@FXML ComboBox scsat;
	@FXML ComboBox scsun;
	
	@FXML ComboBox umon;
	@FXML ComboBox utue;
	@FXML ComboBox uwed;
	@FXML ComboBox uthurs;
	@FXML ComboBox ufri;
	@FXML ComboBox usat;
	@FXML ComboBox usun;
	
	ObservableList<String>openlist = FXCollections.observableArrayList("6:00","6:30","7:00", "7:30", "8:00", "8:30", "9:00", "9:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00");
	ObservableList<String>closelist = FXCollections.observableArrayList("12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00","20:30", "21:00", "21:30", "22:00", "22:30", "23:00");
	ObservableList<Integer>roomlist= FXCollections.observableArrayList(1,2,3,4);
	ObservableList<String>work= FXCollections.observableArrayList("YES", "NO");
	@FXML public void initialize(){
		monstart.setValue("7:00");
		monstart.getItems().addAll(openlist);
		
		tuestart.setValue("7:00");
		tuestart.getItems().addAll(openlist);
	
	    wedstart.setValue("7:00");
	    wedstart.getItems().addAll(openlist);
	    
	    thursstart.setValue("7:00");
	    thursstart.getItems().addAll(openlist);
	    
	    fristart.setValue("7:00");
	    fristart.getItems().addAll(openlist);

	    satstart.setValue("7:00");
	    satstart.getItems().addAll(openlist);
	    
	    sunstart.setValue("7:00");
	    sunstart.getItems().addAll(openlist);
	    
	    sunend.setValue("7:00");
	    sunend.getItems().addAll(closelist);

		
		monend.setValue("17:00");
		monend.getItems().addAll(closelist);
			
		tueend.setValue("17:00");
		tueend.getItems().addAll(closelist);
		
	    wedend.setValue("17:00");
	    wedend.getItems().addAll(closelist);
		
	    thursend.setValue("17:00");
		thursend.getItems().addAll(closelist);
		    
	    friend.setValue("17:00");
	    friend.getItems().addAll(closelist);

       satend.setValue("17:00");
	   satend.getItems().addAll(closelist);
		    
	  sunrooms.setValue("3");
	   sunrooms.getItems().addAll(roomlist);
		    
	   monrooms.setValue("3");
	   monrooms.getItems().addAll(roomlist);
		    
	    tuerooms.setValue("3");
	   tuerooms.getItems().addAll(roomlist);
		    
	 wedrooms.setValue("3");
	   wedrooms.getItems().addAll(roomlist);
		    
	  thursrooms.setValue("3");
	   thursrooms.getItems().addAll(roomlist);
		    
	   frirooms.setValue("3");
	   frirooms.getItems().addAll(roomlist);
		    
	   satrooms.setValue("3");
	   satrooms.getItems().addAll(roomlist);
		    
	   midmon.getItems().addAll(work);
	   midmon.setValue("YES");
	   midtue.getItems().addAll(work);
	   midtue.setValue("YES");
	   midwed.getItems().addAll(work);
	   midwed.setValue("YES");
	   midthurs.getItems().addAll(work);
	   midthurs.setValue("YES");
	   midfri.getItems().addAll(work);
	   midfri.setValue("YES");
	   midsat.getItems().addAll(work);
	   midsat.setValue("YES");
	   midsun.getItems().addAll(work);
	   midsun.setValue("YES");
	   
	   samon.getItems().addAll(work);
	   samon.setValue("YES");
	   satue.getItems().addAll(work);
	   satue.setValue("YES");
	   sawed.getItems().addAll(work);
	   sawed.setValue("YES");
	   sathurs.getItems().addAll(work);
	   sathurs.setValue("YES");
	   safri.getItems().addAll(work);
	   safri.setValue("YES");
	   sasat.getItems().addAll(work);
	   sasat.setValue("YES");
	   sasun.getItems().addAll(work);
	   sasun.setValue("YES");
	   
	   scmon.getItems().addAll(work);
	   scmon.setValue("YES");
	   sctue.getItems().addAll(work);
	   sctue.setValue("YES");
	   scwed.getItems().addAll(work);
	   scwed.setValue("YES");
	   scthurs.getItems().addAll(work);
	   scthurs.setValue("YES");
	   scfri.getItems().addAll(work);
	   scfri.setValue("YES");
	   scsat.getItems().addAll(work);
	   scsat.setValue("YES");
	   scsun.getItems().addAll(work);
	   scsun.setValue("YES");
	   
	   umon.getItems().addAll(work);
	   umon.setValue("YES");
	   utue.getItems().addAll(work);
	   utue.setValue("YES");
	   uwed.getItems().addAll(work);
	   uwed.setValue("YES");
	   uthurs.getItems().addAll(work);
	   uthurs.setValue("YES");
	   ufri.getItems().addAll(work);
	   ufri.setValue("YES");
	   usat.getItems().addAll(work);
	   usat.setValue("YES");
	   usun.getItems().addAll(work);
	   usun.setValue("YES");
	   
	
	
	}
	@FXML public void handleUpdateSettings(ActionEvent event) throws IOException, SQLException{
		
		Statement stmt = Main.conn.createStatement();
		//monday
		stmt.executeUpdate("UPDATE MillenniumHealthClinic.OperatingHours "
				+ "SET [Open] = '" +(String) monstart.getSelectionModel().getSelectedItem()+ "',"
				+ "[Close] = '" + (String) monend.getSelectionModel().getSelectedItem() + "',"
				+ "[Dr. H. Scheven] = '" + (String) scmon.getSelectionModel().getSelectedItem() + "',"
				+ "[Dr. L. Middel] ='" +(String) midmon.getSelectionModel().getSelectedItem()+ "', "
				+ "[Dr. H. Hamza] = '" + (String) umon.getSelectionModel().getSelectedItem() + "',"
				+ "[Dr. S. Saito] = '" + (String) samon.getSelectionModel().getSelectedItem() + "',"
				+ "RoomsAvailable = " + Integer.parseInt((String) monrooms.getSelectionModel().getSelectedItem()) 
				+ " WHERE Weekday = 'Monday';");
		//tuesday
		stmt.executeUpdate("UPDATE MillenniumHealthClinic.OperatingHours "
				+ "SET [Open] = '" + (String) tuestart.getSelectionModel().getSelectedItem() + "',"
				+ "[Close] = '" + (String) tueend.getSelectionModel().getSelectedItem() + "',"
				+ "[Dr. H. Scheven] = '" + (String) sctue.getSelectionModel().getSelectedItem() + "',"
				+ "[Dr. L. Middel] ='" +(String) midtue.getSelectionModel().getSelectedItem()+ "', "
				+ "[Dr. H. Hamza] = '" + (String) utue.getSelectionModel().getSelectedItem() + "',"
				+ "[Dr. S. Saito] = '" + (String) satue.getSelectionModel().getSelectedItem() + "',"
				+ "RoomsAvailable = '" + Integer.parseInt((String) tuerooms.getSelectionModel().getSelectedItem()) + "'"
				+ " WHERE Weekday = 'Tuesday';");
		//wednesday		
		stmt.executeUpdate("UPDATE MillenniumHealthClinic.OperatingHours "
				+ "SET [Open] = '" + (String) wedstart.getSelectionModel().getSelectedItem() + "',"
				+ "[Close] = '" + (String) wedend.getSelectionModel().getSelectedItem() + "',"
				+ "[Dr. H. Scheven] = '" + (String) scwed.getSelectionModel().getSelectedItem() + "',"
				+ "[Dr. L. Middel] ='" +(String) midwed.getSelectionModel().getSelectedItem()+ "', "
				+ "[Dr. H. Hamza] = '" + (String) uwed.getSelectionModel().getSelectedItem() + "',"
				+ "[Dr. S. Saito] = '" + (String) sawed.getSelectionModel().getSelectedItem() + "',"
				+ "RoomsAvailable = '" + (String) wedrooms.getSelectionModel().getSelectedItem() + "'"
				+ " WHERE Weekday = 'Wednesday';");
		//thursday
		stmt.executeUpdate("UPDATE MillenniumHealthClinic.OperatingHours "
				+ "SET [Open] = '" + (String) thursstart.getSelectionModel().getSelectedItem() + "',"
				+ "[Close] = '" + (String) thursend.getSelectionModel().getSelectedItem() + "',"
				+ "[Dr. H. Scheven] = '" + (String) scthurs.getSelectionModel().getSelectedItem() + "',"
				+ "[Dr. L. Middel] ='" +(String) midthurs.getSelectionModel().getSelectedItem()+ "', "
				+ "[Dr. H. Hamza] = '" + (String) uthurs.getSelectionModel().getSelectedItem() + "',"
				+ "[Dr. S. Saito] = '" + (String) sathurs.getSelectionModel().getSelectedItem() + "',"
				+ "RoomsAvailable = '" + (String) thursrooms.getSelectionModel().getSelectedItem() + "'"
				+ " WHERE Weekday = 'Thursday';");
		//friday
		stmt.executeUpdate("UPDATE MillenniumHealthClinic.OperatingHours "
				+ "SET [Open] = '" + (String) fristart.getSelectionModel().getSelectedItem() + "',"
				+ "[Close] = '" + (String) friend.getSelectionModel().getSelectedItem() + "',"
				+ "[Dr. H. Scheven] = '" + (String) scfri.getSelectionModel().getSelectedItem() + "',"
				+ "[Dr. L. Middel] ='" +(String) midfri.getSelectionModel().getSelectedItem()+ "', "
				+ "[Dr. H. Hamza] = '" + (String) ufri.getSelectionModel().getSelectedItem() + "',"
				+ "[Dr. S. Saito] = '" + (String) safri.getSelectionModel().getSelectedItem() + "',"
				+ "RoomsAvailable = '" + (String) frirooms.getSelectionModel().getSelectedItem() + "'"
				+ " WHERE Weekday = 'Friday';");
		//saturday
		stmt.executeUpdate("UPDATE MillenniumHealthClinic.OperatingHours "
				+ "SET [Open] = '" + (String) satstart.getSelectionModel().getSelectedItem() + "',"
				+ "[Close] = '" + (String) satend.getSelectionModel().getSelectedItem() + "',"
				+ "[Dr. H. Scheven] = '" + (String) scsat.getSelectionModel().getSelectedItem() + "',"
				+ "[Dr. L. Middel] ='" +(String) midsat.getSelectionModel().getSelectedItem()+ "', "
				+ "[Dr. H. Hamza] = '" + (String) usat.getSelectionModel().getSelectedItem() + "',"
				+ "[Dr. S. Saito] = '" + (String) sasat.getSelectionModel().getSelectedItem() + "',"
				+ "RoomsAvailable = '" + (String) satrooms.getSelectionModel().getSelectedItem() + "'"
				+ " WHERE Weekday = 'Saturday';");
		//sunday
		stmt.executeUpdate("UPDATE MillenniumHealthClinic.OperatingHours "
				+ "SET [Open] = '" + (String) sunstart.getSelectionModel().getSelectedItem() + "',"
				+ "[Close] = '" + (String) sunend.getSelectionModel().getSelectedItem() + "',"
				+ "[Dr. H. Scheven] = '" + (String) scsun.getSelectionModel().getSelectedItem() + "',"
				+ "[Dr. L. Middel] ='" +(String) midsun.getSelectionModel().getSelectedItem()+ "', "
				+ "[Dr. H. Hamza] = '" + (String) usun.getSelectionModel().getSelectedItem() + "',"
				+ "[Dr. S. Saito] = '" + (String) sasun.getSelectionModel().getSelectedItem() + "',"
				+ "RoomsAvailable = '" + (String) sunrooms.getSelectionModel().getSelectedItem() + "'"
				+ " WHERE Weekday = 'Sunday';");
		
				handleCancelSettings(event);
	}
	
	@FXML public void handleCancelSettings(ActionEvent event) throws IOException{
		 Stage stage = (Stage) cancelbutton.getScene().getWindow();
		 stage.close();
	}
}
