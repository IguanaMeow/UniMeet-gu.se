
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
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

import net.miginfocom.swing.MigLayout;

/**
 * 
 * Search.java
 * 
 * @author Jessie
 * @version 1.0
 */
public class Search extends JTabbedPane {
	//
	Queries query = new Queries();

	private JPanel contentPane;
	public static JButton ArtsButton, MusicButton, SportsButton, OutdoorButton, IndoorButton,
			FilmButton, OtherButton;
	JButton profilePage, invitations, logout;
	static JButton messages;// added for purpose of trial
												// version
	static String subjectChosen;
	static String langChosen = "";
	JList languageList;
	JTabbedPane tabbedPane;



	// constructor//
	// contains the UI
	public Search(int top) {
	
		final JTree tree = new JTree();
		tree.addTreeWillExpandListener(new TreeWillExpandListener() {
			public void treeWillCollapse(TreeExpansionEvent event) {
			}

			public void treeWillExpand(TreeExpansionEvent event) {
			}
		});
		tree.setModel(new DefaultTreeModel(new DefaultMutableTreeNode(
				"Courses") {
			{
				DefaultMutableTreeNode Bachelor, Master;
				Bachelor = new DefaultMutableTreeNode("Bachelor");
				Bachelor.add(new DefaultMutableTreeNode("Apotekarprogrammet"));
				Bachelor.add(new DefaultMutableTreeNode("Arbetsterapeutprogrammet"));
				Bachelor.add(new DefaultMutableTreeNode("Audionomprogrammet"));
				Bachelor.add(new DefaultMutableTreeNode("Biomedicinska analytikerprogrammet"));
				Bachelor.add(new DefaultMutableTreeNode("Dietistprogrammet"));
				Bachelor.add(new DefaultMutableTreeNode("Logopedprogrammet"));
				Bachelor.add(new DefaultMutableTreeNode("Receptarieprogrammet/Farmaci"));
				Bachelor.add(new DefaultMutableTreeNode("Sjukgymnastprogrammet"));
				Bachelor.add(new DefaultMutableTreeNode("Sjukhusfysikerprogrammet"));
				Bachelor.add(new DefaultMutableTreeNode("Sports Coaching"));
				Bachelor.add(new DefaultMutableTreeNode("Tandhygienistprogrammet"));
				Bachelor.add(new DefaultMutableTreeNode("Tandteknikerprogrammet"));
				Bachelor.add(new DefaultMutableTreeNode("Biologi"));
				Bachelor.add(new DefaultMutableTreeNode("Fysik"));
				Bachelor.add(new DefaultMutableTreeNode("Geografi"));
				Bachelor.add(new DefaultMutableTreeNode("Geovetenskap"));
				Bachelor.add(new DefaultMutableTreeNode("Kemi"));
				Bachelor.add(new DefaultMutableTreeNode("Marin vetenskap"));
				Bachelor.add(new DefaultMutableTreeNode("Matematikprogrammet"));
				Bachelor.add(new DefaultMutableTreeNode("Bebyggelseantikvariskt program"));
				Bachelor.add(new DefaultMutableTreeNode("Konservatorsprogrammet"));
				Bachelor.add(new DefaultMutableTreeNode("Kultur"));
				Bachelor.add(new DefaultMutableTreeNode("Kultarvsstudier"));
				Bachelor.add(new DefaultMutableTreeNode("Liberal arts"));
				Bachelor.add(new DefaultMutableTreeNode("Religionsvetenskapligt program"));
				Bachelor.add(new DefaultMutableTreeNode("Teologiskt program"));
				Bachelor.add(new DefaultMutableTreeNode("Bygghantverksprogrammet"));
				Bachelor.add(new DefaultMutableTreeNode("Design"));
				Bachelor.add(new DefaultMutableTreeNode("Fri konst"));
				Bachelor.add(new DefaultMutableTreeNode("Keramikkonst"));
				Bachelor.add(new DefaultMutableTreeNode("Smyckekonst"));
				Bachelor.add(new DefaultMutableTreeNode("Textilkonst"));
				Bachelor.add(new DefaultMutableTreeNode("Software Engineering and Management"));
				add(Bachelor);

				Master = new DefaultMutableTreeNode("Master");
				Master.add(new DefaultMutableTreeNode("Barnmorskeprogrammet"));
				Master.add(new DefaultMutableTreeNode("Evidensbasering: praktik, teori, kontext"));
				Master.add(new DefaultMutableTreeNode("Buisness Creation and Entrepreneurship in Biomedicine"));
				Master.add(new DefaultMutableTreeNode("Atmospheric Science"));
				Master.add(new DefaultMutableTreeNode("Biodiversitet och systematik"));
				Master.add(new DefaultMutableTreeNode("Complex Adaptive Systems"));
				Master.add(new DefaultMutableTreeNode("Ecotoxicology"));
				Master.add(new DefaultMutableTreeNode("Fysisk oceanografi"));
				Master.add(new DefaultMutableTreeNode("Genomik och Systembiologi"));
				Master.add(new DefaultMutableTreeNode("Marina vetenskaper"));
				Master.add(new DefaultMutableTreeNode("Matematiska vetenskaper"));
				Master.add(new DefaultMutableTreeNode("Physics"));
				Master.add(new DefaultMutableTreeNode("Physics of Materials and Biological Systems"));
				Master.add(new DefaultMutableTreeNode("Arkeologisk praktik och teori"));
				Master.add(new DefaultMutableTreeNode("Genuspraktiker"));
				Master.add(new DefaultMutableTreeNode("Kulturarv och modernitet"));
				Master.add(new DefaultMutableTreeNode("Religious Studies"));
				Master.add(new DefaultMutableTreeNode("Child Culture Design"));
				Master.add(new DefaultMutableTreeNode("Fri konst med inriktning mot digitala medier"));
				Master.add(new DefaultMutableTreeNode("Konsthantverk"));
				Master.add(new DefaultMutableTreeNode("Business & Design"));
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
					HomePage.SearchButton.setEnabled(true);

			}
		});
		
		JScrollPane TreePane = new JScrollPane(tree);
		
		JPanel subjectP = new JPanel(new MigLayout("wrap 1", "0![]0!", "0![]0![]3![]0!"));	
		JLabel subjectL = new JLabel("Find a study partner the next time you're");
		JLabel subjectL2 = new JLabel("at the library!");
		subjectP.add(subjectL, "align 50% 50%");
		subjectP.add(subjectL2, "align 50% 50%");
		subjectP.add(TreePane, "w 318!, h 146!");
		
		

		// add the tree to the first tab.
		addTab("Subject", null, subjectP, null);

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
					HomePage.SearchButton.setEnabled(true);

			}
		});
		
		JPanel languageP = new JPanel(new MigLayout("wrap 1", "0![]0!", "0![]0![]3![]0!"));	
		JLabel languageL = new JLabel("Find students who speak a language you want");
		JLabel languageL2 = new JLabel("to learn!");
		JScrollPane LanguageScroll = new JScrollPane(languageList);
		// add the list to the second tab
		languageP.add(languageL, "align 50% 50%");
		languageP.add(languageL2, "align 50% 50%");
		languageP.add(LanguageScroll, "w 318!, h 146!");
		
//		LanguageScroll.setBorder(BorderFactory.createLineBorder(Color.green));
		
		addTab("Language", null, languageP, null);

		setEnabledAt(1, true);

		
		JPanel interestP = new JPanel(new MigLayout("wrap 3, gap 3", "", "0![]0![]15![]3![]3![]"));
		JLabel interestL = new JLabel("Find students with similar interests in");
		JLabel interestL2 = new JLabel("specific areas like Films ");
		interestP.add(interestL, "span 3, align 50% 50%");
		interestP.add(interestL2, "span 3, align 50% 50%" );

		// add this empty panel to the third tab.
		// in this panel there are seven interest buttons
		addTab("Interest", null, interestP, null);

		ArtsButton = new JButton("Art");
		interestP.add(ArtsButton);
		ArtsButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ArtsButton.setEnabled(true);
				disable(MusicButton, SportsButton, FilmButton, OtherButton,
						IndoorButton, OutdoorButton);
				HomePage.SearchButton.setEnabled(true);
			}

		});

		MusicButton = new JButton("Music");
		interestP.add(MusicButton);
		MusicButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MusicButton.setEnabled(true);
				disable(ArtsButton, SportsButton, FilmButton, OtherButton,
						IndoorButton, OutdoorButton);
				HomePage.SearchButton.setEnabled(true);
			}

		});

		SportsButton = new JButton("Sports");
		interestP.add(SportsButton);
		SportsButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SportsButton.setEnabled(true);
				disable(MusicButton, ArtsButton, FilmButton, OtherButton,
						IndoorButton, OutdoorButton);
				HomePage.SearchButton.setEnabled(true);
			}

		});
		FilmButton = new JButton("Film");
		interestP.add(FilmButton);
		FilmButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FilmButton.setEnabled(true);
				disable(MusicButton, SportsButton, ArtsButton, OtherButton,
						IndoorButton, OutdoorButton);
				HomePage.SearchButton.setEnabled(true);
			}

		});
		IndoorButton = new JButton("Indoor");
		interestP.add(IndoorButton);
		IndoorButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				IndoorButton.setEnabled(true);
				disable(MusicButton, SportsButton, FilmButton, OtherButton,
						ArtsButton, OutdoorButton);
				HomePage.SearchButton.setEnabled(true);
			}

		});
		OutdoorButton = new JButton("Outdoor");
		interestP.add(OutdoorButton);
		OutdoorButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				OutdoorButton.setEnabled(true);
				disable(MusicButton, SportsButton, FilmButton, OtherButton,
						IndoorButton, ArtsButton);
				HomePage.SearchButton.setEnabled(true);
			}

		});

		OtherButton = new JButton("Other");
		interestP.add(OtherButton);
		OtherButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				OtherButton.setEnabled(true);
				disable(MusicButton, SportsButton, FilmButton, ArtsButton,
						IndoorButton, OutdoorButton);
				HomePage.SearchButton.setEnabled(true);
			}

		});
		
		
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
