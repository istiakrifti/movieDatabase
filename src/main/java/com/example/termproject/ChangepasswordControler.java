package com.example.termproject;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ChangepasswordControler {
    public PasswordField currentpass;
    public PasswordField newpass;
    public PasswordField newpass2;
    public Label label;
    Client client;

    public void setClient(Client client) {
        this.client = client;
    }

    public void onChangeClick(ActionEvent actionEvent) {
        String s=currentpass.getText();
        String s1=newpass.getText();
        String s2=newpass2.getText();
        if(!(s.equals(s1)) && s1.equals(s2))
        {
            try {
                client.getNetworkUtil().write(s1);
            } catch (IOException e) {
                e.printStackTrace();
            }
            label.setText("Changed Successfully");
        }
        else {
            label.setText("can not be changed");
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
