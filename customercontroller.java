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
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class customercontroller {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private TextField customernos;

    @FXML
    private TableColumn<TableModel1, String> Customername;


    @FXML
    private TableColumn<TableModel1,String> MovieTitle;

    @FXML
    private Button addmovies_form;

    @FXML
    private Button availablemovies_form;

    @FXML
    private Button btn_delete;

    @FXML
    private Button btn_insert;

    @FXML
    private AnchorPane customer;

    @FXML
    private Button customer_form;

    @FXML
    private TextField customername;
    @FXML
    private TextField movieticket;

    @FXML
    private TableColumn<TableModel1, String> customerno;

    @FXML
    private Button dashboard_form;

    @FXML
    private Button editscreen_form;
    @FXML
    private TextField Genree;
    @FXML
    private TableColumn<TableModel1, String> movietickets;

    @FXML
    private TextField movietitle;

    @FXML
    private TableColumn<TableModel1, String> Genre;

    @FXML
    private Button sign_out;

    @FXML
    private TableView<TableModel1> table_view;

    @FXML
    private Label username;
    @FXML
    void deletion(ActionEvent event) {
        customernos.setText("");
        customername.setText("");
        movieticket.setText("");
        movietitle.setText("");
        Genree.setText("");

    }


    @FXML
    void inserting(ActionEvent e) throws SQLException {

        String number =customernos.getText();
        String name=customername.getText();
        String ticketss = movieticket.getText();
        String titleee=movietitle.getText();
        String genreeee = Genree.getText();
        PreparedStatement psinsert=null;
        PreparedStatement pscheck=null;
        ResultSet resultSet=null;


        //Connecting with Database file
        DatabaseConnection connectnow = new DatabaseConnection();
        Connection connectdb= connectnow.getconnection();


        if(!customerno.getText().isBlank() && !customername.getText().isBlank() && !movieticket.getText().isBlank() && !movietitle.getText().isBlank() && !Genre.getText().isBlank() ) {
            try {
                pscheck = connectdb.prepareStatement("select * from customer where customerno = ?");
                pscheck.setString(1,number);
                resultSet = pscheck.executeQuery();
                if (resultSet.isBeforeFirst()) {

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("YOU CANNOT USE THIS USERNAME.");
                    alert.show();
                } else {
            psinsert = connectdb.prepareStatement("insert into customer VALUES (?,?,?,?,?)");
            psinsert.setString(1,number);
            psinsert.setString(2,name);
            psinsert.setString(3,ticketss );
            psinsert.setString(4, titleee);
            psinsert.setString(5,genreeee);
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
    void initialize() {
        assert Customername != null : "fx:id=\"Customername\" was not injected: check your FXML file 'customer.fxml'.";
        assert Genre != null : "fx:id=\"Genre\" was not injected: check your FXML file 'customer.fxml'.";
        assert Genree != null : "fx:id=\"Genree\" was not injected: check your FXML file 'customer.fxml'.";
        assert MovieTitle != null : "fx:id=\"MovieTitle\" was not injected: check your FXML file 'customer.fxml'.";
        assert addmovies_form != null : "fx:id=\"addmovies_form\" was not injected: check your FXML file 'customer.fxml'.";
        assert availablemovies_form != null : "fx:id=\"availablemovies_form\" was not injected: check your FXML file 'customer.fxml'.";
        assert btn_delete != null : "fx:id=\"btn_delete\" was not injected: check your FXML file 'customer.fxml'.";
        assert btn_insert != null : "fx:id=\"btn_insert\" was not injected: check your FXML file 'customer.fxml'.";
        assert customer != null : "fx:id=\"customer\" was not injected: check your FXML file 'customer.fxml'.";
        assert customer_form != null : "fx:id=\"customer_form\" was not injected: check your FXML file 'customer.fxml'.";
        assert customername != null : "fx:id=\"customername\" was not injected: check your FXML file 'customer.fxml'.";
        assert customerno != null : "fx:id=\"customerno\" was not injected: check your FXML file 'customer.fxml'.";
        assert customernos != null : "fx:id=\"customernos\" was not injected: check your FXML file 'customer.fxml'.";
        assert dashboard_form != null : "fx:id=\"dashboard_form\" was not injected: check your FXML file 'customer.fxml'.";
        assert editscreen_form != null : "fx:id=\"editscreen_form\" was not injected: check your FXML file 'customer.fxml'.";
        assert movietickets != null : "fx:id=\"movietickets\" was not injected: check your FXML file 'customer.fxml'.";
        assert sign_out != null : "fx:id=\"sign_out\" was not injected: check your FXML file 'customer.fxml'.";
        assert table_view != null : "fx:id=\"table_view\" was not injected: check your FXML file 'customer.fxml'.";
        assert username != null : "fx:id=\"username\" was not injected: check your FXML file 'customer.fxml'.";

        customerno.setCellValueFactory(new PropertyValueFactory<TableModel1,String>("customerno"));
        Customername.setCellValueFactory(new PropertyValueFactory<TableModel1,String>("Customername"));
        movietickets.setCellValueFactory(new PropertyValueFactory<TableModel1,String>("movietickets"));
        MovieTitle.setCellValueFactory(new PropertyValueFactory<TableModel1,String>("MovieTitle"));
        Genre.setCellValueFactory(new PropertyValueFactory<TableModel1,String>("Genre"));



        try
        {
            DatabaseConnection connectnow = new DatabaseConnection();
            Connection connectdb = connectnow.getconnection();
            PreparedStatement ps =connectdb.prepareStatement("select * from customer;");
            ResultSet r= ps.executeQuery();
            final ObservableList<TableModel1> listdata= FXCollections.observableArrayList();

            while(r.next())
            {
                listdata.add(new TableModel1(r.getString("customerno"),r.getString("Customername"),r.getString("movietickets"),r.getString("MovieTitle"),r.getString("Genre")));
            }
            table_view.setItems(listdata);

        }catch(SQLException e)
        {
            e.printStackTrace();

        }
    }
//    @FXML
//    protected void goback(ActionEvent e)
//
//    {
//        try {
//            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("customer.fxml"));
//            ((Node)(e.getSource())).getScene().getWindow().hide();
//            Parent root1 = fxmlLoader.load();
//            Stage stage = new Stage();
//            stage.setScene(new Scene(root1));
//            stage.show();
//        } catch(Exception ep) {
//            ep.printStackTrace();
//        }
//    }




    @FXML
    void adds(ActionEvent e) {
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
    void available(ActionEvent e) {
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
    void dashh(ActionEvent e) {
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

    @FXML
    void edit(ActionEvent e) {
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

