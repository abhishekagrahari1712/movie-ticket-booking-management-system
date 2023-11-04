package com.example.movieticket;



import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.EventObject;
import java.util.ResourceBundle;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
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
import javafx.stage.Stage;


public class avaiablemoviescontroller {
    @FXML
    private TableView<TableModel2> tableview;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private Spinner<Integer> spinner1;

    @FXML
    private Spinner<Integer> spinner2;


    @FXML
    private TableColumn<TableModel2, String> Genre;

    @FXML
    private TextField MOVIE_titleeee;

    @FXML
    private TableColumn<TableModel2, String> MovieTitle;

    @FXML
    private TableColumn<TableModel2, String> datess;
    @FXML
    private Label price1_movie;

    @FXML
    private Label price2_movie;

    @FXML
    private Button addmovies_form;

    @FXML
    private Button availablemovies_form;

    @FXML
    private Button btn_select;

    @FXML
    private Button customer_form;

    @FXML
    private Button dashboard_form;

    @FXML
    private Button btn_reciept;

    @FXML
    private Button editscreen_form;

    @FXML
    private Button sign_out;
    @FXML
    private Button clears;
    @FXML
    private Label total_bill;
    @FXML
    private Label username;
     private float price1 =0;
     private float price2=0;
     private float total=0;
     private int qty1=0;
     private int qty2=0;



    public avaiablemoviescontroller() {
    }


    @FXML
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

        @FXML
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

        @FXML // This method is called by the FXMLLoader when initialization is complete
        void initialize() {
            assert Genre != null : "fx:id=\"Genre\" was not injected: check your FXML file 'avaible_movie.fxml'.";
            assert MOVIE_titleeee != null : "fx:id=\"MOVIE_titleeee\" was not injected: check your FXML file 'avaible_movie.fxml'.";
            assert MovieTitle != null : "fx:id=\"MovieTitle\" was not injected: check your FXML file 'avaible_movie.fxml'.";
            assert datess != null : "fx:id=\"Published_Date\" was not injected: check your FXML file 'avaible_movie.fxml'.";
            assert addmovies_form != null : "fx:id=\"addmovies_form\" was not injected: check your FXML file 'avaible_movie.fxml'.";
            assert availablemovies_form != null : "fx:id=\"availablemovies_form\" was not injected: check your FXML file 'avaible_movie.fxml'.";
            assert btn_reciept != null : "fx:id=\"btn_reciept\" was not injected: check your FXML file 'avaible_movie.fxml'.";
            assert btn_select != null : "fx:id=\"btn_select\" was not injected: check your FXML file 'avaible_movie.fxml'.";
            assert clears != null : "fx:id=\"clears\" was not injected: check your FXML file 'avaible_movie.fxml'.";
            assert customer_form != null : "fx:id=\"customer_form\" was not injected: check your FXML file 'avaible_movie.fxml'.";
            assert dashboard_form != null : "fx:id=\"dashboard_form\" was not injected: check your FXML file 'avaible_movie.fxml'.";
            assert editscreen_form != null : "fx:id=\"editscreen_form\" was not injected: check your FXML file 'avaible_movie.fxml'.";
            assert price1_movie != null : "fx:id=\"price1\" was not injected: check your FXML file 'avaible_movie.fxml'.";
            assert price2_movie != null : "fx:id=\"price2\" was not injected: check your FXML file 'avaible_movie.fxml'.";
            assert sign_out != null : "fx:id=\"sign_out\" was not injected: check your FXML file 'avaible_movie.fxml'.";
            assert spinner1 != null : "fx:id=\"spinner1\" was not injected: check your FXML file 'avaible_movie.fxml'.";
            assert spinner2 != null : "fx:id=\"spinner2\" was not injected: check your FXML file 'avaible_movie.fxml'.";
            assert tableview != null : "fx:id=\"tableview\" was not injected: check your FXML file 'avaible_movie.fxml'.";
            assert username != null : "fx:id=\"username\" was not injected: check your FXML file 'avaible_movie.fxml'.";
            assert total_bill != null : "fx:id=\"total_bill\" was not injected: check your FXML file 'avaible_movie.fxml'.";
            MovieTitle.setCellValueFactory(new PropertyValueFactory<TableModel2,String>("MovieTitle"));
                Genre.setCellValueFactory(new PropertyValueFactory<TableModel2,String>("Genre"));
                datess.setCellValueFactory(new PropertyValueFactory<TableModel2,String>("datess"));
                spinner1.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10,0));
                spinner2.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10,0));

        }



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

    public void selecting(ActionEvent e) {

        String titlee =MOVIE_titleeee.getText();
        PreparedStatement pscheck=null;
        ResultSet resultSet=null;


        //Connecting with Database file
        DatabaseConnection connectnow = new DatabaseConnection();
        Connection connectdb= connectnow.getconnection();


        if(!MOVIE_titleeee.getText().isBlank()  ) {
            try {
                PreparedStatement ps =connectdb.prepareStatement("select MovieTitle,Genre,datess from addmovie where MovieTitle= '"+MOVIE_titleeee.getText()+"';");
                ResultSet r= ps.executeQuery();
                final ObservableList<TableModel2> listdata= FXCollections.observableArrayList();
                while(r.next())
                {
                    listdata.add(new TableModel2 (r.getString("MovieTitle"),r.getString("Genre"),r.getString("datess")));
                }
                tableview.setItems(listdata);

            } catch (SQLException ep) {
                ep.printStackTrace();
            }
        }
        else{
            System.out.println("error");

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

    public void clearing(ActionEvent actionEvent) {
        spinner2.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10,0));
        spinner1.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10,0));
        MOVIE_titleeee.setText("");
        price1_movie.setText("$0.0");
        price2_movie.setText("$0.0");
        total_bill.setText("$0.0");
    }

    public void billing(ActionEvent actionEvent) {

        qty1 = spinner1.getValue();
        qty2= spinner2.getValue();
        price1 =(qty1 * 20);
        price2 =(qty2*10);
        total = (price1+price2);
        price1_movie.setText("$"+(price1));
        price2_movie.setText("$"+(price2));
        total_bill.setText("$"+(total));

    }

    public void sold(ActionEvent e) throws SQLException {
        String Totalqty= String.valueOf(qty1+qty2);
        String totalamt= String.valueOf(total);

        DatabaseConnection connectnow = new DatabaseConnection();
        Connection connectdb= connectnow.getconnection();
        PreparedStatement psinsert = connectdb.prepareStatement("insert into avaiblemovies VALUES (?,?)");
        psinsert.setString(1,totalamt);
        psinsert.setString(2,Totalqty);
        psinsert.executeUpdate();

        price1_movie.setText("$0.0");
        price2_movie.setText("$0.0");
        total_bill.setText("$0.0");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));

            ((Node)(e.getSource())).getScene().getWindow().hide();
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception ep) {
            ep.printStackTrace();
        }

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
}



