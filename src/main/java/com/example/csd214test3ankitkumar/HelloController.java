package com.example.csd214test3ankitkumar;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class HelloController implements HelloControllerr {

    public Label welcomeText;
    public TextField eID;
    public TextField eCustomerName;
    public TextField eMobileNumber;
    public TextField ePizzaSize;
    public TextField eTopings;

    public TextField eBill;

    @FXML
    private TableView<PizzaOrder> tableView;
    @FXML
    private TableColumn<PizzaOrder, Integer> ID;
    @FXML
    private TableColumn<PizzaOrder , String> CustomerName;
    @FXML
    private TableColumn<PizzaOrder, String> MobileNumber;
    @FXML
    private TableColumn<PizzaOrder, String> PizzaSize;
    @FXML
    private TableColumn<PizzaOrder, String> Topings;
    @FXML
    private TableColumn<PizzaOrder, String> Bill;


    @FXML
    ObservableList<PizzaOrder> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ID.setCellValueFactory(new
                PropertyValueFactory<PizzaOrder, Integer>("ID"));
        CustomerName.setCellValueFactory(new
                PropertyValueFactory<PizzaOrder, String>("CustomerName"));
        MobileNumber.setCellValueFactory(new
                PropertyValueFactory<PizzaOrder, String>("MobileNumber"));
        PizzaSize.setCellValueFactory(new
                PropertyValueFactory<PizzaOrder, String>("PizzaSize"));
        Topings.setCellValueFactory(new
                PropertyValueFactory<PizzaOrder, String>("Topings"));
        Bill.setCellValueFactory(new
                PropertyValueFactory<PizzaOrder, String>("Bill"));




        tableView.setItems(list);
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void populateTable() {
// Establish a database connection
        String jdbcUrl = "jdbc:mysql://localhost:3306/pizzapizza";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
// Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM `pizza`";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            list.clear();
// Populate the table with data from the database
            while (resultSet.next()) {
                int eID = resultSet.getInt("ID");
                String eCustomerName = resultSet.getString("CustomerName");
                String eMobileNumber = resultSet.getString("MobileNumber");
                String ePizzaSize = resultSet.getString("PizzaSize");
                String eTopings = resultSet.getString("Topings");
                String eBill = resultSet.getString("Bill");


                tableView.getItems().add(new PizzaOrder(eID, eCustomerName, eMobileNumber, ePizzaSize, eTopings, eBill));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

    public void Insertbutton(ActionEvent actionEvent) {

        String a = eCustomerName.getText();
        String b = eMobileNumber.getText();
        String c = ePizzaSize.getText();
        String d = eTopings.getText();
        String f = eBill.getText();

        Insertbutton(a, b, c, d, f);
    }

    private void Insertbutton(String a, String b, String c, String d, String f) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/pizzapizza";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
// Execute a SQL query to retrieve data from the database
            String query = "INSERT INTO `pizza`(`CustomerName`, `MobileNumber`, `PizzaSize`, `Topings`, `Bill`) VALUES ('" + a + "','" + b + "','" + c + "','" + d + "','" + f + "')";
            var statement = connection.createStatement();
            statement.execute(query);
// Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

    public void Deletebutton(ActionEvent actionEvent) {


        String EID = eID.getText();

        String jdbcUrl = "jdbc:mysql://localhost:3306/pizzapizza";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
// Execute a SQL query to retrieve data from the database
            String query = "DELETE FROM `pizza` WHERE ID='" + EID + "'";
            Statement statement = connection.createStatement();
            statement.execute(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void Updatebutton(ActionEvent actionEvent) {

        String Eid = eID.getText();
        String ECustomerName = eCustomerName.getText();
        String EMobileNumber = eMobileNumber.getText();
        String EPizzaSize = ePizzaSize.getText();
        String ETopings = eTopings.getText();
        String EBill = eBill.getText();


        String jdbcUrl = "jdbc:mysql://localhost:3306/pizzapizza";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
// Execute a SQL query to retrieve data from the database
            String query = "UPDATE `pizza` SET `CustomerName`='" + ECustomerName + "',`MobileNumber`='" + EMobileNumber + "',`PizzaSize`='" + EPizzaSize + "',`Topings`='" + ETopings + "',`Bill`='" + EBill + "' WHERE id='" + Eid + "'";
            Statement statement = connection.createStatement();
            statement.execute(query);

            populateTable();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Loadbutton(ActionEvent actionEvent) {
        String EID = eID.getText();

        String jdbcUrl = "jdbc:mysql://localhost:3306/pizzapizza";
        String dbUser = "root";
        String dbPassword = "";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
// Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM `pizza` WHERE id='" + EID + "'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
// Populate the table with data from the database
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String CustomerName = resultSet.getString("CustomerName");
                String MobileNumber = resultSet.getString("MobileNumber");
                String PizzaSize = resultSet.getString("PizzaSize");
                String Topings = resultSet.getString("Topings");
                String Bill = resultSet.getString("Bill");


                eCustomerName.setText(CustomerName);
                eMobileNumber.setText(MobileNumber);
                ePizzaSize.setText(PizzaSize);
                eTopings.setText(Topings);
                eBill.setText(Bill);


            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }


}