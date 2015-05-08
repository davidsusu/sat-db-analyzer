import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Iterator;


public class SqliteFormulaStorage implements FormulaStorage {
	
	final private Connection sqliteConnection;
	
	static private SqliteFormulaStorage _instance = null;
	
	static public SqliteFormulaStorage instance() {
		Connection connection = null;
		if (_instance==null) {
			try {
				Class.forName("org.sqlite.JDBC");
				connection = DriverManager.getConnection("jdbc:sqlite:"+Globals.get("dbfile"));
			} catch (Exception e) {
				// FIXME
				throw new RuntimeException("Can not open database file");
			}
			_instance = new SqliteFormulaStorage(connection);
		}
		return _instance;
	}
	
	public SqliteFormulaStorage(Connection sqliteConnection) {
		this.sqliteConnection = sqliteConnection;
		// TODO: init database
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
