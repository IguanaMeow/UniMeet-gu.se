

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import net.miginfocom.swing.MigLayout;
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
	JTextField aboutMe;
	JButton[] invite=new JButton[Queries.numpanes];
	/*new added*/
	JButton viewProfile;
	public static JPanel panelPicBu;
	public static JPanel picTest;
	  public static ImageIcon a;
	
	public static int id=0;
	public static int fr;
	

	public  ResPane() {
		//System.out.println(Queries.numpanes + "Hi");
	/*	resPane[5]=new JPanel();
		//setPanel1(resPane[5],matchesLabel, null, null);
*/	
		
		for(int i = 0; i<Queries.numpanes; i++){
			
			//
			
			setLayout(new MigLayout("wrap 1", "5! [] 5!"));
//			setBorder(BorderFactory.createDashedBorder(Color.RED
//					));
			resPane[i]=new JPanel();
			//resPane[i].setLayout(new BoxLayout(resPane[i], BoxLayout.Y_AXIS));
			resPane[i].setLayout(new MigLayout("wrap 2", "[]7![]", "[]15![]5![]5![]"));
//			resPane[i].setBorder(BorderFactory.createDashedBorder(Color.ORANGE
//					));
			add(resPane[i], "w 300!");
			
		/* row 1: name and picture-part1
		 * row 2: age and picture-part2
		 * row 3: gender and viewProfile button
		 * row 4: nationality and sendInvite button
		 * 
		 * note: picture, viewProfile button and sendInvite button are in one panel:panelPicBu
		 */
			
		setPanel1(resPane[i],nameLabel,name,Queries.name[i]);			
		setPanel2(resPane[i],ageLabel,age,Queries.age[i]);	
		setPanel3(resPane[i],nationalityLabel,nationality,Queries.nationality[i]);
		setPanel4(resPane[i],universityLabel,university,Queries.gender[i]);
		invite[i]=new JButton("Send Invite");
		setPanel6(resPane[i],invite[i]);
		
		JLabel b = new JLabel(a);
		panelPicBu = new JPanel(new MigLayout("gapy 0!", "0![] 0", "0![] 0!" ));
//		panelPicBu.setBorder(BorderFactory.createDashedBorder(Color.blue));		
		resPane[i].add(panelPicBu, "align left, cell 1 0 1 3, w 128!, h 145!");

		//****here, Omar you can put the picture instead of this JPanel, you can also comment out 
		//****the red border later, it's only for demonstration. :)
		picTest = new JPanel();
		Image image ;
		if(Queries.imageBytes.get(i)!=null){
		image = HomePage.homepage.getToolkit().createImage(Queries.imageBytes.get(i));
		a = new ImageIcon(image);
		Image img = a.getImage();
		img = img.getScaledInstance(115, 115,Image.SCALE_SMOOTH);
		a=new ImageIcon(img);
		b.setIcon(a);
		picTest.add(b);
		}
		panelPicBu.add(picTest, "cell 0 0 1 2, w 125!, h 120!");
		//picTest.setBorder(BorderFactory.createDashedBorder(Color.red));
		
		
		viewProfile = new JButton("View Profile");
		viewProfile.setActionCommand(String.valueOf(Queries.idinvite[i]));
		viewProfile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				id=Integer.valueOf(e.getActionCommand());
				AboutMe a =new AboutMe();
				try {
					a.amscreen();
				//	System.out.println("hi");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		panelPicBu.add(viewProfile, "align 50% 50%, cell 0 2 1 1");
		
		
		//setPanel7(resPane[i],picture);
//		setPanel5(resPane[1],aboutMeLabel,aboutMe, Queries.aboutMe[0]);
		
		invite[i].setActionCommand(String.valueOf(Queries.idinvite[i]));

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
	
	Border grayline = BorderFactory.createDashedBorder(Color.LIGHT_GRAY);
	
	public void setPanel1(JPanel panel,JLabel label, JTextField field,String s){
		//name1
		//label=new JLabel("Name");
		field=new JTextField(20);
		//label.setLayout(null);
		field.setFont(new Font("Helvetica", Font.ITALIC, 15));
		field.setText("  " + s);
		field.setEditable(false);
		field.setBackground(null);
		field.setForeground(Color.DARK_GRAY);
		//panel.add(label);
		
		panel.add(field, "h 30!, w 165!");
		field.setBorder(BorderFactory.createLineBorder(Color.GRAY));	
		add(panel);	
	}
	
	public void setPanel2(JPanel panel,JLabel label, JTextField field,String s){
		//name1
		//label=new JLabel("Birthday");
		field=new JTextField(7);
		//label.setLayout(null);
		field.setText(" "+ s);
		field.setBorder(BorderFactory.createTitledBorder(
				grayline, "Birthday"));
		field.setEditable(false);
		//panel.add(label);
		panel.add(field, "h 40!, w 165!, cell 0 1");
		add(panel);
	}

	public void setPanel3(JPanel panel,JLabel label, JTextField field,String s){
		//name1
		//label=new JLabel("Nationality");
		field=new JTextField(10);
		//label.setLayout(null);
		field.setText(" "+ s);
		field.setBorder(BorderFactory.createTitledBorder(
				grayline, "Nationality"));
		field.setEditable(false);
		//panel.add(label);
		panel.add(field, "h 40!, w 165!, cell 0 3");
		add(panel);
	}
	public void setPanel4(JPanel panel,JLabel label, JTextField field,String s){
		//name1
		label=new JLabel("Gender");
		field=new JTextField(7);
		label.setLayout(null);
		field.setText(" "+ s);
		field.setBorder(BorderFactory.createTitledBorder(
				grayline, "Gender"));
		field.setEditable(false);
		//panel.add(label);
		panel.add(field, "h 40!, w 165!, cell 0 2");
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
	
	public void setPanel5(JPanel panel,JLabel label, JTextField field,String s){
		//name1
		label=new JLabel("About Me");
		field=new JTextField(250);
		label.setLayout(null);
		field.setText(s);
		field.setEditable(false);
		panel.add(label);
		panel.add(field);
		add(panel);
	}
	
	public void setPanel6(JPanel panel,JButton invite){
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
		panel.add(invite, "align 50% 50%, cell 1 3");
		add(panel);
	}
}


