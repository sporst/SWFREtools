package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.List;

import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class OptionInfoParser {

	public static OptionInfo parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final EncodedU30 optionCount = EncodedU30Parser.parse(parser, fieldName + "::option_count");

		final List<OptionDetail> options = new ArrayList<OptionDetail>();

		for (int i=0;i<optionCount.value();i++) {
			options.add(OptionDetailParser.parse(parser, String.format(fieldName + "::option[%d]", i)));
		}

		return new OptionInfo(optionCount, new OptionDetailList(options));
	}
}
