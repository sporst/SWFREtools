package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.UINT8;

public class MorphGradientParser {

	public static MorphGradient parse(final BinaryParser parser) {
		final UINT8 numGradients = parser.readUInt8();

		final List<MorphGradientRecord> gradientRecords = new ArrayList<MorphGradientRecord>();

		for (int i=0;i<numGradients.value();i++) {
			gradientRecords.add(MorphGradientRecordParser.parse(parser));
		}

		return new MorphGradient(numGradients, gradientRecords);
	}

}
