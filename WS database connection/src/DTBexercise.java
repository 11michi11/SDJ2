import java.sql.*;

public class DTBexercise {

	private static final String DRIVER = "org.postgresql.Driver";

	public static void main(String[] args) {

		try {
			String name = "postgres";
			String password = "12345";
			String url = "jdbc:postgresql://10.152.212.116:5432/postgres";

			Class.forName(DRIVER);
			Connection connection = DriverManager.getConnection(url, name, password);

			String sql = "SELECT student_no FROM students WHERE name=? AND study_line=? AND subject_id=? AND average=?";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, "Angelica");
			statement.setString(2, "Chemical Engineering and Food Technology");
			statement.setInt(3, 34386);
			statement.setDouble(4, 8.10);
			ResultSet rs = statement.executeQuery();

			rs.next();
			String noOfStudent = rs.getString(1);
			System.out.println("student number of Angelica is : " + noOfStudent);

			statement.close();
			connection.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
