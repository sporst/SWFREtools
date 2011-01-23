package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses MorphGradient structures.
 * 
 * @author sp
 */
public final class MorphGradientParser {

	/**
	 * Parses a MorphGradient structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param fieldName Name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static MorphGradient parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final UINT8 numGradients = parseUINT8(parser, 0x00006, fieldName + "::NumGradients");

		final List<MorphGradientRecord> gradientRecords = new ArrayList<MorphGradientRecord>();

		for (int i=0;i<numGradients.value();i++) {
			gradientRecords.add(MorphGradientRecordParser.parse(parser, String.format(fieldName + "::GradientRecords[%d]", i)));
		}

		return new MorphGradient(numGradients, gradientRecords);
	}

	/**
	 * Parses a MorphGradient structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param condition which must be true for the structure to be parsed.
	 * @param fieldName Name of the structure in the parent structure.
	 * 
	 * @return The parsed structure or null if the passed condition was false.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static MorphGradient parseIf(final SWFBinaryParser parser, final boolean condition, final String fieldName) throws SWFParserException {
		return condition ? parse(parser, fieldName) : null;
	}
}