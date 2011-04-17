package tv.porst.swfretools.parser.tags;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.CxForm;
import tv.porst.swfretools.parser.structures.CxFormParser;
import tv.porst.swfretools.parser.structures.Matrix;
import tv.porst.swfretools.parser.structures.MatrixParser;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Class for parsing PlaceObject tags.
 */
public final class PlaceObjectParser {

	/**
	 * Parses a PlaceObject tag.
	 * 
	 * @param parser Provides the input data.
	 * @param header Previously parsed header of the tag.
	 * 
	 * @return Returns the parsed tag.
	 * 
	 * @throws SWFParserException Thrown if parsing the tag failed.
	 */
	public static PlaceObjectTag parse(final SWFBinaryParser parser, final RecordHeader header) throws SWFParserException {

		final UINT16 characterId = parseUINT16(parser, 0x00006, "PlaceObject::CharacterId");
		final UINT16 depth = parseUINT16(parser, 0x00006, "PlaceObject::Depth");
		final Matrix matrix = MatrixParser.parse(parser, "PlaceObject::Matrix");
		final CxForm colorTransform = CxFormParser.parse(parser, "PlaceObject::CxForm");

		return new PlaceObjectTag(header, characterId, depth, matrix, colorTransform);
	}

}
