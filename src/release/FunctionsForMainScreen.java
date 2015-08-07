

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

import com.mysql.jdbc.PreparedStatement;

/**
 * 
 * FunctionsForMainScreen.java Purpose: All the functions used in Sign Up and
 * Log In .
 * 
 * @author Omar
 * @version 1.0
 */
public class FunctionsForMainScreen {
	static int studentID = 0;
	static String name = "";
	java.sql.PreparedStatement stmt = null;
	ResultSet res = null;
	Connection con = null;
	static int[] id;
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
		con = null;
		con = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/guproject","USER","PASS");
		// stmt = con.createStatement();
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
	 * @throws SQLException
	 */
	public void signUp(String first, String last, String email, String pass,
			String birth, String gender) throws SQLException {// register new
																// user
		try {
			opencon();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String query = "INSERT INTO Student (First_Name,Last_Name,Email,Password,Birthday,Gender) VALUES (?,?,?,?,?,?)";
		stmt = con.prepareStatement(query);
		stmt.setString(1, first); // set input parameter 1
		stmt.setString(2, last); // set input parameter 2
		stmt.setString(3, email); // set input parameter 3
		stmt.setString(4, pass);
		stmt.setString(5, birth);
		stmt.setString(6, gender);
		stmt.executeUpdate(); // execute insert statement
		// stmt.close();

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
		String checkEmail = "SELECT * From Student WHERE Email = ?";
		stmt = con.prepareStatement(checkEmail);
		stmt.setString(1, email);
		res = stmt.executeQuery();
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
		String query = "SELECT Student_ID FROM Student WHERE ( Email= ? AND Password = ?)";
		stmt = con.prepareStatement(query);
		stmt.setString(1, email);
		stmt.setString(2, String.valueOf(pass));
		res = stmt.executeQuery();
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
		String query = "SELECT Student_ID,First_Name FROM Student WHERE ( Email= ? AND Password = ? ) ";
		stmt = con.prepareStatement(query);
		stmt.setString(1, email);
		stmt.setString(2, String.valueOf(pass));
		res = stmt.executeQuery();
		while (res.next()) {
			studentID = res.getInt("Student_Id");
			name = res.getString("First_Name");
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

		String query = "SELECT * FROM Student WHERE Email = ? ";

		String newPass = null;

		try {
			stmt = con.prepareStatement(query);
			stmt.setString(1, email);
			res = stmt.executeQuery();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Email doesn't Exist ! ");

		}
		try {
			if (res.next()) {

				newPass = nextSessionId();

				EmailSender.sendMail("someone@gmail.com", "PASS",
						"Your new Password is : " + newPass, email);
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
		} finally {
			if (res != null) {
				try {
					res.close();
				} catch (SQLException e) {

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
		String query = "SELECT * FROM Student WHERE Email = ? ";

		String newCode = null;
		try {
			stmt = con.prepareStatement(query);
			stmt.setString(1, email);
			res = stmt.executeQuery();

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
			EmailSender.sendMail("someone@gmail.com", "PASS",
					"Your Activation code is  is : " + newCode, email);

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
	 * Method to check if student account is activated or not.
	 * 
	 * @param Email
	 * @return true if code entered is correct or account is already activated
	 * @return false if code entered is incorrect
	 * @throws Exception
	 * 
	 */
	public boolean checkActivation(String email) throws Exception {// check
																	// if
																	// account
																	// is
																	// activated
		int activation = 0;
		String emailAfterEnteringCode = null;
		boolean act = false;
		String getActivationStatus = "SELECT Activated From Student WHERE Email = ? ";
		try {
			stmt = con.prepareStatement(getActivationStatus);
			stmt.setString(1, email);
			res = stmt.executeQuery();
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
				String getEmailQuery = "SELECT Email From Student WHERE Code = ? ";
				stmt = con.prepareStatement(getEmailQuery);
				stmt.setString(1, code);
				res = stmt.executeQuery();
				if (res.next()) {
					emailAfterEnteringCode = res.getString("Email");
				} else {
					JOptionPane.showMessageDialog(null, "Wrong code Entered !");
					System.exit(0);

				}
				if (emailAfterEnteringCode.equals(email)) {
					act = true;
					String changeActivatedStatus = "Update Student SET Activated = 1 WHERE Email = '"
							+ email + "'";
					stmt.executeUpdate(changeActivatedStatus);
					// JOptionPane.showMessageDialog(null,
					// "Go to Profile Page to fill in your information before you can search ");
					new ViewProfile();
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
		HomePage a = new HomePage();
		a.run();
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
