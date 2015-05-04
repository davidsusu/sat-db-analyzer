import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;


public class Main {

	public static void main(String[] args) {
		String dbfile;
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
		Globals.put("dbfile", dbfile);

		// FIXME: zero instead of one?
		System.out.println("0 -> "+new Clause(new BigInteger("0")));
		System.out.println("1 -> "+new Clause(new BigInteger("1")));
		System.out.println("2 -> "+new Clause(new BigInteger("2")));
		System.out.println("3 -> "+new Clause(new BigInteger("3")));
		System.out.println("4 -> "+new Clause(new BigInteger("4")));
		System.out.println("5 -> "+new Clause(new BigInteger("5")));
		System.out.println("6 -> "+new Clause(new BigInteger("6")));
		System.out.println("7 -> "+new Clause(new BigInteger("7")));
		System.out.println("8 -> "+new Clause(new BigInteger("8")));
		System.out.println("9 -> "+new Clause(new BigInteger("9")));
		System.out.println("10 -> "+new Clause(new BigInteger("10")));
		System.out.println("11 -> "+new Clause(new BigInteger("11")));
		System.out.println("12 -> "+new Clause(new BigInteger("12")));
	}

}
