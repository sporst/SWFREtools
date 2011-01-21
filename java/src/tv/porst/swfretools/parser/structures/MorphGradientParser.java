package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class MorphGradientParser {

	public static MorphGradient parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {
		final UINT8 numGradients = parser.readUInt8();

		final List<MorphGradientRecord> gradientRecords = new ArrayList<MorphGradientRecord>();

		for (int i=0;i<numGradients.value();i++) {
			gradientRecords.add(MorphGradientRecordParser.parse(parser, String.format(fieldName + "::GradientRecords[%d]", i)));
		}

		return new MorphGradient(numGradients, gradientRecords);
	}

}
