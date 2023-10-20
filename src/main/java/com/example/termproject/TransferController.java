package com.example.termproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class TransferController {
    @FXML
    TextField moviename,company;
    Client client;
    @FXML
    Label label;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void onTransferClick(ActionEvent actionEvent) {
        String movie=moviename.getText();
        String productioncmp=company.getText();
        Transfer transfer=new Transfer();
        transfer.setMovieName(movie);
        transfer.setProductionCompany(productioncmp);
        try {
            client.getNetworkUtil().write(transfer);
            //System.out.println(transfer.MovieName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        label.setText("Successful");
    }

    public void onBackClick(ActionEvent actionEvent) {
        try {
            client.showHomePage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
