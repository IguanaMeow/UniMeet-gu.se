package gu.se.project.beta;

import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
/**
 * 
 * EditProfile.java 
 * 
 * @author Elsa
 * @version 1.0
 */



public class EditProfile  implements ActionListener {
	//idStudent gets the id of student logged, it replaces other Student_ID numbers - added by Ian
	int stdID = FunctionsForMainScreen.studentID; 
	
	JFrame editFrame = new JFrame("My Profile");
	JTextField firstNameEdit = new JTextField(20);
	JTextField lastNameEdit = new JTextField(20);
	JTextField nationField = new JTextField(20);
	JPasswordField oldPassword = new JPasswordField(20);
	JPasswordField newPassword = new JPasswordField(20);
	JPasswordField repeatPassword = new JPasswordField(20);
	JEditorPane aboutMeEdit = new JEditorPane();
	JButton saveButton = new JButton("Save");
	JButton langButton = new JButton("Choose");
	Statement st = null;
	ResultSet rs = null;
	java.sql.Connection con=null;
	String universityString[] = {"","Göteborgs Universitet", "Chalmers"};
	String guDegreeString [] = {"", "Bachelor", "Master"};
	String chalmersDegreeString [] = {"", "Bachelor ", "Master "};
	String guMasterCourses[] = {"", "Barnmorskeprogrammet", "Evidensbasering: praktik, teori, kontext", "folkhälsovetenskap med hälsoekonomi", 
			"Buisness Creation and Entrepreneurship in Biomedicine", "Programmet för komletterande utbildning för läkare", 
			"Programmet för kompletterande utbildning för tandläkare", "Specialistsjuksköterskeprogrammet: anestesisjukvård", 
			"Specialistsjuksköterskeprogrammet: distriktssköterska", "Specialistsjuksköterskeprogrammet: hälso- och sjukvård för barn och ungdomar",
			"Specialistsjuksköterskeprogrammet: intensivvård", "Specialistsjuksköterskeprogrammet: kirurgisk vård", "Specialistsjuksköterskeprogrammet: medicinsk vård",
			"Specialistsjuksköterskeprogrammet: onkologisk vård", "Specialistsjuksköterskeprogrammet: operationssjukvård", "Specialistsjuksköterskeprogrammet: psykiatrisk vård",
			"Specialistsjuksköterskeprogrammet: vård av äldre", "Atmospheric Science", "Biodiversitet och systematik", "Biologi", "Complex Adaptive Systems",
			"Ecotoxicology", "Fysisk oceanografi", "Genomik och Systembiologi", "Geovetenskap", "Kemi", "Marina vetenskaper", "Matematiska vetenskaper",
			"Miljö- och hälsoskydd", "Miljövetenskap med naturvetenskaplig inriktning", "Molekylärbiologi", "Organisk kemi och läkemedelskemi", "Physics",
			"Physics of Materials and Biological Systems", "Arkeologisk praktik och teori", "Genuspraktiker", "Kulturarv och modernitet", "Kulturvård", "Religious Studies",
			"Child Culture Design", "Design", "Fri konst", "Fri konst med inriktning mot digitala medier", "Konsthantverk", "Tillämpad konst och formgivning",
			"Business & Design"};
	String guBachCourses[] = {"", "Apotekarprogrammet", "Arbetsterapeutprogrammet", "Audionomprogrammet", "Biomedicinska analytikerprogrammet",
			"Dietistprogrammet", "Folkhälsovetenskapligt program med hälsoekonomi", "Hälsopromotion", "Logopedprogrammet", "Läkarprogrammet",
			"Receptarieprogrammet/Farmaci", "Röntgensjuksköterskeprogrammet", "Sjukgymnastprogrammet", "Sjukhusfysikerprogrammet", "Sjuksköterskeprogrammet",
			"Sports Coaching", "Tandhygienistprogrammet", "Tandläkarprogrammet", "Tandteknikerprogrammet", "Biologi", "Datorstödd fysikalisk mätteknik","Fysik",
			"Geografi", "Geovetenskap", "Kemi", "Läkemedelskemi", "Marin vetenskap", "Matematikprogrammet", "Miljövetenskap med inriktning naturvetenskap",
			"Molekylärbiologi", "Bebyggelseantikvariskt program", "Konservatorsprogrammet", "Kultur", "Kultarvsstudier", "Liberal arts", 
			"Religionsvetenskapligt program", "Teologiskt program", "Bygghantverksprogrammet", "Design", "Fri konst", "Keramikkonst", "Möbeldesign med inriktning trä",
			"Smyckekonst", "Textil - Kläder - Formgivning", "Textilkonst", "Järn och stål - offentlig gestaltning", "Litterär gestaltning", 
			"Ledarskap i slöjd och kulturhantverk", "Trädgårdens och landskapsvårdens hantverk"};
	String chalmersMasterCourses[] = {"", "Chemistry", "Math"};
	String chalmersBachCourses[] = {"", "Music", "Economy"};
	String languageString [] = {"", "Albanian", "Arabic", "Awadhi", "Azerbaijani", "Bengali", "Bhojpuri", "Bosnian", "Burmese", "Chinese, Hakka",
			"Chinese, Mandarin", "Chinese, Min Nan", "Cantonese", "Danish", "Dutch", "English", "Estonian", "Faroese", "Finnish", "French", "German", 
			"Greek", "Gujarati", "Hausa", "Hindi", "Hungarian", "Icelandic", "Italian", "Javanese", "Japanese", "Kannada", "Korean", "Latvian", "Lithuanian", 
			"Maithili", "Malayalam", "Marathi", "Norwegian", "Oriya", "Panjabi", "Persian", "Polish", "Portuguese", "Romanian", "Russian", "Sami", "Serbian",
			"Serbo-Croatian", "Sindhi", "Slovak", "Spanish", "Sunda", "Swedish", "Thai", "Tamil", "Telugu", "Turkish", "Ukrainian", "Urdu", "Vietnamese",
			"Yoruba"};
	//String nationString[] = {""};
	String spokenLang;
	JComboBox universityBox = new JComboBox(universityString);
	JComboBox degreeBox = new JComboBox();
	JComboBox coursesBox = new JComboBox();
	JComboBox languageBox1 = new JComboBox(languageString);
	JComboBox languageBox2 = new JComboBox(languageString);
	JComboBox languageBox3 = new JComboBox(languageString);
	JComboBox languageBox4 = new JComboBox(languageString);
	JComboBox languageBox5 = new JComboBox(languageString);
	//JTextField nationBox = new JTextField();
	JComboBox [] comboArray;
	
	
	
	DefaultComboBoxModel emptyModel = new DefaultComboBoxModel();
	
	EditProfile() {
		JPanel namePanel = new JPanel();
		JPanel uniPanel = new JPanel();
		JPanel langPanel = new JPanel();
		JPanel nationPanel = new JPanel();
		JPanel aboutPanel = new JPanel();
		JPanel passPanel = new JPanel();
		JPanel editPanel = new JPanel();
		editPanel.setLayout(new BoxLayout(editPanel, BoxLayout.PAGE_AXIS));
			//editPanel.setLayout(new GridLayout(28,3));
			
			saveButton.addActionListener(this);
			firstNameEdit.setDocument(new LimitCharactersInput(15));
			lastNameEdit.setDocument(new LimitCharactersInput(15));
			aboutMeEdit.setDocument(new LimitCharactersInput(400));
			aboutMeEdit.setBackground(null);
			
			comboArray = new JComboBox[5];
			comboArray[0] = languageBox1;
			comboArray[1] = languageBox2;
			comboArray[2] = languageBox3;
			comboArray[3] = languageBox4;
			comboArray[4] = languageBox5;
			
			try {
				setTEdit(firstNameEdit,lastNameEdit,aboutMeEdit,nationField);
				setLanguages();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			namePanel.add(new JLabel ("First Name: ", SwingConstants.CENTER));
			namePanel.add(firstNameEdit);
			namePanel.add(new JLabel ("Last Name: ", SwingConstants.CENTER));
			namePanel.add(lastNameEdit);
			uniPanel.add(new JLabel ("University: ", SwingConstants.CENTER));
			uniPanel.add(universityBox);
			uniPanel.add(degreeBox);
			uniPanel.add(coursesBox);
			langPanel.add(new JLabel ("Language: ", SwingConstants.CENTER));
			langPanel.add(languageBox1);
			langPanel.add(languageBox2);
			langPanel.add(languageBox3);
			langPanel.add(languageBox4);
			langPanel.add(languageBox5);
			nationPanel.add(new JLabel ("Nationality:"));
			nationPanel.add(nationField);
			aboutPanel.add(new JLabel ("About me: "));
			aboutPanel.add(aboutMeEdit);
			passPanel.add(new JLabel ("Old Password: ", SwingConstants.CENTER));
			passPanel.add(oldPassword);
			passPanel.add(new JLabel ("New Password: ", SwingConstants.CENTER));
			passPanel.add(newPassword);
			passPanel.add(new JLabel ("Repeat: ", SwingConstants.CENTER));
			passPanel.add(repeatPassword);
			editPanel.add(namePanel);
			editPanel.add(uniPanel);
			editPanel.add(langPanel);
			editPanel.add(nationPanel);
			editPanel.add(aboutPanel);
			editPanel.add(passPanel);
			editPanel.add(saveButton);
			
			universityBox.addItemListener(new ItemListener(){
				public void itemStateChanged(ItemEvent ue){
					String uniStr = (String)universityBox.getSelectedItem();
					  	if(uniStr==""){
					  		degreeBox.setModel(emptyModel);
					  		coursesBox.setModel(emptyModel);
					  	}
					  	if(uniStr=="Göteborgs Universitet"){
					  		DefaultComboBoxModel model = new DefaultComboBoxModel(guDegreeString);
					  		degreeBox.setModel(model);
					  		coursesBox.setModel(emptyModel);
					  			degreeBox.addItemListener(new ItemListener(){
					  				public void itemStateChanged(ItemEvent gude){
					  					String guDegreeStr = (String)degreeBox.getSelectedItem();
					  					if(guDegreeStr == ""){
									  		coursesBox.setModel(emptyModel);
					  					}
					  					if(guDegreeStr == "Bachelor"){
					  						DefaultComboBoxModel guModel = new DefaultComboBoxModel(guBachCourses);
									  		coursesBox.setModel(guModel);
					  					}
					  					if(guDegreeStr == "Master"){
					  						DefaultComboBoxModel guModel = new DefaultComboBoxModel(guMasterCourses);
									  		coursesBox.setModel(guModel);
					  					}
					  				}		
					  		});
					  	}
					  	
					  	if(uniStr=="Chalmers"){
					  		DefaultComboBoxModel model = new DefaultComboBoxModel(chalmersDegreeString);
					  		degreeBox.setModel(model);
					  		coursesBox.setModel(emptyModel);
					  		degreeBox.addItemListener(new ItemListener(){
				  				public void itemStateChanged(ItemEvent gude){
				  					String chalmersDegreeStr = (String)degreeBox.getSelectedItem();
				  					if(chalmersDegreeStr== ""){
								  		coursesBox.setModel(emptyModel);
				  					}
				  					if(chalmersDegreeStr == "Bachelor "){
				  						DefaultComboBoxModel chalmersModel = new DefaultComboBoxModel(chalmersBachCourses);
								  		coursesBox.setModel(chalmersModel);
				  					}
				  					if(chalmersDegreeStr == "Master "){
				  						DefaultComboBoxModel chalmersModel = new DefaultComboBoxModel(chalmersMasterCourses);
								  		coursesBox.setModel(chalmersModel);
				  					}
				  				}		
				  		});
				  	}
				}
			});
			
			editFrame.add(editPanel);
			editFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			editFrame.setSize(1200,600);
			editFrame.setLocationRelativeTo(null);
			editFrame.setVisible(true);
	}
	
	public void setCombo(JComboBox a, JComboBox b, JComboBox c) throws Exception{
		opencon();
		rs=st.executeQuery("Select * FROM Student WHERE Student_ID=" + stdID);
		while(rs.next()){
			a.setSelectedItem(rs.getString("University"));
			b.setSelectedItem(rs.getString("Last_Name"));
			c.setSelectedItem(rs.getDate("Major").toString());
		}
	}
	
	public void setLanguages() throws Exception{
		opencon();
		int id=0;
		rs=st.executeQuery("SELECT * FROM Student_Language2, Languages WHERE Student_Language2.idLanguage = Languages.idLanguage AND Student_Language2.idStudent = " + stdID);
		while(rs.next()){
			comboArray[id].setSelectedItem(rs.getString("Description"));
			id++;
		}
	}
	
	public void addLanguages(){
		try {
			st.executeUpdate("DELETE FROM Student_Language2 WHERE idStudent=" + stdID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int placeID = 0; placeID<5;placeID++){
		String lang=(String)comboArray[placeID].getSelectedItem();
		String id=null;
		
		
		try {
			rs=st.executeQuery("SELECT idLanguage FROM Languages WHERE Description= '" + lang+ "'");
			while(rs.next()){
				 id=rs.getString("idLanguage");
				 //System.out.println(id);
			}
			if(!(id==null)){
			st.executeUpdate("INSERT INTO Student_Language2 VALUES (" + stdID+ ",'"+id+"')" );
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
	}
	
	public void setTEdit(JTextField a,JTextField b,JEditorPane c, JTextField d) throws Exception{
		  opencon();
		  rs=st.executeQuery("Select * FROM Student WHERE Student_ID= " + stdID);
		  while(rs.next()){
		   a.setText(rs.getString("First_Name"));
		   b.setText(rs.getString("Last_Name"));
		   c.setText(rs.getString("About_Me"));
		   d.setText(rs.getString("Nationality"));
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
	

	
    
	
	public void changePassword(){
		try {
			opencon();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
			try {
				rs=st.executeQuery("Select Password FROM Student WHERE Student_ID= " + stdID);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		String passString = newPassword.getText();
			try {
				//why if instead of while?
				if(rs.next()){
					
					if(oldPassword.getText().equals(rs.getString("Password")) && newPassword.getText().equals(repeatPassword.getText())){
					
						st.executeUpdate("UPDATE Student SET Password = '" + passString + "'WHERE Student_ID = " + stdID);
				}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void setCourse() throws Exception{
		st.executeUpdate("DELETE FROM Student_Course WHERE idStudent=" + stdID);
		
		String course=(String)coursesBox.getSelectedItem();
		String id=null;	
	
			rs=st.executeQuery("SELECT idCourse FROM Course WHERE Description= '" + course+ "'");
			while(rs.next()){
				 id=rs.getString("idCourse");
				// System.out.println(id);
			}
			if(!(id==null)){
			st.executeUpdate("INSERT INTO Student_Course VALUES (" + stdID+ ",'"+id+"')" );
			}
		
	}
	
	public void updateDatabase(){
		String fName=firstNameEdit.getText();
		String lName=lastNameEdit.getText();
		String aboutMe=aboutMeEdit.getText();
		String uniStr = (String)universityBox.getSelectedItem();
		String degreeStr = (String)degreeBox.getSelectedItem();
		String coursesStr = (String)coursesBox.getSelectedItem();
		 String nation = nationField.getText();
		if (!universityBox.getSelectedItem().equals("") && !degreeBox.getSelectedItem().equals(null) && !coursesBox.getSelectedItem().equals(null) && !coursesBox.getSelectedItem().equals("")){
			try {
				st.executeUpdate("UPDATE Student SET University = '" + uniStr + "' , Degree = '"+ degreeStr + "' , Major = '"+ coursesStr + "'WHERE Student_ID = " + stdID);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			
			st.executeUpdate("UPDATE Student SET First_Name = '" + fName + "' , Last_Name = '"+ lName + "'WHERE Student_ID = " + stdID);
			st.executeUpdate("UPDATE Student SET About_Me = '" + aboutMe + "'WHERE Student_ID = " + stdID);
			   st.executeUpdate("UPDATE Student SET Nationality = '" + nation + "'WHERE Student_ID= " + stdID );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent E) {
		
		if(E.getSource() == saveButton){
			try {
				opencon();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(!newPassword.getText().equals(repeatPassword.getText())){
				JOptionPane.showMessageDialog(null, "New passwords are not the same");
			}
			changePassword();
			addLanguages();
			updateDatabase();
			try {
				setCourse();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//old password not right or new password and repeat password no the same, error message
			editFrame.dispose();
			
			new InterestView();
			}
	
	}
}
