/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseProject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.sql.*;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

/**
 *
 * @author Aaron
 */
public class databaseProject extends Application {
    
  // PreparedStatement for executing queries
  private PreparedStatement selectStatement;
  private PreparedStatement insertStatement;
  private PreparedStatement updateStatement;
  private PreparedStatement deleteStatement;
  
  private TextField tfVIN = new TextField();
private TextField tfModel = new TextField();
private TextField tfDescription = new TextField();
private TextField tfPlace = new TextField();
private TextField tfInsurance = new TextField();
private TextField tfPassengers = new TextField();

  private Label lbl1 = new Label("Model");
  private Label lbl2 = new Label("Description");
  private Label lbl3 = new Label("Place");
  private Label lbl4 = new Label("Insurance");
  private Label lbl5 = new Label("Passengers");
  private Label lbl6 = new Label("");
  
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
      
    VBox login = new VBox(10);
    // Create a scene and place it in the stage
    Scene dbLogin = new Scene(login, 420, 200);
      
    // Input forms for the database
    TextArea dbInput = new TextArea();
    TextArea dbUser = new TextArea();
    TextArea dbPassword = new TextArea();
    
    Text loginPrompt = new Text("Please input database information. (Database location, username, password)");
    
    login.getChildren().add(loginPrompt);
    login.getChildren().add(dbInput);
    login.getChildren().add(dbUser);
    login.getChildren().add(dbPassword);
    
    Button dbConnect = new Button("Login");
    dbConnect.setPrefSize(100, 20);
    dbConnect.setOnAction(new EventHandler<ActionEvent>() {
	 @Override public void handle(ActionEvent e) {
	     if (initializeDB(dbInput.getText(), dbUser.getText(), dbPassword.getText())) {
		dbWindow(primaryStage);
	     }
	 }
     });
    
    login.getChildren().add(dbConnect);
    
    primaryStage.setTitle("Please input database information"); // Set the stage title
    primaryStage.setScene(dbLogin); // Place the scene in the stage
    primaryStage.show(); // Display the stage   
  }
  
  private void dbWindow(Stage primaryStage) {    
    Button btShow = new Button("Show Vehicle");
    Button btUpdate = new Button("Update Vehicle");
    Button btDelete = new Button("Delete Vehicle");
    Button btInsert = new Button("Insert Vehicle");
    

    HBox hBox1 = new HBox(5);
    HBox hBox2 = new HBox(5);
    HBox hBox3 = new HBox(5);
    HBox hBox4 = new HBox(5);
    HBox hBox5 = new HBox(5);
    HBox hBox6 = new HBox(5);
    HBox hBox7 = new HBox(5);
    hBox1.getChildren().addAll(new Label("VIN"), tfVIN, btShow,btUpdate,btDelete,btInsert);
    hBox2.getChildren().addAll(lbl1,tfModel);
    hBox3.getChildren().addAll(lbl2,tfDescription);
    hBox4.getChildren().addAll(lbl3,tfPlace);
    hBox5.getChildren().addAll(lbl4,tfInsurance);
    hBox6.getChildren().addAll(lbl5,tfPassengers);
    hBox7.getChildren().add(lbl6);

    VBox vBox = new VBox(10);
    vBox.getChildren().addAll(hBox1,hBox2,hBox3,hBox4,hBox5,hBox6,hBox7);
    
    tfVIN.setPrefColumnCount(6);   
    
    btShow.setOnAction(new EventHandler<ActionEvent>() {
	 @Override public void handle(ActionEvent e) {	     
	    try{
		selectStatement.setString(1, tfVIN.getText());
		ResultSet rset = selectStatement.executeQuery();
		if (rset.next()) {
		String model = rset.getString(1);
		String decription = rset.getString(2);
		String place = rset.getString(3);
		String insurance = rset.getString(4);
		String passengers = rset.getString(5);

		// Display result in a label
		tfModel.setText(model);
		tfDescription.setText(decription);  
		tfPlace.setText(place); 
		tfInsurance.setText(insurance); 
		tfPassengers.setText(passengers); 
	      } else {
		lbl6.setText("Not found");
	      }
	    }
	    catch(SQLException ex){
		ex.printStackTrace();
	    }
	 }
     });
    
    btUpdate.setOnAction(new EventHandler<ActionEvent>() {
	 @Override public void handle(ActionEvent e) {
	     try{
		updateStatement.setString(1, tfModel.getText());
		updateStatement.setString(2, tfDescription.getText());
		updateStatement.setString(3, tfPlace.getText());
		updateStatement.setString(4, tfInsurance.getText());
		updateStatement.setString(5, tfPassengers.getText());
		updateStatement.setString(6, tfVIN.getText());
		
		updateStatement.execute();
		lbl6.setText("Successful update!");
	     }
	     catch(SQLException ex){
		 ex.printStackTrace();
		 lbl6.setText("Update failed!");
	     }
	 }
     });
    
    btDelete.setOnAction(new EventHandler<ActionEvent>() {
	 @Override public void handle(ActionEvent e) {
	     try{
		deleteStatement.setString(1, tfVIN.getText());
		 
		deleteStatement.execute();
		lbl6.setText("Successful delete!");
	     }
	     catch(SQLException ex){
		 ex.printStackTrace();
		 lbl6.setText("Delete failed!");
	     }
	 }
     });
    
    btInsert.setOnAction(new EventHandler<ActionEvent>() {
	 @Override public void handle(ActionEvent e) {
	     try{
		insertStatement.setString(1, tfModel.getText());
		insertStatement.setString(2, tfDescription.getText());
		insertStatement.setString(3, tfPlace.getText());
		insertStatement.setString(4, tfInsurance.getText());
		insertStatement.setString(5, tfPassengers.getText());
		insertStatement.setString(6, tfVIN.getText());
		 
		insertStatement.execute();
		lbl6.setText("Successful insert!");
	     }
	     catch(SQLException ex){
		 ex.printStackTrace();
		 lbl6.setText("Insert failed!");
	     }
	 }
     });
    

    // Create a scene and place it in the stage
    Scene scene = new Scene(vBox, 600, 280);
    
    primaryStage.setTitle("Database GUI"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
  }

  private boolean initializeDB(String connectionInfo, String user, String pass) {
    try {

      // Establish a connection
      Connection connection = DriverManager.getConnection
        (connectionInfo, user, pass);

      System.out.println("Database connected");

      String queryString = "SELECT * FROM vehicle WHERE vin = ?";
      
      String updateQuery = "UPDATE vehicle SET " +
	"model = ?, description = ?, place = ?, insurance = ?, passengers = ? " +
	"WHERE vin = ?";
      
      String deleteQuery = "DELETE FROM vehicle " +
	"WHERE vin = ?";
      
      String insertQuery = "INSERT INTO vehicle " +
	"VALUES(?, ?, ?, ?, ?, ?)";

      // Create a statement
      selectStatement = connection.prepareStatement(queryString);
      updateStatement = connection.prepareStatement(updateQuery);
      deleteStatement = connection.prepareStatement(deleteQuery);
      insertStatement = connection.prepareStatement(insertQuery);
      
      //bookStatement = connection.prepareStatement(bookQuery);
      return true;
    }
    catch (Exception ex) {
      ex.printStackTrace();
      return false;
    }
  }
  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
