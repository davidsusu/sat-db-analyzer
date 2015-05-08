
public interface FormulaStorage extends Iterable<FormulaStorage.Row> {

	public void save(Row row);
	
	public Row load(Formula formula);
	
	static public class Row {

		final public Formula formula;
		
		final public boolean satisfiable;
		
		public Row(Formula formula, boolean satisfiable) {
			this.formula = formula;
			this.satisfiable = satisfiable;
		}
		
	}
	
}
