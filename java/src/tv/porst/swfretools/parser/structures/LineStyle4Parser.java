package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUBits;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseFlag;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16If;
import tv.porst.splib.binaryparser.UBits;
import tv.porst.splib.binaryparser.Flag;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses LineStyle4 structures.
 * 
 * @author sp
 */
public final class LineStyle4Parser {

	/**
	 * Parses a LineStyle4 structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param fieldName Name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static LineStyle4 parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final UINT16 width = parseUINT16(parser, 0x00006, fieldName + "::Width");
		final UBits startCapStyle = parseUBits(parser, 2, 0x00006, fieldName + "::StartCapStyle");
		final UBits joinStyle = parseUBits(parser, 2, 0x00006, fieldName + "::JoinStyle");
		final Flag hasFillFlag = parseFlag(parser, 0x00006, fieldName + "::HasFillFlag");
		final Flag noHScaleFlag = parseFlag(parser, 0x00006, fieldName + "::NoHScaleFlag");
		final Flag noVScaleFlag = parseFlag(parser, 0x00006, fieldName + "::NoVScaleFlag");
		final Flag pixelHintingFlag = parseFlag(parser, 0x00006, fieldName + "::PixelHintingFlag");
		final UBits reserved = parseUBits(parser, 5, 0x00006, fieldName + "::Reserved");
		final Flag noClose = parseFlag(parser, 0x00006, fieldName + "::NoClose");
		final UBits endCapStyle = parseUBits(parser, 2, 0x00006, fieldName + "::EndCapStyle");
		final UINT16 miterLimitFactor = parseUINT16If(parser, 0x00006, joinStyle.value() == 2, fieldName + "::MiterLimitFactor");
		final RGBA color = RGBAParser.parseIf(parser, !hasFillFlag.value(), fieldName + "::Color");
		final FillStyle3 fillType = FillStyle3Parser.parseIf(parser, hasFillFlag, fieldName + "::FillType");

		return new LineStyle4(width, startCapStyle, joinStyle, hasFillFlag,
				noHScaleFlag, noVScaleFlag, pixelHintingFlag, reserved, noClose,
				endCapStyle, miterLimitFactor, color, fillType);
	}
}
