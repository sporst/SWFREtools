package tv.porst.swfretools.parser.tags;

import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Class for parsing End tags.
 */
public final class EndParser {

	/**
	 * Parses an End tag.
	 * 
	 * @param header Previously parsed header of the tag.
	 * 
	 * @return Returns the parsed tag.
	 */
	public static EndTag parse(final RecordHeader header) {

		return new EndTag(header);
	}
}