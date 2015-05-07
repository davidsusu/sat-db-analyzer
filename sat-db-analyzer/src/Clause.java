import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Clause {
	
	final private BigInteger number;

	// TODO: TreeSet
	private List<Integer> variablesCache = null;

	private Integer greatestVariableCache = null;
	
	public Clause(BigInteger number) {
		if (number.signum()==(-1)) {
			throw new RuntimeException("Number must be non negative");
		}
		this.number = number;
	}

	public Clause(List<Integer> variables) {
		List<Integer> sortedVariables = new ArrayList<Integer>(variables);
		Collections.sort(sortedVariables, new VariableSortComparator());
		StringBuilder radix3ReprBuilder = new StringBuilder();
		int lastVar = 0;
		for (Integer nextVar: sortedVariables) {
			int nextVarAbs = Math.abs(nextVar);
			for (int var=lastVar+1; var<nextVarAbs; var++) {
				radix3ReprBuilder.insert(0, '0');
			}
			radix3ReprBuilder.insert(0, (nextVar>0)?'1':'2');
			lastVar = nextVarAbs;
		}
		String radix3Repr = radix3ReprBuilder.toString();
		if (radix3Repr.isEmpty()) {
			this.number = new BigInteger("0");
		} else {
			this.number = new BigInteger(radix3Repr, 3);
		}
		this.variablesCache = sortedVariables;
	}

	public Clause(Integer... variables) {
		this(Arrays.asList(variables));
	}
	
	public BigInteger getNumber() {
		return number;
	}
	
	public List<Integer> getVariables() {
		if (variablesCache==null) {
			variablesCache = new ArrayList<Integer>();
			String radix3Repr = number.toString(3);
			int var = 0;
			for (int i=radix3Repr.length()-1; i>=0; i--) {
				var++;
				char digit = radix3Repr.charAt(i);
				if (digit=='1') {
					variablesCache.add(var);
				} else if (digit=='2') {
					variablesCache.add(-var);
				}
			}
		}
		return variablesCache;
	}

	public int getGreatestVariable() {
		if (greatestVariableCache==null) {
			if (variablesCache==null) {
				String radix3Repr = number.toString(3);
				if (radix3Repr.equals("0")) {
					greatestVariableCache = 0;
				} else {
					greatestVariableCache = radix3Repr.length();
				}
			} else if (variablesCache.isEmpty()) {
				greatestVariableCache = 0;
			} else {
				greatestVariableCache = variablesCache.get(variablesCache.size()-1);
			}
		}
		return greatestVariableCache;
	}
	
	@Override
	public String toString() {
		return getVariables().toString();
	}

	static public class VariableSortComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer var1, Integer var2) {
			return Integer.compare(Math.abs(var1), Math.abs(var2));
		}
		
	}
	
}
