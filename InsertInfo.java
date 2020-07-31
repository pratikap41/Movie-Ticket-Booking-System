package com.Pratik;
import java.sql.*;
import java.util.zip.CheckedOutputStream;

public class InsertInfo {
    public InsertInfo(String query , String firstname, String lastname, String phnum, String dob, String username, String userpassword) throws  Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_login", "root","Pratik22");
        PreparedStatement st = con.prepareStatement(query);
        st.setString(1, firstname);
        st.setString(2, lastname);
        st.setString(3, phnum);
        st.setString(4, dob);
        st.setString(5, username);
        st.setString(6, userpassword);

        st.executeUpdate();
        st.close();
        con.close();
    }
}