package com.example.termproject;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import util.Movie;

import java.io.IOException;

public class AddmovieController {
    public TextField name,year,genre1,genre2,genre3,runningtime,budget,revenue;
    public Label label;
    Client client;
    String company;
    public void init(String company)
    {
        this.company=company;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void onAddClick(ActionEvent actionEvent) {
        boolean ismovie=client.getCompany().isMovie(name.getText());
        System.out.println("aaaaa"+ismovie);
        if(name.getText().isEmpty()  || year.getText().isEmpty() || genre1.getText().isEmpty() || runningtime.getText().isEmpty()
        || budget.getText().isEmpty() || revenue.getText().isEmpty()) {

                label.setText("Can not be added");

        }
        else {
            if(ismovie)
            {
                label.setText("Can not be added");
            }
            else {
                Movie movie = new Movie();
                movie.setName(name.getText());
                movie.setProductionCompany(company);
                movie.setReleaseYear(Integer.parseInt(year.getText()));
                movie.setGenre1(genre1.getText());
                movie.setGenre2(genre2.getText());
                movie.setGenre3(genre3.getText());
                movie.setRunningTime(Integer.parseInt(runningtime.getText()));
                movie.setBudget(Integer.parseInt(budget.getText()));
                movie.setRevenue(Integer.parseInt(revenue.getText()));

                try {
                    client.getNetworkUtil().write(movie);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                label.setText("Added successfully");

            }
            //label.setText("Added successfully");
        }
        name.clear();
        year.clear();
        genre1.clear();
        genre2.clear();
        genre3.clear();
        runningtime.clear();
        budget.clear();
        revenue.clear();
    }

    public void onBackClick(ActionEvent actionEvent) {
        try {
            client.showHomePage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
