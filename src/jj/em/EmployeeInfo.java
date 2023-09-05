package jj.em;

/**
 * This class stores employees' information into MySQL
 * including name, age, address, email, job-title, salary, and employee-number
 */
public class EmployeeInfo
{
    private int id;
    private String lastName;
    private String firstName;
    private int age;
    private String jobTitle;
    private double salary;
    private String email;
    private String address;

    public EmployeeInfo(int id, String lastName, String firstName, int age, String jobTitle, double salary,
                        String email, String address)
    {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.email = email;
        this.address = address;
    }

    public EmployeeInfo Employee()
    {
        return new EmployeeInfo(id, lastName,firstName, age, jobTitle, salary, email, address);
    }

}
