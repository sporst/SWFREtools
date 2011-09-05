package tv.porst.swfretools.parser.tags;

import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.AS3Data;
import tv.porst.swfretools.parser.structures.AS3DataParser;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Class for parsing RawABC tags.
 */
public final class RawABCParser {

	/**
	 * Parses a RawABC tag.
	 * 
	 * @param parser Provides the input data.
	 * @param header Previously parsed header of the tag.
	 * 
	 * @return Returns the parsed tag.
	 * 
	 * @throws SWFParserException Thrown if parsing the tag failed.
	 */
	public static RawABCTag parse(final RecordHeader header, final SWFBinaryParser parser) throws SWFParserException {

		final AS3Data abcData = AS3DataParser.parse(parser, "DoABC::ABCData");

		return new RawABCTag(header, abcData);
	}

}
