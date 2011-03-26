package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class InstanceInfoParser {

	public static InstanceInfo parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final EncodedU30 name = EncodedU30Parser.parse(parser, fieldName + "::name");
		final EncodedU30 superName = EncodedU30Parser.parse(parser, fieldName + "::super_name");
		final UINT8 flags = parseUINT8(parser, 0x00006, fieldName + "::flags");

		final EncodedU30 protectedNs = ((flags.value() & 0x08) == 0) ? null : EncodedU30Parser.parse(parser, fieldName + "::protectedNs");
		final EncodedU30 interfaceCount = EncodedU30Parser.parse(parser, fieldName + "::intrf_count");

		final List<EncodedU30> interfaces = new ArrayList<EncodedU30>();

		for (int i=0;i<interfaceCount.value();i++) {
			interfaces.add(EncodedU30Parser.parse(parser, String.format(fieldName + "::interface[%d]", i)));
		}

		final EncodedU30 iinit = EncodedU30Parser.parse(parser, fieldName + "::iinit");
		final EncodedU30 traitCount = EncodedU30Parser.parse(parser, fieldName + "::trait_count");

		final List<TraitsInfo> traits = new ArrayList<TraitsInfo>();

		for (int i=0;i<traitCount.value();i++) {
			traits.add(TraitsInfoParser.parse(parser, String.format(fieldName + "::trait[%d]", i)));
		}

		return new InstanceInfo(name, superName, flags, protectedNs, interfaceCount, new EncodedU30List(interfaces), iinit, traitCount, new TraitsInfoList(traits));
	}

}
