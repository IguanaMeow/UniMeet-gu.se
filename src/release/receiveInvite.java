

import java.awt.Component; // imports used
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import javax.swing.text.PlainDocument;
import javax.swing.text.Utilities;

/*
 * MainScreen.java
 * Purpose: Displays receive invite and automatically downloads the from user names.
 * 			Also, downloads where when and why from server and displays decline and accept button.
 *
 * @author Victor 
 * @version 1.0 
 */

public class receiveInvite extends JFrame { // Define all the
											// Jfields/panels/labels/frames/buttons
											// and resultsets/statements for SQL
											// database
	Statement st = null;
	ResultSet rs = null;
	ResultSet rs1 = null;
	Connection con = null;
	JFrame frame = new JFrame("UniMeet - Receive Invite");
	JPanel firstPanel = new JPanel();
	JPanel commandPanel = new JPanel();
	JPanel meassagePanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	JPanel fin = new JPanel();
	JTextField fromtxt;
	JTextField totxt;
	JTextField wheretxt;
	JTextField whentxt;
	JTextField whytxt;
	JTextArea ppm;
	JLabel from = new JLabel(" From:");
	JLabel to = new JLabel("");
	JLabel when = new JLabel("When:");
	JLabel why = new JLabel(" Why:");
	JLabel where = new JLabel(" Where:");
	JLabel msg = new JLabel(" Message:");
	JButton decline = new JButton("Decline");
	JButton accept = new JButton(" Accept");
	int id1 = 0;
	int id2 = 0;

	public void opencon() throws Exception { // Connection to remote Database
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(" Driver not working");
		}
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:8080/guproject","USER","PASS");
			// System.out.println("Connection working");

		} catch (Exception e) {
			System.out.println("Connection Error");
		}
		st = con.createStatement();
	}

	public void riscreen() throws Exception { // Shows the GUI with all the
												// Jtextfields/panels/labels/etc..

		fromtxt = new JTextField(15);
		totxt = new JTextField(15);
		wheretxt = new JTextField(15);
		whentxt = new JTextField(15);
		whytxt = new JTextField(15);
		ppm = new JTextArea(4, 10);
		ppm.setWrapStyleWord(true); // setWrapStyleWord(true) //
		ppm.setLineWrap(true); // setLineWrap(true) // these 2 things limit
								// limit the JTextArea
		ppm.getCaret().setSelectionVisible(true);
		wheretxt.setDocument(new JTextFieldLimit(15));
		whentxt.setDocument(new JTextFieldLimit(25));
		whytxt.setDocument(new JTextFieldLimit(25));
		ppm.setLineWrap(true);
		ppm.setWrapStyleWord(true);
		fromtxt.setEditable(false);
		totxt.setEditable(false);
		wheretxt.setEditable(false);
		whentxt.setEditable(false);
		whytxt.setEditable(false);
		ppm.setEditable(false);
		firstPanel.add(from);
		firstPanel.add(fromtxt);
		firstPanel.add(to);
		commandPanel.add(where);
		commandPanel.add(wheretxt);
		commandPanel.add(when);
		commandPanel.add(whentxt);
		meassagePanel.add(why);
		meassagePanel.add(whytxt);
		meassagePanel.add(msg);
		meassagePanel.add(new JScrollPane(ppm));
		buttonPanel.add(decline);
		buttonPanel.add(accept);

		fin.setLayout(new GridLayout(4, 2, 2, 2));
		fin.add(firstPanel);
		fin.add(commandPanel);
		fin.add(meassagePanel);
		fin.add(buttonPanel);
		frame.setVisible(true);
		frame.setSize(300, 300);
		frame.add(fin);
		frame.pack();
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setInvite1(fromtxt, totxt, NotifyListener.x,
				FunctionsForMainScreen.getStudentID(),accept,decline);
		// opencon();

		accept.addActionListener(new ActionListener() { // Accept button when
														// pressed sends 1 to
														// accept and 0 to
														// decline

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					st.executeUpdate("UPDATE Invite SET Accepted=1 Where Tuser = "
							+ FunctionsForMainScreen.getStudentID()
							+ " AND Fuser= " + NotifyListener.x);//
					st.executeUpdate("UPDATE Invite SET Declined=0 Where Tuser = "
							+ FunctionsForMainScreen.getStudentID()
							+ " AND Fuser= " + NotifyListener.x);//
					JOptionPane
							.showMessageDialog(null, " Invitation Accepted ");
					frame.dispose();
				} catch (SQLException e) {
					System.out.println("Connection Accept Error");
					e.printStackTrace();
				}
			}
		});

		decline.addActionListener(new ActionListener() { // Decline button when
															// pressed sends 0
															// to accept and 1
															// to decline
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
//					st.executeUpdate("UPDATE Invite SET Accepted=0 Where Tuser = "
//							+ FunctionsForMainScreen.getStudentID()
//							+ " AND Fuser= " + NotifyListener.x);//
//					st.executeUpdate("UPDATE Invite SET Declined=1 Where Tuser = "
//							+ FunctionsForMainScreen.getStudentID()
//							+ " AND Fuser= " + NotifyListener.x);//
					st.executeUpdate("DELETE FROM Invite WHERE Tuser = "
							+ FunctionsForMainScreen.getStudentID()
							+ " AND Fuser =" + NotifyListener.x);
					JOptionPane
							.showMessageDialog(null, " Invitation Declined ");
					frame.dispose();
				//	Invitation.window.dispose();
					try {
						HomePage.showMessInv.removeAll();
						HomePage.showMessInv.add(new Invitation());
						HomePage.showMessInv.revalidate();
						HomePage.contentPane.revalidate();
						//Invitation.screen();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (SQLException e) {
					System.out.println("Connection Decline Error");
					e.printStackTrace();
				}
			}
		});
	}

	// public void invite() throws Exception {
	// opencon();
	// }

	class JTextFieldLimit extends PlainDocument { // Limits JTextFields to a
													// given integer
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

	// public static void main(String[] args) throws Exception {
	// receiveInvite a = new receiveInvite();
	// a.riscreen();
	// }

	public void setInvite1(JTextField fromtxt, JTextField totxt, int id1,
			int id2,JButton accept,JButton decline) throws Exception {
		opencon();
		try {
			// id2=4;
			// rs =
			// st.executeQuery("SELECT Fuser FROM Invite WHERE Tuser="+id2);//Tuser
			// to be changed to logged on user

			//
			// while(rs.next()){
			// id1=rs.getInt("Fuser");
			// }
			rs1 = st.executeQuery("SELECT * FROM Student WHERE Student_ID="
					+ id1);

			while (rs1.next()) {
				fromtxt.setText(rs1.getString("First_Name"));
			}

			rs = st.executeQuery("SELECT * FROM Invite WHERE Tuser=" + id2
					+ " AND Fuser = " + id1);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		while (rs.next()) {
			wheretxt.setText(rs.getString("Location"));
			whentxt.setText(rs.getString("Time"));
			whytxt.setText(rs.getString("Why"));
			ppm.setText(rs.getString("Message"));

		}
		rs=st.executeQuery("Select * from Invite where (Tuser= " + id2 + " AND Fuser = "+ id1 + " )AND Accepted=1");
		if(rs.next()){
			accept.setText("Accepted");
			accept.setEnabled(false);
			decline.setVisible(false);
		
		}
	}
}
