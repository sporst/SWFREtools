package tv.porst.swfretools.parser.structures;

import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.SWFParserHelpers;

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

		SWFParserHelpers.throwIfB(parser, 1, 0x00007, fieldName + "::HasScale");
		final int hasScale = parser.readBits(1);

		SWFParserHelpers.throwIfB(parser, 5, 0x00008, fieldName + "::NScaleBits");
		final int nScaleBits = hasScale == 1 ? parser.readBits(5) : 0;

		SWFParserHelpers.throwIfB(parser, nScaleBits, 0x00009, fieldName + "::ScaleX");
		final int scaleX = hasScale == 1 ? parser.readBits(nScaleBits) : 0;

		SWFParserHelpers.throwIfB(parser, nScaleBits, 0x00010, fieldName + "::ScaleY");
		final int scaleY = hasScale == 1 ? parser.readBits(nScaleBits) : 0;

		SWFParserHelpers.throwIfB(parser, 1, 0x00011, fieldName + "::HasRotate");
		final int hasRotate = parser.readBits(1);

		SWFParserHelpers.throwIfB(parser, 5, 0x00012, fieldName + "::NRotateBits");
		final int nRotateBits = hasRotate == 1 ? parser.readBits(5) : 0;

		SWFParserHelpers.throwIfB(parser, nRotateBits, 0x00013, fieldName + "::RotateSkew0");
		final int rotateSkew0 = hasRotate == 1 ? parser.readBits(nRotateBits) : 0;

		SWFParserHelpers.throwIfB(parser, nRotateBits, 0x00014, fieldName + "::RotateSkew1");
		final int rotateSkew1 = hasRotate == 1 ? parser.readBits(nRotateBits) : 0;

		SWFParserHelpers.throwIfB(parser, 5, 0x00015, fieldName + "::NTranslateBits");
		final int nTranslateBits = parser.readBits(5);

		SWFParserHelpers.throwIfB(parser, nTranslateBits, 0x00016, fieldName + "::TranslateX");
		final int translateX = parser.readBits(nTranslateBits);

		SWFParserHelpers.throwIfB(parser, nTranslateBits, 0x00017, fieldName + "::TranslateY");
		final int translateY = parser.readBits(nTranslateBits);

		return new Matrix(hasScale, nScaleBits, scaleX, scaleY, hasRotate, nRotateBits, rotateSkew0, rotateSkew1, nTranslateBits, translateX, translateY);
	}
}
