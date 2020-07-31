package com.Pratik;

import java.util.Scanner;



public class FirstPage {
    final int  totalSeat = 100;

    public  void firstPage() throws Exception {


        boolean start = true    ;
        Scanner scanner = new Scanner(System.in);



        do {
            System.out.print("\n\n/////////////////////////////////////////");
            System.out.println("\n******* PVR Cinemas : Shirpur ******** ");
            System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
            System.out.println("1.  Now playing ");
            System.out.println("2.  Your Ticket ");
            System.out.println("3.  Exit");
            System.out.print("Choose option : ");
            int optionSelection = scanner.nextInt();

            switch(optionSelection) {
                case 1:
                    NowPlaying playing = new NowPlaying();
                    playing.nowPlaying();

                    break;
                case 2 :

                    String fetchReceiptQuery = "SELECT * FROM booking WHERE user_name = ? ";
                    Server serverobj = new Server(fetchReceiptQuery);
                    serverobj.fetchingReceipt(new Main().USERNAME);
                    break;

                case 3:
                    start = false;
                    break;



                default:
                    System.out.println("Option invalid");
            }


        }while(start);




    }
}
