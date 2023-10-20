package server;

import util.Login;
import util.NetworkUtil;
import util.ProductionCompany;
import server.database.Database;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Server {
    private HashMap<String, NetworkUtil> clientmap;
    private Database database;

    public HashMap<String, NetworkUtil> getClientmap() {
        return clientmap;
    }

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    Server()
    {
        callDatabase();
        while (true)
        {
            try {
                ServerSocket serverSocket=new ServerSocket(44456);
                while (true) {
                    Socket clientsocket = serverSocket.accept();
                    gotoserver(clientsocket);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void callDatabase()
    {
        database=new Database();
        try {
            database.readFile();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        for(ProductionCompany p:database.getProductionCompanies())
        {
            p.setPassword("asdfg");
        }

        clientmap=new HashMap<>();
    }

    public void gotoserver(Socket clientsocket) {
        try {

                NetworkUtil networkUtil = new NetworkUtil(clientsocket);
         //  while (true) {
                Object ob = networkUtil.read();
                if (ob != null) {
                    if (ob instanceof Login) {
                        Login login = (Login) ob;
                        //ProductionCompany p = database.searchBycompany(login.getProductioncompany());
                        String productioncompany = (String) login.getProductioncompany();
                        System.out.println(productioncompany);
                        String password = (String) login.getPassword();
                        System.out.println(password);
                        login.setStatus(database.iscompany(productioncompany) && (database.searchBycompany(login.getProductioncompany()).getPassword().equals(password)));
                        System.out.println(login.isStatus());
                        networkUtil.write(login);
                        if (login.isStatus()) {
                           //try {

                                ProductionCompany p = database.searchBycompany(login.getProductioncompany());
                                clientmap.put(p.getName(), networkUtil);
                                networkUtil.write(p);
                                //networkUtil.write(database.getBuysell());
                                //System.out.println(p.getName());
                                    new ReadThreadServer(this,p.getName());
                           // } catch (Exception e) {
                                //System.out.println(e);
                           // }
                        }
                        //loginCheck(login,networkUtil);
                    }
                }
         // }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
//    public void loginCheck(Login login, NetworkUtil networkUtil) throws Exception {
//        try {
//            ProductionCompany p = database.searchBycompany(login.getProductioncompany());
//
//
//                    if (p.getPassword().equalsIgnoreCase(login.getPassword())) {
//                        if (clientmap.containsKey(p.getName())) {
//                            networkUtil.write("You are logged in");
//                            System.out.println("You are logged in");
//                            networkUtil.closeConnection();
//                        } else {
//                            clientmap.put(p.getName(), networkUtil);
//                            networkUtil.write(p);
//                            //networkUtil.write(database.getBuysell());
//                            //new ReadThreadServer(this, p.getName());
//                        }
//                    } else {
//                        networkUtil.write("Invalid  Password");
//                        System.out.println("Invalid  Password");
//                        networkUtil.closeConnection();
//                    }
//
//
//        }catch(Exception e){
//            networkUtil.write("No production company with this name");
//            System.out.println("No production company with this name");
//            networkUtil.closeConnection();
//        }

   // }

    public static void main(String[] args) {
        new Server();
    }
}
