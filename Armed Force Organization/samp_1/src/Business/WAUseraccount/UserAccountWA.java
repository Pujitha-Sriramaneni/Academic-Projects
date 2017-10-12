/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WAUseraccount;

import java.util.ArrayList;
/**
 *
 * @author Sneha
 */
public class UserAccountWA {
    private ArrayList<String> wauser;
    private ArrayList<String> wapass;
    public UserAccountWA(){
        wauser = new ArrayList<>();
        wapass = new ArrayList<>();
        wauser.add("SnehaK");
        wapass.add("Potato");
    }
    
    public Boolean authenticateUser(String user, String pass){
        int ind1, ind2;
        Boolean u1, p1;
        
        u1 = wauser.contains(user);
        p1 = wapass.contains(pass);
        if(u1 & p1){
            ind1 = wauser.indexOf(user);
            ind2 = wapass.indexOf(pass);
            if(ind1 == ind2){
                return true;
            }
        }
        return false;
    }
}
