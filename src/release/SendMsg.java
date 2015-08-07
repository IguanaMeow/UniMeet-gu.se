

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import net.miginfocom.swing.MigLayout;

/**
 * 
 * SendMsg.java Purpose: Contains the functions used in retrieving the messages
 * and notifying the logged in user if he has messages.
 * 
 * @author Omar
 * @version 1.0
 */
public class SendMsg extends JPanel {
	static PreparedStatement stmt = null;
	static ResultSet res = null;
	static Connection con = null;
	static int[] id;
	int numOfMsgs = 0;
	String[] msgs;
	String[] name;
	JPanel[] panel;
	JLabel[] label;
	JTextArea[] messageToSend;
	JPanel panelForSend;
	JLabel senderName;
	JButton send;
	static JFrame window;
	JTextArea msgToBeSend;
	JPanel panel1;
	JScrollPane scrollPane;
	JButton refresh;

	public static void opencon() throws Exception {// used to connect to
													// database

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		// Connection con = null;
		con = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/guproject","USER","PASS");
		// stmt = con.createStatement();
	}

	/**
	 * Method used to retrieve the messages from database with the name of
	 * sender/receiver
	 * 
	 * 
	 */
	public void sendMsg() {
		try {
			opencon();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			// this query is used to count the number of rows and then assign it
			// to the array
			// holding the name and another array containing the messages
			// messages
			String msgQuery = " SELECT  Student.First_Name,Message.Message,Student.Last_Name From Message,Student where ((Message.Tuser="
					+ MessageListener.x
					+ " and Message.Fuser="
					+ FunctionsForMainScreen.getStudentID()
					+ ") or (Message.Fuser="
					+ MessageListener.x
					+ " and Message.Tuser="
					+ FunctionsForMainScreen.getStudentID()
					+ ")) and (Message.Fuser=Student.Student_ID) ORDER BY Time  ASC";

			stmt = con.prepareStatement(msgQuery);
			res = stmt.executeQuery();

			int i = 0;
			while (res.next()) {
				numOfMsgs = res.getRow();

			}

			name = new String[numOfMsgs];
			msgs = new String[numOfMsgs];
			// this query gets the messages between the logged in user
			// and the user selected in the messages window
			String msgQuery1 = " SELECT  Student.First_Name,Message.Message,Student.Last_Name From Message,Student where ((Message.Tuser="
					+ MessageListener.x
					+ " and Message.Fuser="
					+ FunctionsForMainScreen.getStudentID()
					+ ") or (Message.Fuser="
					+ MessageListener.x
					+ " and Message.Tuser="
					+ FunctionsForMainScreen.getStudentID()
					+ ")) and (Message.Fuser=Student.Student_ID) ORDER BY Time  ASC";
			stmt = con.prepareStatement(msgQuery1);
			res = stmt.executeQuery();
			while (res.next()) {
				name[i] = res.getString("Student.First_Name") + " "
						+ res.getString("Student.Last_Name");
				msgs[i] = res.getString("Message.Message");
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {// closing the resultSet,PreparedStatements and connection
			if (res != null) {
				try {
					res.close();
				} catch (Exception excp) {

				}
			}
			if (stmt != null) {
				try {
					stmt.close();
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

	/**
	 * a constructor where the panel and labels are created then the messages
	 * retrieved are shown
	 * 
	 * 
	 */
	public SendMsg() {
		sendMsg();

		panel = new JPanel[numOfMsgs + 1];
		messageToSend = new JTextArea[numOfMsgs + 1];
		label = new JLabel[numOfMsgs + 1];
		panel1 = new JPanel();
		for (int i = 0; i < numOfMsgs; i++) {

			panel[i] = new JPanel();
			label[i] = new JLabel();
			label[i].setText(name[i]);

			messageToSend[i] = new JTextArea(3, 10);

			messageToSend[i].setLineWrap(true);
			messageToSend[i].setBorder(BorderFactory
					.createLineBorder(Color.BLUE));

			messageToSend[i].setText(msgs[i]);

			messageToSend[i].setEditable(false);
			messageToSend[i].setBackground(null);

			panel1.add(label[i]);
			panel1.add(messageToSend[i]);

		}
		panel1.setLayout(new GridLayout(numOfMsgs, 1, 0, 1));

		// ** migLayout
		setLayout(new MigLayout("wrap 2"));

		scrollPane = new JScrollPane(panel1,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setPreferredSize(new Dimension(400, 400));
		if (numOfMsgs > 0)
			add(scrollPane, "span 2");

		msgToBeSend = new JTextArea();
		send = new JButton("Send");
		refresh = new JButton("Refresh");
		msgToBeSend = new JTextArea(10, 30);
		msgToBeSend.setLineWrap(true);
		msgToBeSend.setWrapStyleWord(true);

		add(new JScrollPane(msgToBeSend), "span 2");
		add(send);
		add(refresh);
		refresh.addActionListener(new ActionListener() {// closes the sendMsg
														// window and re-open it
														// with updated the
														// msgStatus

			@Override
			public void actionPerformed(ActionEvent e) {
				window.dispose();

				try {

					// notifyUser();
					changeMsgStatus();

					SendMsg.screen();

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		send.addActionListener(new ActionListener() {// when send button is
														// pressed that message
														// is inserted into the
														// database

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					opencon();
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				DateFormat dateFormat = new SimpleDateFormat(
						"yyyy/MM/dd HH:mm:ss");
				Date date = new Date();

				int from = FunctionsForMainScreen.getStudentID();
				int to = MessageListener.x;
				String msg = msgToBeSend.getText();
				try {
					String query = "INSERT INTO Message (Fuser,Tuser,Message,Time) Values (?,?,?,?)";
					stmt = con.prepareStatement(query);
					stmt.setInt(1, from);
					stmt.setInt(2, to);
					stmt.setString(3, msg);
					stmt.setString(4, dateFormat.format(date));
					stmt.executeUpdate();
					SendMsg.window.dispose();
					try {
						SendMsg.screen();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					if (stmt != null) {
						try {
							stmt.close();
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
		});
	}

	/**
	 * Method to update the message Status to 1 which means Read
	 * 
	 */
	public static void changeMsgStatus() {
		try {
			opencon();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			String query = "Update Message Set Message.Read=1 Where Message.Tuser="
					+ FunctionsForMainScreen.getStudentID();
			stmt = con.prepareStatement(query);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
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

	/**
	 * Method used to notify the user if he has unread messages
	 * 
	 */
	public static void notifyUser() {

		try {
			opencon();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			String query = "SELECT DISTINCT Fuser From Message Where Tuser= "
					+ FunctionsForMainScreen.getStudentID()
					+ " and Message.Read='0'";// count the rows of the unread
												// messages
			stmt = con.prepareStatement(query);
			res = stmt.executeQuery();
			int numOfRows = 0;
			while (res.next()) {

				numOfRows = res.getRow();
			}
			id = new int[numOfRows];
			String query1 = "SELECT DISTINCT Fuser From Message Where Tuser= "
					+ FunctionsForMainScreen.getStudentID()
					+ " and Message.Read='0'";// selected the user id of the
												// unread messages
			stmt = con.prepareStatement(query1);
			res = stmt.executeQuery();
			int i = 0;
			while (res.next()) {

				id[i] = res.getInt("Fuser");
				HomePage.messages.setBackground(Color.yellow);
				i++;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
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

	public static void screen() throws Exception {// the GUI of SendMsg

		window = new JFrame("Messages");

		window.setSize(400, 500);

		window.setContentPane(new SendMsg());

		window.setVisible(true);
		// window.pack();

		// window.pack();

	}
	// public static void main(String[] args) {
	// try {
	// screen();
	// } catch (Exception e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }

}
