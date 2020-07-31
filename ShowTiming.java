package com.Pratik;
import java.util.Scanner;
import java.sql.*;



public class ShowTiming  {
    static Scanner scanner = new Scanner(System.in);

    public ShowTiming(String selected ) throws Exception{                                                                                //constructor

        System.out.println("\n\n***** Show timing ******");
        String[] showTiming = {"10:00 AM", "2:00 PM", "6:00 PM", "10:00 PM"};
        for(int i = 0; i < showTiming.length; i++ )
            System.out.println( (i+1) + " : " + showTiming[i] );
        System.out.println("To Exit Press 0");
        System.out.print("Choose Option : ");
        int optionSelection = scanner.nextInt();

        if(optionSelection > showTiming.length){
            System.out.println("Invalid option ");
        }
        else if(optionSelection == 0) {
            Main home = new Main();
        }
        else {
            System.out.print("Enter Number Of Tickets :");
            int NumberOfTickets = scanner.nextInt();
            Receipt payment = new Receipt(showTiming[optionSelection - 1], selected, NumberOfTickets);

        }

        }



}
