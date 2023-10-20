package com.example.termproject;


import javafx.application.Platform;
import server.Server;
import util.Login;
import util.Movie;
import util.NetworkUtil;
import util.ProductionCompany;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReadThread implements Runnable {
    private Thread thr;
    private Client client;
    private HashMap<String, NetworkUtil> clientmap;

    public HashMap<String, NetworkUtil> getClientmap() {
        return clientmap;
    }

    public void setClientmap(HashMap<String, NetworkUtil> clientmap) {
        this.clientmap = clientmap;
    }

    private NetworkUtil networkUtil;
    //RecentmoviesController recentmoviesController=new RecentmoviesController();

    String clientname;

    public ReadThread(Client client) {
        //this.networkUtil = networkUtil;
        this.client=client;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            while (true) {
                Object o = client.getNetworkUtil().read();
                if (o instanceof Login) {
                    Login login = (Login) o;
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                           if (login.isStatus()) {
                                try {
                                    client.showHomePage();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                           } else {
                               client.showAlert();
                           }
                           // }

                        }
                    });
                }
                if (o instanceof ProductionCompany ) {
                    ProductionCompany obj = (ProductionCompany) o;
                    client.setCompany(obj);
                    Client.allmovie=obj.getMovieList();
                    Client.maxrevmovie=obj.MaxRevenueMovie(obj.getName());
                    //List<Movie> list=new ArrayList<>();
                    //list=obj.MostRecentMovie(obj.getName());
//                    for(int i=0;i<Client.recentmovie.size();i++)
//                    {
//                        if(list.get(i).getReleaseYear()==list.get(0).getReleaseYear()) {
//                            Client.recentmovie.add(list.get(i));
//                        }
//                    }
                    Client.recentmovie=obj.MostRecentMovie(obj.getName());

                    Client.profit=obj.totalProfit(obj.getName());
                    for (int i = 0; i < obj.getMovieList().size(); i++) {
                        System.out.println("Received: " + obj.getMovieList().get(i).getName() + ", " + obj.getMovieList().get(i).getRunningTime());
                    }
                }
//                if (o instanceof List) {
//                    List<Movie> forsell = (List<Movie>) o;
//                    for (int i = 0; i < forsell.size(); i++) {
//                        if (forsell.get(i).getProductionCompany().equalsIgnoreCase(client.getCompany().getName())) {
//                            forsell.remove(i--);
//                        }
//                    }
//                }
            }
    } catch (Exception e) {
            System.out.println(e);
        }
//        finally {
//            try {
//                networkUtil.closeConnection();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }
}



