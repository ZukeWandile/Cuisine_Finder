/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_alpha1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeScreen extends JFrame {
    private JButton continueButton, exitButton;

    public WelcomeScreen(String username) {
        super("Welcome");

        // Set layout
        setLayout(new FlowLayout());

        // Welcome message
        JLabel welcomeLabel = new JLabel("Welcome, " + username + "!");
        add(welcomeLabel);

        // Continue button
        continueButton = new JButton("Continue to Cuisine Selection");
        add(continueButton);

        // Exit button
        exitButton = new JButton("Exit Application");
        add(exitButton);

        // Button action listeners
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open Cuisine Selection Screen
                CuisineSelectionScreen cuisineSelection = new CuisineSelectionScreen();
                cuisineSelection.setSize(300, 200);
                cuisineSelection.setVisible(true);
                dispose();  // Close the Welcome screen
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);  // Exit the application
            }
        });

        // Frame settings
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);  // Set size of the frame
        setVisible(true);  // Show the frame
    }
}