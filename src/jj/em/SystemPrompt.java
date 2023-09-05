package jj.em;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SystemPrompt implements ActionListener
{
    private static JFrame loginFrame = new JFrame();
    private static JPanel loginPanel = new JPanel();
    private static JLabel programTitle = new JLabel("Employee Manager");
    private static JLabel idLabel = new JLabel("User ID: ");
    private static JLabel pswdLabel = new JLabel("Password: ");
    private static JTextField idTextField = new JTextField();
    private static JPasswordField pswdField = new JPasswordField();
    private static JButton loginBtn = new JButton("Login");
    private static JButton cancelBtn = new JButton("Cancel");
    String userID = "";
    String password = "";

    public void login()
    {
        // Frame Settings
        loginFrame.setPreferredSize(new Dimension(300, 300));
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.add(loginPanel);

        // Panel Settings
        loginPanel.setLayout(null);
        programTitle.setBounds(80, 0, 300, 50);
        idLabel.setBounds(30, 90, 80,25);
        pswdLabel.setBounds(30, 115, 80, 25);
        loginPanel.add(programTitle);
        loginPanel.add(idLabel);
        loginPanel.add(pswdLabel);

        // TextField Settings
        loginPanel.add(idTextField);
        idTextField.setBounds(110, 90, 120, 25);

        // PasswordField Settings
        loginPanel.add(pswdField);
        pswdField.setBounds(110, 115, 120, 25);

        // Button Settings
        loginPanel.add(loginBtn);
        loginPanel.add(cancelBtn);
        loginBtn.setBounds(68, 150, 80, 25);
        cancelBtn.setBounds(152, 150, 80, 25);

        // ActionListener Settings
        loginBtn.addActionListener(new SystemPrompt());
        cancelBtn.addActionListener(new SystemPrompt());
        /*
        loginBtn.addActionListener(e ->
        {
            userID = idTextField.getText();
            password = new String(pswdField.getPassword());
            DBConnection dbConnection = new DBConnection();
            dbConnection.isAdmin(userID, password);
        });
        cancelBtn.addActionListener(e -> System.exit(0));
         */

        // Visibility Settings
        loginFrame.pack();
        loginFrame.setVisible(true);


    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == cancelBtn)
        {
            System.exit(0);
        }
        else
        {
            userID = idTextField.getText();
            password = new String(pswdField.getPassword());
            DBConnection dbConnection = new DBConnection();
            dbConnection.isAdmin(userID, password);
        }

    }
}
