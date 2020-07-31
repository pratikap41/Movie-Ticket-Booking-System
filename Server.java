package com.Pratik;
import java.sql.*;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

public class Server {
    private static Connection con;
    private  PreparedStatement st;
    public Server(String query) throws  Exception{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_login", "root", "Pratik22");
        st = con.prepareStatement(query);


    }

    public ResultSet movieFetching() throws Exception{
        return st.executeQuery();
    }

    public String adminLogin() throws Exception{
        ResultSet rs = st.executeQuery();
        rs.next();
        return rs.getString(1);

    }

    public void addMovie(String moviename) throws Exception{
        st.setString(1,moviename);
        st.executeUpdate();
        System.out.println("\n\t\tMovie Added Successfully!!!!");
    }

    public void removeMovie(String movie) throws Exception{
        st.setString(1,movie);
        st.executeUpdate();
        System.out.println("\n\t\tMovie Removed Successfully!!!!");

    }

    public void changePassword(String newpass) throws  Exception{
        st.setString(1,newpass);
        st.executeUpdate();
        System.out.println("\n\t\tPassword Changed Successfully!!");


    }

    public int Customer_id(String user)throws Exception{
        st.setString(1,user);
        ResultSet rs =  st.executeQuery();
        rs.next();
        return  rs.getInt(1);

    }

    public void receiptToServer(int seat ,String movie, String show) throws Exception{
        long millis = System.currentTimeMillis();
        java.sql.Date now = new java.sql.Date(millis);
        Main mainObj = new Main();
        String user_id = mainObj.USERNAME ;
        Server serverObj = new Server("SELECT customer_id FROM login WHERE user_name = ?");
        int customerId = serverObj.Customer_id(user_id);
        st.setInt(1,customerId);
        st.setString(2,user_id);
        st.setString(3,movie);
        st.setString(4,show);
        st.setDate(5,now);
        st.setInt(6,seat);
        st.executeUpdate();
    }

    public void fetchingReceipt(String userid) throws Exception{
        st.setString(1,userid);
        ResultSet  rs = st.executeQuery();
        while (rs.next()){
            System.out.println("\n********* Your Tickets *********");
            System.out.println("Booking ID : " + rs.getInt(1));
            System.out.println("Customer Id : " + rs.getInt(2));
            System.out.println("User Name : " + rs.getString(3));
            System.out.println("Movie : "+ rs.getString(4));
            System.out.println("Show Time : "+ rs.getString(5));
            System.out.println("Show Date : "+ rs.getString(6));
            System.out.println("Number Of Seat : "+ rs.getInt(7));
            System.out.println("Amount Paid :\t\t\t" + NumberFormat.getCurrencyInstance().format(rs.getInt(7)*60) );

        }

    }
}