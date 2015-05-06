import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;


public class Formula {

	final private BigInteger number;
	
	public Formula(BigInteger number) {
		this.number = number.abs();
	}

	public Formula(List<Clause> clauses) {
		// TODO
		this.number = null;
	}

	public Formula(Clause... clauses) {
		this(Arrays.asList(clauses));
	}
	
	public BigInteger getNumber() {
		return number;
	}
	
	public List<Clause> getClauses() {
		// TODO
		return null;
	}
	
	public int getVariableCount() {
		// TODO
		return 1;
	}
	
}
