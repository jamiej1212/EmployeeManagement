package jj.em;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * This class offers Login GUI
 */
public class LoginPrompt implements ActionListener
{
    private static JFrame frame = new JFrame();
    private static JPanel panel = new JPanel();
    private static JLabel programTitle = new JLabel("Employee Manager");
    private static JLabel idLabel = new JLabel("User ID: ");
    private static JLabel pswdLabel = new JLabel("Password: ");
    private static JTextField idTextField = new JTextField();
    private static JPasswordField pswdField = new JPasswordField();
    private static JButton loginBtn = new JButton("Login");
    private static JButton cancelBtn = new JButton("Cancel");
    String userID = "";
    String password = "";
    JLabel programIcon = new JLabel();
    ImageIcon icon = new ImageIcon(Objects.requireNonNull(SystemPrompt.class.getResource("/pngs/employer.png")));

    public void loginManager()
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
        // PasswordField Settings
        passwordFieldSetting();
        // Button Settings
        buttonSetting();
        // ActionListener Settings
        actionListenerSetting();

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
    }

    // This method sets frame
    public void frameSetting()
    {
        frame.setPreferredSize(new Dimension(300, 300));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        // Visibility Settings
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
        idLabel.setBounds(30, 90, 80,25);
        pswdLabel.setBounds(30, 115, 80, 25);
        panel.add(programTitle);
        panel.add(idLabel);
        panel.add(pswdLabel);
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
        panel.add(idTextField);
        idTextField.setBounds(110, 90, 120, 25);
    }

    // This method sets passwordField
    public void passwordFieldSetting()
    {
        panel.add(pswdField);
        pswdField.setBounds(110, 115, 120, 25);
    }

    // This method sets buttons
    public void buttonSetting()
    {
        panel.add(loginBtn);
        panel.add(cancelBtn);
        loginBtn.setBounds(68, 150, 80, 25);
        cancelBtn.setBounds(152, 150, 80, 25);
    }

    // This method adds ActionListener to buttons
    public void actionListenerSetting()
    {
        loginBtn.addActionListener(new LoginPrompt());
        cancelBtn.addActionListener(new LoginPrompt());
    }

    /**
     * check if entered information is matched to DB
     * if matched, shows employee information setting GUI
     * if not, shows error GUI
     * @param e ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == cancelBtn)
        {
            System.out.println("Button Pressed");
            System.exit(0);
        }
        else
        {
            userID = idTextField.getText();
            password = new String(pswdField.getPassword());
            DBConnection dbConnection = new DBConnection();
            dbConnection.isAdmin(userID, password);
            if(dbConnection.isAdmin(userID, password))
            {
                frame.dispose();
                SystemPrompt sp = new SystemPrompt();
                sp.systemManager();
            }
        }

    }
}
