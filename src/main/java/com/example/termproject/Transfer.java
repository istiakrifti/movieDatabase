package com.example.termproject;

import java.io.Serializable;

public class Transfer implements Serializable {
    String MovieName;
    String ProductionCompany;

    public String getMovieName() {
        return MovieName;
    }

    public void setMovieName(String movieName) {
        MovieName = movieName;
    }

    public String getProductionCompany() {
        return ProductionCompany;
    }

    public void setProductionCompany(String productionCompany) {
        ProductionCompany = productionCompany;
    }
}
