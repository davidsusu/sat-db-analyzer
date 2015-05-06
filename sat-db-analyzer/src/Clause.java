import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Clause {
	
	final private BigInteger number;
	
	public Clause(BigInteger number) {
		this.number = number.abs();
	}

	public Clause(List<Integer> variables) {
		List<Integer> sortedVariables = new ArrayList<Integer>(variables);
		Collections.sort(sortedVariables);
		StringBuilder log3ReprBuilder = new StringBuilder();
		int lastVar = 0;
		for (Integer nextVar: sortedVariables) {
			int nextVarAbs = Math.abs(nextVar);
			for (int var=lastVar+1; var<nextVarAbs; var++) {
				log3ReprBuilder.insert(0, '0');
			}
			log3ReprBuilder.insert(0, (nextVar>0)?'1':'2');
			lastVar = nextVarAbs;
		}
		String log3Repr = log3ReprBuilder.toString();
		if (log3Repr.isEmpty()) {
			this.number = new BigInteger("0");
		} else {
			this.number = new BigInteger(log3Repr);
		}
	}

	public Clause(Integer... variables) {
		this(Arrays.asList(variables));
	}
	
	public BigInteger getNumber() {
		return number;
	}
	
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
		return getVariables().toString();
	}
	
}
