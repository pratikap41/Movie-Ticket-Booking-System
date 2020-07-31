package com.Pratik;
import java.sql.*;


public class UserLoginValidation {
    public boolean userLoginValidation(String query , String user , String password) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_login", "root","Pratik22");
        PreparedStatement st = con.prepareStatement(query);
        st.setString(1,user);
        st.setString(2, password);
        ResultSet rs = st.executeQuery();
        rs.next();
        return rs.getString(1).equals(user) && rs.getString(2).equals(password);

    }
}