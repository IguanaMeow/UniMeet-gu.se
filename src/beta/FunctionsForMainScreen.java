package gu.se.project.beta;

import java.awt.Color;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

/**
 * 
 * FunctionsForMainScreen.java 
 * Purpose: All the functions used in Sign Up and Log In .
 * 
 * @author Omar
 * @version 1.0
 */
public class FunctionsForMainScreen {
	static int studentID = 0;

	Statement stmt = null;
	ResultSet res = null;
	Connection con = null;static int[] id;
	private SecureRandom random = new SecureRandom();

	/**
	 * Method to connect to database
	 * 
	 * @throws Exception
	 */

	public void opencon() throws Exception {// open connection
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
	 * Method to insert basic student information to database
	 * 
	 * @param first
	 *            Name
	 * @param last
	 *            Name
	 * @param Email
	 * @param Password
	 * @param Date
	 *            of birth
	 * @param Gender
	 */
	public void signUp(String first, String last, String email, String pass,
			String birth, String gender) {// register new user
		try {
			opencon();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String query = "INSERT INTO Student (First_Name,Last_Name,Email,Password,Birthday,Gender) VALUES ('"
				+ first
				+ "','"
				+ last
				+ "','"
				+ email
				+ "','"
				+ pass
				+ "','"
				+ birth + "','" + gender + "')";

		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Method to check if email exists
	 * 
	 * @param Email
	 * @return true if email exists
	 * @return false if email doesn't exists
	 * 
	 */
	public boolean checkEmailAlreadyExists(String email) throws Exception { // make
																			// sure
																			// email
																			// doesn't
																			// exist
																			// in
																			// database
		opencon();
		String checkEmail = "SELECT * From Student WHERE Email = '" + email
				+ "'";
		res = stmt.executeQuery(checkEmail);
		if (res.next()) {
			return true;
		} else
			return false;
	}

	/**
	 * Method to check if email and password are true
	 * 
	 * @param Email
	 * @param Password
	 * @return true if email and password correct
	 * @return false if email and password incorrect
	 * 
	 */
	public boolean checkEmailAndPassword(String email, String pass)
			throws Exception {// check if email and password entered are true
		opencon();
		String query = "SELECT Student_ID FROM Student WHERE ( Email= '"
				+ email + "' AND Password = '" + String.valueOf(pass) + "') ";
		res = stmt.executeQuery(query);
		while (res.next()) {
			return true;

		}
		return false;

	}

	/**
	 * Method to store the logged in Student ID
	 * 
	 * @param Email
	 * @param Password
	 * 
	 */
	public void login(String email, String pass) throws Exception {// perform
																	// log in
																	// operation
																	// and
																	// stores
																	// logged in
																	// user ID
		opencon();
		String query = "SELECT Student_ID FROM Student WHERE ( Email= '"
				+ email + "' AND Password = '" + String.valueOf(pass) + "') ";
		res = stmt.executeQuery(query);
		while (res.next()) {
			studentID = res.getInt("Student_Id");

		}

	}

	/**
	 * Method to generate random code
	 * 
	 * @return random code
	 * 
	 */
	public String nextSessionId() {// generate random code
		return new BigInteger(50, random).toString(32);
	}

	/**
	 * Method to generate new password if the student forgets password and
	 * updating the new password to database
	 * 
	 * @param Email
	 * 
	 */
	public void generateNewPassword(String email) {// generate new password if
													// user forgets his/her
													// password
		try {
			opencon();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String query = "SELECT * FROM Student WHERE Email = '" + email + "'";
		String newPass = null;

		try {
			res = stmt.executeQuery(query);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Email doesn't Exist ! ");

		}
		try {
			if (res.next()) {

				newPass = nextSessionId();

			} else {
				JOptionPane.showMessageDialog(null, "Email doesn't Exist ! ");
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String newPassQuery = "Update Student SET Password =  '" + newPass
				+ "' WHERE Email = '" + email + "'";
		try {
			stmt.executeUpdate(newPassQuery);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Method to generate activation code for new registered students
	 * 
	 * @param Email
	 * 
	 */
	public void generateActivationCode(String email) {// generate activation
														// code for everyone who
														// registers
		try {
			opencon();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String query = "SELECT * FROM Student WHERE Email = '" + email + "'";
		String newCode = null;
		try {
			res = stmt.executeQuery(query);

		} catch (SQLException e) {
			// JOptionPane.showMessageDialog(null, "Email doesn't Exist ! ");
			e.printStackTrace();
		}
		try {
			if (res.next()) {
				newCode = nextSessionId();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String newCodeQuery = "Update Student SET Code =  '" + newCode
				+ "' WHERE Email = '" + email + "'";
		try {
			stmt.executeUpdate(newCodeQuery);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Method to check if student account is activated or not.
	 * 
	 * @param Email
	 * @return true if code entered is correct or account is already activated
	 * @return false if code entered is incorrect
	 * 
	 */
	public boolean checkActivation(String email) throws SQLException {// check
																		// if
																		// account
																		// is
																		// activated
		int activation = 0;
		String emailAfterEnteringCode = null;
		boolean act = false;
		String getActivationStatus = "SELECT Activated From Student WHERE Email = '"
				+ email + "'";
		try {
			res = stmt.executeQuery(getActivationStatus);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (res.next()) {
				activation = res.getInt("Activated");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (activation == 0) {
			String code = JOptionPane
					.showInputDialog("Please enter Activation code ");
			if (code != null) {
				String getEmailQuery = "SELECT Email From Student WHERE Code = '"
						+ code + "'";
				res = stmt.executeQuery(getEmailQuery);
				if (res.next()) {
					emailAfterEnteringCode = res.getString("Email");
				}
				else{
					JOptionPane.showMessageDialog(null, "Wrong code Entered !");
					System.exit(0);
				}
				if (emailAfterEnteringCode.equals(email)) {
					act = true;
					String changeActivatedStatus = "Update Student SET Activated = 1 WHERE Email = '"
							+ email + "'";
					stmt.executeUpdate(changeActivatedStatus);
					JOptionPane.showMessageDialog(null, "Go to Profile Page to fill in your information before you can search ");
					return act;
				} else {
					JOptionPane.showMessageDialog(null, "Wrong code Entered");
					act = false;
				}
			} else {
				System.exit(0);
			}
		}
		if (activation == 1)
			act = true;
		return act;

	}
	

	/**
	 * Method to get Student ID
	 * 
	 * @return logged in Student ID
	 * 
	 */
	public static int getStudentID() {
		return studentID;
	}
}
