import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Formula {

	final private BigInteger number;

	// TODO: TreeSet
	private List<Clause> clausesCache = null;
	
	public Formula(BigInteger number) {
		if (number.signum()==(-1)) {
			throw new RuntimeException("Number must be non negative");
		}
		this.number = number;
	}

	public Formula(List<Clause> clauses) {
		List<Clause> sortedClauses = new ArrayList<Clause>(clauses);
		Collections.sort(sortedClauses, new ClauseSortComparator());
		BigInteger two = new BigInteger("2");
		BigInteger formulaNumber = new BigInteger("0");
		for (Clause clause : sortedClauses) {
			formulaNumber = formulaNumber.add(two.pow(clause.getNumber().intValue())); // FIXME: int! 
		}
		this.number = formulaNumber;
		this.clausesCache = sortedClauses;
	}

	public Formula(Clause... clauses) {
		this(Arrays.asList(clauses));
	}
	
	public BigInteger getNumber() {
		return number;
	}
	
	public List<Clause> getClauses() {
		if (clausesCache==null) {
			clausesCache = new ArrayList<Clause>();
			int numberLength = number.bitLength(); // FIXME: int!
			for (int i=0; i<numberLength; i++) {
				if (number.testBit(i)) {
					clausesCache.add(new Clause(new BigInteger(""+i)));
				}
			}
		}
		return clausesCache;
	}
	
	public int getVariableCount() {
		int variableCount = 0;
		for (Clause clause: getClauses()) {
			int greatestVariable = clause.getGreatestVariable();
			if (greatestVariable>variableCount) {
				variableCount = greatestVariable;
			}
		}
		return variableCount;
	}
	
	@Override
	public String toString() {
		return getClauses().toString();
	}
	
	static public class ClauseSortComparator implements Comparator<Clause> {

		@Override
		public int compare(Clause clause1, Clause clause2) {
			return clause1.getNumber().compareTo(clause2.getNumber());
		}
		
	}
	
}
