package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.BinaryParser;

public class GradientParser {

	public static Gradient parse(final BinaryParser parser) {
		final int spreadMode = parser.readBits(2);
		final int interpolationMode = parser.readBits(2);
		final int numGradients = parser.readBits(4);

		final List<GradRecord> gradientRecords = new ArrayList<GradRecord>();

		for (int i=0;i<numGradients;i++) {
			gradientRecords.add(GradRecordParser.parse(parser));
		}

		return new Gradient(spreadMode, interpolationMode, numGradients, gradientRecords);
	}

}
