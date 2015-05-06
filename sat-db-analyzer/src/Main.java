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

		// TODO
	}

}
