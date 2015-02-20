

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Queries {

	// Queries.
	// -----------------------------------------------------------------------------------------------------

	int studentID = FunctionsForMainScreen.studentID;
	// String subjectChosen = Search.getSubjectChosen();

	String languageSql; // changed string
	String courseSql; // changed string
	String musicSql;
	String filmSql;
	String otherSql;
	String indoorSql;
	String outdoorSql;
	String artsSql;
	String sportsSql;
	String suggSql;

	protected Connection con;
	ResultSet theQuery;
	static int k;
	static int numpanes;
	static int i;
	// byte [] imageBytes;
	PreparedStatement statement = null;
	public static boolean exist = false;
	public static String[] name = new String[6];
	public static String[] age = new String[6];
	public static String[] nationality = new String[6];
	public static String[] gender = new String[6];
	public static String[] idinvite = new String[6];
	// public static String[] aboutMe=new String[10];
	public static ArrayList<byte[]> imageBytes = new ArrayList<byte[]>();

	// allQuery contains the different sql statements
	// -------------------------------------------------------------------

	public void musicQuery() {
		// int studentID = FunctionsForMainScreen.studentID;
		musicSql = "Select distinct Student_ID, First_Name, Last_Name, Birthday, Nationality, Gender,Picture from Student, Student_Music where Student.Student_ID !="
				+ studentID
				+ " and  Student.Student_ID = Student_Music.idStudent and Student_Music.idMusic in (Select idMusic from Student_Music where idStudent ="
				+ studentID + " ) order by RAND() desc LIMIT 5;";
		exeQuery(musicSql);
	}

	public void filmQuery() {
		// studentID = 1;
		filmSql = "Select distinct Student_ID, First_Name, Last_Name, Birthday, Nationality, Gender,Picture from Student, Student_Film where Student.Student_ID !="
				+ studentID
				+ " and  Student.Student_ID = Student_Film.idStudent and Student_Film.idFilm in (Select idFilm from Student_Film where idStudent ="
				+ studentID + " ) order by RAND() LIMIT 5;";
		exeQuery(filmSql);
	}

	public void otherQuery() {
		// studentID = 1;
		otherSql = "Select distinct Student_ID, First_Name, Last_Name, Birthday, Nationality, Gender,Picture from Student, Student_Other where Student.Student_ID !="
				+ studentID
				+ " and  Student.Student_ID = Student_Other.idStudent and Student_Other.idOther in (Select idOther from Student_Other where idStudent ="
				+ studentID + " ) order by RAND() LIMIT 5;";
		exeQuery(this.otherSql);
	}

	public void indoorQuery() {
		// studentID = 1;
		indoorSql = "Select distinct Student_ID, First_Name, Last_Name, Birthday, Nationality, Gender,Picture from Student, Student_Indoor where Student.Student_ID !="
				+ studentID
				+ " and  Student.Student_ID = Student_Indoor.idStudent and Student_Indoor.idIndoor in (Select idIndoor from Student_Indoor where idStudent ="
				+ studentID + " ) order by RAND() LIMIT 5;";
		exeQuery(this.indoorSql);
	}

	public void outdoorQuery() {
		// studentID = 1;
		outdoorSql = "Select distinct Student_ID, First_Name, Last_Name, Birthday, Nationality, Gender,Picture from Student, Student_Outdoor where Student.Student_ID !="
				+ studentID
				+ " and  Student.Student_ID = Student_Outdoor.idStudent and Student_Outdoor.idOutdoor in (Select idOutdoor from Student_Outdoor where idStudent ="
				+ studentID + " ) order by RAND() LIMIT 5;";
		exeQuery(this.outdoorSql);
	}

	public void artsQuery() {
		// studentID = 1;
		artsSql = "Select distinct Student_ID, First_Name, Last_Name, Birthday, Nationality, Gender,Picture from Student, Student_Arts where Student.Student_ID !="
				+ studentID
				+ " and  Student.Student_ID = Student_Arts.idStudent and Student_Arts.idArts in (Select idArts from Student_Arts where idStudent ="
				+ studentID + " ) order by RAND() LIMIT 5;";
		exeQuery(artsSql);
	}

	public void sportsQuery() {
		// studentID = 1;
		sportsSql = "Select distinct Student_ID, First_Name, Last_Name, Birthday, Nationality, Gender,Picture from Student, Student_Sports where Student.Student_ID !="
				+ studentID
				+ " and  Student.Student_ID = Student_Sports.idStudent and Student_Sports.idSports in (Select idSports from Student_Sports where idStudent ="
				+ studentID + " ) order by RAND() LIMIT 5;";
		exeQuery(sportsSql);
	}

	public void languageQuery() {
		// studentID = 1;
		languageSql = "Select Student_ID, First_Name, Last_Name, Birthday, Nationality, Gender,Picture from Student, Student_Language2, Languages where Student.Student_ID = Student_Language2.idStudent and Student_Language2.idLanguage = Languages.idLanguage and Languages.Description = '"
				+ Search.langChosen
				+ "' and Student_Language2.idStudent !="
				+ studentID + " order by RAND()  LIMIT 5;";
		exeQuery(languageSql);
		// System.out.println(languageSql);
	}

	public void courseQuery() {
		// studentID = 1;
		courseSql = "Select Student_ID, First_Name, Last_Name, Birthday, Nationality,Gender,Picture from Student, Student_Course, Course where Student.Student_ID = Student_Course.idStudent and Student_Course.idCourse = Course.idCourse and Course.Description = '"
				+ Search.subjectChosen
				+ "' and Student_Course.idStudent !="
				+ studentID + " order by RAND()  LIMIT 5;";
		// System.out.println(Search.subjectChosen);
		exeQuery(courseSql);
	}

	public void suggQuery() {
		suggSql = "SELECT Student_ID, First_Name,Last_Name,Birthday ,Nationality,Gender,Picture,Picture,Count(*) From "
				+ "(Select Student_ID,First_Name, Last_Name,Birthday ,Nationality,Gender,Picture"
				+ " from Student, Student_Sports where Student.Student_ID != "
				+ studentID
				+ " and  Student.Student_ID = Student_Sports.idStudent"
				+ " and Student_Sports.idSports in (Select idSports  from Student_Sports where idStudent = "
				+ studentID
				+ ")"
				+ " union all"
				+ " Select Student_ID,First_Name, Last_Name,Birthday ,Nationality,Gender,Picture"
				+ " from Student, Student_Other where Student.Student_ID != "
				+ studentID
				+ " and  Student.Student_ID = Student_Other.idStudent"
				+ " and Student_Other.idOther in (Select idOther  from Student_Other where idStudent = "
				+ studentID
				+ ")"
				+ " union all"
				+ " Select Student_ID,First_Name, Last_Name,Birthday ,Nationality,Gender,Picture"
				+ " from Student, Student_Outdoor where Student.Student_ID != "
				+ studentID
				+ " and  Student.Student_ID = Student_Outdoor.idStudent"
				+ " and Student_Outdoor.idOutdoor in (Select idOutdoor  from Student_Outdoor where idStudent = "
				+ studentID
				+ ")"
				+ " union all"
				+ " Select Student_ID,First_Name, Last_Name,Birthday ,Nationality,Gender,Picture"
				+ " from Student, Student_Other where Student.Student_ID != "
				+ studentID
				+ " and  Student.Student_ID = Student_Other.idStudent"
				+ " and Student_Other.idOther in (Select idOther  from Student_Other where idStudent = "
				+ studentID
				+ ")"
				+ " union all"
				+ " Select Student_ID,First_Name, Last_Name,Birthday ,Nationality,Gender,Picture"
				+ " from Student, Student_Music where Student.Student_ID != "
				+ studentID
				+ " and  Student.Student_ID = Student_Music.idStudent"
				+ " and Student_Music.idMusic in (Select idMusic  from Student_Music where idStudent = "
				+ studentID
				+ ")"
				+ " union all"
				+ " Select Student_ID,First_Name, Last_Name,Birthday ,Nationality,Gender,Picture"
				+ " from Student, Student_Indoor where Student.Student_ID != "
				+ studentID
				+ " and  Student.Student_ID = Student_Indoor.idStudent"
				+ " and Student_Indoor.idIndoor in (Select idIndoor  from Student_Indoor where idStudent = "
				+ studentID
				+ ")"
				+ " union all"
				+ " Select Student_ID,First_Name, Last_Name,Birthday ,Nationality,Gender,Picture"
				+ " from Student, Student_Arts where Student.Student_ID != "
				+ studentID
				+ " and  Student.Student_ID = Student_Arts.idStudent"
				+ " and Student_Arts.idArts in (Select idArts  from Student_Arts where idStudent = "
				+ studentID
				+ ")"
				+ " union all"
				+ " Select Student_ID,First_Name, Last_Name,Birthday ,Nationality,Gender,Picture"
				+ " from Student, Student_Film where Student.Student_ID != "
				+ studentID
				+ " and  Student.Student_ID = Student_Film.idStudent"
				+ " and Student_Film.idFilm in (Select idFilm  from Student_Film where idStudent = "
				+ studentID
				+ ")  ) as t group by (First_Name)"
				+ " order by count(*) desc limit 5;";
		exeQuery(suggSql);
	}

	// exeQuery executes and stores the called sql statement in a result set
	// -----------------------------------------------------------
	public void exeQuery(String query) {
		// Create Query-------
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Create a connection to database.
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:8080/guproject","USER","PASS");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			statement = con.prepareStatement(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Create variable to store query result-------
		query = null;
		try {
			theQuery = statement.executeQuery();
			viewRes(theQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {

				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {

				}

			}
		}

	}

	// viewRes separates the result set of the executed query and put them into
	// an array of strings which will be displayed into the resPane ----------
	public void viewRes(ResultSet s) {

		i = 0;
		numpanes = 0;
		try {

			while (s.next()) {
				// System.out.println("inside res");
				exist = true;
				idinvite[i] = s.getString(1);
				name[i] = s.getString(2) + " " + s.getString(3);

				age[i] = s.getString(4);
				nationality[i] = s.getString(5);
				gender[i] = s.getString(6);
				imageBytes.add(s.getBytes("Picture"));
				// the id's for the person you invite from search results ID 2
				// in receive invite

				i++;

				// System.out.println(name);
			}
			numpanes = i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (s != null) {
				try {
					s.close();

				} catch (SQLException e) {

				}
			}
		}
	}

}