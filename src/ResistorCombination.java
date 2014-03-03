/**
 * A Combination is a set of resistors either parallel or series or combinations of both
 */
public class ResistorCombination
{
	/* Instance variables */
	Double value;
	String string;

	/**
	 * Default constructor for a single resistor
	 */
	public ResistorCombination(Double value)
	{
		this.value = value;
		this.string = value.toString();
	}

	/**
	 * Empty Constructor
	 */
	public ResistorCombination()
	{
		this.value = Double.POSITIVE_INFINITY;
		this.string = "";
	}

	/**
	 * @return the combination of the two inputs in serires
	 */
	static ResistorCombination series(ResistorCombination r1,
			ResistorCombination r2)
	{
		ResistorCombination result = new ResistorCombination();
		result.value = r1.value + r2.value;
		result.string = "( " + r1.string + " + " + r2.string + " )";
		return result;
	}

	/**
	 * @return the combination of the two inputs in serires
	 */
	static ResistorCombination parallel(ResistorCombination r1,
			ResistorCombination r2)
	{
		ResistorCombination result = new ResistorCombination();
		result.value = (r1.value * r2.value) / (r1.value + r2.value);
		result.string = "( " + r1.string + " // " + r2.string + " )";
		return result;
	}

	public String toString()
	{
		return "Value : " + this.value + "...Combination : " + this.string;
	}
}
