package server;

import server.database.Database;
import util.Movie;
import util.NetworkUtil;
import util.ProductionCompany;
import com.example.termproject.Transfer;

import java.io.IOException;
import java.util.HashMap;

public class ReadThreadServer implements Runnable{
    private  Server server;
    private  String company;
    NetworkUtil networkUtil;
    HashMap<String,NetworkUtil> clientmap=new HashMap<>();
    Database database=new Database();

    public ReadThreadServer(Server server,String company) {
//        try {
//            database.readFile();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        this.server=server;
        //this.networkUtil = networkUtil;
       // this.clientmap=clientmap;
        this.company = company;
        new Thread(this).start();
    }
    ProductionCompany p,p1;

    @Override
    public void run() {
        try {
            while (true) {

                Object ob = server.getClientmap().get(company).read();
                System.out.println("gdfgsd");
//                    if(ob instanceof Movie)
//                    {
//                        Movie movie=(Movie) ob;
//                        ProductionCompany pr=server.getDatabase().searchBycompany(productioncompany);
//
//                        if(pr.searchByTitle(movie.getName())==null) {
//                            Movie movie1 = server.getDatabase().searchToBuySell(pr.getName());
//                            if (movie1 == null) {
//                                server.getClientmap().get(productioncompany).write("Not Available");
//                            } else {
//                                server.getDatabase().getBuysell().remove(movie1);
//                                movie1.setProductionCompany(pr.getName());
//                                pr.addMoviesToProuctioncmp(movie1);
//                                server.getClientmap().get(productioncompany).write(pr);
//                            }
//                        }else {
//                            Movie movie2=pr.searchByTitle(movie.getName());
//                            pr.removeMovie(movie2);
//                            server.getDatabase().addForBuy(movie);
//                            server.getClientmap().get(productioncompany).write(pr);
//                        }
//
//                            for(Map.Entry<String, NetworkUtil> map:server.getClientmap().entrySet())
//                            {
//                                map.getValue().write(server.getDatabase().getBuysell());
//                            }
//
//                    }
                if(ob instanceof Movie)
                {
                    Movie movie=(Movie) ob;
                    p= server.getDatabase().searchBycompany(company);
                    p.addMoviesToProuctioncmp(movie);
                    server.getClientmap().get(company).write(p);
                }
                    if(ob instanceof Transfer)
                    {
                        Transfer transfer=(Transfer) ob;
                        System.out.println("dsnfksd");
                        p= server.getDatabase().searchBycompany(company);

                        System.out.println("asfjkdsf");
                        if(p.isMovie(transfer.getMovieName()) && server.getDatabase().iscompany(transfer.getProductionCompany()))
                        {
                            Movie movie=p.searchByTitle(transfer.getMovieName());
                            System.out.println(movie.getName());
                            p.removeMovie(movie);
                            server.getClientmap().get(company).write(p);
                            //System.out.println(p1.getName());
                            System.out.println("fdsfdg");
                            //if(server.getDatabase().iscompany(transfer.getProductionCompany()))
                            //{
                                System.out.println("sfdsafd");


                                if(!(server.getDatabase().searchBycompany(transfer.getProductionCompany()).isMovie(transfer.getMovieName())))
                                {
                                    System.out.println("Fasdff");
                                    movie.setProductionCompany(server.getDatabase().searchBycompany(transfer.getProductionCompany()).getName());
                                    System.out.println(server.getDatabase().searchBycompany(transfer.getProductionCompany()).getName());
                                    server.getDatabase().searchBycompany(transfer.getProductionCompany()).addMoviesToProuctioncmp(movie);
                                    System.out.println("adfaf");
                                    server.getClientmap().get(server.getDatabase().searchBycompany(transfer.getProductionCompany()).getName()).write(server.getDatabase().searchBycompany(transfer.getProductionCompany()));
                                    System.out.println(server.getDatabase().searchBycompany(transfer.getProductionCompany()).getName());
                                    System.out.println("fadsfgggh");
                                }
                                else {
                                    server.getClientmap().get(company).write("Already Exist");
                                }
                            //}
//                            else {
//                                server.getClientmap().get(company).write("No such production company exists");
//                            }
                        }
                        else {
                            server.getClientmap().get(company).write("No such movie exists");
                        }
                    }
                    if(ob instanceof String)
                    {
                        String pass=(String) ob;
                        ProductionCompany company1=server.getDatabase().searchBycompany(company);
                        company1.setPassword(pass);
                        server.getClientmap().get(company).write(company1);
                    }

              }

        } catch (Exception e) {
            System.out.println(e);
        }
//        finally {
//            try {
//                networkUtil.closeConnection();
//                //server.getClientmap().remove(productioncompany);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

        }

}
