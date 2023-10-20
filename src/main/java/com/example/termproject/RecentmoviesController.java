package com.example.termproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import util.Movie;

import java.net.URL;
import java.util.ResourceBundle;

public class RecentmoviesController implements Initializable {
    Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
        //System.out.println(Client.list.get(0).getName());
    }
    @FXML
    private TableView<Movie> table;

    @FXML
    private TableColumn<Movie,String> name,year,genre1,genre2,genre3,runningtime,budget,revenue;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Movie> movieObservableList = FXCollections.observableArrayList();

        //System.out.println(list.get(0).getName());
        if (Client.recentmovie != null) {
            for (int i = 0; i < Client.recentmovie.size(); i++) {
                //if(Client.recentmovie.get(i).getReleaseYear()==Client.recentmovie.get(0).getReleaseYear()) {
                movieObservableList.add(Client.recentmovie.get(i));
                //}
            }
            name.setCellValueFactory(new PropertyValueFactory<Movie, String>("Name"));
            year.setCellValueFactory(new PropertyValueFactory<Movie, String>("ReleaseYear"));
            genre1.setCellValueFactory(new PropertyValueFactory<Movie, String>("Genre1"));
            genre2.setCellValueFactory(new PropertyValueFactory<Movie, String>("Genre2"));
            genre3.setCellValueFactory(new PropertyValueFactory<Movie, String>("Genre3"));
            runningtime.setCellValueFactory(new PropertyValueFactory<Movie, String>("RunningTime"));
            budget.setCellValueFactory(new PropertyValueFactory<Movie, String>("Budget"));
            revenue.setCellValueFactory(new PropertyValueFactory<Movie, String>("Revenue"));
            table.setItems(movieObservableList);
        }
    }

    public void onBackClick(ActionEvent actionEvent) {
        try {
            client.showHomePage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
