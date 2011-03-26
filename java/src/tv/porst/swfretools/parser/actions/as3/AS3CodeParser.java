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
		case AS3Opcodes.DEBUG: return AS3DebugParser.parse(parser, fieldName + "::debug");
		case AS3Opcodes.DEBUGFILE: return AS3DebugfileParser.parse(parser, fieldName + "::debugfile");
		case AS3Opcodes.DEBUGLINE: return AS3DebuglineParser.parse(parser, fieldName + "::debugline");
		case AS3Opcodes.DECLOCAL: return AS3DeclocalParser.parse(parser, fieldName + "::declocal");
		case AS3Opcodes.DECLOCALI: return AS3DeclocaliParser.parse(parser, fieldName + "::declocal_i");
		case AS3Opcodes.DECREMENT: return AS3DecrementParser.parse(parser, fieldName + "::decrement");
		case AS3Opcodes.DECREMENTI: return AS3DecrementiParser.parse(parser, fieldName + "::decrement_i");
		case AS3Opcodes.DELETEPROPERTY: return AS3DeletepropertyParser.parse(parser, fieldName + "::deleteproperty");
		case AS3Opcodes.DIVIDE: return AS3DivideParser.parse(parser, fieldName + "::divide");
		case AS3Opcodes.DUP: return AS3DupParser.parse(parser, fieldName + "::dup");
		case AS3Opcodes.DXNS: return AS3DxnsParser.parse(parser, fieldName + "::dxns");
		case AS3Opcodes.DXNSLATE: return AS3DxnslateParser.parse(parser, fieldName + "::dxnslate");
		case AS3Opcodes.EQUALS: return AS3EqualsParser.parse(parser, fieldName + "::equals");
		case AS3Opcodes.ESCXATTR: return AS3EscxattrParser.parse(parser, fieldName + "::escx_attr");
		case AS3Opcodes.ESCXELEM: return AS3EscxelemParser.parse(parser, fieldName + "::escx_elem");
		case AS3Opcodes.FINDPROPERTY: return AS3FindpropertyParser.parse(parser, fieldName + "::findproperty");
		case AS3Opcodes.FINDPROPSTRICT: return AS3FindpropstrictParser.parse(parser, fieldName + "::findpropstrict");
		case AS3Opcodes.GETDESCENDANTS: return AS3GetdescendantsParser.parse(parser, fieldName + "::getdescendants");
		case AS3Opcodes.GETGLOBALSCOPE: return AS3GetglobalscopeParser.parse(parser, fieldName + "::getglobalscope");
		case AS3Opcodes.GETGLOBALSLOT: return AS3GetglobalslotParser.parse(parser, fieldName + "::getglobalslot");
		case AS3Opcodes.GETLEX: return AS3GetlexParser.parse(parser, fieldName + "::getlex");
		case AS3Opcodes.GETLOCAL: return AS3GetlocalParser.parse(parser, fieldName + "::getlocal");
		case AS3Opcodes.GETLOCAL0: return AS3Getlocal0Parser.parse(parser, fieldName + "::getlocal_0");
		case AS3Opcodes.GETLOCAL1: return AS3Getlocal1Parser.parse(parser, fieldName + "::getlocal_1");
		case AS3Opcodes.GETLOCAL2: return AS3Getlocal2Parser.parse(parser, fieldName + "::getlocal_2");
		case AS3Opcodes.GETLOCAL3: return AS3Getlocal3Parser.parse(parser, fieldName + "::getlocal_3");
		case AS3Opcodes.GETPROPERTY: return AS3GetpropertyParser.parse(parser, fieldName + "::getproperty");
		case AS3Opcodes.GETSCOPEOBJECT: return AS3GetscopeobjectParser.parse(parser, fieldName + "::getscopeobject");
		case AS3Opcodes.GETSLOT: return AS3GetslotParser.parse(parser, fieldName + "::getslot");
		case AS3Opcodes.GETSUPER: return AS3GetsuperParser.parse(parser, fieldName + "::getsuper");
		case AS3Opcodes.GREATERTHAN: return AS3GreaterthanParser.parse(parser, fieldName + "::greaterthan");
		case AS3Opcodes.HASNEXT: return AS3HasnextParser.parse(parser, fieldName + "::hasnext");
		case AS3Opcodes.HASNEXT2: return AS3Hasnext2Parser.parse(parser, fieldName + "::hasnext2");
		case AS3Opcodes.IFEQ: return AS3IfeqParser.parse(parser, fieldName + "::ifeq");
		case AS3Opcodes.IFFALSE: return AS3IffalseParser.parse(parser, fieldName + "::iffalse");
		case AS3Opcodes.IFGE: return AS3IfgeParser.parse(parser, fieldName + "::ifge");
		case AS3Opcodes.IFGT: return AS3IfgtParser.parse(parser, fieldName + "::ifgt");
		case AS3Opcodes.IFLE: return AS3IfleParser.parse(parser, fieldName + "::ifle");
		case AS3Opcodes.IFLT: return AS3IfltParser.parse(parser, fieldName + "::iflt");
		case AS3Opcodes.IFNE: return AS3IfneParser.parse(parser, fieldName + "::ifne");
		case AS3Opcodes.IFNGE: return AS3IfngeParser.parse(parser, fieldName + "::ifnge");
		case AS3Opcodes.IFNGT: return AS3IfngtParser.parse(parser, fieldName + "::ifngt");
		case AS3Opcodes.IFNLE: return AS3IfnleParser.parse(parser, fieldName + "::ifnle");
		case AS3Opcodes.IFNLT: return AS3IfnltParser.parse(parser, fieldName + "::ifnlt");
		case AS3Opcodes.IFSTRICTEQ: return AS3IfstricteqParser.parse(parser, fieldName + "::ifstricteq");
		case AS3Opcodes.IFSTRICTNE: return AS3IfstrictneParser.parse(parser, fieldName + "::ifstrictne");
		case AS3Opcodes.IFTRUE: return AS3IftrueParser.parse(parser, fieldName + "::iftrue");
		case AS3Opcodes.IN: return AS3InParser.parse(parser, fieldName + "::in");
		case AS3Opcodes.INCLOCAL: return AS3InlocalParser.parse(parser, fieldName + "::inclocal");
		case AS3Opcodes.INCLOCALI: return AS3InlocaliParser.parse(parser, fieldName + "::inclocal_i");
		case AS3Opcodes.INCREMENT: return AS3IncrementParser.parse(parser, fieldName + "::increment");
		case AS3Opcodes.INCREMENTI: return AS3IncrementiParser.parse(parser, fieldName + "::increment_i");
		case AS3Opcodes.INITPROPERTY: return AS3InitpropertyParser.parse(parser, fieldName + "::initproperty");
		case AS3Opcodes.INSTANCEOF: return AS3InstanceofParser.parse(parser, fieldName + "::instanceof");
		case AS3Opcodes.ISTYPE: return AS3IstypeParser.parse(parser, fieldName + "::istype");
		case AS3Opcodes.ISTYPELATE: return AS3IstypelateParser.parse(parser, fieldName + "::istypelate");
		case AS3Opcodes.JUMP: return AS3JumpParser.parse(parser, fieldName + "::jump");
		case AS3Opcodes.KILL: return AS3KillParser.parse(parser, fieldName + "::kill");
		case AS3Opcodes.LABEL: return AS3LabelParser.parse(parser, fieldName + "::label");
		case AS3Opcodes.LESSEQUALS: return AS3LessequalsParser.parse(parser, fieldName + "::lessequals");
		case AS3Opcodes.LESSTHAN: return AS3LessthanParser.parse(parser, fieldName + "::lessthan");
		case AS3Opcodes.LOOKUPSWITCH: return AS3LookupswitchParser.parse(parser, fieldName + "::lookupswitch");
		case AS3Opcodes.LSHIFT: return AS3LshiftParser.parse(parser, fieldName + "::lshift");
		case AS3Opcodes.MODULO: return AS3ModuloParser.parse(parser, fieldName + "::modulo");
		case AS3Opcodes.MULTIPLY: return AS3MultiplyParser.parse(parser, fieldName + "::multiply");
		case AS3Opcodes.MULTIPLYI: return AS3MultiplyiParser.parse(parser, fieldName + "::multiply_i");
		case AS3Opcodes.NEGATE: return AS3NegateParser.parse(parser, fieldName + "::negate");
		case AS3Opcodes.NEGATEI: return AS3NegateiParser.parse(parser, fieldName + "::negate_i");
		case AS3Opcodes.NEWACTIVATION: return AS3NewactivationParser.parse(parser, fieldName + "::newactivation");
		case AS3Opcodes.NEWARRAY: return AS3NewarrayParser.parse(parser, fieldName + "::newarray");
		case AS3Opcodes.NEWCATCH: return AS3NewcatchParser.parse(parser, fieldName + "::newcatch");
		case AS3Opcodes.NEWCLASS: return AS3NewclassParser.parse(parser, fieldName + "::newclass");
		case AS3Opcodes.NEWFUNCTION: return AS3NewfunctionParser.parse(parser, fieldName + "::newfunction");
		case AS3Opcodes.NEWOBJECT: return AS3NewobjectParser.parse(parser, fieldName + "::newobject");
		case AS3Opcodes.NEXTNAME: return AS3NextnameParser.parse(parser, fieldName + "::nextname");
		case AS3Opcodes.NEXTVALUE: return AS3NextvalueParser.parse(parser, fieldName + "::nextvalue");
		case AS3Opcodes.NOP: return AS3NopParser.parse(parser, fieldName + "::nop");
		case AS3Opcodes.NOT: return AS3NotParser.parse(parser, fieldName + "::not");
		case AS3Opcodes.POP: return AS3PopParser.parse(parser, fieldName + "::pop");
		case AS3Opcodes.POPSCOPE: return AS3PopscopeParser.parse(parser, fieldName + "::popscope");
		case AS3Opcodes.PUSHBYTE: return AS3PushbyteParser.parse(parser, fieldName + "::pushbyte");
		case AS3Opcodes.PUSHDOUBLE: return AS3PushdoubleParser.parse(parser, fieldName + "::pushdouble");
		case AS3Opcodes.PUSHFALSE: return AS3PushfalseParser.parse(parser, fieldName + "::pushfalse");
		case AS3Opcodes.PUSHINT: return AS3PushintParser.parse(parser, fieldName + "::pushint");
		case AS3Opcodes.PUSHNAMESPACE: return AS3PushnamespaceParser.parse(parser, fieldName + "::pushnamespace");
		case AS3Opcodes.PUSHNAN: return AS3PushnanParser.parse(parser, fieldName + "::pushnan");
		case AS3Opcodes.PUSHNULL: return AS3PushnullParser.parse(parser, fieldName + "::pushnull");
		case AS3Opcodes.PUSHSCOPE: return AS3PushscopeParser.parse(parser, fieldName + "::pushscope");
		case AS3Opcodes.PUSHSHORT: return AS3PushshortParser.parse(parser, fieldName + "::pushshort");
		case AS3Opcodes.PUSHSTRING: return AS3PushstringParser.parse(parser, fieldName + "::pushstring");
		case AS3Opcodes.PUSHTRUE: return AS3PushtrueParser.parse(parser, fieldName + "::pushtrue");
		case AS3Opcodes.PUSHUINT: return AS3PushuintParser.parse(parser, fieldName + "::pushuint");
		case AS3Opcodes.PUSHUNDEFINED: return AS3PushundefinedParser.parse(parser, fieldName + "::pushundefined");
		case AS3Opcodes.PUSHWITH: return AS3PushwithParser.parse(parser, fieldName + "::pushwith");
		case AS3Opcodes.RETURNVALUE: return AS3ReturnvalueParser.parse(parser, fieldName + "::returnvalue");
		case AS3Opcodes.RETURNVOID: return AS3ReturnvoidParser.parse(parser, fieldName + "::returnvoid");
		case AS3Opcodes.RSHIFT: return AS3RshiftParser.parse(parser, fieldName + "::rshift");
		case AS3Opcodes.SETLOCAL: return AS3SetlocalParser.parse(parser, fieldName + "::setlocal");
		case AS3Opcodes.SETLOCAL0: return AS3Setlocal0Parser.parse(parser, fieldName + "::setlocal_0");
		case AS3Opcodes.SETLOCAL1: return AS3Setlocal1Parser.parse(parser, fieldName + "::setlocal_1");
		case AS3Opcodes.SETLOCAL2: return AS3Setlocal2Parser.parse(parser, fieldName + "::setlocal_2");
		case AS3Opcodes.SETLOCAL3: return AS3Setlocal3Parser.parse(parser, fieldName + "::setlocal_3");
		case AS3Opcodes.SETGLOBALSLOT: return AS3SetglobalslotParser.parse(parser, fieldName + "::setglobalslot");
		case AS3Opcodes.SETPROPERTY: return AS3SetpropertyParser.parse(parser, fieldName + "::setproperty");
		case AS3Opcodes.SETSLOT: return AS3SetslotParser.parse(parser, fieldName + "::setslot");
		case AS3Opcodes.SETSUPER: return AS3SetsuperParser.parse(parser, fieldName + "::setsuper");
		case AS3Opcodes.STRICTEQUALS: return AS3StrictequalsParser.parse(parser, fieldName + "::strictequals");
		case AS3Opcodes.SUBTRACT: return AS3SubtractParser.parse(parser, fieldName + "::subtract");
		case AS3Opcodes.SUBTRACTI: return AS3SubtractiParser.parse(parser, fieldName + "::subtract_i");
		case AS3Opcodes.SWAP: return AS3SwapParser.parse(parser, fieldName + "::swap");
		case AS3Opcodes.THROW: return AS3ThrowParser.parse(parser, fieldName + "::throw");
		case AS3Opcodes.TYPEOF: return AS3TypeofParser.parse(parser, fieldName + "::typeof");
		case AS3Opcodes.URSHIFT: return AS3UrshiftParser.parse(parser, fieldName + "::urshift");
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
