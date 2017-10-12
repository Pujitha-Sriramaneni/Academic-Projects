/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.ca;

/**
 *
 * @author pujitha sriramaneni
 */
import java.util.ArrayList;

public class CAGenerationSet {
    //Dynamic array list for CAGeneration arrays as the number of generations is not specfic
    private ArrayList<CAGeneration> caGenList= new ArrayList();
    CAGeneration caG = null;//new CAGeneration();
    CAGeneration cagTemp= new CAGeneration(getGenNum());
    int genNum;
    private int j;
    public int getGenNum() {
		return genNum;
	}

	public void setGenNum(int genNum) {
		this.genNum = genNum;
	}

	public ArrayList<CAGeneration> getcaGenList() {
        return caGenList;
    }

    public void setGenList(ArrayList<CAGeneration> caGenList) {
        this.caGenList = caGenList;
    }

    public CAGeneration getCaG() {
        return caG;
    }

    public void setCaG1(CAGeneration caG1) {
        this.caG = caG;
    }
    public void iniStart()
   {
        int j=0;
       caGenList.add(cagTemp);
       for(int i=0; i<caGenList.get(0).CellArray.length; i++){
                    if(i==(caGenList.get(0).CellArray.length/2))
                    //setting the centre value of 1st row to 1
                    caGenList.get(0).CellArray[(caGenList.get(0).CellArray.length/2)].setX(1);
       }
       j++;
   }
   
   public void createGenerations(int ruleNum,int genNum)
   {
       CAGeneration caG_temp1= new CAGeneration(getGenNum());
       
       caGenList.add(caG_temp1);
       for(int k=0;k<caGenList.get(j).CellArray.length;k++){
                    if(k==0 || k==caGenList.get(j).CellArray.length-1){
                        //if the iteration reaches the last line then set the first and last cell to 1
                        if(j==(caG.CellArray.length)/2)
                        {
                        caGenList.get(j).CellArray[k].setX(1);
                        //System.out.print(1);  
                        }
                        else{
                        //Set first cell and last cell to 0 for other iterations
                        caGenList.get(j).CellArray[k].setX(0);
                        //System.out.print(0); 
                        }
                    }
                    else {
                        //calling CARule's function multiple times to calculate current generation based on the previous one
                        int s= caGenList.get(j).caR.calculateRule(
                            caGenList.get(j-1).CellArray[k-1].getX(), 
                            caGenList.get(j-1).CellArray[k].getX(), 
                            caGenList.get(j-1).CellArray[k+1].getX(),ruleNum);
                        caGenList.get(j).CellArray[k].setX(s);
                        //System.out.print(s);
                    }                    
                }
       
                j++;
                //return j;
                                // System.out.println();
   }
    public void run(int rule_num,int genNum){
    	caG=new CAGeneration(getGenNum());
        for(int j=0;j<=(caG.CellArray.length);j++)
        {
            CAGeneration caG_temp = new CAGeneration(getGenNum());
            caGenList.add(caG_temp);    
            
            if(j==0)
            {
                for(int i=0; i<caGenList.get(0).CellArray.length; i++){
                    if(i==(caGenList.get(0).CellArray.length/2))
                    //setting the centre value of 1st row to 1
                    caGenList.get(0).CellArray[(caGenList.get(0).CellArray.length/2)].setX(1);
                    //int n= GenList.get(0).CellArr[i].getA();
                    //System.out.print(n);
                }
            //System.out.println();
            }
            else
            {
                for(int k=0;k<caGenList.get(j).CellArray.length;k++){
                    if(k==0 || k==caGenList.get(j).CellArray.length-1){
                         //set the first and last cell to 1 for the last iteration
                        if(j==(caG.CellArray.length)/2)
                        {
                        caGenList.get(j).CellArray[k].setX(1);
                         
                        }
                        else{
                        //set first and last cell to 0 for rest of the iterations
                        caGenList.get(j).CellArray[k].setX(0);
                        //System.out.print(0); 
                        }
                    }
                    else {
                     //calling CARule function to calculate current generation based on previous one
                        int s= caGenList.get(j).caR.calculateRule(
                            caGenList.get(j-1).CellArray[k-1].getX(), 
                            caGenList.get(j-1).CellArray[k].getX(), 
                            caGenList.get(j-1).CellArray[k+1].getX(),rule_num);
                        caGenList.get(j).CellArray[k].setX(s);
                        //System.out.print(s);
                    }                    
                }
                // System.out.println();
            }
        } 
    }   
    
   public void run(int ruleNum){
        for(int j=0;j<=(caG.CellArray.length)/2;j++)
        {
            CAGeneration cagTemp = new CAGeneration(getGenNum());
            caGenList.add(cagTemp);    
            
            if(j==0)
            {
                for(int i=0; i<caGenList.get(0).CellArray.length; i++){
                    if(i==(caGenList.get(0).CellArray.length/2))
                    //setting the centre value of 1st row to 1
                    caGenList.get(0).CellArray[(caGenList.get(0).CellArray.length/2)].setX(1);
                    //int n= GenList.get(0).CellArr[i].getA();
                    //System.out.print(n);
                }
            //System.out.println();
            }
            else
            {
                for(int k=0;k<caGenList.get(j).CellArray.length;k++){
                    if(k==0 || k==caGenList.get(j).CellArray.length-1){
                        //if the iteration reaches the last line then set the first and last cell to 1
                        if(j==(caG.CellArray.length)/2)
                        {
                        caGenList.get(j).CellArray[k].setX(1);
                        //System.out.print(1);  
                        }
                        else{
                        //Set first cell and last cell to 0 for other iterations
                        caGenList.get(j).CellArray[k].setX(0);
                        //System.out.print(0); 
                        }
                    }
                    else {
                        //calling CARule's function multiple times to calculate current generation based on the previous one
                        int s= caGenList.get(j).caR.calculateRule(
                            caGenList.get(j-1).CellArray[k-1].getX(), 
                            caGenList.get(j-1).CellArray[k].getX(), 
                            caGenList.get(j-1).CellArray[k+1].getX(),ruleNum);
                        caGenList.get(j).CellArray[k].setX(s);
                       
                    }                    
                }
                    }
        } 
    }   
}
     




