package com.example.movieticket;

import javafx.collections.FXCollections;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;



import javafx.fxml.FXML;

import java.net.URL;

import java.sql.*;
import java.util.EventObject;
import java.util.ResourceBundle;


import javafx.scene.layout.AnchorPane;


public class addmoviescontroller {



    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<TableModel> tableview;

    @FXML
    private AnchorPane add_movies;

    @FXML
    private Button addmovies_form;

    @FXML
    private Button availablemovies_form;

    @FXML
    private Button btn_clear;

    @FXML
    private Button btn_delete;

    @FXML
    private Button btn_insert;

    @FXML
    private Button btn_update;

    @FXML
    private Button customer_form;

    @FXML
    private Button dashboard_form;

    @FXML
    private TableColumn<TableModel,String> datess;

    @FXML
    private Button editscreen_form;

    @FXML
    private TextField g_nreee;

    @FXML
    private TableColumn<TableModel,String> Genre;

    @FXML
    private TextField m_titlee;

    @FXML
    private TableColumn<TableModel, String> MovieTitle;

    @FXML
    private TextField p_dattttesss;

    @FXML
    private Button sign_out;

    @FXML
    private TextField t_iming;

    @FXML
    private TableColumn<TableModel,String> Duration ;

    @FXML
    private Label username;

    @FXML
    void clearing(ActionEvent event) {
        m_titlee.setText("");
        g_nreee.setText("");
        t_iming.setText("");
        p_dattttesss.setText("");

    }




    @FXML
    void deletion(ActionEvent e) throws SQLException {
        System.out.println("enterd");
        String title =m_titlee.getText();
        String genreee =g_nreee.getText();
        String durations =t_iming.getText();
        String publishing=p_dattttesss.getText();
        if(!m_titlee.getText().isBlank()  ) {
            System.out.println("enterd");

            DatabaseConnection connectnow = new DatabaseConnection();
            Connection connectdb = connectnow.getconnection();
            Statement statement = connectdb.createStatement();

            String deleteQuery = "DELETE FROM addmovie WHERE Movietitle='"+m_titlee.getText()+"'";

            // Execute the DELETE query
            int rowsAffected = statement.executeUpdate(deleteQuery);

            // Check the number of rows affected
            if (rowsAffected > 0) {
                System.out.println(rowsAffected + " row(s) deleted successfully.");
            }
            else {
                System.out.println("No rows deleted.");
            }

        }
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
    void insertion(ActionEvent e) {

        String title =m_titlee.getText();
        String genreee =g_nreee.getText();
        String durations =t_iming.getText();
        String publishing=p_dattttesss.getText();
        PreparedStatement psinsert=null;
        PreparedStatement pscheck=null;
        ResultSet resultSet=null;


        //Connecting with Database file
        DatabaseConnection connectnow = new DatabaseConnection();
        Connection connectdb = connectnow.getconnection();


        if(!m_titlee.getText().isBlank() && !g_nreee.getText().isBlank() && !t_iming.getText().isBlank() && !p_dattttesss.getText().isBlank() ) {
            try {
                pscheck = connectdb.prepareStatement("select * from addmovie where Movietitle = ?");
                pscheck.setString(1, title);
                resultSet = pscheck.executeQuery();
                if (resultSet.isBeforeFirst()) {

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("YOU CANNOT USE THIS USERNAME.");
                    alert.show();
                } else {

                    psinsert = connectdb.prepareStatement("insert into addmovie VALUES (?,?,?,?)");
                    psinsert.setString(1, title);
                    psinsert.setString(2, genreee);
                    psinsert.setString(3, durations);
                    psinsert.setString(4, publishing);
                    psinsert.executeUpdate();

                }
            } catch (SQLException ep) {
                ep.printStackTrace();
            }
        }
        else{
            System.out.println("error");

        }
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
    void initialize() {
        assert add_movies != null : "fx:id=\"add_movies\" was not injected: check your FXML file 'add_movies.fxml'.";
        assert addmovies_form != null : "fx:id=\"addmovies_form\" was not injected: check your FXML file 'add_movies.fxml'.";
        assert availablemovies_form != null : "fx:id=\"availablemovies_form\" was not injected: check your FXML file 'add_movies.fxml'.";
        assert btn_clear != null : "fx:id=\"btn_clear\" was not injected: check your FXML file 'add_movies.fxml'.";
        assert btn_delete != null : "fx:id=\"btn_delete\" was not injected: check your FXML file 'add_movies.fxml'.";
        assert btn_insert != null : "fx:id=\"btn_insert\" was not injected: check your FXML file 'add_movies.fxml'.";
        assert btn_update != null : "fx:id=\"btn_update\" was not injected: check your FXML file 'add_movies.fxml'.";
        assert customer_form != null : "fx:id=\"customer_form\" was not injected: check your FXML file 'add_movies.fxml'.";
        assert dashboard_form != null : "fx:id=\"dashboard_form\" was not injected: check your FXML file 'add_movies.fxml'.";
        assert datess != null : "fx:id=\"date\" was not injected: check your FXML file 'add_movies.fxml'.";
        assert editscreen_form != null : "fx:id=\"editscreen_form\" was not injected: check your FXML file 'add_movies.fxml'.";
        assert g_nreee != null : "fx:id=\"g_nreee\" was not injected: check your FXML file 'add_movies.fxml'.";
        assert Genre != null : "fx:id=\"genre\" was not injected: check your FXML file 'add_movies.fxml'.";
        assert m_titlee != null : "fx:id=\"m_titlee\" was not injected: check your FXML file 'add_movies.fxml'.";
        assert MovieTitle != null : "fx:id=\"movie_title\" was not injected: check your FXML file 'add_movies.fxml'.";
        assert p_dattttesss != null : "fx:id=\"p_dattttesss\" was not injected: check your FXML file 'add_movies.fxml'.";
        assert sign_out != null : "fx:id=\"sign_out\" was not injected: check your FXML file 'add_movies.fxml'.";
        assert t_iming != null : "fx:id=\"t_iming\" was not injected: check your FXML file 'add_movies.fxml'.";
        assert Duration!= null : "fx:id=\"timing\" was not injected: check your FXML file 'add_movies.fxml'.";
        assert username != null : "fx:id=\"username\" was not injected: check your FXML file 'add_movies.fxml'.";
        MovieTitle.setCellValueFactory(new PropertyValueFactory<TableModel,String>("MovieTitle"));
        Genre.setCellValueFactory(new PropertyValueFactory<TableModel,String>("Genre"));
        Duration.setCellValueFactory(new PropertyValueFactory<TableModel,String>("Duration"));
        datess.setCellValueFactory(new PropertyValueFactory<TableModel,String>("datess"));
        try
        {
            DatabaseConnection connectnow = new DatabaseConnection();
            Connection connectdb = connectnow.getconnection();
            PreparedStatement ps =connectdb.prepareStatement("select * from addmovie;");
            ResultSet r= ps.executeQuery();

            final ObservableList<TableModel> listdata= FXCollections.observableArrayList();
            while(r.next())
            {
                listdata.add(new TableModel (r.getString("MovieTitle"),r.getString("Genre"),r.getString("Duration"),r.getString("datess")));
            }
            tableview.setItems(listdata);

        }catch(SQLException e)
        {
            e.printStackTrace();

        }


    }

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

    public void edit(ActionEvent e) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("edit_screening.fxml"));
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
