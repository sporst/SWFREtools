package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.BinaryParser;

public class Gradient3Parser {

	public static Gradient3 parse(final BinaryParser parser) {
		final int spreadMode = parser.readBits(2);
		final int interpolationMode = parser.readBits(2);
		final int numGradients = parser.readBits(4);

		final List<GradRecord3> gradientRecords = new ArrayList<GradRecord3>();

		for (int i=0;i<numGradients;i++) {
			gradientRecords.add(GradRecord3Parser.parse(parser));
		}

		return new Gradient3(spreadMode, interpolationMode, numGradients, gradientRecords);
	}

}
