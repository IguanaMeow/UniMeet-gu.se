

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

/**
 * 
 * Invitation.java Purpose: Shows the invitation send and received.
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
	// int[] decline;
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
				+ FunctionsForMainScreen.getStudentID() + " AND Declined = 0");// select
																				// invitations
		// the logged in user has received
		int a = 0;
		while (res.next()) {

			fUser[a] = res.getInt("Fuser");

			a++;

		}
		fNameReceiving = new String[rowNumForReceiving];
		lNameReceiving = new String[rowNumForReceiving];
		for (int i = 0; i < fUser.length; i++) {
			res = stmt.executeQuery("SELECT * FROM Student WHERE Student_ID = "
					+ fUser[i]);// get the name of the sender of invitaitons

			while (res.next()) {

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

		res = stmt
				.executeQuery("SELECT Tuser,Accepted,Declined FROM Invite WHERE Fuser="
						+ FunctionsForMainScreen.getStudentID());// select the
																	// status of
																	// the
																	// invitations
		// the user have sent
		while (res.next()) {

			tUser[x] = res.getInt("Tuser");
			accepted[x] = res.getInt("Accepted");

			x++;
		}
		fNameSending = new String[rowNumForSending];
		lNameSending = new String[rowNumForSending];
		for (int i = 0; i < rowNumForSending; i++) {
			res = stmt.executeQuery("SELECT * FROM Student WHERE Student_ID = "
					+ tUser[i]);// get the name of the people invited by the
								// user
			while (res.next()) {
				String b;
				fNameSending[i] = res.getString("First_Name");
				lNameSending[i] = res.getString("Last_Name");

			}
		}

	}

	/**
	 * 
	 * Constructor that has the design of the panels and labels of invitations
	 * 
	 * 
	 */
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

		setLayout(new MigLayout("wrap 1, gapy 5", "0![][]0!"));

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
			fieldsForReceive[i].setBackground(null);
			fieldsForReceive[i].setFont(new Font("Helvetica", Font.ITALIC, 13));
			fieldsForReceive[i].setForeground(Color.DARK_GRAY);
			fieldsForReceive[i].setEditable(false);
			fieldsForReceive[i].setText(fNameReceiving[i] + " "
					+ lNameReceiving[i]);
			showInvitation[i] = new JButton("Show");
			showInvitation[i].setActionCommand(String.valueOf(fUser[i]));
			showInvitation[i].addActionListener(myListener);

			panelsForReceive[i].add(fieldsForReceive[i]);
			panelsForReceive[i].add(showInvitation[i]);
			index += i;
		}

		int x = 0;
		for (int i = 0; i < rowNumForSending; i++) {
			panelsForSend[i] = new JPanel(new MigLayout("wrap 2, gapy 2!"));
			fieldsForSend[i] = new JTextField(13);
			fieldsForSend[i].setEditable(false);
			fieldsForSend[i].setBackground(null);
			fieldsForSend[i].setFont(new Font("Helvetica", Font.ITALIC, 13));
			fieldsForSend[i].setForeground(Color.DARK_GRAY);
			fieldsForSend[i].setText(fNameSending[i] + " " + lNameSending[i]);
			invitationStatus[i] = new JLabel("Status:");

			if (accepted[i] == 1) {

				status[i] = new JTextField(10);
				status[i].setEditable(false);
				status[i].setText("Accepted");
				status[i].setBackground(null);

			}

			else {

				status[i] = new JTextField(10);
				status[i].setEditable(false);
				status[i].setText("Not Decided");
				status[i].setBackground(null);
			}
			panelsForSend[i].add(fieldsForSend[i], "span 2, align left");
			panelsForSend[i].add(invitationStatus[i], "align left");
			panelsForSend[i].add(status[i]);

			x++;
		}

		if (rowNumForReceiving > 0) {
			JPanel receiveP = new JPanel(new MigLayout("wrap 1"));
			receiveP.setBorder(BorderFactory
					.createTitledBorder("Received Invitations"));
			add(receiveP, "w 270!");
			for (int i = 0; i < rowNumForReceiving; i++) {

				receiveP.add(panelsForReceive[i]);

			}
		}
		if (rowNumForSending > 0) {
			JPanel sentP = new JPanel(new MigLayout("wrap 1"));
			sentP.setBorder(BorderFactory
					.createTitledBorder("Sent Invitations"));
			add(sentP, "w 270!");
			for (int i = 0; i < rowNumForSending; i++) {

				sentP.add(panelsForSend[i]);
			}
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
