package com.bookstore.gui;

import com.bookstore.Core;
import com.bookstore.LoggedInUserData;
import com.bookstore.debug.Log;
import com.bookstore.users.login.Login;
import javafx.scene.layout.Background;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * Created by Elijah on 27/01/2015.
 */
public class MainGUI extends JFrame{

    public static MainGUI display;

    public static void showWindow(){

        Log.logDebug("System main window is now being displayed.");

        if(LoggedInUserData.isLoggedIn)
            display = new MainGUI();
        else
            JOptionPane.showMessageDialog(null,"You are not logged in!","Error",JOptionPane.ERROR_MESSAGE);

    }

    private MainGUI(){
        super("BookManager - " + Core.version);                 // Set the title of the frame
        this.setSize(500, 500);                                 // Size of the frame
        this.setLocationRelativeTo(null);                       // Center of screen alignment
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // Exit program when closed
        this.setResizable(false);                               // We don't want the frame to be resizable

        JPanel panel = new JPanel();                            // Create a panel to show everything on

        panel.setLayout(null);

        JLabel welcomeText = new JLabel("BookManager version " + Core.version);
        JLabel usernameText = new JLabel("You're logged in as " + LoggedInUserData.loggedInUser.getUsername());
        usernameText.setHorizontalAlignment(SwingConstants.CENTER);
        JButton viewItems = new JButton();
        JButton viewUsers = new JButton();
        JButton exitButton = new JButton();

        // Add image(s) to the button(s)
        try {
            Image items = ImageIO.read(this.getClass().getResource("/resources/Items.png"));
            viewItems.setIcon(new ImageIcon(items));
            Image management = ImageIO.read(this.getClass().getResource("/resources/UserManagement.png"));
            viewUsers.setIcon(new ImageIcon(management));
            Image exit = ImageIO.read(this.getClass().getResource("/resources/Exit.png"));
            exitButton.setIcon(new ImageIcon(exit));
        } catch (IOException ex) {
            Log.logDebug(ex);
        }
        // End adding images

        // Get rid of the borders on the button(s)
        viewItems.setBorder(null);
        viewItems.setContentAreaFilled(false);
        viewUsers.setBorder(null);
        viewUsers.setContentAreaFilled(false);
        exitButton.setBorder(null);
        exitButton.setContentAreaFilled(false);
        // End removing borders

        // Add listeners to buttons so that tasks can be preformed
        viewItems.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(display, "This function is not ready yet!", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        viewUsers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(LoggedInUserData.loggedInUser.isAdmin())
                    UserManagerGUI.showWindow();
                else
                    JOptionPane.showMessageDialog(display, "You are not allowed to access this area!", "Insufficient privileges", JOptionPane.ERROR_MESSAGE);
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(display, "Your session will now be terminated.", "Good-bye!", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        });
        // End listeners

        // Set the position of the objects that are going to be displayed
        welcomeText.setBounds(170,10,150,30);
        usernameText.setBounds(160,40,160,30);
        viewItems.setBounds(50,100,400,100);
        viewUsers.setBounds(50,210,400,100);
        exitButton.setBounds(50,320,400,100);
        // End the position setting

        // Add items to the panel
        panel.add(welcomeText);
        panel.add(usernameText);
        panel.add(viewItems);
        panel.add(viewUsers);
        panel.add(exitButton);
        // End item appending

        // Add items to the frame
        this.add(panel);                                        // Add the panel to the frame
        // End item appending

        this.setVisible(true);                                  // Show this frame
    }

}
