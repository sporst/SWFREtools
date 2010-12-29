package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.BinaryParser;

public class MorphGradientParser {

	public static MorphGradient parse(final BinaryParser parser) {
		final int numGradients = parser.readUInt8();

		final List<MorphGradientRecord> gradientRecords = new ArrayList<MorphGradientRecord>();

		for (int i=0;i<numGradients;i++) {
			gradientRecords.add(MorphGradientRecordParser.parse(parser));
		}

		return new MorphGradient(numGradients, gradientRecords);
	}

}
