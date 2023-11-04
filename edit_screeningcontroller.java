package com.example.movieticket;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class edit_screeningcontroller {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private TableView<TableModel3> tableview;


    @FXML
    private TableColumn<TableModel3, String> Duration;

    @FXML
    private TableColumn<TableModel3, String> Genre;

    @FXML
    private TableColumn<TableModel3, String> MovieTitle;

    @FXML
    private TableColumn<TableModel3, String> datess;

    @FXML
    private Button addmovies_form;

    @FXML
    private Button availablemovies_form;

    @FXML
    private Button btn_delete;

    @FXML
    private Button btn_update;

    @FXML
    private Button customer_form;

    @FXML
    private Button dashboard_form;

    @FXML
    private AnchorPane edit_screening;

    @FXML
    private Button editscreen_form;
//    @FXML
//    private ComboBox<String> choosing;

    @FXML
    private Button sign_out;

    @FXML
    private Label username;

        @FXML
        void deletion(ActionEvent event) {

        }


        @FXML
        void update(ActionEvent event) throws SQLException {
            DatabaseConnection connectnow = new DatabaseConnection();
            Connection connectdb = connectnow.getconnection();
            String genre=checkbox.getValue();

            PreparedStatement ps =connectdb.prepareStatement("select * from addmovie where Genre= '"+genre+"';");
            ResultSet r= ps.executeQuery();

            final ObservableList<TableModel3> listdata= FXCollections.observableArrayList();
            while(r.next())
            {
                listdata.add(new TableModel3 (r.getString("MovieTitle"),r.getString("Genre"),r.getString("Duration"),r.getString("datess")));
                tableview.setItems(listdata);
            }


        }
    @FXML
    private ChoiceBox<String> checkbox;
    private final String[] genre={"Action","Horror","Thriller","Drama","Comedy","Science fiction","Animation","Rom-com"};
        @FXML // This method is called by the FXMLLoader when initialization is complete
        void initialize() {
            checkbox.getItems().addAll(genre);

            assert Duration != null : "fx:id=\"Duration\" was not injected: check your FXML file 'edit_screening.fxml'.";
            assert Genre != null : "fx:id=\"Genre\" was not injected: check your FXML file 'edit_screening.fxml'.";
            assert MovieTitle != null : "fx:id=\"MovieTitle\" was not injected: check your FXML file 'edit_screening.fxml'.";
            assert datess != null : "fx:id=\"Published_Date\" was not injected: check your FXML file 'edit_screening.fxml'.";
            assert addmovies_form != null : "fx:id=\"addmovies_form\" was not injected: check your FXML file 'edit_screening.fxml'.";
            assert availablemovies_form != null : "fx:id=\"availablemovies_form\" was not injected: check your FXML file 'edit_screening.fxml'.";
            assert btn_delete != null : "fx:id=\"btn_delete\" was not injected: check your FXML file 'edit_screening.fxml'.";
            assert btn_update != null : "fx:id=\"btn_update\" was not injected: check your FXML file 'edit_screening.fxml'.";
//            assert choosing != null : "fx:id=\"choosing\" was not injected: check your FXML file 'edit_screening.fxml'.";
            assert customer_form != null : "fx:id=\"customer_form\" was not injected: check your FXML file 'edit_screening.fxml'.";
            assert dashboard_form != null : "fx:id=\"dashboard_form\" was not injected: check your FXML file 'edit_screening.fxml'.";
            assert edit_screening != null : "fx:id=\"edit_screening\" was not injected: check your FXML file 'edit_screening.fxml'.";
            assert editscreen_form != null : "fx:id=\"editscreen_form\" was not injected: check your FXML file 'edit_screening.fxml'.";
            assert sign_out != null : "fx:id=\"sign_out\" was not injected: check your FXML file 'edit_screening.fxml'.";
            assert username != null : "fx:id=\"username\" was not injected: check your FXML file 'edit_screening.fxml'.";

//            ObservableList<String>list= FXCollections.observableArrayList("Action","Horror","Thriller","Drama","Comedy","Science fiction","Animation");
            MovieTitle.setCellValueFactory(new PropertyValueFactory<TableModel3,String>("MovieTitles"));
//            choosing.setItems(list);
            Genre.setCellValueFactory(new PropertyValueFactory<TableModel3,String>("Genres"));
            Duration.setCellValueFactory(new PropertyValueFactory<TableModel3,String>("Durations"));
            datess.setCellValueFactory(new PropertyValueFactory<TableModel3,String>("datess"));
            try
            {
                DatabaseConnection connectnow = new DatabaseConnection();
                Connection connectdb = connectnow.getconnection();
                PreparedStatement ps =connectdb.prepareStatement("select * from addmovie;");
                ResultSet r= ps.executeQuery();

                final ObservableList<TableModel3> listdata= FXCollections.observableArrayList();
                while(r.next())
                {
                    listdata.add(new TableModel3 (r.getString("MovieTitle"),r.getString("Genre"),r.getString("Duration"),r.getString("datess")));
                    tableview.setItems(listdata);
                }

            }catch(SQLException e)
            {
                e.printStackTrace();

            }
        }





        @FXML
        public void adds(ActionEvent e) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("add_movies.fxml"));
                ((Node)(e.getSource())).getScene().getWindow().hide();
                Parent root1 = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (Exception ep) {
                ep.printStackTrace();
            }
        }

        @FXML
        public void available(ActionEvent e) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("avaible_movie.fxml"));
                ((Node)(e.getSource())).getScene().getWindow().hide();
                Parent root1 = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (Exception ep) {
                ep.printStackTrace();
            }

        }

        @FXML
        public void customer(ActionEvent e) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("customer.fxml"));
                ((Node)(e.getSource())).getScene().getWindow().hide();
                Parent root1 = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (Exception ep) {
                ep.printStackTrace();
            }

        }

        @FXML
        public void dashh(ActionEvent e) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("home.fxml"));
                ((Node)(e.getSource())).getScene().getWindow().hide();
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