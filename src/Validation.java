/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

/**
 *
 * @author tawraat
 */
public class Validation {
    
    public boolean validFields(String name, String email, String gender, String dob, String password){
        if(name.isEmpty() || email.isEmpty() || gender.isEmpty() || dob.isEmpty() || password.isEmpty())
            return false;
        else
            return true;
    }
    
    public boolean validEmail(String email){
        int pos1 = -1;
        int pos2 = -1;
        
        for(int i = 0; i < email.length(); i++){
            if(email.charAt(i) == '@')
                pos1 = i;
            if(email.charAt(i) == '.')
                pos2 = i;
        }
        
        if(pos2 <= pos1 || pos1 == 0 || pos2 - pos1 <= 1 || pos2 == email.length()-1  || pos1 == -1 || pos2 == -1)
            return false;
        else
            return true;
    }
    
    public boolean isValidPassword(String password1, String password2){
        if(password1.equals(password2) && password1 != null && password1.length() >= 6)
            return true;
        else
            return false;
    }
    
    public String purifyString(String st){
        String purified = new String();
        
        for(int i = 0; i < st.length(); i++){
            if(st.charAt(i) != '.' && st.charAt(i) != '@')
                purified += st.charAt(i);
        }
        return purified;
    }
    
    public boolean isNumberOnly(String st){
        for(int i = 0; i < st.length(); i++)
            if(st.charAt(i) < 48 || st.charAt(i) > 57)
                return false;
       
        return true;
    }
}
