/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Doctor;

import java.util.ArrayList;

/**
 *
 * @author srchaudhuri
 */
public class docaccount {
    
    private ArrayList<String> docuser;
    private ArrayList<String> docpass;
    public docaccount(){
        docuser = new ArrayList<>();
        docpass = new ArrayList<>();
        docuser.add("doctor");
        docpass.add("doctor");
    }
    
    public Boolean authenticateUser(String user, String pass){
        int ind1, ind2;
        Boolean u1, p1;
        
        u1 = docuser.contains(user);
        p1 = docpass.contains(pass);
        if(u1 & p1){
            ind1 = docuser.indexOf(user);
            ind2 = docpass.indexOf(pass);
            if(ind1 == ind2){
                return true;
            }
        }
        return false;
    }
    
}
