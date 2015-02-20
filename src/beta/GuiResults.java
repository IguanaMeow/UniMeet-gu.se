package gu.se.project.beta;


import javax.swing.*;
/**
 * 
 * GuiResults.java 
 * 
 * 
 * @author Ian
 * @version 1.0
 */
public class GuiResults extends JFrame {

	public GuiResults(){
		JFrame window=new JFrame("Search Results");
		
        //Set default size of frame:
		window.setContentPane(new ResPane());
		window.setSize(1200, 500);
		pack();
		//window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
		//ResPane resPane1 = new ResPane();
		
		
	}
	
}