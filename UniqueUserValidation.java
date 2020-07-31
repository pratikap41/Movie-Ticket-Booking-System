package com.Pratik;
import java.sql.*;

public class UniqueUserValidation {
    public boolean uniqueUserValidation(String query, String username) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_login", "root","Pratik22");
        PreparedStatement st = con.prepareStatement(query);
        st.setString(1,username);
        ResultSet rs = st.executeQuery();

        return rs.next();

    }
}