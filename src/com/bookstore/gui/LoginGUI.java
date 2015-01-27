package com.bookstore.gui;

import com.bookstore.Core;
import com.bookstore.debug.Log;

import javax.swing.*;

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
        this.setSize(400, 400);                                 // Title of the frame
        this.setLocationRelativeTo(null);                       // Center of screen alignment
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // Exit program when closed

        JPanel panel = new JPanel();                            // Create a panel to show everything on

        JLabel welcomeText = new JLabel("Welcome!");            // New Label with the text "Welcome!"

        // Add items to the panel
        panel.add(welcomeText);
        // End item appending

        // Add items to the frame
        this.add(panel);                                        // Add the panel to the frame
        // End item appending

        this.setVisible(true);                                  // Show this frame
    }

}
