


/*
 * DO NOT CHANGE ANY NUMBER IN THIS CLASS!
 * 
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;

public class HomePage extends JFrame{
	static JFrame homepage;
	static JPanel contentPane;
	static JButton SearchButton,RefreshButton;
	static JLabel result;
	static JLabel messInv;
	FunctionsForHome funch = new FunctionsForHome();
	static JPanel showResult; 
	static JPanel showMessInv;
	static JPanel logoPanel;
	static JPanel messageInvP;
	static JScrollPane messScroll;
	static JButton messages;
	ImageIcon icon;
	JLabel imageLabel = new JLabel(icon);
//	public void run() {
//		try {
//			HomePage homepage = new HomePage();
//			homepage.setVisible(true);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
	public void run () throws Exception{
		JPanel imagePanel;
		JLabel logo,logo2, welcome, welcome2;
		JButton profilePage, logout, invitations, messInvHide; 
		
		//here I don't know why :( it says only 'final' is allowed
		//and it should have been static.
		
		

		homepage = new JFrame();
		homepage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		homepage.setVisible(true);
		homepage.setSize(750, 520);
		homepage.setLocationRelativeTo(null);
//	homepage.pack();
		
		//this setup means no spaces between each panels
		homepage.setLayout(new MigLayout("", "0![] 0! [] 0!", " 0! [] 0! [] 10"));
	
		//contentPane is a Panel that contains two sub-panels
		// it has the size as the JFrame minus logoPanel
		contentPane = new JPanel(new MigLayout("", "15! [340!] 20! [365!] 20! [310!] 10!", "0! [] 0!"));
//		contentPane.setBorder(BorderFactory.createLineBorder(Color.BLUE));
	
		//the two sub-panels of the contentPane is profile Panel and result Panel
		// profilePanel contains welcome words, profile picture and search function
		/*resultPanel has suggested friends when first logged in, 
		  when the user does a search, the resultPanel shows the search result instead*/
		JPanel profilePanel = new JPanel(new MigLayout("wrap 2, gapy 1", "0 [] 0![] 5!", ""));
		JPanel resultPanel = new JPanel(new MigLayout("wrap 2, gapy 5", "0 [168!] 2 [168!] 0", ""));

		profilePanel.setBorder(BorderFactory.createDashedBorder(Color.LIGHT_GRAY));
		resultPanel.setBorder(BorderFactory.createDashedBorder(Color.LIGHT_GRAY));
	
		/*
		 * logoPanel
		 * 
		 */
		
		//set a logoPanel which is on the top, contains two parts of the logo
		//and two buttons: MyPage and LogOut
		logoPanel = new JPanel(new MigLayout("", "10![]0![]0![]2![]10!"));
		
		logo = new JLabel("Uni");
		logo2 = new JLabel("Meet");
		logo.setFont(new Font("Serif", Font.ITALIC, 20));
		logo.setForeground(Color.BLUE);
		logo2.setFont(new Font("TimesRoman-Bold", Font.ITALIC, 20));
		logo2.setForeground(Color.DARK_GRAY);
		
//		logoPanel.setBorder(BorderFactory.createDashedBorder(null));
		logoPanel.setBackground(Color.WHITE);
		logoPanel.add(logo, "align right");
		logoPanel.add(logo2, "push");
		
		profilePage = new JButton("My Profile");		
		logout = new JButton("Log Out");
		logoPanel.add(profilePage, "aligny top");
		logoPanel.add(logout, "aligny top");
		
		homepage.add(logoPanel, "w 750!, h 42!, wrap");
		homepage.add(contentPane);

	
		/*
		 * profile Panel:
		 * 
		 */
		JPanel welcomeP = new JPanel(new MigLayout("gapy 1", "0![] 0!", "8![]8![]10![]"));
		
		String sName = FunctionsForMainScreen.name;
		welcome = new JLabel("Hi " + sName + "!");
		welcome.setFont(new Font("Selrif", Font.ITALIC, 25));
		welcome.setForeground(Color.BLUE);
		welcome2 = new JLabel("Welcome Back :)");
		welcome2.setFont(new Font("Helvetica", Font.ITALIC, 20));
		welcome2.setForeground(Color.DARK_GRAY);
		welcomeP.add(welcome, "wrap, align 10% 90%");
		welcomeP.add(welcome2, "wrap, align 10% 90%");
		
		JPanel buttonP = new JPanel(new MigLayout("", "0! []0!", "0![] 0! [] 0!"));
		messages = new JButton("Messages");
		buttonP.add(messages, "push, align left, wrap");

		invitations = new JButton("Invitations");
		buttonP.add(invitations);
		
		welcomeP.add(buttonP, "align left,  span 1 2, h 60!");
//		welcomeP.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
		
		profilePanel.add(welcomeP, " align left, w 170!, h 140!, span 1 4");
		
		//a panel that contains the profile picture of the user who logged in
		imagePanel = new JPanel();
		imagePanel.setBorder(BorderFactory.createDashedBorder(Color.BLUE));
		funch.setImage(icon, imageLabel, imagePanel);
		//to retrieve the image
		//*** :(
		
		profilePanel.add(imagePanel, "w 150!, h 140!, push, span 1 4");
				

		//just a dashed line that separate two sections:
		JPanel dashed = new JPanel();
		dashed.setBorder(BorderFactory.createDashedBorder(Color.WHITE));
		dashed.setBackground(Color.WHITE);
		profilePanel.add(dashed, "span 2, w 339!, h 2!, skip 7");
				
		
		JLabel SearchBy = new JLabel("Search Students by:");
		SearchBy.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		SearchBy.setHorizontalAlignment(SwingConstants.LEFT);
		SearchBy.setForeground(Color.BLUE);
		profilePanel.add(SearchBy, "skip 8, span 2, h 20!, aligny top, align 50% 50%");
//		SearchBy.setBorder(BorderFactory.createLineBorder(Color.green));
		
		//Search is another class, which extends tabbedPane
		final Search tabbedPane = new Search(JTabbedPane.TOP);	
		profilePanel.add(tabbedPane, "span 2, w 340!, h 230!");
		//Add Search button, its function is in FunctionForHome Class
//		tabbedPane.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
		SearchButton = new JButton("Search");
		SearchButton.setEnabled(false);
		profilePanel.add(SearchButton, "pushx, align right");
		
		RefreshButton = new JButton("Refresh");
		profilePanel.add(RefreshButton);
		
		/*
		 * result Panel
		 * 
		 */
		result = new JLabel();
		result.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		result.setForeground(Color.BLUE);
		// the default text is suggested strangers, which will change once the 'search' button is pressed.
		result.setText("Suggested Strangers");
		resultPanel.add(result, "span 2, h 18!");

		//showResult is the panel that displays all results,
		// Equivalent to the 'GuiResults' class
		showResult = new JPanel(new MigLayout("gapy 2, w 345!", "", "0![]0!"));		
		JScrollPane resultScroll = new JScrollPane(showResult, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
//		resultScroll.setBorder(BorderFactory.createLineBorder(Color.yellow));
		
		resultPanel.add(resultScroll, "span 2, w 364!, h 410!");

		
		/*
		 * Message Invitation panel
		 * 
		 */
		messageInvP = new JPanel(new MigLayout("wrap 2, gapy 5", "3! [] [] 2!", ""));
		showMessInv = new JPanel(new MigLayout("wrap 1, gapy 2", "", "15![]0!"));
		messageInvP.setBorder(BorderFactory.createDashedBorder(Color.GRAY));
		messInv = new JLabel();
		messInv.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		messInv.setForeground(Color.BLUE);
		messageInvP.add(messInv, "h 18!, push");
		
		messInvHide = new JButton("[x] Hide");
		messInvHide.setForeground(Color.RED);
		messInvHide.setBorderPainted(false);
		messageInvP.add(messInvHide, "h 18!, w 95!");
		messScroll = new JScrollPane(showMessInv);
		messageInvP.add(messScroll,"w 304!, h 410!, span 2");
		
		// add panels
		contentPane.add(profilePanel, "w 340!, h 448!");
		contentPane.add(resultPanel, "w 365!, h 448!");
		funch.suggestedFriends();
				
		
		/*
		 * button's actionListeners
		 * 
		 */
		profilePage.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ViewProfile();

			}
		});
		
		logout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		messages.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					//Message.screen();
					messages.setBackground(null);
					messInv.setText("Messages");
				//	messageInvP.removeAll();
					
					showMessInv.removeAll();
					showMessInv.add(new Message());
					showMessInv.revalidate();
					contentPane.add(messageInvP, "w 310!, h 448!");
					contentPane.revalidate();
					
					homepage.add(logoPanel, "w 1080!, h 42!, wrap, dock north");
					homepage.setSize(1080, 520);
					homepage.setLocationRelativeTo(null);
					homepage.revalidate();
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		
		messInvHide.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					contentPane.remove(messageInvP);
					contentPane.revalidate();
					
					homepage.add(logoPanel, "w 750!, h 42!, wrap, dock north");
					homepage.setSize(750, 520);
					homepage.setLocationRelativeTo(null);
					homepage.revalidate();
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		invitations.addActionListener(new ActionListener() {
			//
						@Override
						public void actionPerformed(ActionEvent e) {
			
							try {
								//Invitation.screen();
								messInv.setText("Invitations");
								contentPane.add(messageInvP, "w 310!, h 448!");
								showMessInv.removeAll();
								showMessInv.add(new Invitation());
								showMessInv.revalidate();
								contentPane.revalidate();
								
								homepage.add(logoPanel, "w 1080!, h 42!, wrap, dock north");
								homepage.setSize(1080, 520);
								homepage.setLocationRelativeTo(null);
								homepage.revalidate();
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
			
						}
					});
		
		// in case the user choose the wrong button, he/she can refresh all buttons
		RefreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				funch.refreshButtons();
				SearchButton.setEnabled(false);
			}
		});
		
		
		
		// To make this constructor neater, I created a new class that contains
		// the Actionlistener
		// to the search button.
		
		SearchButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				result.setText("Search Results:");
				Queries.imageBytes.clear();
				//Queries.numpanes=0;
				showResult.removeAll();
				funch.searchFunction(tabbedPane);
				showResult.revalidate();
				
			}
		});
		
		
	}
	
	
}
