package com.Pratik;
import java.util.*;
import java.sql.*;

public class Main {
    static  String USERNAME;

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception {

        boolean stop = false;
        while(!stop) {

            try {
                System.out.println("");
                System.out.println("1. Create New account ");
                System.out.println("2. Login ");
                System.out.println("3. Admin login");
                System.out.println("4. Exit");
                System.out.print("Enter Option : ");
                switch (scanner.nextInt()) {
                    case 1:
                        new Regestration();
                        break;
                    case 2:
                        loginPage();
                        break;
                    case 3 :
                        System.out.print("Enter Password : ");
                        String password = scanner.next();
                        String adminLoginQuery = "SELECT admin_password From admin ";
                        Server serverObj = new Server(adminLoginQuery);
                        String pass =serverObj.adminLogin();
                        if(password.equals(pass)) {
                            new AdminPage();
                        }
                        else{
                            System.out.println("\n\t\t Invalid Password ! Access Denied !");
                        }
                        break;
                    case 4:
                        stop = true;
                        break;
                    default:
                        System.out.println("invalid option!");
                        break;


                }
            } catch (Exception e) {
               break;


            }
        }



    }

    public  static void loginPage() throws Exception{
        while (true) {
            System.out.print("User Name : ");
            String user = scanner.next();
            System.out.print("Password : ");
            String password = scanner.next();
            String loginQuery = " SELECT user_name,user_password FROM login WHERE user_name = ? AND user_password = ? ";
            UserLoginValidation userlogin = new UserLoginValidation();
            try {
                if (userlogin.userLoginValidation(loginQuery, user, password)) {
                    System.out.println("login successful");
                    USERNAME = user;
                    new FirstPage().firstPage();
                    break;
                }
            }catch (Exception e){
                System.out.println("\n\n\t\tInvalide User Name Password!!!");
                break;
            }



        }
    }
}
