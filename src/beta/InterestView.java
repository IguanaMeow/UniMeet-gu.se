package gu.se.project.beta;


import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

import static javax.swing.GroupLayout.Alignment.*;
/**
 * 
 * InterestView.java 
 * 
 * 
 * @author Elsa
 * @version 1.0
 */
public class InterestView implements ActionListener {
	int idStudent = FunctionsForMainScreen.studentID; 
	Statement st = null;
	ResultSet rs = null;
	java.sql.Connection con=null;
	JButton saveIntr= new JButton("Save");
	JCheckBox artBox1= new JCheckBox("Circus");
	JCheckBox artBox2= new JCheckBox("Dance");
	JCheckBox artBox3= new JCheckBox("Galleries");
	JCheckBox artBox4= new JCheckBox("Museums");
	JCheckBox artBox5= new JCheckBox("Opera");
	JCheckBox artBox6= new JCheckBox("Performing Arts");
	JCheckBox artBox7= new JCheckBox("Theatre");
	JCheckBox filmBox1= new JCheckBox("Action");
	JCheckBox filmBox2= new JCheckBox("Anime");
	JCheckBox filmBox3= new JCheckBox("Comedy");
	JCheckBox filmBox4= new JCheckBox("Drama");
	JCheckBox filmBox5= new JCheckBox("Erotic");
	JCheckBox filmBox6= new JCheckBox("Foreign Films");
	JCheckBox filmBox7= new JCheckBox("Horror");
	JCheckBox filmBox8= new JCheckBox("Musicals");
	JCheckBox filmBox9= new JCheckBox("Sci-Fi");
	JCheckBox filmBox10= new JCheckBox("Thriller");
	JCheckBox inBox1= new JCheckBox("Books");
	JCheckBox inBox2= new JCheckBox("Board Games");
	JCheckBox inBox3= new JCheckBox("Coffeeshops");
	JCheckBox inBox4= new JCheckBox("Cooking");
	JCheckBox inBox5= new JCheckBox("Dancing");
	JCheckBox inBox6= new JCheckBox("Fitness");
	JCheckBox inBox7= new JCheckBox("Painting");
	JCheckBox inBox8= new JCheckBox("Restaurants");
	JCheckBox inBox9= new JCheckBox("Televsion");
	JCheckBox inBox10= new JCheckBox("Videogames");
	JCheckBox musBox1= new JCheckBox("Afro-Beat");
	JCheckBox musBox2= new JCheckBox("Blues");
	JCheckBox musBox3= new JCheckBox("Classical");
	JCheckBox musBox4= new JCheckBox("Electronic"); 
	JCheckBox musBox5= new JCheckBox("Folk");
	JCheckBox musBox6= new JCheckBox("Hip-Hop");
	JCheckBox musBox7= new JCheckBox("Indian"); 
	JCheckBox musBox8= new JCheckBox("Jazz");
	JCheckBox musBox9= new JCheckBox("Rock");
	JCheckBox musBox10= new JCheckBox("World");
	JCheckBox outBox1= new JCheckBox("Astrology");
	JCheckBox outBox2= new JCheckBox("Bird Watching");
	JCheckBox outBox3= new JCheckBox("Camping");
	JCheckBox outBox4= new JCheckBox("Hiking");
	JCheckBox outBox5= new JCheckBox("Hunting");
	JCheckBox outBox6= new JCheckBox("Sunbathing");
	JCheckBox outBox7= new JCheckBox("Travel");
	JCheckBox outBox8= new JCheckBox("Walking");
	JCheckBox sprtBox1= new JCheckBox("Badminton");
	JCheckBox sprtBox2= new JCheckBox("Boxing");
	JCheckBox sprtBox3= new JCheckBox("Cycling");
	JCheckBox sprtBox4= new JCheckBox("Gym");
	JCheckBox sprtBox5= new JCheckBox("Football");
	JCheckBox sprtBox6= new JCheckBox("Running");
	JCheckBox sprtBox7= new JCheckBox("Skiing");
	JCheckBox sprtBox8= new JCheckBox("Swimming");
	JCheckBox sprtBox9= new JCheckBox("Tennis");
	JCheckBox sprtBox10= new JCheckBox("Volley ball");
	JCheckBox otrBox1 = new JCheckBox("Cars");
	JCheckBox otrBox2 = new JCheckBox("Computers");
	JCheckBox otrBox3 = new JCheckBox("Cosplay");
	JCheckBox otrBox4 = new JCheckBox("Fashion");
	JCheckBox otrBox5 = new JCheckBox("Photography");
	JCheckBox otrBox6 = new JCheckBox("Politics");
	JCheckBox otrBox7 = new JCheckBox("Train Spotting");
	JCheckBox otrBox8 = new JCheckBox("Volunteering");
	JCheckBox otrBox9 = new JCheckBox("Watching Sports");
	JCheckBox otrBox10 = new JCheckBox("Wine Tasting");
	JPanel artPanel = new JPanel();
	JPanel filmPanel = new JPanel();
	JPanel inPanel = new JPanel();
	JPanel musicPanel = new JPanel();
	JPanel outPanel = new JPanel();
	JPanel sprtPanel = new JPanel();
	JPanel otrPanel = new JPanel();
	JPanel savePanel = new JPanel();
	JFrame interestFrame = new JFrame();
	JCheckBox [] artArray;
	JCheckBox [] filmArray;
	JCheckBox [] inArray;
	JCheckBox [] musArray;
	JCheckBox [] outArray;
	JCheckBox [] sprtArray;
	JCheckBox [] otrArray;
	
	InterestView(){
		saveIntr.addActionListener(this);
		
		artArray = new JCheckBox[7];
		artArray[0] = artBox1;
		artArray[1] = artBox2;
		artArray[2] = artBox3;
		artArray[3] = artBox4;
		artArray[4] = artBox5;
		artArray[5] = artBox6;
		artArray[6] = artBox7;
		
		filmArray= new JCheckBox[10];
		filmArray[0] = filmBox1;
		filmArray[1] = filmBox2;
		filmArray[2] = filmBox3;
		filmArray[3] = filmBox4;
		filmArray[4] = filmBox5;
		filmArray[5] = filmBox6;
		filmArray[6] = filmBox7;
		filmArray[7] = filmBox8;
		filmArray[8] = filmBox9;
		filmArray[9] = filmBox10;
		
		inArray= new JCheckBox[10];
		inArray[0] = inBox1;
		inArray[1] = inBox2;
		inArray[2] = inBox3;
		inArray[3] = inBox4;
		inArray[4] = inBox5;
		inArray[5] = inBox6;
		inArray[6] = inBox7;
		inArray[7] = inBox8;
		inArray[8] = inBox9;
		inArray[9] = inBox10;
		
		musArray= new JCheckBox[10];
		musArray[0] = musBox1;
		musArray[1] = musBox2;
		musArray[2] = musBox3;
		musArray[3] = musBox4;
		musArray[4] = musBox5;
		musArray[5] = musBox6;
		musArray[6] = musBox7;
		musArray[7] = musBox8;
		musArray[8] = musBox9;
		musArray[9] = musBox10;
		
		outArray= new JCheckBox[8];
		outArray[0] = outBox1;
		outArray[1] = outBox2;
		outArray[2] = outBox3;
		outArray[3] = outBox4;
		outArray[4] = outBox5;
		outArray[5] = outBox6;
		outArray[6] = outBox7;
		outArray[7] = outBox8;
		
		sprtArray = new JCheckBox[10];
		sprtArray[0] = sprtBox1;
		sprtArray[1] = sprtBox2;
		sprtArray[2] = sprtBox3;
		sprtArray[3] = sprtBox4;
		sprtArray[4] = sprtBox5;
		sprtArray[5] = sprtBox6;
		sprtArray[6] = sprtBox7;
		sprtArray[7] = sprtBox8;
		sprtArray[8] = sprtBox9;
		sprtArray[9] = sprtBox10;
		
		otrArray = new JCheckBox[10];
		otrArray[0] = otrBox1;
		otrArray[1] = otrBox2;
		otrArray[2] = otrBox3;
		otrArray[3] = otrBox4;
		otrArray[4] = otrBox5;
		otrArray[5] = otrBox6;
		otrArray[6] = otrBox7;
		otrArray[7] = otrBox8;
		otrArray[8] = otrBox9;
		otrArray[9] = otrBox10;
		
		try {
			setSelected();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ItemListener listener = new ItemListener(){
			public void itemStateChanged(ItemEvent event){
				
				 JCheckBox checkBox = (JCheckBox)event.getSource();
			        if(checkBox.isSelected()==true){
			        	Component[] components = checkBox.getParent().getComponents();
			        	int times=0;
			        	for (int i = 0; i < components.length; i++){
			        		if (components[i] instanceof JCheckBox){
			        			JCheckBox box = (JCheckBox)components[i];
			        				if (box.isSelected() == true){
			        					times++;
			        				}
			        		}
			        }
			        if(times>3){
			        	checkBox.setSelected(false);
			        }
			     }
			}
		};
		artBox1.addItemListener(listener);
		artBox2.addItemListener(listener);
		artBox3.addItemListener(listener);
		artBox4.addItemListener(listener);
		artBox5.addItemListener(listener);
		artBox6.addItemListener(listener);
		artBox7.addItemListener(listener);
		filmBox1.addItemListener(listener);
		filmBox2.addItemListener(listener);
		filmBox3.addItemListener(listener);
		filmBox4.addItemListener(listener);
		filmBox5.addItemListener(listener);
		filmBox6.addItemListener(listener);
		filmBox7.addItemListener(listener);
		filmBox8.addItemListener(listener);
		filmBox8.addItemListener(listener);
		filmBox10.addItemListener(listener);
		inBox1.addItemListener(listener);
		inBox2.addItemListener(listener);
		inBox3.addItemListener(listener);
		inBox4.addItemListener(listener);
		inBox5.addItemListener(listener);
		inBox6.addItemListener(listener);
		inBox7.addItemListener(listener);
		inBox8.addItemListener(listener);
		inBox9.addItemListener(listener);
		inBox10.addItemListener(listener);
		musBox1.addItemListener(listener);
		musBox2.addItemListener(listener);
		musBox3.addItemListener(listener);
		musBox4.addItemListener(listener);
		musBox5.addItemListener(listener);
		musBox6.addItemListener(listener);
		musBox7.addItemListener(listener);
		musBox8.addItemListener(listener);
		musBox9.addItemListener(listener);
		musBox10.addItemListener(listener);
		outBox1.addItemListener(listener);
		outBox2.addItemListener(listener);
		outBox3.addItemListener(listener);
		outBox4.addItemListener(listener);
		outBox5.addItemListener(listener);
		outBox6.addItemListener(listener);
		outBox7.addItemListener(listener);
		outBox8.addItemListener(listener);
		sprtBox1.addItemListener(listener);
		sprtBox2.addItemListener(listener);
		sprtBox3.addItemListener(listener);
		sprtBox4.addItemListener(listener);
		sprtBox5.addItemListener(listener);
		sprtBox6.addItemListener(listener);
		sprtBox7.addItemListener(listener);
		sprtBox8.addItemListener(listener);
		sprtBox9.addItemListener(listener);
		sprtBox10.addItemListener(listener);
		otrBox1.addItemListener(listener);
		otrBox2.addItemListener(listener);
		otrBox3.addItemListener(listener);
		otrBox4.addItemListener(listener);
		otrBox5.addItemListener(listener);
		otrBox6.addItemListener(listener);
		otrBox7.addItemListener(listener);
		otrBox8.addItemListener(listener);
		otrBox9.addItemListener(listener);
		otrBox10.addItemListener(listener);
		
		artPanel.add(new JLabel("Art: "));
		artPanel.add(artBox1);
		artPanel.add(artBox2);
		artPanel.add(artBox3);
		artPanel.add(artBox4);
		artPanel.add(artBox5);
		artPanel.add(artBox6);
		artPanel.add(artBox7);
		filmPanel.add(new JLabel("Film: "));
		filmPanel.add(filmBox1);
		filmPanel.add(filmBox2);
		filmPanel.add(filmBox3);
		filmPanel.add(filmBox4);
		filmPanel.add(filmBox5);
		filmPanel.add(filmBox6);
		filmPanel.add(filmBox7);
		filmPanel.add(filmBox8);
		filmPanel.add(filmBox9);
		filmPanel.add(filmBox10);
		inPanel.add(new JLabel("Indoor :"));
		inPanel.add(inBox1);
		inPanel.add(inBox2);
		inPanel.add(inBox3);
		inPanel.add(inBox4);
		inPanel.add(inBox5);
		inPanel.add(inBox6);
		inPanel.add(inBox7);
		inPanel.add(inBox8);
		inPanel.add(inBox9);
		inPanel.add(inBox10);
		musicPanel.add(new JLabel("Music: "));
		musicPanel.add(musBox1);
		musicPanel.add(musBox2);
		musicPanel.add(musBox3);
		musicPanel.add(musBox4);
		musicPanel.add(musBox5);
		musicPanel.add(musBox6);
		musicPanel.add(musBox7);
		musicPanel.add(musBox8);
		musicPanel.add(musBox9);
		musicPanel.add(musBox10);
		outPanel.add(new JLabel("Outdoor: "));
		outPanel.add(outBox1);
		outPanel.add(outBox2);
		outPanel.add(outBox3);
		outPanel.add(outBox4);
		outPanel.add(outBox5);
		outPanel.add(outBox6);
		outPanel.add(outBox7);
		outPanel.add(outBox8);
		sprtPanel.add(artPanel);
		sprtPanel.add(filmPanel);
		sprtPanel.add(inPanel);
		sprtPanel.add(musicPanel);
		sprtPanel.add(outPanel);
		sprtPanel.add(new JLabel("Sports: "));
		sprtPanel.add(sprtBox1);
		sprtPanel.add(sprtBox2);
		sprtPanel.add(sprtBox3);
		sprtPanel.add(sprtBox4);
		sprtPanel.add(sprtBox5);
		sprtPanel.add(sprtBox6);
		sprtPanel.add(sprtBox7);
		sprtPanel.add(sprtBox8);
		sprtPanel.add(sprtBox9);
		sprtPanel.add(sprtBox10);
		otrPanel.add(new JLabel("Other: "));
		otrPanel.add(otrBox1);
		otrPanel.add(otrBox2);
		otrPanel.add(otrBox3);
		otrPanel.add(otrBox4);
		otrPanel.add(otrBox5);
		otrPanel.add(otrBox6);
		otrPanel.add(otrBox7);
		otrPanel.add(otrBox8);
		otrPanel.add(otrBox9);
		otrPanel.add(otrBox10);
		savePanel.add(artPanel);
		savePanel.add(filmPanel);
		savePanel.add(inPanel);
		savePanel.add(musicPanel);
		savePanel.add(outPanel);
		savePanel.add(sprtPanel);
		savePanel.add(otrPanel);
		savePanel.add(saveIntr);
		interestFrame.add(savePanel);
		
		
		interestFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		interestFrame.setSize(1200,600);
		interestFrame.setLocationRelativeTo(null);
		interestFrame.setVisible(true);
	
	}
	
	public void opencon() throws Exception {
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
	
	public void updateBase() throws Exception{
		opencon();
		st.executeUpdate("DELETE FROM Student_Arts WHERE idStudent="+ idStudent +"");
		st.executeUpdate("DELETE FROM Student_Film WHERE idStudent="+ idStudent +"");
		st.executeUpdate("DELETE FROM Student_Indoor WHERE idStudent="+ idStudent +"");
		st.executeUpdate("DELETE FROM Student_Music WHERE idStudent="+ idStudent +"");
		st.executeUpdate("DELETE FROM Student_Outdoor WHERE idStudent="+ idStudent +"");
		st.executeUpdate("DELETE FROM Student_Sports WHERE idStudent="+ idStudent +"");
		st.executeUpdate("DELETE FROM Student_Other WHERE idStudent="+ idStudent +"");
		
		int id=0;
		for(JCheckBox j:artArray){
			if(j.isSelected()){
				 rs=st.executeQuery("SELECT idArts FROM Arts WHERE Description= '" + j.getText() + "'");
				 if(rs.next()){
					 id=rs.getInt("idArts");
					 st.executeUpdate("INSERT INTO Student_Arts VALUES ("+ idStudent +","+id+")" );
				 }
			}
		}
		for(JCheckBox j:filmArray){
			if(j.isSelected()){
				 rs=st.executeQuery("SELECT idFilm FROM Film WHERE Description= '" + j.getText() + "'");
				 if(rs.next()){
					 id=rs.getInt("idFilm");
					 st.executeUpdate("INSERT INTO Student_Film VALUES ("+ idStudent +","+id+")" );
				 }
			}
		}
		for(JCheckBox j:inArray){
			if(j.isSelected()){
				 rs=st.executeQuery("SELECT idIndoor FROM Indoor WHERE Description= '" + j.getText() + "'");
				 if(rs.next()){
					 id=rs.getInt("idIndoor");
					 st.executeUpdate("INSERT INTO Student_Indoor VALUES ("+ idStudent +","+id+")" );
				 }
			}
		}
		for(JCheckBox j:musArray){
			if(j.isSelected()){
				 rs=st.executeQuery("SELECT idMusic FROM Music WHERE Description= '" + j.getText() + "'");
				 if(rs.next()){
					 id=rs.getInt("idMusic");
					 st.executeUpdate("INSERT INTO Student_Music VALUES ("+ idStudent +","+id+")" );
				 }
			}
		}
		for(JCheckBox j:outArray){
			if(j.isSelected()){
				 rs=st.executeQuery("SELECT idOutdoor FROM Outdoor WHERE Description= '" + j.getText() + "'");
				 if(rs.next()){
					 id=rs.getInt("idOutdoor");
					 st.executeUpdate("INSERT INTO Student_Outdoor VALUES ("+ idStudent +","+id+")" );
				 }
			}
		}
		for(JCheckBox j:sprtArray){
			if(j.isSelected()){
				 rs=st.executeQuery("SELECT idSports FROM Sports WHERE Description= '" + j.getText() + "'");
				 if(rs.next()){
					 id=rs.getInt("idSports");
					 st.executeUpdate("INSERT INTO Student_Sports VALUES ("+ idStudent +","+id+")" );
				 }
			}
		}
		for(JCheckBox j:otrArray){
			if(j.isSelected()){
				 rs=st.executeQuery("SELECT idOther FROM Other WHERE Description= '" + j.getText() + "'");
				 if(rs.next()){
					 id=rs.getInt("idOther");
					 st.executeUpdate("INSERT INTO Student_Other VALUES ("+ idStudent +","+id+")" );
				 }
			}
		}
	}
	
	public void setSelected() throws Exception{
		opencon();
		 rs=st.executeQuery("SELECT * FROM Student_Arts, Arts WHERE Student_Arts.idStudent = "+ idStudent +" AND Arts.idArts = Student_Arts.idArts");
         while(rs.next()){
        	 for(JCheckBox j:artArray){
        		 if(j.getText().equals(rs.getString("Description"))){
        			 j.setSelected(true);
        		 }
        	 }
         }
         rs=st.executeQuery("SELECT * FROM Student_Film, Film WHERE Student_Film.idStudent = "+ idStudent +" AND Film.idFilm = Student_Film.idFilm");
         while(rs.next()){
        	 for(JCheckBox j:filmArray){
        		 if(j.getText().equals(rs.getString("Description"))){
        			 j.setSelected(true);
        		 }
        	 }
         }
         rs=st.executeQuery("SELECT * FROM Student_Indoor, Indoor WHERE Student_Indoor.idStudent = "+ idStudent +" AND Indoor.idIndoor = Student_Indoor.idIndoor");
         while(rs.next()){
        	 for(JCheckBox j:inArray){
        		 if(j.getText().equals(rs.getString("Description"))){
        			 j.setSelected(true);
        		 }
        	 }
         }
         rs=st.executeQuery("SELECT * FROM Student_Music, Music WHERE Student_Music.idStudent = "+ idStudent +" AND Music.idMusic = Student_Music.idMusic");
         while(rs.next()){
        	 for(JCheckBox j:musArray){
        		 if(j.getText().equals(rs.getString("Description"))){
        			 j.setSelected(true);
        		 }
        	 }
         }
         rs=st.executeQuery("SELECT * FROM Student_Outdoor, Outdoor WHERE Student_Outdoor.idStudent = "+ idStudent +" AND Outdoor.idOutdoor = Student_Outdoor.idOutdoor");
         while(rs.next()){
        	 for(JCheckBox j:outArray){
        		 if(j.getText().equals(rs.getString("Description"))){
        			 j.setSelected(true);
        		 }
        	 }
         }
         rs=st.executeQuery("SELECT * FROM Student_Sports, Sports WHERE Student_Sports.idStudent = "+ idStudent +" AND Sports.idSports = Student_Sports.idSports");
         while(rs.next()){
        	 for(JCheckBox j:sprtArray){
        		 if(j.getText().equals(rs.getString("Description"))){
        			 //System.out.println(rs.getString("Description"));
        			 j.setSelected(true);
        		 }
        	 }
         }
         rs=st.executeQuery("SELECT * FROM Student_Other, Other WHERE Student_Other.idStudent = "+ idStudent +" AND Other.idOther = Student_Other.idOther");
         while(rs.next()){
        	 for(JCheckBox j:otrArray){
        		 if(j.getText().equals(rs.getString("Description"))){
        			 //System.out.println(rs.getString("Description"));
        			 j.setSelected(true);
        		 }
        	 }
         }
	}
	
	public void actionPerformed(ActionEvent E){
		if(E.getSource() == saveIntr){
			interestFrame.dispose();
			try {
				opencon();
				updateBase();
				new ViewProfile();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	


}

	
