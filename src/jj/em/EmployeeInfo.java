package jj.em;

/**
 * This class stores employees' information into MySQL
 * including name, age, address, email, job-title, salary, and employee-number
 */
public class EmployeeInfo
{
    private int id;
    private String name;
    private int age;
    private String jobTitle;
    private double salary;
    private String email;
    private String address;

    public EmployeeInfo(int id, String name, int age, String jobTitle, double salary,
                        String email, String address)
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.email = email;
        this.address = address;
    }

    public int getID()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public int getAge()
    {
        return age;
    }
    public String getJobTitle()
    {
        return jobTitle;
    }
    public double getSalary()
    {
        return salary;
    }
    public String getEmail()
    {
        return email;
    }
    public String getAddress()
    {
        return address;
    }

}
