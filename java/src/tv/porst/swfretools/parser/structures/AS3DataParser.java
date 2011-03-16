package tv.porst.swfretools.parser.structures;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT16;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.binaryparser.UINT16;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

public class AS3DataParser {

	public static AS3Data parse(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {

		final UINT16 minorVersion = parseUINT16(parser, 0x00006, fieldName + "::minor_version");
		final UINT16 majorVersion = parseUINT16(parser, 0x00006, fieldName + "::major_version");
		final ConstantPool constantPool = ConstantPoolParser.parse(parser, fieldName + "::constant_pool");

		final EncodedU30 methodCount = EncodedU30Parser.parse(parser, fieldName + "::method_count");

		final List<MethodInfo> methodInfos = new ArrayList<MethodInfo>();

		for (int i=0;i<methodCount.value();i++) {
			methodInfos.add(MethodInfoParser.parse(parser, String.format(fieldName + "::method_info[%d]", i)));
		}

		final EncodedU30 metaDataCount = EncodedU30Parser.parse(parser, fieldName + "::metadata_count");

		final List<MetaData> metaData = new ArrayList<MetaData>();

		for (int i=0;i<metaDataCount.value();i++) {
			metaData.add(MetaDataParser.parse(parser, String.format(fieldName + "::metadata[%d]", i)));
		}

		final EncodedU30 classCount = EncodedU30Parser.parse(parser, fieldName + "::class_count");

		final List<InstanceInfo> instances = new ArrayList<InstanceInfo>();

		for (int i=0;i<classCount.value();i++) {
			instances.add(InstanceInfoParser.parse(parser, String.format(fieldName + "::instances[%d]", i)));
		}

		final List<ClassInfo> classes = new ArrayList<ClassInfo>();

		for (int i=0;i<classCount.value();i++) {
			classes.add(ClassInfoParser.parse(parser, String.format(fieldName + "::class[%d]", i)));
		}

		final EncodedU30 scriptCount = EncodedU30Parser.parse(parser, fieldName + "::script_count");

		final List<ScriptInfo> scripts = new ArrayList<ScriptInfo>();

		for (int i=0;i<scriptCount.value();i++) {
			scripts.add(ScriptInfoParser.parse(parser, String.format(fieldName + "::script[%d]", i)));
		}

		final EncodedU30 methodBodyCount = EncodedU30Parser.parse(parser, fieldName + "::method_body_count");

		System.out.println(methodBodyCount.value());
		System.exit(0);

		final List<MethodBody> methodBodies = new ArrayList<MethodBody>();

		for (int i=0;i<methodBodyCount.value();i++) {
			methodBodies.add(MethodBodyParser.parse(parser, String.format(fieldName + "::script[%d]", i)));
		}

		return new AS3Data(minorVersion, majorVersion, constantPool);
	}

}
