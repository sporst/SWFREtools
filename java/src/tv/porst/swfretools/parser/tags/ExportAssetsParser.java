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
 * Class for parsing ExportAssets tags.
 * 
 * @author sp
 */
public final class ExportAssetsParser {

	/**
	 * Parses an ExportAssets tag.
	 * 
	 * @param parser Provides the input data.
	 * @param header Previously parsed header of the tag.
	 * 
	 * @return Returns the parsed tag.
	 * 
	 * @throws SWFParserException Thrown if parsing the tag failed.
	 */
	public static ExportAssetsTag parse(final RecordHeader header, final SWFBinaryParser parser) throws SWFParserException {

		final UINT16 count= parseUINT16(parser, 0x00006, "ExportAssets::Count");

		final List<AssetTag> tags = new ArrayList<AssetTag>();

		for (int i=0;i<count.value();i++) {
			tags.add(AssetParser.parse(parser, String.format("ExportAssets::Tags[%d]", i)));
		}

		return new ExportAssetsTag(header, count, tags);
	}
}