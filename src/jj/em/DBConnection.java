package jj.em;

import java.sql.*;

/**
 * This class connects the program to the DB
 */
public class DBConnection
{
    // Connection object
    private Connection connection;
    // Allows to use query to designate DB
    private PreparedStatement statement;
    // Gets output
    private ResultSet resultSet;

    private static final String USERNAME = "root"; // DBMS ID
    private static final String PASSWORD = "1234"; // DBMS Password
    private static final String URL = "jdbc:mysql://localhost:3306/employee_management"; // DBMS URL

    // Constructor
    public DBConnection()
    {
        // Check if connection failed
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connected successfully");
        }
        catch(ClassNotFoundException | SQLException e)
        {
           e.printStackTrace();
        }
    }

    public boolean isAdmin(String adminID, String adminPSWD)
    {
        try
        {
            String sql = "SELECT * FROM ADMIN WHERE adminID = '" + adminID + "' and adminPassword = '" + adminPSWD +"'";
            // Send sql to the DB
            statement = connection.prepareStatement(sql);
            // resultSet = sql execution output
            resultSet = statement.executeQuery(sql);
            // if data found, return true. Otherwise, return false
            if(resultSet.next())
            {
                System.out.println("Successfully Logged in");
                return true;
            }
            System.out.println(adminID + " " + adminPSWD);

        }
        catch(Exception e)
        {
            System.out.println("Wrong ID or Password is entered" + e.getMessage());
        }
        return false;
    }

}
