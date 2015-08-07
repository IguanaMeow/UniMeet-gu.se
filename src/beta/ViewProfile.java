package gu.se.project.beta;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
/**
 * 
 * ViewProfile.java 
 * Purpose: View student profile page .
 * 
 * @author Elsa
 * @version 1.0
 */
public class ViewProfile implements ActionListener  {
	static int stdID=FunctionsForMainScreen.studentID;
	Statement st = null;
	ResultSet rs = null;
	java.sql.Connection con=null;
	//JTextField firstName = new JTextField(10);
	JLabel firstName = new JLabel();
	JLabel genderField = new JLabel();
	JLabel birthField = new JLabel();
	JLabel uniField = new JLabel();
	JLabel interestField1 = new JLabel();
	JLabel interestField2 = new JLabel();
	JLabel interestField3 = new JLabel();
	JLabel interestField4 = new JLabel();
	JLabel interestField5 = new JLabel();
	JLabel interestField6 = new JLabel();
	JLabel interestField7 = new JLabel();
	JLabel languageField = new JLabel();
	JLabel nationField = new JLabel();
	JTextArea aboutMeField = new JTextArea(20,10);
	JButton editButton = new JButton("Edit");
	//JButton searchButton = new JButton("Search");
	JFrame profilePage = new JFrame("MyProfile");
	
	
	ViewProfile() {
		JPanel namesPanel = new JPanel();
		JPanel genBirPanel = new JPanel();
		JPanel nationPanel = new JPanel();
		JPanel uniPanel = new JPanel();
		JPanel langPanel = new JPanel();
		JPanel intPanel = new JPanel();
		JPanel profilePanel = new JPanel();
		JPanel artPanel = new JPanel();
		JPanel filmPanel = new JPanel();
		JPanel inPanel = new JPanel();
		JPanel musPanel = new JPanel();
		JPanel outPanel = new JPanel();
		JPanel sprtPanel = new JPanel();
		JPanel otrPanel = new JPanel();
		JPanel aboutPanel = new JPanel();
		profilePanel.setLayout(new BoxLayout(profilePanel, BoxLayout.PAGE_AXIS));
		
		
		try {
			setT(firstName,birthField,uniField,genderField,languageField,aboutMeField,interestField1,interestField2,interestField3,interestField4,interestField5,interestField6,interestField7,nationField);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	
		aboutMeField.setEditable(false);
		//languageField.setBorder(null);
		aboutMeField.setBackground(null);
		
		editButton.addActionListener(this);
		JLabel fnLabel = new JLabel("First Name :");
		namesPanel.add(fnLabel);
		namesPanel.add(firstName);
		
		
		genBirPanel.add(new JLabel (" Gender: "));
		genBirPanel.add(genderField);
		genBirPanel.add(new JLabel (" Date of birth: "));
		genBirPanel.add(birthField);
		nationPanel.add(new JLabel (" Nationality: "));
		nationPanel.add(nationField);
		uniPanel.add(new JLabel (" University :"));
		uniPanel.add(uniField);
		langPanel.add(new JLabel (" Languages :"));
		langPanel.add(languageField);
		intPanel.add(new JLabel (" Interests"));
		artPanel.add(new JLabel (" Arts :"));
		artPanel.add(interestField1);
		filmPanel.add(new JLabel (" Film :"));
		filmPanel.add(interestField2);
		inPanel.add(new JLabel (" Indoor :"));
		inPanel.add(interestField3);
		musPanel.add(new JLabel (" Music :"));
		musPanel.add(interestField4);
		outPanel.add(new JLabel (" Outdoor :"));
		outPanel.add(interestField5);
		sprtPanel.add(new JLabel (" Sports :"));
		sprtPanel.add(interestField6);
		otrPanel.add(new JLabel (" Other :"));
		otrPanel.add(interestField7);
		aboutPanel.add(new JLabel (" About me: "));
		aboutPanel.add(aboutMeField);
		profilePanel.add(namesPanel);
		profilePanel.add(genBirPanel);
		profilePanel.add(nationPanel);
		profilePanel.add(uniPanel);
		profilePanel.add(langPanel);
		profilePanel.add(intPanel);
		profilePanel.add(artPanel);
		profilePanel.add(filmPanel);
		profilePanel.add(inPanel);
		profilePanel.add(musPanel);
		profilePanel.add(outPanel);
		profilePanel.add(sprtPanel);
		profilePanel.add(otrPanel);
		profilePanel.add(aboutPanel);
		
		profilePanel.add(editButton);
		
		
		profilePage.add(profilePanel);
	//	profilePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		profilePage.setSize(1200,600);
		profilePage.setLocationRelativeTo(null);
		profilePage.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent E) {
		if(E.getSource() == editButton){
			profilePage.dispose();
			new EditProfile();
		}
//		if(E.getSource() == searchButton){
//			profilePage.dispose();
//		}
	}
	
	public void setT(JLabel a, JLabel b,JLabel c,JLabel d,JLabel e, JTextArea f, JLabel g, JLabel h, JLabel i, JLabel j, JLabel k, JLabel l, JLabel m, JLabel n) throws Exception{
		opencon();
		rs=st.executeQuery("Select * FROM Student WHERE Student_ID=" + stdID);
		while(rs.next()){
			a.setText(rs.getString("First_Name") + " " + rs.getString("Last_Name"));
			b.setText(rs.getDate("Birthday").toString());
			c.setText(rs.getString("University") + " - " + rs.getString("Degree") + "-" + rs.getString("Major"));
			d.setText(rs.getString("Gender"));
			n.setText(rs.getString("Nationality"));
		//	System.out.println(rs.getString("First_Name"));
			}
			rs=st.executeQuery("SELECT * FROM Student_Language2, Languages WHERE Student_Language2.idLanguage = Languages.idLanguage AND Student_Language2.idStudent = " + stdID);
			while(rs.next()){
				e.setText(e.getText() + rs.getString("Description") + " ");
			}
			rs=st.executeQuery("Select About_Me FROM Student WHERE Student_ID=  " + stdID);
			while(rs.next()){
				f.setText(rs.getString("About_Me"));
			}
			rs=st.executeQuery("SELECT * FROM Student_Arts, Arts WHERE Student_Arts.idArts = Arts.idArts AND Student_Arts.idStudent =  " + stdID);
			while(rs.next()){
				g.setText(g.getText() + rs.getString("Description") + "    ");
			}
			rs=st.executeQuery("SELECT * FROM Student_Film, Film WHERE Student_Film.idFilm = Film.idFilm AND Student_Film.idStudent =  " + stdID);
			while(rs.next()){
				h.setText(h.getText() + rs.getString("Description") + "    ");
			}
			rs=st.executeQuery("SELECT * FROM Student_Indoor, Indoor WHERE Student_Indoor.idIndoor = Indoor.idIndoor AND Student_Indoor.idStudent =  " + stdID);
			while(rs.next()){
				i.setText(i.getText() + rs.getString("Description") + "    ");
			}
			rs=st.executeQuery("SELECT * FROM Student_Music, Music WHERE Student_Music.idMusic = Music.idMusic AND Student_Music.idStudent =  " + stdID);
			while(rs.next()){
				j.setText(j.getText() + rs.getString("Description") + "    ");
			}
			rs=st.executeQuery("SELECT * FROM Student_Outdoor, Outdoor WHERE Student_Outdoor.idOutdoor = Outdoor.idOutdoor AND Student_Outdoor.idStudent =  " + stdID);
			while(rs.next()){
				k.setText(k.getText() + rs.getString("Description") + "    ");
			}
			rs=st.executeQuery("SELECT * FROM Student_Sports, Sports WHERE Student_Sports.idSports = Sports.idSports AND Student_Sports.idStudent =  " + stdID);
			while(rs.next()){
				l.setText(l.getText() + rs.getString("Description") + "    ");
			}
			rs=st.executeQuery("SELECT * FROM Student_Other, Other WHERE Student_Other.idOther = Other.idOther AND Student_Other.idStudent =  " + stdID);
			while(rs.next()){
				m.setText(m.getText() + rs.getString("Description") + "    ");
			}
	}
	
	public void opencon() throws Exception {
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
	
	
}
