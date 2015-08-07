

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;

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
	JLabel languageLabel = new JLabel();
	JLabel languageField = new JLabel();
	JLabel nationField = new JLabel();
	JTextArea aboutMeField = new JTextArea(10,32);
	JButton editButton = new JButton("Edit");
	JFrame profilePage = new JFrame("UniMeet- My Profile");
	JPanel imagePanel = new JPanel();
	ImageIcon icon;
	JLabel imageLabel = new JLabel(icon);
	
	ViewProfile() {
		
		//**J: deleted all panels, they aren't useful if only one component in each panel
//		JPanel namesPanel = new JPanel();
//		JPanel imagePanel = new JPanel();
//		JPanel genBirPanel = new JPanel();
//		JPanel birPanel = new JPanel();
//		JPanel nationPanel = new JPanel();
//		JPanel uniPanel = new JPanel();
		
//		JPanel intPanel = new JPanel();
		JPanel profilePanel = new JPanel();
//		JPanel artPanel = new JPanel();
//		JPanel filmPanel = new JPanel();
//		JPanel inPanel = new JPanel();
//		JPanel musPanel = new JPanel();
//		JPanel outPanel = new JPanel();
//		JPanel sprtPanel = new JPanel();
//		JPanel otrPanel = new JPanel();
		
		
		aboutMeField.setLineWrap(true);
        aboutMeField.setWrapStyleWord(true);
        aboutMeField.setEditable(false);
		aboutMeField.setBackground(null);
        
		try {
			setImage(icon,imageLabel);
			setT(firstName,birthField,uniField,genderField,languageField,aboutMeField,interestField1,interestField2,interestField3,interestField4,interestField5,interestField6,interestField7,nationField);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		editButton.addActionListener(this);

		//profilePanel.setLayout(new BoxLayout(profilePanel, BoxLayout.PAGE_AXIS));
		profilePanel.setLayout(new MigLayout("wrap 2, align left", "0! [300:300:400] 0! []", "0![]5![]3![]12![]20![]20![]20![]20![]20!"));
		
		/*
		 * logoPanel
		 * 
		 */
		
		//set a logoPanel which is on the top, contains two parts of the logo
		//and two buttons: MyPage and LogOut
		JPanel logoPanel = new JPanel(new MigLayout("", "10![]0![]0![]2![]10!", "0![] 20! []"));
		
		JLabel logo = new JLabel("Uni");
		JLabel logo2 = new JLabel("Meet");
		logo.setFont(new Font("Serif", Font.ITALIC, 20));
		logo.setForeground(Color.BLUE);
		logo2.setFont(new Font("TimesRoman-Bold", Font.ITALIC, 20));
		logo2.setForeground(Color.DARK_GRAY);
		
//		logoPanel.setBorder(BorderFactory.createDashedBorder(null));
		logoPanel.setBackground(Color.WHITE);
		logoPanel.add(logo, "align right, aligny baseline");
		logoPanel.add(logo2, "push, aligny baseline");
		profilePanel.add(logoPanel, "span 2, w 460!, h 28!, dock north");
		
		//**edit Panel
		JLabel editLabel = new JLabel("Fill in your profile so other students can search for you.");
		editLabel.setForeground(Color.BLUE);
		JPanel editPanel = new JPanel();
		editPanel.add(editLabel);
		editPanel.add(editButton);
		profilePanel.add(editPanel, "span 2, gapleft 15!");
		
		
		/*
		 * 
		 * personal details section
		 */
		JLabel personalL = new JLabel("--Basic Information-------------------------------------------------------");
		personalL.setFont(new Font("Serif", Font.ITALIC, 16));
		profilePanel.add(personalL, "gapleft 20!, span 2, align left");
		// add name
		profilePanel.add(firstName, "gapleft 20!, skip 2, w 300!");

		//***J: new image panel for retrieving profile pic
//		profilePanel.add(imageLabel, "cell 1 0 1 5");
		imagePanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));		
		profilePanel.add(imagePanel, "span 1 4, w 120!, h 130!");		

		profilePanel.add(genderField, "gapleft 20!, w 300!");
		profilePanel.add(birthField, "gapleft 20!, w 300!");
		profilePanel.add(nationField, "gapleft 20!, w 300!");
		profilePanel.add(uniField, "span 2, gapleft 20!");
		
		profilePanel.add(languageLabel, "split 2, gapleft 20!");
		profilePanel.add(languageField, "wrap");
		
		//J: instead of having separate panels for all interests, I put them all in intPanel
		JPanel intPanel = new JPanel();
		intPanel.setLayout(new MigLayout("wrap 2, gapy 15!"));
		intPanel.setBorder(BorderFactory.createTitledBorder("Interests"));
		
		/*
		 * 
		 * interest Panel
		 */
		intPanel.add(new JLabel (" Arts :"));
		intPanel.add(interestField1);
		intPanel.add(new JLabel (" Film :"));
		intPanel.add(interestField2);
		intPanel.add(new JLabel (" Indoor :"));
		intPanel.add(interestField3);
		intPanel.add(new JLabel (" Music :"));
		intPanel.add(interestField4);
		intPanel.add(new JLabel (" Outdoor :"));
		intPanel.add(interestField5);
		intPanel.add(new JLabel (" Sports :"));
		intPanel.add(interestField6);
		intPanel.add(new JLabel (" Other :"));
		intPanel.add(interestField7);
		profilePanel.add(intPanel, "span 2, w 425!, gapleft 20!");
		
		/*
		 * 
		 * about me section
		 */
		JPanel aboutPanel = new JPanel();
		aboutPanel.setBorder(BorderFactory.createTitledBorder("About Me"));	
//		profilePanel.add(new JLabel (" About me: "), "wrap");
		aboutPanel.add(aboutMeField);
		profilePanel.add(aboutPanel, "span 2, w 425!, gapleft 20!");

		
//		profilePanel.add(imagePanel);
//		profilePanel.add(namesPanel);
//		namesPanel.setBorder(BorderFactory.createLineBorder(Color.green));
//		profilePanel.add(genBirPanel);
//		genBirPanel.setBorder(BorderFactory.createLineBorder(Color.red));
//		profilePanel.add(birPanel);
//		profilePanel.add(nationPanel);
//		langPanel.setBorder(BorderFactory.createLineBorder(Color.orange));
//		profilePanel.add(uniPanel);
		
//		profilePanel.add(intPanel);
//		profilePanel.add(artPanel);
//		profilePanel.add(filmPanel);
//		profilePanel.add(inPanel);
//		profilePanel.add(musPanel);
//		profilePanel.add(outPanel);
//		profilePanel.add(sprtPanel);
//		profilePanel.add(otrPanel);
//		profilePanel.add(aboutPanel);
		

		
		profilePage.add(new JScrollPane(profilePanel));
	//	profilePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		profilePage.setSize(480,600);
		//profilePage.setLocationRelativeTo(null);
		profilePage.setVisible(true);
		profilePage.setLocationRelativeTo(null);
		
	}
	
	public void actionPerformed(ActionEvent E) {
		if(E.getSource() == editButton){
			profilePage.dispose();
			new EditProfile();
		}
	}
	
	public void setImage(ImageIcon a, JLabel b) throws Exception{
		opencon();
		byte [] imageBytes;
		Image image;
		st = con.createStatement();
		PreparedStatement ps=null;
		String sql = "Select Picture FROM Student WHERE Student_ID=" + stdID;
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        if(rs.next()){
			
			imageBytes=rs.getBytes("Picture");
			if(imageBytes!=null){
				image = profilePage.getToolkit().createImage(imageBytes);
				a = new ImageIcon(image);
				Image img = a.getImage();
				
				
				//int scaledWidth = (int) (imgW*scaleFactor);


				
				img = img.getScaledInstance(115, 115, Image.SCALE_SMOOTH);
				a=new ImageIcon(img);
				b.setIcon(a);
				imagePanel.add(b);
			}
		}
	}
	
	
	
	public void setT(JLabel a, JLabel b,JLabel c,JLabel d,JLabel e, JTextArea f, JLabel g, JLabel h, JLabel i, JLabel j, JLabel k, JLabel l, JLabel m, JLabel n) throws Exception{
		opencon();
		rs=st.executeQuery("Select * FROM Student WHERE Student_ID=" + stdID);
		while(rs.next()){
			a.setText("Name: " + rs.getString("First_Name") + " " + rs.getString("Last_Name"));
			b.setText("Date of birth: " + rs.getDate("Birthday").toString());
			c.setText("University: " + rs.getString("University") + " - " + rs.getString("Degree") + "-" + rs.getString("Major"));
			d.setText("Gender: " + rs.getString("Gender"));
			n.setText("Nationality: " + rs.getString("Nationality"));
			}
			rs=st.executeQuery("SELECT * FROM Student_Language2, Languages WHERE Student_Language2.idLanguage = Languages.idLanguage AND Student_Language2.idStudent = " + stdID);
			
			while(rs.next()){
				languageLabel.setText("");
				languageLabel.setText("Language/s: ");
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
	
	/*public static void main (String[] args){
	 new ViewProfile();	
	}*/
	
	
}
