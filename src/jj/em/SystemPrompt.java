package jj.em;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Objects;

public class SystemPrompt implements ActionListener
{
    private static JFrame frame = new JFrame();
    private static JPanel panel = new JPanel();
    // Labels
    private static JLabel programTitle = new JLabel("Employee Manager");
    private static JLabel idLabel = new JLabel("ID: ");
    private static JLabel lastNameLabel = new JLabel("Last Name: ");
    private static JLabel firstNameLabel = new JLabel("First Name: ");
    private static JLabel ageLabel = new JLabel("Age: ");
    private static JLabel jobTitleLabel = new JLabel("Job Title: ");
    private static JLabel salaryLabel = new JLabel("Salary: ");
    private static JLabel emailLabel = new JLabel("Email: ");
    private static JLabel addressLabel = new JLabel("Address: ");

    // TextFields
    private static JTextField idField = new JTextField();
    private static JTextField lastNameField = new JTextField();
    private static JTextField firstNameField = new JTextField();
    private static JTextField ageField = new JTextField();
    private static JTextField jobTitleField = new JTextField();
    private static JTextField salaryField = new JTextField();
    private static JTextField emailField = new JTextField();
    private static JTextField addressField = new JTextField();
    private static JTextField searchField = new JTextField();

    // Buttons
    private static JButton addBtn = new JButton("Add");
    private static JButton updateBtn = new JButton("Update");
    private static JButton cancelBtn = new JButton("Cancel");
    private static JButton searchBtn = new JButton("Search");

    // Table
    JTable table = new JTable();

    JLabel programIcon = new JLabel();
    String iconAddress = "/pngs/employer.png";
    ImageIcon icon = new ImageIcon(Objects.requireNonNull(SystemPrompt.class.getResource(iconAddress)));

    // User Inputs
    int id, age = 0;
    String lastName, firstName, jobTitle, email, address = "";
    double salary = 0.0;

    public void systemManager()
    {
        // Frame Settings
        frameSetting();
        // Panel Settings
        panelSetting();
        // Label Settings
        labelSetting();
        // Icon Settings
        iconSetting();
        // TextField Settings
        textFieldSetting();
        // Button Settings
        buttonSetting();
        // ActionListener Settings
        actionListenerSetting();
    }

    // This method sets frame
    public void frameSetting()
    {
        frame.setPreferredSize(new Dimension(600, 400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    // This method sets panel
    public void panelSetting()
    {
        panel.setLayout(null);
    }

    // This method sets labels
    public void labelSetting()
    {
        programTitle.setBounds(95, 0, 300, 50);
        idLabel.setBounds(30, 80, 80, 25);
        lastNameLabel.setBounds(30, 105, 80, 25);
        firstNameLabel.setBounds(30, 130, 80, 25);
        ageLabel.setBounds(30,155, 80, 25);
        jobTitleLabel.setBounds(30, 180, 80, 25);
        salaryLabel.setBounds(30, 205, 80, 25);
        emailLabel.setBounds(30, 230, 80, 25);
        addressLabel.setBounds(30, 255, 80, 25);
        panel.add(programTitle);
        panel.add(idLabel);
        panel.add(lastNameLabel);
        panel.add(firstNameLabel);
        panel.add(ageLabel);
        panel.add(jobTitleLabel);
        panel.add(salaryLabel);
        panel.add(emailLabel);
        panel.add(addressLabel);
    }

    // This method sets icon
    public void iconSetting()
    {
        programIcon.setIcon(icon);
        programIcon.setBounds(60, 10, 30, 30);
        programIcon.setHorizontalAlignment(JLabel.CENTER);
        panel.add(programIcon);
    }

    // This method sets textFields
    public void textFieldSetting()
    {
        idField.setBounds(110, 80, 130, 25);
        lastNameField.setBounds(110, 105, 130, 25);
        firstNameField.setBounds(110, 130, 130, 25);
        ageField.setBounds(110, 155, 130, 25);
        jobTitleField.setBounds(110, 180, 130, 25);
        salaryField.setBounds(110,205, 130, 25);
        emailField.setBounds(110,230, 130, 25);
        addressField.setBounds(110, 255, 130, 25);
        searchField.setBounds(320, 291, 165, 25);
        panel.add(idField);
        panel.add(lastNameField);
        panel.add(firstNameField);
        panel.add(ageField);
        panel.add(jobTitleField);
        panel.add(salaryField);
        panel.add(emailField);
        panel.add(addressField);
        panel.add(searchField);
    }

    // This method sets buttons
    public void buttonSetting()
    {
        addBtn.setBounds(10, 290, 80, 25);
        updateBtn.setBounds(92, 290, 80, 25);
        cancelBtn.setBounds(174, 290, 80, 25);
        searchBtn.setBounds(490, 290, 80, 25);
        panel.add(addBtn);
        panel.add(updateBtn);
        panel.add(cancelBtn);
        panel.add(searchBtn);
    }

    // This method adds ActionListener to buttons
    public void actionListenerSetting()
    {
        addBtn.addActionListener(new SystemPrompt());
        updateBtn.addActionListener(new SystemPrompt());
        cancelBtn.addActionListener(new SystemPrompt());
        searchBtn.addActionListener(new SystemPrompt());
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == cancelBtn)
        {
            System.out.println("Cancel Button Pressed");
            System.exit(0);
        }
        else if(e.getSource() == addBtn)
        {
            if(inputValidation())
            {
                inputValidation();
                getInputID();
                getLastName();
                getFirstName();
                getAge();
                getJobTitle();
                getSalary();
                getEmail();
                getAddress();
                DBConnection db = new DBConnection();
                db.insertData(id, lastName, firstName, age, jobTitle, salary, email, address);

            }
            else
            {
                JOptionPane.showMessageDialog(null, "Please fill all boxes");
            }
            System.out.println("Add Button Pressed");

        }
        else if(e.getSource() == updateBtn)
        {
            System.out.println("Update Button Pressed");
        }
        else if(e.getSource() == searchBtn)
        {
            System.out.println("Search Button Pressed");
        }
    }

    public boolean inputValidation()
    {
        return !idField.getText().isEmpty() && !lastNameField.getText().isEmpty() && !firstNameField.getText().isEmpty() && !ageField.getText().isEmpty()
                && !jobTitleField.getText().isEmpty() && !salaryField.getText().isEmpty() && !emailField.getText().isEmpty() && !addressField.getText().isEmpty();
    }
    public void getInputID()
    {
        if(idField.getText().length() == 8 && idField.getText().matches("[0-9]+"))
        {
            id = Integer.parseInt(idField.getText());
            System.out.println(id);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "ID must be 8 digits");
        }

    }

    public void getLastName()
    {
        if(lastNameField.getText().matches("[a-zA-Z]*"))
            lastName = lastNameField.getText();
        else
            JOptionPane.showMessageDialog(null, "Last name must be letters");
    }

    public void getFirstName()
    {
        if(firstNameField.getText().matches("[a-zA-Z]*"))
            firstName = firstNameField.getText();
        else
            JOptionPane.showMessageDialog(null, "First name must be letters");
    }

    public void getAge()
    {
        if(ageField.getText().length() == 2 && ageField.getText().matches("[0-9]+"))
            age = Integer.parseInt(ageField.getText());
        else
            JOptionPane.showMessageDialog(null, "Age must be 2 digits");
    }
    public void getJobTitle()
    {
        if(jobTitleField.getText().matches("^[ a-zA-Z]+$"))
            jobTitle = jobTitleField.getText();
        else
            JOptionPane.showMessageDialog(null, "Job title must be letters");
    }

    public void getSalary()
    {
        if(salaryField.getText().matches("[0-9]+([.][0-9]+)*"))
            salary = Double.parseDouble(salaryField.getText());
        else
            JOptionPane.showMessageDialog(null, "Salary must be numeric");
    }

    public void getEmail()
    {
        if(emailField.getText().contains("@") && emailField.getText().contains("."))
            email = emailField.getText();
        else
            JOptionPane.showMessageDialog(null, "Invalid email address");
    }

    public void getAddress()
    {
        if(addressField.getText().contains(","))
            address = addressField.getText();
        else
            JOptionPane.showMessageDialog(null, "Address must include city, state, and zipcode");
    }

}
