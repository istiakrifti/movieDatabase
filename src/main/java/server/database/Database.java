package server.database;

import util.Movie;
import util.ProductionCompany;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private final String INPUT_FILE_NAME="D:/java/Networking part/src/server/database/movies.txt";
    List<ProductionCompany> productionCompanies;
    //List<Movie> buysell=new ArrayList<>();
    //List<Movie> movieList=new ArrayList<>();

//    public List<Movie> getBuysell() {
//        return buysell;
//    }

    public void readFile() throws Exception
    {
        productionCompanies=new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
        while (true) {
            String line = br.readLine();
            if (line == null) break;
            String[] obj=line.split(",");
            Movie ob=new Movie(obj[0],Integer.parseInt(obj[1]),obj[2],obj[3],obj[4],Integer.parseInt(obj[5]),obj[6],Integer.parseInt(obj[7]),Integer.parseInt(obj[8]));
            //movieList.add(ob);
            Add(ob);
        }

        br.close();
    }
    public void Add(Movie movie)
    {
        for(ProductionCompany p:productionCompanies)
        {
            if(p.getName().equalsIgnoreCase(movie.getProductionCompany()))
            {
                p.addMoviesToProuctioncmp(movie);
                return;
            }
        }
        ProductionCompany p=new ProductionCompany();
        p.setName(movie.getProductionCompany());
        p.addMoviesToProuctioncmp(movie);
        productionCompanies.add(p);
    }
//    public Movie searchToBuySell(String name)
//    {
//        for(Movie m:buysell)
//        {
//            if(m.getName().equalsIgnoreCase(name))
//            {
//                return m;
//            }
//        }
//        return null;
//    }
//
//    public void addForBuy(Movie movie)
//    {
//        buysell.add(movie);
//    }

    public boolean iscompany(String name)
    {
        for(ProductionCompany p:productionCompanies)
        {
            if(p.getName().equalsIgnoreCase(name))
            {
                return true;
            }
        }
        return false;
    }
    public ProductionCompany searchBycompany(String name)
    {
        for(ProductionCompany p:productionCompanies)
        {
            if(p.getName().equalsIgnoreCase(name))
            {
                return p;
            }
        }
        return null;
    }
    public List<ProductionCompany> getProductionCompanies() {
        return productionCompanies;
    }
}
