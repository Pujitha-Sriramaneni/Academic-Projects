/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.GovUserAccount;

import java.util.ArrayList;

/**
 *
 * @author Sneha
 */
public class GovUserAccount {
    private ArrayList<String> govuser;
    private ArrayList<String> govpass;
    public GovUserAccount(){
        govuser = new ArrayList<>();
        govpass = new ArrayList<>();
        govuser.add("Government");
        govpass.add("Government");
    }
    
    public Boolean authenticateUser(String user, String pass){
        int ind1, ind2;
        Boolean u1, p1;
        
        u1 = govuser.contains(user);
        p1 = govpass.contains(pass);
        if(u1 & p1){
            ind1 = govuser.indexOf(user);
            ind2 = govpass.indexOf(pass);
            if(ind1 == ind2){
                return true;
            }
        }
        return false;
    }
}
