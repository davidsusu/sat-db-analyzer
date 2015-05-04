import java.util.HashMap;
import java.util.Map;

public class Globals {
	
	static private Map<String, String> variables = new HashMap<String, String>();
	
	static public void put(String name, String value) {
		variables.put(name, value);
	}

	static public String get(String name) {
		return variables.get(name);
	}

	static public void remove(String name) {
		variables.remove(name);
	}
	
}
