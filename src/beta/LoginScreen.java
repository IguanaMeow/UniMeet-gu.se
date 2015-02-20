package gu.se.project.beta;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;

import javax.swing.*;

/**
 * 
 * LoginScreen.java Purpose: Log In screen.
 * 
 * @author Omar
 * @version 1.0
 */
public class LoginScreen extends JFrame {
	FunctionsForMainScreen func = new FunctionsForMainScreen();
	JLabel email;
	public static JTextField emailF;
	JLabel pass;
	JPasswordField passF;
	JPanel panel1;
	JPanel panel2;
	JPanel panel3;
	JFrame login;
	JButton log;
	JButton cantAccess;

	/**
	 * Method to create the window,panels and labels
	 * 
	 */
	public void login() {
		login = new JFrame("Login");
		login.setLayout(new GridLayout(3, 1, 2, 2));
		login.setLocationRelativeTo(null);
		login.setDefaultCloseOperation(EXIT_ON_CLOSE);

		login.setVisible(true);
		login.setSize(300, 300);
		email = new JLabel("Email ");
		emailF = new JTextField(15);
		emailF.setDocument(new LimitCharactersInput(30));
		pass = new JLabel("Password ");
		passF = new JPasswordField(10);
		passF.setDocument(new LimitCharactersInput(15));
		panel1 = new JPanel();
		panel1.add(email);
		panel1.add(emailF);
		log = new JButton("Log in ");
		cantAccess = new JButton("Can't Access your Account ? ");
		cantAccess.setBorderPainted(false);
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel2.add(pass);
		panel2.add(passF);
		panel2.add(log);
		panel3.add(cantAccess);
		login.add(panel1);
		login.add(panel2);
		login.add(panel3);
		login.pack();

		buttonFunctions();
	}

	/**
	 * Method that includes the actionListener for Log In and Cant Access
	 * buttons.
	 * 
	 */
	public void buttonFunctions() {
		log.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String email = emailF.getText();

				char[] input = passF.getPassword();
				String password = "";
				for (int i = 0; i < input.length; i++) {
					password += input[i];
				}
				try {
					if (func.checkEmailAndPassword(email, password) == true) {// if
																				// email
																				// and
																				// password
						func.login(email, password);
						if (func.checkActivation(email) == true) {// if account
																	// not
																	// activated
																	// and
																	// password
																	// and email
																	// are true
																	// the
																	// student
																	// is
																	// directed
																	// to main
																	// page
							login.dispose();
							SendMsg.notifyUser();
							Search GUI = new Search();
							GUI.run();
						} else {
							JOptionPane.showMessageDialog(null,
									"Wrong Code Entered ");
						}
					} else {
						JOptionPane.showMessageDialog(null,
								"Please Check your Email or Password");
						return;

					}

				} catch (Exception e1) {

					e1.printStackTrace();
				}

			}
		});

		cantAccess.addActionListener(new ActionListener() {// if can't access
															// account

					@Override
					public void actionPerformed(ActionEvent e) {
						String email = JOptionPane
								.showInputDialog("Please enter your email");
						if(email==null)
							return;
						try {
							func.generateNewPassword(email);
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null,
									"Email doesn't Exist ! ");
							e1.printStackTrace();
						}

					}
				});
	}

}
