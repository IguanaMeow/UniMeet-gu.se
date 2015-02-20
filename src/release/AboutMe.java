
import java.awt.Color;
import java.awt.Component;	// imports used
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import javax.swing.text.PlainDocument;
import javax.swing.text.Utilities;

import net.miginfocom.swing.MigLayout;

/*
 * MainScreen.java
 * Purpose: Displays about me information from selected user
 *
 * @author Simeon
 * @version 1.0 
 */

public class AboutMe extends JFrame {			//	Define all the Jfields/panels/labels/frames/buttons and resultsets/statements for SQL database
	Statement st = null;
	ResultSet rs = null;
	ResultSet rs1 = null;
	Connection con = null;
	JFrame frame = new JFrame("UniMeet - About Me");
	JPanel pPanel = new JPanel();
	JPanel aaPanel = new JPanel();
	JPanel bbPanel = new JPanel();
	JPanel ccPanel = new JPanel();
	JPanel ddPanel = new JPanel();
	JPanel aPanel = new JPanel();
	JPanel bPanel = new JPanel();
	JPanel cPanel = new JPanel();
	JPanel dPanel = new JPanel();
	JPanel amPanel = new JPanel();
	JPanel buttonPanel = new JPanel();
//	void picture() {
//	BufferedImage pix = null;
//	try {
//		pix = ImageIO.read(this.getClass().getResource("" + pic));
//	} catch (IOException e) {
//		e.printStackTrace();
//	}
//	}
	JPanel fin = new JPanel();;
	JTextField fnametxt;
	JTextField tnametxt;
	JTextField agetxt;
	JTextField gentxt;
	JTextField unitxt;
	JTextField natitxt;
	JTextField majtxt;
	JTextField degtxt;
	JTextField langtxt;
	JTextField i1txt;
	JTextField i2txt;
	JTextField i3txt;
	JTextField i4txt;
	JTextField i5txt;
	JTextField i6txt;
	JTextField i7txt;
	JTextArea abtmetxt;
//	JLabel pic;
	JLabel tname = new JLabel();
	JLabel fname = new JLabel(" Name:");
	JLabel age = new JLabel(" Birthday:");
	JLabel gen = new JLabel(" Gender:");
	JLabel uni = new JLabel(" University:  ");
	JLabel nati = new JLabel(" Nationality:");
	JLabel maj = new JLabel(" Major:");
	JLabel deg = new JLabel(" Degree:");
	JLabel lang = new JLabel(" Language:");
	JLabel am = new JLabel(" About Me:");
	JLabel i1 = new JLabel (" Arts :");
	JLabel i2 = new JLabel (" Film :");
	JLabel i3 = new JLabel (" Indoor :");
	JLabel i4 = new JLabel (" Music :");
	JLabel i5 = new JLabel (" Outdoor :  ");
	JLabel i6 = new JLabel (" Sports :");
	JLabel i7 = new JLabel (" Other :");
	JLabel abtme = new JLabel(" About Me:");
	JButton ok = new JButton("Ok");
	int id1=0;
	int id2=0;

	public void opencon() throws Exception {			// Connection to remote Database
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(" Driver not working");
		}
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:8080/guproject","USER","PASS");
			//System.out.println("Connection working");

		} catch (Exception e) {
			System.out.println("Connection Error");
		}
		st = con.createStatement();
	}

	public void amscreen() throws Exception {			// Shows the GUI with all the Jtextfields/panels/labels/etc..

//		pic = new JLabel(new ImageIcon(pix));
//		pic.setSize(100, 100);
		
		//*** set layout for each panel.
		aPanel.setLayout(new MigLayout("wrap 2"));
		bPanel.setLayout(new MigLayout("wrap 2"));
		cPanel.setLayout(new MigLayout("wrap 2"));
		amPanel.setLayout(new MigLayout("wrap 2"));
		
		tnametxt = new JTextField(15);
		//** J: changed some of the fields' sizes
		fnametxt = new JTextField(20);
		agetxt = new JTextField(10);
		gentxt = new JTextField(10);
		unitxt = new JTextField(20);
		langtxt = new JTextField(20);
		natitxt = new JTextField(10);
		majtxt = new JTextField(20);
		degtxt = new JTextField(20);
		i1txt = new JTextField(20);
		i2txt = new JTextField(20);
		i3txt = new JTextField(20);
		i4txt = new JTextField(20);
		i5txt = new JTextField(20);
		i6txt = new JTextField(20);
		i7txt = new JTextField(20);
		abtmetxt = new JTextArea(10, 28);
		abtmetxt.setWrapStyleWord(true);		//	setWrapStyleWord(true)	//
		abtmetxt.setLineWrap(true);			//	setLineWrap(true)			// these 2 things limit the JTextArea
		abtmetxt.getCaret().setSelectionVisible(true);
		abtmetxt.setLineWrap(true);
		abtmetxt.setWrapStyleWord(true);

		
		
		fnametxt.setEditable(false);
		tnametxt.setEditable(false);
		agetxt.setEditable(false);
		gentxt.setEditable(false);
		unitxt.setEditable(false);
		//**
		langtxt.setEditable(false);
		natitxt.setEditable(false);
		majtxt.setEditable(false);
		degtxt.setEditable(false);
		i1txt.setEditable(false);
		i2txt.setEditable(false);
		i3txt.setEditable(false);
		i4txt.setEditable(false);
		i5txt.setEditable(false);
		i6txt.setEditable(false);
		i7txt.setEditable(false);
		abtmetxt.setEditable(false);
//		pPanel.add(pic);
		
		//***J:here I changed the arrangement of the information
		// a contains basic information
		// b contains education info
		// c contains interests
		// am contains about me
		
		pPanel.add(tname);
		aPanel.add(fname);
		aPanel.add(fnametxt);
		aPanel.add(age);
		aPanel.add(agetxt);
		aPanel.add(gen);
		aPanel.add(gentxt);
		aPanel.add(nati);
		aPanel.add(natitxt);
		//** J: Simeon did you forget to add language?
		aPanel.add(lang);
		aPanel.add(new JScrollPane(langtxt));
		
		
		bPanel.add(uni);
		bPanel.add(unitxt);		
		bPanel.add(maj);
		bPanel.add(majtxt);
		bPanel.add(deg);
		bPanel.add(degtxt);
		
		cPanel.add(i1);
		cPanel.add(i1txt);
		cPanel.add(i2);
		cPanel.add(i2txt);
		cPanel.add(i3);
		cPanel.add(i3txt);
		cPanel.add(i4);
		cPanel.add(i4txt);
		cPanel.add(i5);
		cPanel.add(i5txt);
		cPanel.add(i6);
		cPanel.add(i6txt);
		cPanel.add(i7);
		cPanel.add(i7txt);
		//***
		amPanel.add(abtme, "wrap");
		amPanel.add(new JScrollPane(abtmetxt));
		//***
		buttonPanel.add(ok);

		//***added border so to make it easy to see the section
		aPanel.setBorder(BorderFactory.createLineBorder(Color.orange));
		bPanel.setBorder(BorderFactory.createLineBorder(Color.yellow));
		cPanel.setBorder(BorderFactory.createTitledBorder("Interests"));
		amPanel.setBorder(BorderFactory.createLineBorder(Color.cyan));

		/*
		 * logoPanel
		 * 
		 */
		
		//set a logoPanel which is on the top, contains two parts of the logo
		//and two buttons: MyPage and LogOut
		JPanel logoPanel = new JPanel(new MigLayout("", "10![]0![]0![]2![]10!"));
		
		JLabel logo = new JLabel("Uni");
		JLabel logo2 = new JLabel("Meet");
		logo.setFont(new Font("Serif", Font.ITALIC, 20));
		logo.setForeground(Color.BLUE);
		logo2.setFont(new Font("TimesRoman-Bold", Font.ITALIC, 20));
		logo2.setForeground(Color.DARK_GRAY);
		
//		logoPanel.setBorder(BorderFactory.createDashedBorder(null));
		logoPanel.setBackground(Color.WHITE);
		logoPanel.add(logo, "align right");
		logoPanel.add(logo2, "push");
		
		
		//***
		//fin.setLayout(new GridLayout(7, 1));
		fin.setLayout(new MigLayout("wrap 2", "0! [20!][] 0", "0![]"));
		
		//**
		//fin.add(pPanel);
		fin.add(logoPanel, "span 2, w 430!, h 42!");
		fin.add(aPanel, "skip 1");
		fin.add(bPanel, "skip 1");
		fin.add(cPanel, "skip 1");
		fin.add(amPanel, "skip 1");
		fin.add(buttonPanel, "align 50% 50%, skip 1");
		frame.setVisible(true);
		frame.setSize(450, 600);
		frame.add(new JScrollPane(fin));		
		frame.setLocationRelativeTo(null);
		//**
		//frame.pack();
		aboutMe1(fnametxt, tnametxt);
		

		ok.addActionListener(new ActionListener() {		//	Ok button when pressed closes the AboutMe frame
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//System.exit(0);		 // 
				
				//Jessie: here if system.exit then the whole app will be shut down
				//		  so rather it should be :
				frame.dispose();
			}
		});
	}
	

	

	public void aboutMe1(JTextField fnametxt, JTextField tnametxt) throws Exception {
		opencon();
		try {
			id2=FunctionsForMainScreen.getStudentID();;
			rs = st.executeQuery("SELECT * FROM Student WHERE Student_ID="+id2);// - id of current user
			} catch (SQLException e) {
				e.printStackTrace();
			}
		while (rs.next()) {
			tnametxt.setText(rs.getString("First_Name") + " " + rs.getString("Last_Name"));// - id of current user's name into invisible textfield
		}
		
		try{
			id1=ResPane.id;
			rs=st.executeQuery("Select * FROM Student WHERE Student_ID=" + id1);// - id of user whom you want to see more info of
				}catch (SQLException e) {
					e.printStackTrace();
				}
			while(rs.next()){
				fnametxt.setText(rs.getString("First_Name") + " " + rs.getString("Last_Name"));// - queries of user's aboutme info which include general info and interests
				gentxt.setText(rs.getString("Gender"));
				agetxt.setText(rs.getDate("Birthday").toString());
				natitxt.setText(rs.getString("Nationality"));
				unitxt.setText(rs.getString("University"));
				majtxt.setText(rs.getString("Major"));
				degtxt.setText(rs.getString("Degree"));
					}
					rs=st.executeQuery("SELECT * FROM Student_Language2, Languages WHERE Student_Language2.idLanguage = Languages.idLanguage"
							+ " AND Student_Language2.idStudent = " + id1);
					while(rs.next()){
						langtxt.setText(langtxt.getText() + rs.getString("Description") + " ");
					}
					rs=st.executeQuery("SELECT * FROM Student_Arts, Arts WHERE Student_Arts.idArts = Arts.idArts AND Student_Arts.idStudent =  " + id1);
					while(rs.next()){
						i1txt.setText(i1txt.getText() + rs.getString("Description") + "    ");
					}
					rs=st.executeQuery("SELECT * FROM Student_Film, Film WHERE Student_Film.idFilm = Film.idFilm AND Student_Film.idStudent =  " + id1);
					while(rs.next()){
						i2txt.setText(i2txt.getText() + rs.getString("Description") + "    ");
					}
					rs=st.executeQuery("SELECT * FROM Student_Indoor, Indoor WHERE Student_Indoor.idIndoor = Indoor.idIndoor AND Student_Indoor.idStudent =  " + id1);
					while(rs.next()){
						i3txt.setText(i3txt.getText() + rs.getString("Description") + "    ");
					}
					rs=st.executeQuery("SELECT * FROM Student_Music, Music WHERE Student_Music.idMusic = Music.idMusic AND Student_Music.idStudent =  " + id1);
					while(rs.next()){
						i4txt.setText(i4txt.getText() + rs.getString("Description") + "    ");
					}
					rs=st.executeQuery("SELECT * FROM Student_Outdoor, Outdoor WHERE Student_Outdoor.idOutdoor = Outdoor.idOutdoor AND Student_Outdoor.idStudent =  " + id1);
					while(rs.next()){
						i5txt.setText(i5txt.getText() + rs.getString("Description") + "    ");
					}
					rs=st.executeQuery("SELECT * FROM Student_Sports, Sports WHERE Student_Sports.idSports = Sports.idSports AND Student_Sports.idStudent =  " + id1);
					while(rs.next()){
						i6txt.setText(i6txt.getText() + rs.getString("Description") + "    ");
					}
					rs=st.executeQuery("SELECT * FROM Student_Other, Other WHERE Student_Other.idOther = Other.idOther AND Student_Other.idStudent =  " + id1);
					while(rs.next()){
						i7txt.setText(i7txt.getText() + rs.getString("Description") + "    ");
					}
					rs=st.executeQuery("Select About_Me FROM Student WHERE Student_ID=  " + id1);
					while(rs.next()){
						abtmetxt.setText(rs.getString("About_Me"));
					}
			}
			
}
