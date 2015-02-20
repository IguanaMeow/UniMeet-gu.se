package gu.se.project.beta;

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

	public void opencon() throws Exception {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		Connection con = null;
		con = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:8080/guproject","USER","PASS");
		stmt = con.createStatement();
	}
	

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
							+ " AND Accepted=1");
			int i = 0;
			while (res.next()) {
				fUser[i] = res.getInt("Fuser");
				i++;
			}
			res = stmt
					.executeQuery("SELECT * From Invite Where Fuser="
							+ FunctionsForMainScreen.getStudentID()
							+ " AND Accepted=1");
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
	

	public Message() {
		try {
			message();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setLayout(new GridLayout(numOfUser + numToUser, 1));
		name = new JTextField[numOfUser + numToUser + 1];
	//	message = new JButton[numOfUser + numToUser + 1];
		
		panel = new JPanel[numOfUser + numToUser + 1];
		int index = 0;
		int z=0;
		for (int i = 0; i < numOfUser; i++) {
			message=new JButton("Show");
			panel[i] = new JPanel();
			name[i] = new JTextField(20);
			name[i].setText(fName[i]);
			name[i].setEditable(false);
			//message[i] = new JButton("Message");
			if(SendMsg.id.length>0){
			if(SendMsg.id[z]==fUser[i]){
		
				//message[i].setBackground(Color.yellow);
				message.setBackground(Color.yellow);
				if(z<SendMsg.id.length-1)
				z++;
				}}
			//message[i].addActionListener(msg);
			message.addActionListener(msg);
			//message[i].setActionCommand(String.valueOf(fUser[i]));
			message.setActionCommand(String.valueOf(fUser[i]));
			panel[i].add(name[i]);
			//panel[i].add(message[i]);
			panel[i].add(message);
			add(panel[i]);
			index++;
		}

		int x = 0;
		int y=0;
		for (int b = index; b < numToUser + numOfUser; b++) {
			message=new JButton("Show");
			panel[b] = new JPanel();
			name[b] = new JTextField(20);
			name[b].setText(tName[x]);
			name[b].setEditable(false);
			//message[b] = new JButton("Message");
			if(SendMsg.id.length>0){
			if(SendMsg.id[y]==tUser[x]){
			
				//message[b].setBackground(Color.yellow);
				message.setBackground(Color.yellow);
				if(y<SendMsg.id.length-1)
				y++;
				}}
			//message[b].addActionListener(msg);
			message.addActionListener(msg);
			//message[b].setActionCommand(String.valueOf(tUser[x]));
			message.setActionCommand(String.valueOf(tUser[x]));
			panel[b].add(name[b]);
			//panel[b].add(message[b]);
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

		window.pack();

	}
	// public static void main(String[] args) {
	// try {
	//
	// } catch (Exception e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
}
