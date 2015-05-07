import java.util.List;

import org.sat4j.core.VecInt;
import org.sat4j.minisat.SolverFactory;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.ISolver;


public class FormulaValidator {
	
	final private int timeout;
	
	public FormulaValidator(int timeout) {
		this.timeout = timeout;
	}
	
	public boolean isSatisfiable(Formula formula) throws TimeoutException {
		ISolver solver = SolverFactory.newDefault();
		solver.setTimeout(timeout);
		solver.newVar(formula.getVariableCount());
		for (Clause clause: formula.getClauses()) {
			List<Integer> variables = clause.getVariables();
			int[] variablesArray = new int[variables.size()];
			int i = 0;
			for (Integer var: variables) {
				variablesArray[i] = var;
				i++;
			}
			try {
				solver.addClause(new VecInt(variablesArray));
			} catch (ContradictionException e) {
				return false;
			}
		}
		boolean satisfiable;
		try {
			satisfiable = solver.isSatisfiable();
		} catch (org.sat4j.specs.TimeoutException e) {
			throw new TimeoutException();
		}
		return satisfiable;
	}
	
	static public class TimeoutException extends Exception {
		
		private static final long serialVersionUID = 1L;
		
	}
	
}
