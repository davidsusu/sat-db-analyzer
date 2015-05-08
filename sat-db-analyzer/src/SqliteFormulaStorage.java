import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;


public class SqliteFormulaStorage implements FormulaStorage {
	
	final public String TABLENAME = "formula";
	
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
				throw new RuntimeException("Can not open database file", e);
			}
			_instance = new SqliteFormulaStorage(connection);
		}
		return _instance;
	}
	
	public SqliteFormulaStorage(Connection sqliteConnection) {
		this.sqliteConnection = sqliteConnection;
		try {
			init();
		} catch (SQLException e) {
			throw new RuntimeException("Can not initalize database file", e);
		}
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
	
	protected void init() throws SQLException {
		PreparedStatement statement = sqliteConnection.prepareStatement("SELECT name FROM sqlite_master WHERE type='table' AND name=?");
		statement.setString(0, TABLENAME);
		ResultSet resultSet = statement.executeQuery();
		if (resultSet.isAfterLast()) {
			PreparedStatement createStatement = sqliteConnection.prepareStatement("CREATE TABLE ? ()");
			createStatement.setString(0, TABLENAME);
			createStatement.execute();
		}
	}
	
}
