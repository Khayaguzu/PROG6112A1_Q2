/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poepart1;

import javax.swing.JOptionPane;

/**
 *
 * @author RC_Student_lab
 */
public class PoePart1 {

    /**
     * @param args the command line arguments
     */
    public static Login objUser = new Login();
    public static String userName;
    public static String password;
    public static String firstName;
    public static String lastName;
    public static void main(String[] args) {

        String outputStr1;
        String outputStr2;
        String outputStr3;
        String outputStr4;

        do{
            //enter usernAME DETAILS
            userName = JOptionPane.showInputDialog("Please enter your username");
            objUser.setUsername(userName);

            objUser.setLoginStatus(true);
            
            if(objUser.checkUserName()){
                outputStr1 = "User " + userName + " Username successfully captured" +  " " + objUser.getLoginStatus();
                JOptionPane.showMessageDialog(null, outputStr1, "Username", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                outputStr2 = "User " + userName + " Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters long.";
                JOptionPane.showMessageDialog(null, outputStr2, "Username", JOptionPane.INFORMATION_MESSAGE);
            }
            
        }
        while(objUser.checkUserName()==false);
            
        do{
            password = JOptionPane.showInputDialog("Please enter your password");
            objUser.setpassword(password);

            objUser.setLoginStatus(true);
       
            if (objUser.checkpassword()){
                   outputStr3 = "pass" + password + "password successfully captured" + " " +objUser.getLoginStatus();
                   JOptionPane.showMessageDialog(null, outputStr3, "password", JOptionPane.INFORMATION_MESSAGE);
              } 
            else {
                  outputStr4 = "pass" + password + "password is not correctly formated, please ensure that the password contains at least 8 Characters, a capital letter, a number and a special character.";
                  JOptionPane.showMessageDialog(null, outputStr4, "password", JOptionPane.ERROR_MESSAGE);
            }
        }
        while (objUser.checkpassword()==false);

        
        firstName = JOptionPane.showInputDialog("Please enter your firstName");

        lastName = JOptionPane.showInputDialog("Please enter your lastName");

        JOptionPane.showMessageDialog(null, "Your firstName is: " + firstName, "First Name", JOptionPane.INFORMATION_MESSAGE);

        JOptionPane.showMessageDialog(null, "Your lastName is: " + lastName, "Last Name", JOptionPane.INFORMATION_MESSAGE);
        login();
    }

   
public static void login(){
//Prompt user to enter login credentials
String enteredUsername = JOptionPane.showInputDialog("Enter your username to login");
String enteredpassword = JOptionPane.showInputDialog("Enter your password to login");

// Check if entered credentials match the ones registered ones

if (objUser.loginUser(enteredUsername, enteredpassword)) {
JOptionPane.showMessageDialog(null, "Welcome: " +  lastName + " you have successfully loged in, it is greate to see you again. " );;
} else { 
    JOptionPane.showMessageDialog(null, "Failed Login, Username or Password is incorrect, please try again");
    
}
}
}
    


       
       

       