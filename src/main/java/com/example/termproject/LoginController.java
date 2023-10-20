package com.example.termproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import util.Login;

import java.io.IOException;

public class LoginController{
    @FXML
    private Label nameLabel;
    @FXML
    private TextField cmpname;
    @FXML
    private PasswordField password;

   private Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @FXML
    protected void onLoginClick(ActionEvent event) throws Exception {
            client.connectToServer();
            String userName = cmpname.getText();
            String pass = password.getText();
            Login login = new Login();
            login.setProductioncompany(userName);
            login.setPassword(pass);
            try {
                client.getNetworkUtil().write(login);
            } catch (IOException e) {
                e.printStackTrace();
            }


    }

    public void onResetClick(ActionEvent actionEvent) {
        cmpname.setText(null);
        password.setText(null);
    }
}