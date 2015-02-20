


import javax.swing.*;

import net.miginfocom.swing.MigLayout;
/**
 * 
 * GuiResults.java 
 * 
 * 
 * @author Ian
 * @version 1.0
 */
public class GuiResults extends JFrame {
	public static JFrame window;
	public GuiResults(){
		 window=new JFrame("Search Results");
		
        //Set default size of frame:
		
		window.setContentPane(new ResPane());
		window.setSize(1200, 500);
		window.setLayout(new MigLayout("wrap 1", "10 [] 10"));
		//window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
		//ResPane resPane1 = new ResPane();
		
		
	}
	
}