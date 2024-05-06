/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poepart1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Khaya Guzu [ST10404851]
 */
public class Login {
    private String username;
    private boolean isLogedIn;
    private String password;
    private String firstName;
    private String lastName;
    
    //Defualt Constructor
    public Login(){
        this.username = "";
        this.isLogedIn = false;
        this.password = "";
        this.firstName = "";
        this.lastName = "";
    }
    
    public boolean getLoginStatus(){
        if(this.isLogedIn == true){
            return true;
        }else if( this.isLogedIn == false){
            return false;
        }
      return false;
    }
    public void setLoginStatus(boolean status){
        this.isLogedIn = status;
    }
    
    public boolean checkUserName(){
        if(this.username.contains("_") && this.username.length() <=5){
            return true;
        }
        return false;
    }
    
    public void setUsername(String username){
        this.username = username;
        
    }
    
    public String getUsername(){
        return this.username;
    }
    
    public boolean checkpassword(){
        String pwd = "";
        //regex to check if password has special characters, a digit and an uppercase character
        String regexValue = "^(?=.*[a-z])(?=."
                        +"*[A-Z])(?=.*\\d)"
                       + "(?=.*[-+_!@#$%^&*., ?]).+$";
        pwd = this.password;

                Pattern p = Pattern.compile(regexValue);
        Matcher m = p.matcher(pwd);
 
        // CHeck if string maches Regex
        if (m.matches() && this.password.length() >=8)
            return true;
        else
            return false;
        
        /*if(this.password.contains("A-Z") && this.password.length() <=8){
            return true;
        }
        return false;*/
    }
    public void setpassword(String password){
        this.password = password;
    }
    
    public String getpassword(){
        return this.password;
    }
    
    public void sefirstName (String firstName){
        this.firstName = firstName;
    }
    
    public String getfirstName(){
        return this.firstName;
    }
    
    public void setlastName (String lastName){
        this.lastName = lastName;
    }
    
    public String getlastName(){
        return this.lastName;
    }

    boolean loginUser(String enteredUsername, String enteredPassword) {
       // throw new UnsupportedOperationException("Not supported yet."); 
       if(this.username.matches(enteredUsername) && this.password.matches(enteredPassword)){
           return true;
       }
       return false;
    }

    } 

