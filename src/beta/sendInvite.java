package gu.se.project.beta; // package declaration

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
 * Purpose: Displays send invite and automatically downloads the from and to user names.
 * 			Also, where when and why fields are left for the current user to fill in, the cancle button closes the send invite forum and send button uploads the information to the database.
 * @author Simeon
 * @version 1.0 
 */

public class sendInvite extends JFrame {		//	Define all the Jfields/panels/labels/frames/buttons and resultsets/statements for SQL database
	Statement st = null;
	ResultSet rs = null;
	Connection con = null;
	JFrame frame = new JFrame("UniMeet - Send Invite");
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
	JLabel to = new JLabel(" To:");
	JLabel when = new JLabel(" When:");
	JLabel why = new JLabel(" Why:");
	JLabel where = new JLabel(" Where:");
	JLabel msg = new JLabel(" Message:");
	JButton cancel = new JButton("Cancel");
	JButton send = new JButton(" Send");
	int id1=0;
	int id2=0;
	String email="";
	public void opencon() throws Exception {		//	Connection to remote Database
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

	public void siscreen() throws Exception {		//	Shows the GUI with all the Jtextfields/panels/labels/etc..
		fromtxt = new JTextField(15);
		totxt = new JTextField(15);
		wheretxt = new JTextField(15);
		whentxt = new JTextField(15);
		whytxt = new JTextField(15);
		ppm = new JTextArea(2, 10);
		wheretxt.setDocument(new JTextFieldLimit(15));
		whentxt.setDocument(new JTextFieldLimit(25));
		whytxt.setDocument(new JTextFieldLimit(25));
		ppm.setLineWrap(true);				//	setWrapStyleWord(true)	//
		ppm.setWrapStyleWord(true);			//	setLineWrap(true)			// these 2 things limit limit the JTextArea
		fromtxt.setEditable(false);
		totxt.setEditable(false);
		firstPanel.add(from);
		firstPanel.add(fromtxt);
		firstPanel.add(to);
		firstPanel.add(totxt);
		commandPanel.add(where);
		commandPanel.add(wheretxt);
		commandPanel.add(when);
		commandPanel.add(whentxt);
		meassagePanel.add(why);
		meassagePanel.add(whytxt);
		meassagePanel.add(msg);
		meassagePanel.add(new JScrollPane(ppm));
		buttonPanel.add(cancel);
		buttonPanel.add(send);

		fin.setLayout(new GridLayout(4, 2, 2, 2));
		fin.add(firstPanel);
		fin.add(commandPanel);
		fin.add(meassagePanel);
		fin.add(buttonPanel);
		frame.setVisible(true);
		frame.setSize(300, 300);
		frame.add(fin);
		frame.pack();
		setInvite1(fromtxt, totxt);
		opencon();
		send.addActionListener(new ActionListener() {		//	Send button when pressed sends 0 to accept and 0 to decline and opens a popup windows to inform you that you have sent an invitation

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(wheretxt.getText()=="" || whentxt.getText()=="" || whytxt.getText()=="" || ppm.getText().equals("") ){
					JOptionPane.showMessageDialog(null, " Please fill all fields");}
				else{
				try {
					st.executeUpdate("insert into Invite VALUES ("
							+ id1 + ","		// - change id to login id of current user
							+ id2 + ",'"		// - change to id of person u r inviting
							+ wheretxt.getText() + "','" 
							+ whentxt.getText() + "','" 
							+ whytxt.getText() + "','"
							+ ppm.getText() + "','"
							+ 0 + "',"
							+ 0 + ")");
//					rs=st.executeQuery("SELECT Email From Student Where Student_ID= "+id2);
//					while(rs.next()){
//						email=rs.getString("Email");
//					}
//					EmailSender.sendMail("someone@gmail.com", 
//							"PASS", 
//							"You have recieved an invitation", 
//							email);
					JOptionPane.showMessageDialog(null, " Invitation Sent " );
					frame.dispose();		// 
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Already Invited");
					frame.dispose();
					return;
				}
			}}
		});

	cancel.addActionListener(new ActionListener() {		//	Cancel button when pressed closes the sendInvite frame
		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);		 // 
		}
	});
	}
	
//	public void invite() throws Exception {
//		opencon();
//	}
	
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

	  	  public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
	  	    if (str == null)
	  	      return;

	  	    if ((getLength() + str.length()) <= limit) {
	  	      super.insertString(offset, str, attr);
	  	    }
	  	  }
	}



	public void setInvite1(JTextField fromtxt, JTextField totxt)
			throws Exception {
		opencon();
		try {
			 id1=FunctionsForMainScreen.getStudentID();
			rs = st.executeQuery("SELECT * FROM Student WHERE Student_ID = "+id1);	// - change id to login id of current user
		} catch (SQLException e) {
			e.printStackTrace();
		}
		while (rs.next()) {
			fromtxt.setText(rs.getString("First_Name"));
		}
		try {
			id2=ResPane.id;
			rs = st.executeQuery("SELECT * FROM Student WHERE Student_ID="+id2);// - change to id of person u r inviting
		} catch (SQLException e) {
			e.printStackTrace();
		}
		while (rs.next()) {
			totxt.setText(rs.getString("First_Name") + " " + rs.getString("Last_Name"));
		}
	}
}
