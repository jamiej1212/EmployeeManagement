package jj.em;

/**
 * Main Class
 * This program helps employers to manage their employees
 */

public class EmployeeManager
{

    public static void main(String[] args)
    {
        //DBConnection dbConnection = new DBConnection();
        //System.out.println("Admin confirmation: " + dbConnection.isAdmin("admin", "admin1"));
        LoginPrompt lp = new LoginPrompt();
        lp.loginManager();
        //SystemPrompt sp = new SystemPrompt();
        //sp.systemManager();


    }
}
