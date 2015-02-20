

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

import net.miginfocom.swing.MigLayout;

/*
 * This class is a combination of MainScreen, LoginScreen and SignUpScreen
 */

public class MainScreenMig {
	/* J:Some elements in Log In panel */
	JButton loginButton, cantAccess;
	JFrame window;
	JLabel Logo, Logo2, Slogan, LogIn;
	public static JTextField emailF;
	JPasswordField passF;
	/* J:Some elements in Sign Up panel */
	JLabel SignUp, birthday, birthdayF;
	JTextField fName, lName;
	public static JTextField emailSign;
	JPasswordField passwordSign, passwordSign2;
	JRadioButton male, female;
	ButtonGroup group;
	JButton signupButton;

	FunctionsForMainScreen func = new FunctionsForMainScreen();
	JDateChooser dateChooser = new JDateChooser();

	public void initial() {
		// J:set up the frame
		window = new JFrame("UniMeet");

		// J:the content panel, using MigLayout("layout constraint",
		// "column constraint", "row constraint");
		JPanel Panel = new JPanel(new MigLayout("", "[315!] 10 [350!]",
				"10 [] 10"));

		// J:Divide the content panel into two panels, logPanel and signPanel
		JPanel LogPanel = new JPanel(new MigLayout("wrap 2, gapy 10",
				"0 [152!] 1 [152!] 10", ""));
		JPanel signPanel = new JPanel(new MigLayout("wrap 2, gapy 5",
				"0 [151!] 3 [151!] 45", ""));

		/***
		 * Log In Panel *
		 ***/

		// J:The logo consists of two parts because there are two fonts used
		// here.
		Logo = new JLabel("Uni");
		Logo2 = new JLabel("Meet");
		Logo.setFont(new Font("Serif", Font.ITALIC, 35));
		Logo.setForeground(Color.BLUE);
		Logo2.setFont(new Font("TimesRoman-Bold", Font.ITALIC, 35));
		Logo2.setForeground(Color.DARK_GRAY);
		LogPanel.add(Logo, "align right");
		LogPanel.add(Logo2, "align left");

		// J:add the slogan below the logo
		Slogan = new JLabel("To easily find new friends in Universities");
		Slogan.setFont(new Font("TimesRoman", Font.ITALIC, 15));
		Slogan.setForeground(Color.DARK_GRAY);
		LogPanel.add(Slogan, "span 2, align 50% 50%");

		LogIn = new JLabel("Log In Here");
		LogIn.setFont(new Font("Helvetica", Font.PLAIN, 20));
		LogIn.setForeground(Color.BLUE);
		// J:"skip 2" is to skip two components, which is a row.
		LogPanel.add(LogIn, "span 2, align 50% 50%, skip 2");

		// J: instead of having separate JLabel and JTextField, I used
		// TitleBorder.
		// J: (applies also to password TextField)
		emailF = new JTextField(15);
		Border blueline = BorderFactory.createLineBorder(Color.blue);
		emailF.setBorder(BorderFactory.createTitledBorder(blueline,
				"Student Email"));
		emailF.setBackground(null);
		LogPanel.add(emailF, "span 2, grow, h 45!, w :270:290");
		// **emailF.setDocument(new LimitCharactersInput(30));

		passF = new JPasswordField(10);
		passF.setBorder(BorderFactory.createTitledBorder(blueline, "Password"));
		passF.setBackground(null);
		LogPanel.add(passF, "span 2, grow, h 45!, w :270:290");
		// **passF.setDocument(new LimitCharactersInput(15));

		cantAccess = new JButton("Can't Access your Account?");
		cantAccess.setBorderPainted(false);
		LogPanel.add(cantAccess, "span 2, w :100:, align right, push");

		loginButton = new JButton("Log in");
		LogPanel.add(loginButton, "skip 1, w :100:, align right, push");

		// J:add the login button's function and 'can't access?'button's
		// function

		logButtonFunctions();

		// J:add LogPanel to the content panel.
		Panel.add(LogPanel);

		/***
		 * Sign Up Panel*
		 ***/

		dateChooser.setVisible(true);

		// J:add a simple sign up label
		SignUp = new JLabel("Sign Up Now!");
		SignUp.setFont(new Font("Helvetica", Font.PLAIN, 20));
		SignUp.setForeground(Color.DARK_GRAY);
		signPanel.add(SignUp, "span 2, align 50% 50%, aligny baseline");

		// J:TextField for first name and last name
		fName = new JTextField(10);
		Border Grayline = BorderFactory.createLineBorder(Color.GRAY);
		fName.setBorder(BorderFactory
				.createTitledBorder(Grayline, "First Name"));
		fName.setBackground(Color.WHITE);
		signPanel.add(fName, "skip 4, span 2, h 40!, grow");
		fName.setDocument(new LimitCharactersInput(15));

		lName = new JTextField(10);
		lName.setDocument(new LimitCharactersInput(15));
		lName.setBorder(BorderFactory.createTitledBorder(Grayline, "Last Name"));
		lName.setBackground(Color.WHITE);
		signPanel.add(lName, "span 2, h 40!, grow");

		emailSign = new JTextField(15);
		emailF.setDocument(new LimitCharactersInput(30));
		emailSign.setBorder(BorderFactory.createTitledBorder(Grayline,
				"Student Email"));
		emailSign.setBackground(Color.WHITE);
		signPanel.add(emailSign, "h 40!, grow, span 2");

		passwordSign = new JPasswordField(10);
		passwordSign.setDocument(new LimitCharactersInput(15));
		passwordSign.setBorder(BorderFactory.createTitledBorder(Grayline,
				"Password"));
		passwordSign.setBackground(Color.WHITE);
		signPanel.add(passwordSign, "h 40!, grow, span 2");

		// J: if we want to add a re-type password Field:

		// passwordSign2 = new JPasswordField(10);
		// //***passwordF.setDocument(new LimitCharactersInput(15));
		// passwordSign2.setBorder(BorderFactory.createTitledBorder(
		// Grayline, "Re-type Password"));
		// passwordSign2.setBackground(Color.WHITE);
		// signPanel.add(passwordSign2, "h 40!, grow, span 2");

		birthday = new JLabel("Birthday");
		signPanel.add(birthday, "split 2");
		signPanel.add(dateChooser, "");
		dateChooser.setDateFormatString("yyyy-MM-dd");

		male = new JRadioButton("Male");
		female = new JRadioButton("Female");
		group = new ButtonGroup();
		group.add(male);
		group.add(female);
		signPanel.add(male, "split 2");
		signPanel.add(female);

		signupButton = new JButton("Sign Up!");
		signPanel.add(signupButton, "skip 7, w :100:, align right");

		Panel.add(signPanel);

		try {
			signButtonFunctions();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		window.add(Panel);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.setSize(685, 400);
		window.setLocationRelativeTo(null);
		MigLayout layout = new MigLayout("nogrid");
		window.setLayout(layout);
	}

	public void logButtonFunctions() {
		
		loginButton.addActionListener(new ActionListener() {

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
							window.dispose();
							SendMsg.notifyUser();
							//*** here instead of Search Frame I introduce another Frame
							//*** "HomePage", 'Search' is just one of panel in this new JFrame
//							Search GUI = new Search();
//							GUI.run();
							

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
passF.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
//					System.out.println("hi");
//				}
//					if(fName.getText().isEmpty()&&lName.getText().isEmpty()&&passF.getText().isEmpty()&&emailF.getText().isEmpty()&&!female.isSelected()&&!male.isSelected()&&!emailSign.getText().isEmpty()&&){
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
									window.dispose();
									SendMsg.notifyUser();
									//*** here instead of Search Frame I introduce another Frame
									//*** "HomePage", 'Search' is just one of panel in this new JFrame
//									Search GUI = new Search();
//									GUI.run();
									

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
//				}
		}

	@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
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

	public static void main(String[] args) {
		MainScreenMig a = new MainScreenMig();
		a.initial();
	}

	/**
	 * Method that contains the actionListener for SignUp button.
	 * 
	 * 
	 */
	public void signButtonFunctions() throws Exception {

		signupButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try{
				if(fName.getText().isEmpty()&&lName.getText().isEmpty()&&emailSign.getText().isEmpty()&&passF.getText().isEmpty()&&dateChooser.getDate().toString().isEmpty()&&!female.isSelected()&!male.isSelected()){
					
				}}
	catch(NullPointerException e1){
		JOptionPane.showMessageDialog(null,"Please fill all fields"	 );
		return;
	}
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");// format
																	// date

				String first = "";
				String last = "";
				String email = "";
				String pass = "";
				String birth = "";
				String gender = "";
				char[] input = passwordSign.getPassword();
				String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
				try {
					birth = df.format(dateChooser.getDate());
				} catch (Exception e1) {
JOptionPane.showMessageDialog(null, "Please choose a date of birth");
				}
				
				
				if (male.isSelected() == true) {
					gender = "Male";
				} else if (female.isSelected() == true) {
					gender = "Female";
				}
				else if(male.isSelected()==false && female.isSelected()==false){
					JOptionPane.showMessageDialog(null, "Please choose a gender");
				}

				if (fName.getText().matches("^[\\p{L} .'-]+$"))// check if name
																// contains only
																// letters
					first = fName.getText();
				else if (!fName.getText().matches("^[\\p{L} .'-]+$")
						&& !fName.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null,
							"Only letters Allowed in First Name");
					fName.setText("");
				}
				else if(fName.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Please type your first name");
				}
				if (lName.getText().matches("^[\\p{L} .'-]+$"))// check if name
																// contains only
																// letters
					last = lName.getText();
				// System.out.println(last + "Last");
				else if (!lName.getText().matches("^[\\p{L} .'-]+$")
						&& !lName.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null,
							"Only letters Allowed in Last Name");
					lName.setText("");
				}
				else if(lName.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Please type your last name");
				}
				if (emailSign.getText().contains("@student.gu.se")
						&& emailSign.getText().matches(EMAIL_REGEX)) {
					// check if email is a student email and correctly formated
					email = emailSign.getText();
				} else if (!emailSign.getText().contains("@student.gu.se")
						&& !emailSign.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null,
							"Please enter your student email ");
					// emailSign.setText("");
					

				}
				else if(emailSign.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Please enter your student email");
				}

				for (int i = 0; i < input.length; i++) {
					pass += input[i];
				}
				
				

				if (!first.equals("") && !last.equals("") && !email.equals("")
						&& !pass.equals("") && !gender.equals("")
						&& !birth.equals("")) {
					try {
						if (func.checkEmailAlreadyExists(email) == false) {// chech
																			// if
																			// email
																			// already
																			// exists

							func.signUp(first, last, email, pass, birth, gender);// sign
																					// up
							try {
								func.generateActivationCode(email);// generate
																	// code
							} catch (Exception e2) {
								e2.printStackTrace();
							}
							JOptionPane
									.showMessageDialog(null,
											"Registered successfully, Activation code sent to email");
							emailSign.setText(null);
							fName.setText(null);
							lName.setText(null);
							passwordSign.setText(null);

						} else if (func.checkEmailAlreadyExists(email) == true)// if
																				// email
																				// already
																				// exists
																				// then
																				// message
																				// appeared
							JOptionPane.showMessageDialog(null,
									"Email Already Exists");
					} catch (Exception e1) {
						e1.printStackTrace();

					}
				} 
				

			}
		});
	}

}