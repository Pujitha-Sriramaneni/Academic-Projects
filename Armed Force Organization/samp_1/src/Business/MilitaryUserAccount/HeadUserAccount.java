/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.MilitaryUserAccount;

import java.util.ArrayList;
/**
 *
 * @author Sneha
 */
public class HeadUserAccount {
    private ArrayList<String> hduser;
    private ArrayList<String> hdpass;
    public HeadUserAccount(){
        hduser = new ArrayList<>();
        hdpass = new ArrayList<>();
        hduser.add("Head");
        hdpass.add("Head");
    }
    
    public Boolean authenticateUser(String user, String pass){
        int ind1, ind2;
        Boolean u1, p1;
        
        u1 = hduser.contains(user);
        p1 = hdpass.contains(pass);
        if(u1 & p1){
            ind1 = hduser.indexOf(user);
            ind2 = hdpass.indexOf(pass);
            if(ind1 == ind2){
                return true;
            }
        }
        return false;
    }
}
