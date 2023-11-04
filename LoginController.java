
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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import javafx.scene.layout.AnchorPane;

public class LoginController implements Initializable {

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

//    @FXML // fx:id="message"
//    private Label message; // Value injected by FXMLLoade

    private Stage stage;
    private Scene scene;
    @FXML
    void onHelloButtonClick(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert create != null : "fx:id=\"create\" was not injected: check your FXML file 'builder.fxml'.";
        assert cust != null : "fx:id=\"cust\" was not injected: check your FXML file 'builder.fxml'.";
        assert log != null : "fx:id=\"log\" was not injected: check your FXML file 'builder.fxml'.";
        assert login_page != null : "fx:id=\"login_page\" was not injected: check your FXML file 'builder.fxml'.";
        assert nbjbvhj != null : "fx:id=\"nbjbvhj\" was not injected: check your FXML file 'builder.fxml'.";
        assert pass != null : "fx:id=\"pass\" was not injected: check your FXML file 'builder.fxml'.";
        assert sign != null : "fx:id=\"sign\" was not injected: check your FXML file 'builder.fxml'.";

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
    public void create(ActionEvent e) throws SQLException {


            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("create.fxml"));
                ((Node)(e.getSource())).getScene().getWindow().hide();
                Parent root1 = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (Exception ep) {
                ep.printStackTrace();
            }

    }

        public void loginbuttonOnAction(ActionEvent e) throws SQLException {
                String username = cust.getText();
                String password = pass.getText();


            if (isUsernameValid((username)) && isPasswordValid((password))) {
                DatabaseConnection connection = new DatabaseConnection();
                Connection connection1 = connection.getconnection();
                String verifylogin = "select count(1) from moviebooking.login where username='" + cust.getText() + "' and password='" + pass.getText() + "'";
                try {
                    Statement statement = connection1.createStatement();
                    ResultSet queryResult = statement.executeQuery(verifylogin);
                    while (queryResult.next()) {
                        if (queryResult.getInt(1) == 1) {
                            try {
                                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("home.fxml"));
                                ((Node) (e.getSource())).getScene().getWindow().hide();
                                Parent root1 = fxmlLoader.load();
                                Stage stage = new Stage();
                                stage.setScene(new Scene(root1));
                                stage.show();
                            } catch (Exception ep) {
                                ep.printStackTrace();
                            }
                        } else {
                            System.out.println("Invalid username or password.");
                        }
                    }
                } catch (Exception ep) {
                    ep.printStackTrace();
                }
            } else {
                System.out.println("Username and password must meet the criteria.");
            }
        }

    private boolean isUsernameValid(String username) {
        // Define a regular expression pattern to check for special characters in the username
        String usernamePattern = ".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>?/].*";

        // Compile the pattern
        Pattern pattern = Pattern.compile(usernamePattern);

        // Create a matcher with the input username
        Matcher matcher = pattern.matcher(username);

        // Check if the username contains at least one special character
        return matcher.matches();
    }

    private boolean isPasswordValid(String password) {
        // Define a regular expression pattern to check for at least one special character in the password
        String passwordPattern = ".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>?/].*";

        // Compile the pattern
        Pattern pattern = Pattern.compile(passwordPattern);

        // Create a matcher with the input password
        Matcher matcher = pattern.matcher(password);

        // Check if the password contains at least one special character
        return matcher.matches();
    }


    }
