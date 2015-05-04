import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataBase {
	
	static private Connection connection = null;
	
	static public Connection getConnection() throws ClassNotFoundException, SQLException {
		if (connection==null) {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:"+Globals.get("dbfile"));
		}
		return connection;
	}
	
}
