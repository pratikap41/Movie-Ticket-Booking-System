package com.Pratik;

import com.Pratik.InsertInfo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Regestration {
    public Regestration() throws  Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.print("First Name : ");
        String firstName =  scanner.next();
        System.out.print("Last Name : ");
        String lastName =  scanner.next();
        System.out.print("Phone Number : ");
        String phNum =  scanner.next();
        System.out.print("Date of Birth : ");
        String dob =  scanner.next();

        String userName = " ";
        UniqueUserValidation obj = new UniqueUserValidation();
        boolean val = true;

        String validationQuery = "SELECT user_name FROM login WHERE user_name = ? ";
        while(true) {
            System.out.print("Create User Name : ");
            userName = scanner.next();
            val = obj.uniqueUserValidation(validationQuery, userName);
            if (!val) {

                break;

            }
            else{
                System.out.println(" \t\t User Name Already Taken!!! ");
                continue;
            }
        }

        System.out.print("New Password : ");
        String password = scanner.next();
        System.out.print("\t\t Account created !!!! 1");
        String insertQuery = "insert into login value(default, ? , ? , ?, ? , ? , ?) ";
        new InsertInfo(insertQuery , firstName, lastName, phNum, dob, userName, password);
    }
}