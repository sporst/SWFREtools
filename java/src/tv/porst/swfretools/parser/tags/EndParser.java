package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.BinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Class for parsing End tags.
 * 
 * @author sp
 */
public final class EndParser {

	/**
	 * Parses an End tag.
	 * 
	 * @param parser Provides the input data.
	 * @param header Previously parsed header of the tag.
	 * 
	 * @return Returns the parsed tag.
	 * 
	 * @throws SWFParserException Thrown if parsing the tag failed.
	 */
	public static EndTag parse(final RecordHeader header, final BinaryParser parser) {

		return new EndTag(header);
	}
}