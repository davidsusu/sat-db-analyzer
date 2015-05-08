import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;


public class SqliteFormulaStorage implements FormulaStorage {

	static private Connection connection = null;
	
	static public Connection getConnection() throws ClassNotFoundException, SQLException {
		if (connection==null) {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:"+Globals.get("dbfile"));
		}
		return connection;
	}

	@Override
	public void save(Row row) {
		// TODO
	}

	@Override
	public Row load(Formula formula) {
		// TODO
		return null;
	}

	@Override
	public Iterator<Row> iterator() {
		// TODO
		return null;
	}
	
}
