/*
 * Given a set of resistances and a target value, the solver will try to get the combination that
 * gives an equivalent value closest to the target value
 */
import java.util.Collections;
import java.util.LinkedList;

public class ResistorSetSolver
{
	/* The input from the user */
	private Double requiredValue;
	private long executionTime;
	private LinkedList<ResistorCombination> givenResistors;

	/* Things needed when computing */
	private long startTime;
	private ResistorCombination bestCombination;

	/**
	* The constructor
	 */
	public ResistorSetSolver(Double requiredValue, long executionTime,
			LinkedList<ResistorCombination> givenResistors)
	{
		this.requiredValue = requiredValue;
		this.executionTime = executionTime;
		this.givenResistors = givenResistors;

		startTime = System.currentTimeMillis();
		bestCombination = new ResistorCombination();
	}

	public ResistorCombination getBestCombination()
	{
		while(System.currentTimeMillis() - startTime < executionTime)
		{
			Collections.shuffle(givenResistors);
			LinkedList<ResistorCombination> combinationsList = (LinkedList<ResistorCombination>) givenResistors.clone();
			combine(combinationsList);
			
			System.out.println("The best :" + bestCombination);
			
			// If we already reached the best combination then break
			if (bestCombination.value.equals(requiredValue))
				break;
		}
		
		return bestCombination;
	}

	/**
	 * Pick the first two resistors once connect them parallel and once series
	 * then put the new combination in the list
	 */
	private void combine(LinkedList<ResistorCombination> combinationsList)
	{
		// Base case
		if (combinationsList.size() == 1)
		{
			competeWithTheBest(combinationsList.pop());
			return;
		} else if (combinationsList.size() == 0)
		{
			return;
		}

		Collections.shuffle(combinationsList);
		ResistorCombination r1 = combinationsList.pop();
		ResistorCombination r2 = combinationsList.pop();

		// Try neglecting both
		LinkedList<ResistorCombination> remaining = (LinkedList<ResistorCombination>) combinationsList
				.clone();
		combine(remaining);

		// Try neglecting r1
		LinkedList<ResistorCombination> r1Ignored = (LinkedList<ResistorCombination>) combinationsList
				.clone();
		r1Ignored.addFirst(r2);
		combine(r1Ignored);

		// Try neglecting r2
		LinkedList<ResistorCombination> r2Ignored = (LinkedList<ResistorCombination>) combinationsList
				.clone();
		r2Ignored.addFirst(r1);
		combine(r2Ignored);

		// Try r1 series with r2
		ResistorCombination seriesCombination = ResistorCombination.series(r1,
				r2);
		competeWithTheBest(seriesCombination);
		LinkedList<ResistorCombination> seriesRemaining = (LinkedList<ResistorCombination>) combinationsList
				.clone();
		seriesRemaining.addFirst(seriesCombination);
		combine(seriesRemaining);

		// Try r1 parallel with r2
		ResistorCombination parallelCombination = ResistorCombination.parallel(
				r1, r2);
		competeWithTheBest(parallelCombination);
		LinkedList<ResistorCombination> parallelRemaining = (LinkedList<ResistorCombination>) combinationsList
				.clone();
		parallelRemaining.addFirst(parallelCombination);
		combine(parallelRemaining);

	}

	private void competeWithTheBest(ResistorCombination competitor)
	{
		Double diffCompetitor = Math.abs(requiredValue - competitor.value);
		Double diffMax = Math.abs(requiredValue - bestCombination.value);
		if (diffCompetitor < diffMax)
			bestCombination = competitor;
	}

}
