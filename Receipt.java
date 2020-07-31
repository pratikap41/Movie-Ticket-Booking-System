package com.Pratik;

import java.text.NumberFormat;
import java.util.Scanner;

public class Receipt {

    static Scanner scanner = new Scanner(System.in);




    public Receipt(String selectedShow, String selectedMovie, int numberOfSeat) throws Exception{

        System.out.println("\n\n*****Payment******");
        System.out.println("Movie : " + selectedMovie);
        System.out.println("Show Time : " + selectedShow);
        System.out.println("Number of Tickets : " + numberOfSeat);
        System.out.print("Amount : \t\t" + numberOfSeat + " * 60 = " + NumberFormat.getCurrencyInstance().format(numberOfSeat*60)    );
        while(true) {

            System.out.println("\nEnter 10 digit Card Number :");
            if (scanner.next().length() == 10) {
                System.out.print("Enter your pin :  ");
                scanner.next();
                System.out.println(" \n\n\t\t\tTicket Booked Successfully !!");
                break;
            } else {
                System.out.println("Invalid Card Number");
                continue;
            }
        }


        String receiptQuery = "INSERT INTO booking VALUE(DEFAULT, ?, ?, ?, ?, ?, ?) ";

        Server serverObj = new Server(receiptQuery);
        serverObj.receiptToServer(numberOfSeat, selectedMovie, selectedShow);




    }
}