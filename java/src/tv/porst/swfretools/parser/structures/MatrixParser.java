package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseBits;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseBitsIf;
import static tv.porst.swfretools.parser.SWFParserHelpers.parseFlag;
import tv.porst.splib.io.Flag;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Used to parse Matrix structures.
 * 
 * @author sp
 */
public final class MatrixParser {

	/**
	 * Parses a Matrix structure.
	 * 
	 * @param parser Provides the input data.
	 * @param fieldName Name of the matrix field that is parsed.
	 * 
	 * @return The parsed Matrix value.
	 * 
	 * @throws SWFParserException Thrown if parsing the Matrix value failed.
	 */
	public static Matrix parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		if (parser == null) {
			throw new IllegalArgumentException("Parser argument must not be null");
		}

		if (fieldName == null) {
			throw new IllegalArgumentException("Field name argument must not be null");
		}

		final Flag hasScale = parseFlag(parser, 0x00006, fieldName + "::HasScale");
		final int nScaleBits = parseBitsIf(parser, 5, 0x00006, hasScale.value(), fieldName + "::NScaleBits");
		final int scaleX = parseBitsIf(parser, nScaleBits, 0x00006, hasScale.value(), fieldName + "::ScaleX");
		final int scaleY = parseBitsIf(parser, nScaleBits, 0x00006, hasScale.value(), fieldName + "::ScaleY");
		final Flag hasRotate = parseFlag(parser, 0x00006, fieldName + "::HasRotate");
		final int nRotateBits = parseBitsIf(parser, 5, 0x00006, hasRotate.value(), fieldName + "::NRotateBits");
		final int rotateSkew0 = parseBitsIf(parser, nRotateBits, 0x00006, hasRotate.value(), fieldName + "::rotateSkew0");
		final int rotateSkew1 = parseBitsIf(parser, nRotateBits, 0x00006, hasRotate.value(), fieldName + "::rotateSkew1");
		final int nTranslateBits = parseBits(parser, 5, 0x00006, fieldName + "::NTranslateBits");
		final int translateX = parseBitsIf(parser, nTranslateBits, 0x00006, hasScale.value(), fieldName + "::TranslateX");
		final int translateY = parseBitsIf(parser, nTranslateBits, 0x00006, hasScale.value(), fieldName + "::TranslateY");

		return new Matrix(hasScale, nScaleBits, scaleX, scaleY, hasRotate, nRotateBits, rotateSkew0, rotateSkew1, nTranslateBits, translateX, translateY);
	}

	public static Matrix parseIf(final SWFBinaryParser parser, final Flag condition, final String fieldName) throws SWFParserException {
		return condition.value() ? parse(parser, fieldName) : null;
	}
}
