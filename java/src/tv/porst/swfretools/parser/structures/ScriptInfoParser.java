package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.List;

import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class ScriptInfoParser {

	public static ScriptInfo parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final EncodedU30 init = EncodedU30Parser.parse(parser, fieldName + "::init");
		final EncodedU30 traitCount = EncodedU30Parser.parse(parser, fieldName + "::trait_count");

		final List<TraitsInfo> traits = new ArrayList<TraitsInfo>();

		for (int i=0;i<traitCount.value();i++) {
			traits.add(TraitsInfoParser.parse(parser, String.format(fieldName + "::traits[%d]", i)));
		}

		return new ScriptInfo(init, traitCount, new TraitsInfoList(traits));
	}

}
