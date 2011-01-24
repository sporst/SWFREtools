package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseBits;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.Bits;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Parses FocalGradient structures.
 * 
 * @author sp
 *
 */
public final class FocalGradientParser {

	/**
	 * Parses a FocalGradient structure.
	 * 
	 * @param parser The parser that parses the structure.
	 * @param fieldName The name of the structure in the parent structure.
	 * 
	 * @return The parsed structure.
	 * 
	 * @throws SWFParserException Thrown if the structure could not be parsed.
	 */
	public static FocalGradient parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final Bits spreadMode = parseBits(parser, 2, 0x00006, fieldName + "::SpreadMode");
		final Bits interpolationMode = parseBits(parser, 2, 0x00006, fieldName + "::InterpolationMode");
		final Bits numGradients = parseBits(parser, 4, 0x00006, fieldName + "::NumGradients");

		final List<GradRecord> gradientRecords = new ArrayList<GradRecord>();

		for (int i=0;i<numGradients.value();i++) {
			gradientRecords.add(GradRecordParser.parse(parser, String.format("GradientRecord[%d]", i)));
		}

		final Fixed8 focalPoint = Fixed8Parser.parse(parser, fieldName + "::FocalPoint");

		return new FocalGradient(spreadMode, interpolationMode, numGradients, gradientRecords, focalPoint);
	}
}