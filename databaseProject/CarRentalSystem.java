/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrentalsystem;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.sql.*;
import static javafx.application.Application.launch;

public class CarRentalSystem extends Application {
  // PreparedStatement for executing queries
  private PreparedStatement preparedStatement;
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
  
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    // Initialize database connection and create a Statement object
    initializeDB();

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
    hBox1.getChildren().addAll(new Label("VIN"), tfVIN, btShow,btUpdate,btDelete,btInsert);
    hBox2.getChildren().addAll(lbl1,tfModel);
    hBox3.getChildren().addAll(lbl2,tfDescription);
    hBox4.getChildren().addAll(lbl3,tfPlace);
    hBox5.getChildren().addAll(lbl4,tfInsurance);
    hBox6.getChildren().addAll(lbl5,tfPassengers);

    VBox vBox = new VBox(10);
    vBox.getChildren().addAll(hBox1,hBox2,hBox3,hBox4,hBox5,hBox6);
    
    tfVIN.setPrefColumnCount(6);
    
    btShow.setOnAction(e -> showTable());
    btUpdate.setOnAction(e -> doUpdate());
    btDelete.setOnAction(e -> doDelete());
    btInsert.setOnAction(e -> doInsert());

    // Create a scene and place it in the stage
    Scene scene = new Scene(vBox, 600, 280);
    primaryStage.setTitle("VehicleTable"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage   
  }

  private void initializeDB() {
    try {

      // Establish a connection
      Connection connection = DriverManager.getConnection
        ("jdbc:derby://localhost:1527/CarRental", "scott", "tiger");

      System.out.println("Database connected");

      String queryString = "select model, description, " +
        "place, insurance, passengers,vin from Vehicle " +
        "where Vehicle.vin = ? ";
      String updateQuery = "UPDATE vehicle SET " +
	"model = ?, description = ?, place = ?, insurance = ?, passengers = ? " +
	"WHERE vin = ?";
       String deleteQuery = "DELETE FROM vehicle " +
	"WHERE vin = ?";
      
      String insertQuery = "INSERT INTO vehicle " +
	"VALUES(?, ?, ?, ?, ?, ?)";
      // Create a statement
      preparedStatement = connection.prepareStatement(queryString);
      preparedStatement = connection.prepareStatement(queryString);
      preparedStatement = connection.prepareStatement(queryString);

    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  private void showTable() {
    String vin = tfVIN.getText();
   
    try {
      preparedStatement.setString(1, vin);
      ResultSet rset = preparedStatement.executeQuery();

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
        tfModel.setText("Not found");
      }
    }
    catch (SQLException ex) {
      ex.printStackTrace();
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

