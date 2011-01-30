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
 * Parses MorphLineStyle2 structures.
 * 
 * @author sp
 */
public final class MorphLineStyle2Parser {

	/**
	 * Parses a MorphLineStyle2 structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param fieldName Name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static MorphLineStyle2 parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final UINT16 startWidth = parseUINT16(parser, 0x00006, fieldName + "::StartWidth");
		final UINT16 endWidth = parseUINT16(parser, 0x00006, fieldName + "::EndWidth");
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
		final RGBA startColor = RGBAParser.parseIf(parser, !hasFillFlag.value(), fieldName + "::StartColor");
		final RGBA endColor = RGBAParser.parseIf(parser, !hasFillFlag.value(), fieldName + "::EndColor");
		final MorphFillStyle fillType = MorphFillStyleParser.parseIf(parser, hasFillFlag, fieldName + "::FillType");

		return new MorphLineStyle2(startWidth, endWidth, startCapStyle, joinStyle, hasFillFlag,
				noHScaleFlag, noVScaleFlag, pixelHintingFlag, reserved, noClose, endCapStyle,
				miterLimitFactor, startColor, endColor, fillType);
	}
}