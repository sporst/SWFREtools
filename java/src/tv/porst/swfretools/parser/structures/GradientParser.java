package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.Bits;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class GradientParser {

	public static Gradient parse(final SWFBinaryParser parser) throws SWFParserException {
		final Bits spreadMode = parser.readBits(2);
		final Bits interpolationMode = parser.readBits(2);
		final Bits numGradients = parser.readBits(4);

		final List<GradRecord> gradientRecords = new ArrayList<GradRecord>();

		for (int i=0;i<numGradients.value();i++) {
			gradientRecords.add(GradRecordParser.parse(parser, String.format("GradientRecord[%d]", i)));
		}

		return new Gradient(spreadMode, interpolationMode, numGradients, gradientRecords);
	}

}
