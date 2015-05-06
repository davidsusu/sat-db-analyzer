import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


public class Clause {
	
	final private BigInteger number;
	
	public Clause(BigInteger number) {
		this.number = number.abs();
	}
	
	// TODO
	public List<Integer> getVariables() {
		String log3Repr = number.toString(3);
		List<Integer> result = new ArrayList<Integer>();
		int var = 0;
		for (int i=log3Repr.length()-1; i>=0; i--) {
			var++;
			char digit = log3Repr.charAt(i);
			if (digit=='1') {
				result.add(var);
			} else if (digit=='2') {
				result.add(-var);
			}
		}
		return result;
	}
	
	@Override
	public String toString() {
		StringBuilder resultBuilder = new StringBuilder();
		for (Integer var: getVariables()) {
			resultBuilder.append(var+" ");
		}
		return resultBuilder.toString();
	}
	
}
