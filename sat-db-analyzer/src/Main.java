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
		Formula formula1 = new Formula(Arrays.asList(new Clause[]{new Clause(-2, 4), new Clause(1, 2), new Clause(1, 3, -4)}));
		System.out.println(formula1+" => "+formula1.getNumber());

		Formula formula2 = new Formula(Arrays.asList(new Clause[]{new Clause(5)}));
		System.out.println(formula2+" => "+formula2.getNumber());
		
		// TODO
	}

}
