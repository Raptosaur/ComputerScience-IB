package com.bookstore.gui;

import com.bookstore.Core;
import com.bookstore.LoggedInUserData;
import com.bookstore.data.UserList;
import com.bookstore.debug.Log;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by Elijah on 27/01/2015.
 */
public class UserManagerGUI extends JFrame{

    public static UserManagerGUI display;

    public static void showWindow(){

        Log.logDebug("User Management window is now being displayed");

        if(!LoggedInUserData.isLoggedIn)
            JOptionPane.showMessageDialog(null,"You are not logged in!","Error",JOptionPane.ERROR_MESSAGE);
        else if(!LoggedInUserData.loggedInUser.isAdmin())
            JOptionPane.showMessageDialog(null, "You do not have permission to view this!", "Insufficient privileges", JOptionPane.ERROR_MESSAGE);
        else
            display = new UserManagerGUI();

    }

    private UserManagerGUI(){
        super("BookManager - " + Core.version);                 // Set the title of the frame
        this.setSize(600, 400);                                 // Size of the frame
        this.setLocationRelativeTo(null);                       // Center of screen alignment
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Only dispose of the frame when closed / Clear from RAM
        this.setResizable(false);                               // We don't want the frame to be resizable

        JPanel panel = new JPanel();                            // Create a panel to show everything on

        panel.setLayout(null);

        JLabel welcomeText = new JLabel("BookManager version " + Core.version);

        JTable userTable = new JTable(new UserManagerTable());
        JScrollPane scrollPane = new JScrollPane(userTable);

        // Set the position of the objects that are going to be displayed
        welcomeText.setBounds(0,0,600,30);
        scrollPane.setBounds(10,30,575,370);
        // End the position setting

        // Center align the contents of the label(s)
        welcomeText.setHorizontalAlignment(SwingConstants.CENTER);
        // Finish alignment

        // Add items to the panel
        panel.add(welcomeText);
        panel.add(scrollPane);
        // End item appending

        // Add items to the frame
        this.add(panel);                                        // Add the panel to the frame
        // End item appending

        this.setVisible(true);                                  // Show this frame
    }

}
