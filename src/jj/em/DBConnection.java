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
    private Statement statement;
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
            System.out.println("Connected successfully");
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.createStatement();
        }
        catch(Exception e)
        {
            System.out.println("Connection failed: " + e.getMessage());
        }
    }

    public boolean isAdmin(String adminID, String adminPSWD)
    {
        try
        {
            String SQL = "SELECT * FROM ADMIN WHERE adminID = " + adminID + " and adminPassword = " + adminPSWD;
            // connect to DB
            // resultSet = SQL execution output
            resultSet = statement.executeQuery(SQL);
            // if data found, return true. Otherwise, return false
            if(resultSet.next())
            {
                return true;
            }
        }
        catch(Exception e)
        {
            System.out.println("Wrong ID or Password is entered" + e.getMessage());
        }
        return false;
    }

}
