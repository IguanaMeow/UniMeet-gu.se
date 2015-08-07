

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

/**
 * 
 * Message.java Purpose: Contains the method used to get the accepted
 * invitations sent/received and contains the panels that has the name of other
 * users .
 * 
 * @author Omar
 * @version 1.0
 */
public class Message extends JPanel {
	MessageListener msg = new MessageListener();
	Statement stmt = null;
	ResultSet res = null;

	Connection con = null;
	int[] fUser;
	int[] tUser;
	int numOfUser = 0;
	int numToUser = 0;
	String[] fName;
	String[] tName;
	JTextField[] name;
	static JButton message;
	JPanel[] panel;

	public static JFrame window;

	public void opencon() throws Exception {// connect to database

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		Connection con = null;
		con = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/guproject","USER","PASS");
		stmt = con.createStatement();
	}

	/**
	 * method is used to retrieve the users who have accepted the logged in user
	 * invitation or the user whom the logged in user has accepted their
	 * invitation
	 * 
	 * 
	 */

	public void message() {
		try {
			opencon();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			res = stmt.executeQuery("SELECT COUNT(*) From Invite Where Tuser= "
					+ FunctionsForMainScreen.getStudentID()
					+ " AND Accepted =1");
			while (res.next()) {
				numOfUser = res.getInt("COUNT(*)");
			}
			res = stmt.executeQuery("SELECT COUNT(*) From Invite Where Fuser= "
					+ FunctionsForMainScreen.getStudentID()
					+ " AND Accepted =1");
			while (res.next()) {
				numToUser = res.getInt("COUNT(*)");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fUser = new int[numOfUser];
		fName = new String[numOfUser];
		tUser = new int[numToUser];
		tName = new String[numToUser];

		try {
			res = stmt
					.executeQuery("SELECT * From Invite Where Tuser="
							+ FunctionsForMainScreen.getStudentID()
							+ " AND Accepted=1");// accepted invitation by
													// logged in user
			int i = 0;
			while (res.next()) {
				fUser[i] = res.getInt("Fuser");
				i++;
			}
			res = stmt
					.executeQuery("SELECT * From Invite Where Fuser="
							+ FunctionsForMainScreen.getStudentID()
							+ " AND Accepted=1");// accepted invitations sent by
													// logged in user
			int a = 0;
			while (res.next()) {
				tUser[a] = res.getInt("Tuser");
				a++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int x = 0; x < fUser.length; x++) {
			try {
				res = stmt
						.executeQuery("SELECT * From Student Where Student_ID="
								+ fUser[x]);
				while (res.next()) {
					fName[x] = res.getString("First_Name") + " "
							+ res.getString("Last_Name");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		for (int z = 0; z < tUser.length; z++) {
			try {
				res = stmt
						.executeQuery("SELECT * From Student Where Student_ID="
								+ tUser[z]);
				while (res.next()) {
					tName[z] = res.getString("First_Name") + " "
							+ res.getString("Last_Name");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/**
	 * this constructor is used to display the users retrieved from the database
	 * 
	 * 
	 */
	public Message() {//
		try {
			message();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setLayout(new GridLayout(numOfUser + numToUser, 1));
		name = new JTextField[numOfUser + numToUser + 1];

		panel = new JPanel[numOfUser + numToUser + 1];
		int index = 0;
		int z = 0;
		if (numOfUser == 0 && numToUser == 0) {
			panel[0] = new JPanel();
			JLabel label = new JLabel("No Messages");
			panel[0].add(label);
			add(panel[0]);
		}
		for (int i = 0; i < numOfUser; i++) {
			message = new JButton("Show");
			panel[i] = new JPanel();
			name[i] = new JTextField(15);
			name[i].setText(fName[i]);
			name[i].setEditable(false);
			message.setBackground(null);
			if (SendMsg.id.length > 0) {
				if (SendMsg.id[z] == fUser[i]) {

					message.setBackground(Color.yellow);// the color of the
														// button is changing if
														// he has a message
					if (z < SendMsg.id.length - 1)
						z++;
				}
			}

			message.addActionListener(msg);

			message.setActionCommand(String.valueOf(fUser[i]));
			panel[i].add(name[i]);

			panel[i].add(message);
			add(panel[i]);
			index++;
		}

		int x = 0;
		int y = 0;
		for (int b = index; b < numToUser + numOfUser; b++) {
			message = new JButton("Show");
			panel[b] = new JPanel();
			name[b] = new JTextField(12);
			name[b].setText(tName[x]);
			name[b].setEditable(false);

			if (SendMsg.id.length > 0) {
				if (SendMsg.id[y] == tUser[x]) {

					message.setBackground(Color.yellow);
					if (y < SendMsg.id.length - 1)
						y++;
				}
			}

			message.addActionListener(msg);

			message.setActionCommand(String.valueOf(tUser[x]));
			panel[b].add(name[b]);

			panel[b].add(message);
			x++;
			add(panel[b]);
		}

	}

	public static void screen() throws Exception {

		window = new JFrame("Message");
		window.setSize(700, 700);

		window.setContentPane(new Message());

		window.setVisible(true);

	}

}
