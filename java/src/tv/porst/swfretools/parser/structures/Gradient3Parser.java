package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.Bits;

public class Gradient3Parser {

	public static Gradient3 parse(final BinaryParser parser) {
		final Bits spreadMode = parser.readBits(2);
		final Bits interpolationMode = parser.readBits(2);
		final Bits numGradients = parser.readBits(4);

		final List<GradRecord3> gradientRecords = new ArrayList<GradRecord3>();

		for (int i=0;i<numGradients.value();i++) {
			gradientRecords.add(GradRecord3Parser.parse(parser));
		}

		return new Gradient3(spreadMode, interpolationMode, numGradients, gradientRecords);
	}

}
