/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_alpha1;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class LoginSystem extends Project_Alpha1 {
    public List<String> Username, Password;

    public LoginSystem() {
        Password = new ArrayList<>();
        Username = new ArrayList<>();
    }

    public void setUserName(String username) {
        Username.add(username);
    }

    public void setPassword(String password) {
        Password.add(password);  // Fixing the issue here
    }

    public List<String> getUsername() {
        return Username;
    }

    public List<String> getPassword() {
        return Password;
    }

    public boolean isValidUsername(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean isValidPassword(String password) {
        if (password.length() < 8) return false;
        boolean hasUppercase = false, hasDigit = false, hasSpecialChar = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUppercase = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else if (!Character.isLetterOrDigit(c)) hasSpecialChar = true;
        }
        return hasUppercase && hasDigit && hasSpecialChar;
    }
}