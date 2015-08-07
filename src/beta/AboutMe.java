package gu.se.project.beta;	// package declaration

import java.awt.Component;	// imports used
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
	JTextField loctxt;
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
	JLabel uni = new JLabel(" University:");
	JLabel loc = new JLabel(" Location:");
	JLabel nati = new JLabel(" Nationality:");
	JLabel maj = new JLabel(" Major:");
	JLabel deg = new JLabel(" Degree:");
	JLabel lang = new JLabel(" Language:");
	JLabel am = new JLabel(" About Me:");
	JLabel i1 = new JLabel (" Arts :");
	JLabel i2 = new JLabel (" Film :");
	JLabel i3 = new JLabel (" Indoor :");
	JLabel i4 = new JLabel (" Music :");
	JLabel i5 = new JLabel (" Outdoor :");
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
					"jdbc:mysql://127.0.0.1:3306/guproject","USER","PASS");
			//System.out.println("Connection working");

		} catch (Exception e) {
			System.out.println("Connection Error");
		}
		st = con.createStatement();
	}

	public void amscreen() throws Exception {			// Shows the GUI with all the Jtextfields/panels/labels/etc..

//		pic = new JLabel(new ImageIcon(pix));
//		pic.setSize(100, 100);
		tnametxt = new JTextField(15);
		fnametxt = new JTextField(30);
		agetxt = new JTextField(15);
		gentxt = new JTextField(8);
		unitxt = new JTextField(30);
		langtxt = new JTextField(20);
		loctxt = new JTextField(10);
		natitxt = new JTextField(20);
		majtxt = new JTextField(20);
		degtxt = new JTextField(20);
		i1txt = new JTextField(20);
		i2txt = new JTextField(20);
		i3txt = new JTextField(20);
		i4txt = new JTextField(20);
		i5txt = new JTextField(20);
		i6txt = new JTextField(20);
		i7txt = new JTextField(20);
		abtmetxt = new JTextArea(10, 20);
		abtmetxt.setWrapStyleWord(true);		//	setWrapStyleWord(true)	//
		abtmetxt.setLineWrap(true);			//	setLineWrap(true)			// these 2 things limit the JTextArea
		abtmetxt.getCaret().setSelectionVisible(true);
		abtmetxt.setLineWrap(true);
		abtmetxt.setWrapStyleWord(true);

		fnametxt.setDocument(new JTextFieldLimit(30));
		agetxt.setDocument(new JTextFieldLimit(15));
		gentxt.setDocument(new JTextFieldLimit(8));
		unitxt.setDocument(new JTextFieldLimit(30));
		loctxt.setDocument(new JTextFieldLimit(10));
		natitxt.setDocument(new JTextFieldLimit(20));
		majtxt.setDocument(new JTextFieldLimit(20));
		degtxt.setDocument(new JTextFieldLimit(20));
		i1txt.setDocument(new JTextFieldLimit(20));
		i2txt.setDocument(new JTextFieldLimit(20));
		i3txt.setDocument(new JTextFieldLimit(20));
		i4txt.setDocument(new JTextFieldLimit(20));
		i5txt.setDocument(new JTextFieldLimit(20));
		i6txt.setDocument(new JTextFieldLimit(20));
		i7txt.setDocument(new JTextFieldLimit(20));
		
		fnametxt.setEditable(false);
		tnametxt.setEditable(false);
		agetxt.setEditable(false);
		gentxt.setEditable(false);
		unitxt.setEditable(false);
		loctxt.setEditable(false);
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
		pPanel.add(tname);
		aPanel.add(fname);
		aPanel.add(fnametxt);
		aPanel.add(age);
		aPanel.add(agetxt);
		aPanel.add(gen);
		aPanel.add(gentxt);
		bPanel.add(uni);
		bPanel.add(unitxt);
		bPanel.add(loc);
		bPanel.add(loctxt);
		bPanel.add(nati);
		bPanel.add(natitxt);
		cPanel.add(maj);
		cPanel.add(majtxt);
		cPanel.add(deg);
		cPanel.add(degtxt);
		cPanel.add(i1);
		cPanel.add(i1txt);
		dPanel.add(i2);
		dPanel.add(i2txt);
		dPanel.add(i3);
		dPanel.add(i3txt);
		dPanel.add(i4);
		dPanel.add(i4txt);
		aaPanel.add(i5);
		aaPanel.add(i5txt);
		aaPanel.add(i6);
		aaPanel.add(i6txt);
		aaPanel.add(i7);
		aaPanel.add(i7txt);
		amPanel.add(abtmetxt);
		amPanel.add(new JScrollPane(abtme));
		amPanel.add(ok);

		fin.setLayout(new GridLayout(7, 1));
		fin.add(pPanel);
		fin.add(aPanel);
		fin.add(bPanel);
		fin.add(cPanel);
		fin.add(dPanel);
		fin.add(aaPanel);
		fin.add(amPanel);
		fin.add(buttonPanel);
		frame.setVisible(true);
		frame.setSize(300, 200);
		frame.add(fin);
		frame.pack();
		aboutMe1(fnametxt, tnametxt);
		

		ok.addActionListener(new ActionListener() {		//	Ok button when pressed closes the AboutMe frame
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);		 // 
			}
		});
	}
	

	class JTextFieldLimit extends PlainDocument {		//	Limits JTextFields to a given integer
		private int limit;

		JTextFieldLimit(int limit) {
			super();
			this.limit = limit;
		}

		JTextFieldLimit(int limit, boolean upper) {
			super();
			this.limit = limit;
		}

		public void insertString(int offset, String str, AttributeSet attr)
				throws BadLocationException {
			if (str == null)
				return;

			if ((getLength() + str.length()) <= limit) {
				super.insertString(offset, str, attr);
			}
		}
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
				loctxt.setText(rs.getString("Location"));
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
						i3.setText(i3txt.getText() + rs.getString("Description") + "    ");
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
