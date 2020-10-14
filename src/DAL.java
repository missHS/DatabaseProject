

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAL {
	private Connection con; 
	private ResultSet rs;
	private PreparedStatement ps; 
	private String query;

	public void connections() throws SQLException {

		ps = con.prepareStatement(query);
		rs = ps.executeQuery();
	}

	public void update() throws SQLException {

		ps = con.prepareStatement(query);
		ps.executeUpdate();
	}
	
	public void close() throws SQLException{
		rs.close();
		con.close();
		ps.close();
	}
	

	public void callDatabase() throws SQLException {

	

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			String url = "jdbc:sqlserver://localhost:1433;database=assignment1";
			String user = "admin1";
			String password = "admin1";

			con = DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
	}

	public ResultSet findStudent(String ssn) throws SQLException {
		callDatabase();
		query = "SELECT * FROM Student WHERE ssn = '" + ssn + "'";
		connections();
		return rs;			
	}

	public ResultSet findAllStudents() throws SQLException {
		callDatabase();
		query = "SELECT * FROM Student ";
		connections();
		return rs;

	}

	public ResultSet findCourse(String courseCode) throws SQLException {
		callDatabase();
		query = "SELECT * FROM Course WHERE courseCode = '" + courseCode + "'";

		connections();
		return rs;

	}

	public ResultSet findAllCourses() throws SQLException {
		callDatabase();
		query = "SELECT * FROM Course ";

		connections();
		return rs;
	}

	public ResultSet findStudentHasStudied(String courseCode) throws SQLException {
		callDatabase();
		query = "SELECT hs.ssn, s.studentName, hs.courseCode, hs.grade FROM HasStudied hs JOIN Student s "
				+ "ON s.ssn = hs.ssn WHERE hs.courseCode = '" + courseCode + "'";

		connections();
		return rs;

	}

	public ResultSet findCourseHasStudied(String ssn) throws SQLException {
		callDatabase();
		query = "SELECT hs.ssn, s.studentName, hs.courseCode, hs.grade FROM HasStudied hs JOIN Student s "
				+ "ON s.ssn = hs.ssn WHERE hs.ssn =  '" + ssn + "'";

		connections();
		return rs;

	}

	public ResultSet findCourseStudentHasStudied(String courseCode, String ssn) throws SQLException {
		callDatabase();
		query = "SELECT hs.ssn, s.studentName, hs.courseCode, hs.grade FROM HasStudied hs JOIN Student s "
				+ "ON s.ssn = hs.ssn WHERE hs.courseCode = '" + courseCode + "' AND hs.ssn = '" + ssn + "'";

		connections();
		return rs;

	}

	public ResultSet findAllStudentsHasStudied() throws SQLException {
		callDatabase();
		query = "SELECT DISTINCT  hs.ssn, s.studentName FROM HasStudied hs JOIN Student s "
				+ "ON s.ssn = hs.ssn ";

		connections();
		return rs;

	}

	public ResultSet findAllStudentAndCoursesFromHasStudied() throws SQLException {
		callDatabase();
		query = "SELECT s.ssn, s.studentName, hs.courseCode, hs.grade FROM Student s JOIN HasStudied hs ON s.ssn = hs.ssn";
		connections();
		return rs;

	}

	public ResultSet findAllCoursesHasStudied() throws SQLException {
		callDatabase();
		query = "SELECT DISTINCT hs.courseCode, c.courseName FROM HasStudied hs JOIN Course c "
				+ "ON c.courseCode = hs.courseCode";
		connections();
		return rs;
	}

	public ResultSet findCourseCredit(String courseCode) throws SQLException {
		callDatabase();
		query = "SELECT courseCredit FROM Course  WHERE courseCode = '" + courseCode + "'";
		connections();
		return rs;
	}

	public ResultSet findAllStudentAndCoursesFromStudies() throws SQLException {
		callDatabase();
		query = "SELECT s.ssn, s.studentName, st.courseCode FROM Student s JOIN Studies st "
				+ "ON s.ssn = st.ssn ";
		connections();
		return rs;

	}

	public ResultSet findGradeAFromHasStudied(String courseCode) throws SQLException {
		callDatabase();

		query = "SELECT courseCode, (Count(grade)* 100 / (Select Count(*) FROM HasStudied WHERE courseCode = '"	+ courseCode + "')) AS Score "
				+ "FROM HasStudied "
				+ "WHERE courseCode = '" + courseCode + "' "
				+ "GROUP BY grade, courseCode "
				+ "HAVING grade = 'A'";

		connections();
		return rs;
	}

	public ResultSet findCourseThroughput(String courseCode) throws SQLException {
		callDatabase();

		query = "SELECT courseCode, (SELECT count(*) FROM HasStudied WHERE grade != 'U' AND courseCode = '" + courseCode + "') * 100 / (SELECT count(*) FROM HasStudied WHERE courseCode = '" + courseCode + "') "
				+ " FROM HasStudied "
				+ "WHERE courseCode = '" + courseCode + "' "
				+ "GROUP BY courseCode";

		connections();
		return rs;
	}

	public void insertStudent(String ssn, String studentName, String phoneNumber, String address) throws SQLException {
		callDatabase();
		query = "INSERT INTO Student VALUES ('" + ssn + "', '" + studentName + "', '" + phoneNumber + "', '" + address
				+ "')";

		update();

	}

	public void insertCourse(String courseCode, String courseName, int courseCredit) throws SQLException {
		callDatabase();
		query = "INSERT INTO Course VALUES ('" + courseCode + "', '" + courseName + "' ," + courseCredit + ")";

		update();

	}

	public void courseFinished(String ssn, String courseCode, String grade) throws SQLException {

		callDatabase();
		query = "INSERT INTO HasStudied VALUES ('" + ssn + "', '" + courseCode + "' , '" + grade + "')";

		update();
	}

	public void registerStudentforCourse(String ssn, String courseCode) throws SQLException {
		callDatabase();

		query = "INSERT INTO Studies VALUES ('" + ssn + "', '" + courseCode + "')";

		update();

	}

	public void deleteStudent(String ssn) throws SQLException {
		callDatabase();
		query = "DELETE Student FROM Student WHERE ssn = ('" + ssn + "')";

		update();
	}

	public void deleteCourse(String courseCode) throws SQLException {
		callDatabase();
		query = "DELETE Course FROM Course WHERE courseCode = ('" + courseCode + "')";

		update();
	}

	public void deleteStudies(String ssn, String courseCode) throws SQLException {
		callDatabase();
		query = "DELETE Studies FROM Studies WHERE ssn = ('" + ssn + "')  AND courseCode = ('" + courseCode + "')";

		ps = con.prepareStatement(query);
		ps.execute();
		
	}

	public ResultSet getCurrentCredits(String ssn) throws SQLException {
		callDatabase();

		query = "SELECT SUM(c.courseCredit) FROM Course c JOIN Studies s ON c.courseCode = s.courseCode WHERE s.ssn = ('"
				+ ssn + "')";

		connections();
		return rs;
	}

	public ResultSet findStudentAndCourseFromHasStudied(String ssn, String courseCode) throws SQLException {
		callDatabase();
		query = "SELECT ssn, courseCode FROM HasStudied WHERE ssn = '" + ssn + "' AND courseCode = '" + courseCode
				+ "'";
		connections();
		return rs;

	}

	public ResultSet findStudentAndCourseFromStudies(String ssn, String courseCode) throws SQLException {
		callDatabase();
		query = "SELECT ssn, courseCode FROM Studies WHERE courseCode = '" + courseCode + "'" + "AND ssn = '" + ssn
				+ "'";

		connections();
		return rs;

	}
}