package com.Pratik;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminPage {

    static Scanner scanner = new Scanner(System.in);


    public AdminPage() throws Exception {
        System.out.println("\t Login Successful");
        boolean start = true;
        do {

            System.out.println("\n\n***** Admin Page *****");
            System.out.println("1. Change password");
            System.out.println("2. Add Movie ");
            System.out.println("3. Remove Movie");
            System.out.println("4. Back");
            System.out.print("Choose Option : ");
            int optionSelection = scanner.nextInt();
            switch (optionSelection) {
                case 1:
                    boolean ask = true;
                    while(ask){
                        System.out.print("Old Password : ");
                        String oldPassword = scanner.next();
                        String oldPassCheckQuery = "SELECT admin_password From admin ";
                        Server oldPasswordobj = new Server(oldPassCheckQuery);

                        if(oldPasswordobj.adminLogin().equals(oldPassword)) {
                            System.out.print("New Password : ");
                            String newPassword = scanner.next();
                            String passUpdateQuery = "UPDATE admin SET admin_password = ? WHERE admin_password IS NOT NULL";
                            Server passUpdateobj = new Server(passUpdateQuery);
                            passUpdateobj.changePassword(newPassword);
                            ask = false;
                        }
                        else{
                            System.out.println("\t\tWrong Password!!!");
                            ask = false;
                            }


                    }
                    break;


                case 2:
                    System.out.print("Movie Name : ");
                    String movieToAdd = scanner.next();
                    String inserMovieQuery = "INSERT INTO movies VALUE(DEFAULT ,?)";
                    Server serverObj1 = new Server(inserMovieQuery);
                    serverObj1.addMovie(movieToAdd);
                    break;



                case 3:
                    List<String> movieList = new ArrayList<>();
                    String getMovieQuery = "SELECT movie_name FROM movies ";
                    String removeMovieQuery = "DELETE FROM movies WHERE movie_name = ? ";
                    Server serverObj2 = new Server(getMovieQuery) ;
                    ResultSet movieTable = serverObj2.movieFetching();
                    int i = 1;
                    while(movieTable.next()){
                        movieList.add(movieTable.getString(1));
                    }
                    for(String movie : movieList){
                        System.out.println(i + " : " +movie);
                        i++;
                    }

                    boolean run  = true;
                    while(run) {
                        System.out.print("Movie Number : ");
                        int movieSelection = scanner.nextInt();
                        if (movieSelection > movieList.size()) {
                            System.out.println("\nInvalid Movie");

                        } else {

                            Server serverObj3 = new Server(removeMovieQuery);
                            serverObj3.removeMovie(movieList.get(movieSelection-1));
                            run = false;
                        }

                    }
                    break;

                case 4:
                    start = false;
                    break;
                default:
                    System.out.println("Invalid Option");


            }
        } while (start);

    }



    }

