package tv.porst.swfretools.parser.tags;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseBits;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseFloat;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8;
import tv.porst.splib.io.Bits;
import tv.porst.splib.io.Float32;
import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Class for parsing CSMTextSettings tags.
 * 
 * @author sp
 */
public final class CSMTextSettingsParser {

	/**
	 * Parses a CSMTextSettings tag.
	 * 
	 * @param parser Provides the input data.
	 * @param header Previously parsed header of the tag.
	 * 
	 * @return Returns the parsed tag.
	 * 
	 * @throws SWFParserException Thrown if parsing the tag failed.
	 */
	public static CSMTextSettingsTag parse(final RecordHeader header, final SWFBinaryParser parser) throws SWFParserException {

		final UINT16 textId = parseUINT16(parser, 0x00006, "CSMTextSettings::TextId");
		final Bits useFlashType = parseBits(parser, 2, 0x00006, "CSMTextSettings::UseFlashType");
		final Bits gridFit = parseBits(parser, 3, 0x00006, "CSMTextSettings::GridFit");
		final Bits reserved = parseBits(parser, 3, 0x00006, "CSMTextSettings::Reserved");
		final Float32 thickness = parseFloat(parser, 0x00006, "CSMTextSettings::Thickness");
		final Float32 sharpness = parseFloat(parser, 0x00006, "CSMTextSettings::Sharpness");
		final UINT8 reserved2 = parseUINT8(parser, 0x00006, "CSMTextSettings::Reserveds");

		return new CSMTextSettingsTag(header, textId, useFlashType, gridFit, reserved, thickness, sharpness, reserved2);
	}
}