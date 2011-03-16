package tv.porst.swfretools.parser.actions.as3;

import java.util.ArrayList;
import java.util.List;

import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.AS3Code;

public class AS3CodeParser {

	private static AS3Instruction decodeInstruction(final SWFBinaryParser parser, final String fieldName) throws SWFParserException {
		final int opcode = parser.peekUInt8().value();

		switch (opcode) {
		case AS3Opcodes.ADD: return AS3AddParser.parse(parser, fieldName + "::add");
		case AS3Opcodes.ADDI: return AS3AddiParser.parse(parser, fieldName + "::add_i");
		case AS3Opcodes.ASTYPE: return AS3AstypeParser.parse(parser, fieldName + "::astype");
		case AS3Opcodes.ASTYPELATE: return AS3AstypelateParser.parse(parser, fieldName + "::astypelate");
		case AS3Opcodes.BITAND: return AS3BitandParser.parse(parser, fieldName + "::bitand");
		case AS3Opcodes.BITNOT: return AS3BitnotParser.parse(parser, fieldName + "::bitnot");
		case AS3Opcodes.BITOR: return AS3BitorParser.parse(parser, fieldName + "::bitor");
		case AS3Opcodes.BITXOR: return AS3BitxorParser.parse(parser, fieldName + "::bitxor");
		case AS3Opcodes.CALL: return AS3CallParser.parse(parser, fieldName + "::call");
		case AS3Opcodes.CALLMETHOD: return AS3CallmethodParser.parse(parser, fieldName + "::callmethod");
		case AS3Opcodes.CALLPROPERTY: return AS3CallpropertyParser.parse(parser, fieldName + "::callproperty");
		case AS3Opcodes.CALLPROPLEX: return AS3CallproplexParser.parse(parser, fieldName + "::callproplex");
		case AS3Opcodes.CALLPROPVOID: return AS3CallpropvoidParser.parse(parser, fieldName + "::callpropvoid");
		case AS3Opcodes.CALLSTATIC: return AS3CallstaticParser.parse(parser, fieldName + "::callstatic");
		case AS3Opcodes.CALLSUPER: return AS3CallsuperParser.parse(parser, fieldName + "::callsuper");
		case AS3Opcodes.CALLSUPERVOID: return AS3CallsupervoidParser.parse(parser, fieldName + "::callsupervoid");
		case AS3Opcodes.CHECKFILTER: return AS3CheckfilterParser.parse(parser, fieldName + "::checkfilter");
		case AS3Opcodes.COERCE: return AS3CoerceParser.parse(parser, fieldName + "::coerce");
		case AS3Opcodes.COERCEA: return AS3CoerceaParser.parse(parser, fieldName + "::coerce_a");
		case AS3Opcodes.COERCES: return AS3CoercesParser.parse(parser, fieldName + "::coerce_s");
		case AS3Opcodes.CONSTRUCT: return AS3ConstructParser.parse(parser, fieldName + "::construct");
		case AS3Opcodes.CONSTRUCTPROP: return AS3ConstructpropParser.parse(parser, fieldName + "::constructprop");
		case AS3Opcodes.CONSTRUCTSUPER: return AS3ConstructsuperParser.parse(parser, fieldName + "::constructsuper");
		case AS3Opcodes.CONVERTB: return AS3ConvertbParser.parse(parser, fieldName + "::convertb");
		case AS3Opcodes.CONVERTI: return AS3ConvertiParser.parse(parser, fieldName + "::converti");
		case AS3Opcodes.CONVERTD: return AS3ConvertdParser.parse(parser, fieldName + "::convertd");
		case AS3Opcodes.CONVERTO: return AS3ConvertoParser.parse(parser, fieldName + "::converto");
		case AS3Opcodes.CONVERTS: return AS3ConvertsParser.parse(parser, fieldName + "::converts");
		case AS3Opcodes.CONVERTU: return AS3ConvertuParser.parse(parser, fieldName + "::convertu");
		default: return AS3UnknownInstructionParser.parse(parser, fieldName + "::unknown");
		}
	}

	public static AS3Code parse(final SWFBinaryParser parser, final int length, final String fieldName) throws SWFParserException {

		final int end = parser.getBytePosition() + length;

		final List<AS3Instruction> instructions = new ArrayList<AS3Instruction>();

		while (parser.getBytePosition() < end) {
			instructions.add(decodeInstruction(parser, fieldName));
		}

		return new AS3Code();
	}
}
