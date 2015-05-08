
public interface FormulaValidator {
	
	public boolean isSatisfiable(Formula formula) throws TimeoutException;
	
	static public class TimeoutException extends Exception {
		
		private static final long serialVersionUID = 1L;
		
	}
	
}
