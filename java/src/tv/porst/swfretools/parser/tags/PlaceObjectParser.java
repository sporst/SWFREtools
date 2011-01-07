package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.SWFParserHelpers;
import tv.porst.swfretools.parser.structures.CxForm;
import tv.porst.swfretools.parser.structures.CxFormParser;
import tv.porst.swfretools.parser.structures.Matrix;
import tv.porst.swfretools.parser.structures.MatrixParser;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Class for parsing a PlaceObject tag.
 * 
 * @author sp
 */
public final class PlaceObjectParser {

	/**
	 * Parses a PlaceObject tag.
	 * 
	 * @param parser Provides the input data.
	 * @param header Previously parsed header of the PlaceObject tag.
	 * 
	 * @return Returns the parsed tag.
	 * 
	 * @throws SWFParserException Thrown if parsing the tag failed.
	 */
	public static PlaceObjectTag parse(final SWFBinaryParser parser, final RecordHeader header) throws SWFParserException {

		parser.setTag(header.getPosition(), "PlaceObject");

		SWFParserHelpers.throwIf(parser, UINT16.LENGTH, 0x00006, "CharacterId");
		final UINT16 characterId = parser.readUInt16();

		SWFParserHelpers.throwIf(parser, UINT16.LENGTH, 0x00006, "Depth");
		final UINT16 depth = parser.readUInt16();

		final Matrix matrix = MatrixParser.parse(parser, "Matrix");

		final CxForm colorTransform = CxFormParser.parse(parser);

		return new PlaceObjectTag(header, characterId, depth, matrix, colorTransform);
	}

}
