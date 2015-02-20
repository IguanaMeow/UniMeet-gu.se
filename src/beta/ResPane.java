package gu.se.project.beta;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * 
 * ResPane.java 
 * 
 * @author Ian
 * @version 1.0
 */
public class ResPane extends JPanel {
	
	JPanel[] resPane = new JPanel[Queries.numpanes];
	JPanel[] display = new JPanel[1];
	JLabel matchesLabel;
	JLabel nameLabel;
	JTextField name;
	JLabel ageLabel;
	JTextField age;
	JLabel nationalityLabel;
	JTextField nationality;
	JLabel universityLabel;
	JTextField university;
	JLabel picture;
	JLabel aboutMeLabel;
//	JTextField aboutMe;
	JButton[] invite=new JButton[Queries.numpanes];
	JButton[] aboutme=new JButton[Queries.numpanes]; /////-sv-/////
	public static int id=0;
	public static int fr;
	

	public  ResPane() {
		
	/*	resPane[5]=new JPanel();
		//setPanel1(resPane[5],matchesLabel, null, null);
*/	
		
		for(int i = 0; i<Queries.numpanes; i++){
		resPane[i]=new JPanel();
		resPane[i].setLayout(new BoxLayout(resPane[i], BoxLayout.Y_AXIS));
		
		setPanel1(resPane[i],nameLabel,name,Queries.name[i]);
		setPanel2(resPane[i],ageLabel,age,Queries.age[i]);
		setPanel3(resPane[i],nationalityLabel,nationality,Queries.nationality[i]);
		setPanel4(resPane[i],universityLabel,university,Queries.gender[i]);
		//setPanel7(resPane[i],picture);
//		setPanel5(resPane[1],aboutMeLabel,aboutMe, Queries.aboutMe[0]);
		invite[i]=new JButton("Send Invite");
		aboutme[i]=new JButton("About Me"); /////-sv-/////
		setPanel6(resPane[i],invite[i], aboutme[i]);
		invite[i].setActionCommand(String.valueOf(Queries.idinvite[i]));
		aboutme[i].setActionCommand(String.valueOf(Queries.idaboutme[i]));/////-sv-/////
	
		
		}

		/*display[0] = new JPanel();
		displayPanel(display[0],matchesLabel);
		display[0].setLayout(new BoxLayout(display[0], BoxLayout.X_AXIS));
*/
		}	
	
	
/*	public void displayPanel(JPanel panel,JLabel label){
		//name1
		label=new JLabel(Queries.matches);
		System.out.println(Queries.matches);
		panel.add(label);
		add(panel);
	}*/
	
	public void setPanel1(JPanel panel,JLabel label, JTextField field,String s){
		//name1
		label=new JLabel("Name");
		field=new JTextField(10);
		label.setLayout(null);
		field.setText(s);
		field.setEditable(false);
		panel.add(label);
		panel.add(field);
		
		add(panel);	
	}
	
	public void setPanel2(JPanel panel,JLabel label, JTextField field,String s){
		//name1
		label=new JLabel("Birthday");
		field=new JTextField(7);
		label.setLayout(null);
		field.setText(s);
		field.setEditable(false);
		panel.add(label);
		panel.add(field);
		add(panel);
	}

	public void setPanel3(JPanel panel,JLabel label, JTextField field,String s){
		//name1
		label=new JLabel("Nationality");
		field=new JTextField(10);
		label.setLayout(null);
		field.setText(s);
		field.setEditable(false);
		panel.add(label);
		panel.add(field);
		add(panel);
	}
	public void setPanel4(JPanel panel,JLabel label, JTextField field,String s){
		//name1
		label=new JLabel("Gender");
		field=new JTextField(7);
		label.setLayout(null);
		field.setText(s);
		field.setEditable(false);
		panel.add(label);
		panel.add(field);
		add(panel);
	}
	
//	public void setPanel7(JPanel panel, JLabel picture){
//		BufferedImage myPicture = null;
//		try {
//			myPicture = ImageIO.read(this.getClass().getResource("Ian.png"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		picture = new JLabel(new ImageIcon(myPicture));
//	//picture.setSize(100, 100);
//		panel.add(picture);
//		add(panel);
//		
//	//	picture.setLayout(null);
//	//	panel.add(picture);
//	//	add(panel);
//		panel.setOpaque(true);
//		
//	}
	
//	public void setPanel5(JPanel panel,JLabel label, JTextField field,String s){
//		//name1
//		label=new JLabel("About Me");
//		field=new JTextField(250);
//		label.setLayout(null);
//		field.setText(s);
//		field.setEditable(false);
//		panel.add(label);
//		panel.add(field);
//		add(panel);
//	}
	
	public void setPanel6(JPanel panel,JButton invite, JButton aboutme){ /////-sv-/////
		//name1
		
		invite.setLayout(null);
		invite.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				id=Integer.valueOf(e.getActionCommand());
				sendInvite a = new sendInvite();
				try {
					a.siscreen();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
			aboutme.setLayout(null);/////-sv-/////
			aboutme.addActionListener(new ActionListener() {/////-sv-/////
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					id=Integer.valueOf(e.getActionCommand());
					AboutMe a = new AboutMe();
					try {
						a.amscreen();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			panel.add(invite);
			panel.add(aboutme);/////-sv-/////
		add(panel);
	}
	


	
	}

