
/**
 * Sample Skeleton for 'login.fxml' Controller Class
 */

package com.example.movieticket;
import javafx.scene.Node;
import javafx.fxml.FXML;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.sql.*;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.EventObject;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;

import javafx.scene.layout.AnchorPane;

public class dashboardcontroller  {
    @FXML
    private Label dashboard_totalAvaibleMovies;

    @FXML
    private Label dashboard_totalEarnToday;

    @FXML
    private Label dashboard_totalSoldTicket;


    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="create"
    private Hyperlink create; // Value injected by FXMLLoader

    @FXML // fx:id="cust"
    private TextField cust; // Value injected by FXMLLoader

    @FXML // fx:id="log"
    private Button log; // Value injected by FXMLLoader

    @FXML // fx:id="login_page"
    private AnchorPane login_page; // Value injected by FXMLLoader

    @FXML // fx:id="nbjbvhj"
    private AnchorPane nbjbvhj; // Value injected by FXMLLoader

    @FXML // fx:id="pass"
    private PasswordField pass; // Value injected by FXMLLoader

    @FXML // fx:id="sign"
    private Label sign; // Value injected by FXMLLoader

    @FXML
    void initialize() {
//        assert addmovies_form != null : "fx:id=\"addmovies_form\" was not injected: check your FXML file 'home.fxml'.";
//        assert availablemovies_form != null : "fx:id=\"availablemovies_form\" was not injected: check your FXML file 'home.fxml'.";
//        assert customer_form != null : "fx:id=\"customer_form\" was not injected: check your FXML file 'home.fxml'.";
//        assert dashboard != null : "fx:id=\"dashboard\" was not injected: check your FXML file 'home.fxml'.";
//        assert dashboard_form != null : "fx:id=\"dashboard_form\" was not injected: check your FXML file 'home.fxml'.";
//        assert dashboard_total != null : "fx:id=\"dashboard_total\" was not injected: check your FXML file 'home.fxml'.";
        assert dashboard_totalAvaibleMovies != null : "fx:id=\"dashboard_totalAvaibleMovies\" was not injected: check your FXML file 'home.fxml'.";
        assert dashboard_totalEarnToday != null : "fx:id=\"dashboard_totalEarnToday\" was not injected: check your FXML file 'home.fxml'.";
        assert dashboard_totalSoldTicket != null : "fx:id=\"dashboard_totalSoldTicket\" was not injected: check your FXML file 'home.fxml'.";
        DatabaseConnection connectnow = new DatabaseConnection();

        Connection connectdb = connectnow.getconnection();
        PreparedStatement ptotalearn ,ptotaltickets,pavailablemovies= null;
        try {

        ResultSet rs = null;

            ptotalearn = connectdb.prepareStatement("select SUM(Totalearning)  as avai from avaiblemovies;");

            rs = ptotalearn.executeQuery();
            while (rs.next()) {
                int c = rs.getInt("avai");
                dashboard_totalEarnToday.setText(String.valueOf("$"+c));
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {

            ResultSet rs = null;

        ptotaltickets = connectdb.prepareStatement("select SUM(totaltickets)  as avai from avaiblemovies;");

            rs = ptotaltickets.executeQuery();
            while (rs.next()) {
                int c = rs.getInt("avai");
                dashboard_totalSoldTicket.setText(String.valueOf(c));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {

            ResultSet rs = null;

            pavailablemovies = connectdb.prepareStatement("select count(MovieTitle)  as avai from addmovie; ;");

            rs = pavailablemovies.executeQuery();
            while (rs.next()) {
                int c = rs.getInt("avai");
                dashboard_totalAvaibleMovies.setText(String.valueOf(c));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }




    }
//    @FXML // fx:id="message"
//    private Label message; // Value injected by FXMLLoade

    private Stage stage;
    private Scene scene;


    public void adds(ActionEvent e) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("add_movies.fxml"));
            ((Node) (e.getSource())).getScene().getWindow().hide();
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception ep) {
            ep.printStackTrace();
        }
    }

    public void available(ActionEvent e) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("avaible_movie.fxml"));
            ((Node) (e.getSource())).getScene().getWindow().hide();
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception ep) {
            ep.printStackTrace();

        }
    }
    public void customer(ActionEvent e) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("customer.fxml"));
            ((Node) (e.getSource())).getScene().getWindow().hide();
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception ep) {
            ep.printStackTrace();
        }
    }

    public void edit(ActionEvent e) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("edit_screening.fxml"));
            ((Node) (e.getSource())).getScene().getWindow().hide();
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception ep) {
            ep.printStackTrace();
        }
    }

    public void out(ActionEvent e) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
            ((Node)(e.getSource())).getScene().getWindow().hide();
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception ep) {
            ep.printStackTrace();
        }

    }
}
