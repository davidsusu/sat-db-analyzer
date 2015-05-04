import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


public class Clause {

	final private BigInteger ZERO = new BigInteger("0");
	final private BigInteger ONE = new BigInteger("1");
	final private BigInteger TWO = new BigInteger("2");
	final private BigInteger THREE = new BigInteger("3");
	
	final private BigInteger number;
	
	public Clause(BigInteger number) {
		this.number = number.abs();
	}
	
	// TODO
	public List<Integer> getVariables() {
		List<Integer> result = new ArrayList<Integer>();
		BigInteger remainder = number;
		if (remainder.equals(ZERO)) {
			return result;
		}
		while (true) {
			int var = getLog3(remainder.subtract(ONE));
			if (var<1) {
				break;
			}
			BigInteger third = THREE.pow(var-1);
			BigInteger div = third.multiply(TWO);
			if (remainder.compareTo(div)>0) {
				var = -var;
				remainder = remainder.subtract(div);
			} else {
				remainder = remainder.subtract(third);
			}
			result.add(0, var);
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
	
	public int getLog3(BigInteger number) {
		int i = 0;
		BigInteger remainder = number;
		while(!remainder.equals(ZERO)) {
			remainder = remainder.divide(THREE);
			i++;
		}
		return i;
	}
	
}
