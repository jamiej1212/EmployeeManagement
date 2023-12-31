package jj.em;

import javax.swing.*;
import java.awt.event.ActionEvent;
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

    /**
     * Constructor
     */
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

    /**
     * A method that checks login information is matched
     * @param adminID Administrator's ID
     * @param adminPSWD Administrator's Password
     * @return true if the info is matched
     */
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
            if(statement != null)
                statement.close();
            if(connection != null)
                connection.close();

        }
        catch(Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }
        /*
            1. printStackTrace() : java.lang.Error inherited into java.lang.Exception
                Displays the name of the exception, nature of the message, and line number
            2. getMessage() : java.lang.Throwable inherited into java.lang.Exception
                Displays only exception message
                finally
        {
            try
            {
                connection.close();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        }
         */

        System.out.println("Wrong ID or Password is Entered");
        return false;
    }

    public void insertData(int id, String lastName, String firstName, int age, String jobTitle, double salary,
                           String email, String address)
    {
        try
        {
            String sql = "INSERT INTO employees " + "VALUES(?, ?, ?, ?, ?, ?, ?, ?) ";
            statement = connection.prepareStatement(sql);


            statement.setInt(1, id);
            statement.setString(2, lastName);
            statement.setString(3, firstName);
            statement.setInt(4, age);
            statement.setString(5, jobTitle);
            statement.setDouble(6, salary);
            statement.setString(7, email);
            statement.setString(8, address);


            int result = statement.executeUpdate();
            System.out.println(result+ "inputs are entered");
        }
        catch(SQLException e)
        {
            if(e.getErrorCode() == 1062)
            {
                JOptionPane.showMessageDialog(null, "This employee exists in the DB\n" + "Please use modify instead");
            }
        }

    }

}
