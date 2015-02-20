

import java.awt.Image;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class FunctionsForHome {
	Statement st ;
	ResultSet rs ;
	java.sql.Connection con;
static String common;
	Queries query = new Queries();
	
	public void refreshButtons() {
		refresh(Search.ArtsButton, Search.SportsButton, Search.OutdoorButton, Search.IndoorButton,
				Search.FilmButton, Search.MusicButton, Search.OtherButton);
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
	public void refresh(JButton a, JButton b, JButton c, JButton d, JButton e,
			JButton f, JButton g) {
		a.setEnabled(true);
		b.setEnabled(true);
		c.setEnabled(true);
		d.setEnabled(true);
		e.setEnabled(true);
		f.setEnabled(true);
		g.setEnabled(true);
	}
	public void suggestedFriends(){
		query.suggQuery();
		common="Common Interests Shared";
		if(Queries.exist==true){
			HomePage.showResult.add(new ResPane());
		}
			
	}
	public void setImage(ImageIcon a, JLabel b,JPanel p) throws Exception{
		opencon();
		byte [] imageBytes;
		Image image;
		st = con.createStatement();
		PreparedStatement ps=null;
		String sql = "Select Picture FROM Student WHERE Student_ID=" + FunctionsForMainScreen.getStudentID();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        if(rs.next()){
			imageBytes=rs.getBytes("Picture");
			if(imageBytes!=null){
				image = HomePage.homepage.getToolkit().createImage(imageBytes);
				a = new ImageIcon(image);
				Image img = a.getImage();
				img = img.getScaledInstance(140, 130, Image.SCALE_SMOOTH);
				a=new ImageIcon(img);
				b.setIcon(a);
				p.add(b);
				
			}
		}
	}

	// this class is an void method for the search button,
		// when clicking a button and then click 'search', it will call
		// the corresponding button
		public void searchFunction( JTabbedPane tabbedPane) {
			if (tabbedPane.getTitleAt(tabbedPane.getSelectedIndex()).equals(
					"Subject")) {
				common="Study Partner";
				Queries.exist=false;
				// System.out.println(subjectChosen);
				query.courseQuery();
				
				if (Queries.exist == true){
				//	System.out.println("query exists");
					/*
					new GuiResults();
					*/
					HomePage.showResult.add(new ResPane());}
				else {
					JOptionPane.showMessageDialog(null, "No matches found");
				}
			} else if (tabbedPane.getTitleAt(tabbedPane.getSelectedIndex())
					.equals("Language")) {
				common="Language Partner";
				Queries.exist=false;
				query.languageQuery();
				if (Queries.exist == true)
					//new GuiResults();
					HomePage.showResult.add(new ResPane());
				else {
					JOptionPane.showMessageDialog(null, "No matches found");
				}

			} else if (tabbedPane.getTitleAt(tabbedPane.getSelectedIndex())
					.equals("Interest")) {
				if (Search.MusicButton.isEnabled() == true) {
					common="Common Music Interests";
					Queries.exist=false;
					query.musicQuery();
					if (Queries.exist == true)
						//new GuiResults();
						HomePage.showResult.add(new ResPane());

					else {
						JOptionPane.showMessageDialog(null, "No matches found");
					}
				}
				if (Search.FilmButton.isEnabled() == true) {
					common="Common Film Interests";
					Queries.exist=false;
					query.filmQuery();
					if (Queries.exist == true)
						//new GuiResults();
						HomePage.showResult.add(new ResPane());

					else {
						JOptionPane.showMessageDialog(null, "No matches found");
					}
				}
				if (Search.IndoorButton.isEnabled() == true) {
					common="Common Indoor Interests";
					Queries.exist=false;
					query.indoorQuery();
					if (Queries.exist == true)
						//new GuiResults();
						HomePage.showResult.add(new ResPane());

					else {
						JOptionPane.showMessageDialog(null, "No matches found");
					}
				}
				if (Search.OutdoorButton.isEnabled() == true) {
					common="Common Outdoor Interests";
					Queries.exist=false;
					query.outdoorQuery();
					if (Queries.exist == true)
						//new GuiResults();
						HomePage.showResult.add(new ResPane());

					else {
						JOptionPane.showMessageDialog(null, "No matches found");
					}
				}
				if (Search.ArtsButton.isEnabled() == true) {
					common="Common Arts Interests";
					Queries.exist=false;
					query.artsQuery();
					if (Queries.exist == true)
						//new GuiResults();
						HomePage.showResult.add(new ResPane());

					else {
						JOptionPane.showMessageDialog(null, "No matches found");
					}
				}
				if (Search.SportsButton.isEnabled() == true) {
					common="Common Sports Interests";
					Queries.exist=false;
					query.sportsQuery();
					if (Queries.exist == true)
						//new GuiResults();
						HomePage.showResult.add(new ResPane());

					else {
						JOptionPane.showMessageDialog(null, "No matches found");
					}
				}
				if (Search.OtherButton.isEnabled() == true) {
					common="Common Other Interests";
					Queries.exist=false;
					query.otherQuery();
					if (Queries.exist == true)
						//new GuiResults();
						HomePage.showResult.add(new ResPane());

					else {
						JOptionPane.showMessageDialog(null, "No matches found");
					}
				}
			}
		}
	
}

