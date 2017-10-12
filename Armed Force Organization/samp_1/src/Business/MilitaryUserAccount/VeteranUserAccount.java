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
public class VeteranUserAccount {
    private ArrayList<String> vetuser;
    private ArrayList<String> vetpass;
    public VeteranUserAccount(){
        vetuser = new ArrayList<>();
        vetpass = new ArrayList<>();
        vetuser.add("SnehaK");
        vetpass.add("Onion");
    }
    
    public Boolean authenticateUser(String user, String pass){
        int ind1, ind2;
        Boolean u1, p1;
        
        u1 = vetuser.contains(user);
        p1 = vetpass.contains(pass);
        if(u1 & p1){
            ind1 = vetuser.indexOf(user);
            ind2 = vetpass.indexOf(pass);
            if(ind1 == ind2){
                return true;
            }
        }
        return false;
    } 
}
