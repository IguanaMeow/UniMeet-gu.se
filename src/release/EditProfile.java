

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import net.miginfocom.swing.MigLayout;

public class EditProfile implements ActionListener {
	// idStudent gets the id of student logged, it replaces other Student_ID
	// numbers - added by Ian
	int stdID = FunctionsForMainScreen.studentID;;
	File image;
	JFrame editFrame = new JFrame("My Profile");
	JLetterField firstNameEdit = new JLetterField(10, 15);
	JLetterField lastNameEdit = new JLetterField(10, 15);
	ImageIcon editIcon;
	JLabel imgLabel = new JLabel(editIcon);
	JPasswordField oldPassword = new JPasswordField(20);
	JPasswordField newPassword = new JPasswordField(20);
	JPasswordField repeatPassword = new JPasswordField(20);
	JTextArea aboutMeEdit = new JTextArea(10, 25);
	JButton saveButton = new JButton("Save");
	JButton imageButton = new JButton("Choose Picture");
	PreparedStatement st = null;
	ResultSet rs = null;
	java.sql.Connection con = null;
	String sqlPassword;
	String degreeString[] = { "", "Bachelor", "Master" };
	String masterCourses[] = { "", "Barnmorskeprogrammet",
			"Evidensbasering: praktik, teori, kontext",
			"Buisness Creation and Entrepreneurship in Biomedicine",
			"Atmospheric Science", "Biodiversitet och systematik",
			"Complex Adaptive Systems", "Ecotoxicology", "Fysisk oceanografi",
			"Genomik och Systembiologi", "Marina vetenskaper",
			"Matematiska vetenskaper", "Physics",
			"Physics of Materials and Biological Systems",
			"Arkeologisk praktik och teori", "Genuspraktiker",
			"Kulturarv och modernitet", "Religious Studies",
			"Child Culture Design",
			"Fri konst med inriktning mot digitala medier", "Konsthantverk",
			"Business & Design" };
	String bachCourses[] = { "", "Apotekarprogrammet",
			"Arbetsterapeutprogrammet", "Audionomprogrammet",
			"Biomedicinska analytikerprogrammet", "Dietistprogrammet",
			"Logopedprogrammet", "Receptarieprogrammet/Farmaci",
			"Sjukgymnastprogrammet", "Sjukhusfysikerprogrammet",
			"Sports Coaching", "Tandhygienistprogrammet",
			"Tandteknikerprogrammet", "Biologi", "Fysik", "Geografi",
			"Geovetenskap", "Kemi", "Marin vetenskap", "Matematikprogrammet",
			"Bebyggelseantikvariskt program", "Konservatorsprogrammet",
			"Kultur", "Kultarvsstudier", "Liberal arts",
			"Religionsvetenskapligt program", "Teologiskt program",
			"Bygghantverksprogrammet", "Design", "Fri konst", "Keramikkonst",
			"Smyckekonst", "Textilkonst", "Software Engineering and Management" };
	String languageString[] = { "", "Albanian", "Arabic", "Awadhi",
			"Azerbaijani", "Bengali", "Bhojpuri", "Bosnian", "Burmese",
			"Chinese, Hakka", "Chinese, Mandarin", "Chinese, Min Nan",
			"Cantonese", "Danish", "Dutch", "English", "Estonian", "Faroese",
			"Finnish", "French", "German", "Greek", "Gujarati", "Hausa",
			"Hindi", "Hungarian", "Icelandic", "Italian", "Javanese",
			"Japanese", "Kannada", "Korean", "Latvian", "Lithuanian",
			"Maithili", "Malayalam", "Marathi", "Norwegian", "Oriya",
			"Panjabi", "Persian", "Polish", "Portuguese", "Romanian",
			"Russian", "Sami", "Serbian", "Serbo-Croatian", "Sindhi", "Slovak",
			"Spanish", "Sunda", "Swedish", "Thai", "Tamil", "Telugu",
			"Turkish", "Ukrainian", "Urdu", "Vietnamese", "Yoruba" };
	String nationString[] = { "", "Afghan", "Albanian", "Algerian", "American",
			"Andorran", "Angolan", "Antiguans", "Argentinean", "Armenian",
			"Australian", "Austrian", "Azerbaijani", "Bahamian", "Bahraini",
			"Bangladeshi", "Barbadian", "Barbudans", "Batswana", "Belarusian",
			"Belgian", "Belizean", "Beninese", "Bhutanese", "Bolivian",
			"Bosnian", "Brazilian", "British", "Bruneian", "Bulgarian",
			"Burkinabe", "Burmese", "Burundian", "Cambodian", "Cameroonian",
			"Canadian", "Cape Verdean", "Central African", "Chadian",
			"Chilean", "Chinese", "Colombian", "Comoran", "Congolese",
			"Costa Rican", "Croatian", "Cuban", "Cypriot", "Czech", "Danish",
			"Djibouti", "Dominican", "Dutch", "East Timorese", "Ecuadorean",
			"Egyptian", "Emirian", "Equatorial Guinean", "Eritrean",
			"Estonian", "Ethiopian", "Fijian", "Filipino", "Finnish",
			"French,Gabonese", "Gambian", "Georgian", "German", "Ghanaian",
			"Greek", "Grenadian", "Guatemalan", "Guinea-Bissauan", "Guinean",
			"Guyanese", "Haitian", "Herzegovinian", "Honduran", "Hungarian",
			"Icelander", "Indian", "Indonesian", "Iranian", "Iraqi", "Irish",
			"Israeli", "Italian", "Ivorian", "Jamaican", "Japanese",
			"Jordanian", "Kazakhstani", "Kenyan", "Kittian and Nevisian",
			"Kuwaiti", "Kyrgyz", "Laotian", "Latvian", "Lebanese", "Liberian",
			"Libyan", "Liechtensteiner", "Lithuanian", "Luxembourger",
			"Macedonian", "Malagasy", "Malawian", "Malaysian", "Maldivan",
			"Malian", "Maltese", "Marshallese", "Mauritanian", "Mauritian",
			"Mexican", "Micronesian", "Moldovan", "Monacan", "Mongolian",
			"Moroccan", "Mosotho", "Motswana", "Mozambican", "Namibian",
			"Nauruan", "Nepalese", "Netherlander", "New Zealander",
			"Ni-Vanuatu", "Nicaraguan", "Nigerian", "Nigerien", "North Korean",
			"Northern Irish", "Norwegian", "Omani", "Pakistani", "Palauan",
			"Panamanian", "Papua New Guinean", "Paraguayan", "Peruvian",
			"Polish", "Portuguese", "Qatari", "Romanian", "Russian", "Rwandan",
			"Saint Lucian", "Salvadoran", "Samoan", "San Marinese",
			"Sao Tomean", "Saudi", "Scottish", "Senegalese", "Serbian",
			"Seychellois", "Sierra Leonean", "Singaporean", "Slovakian",
			"Slovenian", "Solomon Islander", "Somali", "South African",
			"South Korean", "Spanish", "Sri Lankan", "Sudanese", "Surinamer",
			"Swazi", "Swedish", "Swiss", "Syrian", "Taiwanese", "Tajik",
			"Tanzanian", "Thai", "Togolese", "Tongan",
			"Trinidadian or Tobagonian", "Tunisian", "Turkish", "Tuvaluan",
			"Ugandan", "Ukrainian", "Uruguayan", "Uzbekistani", "Venezuelan",
			"Vietnamese", "Welsh", "Yemenite", "Zambian", "Zimbabwean" };
	JComboBox degreeBox = new JComboBox(degreeString);
	JComboBox coursesBox = new JComboBox();
	JComboBox languageBox1 = new JComboBox(languageString);
	JComboBox languageBox2 = new JComboBox(languageString);
	JComboBox languageBox3 = new JComboBox(languageString);
	JComboBox languageBox4 = new JComboBox(languageString);
	JComboBox languageBox5 = new JComboBox(languageString);
	JComboBox[] comboArray;
	JComboBox nationBox = new JComboBox(nationString);
	JFileChooser chooser;
	String choosertitle;
	FileNameExtensionFilter filter;
	ImageIcon icon;

	DefaultComboBoxModel emptyModel = new DefaultComboBoxModel();

	EditProfile() {

		JPanel namePanel = new JPanel();
		// **
		JPanel imagePanel = new JPanel();
		JPanel uniPanel = new JPanel();
		JPanel langPanel = new JPanel();
		JPanel langPanel2 = new JPanel();
		JPanel nationPanel = new JPanel();
		JPanel aboutPanel = new JPanel();
		JPanel passPanel = new JPanel();
		JPanel pass2 = new JPanel();
		JPanel pass3 = new JPanel();
		JPanel editPanel = new JPanel();
		editPanel.setLayout(new MigLayout("wrap 1, gapy 5!", "20![]", ""));
		// editPanel.setLayout(new GridLayout(28,3));

		imageButton.addActionListener(this);
		saveButton.addActionListener(this);
		aboutMeEdit.setDocument(new LimitCharactersInput(400));
		Border border = BorderFactory.createLineBorder(Color.gray);
		aboutMeEdit.setBorder(border);
		aboutMeEdit.setLineWrap(true);
		aboutMeEdit.setWrapStyleWord(true);

		comboArray = new JComboBox[5];
		comboArray[0] = languageBox1;
		comboArray[1] = languageBox2;
		comboArray[2] = languageBox3;
		comboArray[3] = languageBox4;
		comboArray[4] = languageBox5;

		try {
			setTEdit(firstNameEdit, lastNameEdit, aboutMeEdit, nationBox);
			setLanguages();
			setImage(editIcon, imgLabel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * logoPanel
		 */

		// set a logoPanel which is on the top, contains two parts of the logo
		// and two buttons: MyPage and LogOut
		JPanel logoPanel = new JPanel(new MigLayout("", "10![]0![]0![]2![]10!",
				"0![] "));

		JLabel logo = new JLabel("Uni");
		JLabel logo2 = new JLabel("Meet");
		logo.setFont(new Font("Serif", Font.ITALIC, 20));
		logo.setForeground(Color.BLUE);
		logo2.setFont(new Font("TimesRoman-Bold", Font.ITALIC, 20));
		logo2.setForeground(Color.DARK_GRAY);

		// logoPanel.setBorder(BorderFactory.createDashedBorder(null));
		logoPanel.setBackground(Color.WHITE);
		logoPanel.add(logo, "align right, aligny baseline");
		logoPanel.add(logo2, "push, aligny baseline");
		editPanel.add(logoPanel, "w 590!, h 27!, dock north");

		namePanel.add(new JLabel("First Name: ", SwingConstants.CENTER));
		namePanel.add(firstNameEdit);
		namePanel.add(new JLabel("Last Name: ", SwingConstants.CENTER));
		namePanel.add(lastNameEdit);
		imagePanel.add(imageButton);
		imagePanel.add(imgLabel);
		uniPanel.add(new JLabel("University: ", SwingConstants.CENTER));

		uniPanel.add(degreeBox);
		uniPanel.add(coursesBox);
		langPanel.add(languageBox1);
		langPanel.add(languageBox2);
		langPanel.add(languageBox3);
		langPanel2.add(languageBox4);
		langPanel2.add(languageBox5);
		nationPanel.add(new JLabel("Nationality:"));
		nationPanel.add(nationBox);
		aboutPanel.add(new JScrollPane(aboutMeEdit));
		aboutPanel.setBorder(BorderFactory.createTitledBorder("About Me"));
		JLabel changePass = new JLabel("You can change your password here");
		changePass.setForeground(Color.RED);
		passPanel.add(new JLabel("Old Password: ", SwingConstants.CENTER));
		passPanel.add(oldPassword);
		pass2.add(new JLabel("New Password: ", SwingConstants.CENTER));
		pass2.add(newPassword);
		pass3.add(new JLabel("Repeat: ", SwingConstants.CENTER));
		pass3.add(repeatPassword);
		editPanel.add(namePanel, "skip 2");
		editPanel.add(imagePanel);
		editPanel.add(uniPanel);
		editPanel.add(new JLabel(" Language/s"));
		editPanel.add(langPanel, "skip 2");
		editPanel.add(langPanel2);
		editPanel.add(nationPanel, "skip 2");
		editPanel.add(aboutPanel, "skip 2");
		editPanel.add(changePass, "skip 2");
		editPanel.add(passPanel);
		editPanel.add(pass2);
		editPanel.add(pass3);
		editPanel.add(saveButton, "skip 2");

		degreeBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ue) {
				String degreeString = (String) degreeBox.getSelectedItem();
				if (degreeString == "") {
					coursesBox.setModel(emptyModel);
				}
				if (degreeString == "Bachelor") {
					DefaultComboBoxModel model = new DefaultComboBoxModel(
							bachCourses);
					coursesBox.setModel(model);
				}
				if (degreeString == "Master") {
					DefaultComboBoxModel model = new DefaultComboBoxModel(
							masterCourses);
					coursesBox.setModel(model);
				}

			}
		});

		editFrame.add(new JScrollPane(editPanel));
		editFrame.setSize(600, 600);
		editFrame.setLocationRelativeTo(null);
		editFrame.setVisible(true);
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
			// System.out.println("Connection working");

		} catch (Exception e) {
			System.out.println("Connection Error");
		}
		// st = con.createStatement();
	}

	public void setCombo(JComboBox a, JComboBox b, JComboBox c) {
		try {
			opencon();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String query = "Select * FROM Student WHERE Student_ID=" + stdID;
		try {
			st = con.prepareStatement(query);
			rs = st.executeQuery();
			while (rs.next()) {
				a.setSelectedItem(rs.getString("University"));
				b.setSelectedItem(rs.getString("Last_Name"));
				c.setSelectedItem(rs.getDate("Major").toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {

				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (Exception excp) {

				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception excp) {

				}
			}
		}

	}

	public void getPassword() throws Exception {
		opencon();
		String query = "Select Password FROM Student WHERE Student_ID= "
				+ stdID;
		st = con.prepareStatement(query);
		rs = st.executeQuery();
		if (rs.next()) {
	//		System.out.println("In get Password");
			sqlPassword = rs.getString("Password");
			// System.out.println(sqlPassword);
		}

	}

	public void setLanguages() throws Exception {
		opencon();
		int id = 0;
		String query = "SELECT * FROM Student_Language2, Languages WHERE Student_Language2.idLanguage = Languages.idLanguage AND Student_Language2.idStudent = "
				+ stdID;
		st = con.prepareStatement(query);
		rs = st.executeQuery();
		while (rs.next()) {
			comboArray[id].setSelectedItem(rs.getString("Description"));
			id++;
		}

	}

	public void addLanguages() {
		try {
			opencon();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			String query = "DELETE FROM Student_Language2 WHERE idStudent="
					+ stdID;
			st = con.prepareStatement(query);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int placeID = 0; placeID < 5; placeID++) {
			String lang = (String) comboArray[placeID].getSelectedItem();
			String id = null;

			try {
				try {
					opencon();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String query1 = "SELECT idLanguage FROM Languages WHERE Description= '"
						+ lang + "'";
				st = con.prepareStatement(query1);
				rs = st.executeQuery();
				while (rs.next()) {
					id = rs.getString("idLanguage");
					// System.out.println(id);
				}
				if (!(id == null)) {
					String query2 = "INSERT INTO Student_Language2 VALUES ("
							+ stdID + ",'" + id + "')";
					st = con.prepareStatement(query2);
					st.executeUpdate();
				}
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "Duplicate languages choosen");
				
			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {

					}
				}
				if (st != null) {
					try {
						st.close();
					} catch (Exception excp) {

					}
				}
				if (con != null) {
					try {
						con.close();
					} catch (Exception excp) {

					}
				}
			}
		}
	}

	public void setTEdit(JTextField a, JTextField b, JTextArea c, JComboBox d) {
		try {
			opencon();
		} catch (Exception E) {
			// TODO Auto-generated catch block
			E.printStackTrace();
		}
		String query = "Select * FROM Student WHERE Student_ID= " + stdID;
		try {
			st = con.prepareStatement(query);
		} catch (SQLException E) {
			// TODO Auto-generated catch block
			E.printStackTrace();
		}
		try {
			rs = st.executeQuery();
			while (rs.next()) {
				a.setText(rs.getString("First_Name"));
				b.setText(rs.getString("Last_Name"));
				c.setText(rs.getString("About_Me"));
				d.setSelectedItem(rs.getString("Nationality"));

			}
		} catch (SQLException E) {
			// TODO Auto-generated catch block
			E.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {

				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (Exception excp) {

				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception excp) {

				}
			}
		}

	}

	public void setImage(ImageIcon a, JLabel b) throws Exception {
		opencon();
		byte[] imageBytes;
		Image image;
		// st = con.createStatement();
		PreparedStatement ps = null;
		String sql = "Select Picture FROM Student WHERE Student_ID=" + stdID;
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		if (rs.next()) {

			imageBytes = rs.getBytes("Picture");
			if (imageBytes != null) {
				image = editFrame.getToolkit().createImage(imageBytes);
				a = new ImageIcon(image);
				Image img = a.getImage();
				img = img.getScaledInstance(115, 115, Image.SCALE_SMOOTH);
				a = new ImageIcon(img);
				b.setIcon(a);
			}
		}
	}

	public void changePassword() {
		try {
			opencon();
			//getPassword();
			//opencon();
			String query = "Select Password FROM Student WHERE Student_ID= "
					+ stdID;
			// System.out.println(sqlPassword + "In Change Password");
			st = con.prepareStatement(query);
			rs = st.executeQuery();
			String passString = String.valueOf(newPassword.getPassword());
			if (rs.next()) {
				//System.out.println("In resultSet of changePassword");
				// System.out.println(sqlPassword);
				if ((samePass(oldPassword.getText(), sqlPassword)
						&& samePass(newPassword.getText(),
								repeatPassword.getText()))&&(!newPassword.getText().isEmpty()&&!repeatPassword.getText().isEmpty())) {
					String query2 = "UPDATE Student SET Password = ? WHERE Student_ID = "
							+ stdID;
					st = con.prepareStatement(query2);
					st.setString(1, passString);
					st.executeUpdate();
				//	System.out.println(oldPassword.getText());
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {

				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (Exception excp) {

				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception excp) {

				}
			}
		}

	}

	public void setCourse() {
		try {
			opencon();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String query = "DELETE FROM Student_Course WHERE idStudent=" + stdID;
		try {
			st = con.prepareStatement(query);
			st.executeUpdate();
			String course = (String) coursesBox.getSelectedItem();
			String degree = (String) degreeBox.getSelectedItem();
			String id = null;
			rs = st.executeQuery("SELECT idCourse FROM Course WHERE Description= '"
					+ course + "'");
			while (rs.next()) {
				// System.out.println(rs.getString("idCourse"));
				id = rs.getString("idCourse");
			}
			if (!(id == null)) {
				st.executeUpdate("INSERT INTO Student_Course VALUES (" + stdID
						+ ",'" + id + "')");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {

				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (Exception excp) {

				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception excp) {

				}
			}
		}

	}

	public boolean samePass(String pass1, String pass2) {
		if (pass1.equals(pass2)) {
			return true;
		} else {
			return false;
		}
	}

	public void insertImage() throws Exception {
		opencon();
		PreparedStatement statement = null;
		FileInputStream inputStream = null;

		try {
			// System.out.println(image);

			if (image != null) {
				inputStream = new FileInputStream(image);
				statement = con
						.prepareStatement("UPDATE Student SET Picture =? WHERE Student_ID ="
								+ stdID);
				statement.setBinaryStream(1, (FileInputStream) inputStream,
						(int) (image.length()));
				statement.executeUpdate();
			}
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException: - " + e);
		} catch (SQLException e) {
			System.out.println("SQLException: - " + e);
		} finally {

			if (statement != null) {
				try {
					statement.close();
				} catch (Exception excp) {

				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception excp) {

				}
			}
		}

	}

	public void updateDatabase() {
		try {
			opencon();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String fName = firstNameEdit.getText();
		String lName = lastNameEdit.getText();
		String aboutMe = aboutMeEdit.getText();
		String degreeStr = (String) degreeBox.getSelectedItem();
		String coursesStr = (String) coursesBox.getSelectedItem();
		String nation = (String) nationBox.getSelectedItem();
		if (!degreeBox.getSelectedItem().equals("")
				&& !coursesBox.getSelectedItem().equals(null)
				&& !coursesBox.getSelectedItem().equals("")) {
			try {
				String query = "UPDATE Student SET University = 'Gothenburg University' , Degree = '"
						+ degreeStr
						+ "' , Major = '"
						+ coursesStr
						+ "'WHERE Student_ID = " + stdID;
				st = con.prepareStatement(query);
				st.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			String query1 = "UPDATE Student SET First_Name = ? , Last_Name = ? WHERE Student_ID = "
					+ stdID;
			st = con.prepareStatement(query1);
			st.setString(1, fName);
			st.setString(2, lName);
			st.executeUpdate();
			String query2 = "UPDATE Student SET About_Me = ? WHERE Student_ID = "
					+ stdID;
			st = con.prepareStatement(query2);
			st.setString(1, aboutMe);
			st.executeUpdate();
			String query3 = "UPDATE Student SET Nationality = ? WHERE Student_ID= "
					+ stdID;
			st.setString(1, nation);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (Exception excp) {

				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception excp) {

				}
			}

		}
	}

	public void actionPerformed(ActionEvent E) {
		if (E.getSource() == imageButton) {
			int result;
			chooser = new JFileChooser();
			filter = new FileNameExtensionFilter("JPEG & GIF Images", "jpeg",
					"gif");
			// chooser.setCurrentDirectory(new java.io.File("."));
			chooser.setDialogTitle(choosertitle);
			chooser.setFileFilter(filter);
			// chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				image = new File(chooser.getSelectedFile().toString());
				try {
					insertImage();
					setImage(editIcon, imgLabel);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {
				// System.out.println("No Selection ");
			}
		}
		if (E.getSource() == saveButton) {
			if(firstNameEdit.getText().isEmpty()&&lastNameEdit.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "Please fill in your first and last name");
				return;
			}
			try {
				opencon();
				getPassword();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();

			}

			if (!samePass(newPassword.getText(), repeatPassword.getText())) {
				JOptionPane.showMessageDialog(null,
						"New passwords are not the same");
				return;
			}

			if (!samePass(oldPassword.getText(), sqlPassword)
					&& !samePass(oldPassword.getText(), "")) {
				JOptionPane.showMessageDialog(null, "Old password not right");
				return;
			}
//System.out.println(!samePass(oldPassword.getText(), sqlPassword));
			if (samePass(oldPassword.getText(), sqlPassword))

				changePassword();
			addLanguages();
			updateDatabase();
			try {
				insertImage();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				setCourse();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// old password not right or new password and repeat password no the
			// same, error message
			editFrame.dispose();

			new InterestView();
		}
	}
}
