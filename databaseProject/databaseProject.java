/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseProject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.ListView;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.sql.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.text.Text;
import javafx.util.Callback;

/**
 *
 * @author Aaron
 */
public class databaseProject extends Application {
    
  // PreparedStatement for executing queries
  private PreparedStatement preparedStatement;
  
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
    VBox vBox = new VBox(10);
    Scene scene = new Scene(vBox, 420, 200);
    
    
    primaryStage.setTitle("Database GUI"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
  }

  private boolean initializeDB(String connectionInfo, String user, String pass) {
    try {

      // Establish a connection
      Connection connection = DriverManager.getConnection
        (connectionInfo, user, pass);

      System.out.println("Database connected");

      String queryString = "select * from Employee";

      // Create a statement
      preparedStatement = connection.prepareStatement(queryString);
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
