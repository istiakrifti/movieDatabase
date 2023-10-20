package com.example.termproject;

import javafx.event.ActionEvent;

import java.io.IOException;

public class HomepageController {

    Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void onAllMoviesClick(ActionEvent actionEvent) throws IOException {
        client.goToAllMovies();
    }
    public void onRecentMoviesClick(ActionEvent actionEvent) throws IOException {
       client.goToRecentMovies();
    }


    public void OnMaxRevenueClick(ActionEvent actionEvent) throws IOException {
        client.goToMaxRevenueMovie();

    }

    public void onProfitClick(ActionEvent actionEvent) throws IOException {
        client.goToTotalProfit();
    }

    public void onAddMovieClick(ActionEvent actionEvent) throws IOException {
        client.goToAddMovie();
    }

    public void OnTransferMovieClick(ActionEvent actionEvent) throws IOException {
        client.goToTransferMovie();
    }
    public void onChangePasswordClick(ActionEvent actionEvent) throws IOException {
        client.goToChangePassword();
    }

    public void onLogOutClick(ActionEvent actionEvent) {
        try {
            client.showLoginPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
