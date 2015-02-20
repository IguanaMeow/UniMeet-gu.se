package gu.se.project.beta;

import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * TestNotify.java Purpose: Shows the invitation send and received.
 * 
 * @author Omar
 * @version 1.0
 */
public class Invitation extends JPanel {
	NotifyListener myListener = new NotifyListener();
	int rowNumForReceiving = 0;
	int rowNumForSending = 0;
	int[] fUser;
	int[] tUser;
	int[] accepted;
//	int[] decline;
	String fNameReceiving[];
	String lNameReceiving[];
	String fNameSending[];
	String lNameSending[];
	Statement stmt = null;
	ResultSet res = null;

	Connection con = null;
	String[] fromUsers;
	static JFrame window;
	public static JTextField[] fieldsForReceive;
	JLabel[] labelsForReceive;
	JPanel[] panelsForReceive;
	public static JButton[] showInvitation;
	JPanel[] panelsForSend;
	JLabel[] labelsForSend;
	JTextField[] fieldsForSend;
	JLabel[] invitationStatus;
	JTextField[] status;

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

	/**
	 * Method is used to get the invites which the logged in user has received
	 * and the status for the sent invitations.
	 * 
	 * @throws Exception
	 */
	public void fillFields() throws Exception {

		try {
			opencon();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		res = stmt.executeQuery("SELECT * FROM Invite WHERE Tuser = "
				+ FunctionsForMainScreen.getStudentID() + " AND Declined = 0");

		while (res.next()) {
			// System.out.println("rowNumForReceiving");
			rowNumForReceiving++;
		}
		fUser = new int[rowNumForReceiving];
		res = stmt.executeQuery("SELECT * FROM Invite WHERE Tuser= "
				+ FunctionsForMainScreen.getStudentID() + " AND Declined = 0");
		int a = 0;
		while (res.next()) {

			fUser[a] = res.getInt("Fuser");
			// System.out.println(fUser[a]);
			a++;

		}
		fNameReceiving = new String[rowNumForReceiving];
		lNameReceiving = new String[rowNumForReceiving];
		for (int i = 0; i < fUser.length; i++) {
			res = stmt.executeQuery("SELECT * FROM Student WHERE Student_ID = "
					+ fUser[i]);
			// System.out.println(fUser[i]+ "In for for res3");
			while (res.next()) {
				//String b;
				fNameReceiving[i] = res.getString("First_Name");
				lNameReceiving[i] = res.getString("Last_Name");

			}
		}
		res = stmt.executeQuery("SELECT COUNT(*) FROM Invite WHERE Fuser="
				+ FunctionsForMainScreen.getStudentID());
		int x = 0;
		while (res.next()) {
			rowNumForSending = res.getInt("COUNT(*)");

		}
		tUser = new int[rowNumForSending];
		accepted = new int[rowNumForSending];
		//decline = new int[rowNumForSending];
		res = stmt
				.executeQuery("SELECT Tuser,Accepted,Declined FROM Invite WHERE Fuser="
						+ FunctionsForMainScreen.getStudentID());
		while (res.next()) {

			tUser[x] = res.getInt("Tuser");
			accepted[x] = res.getInt("Accepted");
			//decline[x] = res.getInt("Declined");
			x++;
		}
		fNameSending = new String[rowNumForSending];
		lNameSending = new String[rowNumForSending];
		for (int i = 0; i < rowNumForSending; i++) {
			res = stmt.executeQuery("SELECT * FROM Student WHERE Student_ID = "
					+ tUser[i]);
			while (res.next()) {
				String b;
				fNameSending[i] = res.getString("First_Name");
				lNameSending[i] = res.getString("Last_Name");
				// System.out.println(lNameSending[i] + "   LNAMESENDING");
			}
		}
		// for (int i = 0; i < tUser.length; i++) {
		// System.out.println(tUser[i]);
		// }

	}

	public Invitation() {
		int index = 0;

		try {
			fillFields();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println(rowNumForSending + " row Num for send");

		panelsForReceive = new JPanel[rowNumForReceiving + 1];
		labelsForReceive = new JLabel[rowNumForReceiving + 1];
		fieldsForReceive = new JTextField[rowNumForReceiving + 1];
		showInvitation = new JButton[rowNumForReceiving + 1];
		panelsForSend = new JPanel[rowNumForSending + 1];
		labelsForSend = new JLabel[rowNumForSending + 1];
		fieldsForSend = new JTextField[rowNumForSending + 1];
		invitationStatus = new JLabel[rowNumForSending + 1];
		status = new JTextField[rowNumForSending + 1];
		
		setLayout(new GridLayout(rowNumForReceiving + rowNumForSending, 1, 4, 4));
		// System.out.println(rowNum);
		if (rowNumForReceiving == 0 && rowNumForSending == 0) {
			panelsForReceive[0] = new JPanel();
			labelsForReceive[0] = new JLabel("No Invitations Send or Received");
			panelsForReceive[0].add(labelsForReceive[0]);
			add(panelsForReceive[0]);
		}
		for (int i = 0; i < rowNumForReceiving; i++) {
			panelsForReceive[i] = new JPanel();
			labelsForReceive[i] = new JLabel("Name");
			fieldsForReceive[i] = new JTextField(10);
			fieldsForReceive[i].setEditable(false);
			fieldsForReceive[i].setText(fNameReceiving[i] + " "
					+ lNameReceiving[i]);
			showInvitation[i] = new JButton("Show");
			showInvitation[i].setActionCommand(String.valueOf(fUser[i]));
			showInvitation[i].addActionListener(myListener);
			panelsForReceive[i].add(labelsForReceive[i]);
			panelsForReceive[i].add(fieldsForReceive[i]);
			panelsForReceive[i].add(showInvitation[i]);
			index += i;
		}

		int x = 0;
		for (int i = 0; i < rowNumForSending; i++) {
			panelsForSend[i] = new JPanel();
			labelsForSend[i] = new JLabel("Name");
			fieldsForSend[i] = new JTextField(10);
			fieldsForSend[i].setEditable(false);
			fieldsForSend[i].setText(fNameSending[i] + " " + lNameSending[i]);
			invitationStatus[i] = new JLabel("Status:");
			
			if (accepted[i] == 1) {
				
				status[i] = new JTextField(10);
				status[i].setEditable(false);
				status[i].setText("Accepted");
				status[i].setBackground(null);
				

	} 
				//else if (decline[i] == 1) {
//				status[i] = new JTextField(10);
//				status[i].setEditable(false);
//				status[i].setText("Declined");
//				status[i].setBackground(null);
//			} 
				else {
					
				status[i] = new JTextField(10);
				status[i].setEditable(false);
				status[i].setText("Not Decided");
				status[i].setBackground(null);
			}
			panelsForSend[i].add(labelsForSend[i]);
			panelsForSend[i].add(fieldsForSend[i]);
			panelsForSend[i].add(invitationStatus[i]);
			panelsForSend[i].add(status[i]);
			
			x++;
		}

		for (int i = 0; i < rowNumForReceiving; i++) {
			add(panelsForReceive[i]);

		}

		for (int i = 0; i < rowNumForSending; i++) {
			add(panelsForSend[i]);
		}

	}

	public static void screen() throws Exception {
		window = new JFrame("Invitations");
		window.setSize(700, 700);

		window.setContentPane(new Invitation());

		window.setVisible(true);

		window.pack();

	}

}
