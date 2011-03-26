package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.binaryparser.Float64;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.SWFParserHelpers;

public class ConstantPoolParser {

	public static ConstantPool parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final EncodedU30 intCount = EncodedU30Parser.parse(parser, fieldName + "::int_count");

		final List<EncodedS32> integers = new ArrayList<EncodedS32>();

		for (int i=0;i<intCount.value() - 1;i++) {
			integers.add(EncodedS32Parser.parse(parser, String.format(fieldName + "::integer[%d]", i)));
		}

		final EncodedU30 uintCount = EncodedU30Parser.parse(parser, fieldName + "::uint_count");

		final List<EncodedU32> uintegers = new ArrayList<EncodedU32>();

		for (int i=0;i<uintCount.value() - 1;i++) {
			uintegers.add(EncodedU32Parser.parse(parser, String.format(fieldName + "::uinteger[%d]", i)));
		}

		final EncodedU30 doubleCount = EncodedU30Parser.parse(parser, fieldName + "::double_count");

		final List<Float64> doubles = new ArrayList<Float64>();

		for (int i=0;i<doubleCount.value() - 1;i++) {
			doubles.add(SWFParserHelpers.parseDouble(parser, 0x00006, String.format(fieldName + "::double[%d]", i)));
		}

		final EncodedU30 stringCount = EncodedU30Parser.parse(parser, fieldName + "::string_count");

		final List<StringInfo> strings = new ArrayList<StringInfo>();

		for (int i=0;i<stringCount.value() - 1;i++) {
			strings.add(StringInfoParser.parse(parser, String.format(fieldName + "::strings[%d]", i)));
		}

		final EncodedU30 namespaceCount = EncodedU30Parser.parse(parser, fieldName + "::namespace_count");

		final List<NamespaceInfo> namespaces = new ArrayList<NamespaceInfo>();

		for (int i=0;i<namespaceCount.value() - 1;i++) {
			namespaces.add(NamespaceInfoParser.parse(parser, String.format(fieldName + "::namespace[%d]", i)));
		}

		final EncodedU30 namespaceSetCount = EncodedU30Parser.parse(parser, fieldName + "::ns_set_count");

		final List<NamespaceSetInfo> namespaceSets = new ArrayList<NamespaceSetInfo>();

		for (int i=0;i<namespaceSetCount.value() - 1;i++) {
			namespaceSets.add(NamespaceSetInfoParser.parse(parser, String.format(fieldName + "::ns_set[%d]", i)));
		}

		final EncodedU30 multinameCount = EncodedU30Parser.parse(parser, fieldName + "::multiname_count");

		final List<MultinameInfo> multinames = new ArrayList<MultinameInfo>();

		for (int i=0;i<multinameCount.value() - 1;i++) {
			multinames.add(MultinameInfoParser.parse(parser, String.format(fieldName + "::multiname[%d]", i)));
		}

		return new ConstantPool(intCount, new EncodedS32List(integers), uintCount, new EncodedU32List(uintegers), doubleCount, new Float64List(doubles), stringCount, new StringInfoList(strings), namespaceCount, new NamespaceInfoList(namespaces), namespaceSetCount, new NamespaceSetInfoList(namespaceSets), multinameCount, new MultinameInfoList(multinames));
	}

}
