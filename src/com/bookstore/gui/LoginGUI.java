package com.bookstore.gui;

import com.bookstore.Core;
import com.bookstore.debug.Log;
import com.bookstore.users.login.Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Elijah on 27/01/2015.
 */
public class LoginGUI extends JFrame{

    public static LoginGUI display;

    public static void showWindow(){

        Log.logDebug("System login window is now being displayed.");

        display = new LoginGUI();

    }

    private LoginGUI(){
        super("BookManager - " + Core.version);                 // Set the title of the frame
        this.setSize(400, 300);                                 // Title of the frame
        this.setLocationRelativeTo(null);                       // Center of screen alignment
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // Exit program when closed
        this.setResizable(false);                               // We don't want the login screen to be resizable

        JPanel panel = new JPanel();                            // Create a panel to show everything on

        panel.setLayout(null);

        JLabel welcomeText = new JLabel("BookManager version " + Core.version);
        JLabel titleText = new JLabel("Login");
        JLabel userText = new JLabel("Username");
        JLabel passwordText = new JLabel("Password");
        final JTextField userField = new JTextField();
        final JTextField passField = new JPasswordField();
        JButton submitButton = new JButton("Log in");

        // Set up the handlers for the Submit button, else it wont do anything
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Log.logDebug("Login button has been clicked in LoginGUI");
                if(Login.AttemptLogin(userField.getText(), passField.getText())) {
                    dispose();
                    Log.logDebug("Disposed LoginGUI - Successful login with details:");
                    Log.logDebug("Username: "+userField.getText()+" Password: "+passField.getText());
                }
            }
        });
        // Finished with submit button

        // Set the position of the objects that are going to be displayed
        welcomeText.setBounds(120,10,150,30);
        titleText.setBounds(170,40,50,30);
        userText.setBounds(155,70,75,30);
        userField.setBounds(90,100,200,25);
        passwordText.setBounds(155,135,75,30);
        passField.setBounds(90,165,200,25);
        submitButton.setBounds(140,200,100,25);
        // End the position setting

        // Add items to the panel
        panel.add(welcomeText);
        panel.add(titleText);
        panel.add(userText);
        panel.add(passwordText);
        panel.add(userField);
        panel.add(passField);
        panel.add(submitButton);
        // End item appending

        // Add items to the frame
        this.add(panel);                                        // Add the panel to the frame
        // End item appending

        this.setVisible(true);                                  // Show this frame
    }

}
