package com.example.movieticket;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.sql.*;

public class createcontroller {

    @FXML
    private Button add;

    @FXML
    private PasswordField tf_password;

    @FXML
    private TextField tf_username;


    @FXML
    void initialize() {
        assert add != null : "fx:id=\"add\" was not injected: check your FXML file 'create.fxml'.";
        assert tf_password != null : "fx:id=\"tf_password\" was not injected: check your FXML file 'create.fxml'.";
        assert tf_username != null : "fx:id=\"tf_username\" was not injected: check your FXML file 'create.fxml'.";

    }

    public void onHelloButtonClick(ActionEvent e) throws SQLException {
        String username = tf_username.getText();
        String Password = tf_password.getText();
        PreparedStatement psinsert = null;
        PreparedStatement pscheck = null;
        ResultSet resultSet = null;


        //Connecting with Database file
        DatabaseConnection connectnow = new DatabaseConnection();
        Connection connectdb = connectnow.getconnection();


        if (!tf_username.getText().isBlank() && !tf_password.getText().isBlank()) {
            try {
                pscheck = connectdb.prepareStatement("select * from login where username= ?");
                pscheck.setString(1, username);
                resultSet = pscheck.executeQuery();
                if (resultSet.isBeforeFirst()) {

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("YOU CANNOT USE THIS USERNAME.");
                    alert.show();
                } else {

                    psinsert = connectdb.prepareStatement("insert into login VALUES (?,?)");
                    psinsert.setString(1, username);
                    psinsert.setString(2, Password);

                    psinsert.executeUpdate();

                }
            } catch (SQLException ep) {
                ep.printStackTrace();
            }
        } else {
            System.out.println("error");

        }
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
            ((Node) (e.getSource())).getScene().getWindow().hide();
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception ep) {
            ep.printStackTrace();
        }

    }
}

