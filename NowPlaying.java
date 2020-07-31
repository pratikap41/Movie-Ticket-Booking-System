package com.Pratik;

import java.util.*;
import java.sql.*;

public class NowPlaying {

    List<String> movies = new ArrayList<String>();



    public void nowPlaying() throws Exception {

        String movieFetchQuery = " select movie_name from movies";
        Server serverObj = new  Server(movieFetchQuery);
        ResultSet moviesTable = serverObj.movieFetching();
        while(moviesTable.next()){
            movies.add(moviesTable.getString(1));
        }


        Scanner scanner = new Scanner(System.in);


        System.out.println("\n\n*****MOVIES*****");
        int i = 1;
        for(String mov : movies ){
            System.out.println(i + "  :  " + mov);

            i++;
        }
        System.out.println("To exit press 0");


        System.out.print(" choose option : ");
        int optionSelection =  scanner.nextInt();
        if(optionSelection > movies.size())
            System.out.println("invalid option");
        else if(optionSelection == 0) {
            FirstPage home = new FirstPage();
        }
        else {
            ShowTiming show = new ShowTiming(movies.get(optionSelection- 1 ));
        }
    }

    public void addMovie(String movie){
         movies.add(movie);
    }

    public  void removeMovie(int movieIndex){
        movies.remove(movieIndex) ;

    }

}