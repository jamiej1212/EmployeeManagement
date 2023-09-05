package jj.em;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class SystemPrompt
{
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    // Labels
    JLabel programTitle = new JLabel("Employee Manager");
    JLabel idLabel = new JLabel("ID: ");
    JLabel lastNameLabel = new JLabel("Last Name: ");
    JLabel firstNameLabel = new JLabel("First Name: ");
    JLabel ageLabel = new JLabel("Age: ");
    JLabel jobTitleLabel = new JLabel("Job Title: ");
    JLabel salaryLabel = new JLabel("Salary: ");
    JLabel emailLabel = new JLabel("Email: ");
    JLabel addressLabel = new JLabel("Address: ");

    // TextFields
    JTextField idField = new JTextField("Must be 8 digits");
    JTextField lastNameField = new JTextField("Must be letters");
    JTextField firstNameField = new JTextField("Must be letters");
    JTextField ageField = new JTextField("Must be 2 digits");
    JTextField jobTitleField = new JTextField("Must be letters");
    JTextField salaryField = new JTextField("Must include decimals");
    JTextField emailField = new JTextField("Must include @ and .");
    JTextField addressField = new JTextField("Must be full address");
    JTextField searchField = new JTextField();

    // Buttons
    JButton addBtn = new JButton("Add");
    JButton updateBtn = new JButton("Modify");
    JButton cancelBtn = new JButton("Cancel");
    JButton searchBtn = new JButton("Search");

    // Table
    JTable table = new JTable();

    JLabel programIcon = new JLabel();
    String iconAddress = "/pngs/employer.png";
    ImageIcon icon = new ImageIcon(Objects.requireNonNull(SystemPrompt.class.getResource(iconAddress)));

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


}
