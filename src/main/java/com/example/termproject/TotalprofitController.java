package com.example.termproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import util.Movie;

import java.net.URL;
import java.util.ResourceBundle;

public class TotalprofitController implements Initializable {
    public Label totalprofit;
    @FXML
    private TableView<Movie> table;
    public TableColumn<Movie,String> name,profit;
    Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Movie> movieObservableList= FXCollections.observableArrayList();

        for(Movie movie:Client.allmovie)
        {
            movieObservableList.add(movie);
        }
        name.setCellValueFactory(new PropertyValueFactory<Movie,String>("Name"));
        profit.setCellValueFactory(new PropertyValueFactory<Movie,String>("Profit"));
        table.setItems(movieObservableList);
        totalprofit.setText(String.valueOf(Client.profit));
    }
    public void onBackClick(ActionEvent actionEvent) {
        try {
            client.showHomePage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
