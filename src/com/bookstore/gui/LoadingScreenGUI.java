package com.bookstore.gui;

import com.bookstore.Core;
import com.bookstore.debug.Log;
import com.bookstore.users.login.Login;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by Elijah on 27/01/2015.
 */
public class LoadingScreenGUI extends JFrame{

    public static LoadingScreenGUI display;

    public static void showWindow(){

        Log.logDebug("Loading GUI now being displayed");

        display = new LoadingScreenGUI();

    }

    public static void disposeOfWindow(){
        Log.logDebug("Waiting 5 seconds before disposing Loading Screen");
        try{
            Thread.sleep(5000);
        }catch(Exception e){}
        display.dispose();
        Log.logDebug("Disposed of Loading GUI");
    }

    private LoadingScreenGUI(){
        super("BookManager - " + Core.version);                 // Set the title of the frame
        this.setSize(400, 250);                                 // Size of the frame
        this.setLocationRelativeTo(null);                       // Center of screen alignment
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // Exit program when closed
        this.setResizable(false);                               // We don't want the login screen to be resizable
        this.setAlwaysOnTop(true);
        this.setUndecorated(true);
        this.setBackground(new Color(1.0f,1.0f,1.0f,0f));

        this.setLayout(null);

        JLabel loadingScreen = new JLabel();

        // Set the position of the objects that are going to be displayed
        loadingScreen.setBounds(0, 0, 400, 250);
        // End the position setting

        // Add image(s) to the button(s)
        try {
            Image loading = ImageIO.read(this.getClass().getResource("/resources/LoadingScreen.png"));
            loadingScreen.setIcon(new ImageIcon(loading));
        } catch (IOException ex) {
            Log.logDebug(ex);
        }
        // End adding images

        // Add items to the frame
        this.add(loadingScreen);                                // Add the image to the frame
        // End item appending

        this.setVisible(true);                                  // Show this frame
    }

}
