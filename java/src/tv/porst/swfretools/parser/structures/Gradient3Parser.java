package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUBits;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.binaryparser.UBits;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses Gradient3 structures.
 * 
 * @author sp
 */
public final class Gradient3Parser {

	/**
	 * Parses a Gradient3 structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param fieldName Name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static Gradient3 parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final UBits spreadMode = parseUBits(parser, 2, 0x00006, fieldName + "::SpreadMode");
		final UBits interpolationMode = parseUBits(parser, 2, 0x00006, fieldName + "::InterpolationMode");
		final UBits numGradients = parseUBits(parser, 4, 0x00006, fieldName + "::NumGradients");

		final List<GradRecord3> gradientRecords = new ArrayList<GradRecord3>();

		for (int i=0;i<numGradients.value();i++) {
			gradientRecords.add(GradRecord3Parser.parse(parser, String.format(fieldName + "::GradientRecords[%d]", i)));
		}

		return new Gradient3(spreadMode, interpolationMode, numGradients, new GradRecord3List(gradientRecords));
	}
}