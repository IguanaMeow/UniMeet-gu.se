package gu.se.project.beta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * 
 * MainScreen.java
 * Purpose: Displays Log In and Sign Up Buttons.
 *
 * @author Omar 
 * @version 1.0 
 */
public class MainScreen  {
	JButton loginButton;
	JButton signupButton;
	JFrame window;
	

	public void initial(){
		
		window = new JFrame("UniMeet");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.setSize(200, 200);
		loginButton=new JButton("Login");
		signupButton=new JButton("Sign Up");

		JPanel panel1 = new JPanel();
		panel1.add(loginButton);
		panel1.add(signupButton);
		window.setLocationRelativeTo(null);

		
		
	window.getContentPane().add(panel1);
		
	signupButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			window.dispose();
			SignUpScreen sign=new SignUpScreen();
			sign.SignUp();
			
			
			
		}
	});


	
	loginButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			window.dispose();
			LoginScreen log=new LoginScreen();
			log.login();
			
		}
	});
	
	}
	public static void main(String[] args) {
		MainScreen a= new MainScreen();
		a.initial();
	}
}
