/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project_alpha1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Project_Alpha1 extends JFrame implements ActionListener {

    JLabel label1 = new JLabel("Enter UserName:");
    JLabel label2 = new JLabel("Enter Password:");
    JTextField textField = new JTextField(20);
    JPasswordField textField2 = new JPasswordField(20);  // JPasswordField for hidden password characters
    JButton button = new JButton("OKAY");

    public Project_Alpha1() {
        super("Login");

        // Set default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set layout
        setLayout(new FlowLayout());

        // Add components to the frame
        add(label1);
        add(textField);
        add(label2);
        add(textField2);
        add(button);

        // Register event listeners
        button.addActionListener(this);
        textField.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        LoginSystem check = new LoginSystem();

        String user = textField.getText();  // Get entered username
        String password = new String(textField2.getPassword());  // Get entered password

        boolean isUsernameValid = check.isValidUsername(user);
        boolean isPasswordValid = check.isValidPassword(password);

        if (isUsernameValid && isPasswordValid) {
            // Show WelcomeScreen after successful login
            WelcomeScreen welcomeScreen = new WelcomeScreen(user);
            welcomeScreen.setVisible(true);
            dispose();  // Close the login screen
        } else {
            // Show error message if login fails
            JOptionPane.showMessageDialog(this, "Invalid login. Please try again.");
        }
    }

    public static void main(String[] args) {
        Project_Alpha1 alpha = new Project_Alpha1();
        alpha.setSize(220, 160);
        alpha.setVisible(true);
    }
}