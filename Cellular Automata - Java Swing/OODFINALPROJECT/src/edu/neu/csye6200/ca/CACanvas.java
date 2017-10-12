package edu.neu.csye6200.ca;

import java.util.logging.Logger;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;

public class CACanvas extends JPanel {

	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(CACanvas.class.getName());
	private int cellSize = 15;
	private Color color = null;
	private int numG;
	private int genNum;
	private int ruleNum;
	CAGenerationSet caGnS1 =null; //

	public CACanvas(int ruleNum) {
		color = Color.WHITE;
		caGnS1=new CAGenerationSet();
		caGnS1.run(ruleNum);
	}
	public CACanvas(int ruleNum,int genNum) {
		color = Color.WHITE;
		caGnS1=new CAGenerationSet();
		caGnS1.setGenNum(genNum);
		this.genNum=genNum;
		this.ruleNum=ruleNum;
		caGnS1.run(ruleNum,genNum);
	}

	public void paint(Graphics G) { // calulateVal();
		drawCellularAutomaton(G);
	}

	/*
	 * @Override public void paint(Graphics g) { //calulateVal();
	 * drawCellularAutomaton(g); }
	 */

	public void drawCellularAutomaton(Graphics G) {

		Graphics2D G2d = (Graphics2D) G;
		Dimension size = getSize();

		G2d.setColor(Color.GRAY);
		G2d.fillRect(0, 0, size.width, size.height);

		G2d.setColor(Color.GREEN);
		G2d.drawString("Cellular Automaton Rule ::"+this.ruleNum, 10, 15);

		for (int j = 0; j < genNum; j++) {
			for (int i = 0; i < caGnS1.caG.CellArray.length; i++) {
				if (caGnS1.getcaGenList().get(j).CellArray[i].getX() == 1) {
					color = Color.YELLOW;
				} else
					color = Color.DARK_GRAY;

				paintRect(G2d, i * cellSize, j * cellSize + 20, cellSize - 1,color);
			}
			for (double k = 0; k < 1000000; k++) {

			}
		}
	}

	/*
	 * A local routine to ensure that the color value is in the 0 to 255 range;
	 */
	private int validColor(int colorVal) {
		if (colorVal > 255)
			colorVal = 255;
		if (colorVal < 0)
			colorVal = 0;
		return colorVal;
	}

	/*
	 * A convenience routine to set the color and paint a square
	 * 
	 * @param g2d the graphics context
	 * 
	 * @param x horizontal offset in pixels
	 * 
	 * @param y vertical offset in pixels
	 * 
	 * @param size the square size in pixels
	 * 
	 * @param color the color to draw
	 */
	private void paintRect(Graphics2D g2d, int x, int y, int size, Color color) {
		g2d.setColor(color);
		g2d.fillRect(x, y, size, size);
	}

	/*
	 * public void calulateVal(){ for(int
	 * j=0;j<=(cagS1.caG1.CellArr.length)/2;j++) { CAGeneration caG_temp = new
	 * CAGeneration(); cagS1.getGenList().add(caG_temp);
	 * 
	 * if(j==0) { for(int i=0; i<cagS1.getGenList().get(0).CellArr.length; i++){
	 * if(i==(cagS1.getGenList().get(0).CellArr.length/2)) //setting the centre
	 * value of 1st row to 1
	 * cagS1.getGenList().get(0).CellArr[(cagS1.getGenList(
	 * ).get(0).CellArr.length/2)].setA(1); int n=
	 * cagS1.getGenList().get(0).CellArr[i].getA(); //System.out.print(n); }
	 * //System.out.println(); } else { for(int
	 * k=0;k<cagS1.getGenList().get(j).CellArr.length;k++){ if(k==0 ||
	 * k==cagS1.getGenList().get(j).CellArr.length-1){ //if the iteration
	 * reaches the last line then set the first and last cell to 1
	 * if(j==(cagS1.caG1.CellArr.length)/2) {
	 * cagS1.getGenList().get(j).CellArr[k].setA(1);
	 * //System.out.print(cagS1.getGenList().get(j).CellArr[k].getA()); } else{
	 * //Set first cell and last cell to 0 for other iterations
	 * cagS1.getGenList().get(j).CellArr[k].setA(0);
	 * //System.out.print(cagS1.getGenList().get(j).CellArr[k].getA()); } } else
	 * { //calling CARule's function multiple times to calculate current
	 * generation based on the previous one int s=
	 * cagS1.getGenList().get(j).caR.calculateRule(
	 * cagS1.getGenList().get(j-1).CellArr[k-1].getA(),
	 * cagS1.getGenList().get(j-1).CellArr[k].getA(),
	 * cagS1.getGenList().get(j-1).CellArr[k+1].getA());
	 * cagS1.getGenList().get(j).CellArr[k].setA(s);
	 * //System.out.print(cagS1.getGenList().get(j).CellArr[k].getA()); } }
	 * //System.out.println(); } } }
	 */
}
