package tv.porst.swfretools.stats;

import java.util.HashMap;
import java.util.Map;

/**
 * Encapsulates the result of a stats generator run.
 */
public final class StatsResult {

	/**
	 * Maps tag IDs to how often the tags appeared in the processed files.
	 */
	private final Map<Integer, Integer> tagCounts;

	/**
	 * Creates a new stats result object.
	 * 
	 * @param tagCounts Maps tag IDs to how often the tags appeared in the processed files.
	 */
	public StatsResult(final Map<Integer, Integer> tagCounts) {

		if (tagCounts == null) {
			throw new IllegalArgumentException("Tag counts must not be null");
		}

		this.tagCounts = new HashMap<Integer, Integer>(tagCounts);
	}

	/**
	 * Returns how often individual tags were used in the processed files.
	 *
	 * @return A map that maps tag codes to counts.
	 */
	public Map<Integer, Integer> getTagCounts() {
		return new HashMap<Integer, Integer>(tagCounts);
	}
}