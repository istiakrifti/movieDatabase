package com.example.termproject;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import util.Movie;
import util.NetworkUtil;
import util.ProductionCompany;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class  Client extends Application {

    private Stage stage;
    private NetworkUtil networkUtil;

    public Stage getStage() {
        return stage;
    }
    static ProductionCompany company;
    static List<Movie> recentmovie=new ArrayList<>();
    static List<Movie> maxrevmovie=new ArrayList<>();
    static List<Movie> allmovie=new ArrayList<>();

    static Long profit;

    public void setCompany(ProductionCompany company) {
        this.company = company;
    }

    public ProductionCompany getCompany() {
        return company;
    }

    public NetworkUtil getNetworkUtil() {
        return networkUtil;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        //connectToServer();
        showLoginPage();
    }

    public void connectToServer() throws Exception {
        String serverAddress = "127.0.0.1";
        int serverPort = 44456;
        networkUtil = new NetworkUtil(serverAddress, serverPort);
        new ReadThread(this);

    }

    public void showLoginPage() throws Exception {
        // XML Loading using FXMLLoader
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("loginview.fxml"));
        Parent root = loader.load();


        // Loading the controller
        LoginController controller = loader.getController();
        controller.setClient(this);

        // Set the primary stage
        stage.setTitle("Login");
        stage.setScene(new Scene(root, 600, 437));
        stage.show();
    }
    public void showHomePage() throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("homepage.fxml"));
        Parent root = loader.load();

        // Loading the controller
        HomepageController controller = loader.getController();
        //controller.init(userName);
        controller.setClient(this);
        // Set the primary stage
        stage.setTitle("Home");
        stage.setScene(new Scene(root, 618, 464));
        stage.show();
        //allmovie=company.getMovieList();
        //maxrevmovie=company.MaxRevenueMovie(company.getName());
//        recentmovie=company.MostRecentMovie(company.getName());
//        profit=company.totalProfit(company.getName());
    }
    public void showAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Incorrect Credentials");
        alert.setHeaderText("Incorrect Credentials");
        alert.setContentText("The username and password you provided is not correct.");
        alert.showAndWait();
    }
    public void goToAllMovies() throws IOException {
        //list1=company.getMovieList();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("allmovies.fxml"));

        //controller.init();

        Parent root = loader.load();
        // Loading the controller
        AllmoviesController controller = loader.getController();
        controller.setClient(this);

        // Set the primary stage
        stage.setTitle("All Movies");
        stage.setScene(new Scene(root, 850, 454));
        stage.show();
        //list1=company.getMovieList();
    }
    public void goToRecentMovies() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("recentmovies.fxml"));

        //controller.init();

        Parent root = loader.load();
        // Loading the controller
        RecentmoviesController controller = loader.getController();
        controller.setClient(this);

        // Set the primary stage
        stage.setTitle("Recent Movies");
        stage.setScene(new Scene(root, 850, 454));
        stage.show();

    }
    public void goToMaxRevenueMovie() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("maxrevenuemovie.fxml"));

        //controller.init();

        Parent root = loader.load();
        // Loading the controller
        MaxrevenuemovieController controller = loader.getController();
        controller.setClient(this);

        // Set the primary stage
        stage.setTitle("Maximum Revenue Movie");
        stage.setScene(new Scene(root, 850, 454));
        stage.show();
    }
    public void goToTransferMovie() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("transfer.fxml"));

        //controller.init();

        Parent root = loader.load();
        // Loading the controller
        TransferController controller = loader.getController();
        controller.setClient(this);

        // Set the primary stage
        stage.setTitle("Transfer Movie");
        stage.setScene(new Scene(root, 600, 437));
        stage.show();
    }
    public void goToTotalProfit() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("totalprofit.fxml"));

        Parent root = loader.load();
        // Loading the controller
        TotalprofitController controller = loader.getController();
        controller.setClient(this);

        // Set the primary stage
        stage.setTitle("Total Profit");
        stage.setScene(new Scene(root, 850, 454));
        stage.show();
    }
    public void goToAddMovie() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("addmovie.fxml"));

        Parent root = loader.load();
        // Loading the controller
        AddmovieController controller = loader.getController();
        controller.init(company.getName());
        controller.setClient(this);

        // Set the primary stage

        stage.setTitle("Add Movie");
        stage.setScene(new Scene(root, 600, 437));
        stage.show();
    }
    public void goToChangePassword() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("changepassword.fxml"));

        Parent root = loader.load();
        // Loading the controller
        ChangepasswordControler controller = loader.getController();
        //controller.init(company.getName());
        controller.setClient(this);

        // Set the primary stage
        stage.setTitle("Home");
        stage.setScene(new Scene(root, 600, 437));
        stage.show();
    }
    public static void main(String[] args) {
        // This will launch the JavaFX application
        launch(args);
    }



}