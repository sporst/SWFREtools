package tv.porst.swfretools.parser.tags;

import tv.porst.splib.binaryparser.BinaryParserHelpers;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.RecordHeader;


/**
 * Class for parsing DoAction tags.
 * 
 * @author sp
 */
public final class DoActionParser {

	/**
	 * Parses a DoAction tag.
	 * 
	 * @param parser Provides the input data.
	 * @param header Previously parsed header of the tag.
	 * 
	 * @return Returns the parsed tag.
	 * 
	 * @throws SWFParserException Thrown if parsing the tag failed.
	 */
	public static DoActionTag parse(final RecordHeader header, final SWFBinaryParser parser) throws SWFParserException {

		BinaryParserHelpers.readByteArray(parser, header.getNormalizedLength());

		return new DoActionTag(header);
	}
}