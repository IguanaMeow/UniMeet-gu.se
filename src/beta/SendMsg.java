package gu.se.project.beta;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class SendMsg extends JPanel {
	static Statement stmt = null;
	static ResultSet res = null;
	Connection con = null;
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
	public static void opencon() throws Exception {

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

	public void sendMsg() {
		try {
			opencon();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			
			res = stmt
					.executeQuery(" SELECT  Student.First_Name,Message.Message,Student.Last_Name From Message,Student where ((Message.Tuser="
							+ MessageListener.x
							+ " and Message.Fuser="
							+ FunctionsForMainScreen.getStudentID()
							+ ") or (Message.Fuser="
							+ MessageListener.x
							+ " and Message.Tuser="
							+ FunctionsForMainScreen.getStudentID()
							+ ")) and (Message.Fuser=Student.Student_ID) ORDER BY Time  ASC");

			int i = 0;
			while (res.next()) {
				numOfMsgs = res.getRow();

			}
			name = new String[numOfMsgs];
			msgs = new String[numOfMsgs];
			res = stmt
					.executeQuery(" SELECT  Student.First_Name,Message.Message,Student.Last_Name From Message,Student where ((Message.Tuser="
							+ MessageListener.x
							+ " and Message.Fuser="
							+ FunctionsForMainScreen.getStudentID()
							+ ") or (Message.Fuser="
							+ MessageListener.x
							+ " and Message.Tuser="
							+ FunctionsForMainScreen.getStudentID()
							+ ")) and (Message.Fuser=Student.Student_ID) ORDER BY Time  ASC");
			while (res.next()) {
				name[i] = res.getString("Student.First_Name") + " "
						+ res.getString("Student.Last_Name");
				msgs[i] = res.getString("Message.Message");
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public SendMsg() {
		sendMsg();
		//setLayout(new GridLayout(, 1));
		panel = new JPanel[numOfMsgs + 1];
		messageToSend = new JTextArea[numOfMsgs + 1];
		label = new JLabel[numOfMsgs + 1];
		panel1=new JPanel();
		for (int i = 0; i < numOfMsgs; i++) {
			
			panel[i] = new JPanel();
			label[i] = new JLabel();
			label[i].setText(name[i]);
			messageToSend[i] = new JTextArea();
			messageToSend[i].setText(msgs[i]);
			//System.out.println(msgs[i]);
			messageToSend[i].setEditable(false);
			messageToSend[i].setBackground(null);
			panel[i].add(label[i]);
			panel[i].add(messageToSend[i]);
		//add(panel[i]);
		panel1.add(panel[i]);	
			
			
			
		}
		panel1.setLayout(new GridLayout(numOfMsgs+1, 1));

		scrollPane = new JScrollPane(panel1, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setPreferredSize(new Dimension(200, 200));
		if(numOfMsgs>0)
		add(scrollPane);
		 
		panelForSend = new JPanel();
		msgToBeSend = new JTextArea();
		send = new JButton("Send");
		refresh=new JButton("Refresh");
		msgToBeSend = new JTextArea(2, 10);
		msgToBeSend.setLineWrap(true);
		msgToBeSend.setWrapStyleWord(true);
		panelForSend.add(new JScrollPane(msgToBeSend));
		panelForSend.add(send);
		panelForSend.add(refresh);
		add(panelForSend);
		refresh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				window.dispose();
				Message.window.dispose();
				try {
					
					notifyUser();
					changeMsgStatus();
					//Message.screen();
					SendMsg.screen();
				
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		send.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DateFormat dateFormat = new SimpleDateFormat(
						"yyyy/MM/dd HH:mm:ss");
				Date date = new Date();
				int from = FunctionsForMainScreen.getStudentID();
				int to = MessageListener.x;
				String msg = msgToBeSend.getText();
				try {
					stmt.executeUpdate("INSERT INTO Message (Fuser,Tuser,Message,Time) Values ("
							+ from
							+ ", "
							+ to
							+ ",'"
							+ msg
							+ "','"
							+ dateFormat.format(date) + "')");
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
				}

			}
		});
	}

	public static void changeMsgStatus() {
		try {
			opencon();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.executeUpdate("Update Message Set Message.Read=1 Where Message.Tuser="
					+ FunctionsForMainScreen.getStudentID() );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void notifyUser() {
		

		try {
			opencon();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			res = stmt
					.executeQuery("SELECT DISTINCT Fuser From Message Where Tuser= "
							+ FunctionsForMainScreen.getStudentID()
							+ " and Message.Read='0'");
			int numOfRows = 0;
			while (res.next()) {
			
				numOfRows = res.getRow();
			}
			id = new int[numOfRows];
			res = stmt
					.executeQuery("SELECT DISTINCT Fuser From Message Where Tuser= "
							+ FunctionsForMainScreen.getStudentID()
							+ " and Message.Read='0'");
			int i = 0;
			while (res.next()) {

				id[i] = res.getInt("Fuser");
				
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void screen() throws Exception {
		
		window = new JFrame("Messages");
		 
		window.setSize(400, 400);

		window.setContentPane(new SendMsg());

		window.setVisible(true);
window.addWindowListener(new WindowListener() {
	
	@Override
	public void windowOpened(WindowEvent e) {
		
		
	}
	
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		//System.out.println("hi");
		window.dispose();
		try {
			Message.screen();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	@Override
	public void windowClosed(WindowEvent e) {
		
		
	}
	
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
});
		window.pack();

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
