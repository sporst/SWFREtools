package tv.porst.swfretools.parser.tags;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.UINT16;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.AssetParser;
import tv.porst.swfretools.parser.structures.AssetTag;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Class for parsing SymbolClass tags.
 * 
 * @author sp
 */
public final class SymbolClassParser {

	/**
	 * Parses a SymbolClass tag.
	 * 
	 * @param parser Provides the input data.
	 * @param header Previously parsed header of the tag.
	 * 
	 * @return Returns the parsed tag.
	 * 
	 * @throws SWFParserException Thrown if parsing the tag failed.
	 */
	public static SymbolClassTag parse(final RecordHeader header, final SWFBinaryParser parser) throws SWFParserException {

		final UINT16 numSymbols = parseUINT16(parser, 0x00006, "SymbolClass::NumSymbols");

		final List<AssetTag> tags = new ArrayList<AssetTag>();

		for (int i=0;i<numSymbols.value();i++) {
			tags.add(AssetParser.parse(parser, String.format("SymbolClass::Tags[%d]", i)));
		}

		return new SymbolClassTag(header, numSymbols, tags);
	}
}