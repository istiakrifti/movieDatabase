package util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Serializable;
import java.util.*;
public class ProductionCompany implements Serializable {

    //private static final String INPUT_FILE_NAME = "movies.txt";
    private static final String OUTPUT_FILE_NAME = "movies.txt";
    String name;
    String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    List<Movie> MovieList=new ArrayList();
//    public void readFile() throws Exception
//    {
//
//
//        BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
//        while (true) {
//            String line = br.readLine();
//            if (line == null) break;
//            String[] obj=line.split(",");
//            Movie ob=new Movie(obj[0],Integer.parseInt(obj[1]),obj[2],obj[3],obj[4],Integer.parseInt(obj[5]),obj[6],Integer.parseInt(obj[7]),Integer.parseInt(obj[8]));
//            MovieList.add(ob);
//        }
//        br.close();
//    }

    public List<Movie> getMovieList() {
        return MovieList;
    }

    public void addMoviesToProuctioncmp(Movie movie)
    {
        MovieList.add(movie);
    }
    public void removeMovie(Movie movie){
        MovieList.remove(movie);
    }
    public boolean isMovie(String title)
    {
        for (int i = 0; i < MovieList.size(); i++) {
            if (MovieList.get(i).getName().equalsIgnoreCase(title)) {
                return true;
            }
        }
        return false;
    }
    public Movie searchByTitle(String title)
    {
        int x=-1;
        for (int i = 0; i < MovieList.size(); i++) {
            if (MovieList.get(i).getName().equalsIgnoreCase(title)) {
                x=i;
            }
        }

        if(x != -1) return MovieList.get(x);
        else return null;
    }

    public List<Movie> searchByReleasingyear(int year)
    {
        int flag=0;
        List<Movie> mov=new ArrayList();
        for (int i = 0; i < MovieList.size(); i++) {
            if (MovieList.get(i).getReleaseYear()==year) {
                flag=1;
                mov.add(MovieList.get(i));
            }
        }
        if(flag==0) return null;
        else return mov;
    }

    public List<Movie> searchBygenre(String gen)
    {
        int flag=0;
        List<Movie> mov=new ArrayList();
        for (int i = 0; i < MovieList.size(); i++) {
            if (MovieList.get(i).getGenre1().equalsIgnoreCase(gen)||MovieList.get(i).getGenre2().equalsIgnoreCase(gen)||MovieList.get(i).getGenre3().equalsIgnoreCase(gen)) {
                flag=1;
                mov.add(MovieList.get(i));
            }
        }
        if(flag==0) return null;
        else return mov;
    }

    public List<Movie> searchByproductionCmp(String gen)
    {
        int flag=0;
        List<Movie> mov=new ArrayList();
        for (int i = 0; i < MovieList.size(); i++) {
            if (MovieList.get(i).getProductionCompany().equalsIgnoreCase(gen)) {
                flag=1;
                mov.add(MovieList.get(i));
            }
        }
        if(flag==0) return null;
        else return mov;
    }

    public List<Movie> searchByrunningtime(int x, int y)
    {
        int flag=0;
        List<Movie> mov=new ArrayList();
        for (int i = 0; i < MovieList.size(); i++) {
            if (MovieList.get(i).getRunningTime()>=x && MovieList.get(i).getRunningTime()<=y) {
                flag=1;
                mov.add(MovieList.get(i));
            }
        }
        if(flag==0) return null;
        else return mov;
    }

    public List<Movie> topTenMovie()
    {
        List<Movie> mov=new ArrayList();
        for (int i = 0; i < MovieList.size(); i++)
        {
                mov.add(MovieList.get(i));

        }
        Collections.sort(mov, new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return Integer.compare(o2.getRevenue()-o2.getBudget(),o1.getRevenue()-o1.getBudget() );
            }
        });
        return mov;
    }

    public List<Movie> MostRecentMovie(String company)
    {
        int flag=0;
        List<Movie> productioncmp=new ArrayList();
        for (int i = 0; i < MovieList.size(); i++) {
            if (MovieList.get(i).getProductionCompany().equalsIgnoreCase(company)) {
                flag=1;
                Movie m=MovieList.get(i);
                Movie ob=new Movie(m.getName(),m.getReleaseYear(),m.getGenre1(),m.getGenre2(),m.getGenre3(),m.getRunningTime(),m.getProductionCompany(),m.getBudget(),m.getRevenue());
                productioncmp.add(ob);
            }
        }
        if(flag==0) return null;
        else
        {
            Collections.sort(productioncmp, new Comparator<Movie>() {
                @Override
                public int compare(Movie o1, Movie o2) {
                    return Integer.compare(o2.getReleaseYear(), o1.getReleaseYear());
                }
            });
            List<Movie> temp=new ArrayList<>();
            for (int i=0;i<productioncmp.size();i++)
            {
                if(productioncmp.get(i).getReleaseYear()==productioncmp.get(0).getReleaseYear())
                {
                    temp.add(productioncmp.get(i));
                }
            }
            return temp;
        }

    }

    public List<Movie> MaxRevenueMovie(String company)
    {
        int flag=0;
        List<Movie> productioncmp=new ArrayList();
        for (int i = 0; i < MovieList.size(); i++) {
            if (MovieList.get(i).getProductionCompany().equalsIgnoreCase(company)) {
                flag=1;
                Movie m=MovieList.get(i);
                Movie ob=new Movie(m.getName(),m.getReleaseYear(),m.getGenre1(),m.getGenre2(),m.getGenre3(),m.getRunningTime(),m.getProductionCompany(),m.getBudget(),m.getRevenue());
                productioncmp.add(ob);
            }
        }
        if(flag==0) return null;

        else
        {
            Collections.sort(productioncmp, new Comparator<Movie>() {
                @Override
                public int compare(Movie o1, Movie o2) {
                    return Integer.compare(o2.getRevenue(), o1.getRevenue());
                }
            });
            return productioncmp;
        }

    }

    public Long totalProfit(String company)
    {
        int flag=0;
        List<Movie> productioncmp=new ArrayList();
        for (int i = 0; i < MovieList.size(); i++) {
            if (MovieList.get(i).getProductionCompany().equalsIgnoreCase(company)) {
                flag=1;
                Movie m=MovieList.get(i);
                Movie ob=new Movie(m.getName(),m.getReleaseYear(),m.getGenre1(),m.getGenre2(),m.getGenre3(),m.getRunningTime(),m.getProductionCompany(),m.getBudget(),m.getRevenue());
                productioncmp.add(ob);
            }
        }
        if(flag==0) return null;
        else {
            long profit = 0;
            for (int i = 0; i < productioncmp.size(); i++) {

                profit += (productioncmp.get(i).getRevenue() - productioncmp.get(i).getBudget());
            }
            return profit;
        }
    }

    public List<String> countMovies()
    {
        List<String> str=new ArrayList();
        for(int i=0;i<MovieList.size();i++)
        {
            str.add(MovieList.get(i).getProductionCompany());
        }
        return str;
    }

    public void addMovie()
    {
        int releaseyear,runningtime,budget,revenue,x,flag=0;
        String name;
        String genre1=new String();
        String genre2=new String();
        String genre3=new String();
        String company;
        Scanner input=new Scanner(System.in);
        System.out.println("Enter movie name: ");
        name=input.nextLine();
        for(int i=0;i<MovieList.size();i++)
        {
            if(MovieList.get(i).getName().equalsIgnoreCase(name))
            {
                flag=1;
                break;
            }
        }
        if(flag==1) System.out.println("Already exists the movie.Try another one!!!");
        else {
            Scanner input5=new Scanner(System.in);
            System.out.println("Enter release year: ");
            releaseyear = input.nextInt();
            System.out.println("Enter genre: ");
            Scanner input3 = new Scanner(System.in);
            genre1 = input3.nextLine();
            genre2 = input3.nextLine();
            genre3 = input3.nextLine();

            Scanner input6 = new Scanner(System.in);
            System.out.println("Enter running time(in minutes): ");
            runningtime = input.nextInt();
            System.out.println("Enter production Company name: ");
            company = input6.nextLine();
            System.out.println("Enter budget: ");
            budget = input.nextInt();
            System.out.println("Enter revenue: ");
            revenue = input.nextInt();

            Movie ob = new Movie(name, releaseyear, genre1, genre2, genre3, runningtime, company, budget, revenue);
            MovieList.add(ob);
        }
    }
     public void writeFile() throws Exception
     {
         BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME));
         for(int i=0;i<MovieList.size();i++)
         {
             Movie m=MovieList.get(i);
             String line=m.getName()+","+String.valueOf(m.getReleaseYear())+","+m.getGenre1()+","+m.getGenre2()+","+m.getGenre3()+","+String.valueOf(m.getRunningTime())+","+
                     m.getProductionCompany()+","+String.valueOf(m.getBudget())+","+String.valueOf(m.getRevenue());
             bw.write(line);
             bw.write(System.lineSeparator());
         }

         bw.close();
     }
}
