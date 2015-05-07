import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		/*String dbfile;
		if (args.length==0) {
			System.out.print("Database file: ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			try {
				dbfile = reader.readLine();
			} catch (IOException e) {
				System.out.print("Can not read filename");
				System.exit(1);
				return;
			}
		} else {
			dbfile = args[0];
		}
		Globals.put("dbfile", dbfile);*/
		
		// FIXME
		Formula[] formulas = new Formula[]{
			new Formula(Arrays.asList(new Clause[]{new Clause()})),
			new Formula(Arrays.asList(new Clause[]{new Clause(-2, 4), new Clause(1, 2), new Clause(1, 3, -4)})),
			new Formula(Arrays.asList(new Clause[]{new Clause(1), new Clause(-1)})),
			new Formula(Arrays.asList(new Clause[]{new Clause(2)})),
		};
		
		FormulaValidator validator = new FormulaValidator(100);
		for (Formula formula : formulas) {
			System.out.println("---------------------------------");
			System.out.println(formula);
			try {
				System.out.println(validator.isSatisfiable(formula));
			} catch (FormulaValidator.TimeoutException e) {
				System.out.println("TIMEOUT");
			}
			
		}
		
		// TODO
	}

}
