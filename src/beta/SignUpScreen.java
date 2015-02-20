package gu.se.project.beta;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.*;
import javax.swing.text.PlainDocument;

import com.toedter.calendar.JDateChooser;

/**
 * 
 * SignUpScreen.java
 * Purpose: Sign Up screen.
 *
 * @author Omar 
 * @version 1.0 
 */

public class SignUpScreen extends JFrame {
	FunctionsForMainScreen func = new FunctionsForMainScreen();
	MainScreen main = new MainScreen();
	JLabel firstName;
	JTextField fName;
	JLabel lastName;
	JTextField lName;
	JLabel email;
	JTextField emailF;
	JLabel password;
	JPasswordField passwordF;
	JLabel birthday;
	JTextField birthdayF;
	JLabel gender;
	// JTextField genderF;
	JButton signUp;
	JRadioButton male;
	JRadioButton female;
	ButtonGroup group ;
	JPanel panel1;
	JPanel panel2;
	JPanel panel3;
	JPanel panel4;
	JPanel panel5;
	JPanel panel6;
	JPanel panel7;
	JFrame sign;
	JDateChooser dateChooser = new JDateChooser();
	/**
     * Method that creates the window,panels and labels for signUp screen.
     *
     * 
     */
	public void SignUp() {

		dateChooser.setVisible(true);
		sign = new JFrame("SignUp Page");
		sign.setLayout(new GridLayout(7, 2, 4, 4));
		sign.setLocationRelativeTo(null);
		sign.setDefaultCloseOperation(EXIT_ON_CLOSE);

		sign.setVisible(true);
		sign.setSize(500, 500);

		firstName = new JLabel("First Name ");
		fName = new JTextField(10);
		fName.setDocument(new LimitCharactersInput(15));
		panel1 = new JPanel();
		panel1.add(firstName);
		panel1.add(fName);

		lastName = new JLabel("Last Name ");
		lName = new JTextField(10);
		lName.setDocument(new LimitCharactersInput(15));
		panel2 = new JPanel();
		panel2.add(lastName);
		panel2.add(lName);
		
		email = new JLabel("Email ");
		emailF = new JTextField(15);
		emailF.setDocument(new LimitCharactersInput(30));
		panel3 = new JPanel();
		panel3.add(email);
		panel3.add(emailF);
		
		password = new JLabel("Password ");
		passwordF = new JPasswordField(10);
		passwordF.setDocument(new LimitCharactersInput(15));
		panel4 = new JPanel();
		panel4.add(password);
		panel4.add(passwordF);
		
		birthday = new JLabel("Birthday");
		panel5 = new JPanel();
		panel5.add(birthday);
		panel5.add(dateChooser);
		dateChooser.setDateFormatString("yyyy-MM-dd");

		
		gender = new JLabel("Gender");
		male = new JRadioButton("Male");
		female = new JRadioButton("Female");
		signUp = new JButton("Sign Up!");
		panel6 = new JPanel();
		panel6.add(gender);
		group = new ButtonGroup();
		group.add(male);
		group.add(female);
		panel6.add(male);
		panel6.add(female);
		panel7 = new JPanel();
		panel7.add(signUp);

		sign.add(panel1);
		sign.add(panel2);
		sign.add(panel3);
		sign.add(panel4);
		sign.add(panel5);
		sign.add(panel6);
		sign.add(panel7);
		sign.pack();

		try {
			buttonFunctions();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
     * Method that contains the actionListener for SignUp button.
     *
     * 
     */
	public void buttonFunctions() throws Exception {

		
		signUp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");//format date

				String first = "";
				String last = "";
				String email = "";
				String pass = "";
				String birth = "";
				String gender="";
				char[] input = passwordF.getPassword();
				String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
				try {
					birth = df.format(dateChooser.getDate());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,
							"Please choose birthday");
				}
				
				if (male.isSelected() == true) {
					 gender = "Male";
				} else if (female.isSelected() == true) {
					 gender = "Female";
				}
				
				if (fName.getText().matches("^[\\p{L} .'-]+$"))//check if name contains only letters
					first = fName.getText();
				else if(!fName.getText().matches("^[\\p{L} .'-]+$") && !fName.getText().trim().isEmpty())  {
					JOptionPane.showMessageDialog(null,
							"Only letters Allowed in First Name");
					fName.setText("");
				}
				if (lName.getText().matches("^[\\p{L} .'-]+$"))//check if name contains only letters
					last = lName.getText();
				// System.out.println(last + "Last");
				else if(!lName.getText().matches("^[\\p{L} .'-]+$") && !lName.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null,
							"Only letters Allowed in Last Name");
					lName.setText("");
				}
				if (emailF.getText().contains("@student.gu.se") && emailF.getText().matches(EMAIL_REGEX) ){
					//check if email is a student email and correctly formated	
					email = emailF.getText();
}
				else if(!emailF.getText().contains("@student.gu.se") && !emailF.getText().matches(EMAIL_REGEX) || !emailF.getText().trim().isEmpty() )  {
					JOptionPane.showMessageDialog(null,
							"Please enter your student email ");
					emailF.setText("");
				}
				
					for (int i = 0; i < input.length; i++) {
						pass += input[i];
					}
				
					
				if (!first.equals("") && !last.equals("") && !email.equals("")
						&& !pass.equals("") && !gender.equals("")
						&& !birth.equals("")) {
					try {
						if (func.checkEmailAlreadyExists(email) == false) {//chech if email already exists 

							func.signUp(first, last, email, pass, birth, gender);//sign up
							try {
								func.generateActivationCode(email);//generate code
							} catch (Exception e2) {
								e2.printStackTrace();
							}
							JOptionPane.showMessageDialog(null,
									"Registered Successfully");
							sign.dispose();
							main.initial();
						} else if (func.checkEmailAlreadyExists(email) == true)//if email already exists then message appeared
							JOptionPane.showMessageDialog(null,
									"Email Already Exists");
					} catch (Exception e1) {
						e1.printStackTrace();

					}
				}
				else{
				//	System.out.println(email + " Email ");
					JOptionPane.showMessageDialog(null, "Please fill all fields ");
					return;
				}

			}
		});
	}

	
}
