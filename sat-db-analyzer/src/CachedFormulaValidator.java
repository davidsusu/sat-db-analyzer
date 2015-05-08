
public class CachedFormulaValidator implements FormulaValidator {

	final public FormulaValidator wrappedValidator;
	
	final public FormulaStorage storage;
	
	public CachedFormulaValidator(FormulaValidator wrappedValidator, FormulaStorage storage) {
		this.wrappedValidator = wrappedValidator;
		this.storage = storage;
	}
	
	@Override
	public boolean isSatisfiable(Formula formula) throws TimeoutException {
		FormulaStorage.Row row = storage.load(formula);
		if (row==null) {
			row = new FormulaStorage.Row(formula, wrappedValidator.isSatisfiable(formula));
			storage.save(row);
		}
		return row.satisfiable;
	}
	
}
