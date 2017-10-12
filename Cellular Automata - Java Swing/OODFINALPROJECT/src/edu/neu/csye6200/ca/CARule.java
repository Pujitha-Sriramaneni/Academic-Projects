/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.ca;

/**
 *
 * @author pujitha sriramaneni
 * NUID: 001222891
 */
public class CARule {
    private int rule;

    public int getRule() {
        return rule;
    }

    public void setRule(int rule) {
        this.rule = rule;
    }
 
    public CARule(){
        
    }
    
    //implementing rule 90
    public int calculateRule(int a, int b, int c,int rule)
    {
        if (rule==90)
        {
       if (a == 1 && b == 1 && c == 1) {
            return 0;
        } else if (a == 1 && b == 1 && c == 0) {
            return 1;
        } else if (a == 1 && b == 0 && c == 1) {
            return 0;
        } else if (a == 1 && b == 0 && c == 0) {
            return 1;
        } else if (a == 0 && b == 1 && c == 1) {
            return 1;
        } else if (a == 0 && b == 1 && c == 0) {
            return 0;
        } else if (a == 0 && b == 0 && c == 1) {
           return 1;}
        else
            return 0;
        }
        else if (rule==94)
        {
        if(a==1 && b==1 && c==1)
           return 0;
        else if(a==1 && b==1 && c==0)
           return 1;
        else if(a==1 && b==0 && c==1)
           return 0;
        else if(a==1 && b==0 && c==0)
           return 1;
        else if(a==0 && b==1 && c==1)
           return 1;
        else if(a==0 && b==1 && c==0)
           return 1;
        else if(a==0 && b==0 && c==1)
           return 1;
        else
            return 0;
        }
        else if(rule==126)
        {
        if(a==1 && b==1 && c==1)
           return 0;
        else if(a==1 && b==1 && c==0)
           return 1;
        else if(a==1 && b==0 && c==1)
           return 1;
        else if(a==1 && b==0 && c==0)
           return 1;
        else if(a==0 && b==1 && c==1)
           return 1;
        else if(a==0 && b==1 && c==0)
           return 1;
        else if(a==0 && b==0 && c==1)
           return 1;
        else
            return 0;
        }
        else if(rule==50)
        {
        if(a==1 && b==1 && c==1)
           return 0;
        else if(a==1 && b==1 && c==0)
           return 0;
        else if(a==1 && b==0 && c==1)
           return 1;
        else if(a==1 && b==0 && c==0)
           return 1;
        else if(a==0 && b==1 && c==1)
           return 0;
        else if(a==0 && b==1 && c==0)
           return 0;
        else if(a==0 && b==0 && c==1)
           return 1;
        else
            return 0;
        }
        else 
            return 0;
        
    }
}
