package util;

import java.io.Serializable;

public class Movie implements Serializable {

    private String Name;
    private String Genre1;
    private String Genre2;
    private String Genre3;
    private String ProductionCompany;
    private int ReleaseYear;
    private int RunningTime;
    private int Budget;
    private int Revenue;
    private Long Profit;
    public Movie(){}

    public Movie(String n,int ry,String g1,String g2,String g3,int rt,String pc,int b,int r)
    {
        Name=n;
        ReleaseYear=ry;
        Genre1=g1;
        Genre2=g2;
        Genre3=g3;
        RunningTime=rt;
        ProductionCompany=pc;
        Budget=b;
        Revenue=r;
        Profit=Long.valueOf(Revenue-Budget);
    }

    public void setName(String name) {
        Name = name;
    }

    public void setGenre1(String genre1) {
        Genre1 = genre1;
    }

    public void setGenre2(String genre2) {
        Genre2 = genre2;
    }

    public void setGenre3(String genre3) {
        Genre3 = genre3;
    }

    public void setProductionCompany(String productionCompany) {
        ProductionCompany = productionCompany;
    }

    public void setReleaseYear(int releaseYear) {
        ReleaseYear = releaseYear;
    }

    public void setRunningTime(int runningTime) {
        RunningTime = runningTime;
    }

    public void setBudget(int budget) {
        Budget = budget;
    }

    public void setRevenue(int revenue) {
        Revenue = revenue;
    }

    public void setProfit(Long profit) {
        Profit = profit;
    }

    public String getName() {
        return Name;
    }

    public String getGenre1() {
        return Genre1;
    }

    public String getGenre2() {
        return Genre2;
    }

    public String getGenre3() {
        return Genre3;
    }

    public String getProductionCompany() {
        return ProductionCompany;
    }

    public int getReleaseYear() {
        return ReleaseYear;
    }

    public int getRunningTime() {
        return RunningTime;
    }

    public int getBudget() {
        return Budget;
    }

    public int getRevenue() {
        return Revenue;
    }

    public Long getProfit() {
        return Profit;
    }

    public void printInfo()
    {
        System.out.println("Movie Name: " +Name);
        System.out.println("Realise Year: " + ReleaseYear);
        System.out.println("Genre1: " + Genre1);
        System.out.println("Genre2: " + Genre2);
        System.out.println("Genre3: " + Genre3);
        System.out.println("Running Time(in minutes): " + RunningTime );
        System.out.println("Production Company Name: " + ProductionCompany);
        System.out.println("Budget: " + Budget);
        System.out.println("Revenue: " + Revenue);
    }
}
