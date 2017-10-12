/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.ca;
import java.util.ArrayList;
/**
 *
 * @author pujitha sriramaneni
 */

public class CAGeneration {
    //creating an array of cells 
    CACell[] CellArray =new CACell[131];
    
    //Object for CARule class
    CARule caR = new CARule();

    public CACell[] getCellArray() {
        return CellArray;
    }

    public void setCellArray(CACell[] CellArray) {
        this.CellArray = CellArray;
    }
            

	public CAGeneration(int genNum) {
		// TODO Auto-generated constructor stub
        for(int y=0; y<CellArray.length; y++){           
            CellArray[y] = new CACell();
        }
	}    
    
       
}
