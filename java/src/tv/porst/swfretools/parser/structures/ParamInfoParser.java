package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.List;

import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class ParamInfoParser {

	public static ParamInfo parse(final SWFBinaryParser parser, final EncodedU30 paramCount, final String fieldName) throws SWFParserException {

		final List<EncodedU30> paramNames = new ArrayList<EncodedU30>();

		for (int i=0;i<paramCount.value();i++) {
			paramNames.add(EncodedU30Parser.parse(parser, String.format(fieldName + "::param_name[%d]", i)));
		}

		return new ParamInfo(new EncodedU30List(paramNames));
	}

}
