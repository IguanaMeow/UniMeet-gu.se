package gu.se.project.beta;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JTree;
import javax.swing.JList;
import javax.swing.tree.*;
import javax.swing.DefaultComboBoxModel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeWillExpandListener;
import javax.swing.event.TreeExpansionEvent;

/**
 * 
 * Search.java
 * 
 * @author Jessie
 * @version 1.0
 */
public class Search extends JFrame {
	//
	Queries query = new Queries();

	private JPanel contentPane;
	JButton ArtsButton, MusicButton, SportsButton, OutdoorButton, IndoorButton,
			FilmButton, OtherButton, SearchButton, RefreshButton;
	JButton profilePage, invitations, logout;
	static JButton messages;// added for purpose of trial
												// version
	static String subjectChosen;
	static String langChosen = "";
	JList languageList;
	JTabbedPane tabbedPane;

	public void run() {
		try {
			Search frame = new Search();
			frame.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// constructor//
	// contains the UI
	public Search() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		profilePage = new JButton("Profile Page");// added for purpose of trial
													// version
		invitations = new JButton("Invitations");// added for purpose of trial
													// version

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		// tabbed panel that contains three tabs.

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		final JTree tree = new JTree();
		tree.addTreeWillExpandListener(new TreeWillExpandListener() {
			public void treeWillCollapse(TreeExpansionEvent event) {
			}

			public void treeWillExpand(TreeExpansionEvent event) {
			}
		});
		tree.setModel(new DefaultTreeModel(new DefaultMutableTreeNode(
				"Medicine, odontology, health and care science") {
			{
				DefaultMutableTreeNode Bachelor, Master, Special;
				Bachelor = new DefaultMutableTreeNode("Bachelor");
				Bachelor.add(new DefaultMutableTreeNode("Apotekarprogrammet"));
				Bachelor.add(new DefaultMutableTreeNode(
						"Arbetsterapeutprogrammet"));
				Bachelor.add(new DefaultMutableTreeNode("Audionomprogrammet"));
				Bachelor.add(new DefaultMutableTreeNode(
						"Biomedicinska analytikerprogrammet"));
				Bachelor.add(new DefaultMutableTreeNode("Dietistprogrammet"));
				Bachelor.add(new DefaultMutableTreeNode(
						"Folkhälsovetenskapligt program med hälsoekonomi"));
				Bachelor.add(new DefaultMutableTreeNode("Hälsopromotion"));
				Bachelor.add(new DefaultMutableTreeNode("Logopedprogrammet"));
				Bachelor.add(new DefaultMutableTreeNode("Läkarprogrammet"));
				Bachelor.add(new DefaultMutableTreeNode(
						"Receptarieprogrammet/Farmaci"));
				Bachelor.add(new DefaultMutableTreeNode(
						"Rontgensjukskoterskeprogrammet"));
				Bachelor.add(new DefaultMutableTreeNode("Sjukgymnastprogrammet"));
				Bachelor.add(new DefaultMutableTreeNode(
						"Sjukhusfysikerprogrammet"));
				Bachelor.add(new DefaultMutableTreeNode(
						"Sjukskoterskeprogrammet"));
				Bachelor.add(new DefaultMutableTreeNode("Sports Coaching"));
				Bachelor.add(new DefaultMutableTreeNode(
						"Tandhygienistprogrammet"));
				Bachelor.add(new DefaultMutableTreeNode("Tandläkarprogrammet"));
				Bachelor.add(new DefaultMutableTreeNode(
						"Tandteknikerprogrammet"));
				add(Bachelor);

				Master = new DefaultMutableTreeNode("Master");
				Master.add(new DefaultMutableTreeNode("Barnmorskeprogrammet"));
				Master.add(new DefaultMutableTreeNode(
						"Evidensbasering: praktik, teori, kontext"));
				Master.add(new DefaultMutableTreeNode(
						"folkhälsovetenskap med hälsoekonomi"));
				Master.add(new DefaultMutableTreeNode(
						"Buisness Creation and Entrepreneurship in Biomedicine"));
				Master.add(new DefaultMutableTreeNode(
						"Programmet för komletterande utbildning för läkare"));
				Master.add(new DefaultMutableTreeNode(
						"Programmet för kompletterande utbildning för tandläkare"));
				Special = new DefaultMutableTreeNode(
						"Specialistsjuksköterskeprogrammet");
				Special.add(new DefaultMutableTreeNode("anestesisjukvård"));
				Special.add(new DefaultMutableTreeNode("distriktssköterska"));
				Special.add(new DefaultMutableTreeNode(
						"hälso- och sjukvård för barn och ungdomar"));
				Special.add(new DefaultMutableTreeNode("intensivvård"));
				Special.add(new DefaultMutableTreeNode("kirurgisk vård"));
				Special.add(new DefaultMutableTreeNode("medicinsk vård"));
				Special.add(new DefaultMutableTreeNode("onkologisk vård"));
				Special.add(new DefaultMutableTreeNode("operationssjukvård"));
				Special.add(new DefaultMutableTreeNode("psykiatrisk vård"));
				Special.add(new DefaultMutableTreeNode("vård av äldre"));

				Master.add(Special);
				add(Master);

			}
		}));
		tree.addTreeSelectionListener(new TreeSelectionListener() {

			@Override
			public void valueChanged(TreeSelectionEvent e) {
				if (tree.isSelectionEmpty())
					return;
				Object node = tree.getLastSelectedPathComponent();

				subjectChosen = node.toString();
				if (!subjectChosen.equals(null))
					SearchButton.setEnabled(true);

			}
		});
		JScrollPane TreePane = new JScrollPane(tree);

		// add the tree to the first tab.
		tabbedPane.addTab("Subject", null, TreePane, null);

		String[] languages = { "Albanian", "Arabic", "Awash", "Azerbaijani",
				"Bengali", "Bhojpuri", "Bosnian", "Burmese", "Chinese, Hakka",
				"Chinese, Mandarin", "Chinese, Min Nan", "Cantonese", "Danish",
				"Dutch", "English", "Estonian", "Faroese", "Finnish", "French",
				"German", "Greek", "Gujarati", "Hausa", "Hindi", "Hungarian",
				"Icelandic", "Italian", "Javanese", "Japanese", "Kannada",
				"Korean", "Latvian", "Lithuanian", "Maithili", "Malayalam",
				"Marathi", "Norwegian", "Oriya", "Panjabi", "Persian",
				"Polish", "Portuguese", "Romanian", "Russian", "Sami",
				"Serbian", "Serbo-Croatian", "Sindhi", "Slovak", "Spanish",
				"Sunda", "Swedish", "Thai", "Tamil", "Telugu", "Turkish",
				"Ukrainian", "Urdu", "Vietnamese", "Yoruba" };

		languageList = new JList(languages);
		languageList
				.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

		languageList.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				langChosen = (String) languageList.getSelectedValue();
				if (!langChosen.equals(""))
					SearchButton.setEnabled(true);

			}
		});

		JScrollPane LanguageScroll = new JScrollPane(languageList);
		// add the list to the second tab

		tabbedPane.addTab("Language", null, LanguageScroll, null);

		tabbedPane.setEnabledAt(1, true);

		JPanel panel_1 = new JPanel();
		// add this empty panel to the third tab.
		// in this panel there are seven interest buttons
		tabbedPane.addTab("Interest", null, panel_1, null);

		ArtsButton = new JButton("Art");
		panel_1.add(ArtsButton);
		ArtsButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ArtsButton.setEnabled(true);
				disable(MusicButton, SportsButton, FilmButton, OtherButton,
						IndoorButton, OutdoorButton);
				SearchButton.setEnabled(true);
			}

		});

		MusicButton = new JButton("Music");
		panel_1.add(MusicButton);
		MusicButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MusicButton.setEnabled(true);
				disable(ArtsButton, SportsButton, FilmButton, OtherButton,
						IndoorButton, OutdoorButton);
				SearchButton.setEnabled(true);
			}

		});

		SportsButton = new JButton("Sports");
		panel_1.add(SportsButton);
		SportsButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SportsButton.setEnabled(true);
				disable(MusicButton, ArtsButton, FilmButton, OtherButton,
						IndoorButton, OutdoorButton);
				SearchButton.setEnabled(true);
			}

		});
		FilmButton = new JButton("Film");
		panel_1.add(FilmButton);
		FilmButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FilmButton.setEnabled(true);
				disable(MusicButton, SportsButton, ArtsButton, OtherButton,
						IndoorButton, OutdoorButton);
				SearchButton.setEnabled(true);
			}

		});
		IndoorButton = new JButton("Indoor");
		panel_1.add(IndoorButton);
		IndoorButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				IndoorButton.setEnabled(true);
				disable(MusicButton, SportsButton, FilmButton, OtherButton,
						ArtsButton, OutdoorButton);
				SearchButton.setEnabled(true);
			}

		});
		OutdoorButton = new JButton("Outdoor");
		panel_1.add(OutdoorButton);
		OutdoorButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				OutdoorButton.setEnabled(true);
				disable(MusicButton, SportsButton, FilmButton, OtherButton,
						IndoorButton, ArtsButton);
				SearchButton.setEnabled(true);
			}

		});

		OtherButton = new JButton("Other");
		panel_1.add(OtherButton);
		OtherButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				OtherButton.setEnabled(true);
				disable(MusicButton, SportsButton, FilmButton, ArtsButton,
						IndoorButton, OutdoorButton);
				SearchButton.setEnabled(true);
			}

		});

		// in this panel there are two buttons: search and refresh
		JPanel panel = new JPanel();
		logout = new JButton("Logout");
		messages=new JButton("Messages");
		if(SendMsg.id.length>0){
			Search.messages.setBackground(Color.yellow);
		}
		contentPane.add(panel, BorderLayout.NORTH);

		JLabel lblSearchBy = new JLabel("Search by:");
		lblSearchBy.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblSearchBy.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblSearchBy);

		//panel.add(logout,BorderLayout.LINE_END);
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);

		SearchButton = new JButton("Search");

		panel_2.add(profilePage);// added for purpose of trial version
		panel_2.add(invitations);// added for purpose of trial version
		panel_2.add(SearchButton);
		
		SearchButton.setEnabled(false);
		// To make this constructor neater, I created a new class that contains
		// the Actionlistener
		// to the search button.
		SearchButton.addActionListener(new searchFunction());

		RefreshButton = new JButton("Refresh");
		panel_2.add(RefreshButton);
//		for(int a=0;a<9;a++){
//			messages.setBackground(Color.blue);
//			messages.setBackground(Color.YELLOW);
//		}
		panel_2.add(messages);
		panel_2.add(logout);
		

		RefreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh(ArtsButton, SportsButton, OutdoorButton, IndoorButton,
						FilmButton, MusicButton, OtherButton);
				SearchButton.setEnabled(false);
			}

		});
		invitations.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					Invitation.screen();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
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
					
					Message.screen();
					messages.setBackground(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});

	}

	// this class is an Actionlistener for the search button,
	// when first click a interest button and then click 'search', it will call
	// the corresponding button
	public class searchFunction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (tabbedPane.getTitleAt(tabbedPane.getSelectedIndex()).equals(
					"Subject")) {
				// System.out.println(subjectChosen);
				query.courseQuery();
				if (Queries.exist == true)
					new GuiResults();
				else {
					JOptionPane.showMessageDialog(null, "No matches found");
				}
			} else if (tabbedPane.getTitleAt(tabbedPane.getSelectedIndex())
					.equals("Language")) {

				query.languageQuery();
				if (Queries.exist == true)
					new GuiResults();
				else {
					JOptionPane.showMessageDialog(null, "No matches found");
				}

			} else if (tabbedPane.getTitleAt(tabbedPane.getSelectedIndex())
					.equals("Interest")) {
				if (MusicButton.isEnabled() == true) {
					query.musicQuery();
					if (Queries.exist == true)
						new GuiResults();
					else {
						JOptionPane.showMessageDialog(null, "No matches found");
					}
				}
				if (FilmButton.isEnabled() == true) {
					query.filmQuery();
					if (Queries.exist == true)
						new GuiResults();
					else {
						JOptionPane.showMessageDialog(null, "No matches found");
					}
				}
				if (IndoorButton.isEnabled() == true) {
					query.indoorQuery();
					if (Queries.exist == true)
						new GuiResults();
					else {
						JOptionPane.showMessageDialog(null, "No matches found");
					}
				}
				if (OutdoorButton.isEnabled() == true) {
					query.outdoorQuery();
					if (Queries.exist == true)
						new GuiResults();
					else {
						JOptionPane.showMessageDialog(null, "No matches found");
					}
				}
				if (ArtsButton.isEnabled() == true) {
					query.artsQuery();
					if (Queries.exist == true)
						new GuiResults();
					else {
						JOptionPane.showMessageDialog(null, "No matches found");
					}
				}
				if (SportsButton.isEnabled() == true) {
					query.sportsQuery();
					if (Queries.exist == true)
						new GuiResults();
					else {
						JOptionPane.showMessageDialog(null, "No matches found");
					}
				}
				if (OtherButton.isEnabled() == true) {
					query.otherQuery();
					if (Queries.exist == true)
						new GuiResults();
					else {
						JOptionPane.showMessageDialog(null, "No matches found");
					}
				}
			}
		}
	}

	// a method to disable all other buttons when click one button.
	// so the user cannot choose two interests
	public void disable(JButton a, JButton b, JButton c, JButton d, JButton e,
			JButton f) {
		a.setEnabled(false);
		b.setEnabled(false);
		c.setEnabled(false);
		d.setEnabled(false);
		e.setEnabled(false);
		f.setEnabled(false);
	}

	// in case the user choose the wrong button, he/she can refresh all buttons
	public void refresh(JButton a, JButton b, JButton c, JButton d, JButton e,
			JButton f, JButton g) {
		a.setEnabled(true);
		b.setEnabled(true);
		c.setEnabled(true);
		d.setEnabled(true);
		e.setEnabled(true);
		f.setEnabled(true);
		g.setEnabled(true);
	}

	public static String getLangChosen() {
		// System.out.println(langChosen);
		return langChosen;
	}

	public static String getSubjectChosen() {
		return subjectChosen;
	}

}
