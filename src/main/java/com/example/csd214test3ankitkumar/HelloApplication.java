package com.example.csd214test3ankitkumar;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public double TotalBill(String pizzaSize, int toppingCount) {
        double pizzaPrice;
        switch (pizzaSize) {
            case "XL":
                pizzaPrice = 15.00;
                break;
            case "L":
                pizzaPrice = 12.00;
                break;
            case "M":
                pizzaPrice = 10.00;
                break;
            case "S":
                pizzaPrice = 8.00;
                break;
            default:
                return -1.00;        }

        double totalBill = (pizzaPrice + (1.50 * toppingCount)) * 1.15;

        return totalBill;
    }
}