package tv.porst.swfretools.dissector.gui.main.flashtree.nodes;

import javax.swing.JPanel;

import tv.porst.swfretools.dissector.gui.main.panels.AS3CodePanel;
import tv.porst.swfretools.parser.actions.as3.AS3Instruction;
import tv.porst.swfretools.parser.actions.as3.AS3InstructionList;
import tv.porst.swfretools.parser.structures.AS3Code;

public class FlashAS3CodeNode extends FlashTreeNode<AS3Code> {

	private JPanel panel;

	public FlashAS3CodeNode(final String name, final AS3Code code) {
		super(name, code);

		createChildren();
	}

	private void createChildren() {

		final AS3InstructionList instructions = getUserObject().getInstructions();

		for (final AS3Instruction instruction : instructions) {

			//			switch (instruction.getOpcode().value()) {
			//			case AS3Opcodes.ADD: add(new FlashAS3SimpleInstructionNode("add", (AS3SimpleInstruction) instruction));
			//			case AS3Opcodes.ADDI: add(new FlashAS3SimpleInstructionNode("addi", (AS3SimpleInstruction) instruction));
			//			case AS3Opcodes.ASTYPE: return AS3AstypeParser.parse(parser, fieldName + "::astype");
			//			case AS3Opcodes.ASTYPELATE: add(new FlashAS3SimpleInstructionNode("astypelate", (AS3SimpleInstruction) instruction));
			//			case AS3Opcodes.BITAND: add(new FlashAS3SimpleInstructionNode("bitand", (AS3SimpleInstruction) instruction));
			//			case AS3Opcodes.BITNOT: add(new FlashAS3SimpleInstructionNode("bitnot", (AS3SimpleInstruction) instruction));
			//			case AS3Opcodes.BITOR: add(new FlashAS3SimpleInstructionNode("bitor", (AS3SimpleInstruction) instruction));
			//			case AS3Opcodes.BITXOR: add(new FlashAS3SimpleInstructionNode("bitxor", (AS3SimpleInstruction) instruction));
			//			case AS3Opcodes.CALL: return AS3CallParser.parse(parser, fieldName + "::call");
			//			case AS3Opcodes.CALLMETHOD: return AS3CallmethodParser.parse(parser, fieldName + "::callmethod");
			//			case AS3Opcodes.CALLPROPERTY: return AS3CallpropertyParser.parse(parser, fieldName + "::callproperty");
			//			case AS3Opcodes.CALLPROPLEX: return AS3CallproplexParser.parse(parser, fieldName + "::callproplex");
			//			case AS3Opcodes.CALLPROPVOID: return AS3CallpropvoidParser.parse(parser, fieldName + "::callpropvoid");
			//			case AS3Opcodes.CALLSTATIC: return AS3CallstaticParser.parse(parser, fieldName + "::callstatic");
			//			case AS3Opcodes.CALLSUPER: return AS3CallsuperParser.parse(parser, fieldName + "::callsuper");
			//			case AS3Opcodes.CALLSUPERVOID: return AS3CallsupervoidParser.parse(parser, fieldName + "::callsupervoid");
			//			case AS3Opcodes.CHECKFILTER: add(new FlashAS3SimpleInstructionNode("checkfilter", (AS3SimpleInstruction) instruction));
			//			case AS3Opcodes.COERCE: return AS3CoerceParser.parse(parser, fieldName + "::coerce");
			//			case AS3Opcodes.COERCEA: add(new FlashAS3SimpleInstructionNode("coerce_a", (AS3SimpleInstruction) instruction));
			//			case AS3Opcodes.COERCES: add(new FlashAS3SimpleInstructionNode("coerce_s", (AS3SimpleInstruction) instruction));
			//			case AS3Opcodes.CONSTRUCT: return AS3ConstructParser.parse(parser, fieldName + "::construct");
			//			case AS3Opcodes.CONSTRUCTPROP: return AS3ConstructpropParser.parse(parser, fieldName + "::constructprop");
			//			case AS3Opcodes.CONSTRUCTSUPER: return AS3ConstructsuperParser.parse(parser, fieldName + "::constructsuper");
			//			case AS3Opcodes.CONVERTB: add(new FlashAS3SimpleInstructionNode("convertb", (AS3SimpleInstruction) instruction));
			//			case AS3Opcodes.CONVERTI: add(new FlashAS3SimpleInstructionNode("converti", (AS3SimpleInstruction) instruction));
			//			case AS3Opcodes.CONVERTD: add(new FlashAS3SimpleInstructionNode("convertd", (AS3SimpleInstruction) instruction));
			//			case AS3Opcodes.CONVERTO: add(new FlashAS3SimpleInstructionNode("converto", (AS3SimpleInstruction) instruction));
			//			case AS3Opcodes.CONVERTS: add(new FlashAS3SimpleInstructionNode("converts", (AS3SimpleInstruction) instruction));
			//			case AS3Opcodes.CONVERTU: add(new FlashAS3SimpleInstructionNode("convertu", (AS3SimpleInstruction) instruction));
			//			case AS3Opcodes.DEBUG: return AS3DebugParser.parse(parser, fieldName + "::debug");
			//			case AS3Opcodes.DEBUGFILE: return AS3DebugfileParser.parse(parser, fieldName + "::debugfile");
			//			case AS3Opcodes.DEBUGLINE: return AS3DebuglineParser.parse(parser, fieldName + "::debugline");
			//			case AS3Opcodes.DECLOCAL: return AS3DeclocalParser.parse(parser, fieldName + "::declocal");
			//			case AS3Opcodes.DECLOCALI: return AS3DeclocaliParser.parse(parser, fieldName + "::declocal_i");
			//			case AS3Opcodes.DECREMENT: add(new FlashAS3SimpleInstructionNode("decrement", (AS3SimpleInstruction) instruction));
			//			case AS3Opcodes.DECREMENTI: add(new FlashAS3SimpleInstructionNode("decrement_i", (AS3SimpleInstruction) instruction));
			//			case AS3Opcodes.DELETEPROPERTY: return AS3DeletepropertyParser.parse(parser, fieldName + "::deleteproperty");
			//			case AS3Opcodes.DIVIDE: add(new FlashAS3SimpleInstructionNode("divide", (AS3SimpleInstruction) instruction));
			//			case AS3Opcodes.DUP: add(new FlashAS3SimpleInstructionNode("dup", (AS3SimpleInstruction) instruction));
			//			case AS3Opcodes.DXNS: return AS3DxnsParser.parse(parser, fieldName + "::dxns");
			//			case AS3Opcodes.DXNSLATE: add(new FlashAS3SimpleInstructionNode("dxnslate", (AS3SimpleInstruction) instruction));
			//			case AS3Opcodes.EQUALS: add(new FlashAS3SimpleInstructionNode("equals", (AS3SimpleInstruction) instruction));
			//			case AS3Opcodes.ESCXATTR: add(new FlashAS3SimpleInstructionNode("escx_attr", (AS3SimpleInstruction) instruction));
			//			case AS3Opcodes.ESCXELEM: add(new FlashAS3SimpleInstructionNode("escx_elem", (AS3SimpleInstruction) instruction));
			//			case AS3Opcodes.FINDPROPERTY: return AS3FindpropertyParser.parse(parser, fieldName + "::findproperty");
			//			case AS3Opcodes.FINDPROPSTRICT: return AS3FindpropstrictParser.parse(parser, fieldName + "::findpropstrict");
			//			case AS3Opcodes.GETDESCENDANTS: return AS3GetdescendantsParser.parse(parser, fieldName + "::getdescendants");
			//			case AS3Opcodes.GETGLOBALSCOPE: return AS3GetglobalscopeParser.parse(parser, fieldName + "::getglobalscope");
			//			case AS3Opcodes.GETGLOBALSLOT: return AS3GetglobalslotParser.parse(parser, fieldName + "::getglobalslot");
			//			case AS3Opcodes.GETLEX: return AS3GetlexParser.parse(parser, fieldName + "::getlex");
			//			case AS3Opcodes.GETLOCAL: return AS3GetlocalParser.parse(parser, fieldName + "::getlocal");
			//			case AS3Opcodes.GETLOCAL0: add(new FlashAS3SimpleInstructionNode("getlocal_0", (AS3SimpleInstruction) instruction));
			//			case AS3Opcodes.GETLOCAL1: add(new FlashAS3SimpleInstructionNode("getlocal_1", (AS3SimpleInstruction) instruction));
			//			case AS3Opcodes.GETLOCAL2: add(new FlashAS3SimpleInstructionNode("getlocal_2", (AS3SimpleInstruction) instruction));
			//			case AS3Opcodes.GETLOCAL3: add(new FlashAS3SimpleInstructionNode("getlocal_3", (AS3SimpleInstruction) instruction));
			//			case AS3Opcodes.GETPROPERTY: return AS3GetpropertyParser.parse(parser, fieldName + "::getproperty");
			//			case AS3Opcodes.GETSCOPEOBJECT: return AS3GetscopeobjectParser.parse(parser, fieldName + "::getscopeobject");
			//			case AS3Opcodes.GETSLOT: return AS3GetslotParser.parse(parser, fieldName + "::getslot");
			//			case AS3Opcodes.GETSUPER: return AS3GetsuperParser.parse(parser, fieldName + "::getsuper");
			//			case AS3Opcodes.GREATERTHAN: add(new FlashAS3SimpleInstructionNode("greater", (AS3SimpleInstruction) instruction));
			//			case AS3Opcodes.HASNEXT: return AS3HasnextParser.parse(parser, fieldName + "::hasnext");
			//			case AS3Opcodes.HASNEXT2: return AS3Hasnext2Parser.parse(parser, fieldName + "::hasnext2");
			//			case AS3Opcodes.IFEQ: return AS3IfeqParser.parse(parser, fieldName + "::ifeq");
			//			case AS3Opcodes.IFFALSE: return AS3IffalseParser.parse(parser, fieldName + "::iffalse");
			//			case AS3Opcodes.IFGE: return AS3IfgeParser.parse(parser, fieldName + "::ifge");
			//			case AS3Opcodes.IFGT: return AS3IfgtParser.parse(parser, fieldName + "::ifgt");
			//			case AS3Opcodes.IFLE: return AS3IfleParser.parse(parser, fieldName + "::ifle");
			//			case AS3Opcodes.IFLT: return AS3IfltParser.parse(parser, fieldName + "::iflt");
			//			case AS3Opcodes.IFNE: return AS3IfneParser.parse(parser, fieldName + "::ifne");
			//			case AS3Opcodes.IFNGE: return AS3IfngeParser.parse(parser, fieldName + "::ifnge");
			//			case AS3Opcodes.IFNGT: return AS3IfngtParser.parse(parser, fieldName + "::ifngt");
			//			case AS3Opcodes.IFNLE: return AS3IfnleParser.parse(parser, fieldName + "::ifnle");
			//			case AS3Opcodes.IFNLT: return AS3IfnltParser.parse(parser, fieldName + "::ifnlt");
			//			case AS3Opcodes.IFSTRICTEQ: return AS3IfstricteqParser.parse(parser, fieldName + "::ifstricteq");
			//			case AS3Opcodes.IFSTRICTNE: return AS3IfstrictneParser.parse(parser, fieldName + "::ifstrictne");
			//			case AS3Opcodes.IFTRUE: return AS3IftrueParser.parse(parser, fieldName + "::iftrue");
			//			case AS3Opcodes.IN: return AS3InParser.parse(parser, fieldName + "::in");
			//			case AS3Opcodes.INCLOCAL: return AS3InlocalParser.parse(parser, fieldName + "::inclocal");
			//			case AS3Opcodes.INCLOCALI: return AS3InlocaliParser.parse(parser, fieldName + "::inclocal_i");
			//			case AS3Opcodes.INCREMENT: return AS3IncrementParser.parse(parser, fieldName + "::increment");
			//			case AS3Opcodes.INCREMENTI: return AS3IncrementiParser.parse(parser, fieldName + "::increment_i");
			//			case AS3Opcodes.INITPROPERTY: return AS3InitpropertyParser.parse(parser, fieldName + "::initproperty");
			//			case AS3Opcodes.INSTANCEOF: return AS3InstanceofParser.parse(parser, fieldName + "::instanceof");
			//			case AS3Opcodes.ISTYPE: return AS3IstypeParser.parse(parser, fieldName + "::istype");
			//			case AS3Opcodes.ISTYPELATE: return AS3IstypelateParser.parse(parser, fieldName + "::istypelate");
			//			case AS3Opcodes.JUMP: return AS3JumpParser.parse(parser, fieldName + "::jump");
			//			case AS3Opcodes.KILL: return AS3KillParser.parse(parser, fieldName + "::kill");
			//			case AS3Opcodes.LABEL: return AS3LabelParser.parse(parser, fieldName + "::label");
			//			case AS3Opcodes.LESSEQUALS: return AS3LessequalsParser.parse(parser, fieldName + "::lessequals");
			//			case AS3Opcodes.LESSTHAN: return AS3LessthanParser.parse(parser, fieldName + "::lessthan");
			//			case AS3Opcodes.LOOKUPSWITCH: return AS3LookupswitchParser.parse(parser, fieldName + "::lookupswitch");
			//			case AS3Opcodes.LSHIFT: return AS3LshiftParser.parse(parser, fieldName + "::lshift");
			//			case AS3Opcodes.MODULO: return AS3ModuloParser.parse(parser, fieldName + "::modulo");
			//			case AS3Opcodes.MULTIPLY: return AS3MultiplyParser.parse(parser, fieldName + "::multiply");
			//			case AS3Opcodes.MULTIPLYI: return AS3MultiplyiParser.parse(parser, fieldName + "::multiply_i");
			//			case AS3Opcodes.NEGATE: return AS3NegateParser.parse(parser, fieldName + "::negate");
			//			case AS3Opcodes.NEGATEI: return AS3NegateiParser.parse(parser, fieldName + "::negate_i");
			//			case AS3Opcodes.NEWACTIVATION: return AS3NewactivationParser.parse(parser, fieldName + "::newactivation");
			//			case AS3Opcodes.NEWARRAY: return AS3NewarrayParser.parse(parser, fieldName + "::newarray");
			//			case AS3Opcodes.NEWCATCH: return AS3NewcatchParser.parse(parser, fieldName + "::newcatch");
			//			case AS3Opcodes.NEWCLASS: return AS3NewclassParser.parse(parser, fieldName + "::newclass");
			//			case AS3Opcodes.NEWFUNCTION: return AS3NewfunctionParser.parse(parser, fieldName + "::newfunction");
			//			case AS3Opcodes.NEWOBJECT: return AS3NewobjectParser.parse(parser, fieldName + "::newobject");
			//			case AS3Opcodes.NEXTNAME: return AS3NextnameParser.parse(parser, fieldName + "::nextname");
			//			case AS3Opcodes.NEXTVALUE: return AS3NextvalueParser.parse(parser, fieldName + "::nextvalue");
			//			case AS3Opcodes.NOP: return AS3NopParser.parse(parser, fieldName + "::nop");
			//			case AS3Opcodes.NOT: return AS3NotParser.parse(parser, fieldName + "::not");
			//			case AS3Opcodes.POP: return AS3PopParser.parse(parser, fieldName + "::pop");
			//			case AS3Opcodes.POPSCOPE: return AS3PopscopeParser.parse(parser, fieldName + "::popscope");
			//			case AS3Opcodes.PUSHBYTE: return AS3PushbyteParser.parse(parser, fieldName + "::pushbyte");
			//			case AS3Opcodes.PUSHDOUBLE: return AS3PushdoubleParser.parse(parser, fieldName + "::pushdouble");
			//			case AS3Opcodes.PUSHFALSE: return AS3PushfalseParser.parse(parser, fieldName + "::pushfalse");
			//			case AS3Opcodes.PUSHINT: return AS3PushintParser.parse(parser, fieldName + "::pushint");
			//			case AS3Opcodes.PUSHNAMESPACE: return AS3PushnamespaceParser.parse(parser, fieldName + "::pushnamespace");
			//			case AS3Opcodes.PUSHNAN: return AS3PushnanParser.parse(parser, fieldName + "::pushnan");
			//			case AS3Opcodes.PUSHNULL: return AS3PushnullParser.parse(parser, fieldName + "::pushnull");
			//			case AS3Opcodes.PUSHSCOPE: return AS3PushscopeParser.parse(parser, fieldName + "::pushscope");
			//			case AS3Opcodes.PUSHSHORT: return AS3PushshortParser.parse(parser, fieldName + "::pushshort");
			//			case AS3Opcodes.PUSHSTRING: return AS3PushstringParser.parse(parser, fieldName + "::pushstring");
			//			case AS3Opcodes.PUSHTRUE: return AS3PushtrueParser.parse(parser, fieldName + "::pushtrue");
			//			case AS3Opcodes.PUSHUINT: return AS3PushuintParser.parse(parser, fieldName + "::pushuint");
			//			case AS3Opcodes.PUSHUNDEFINED: return AS3PushundefinedParser.parse(parser, fieldName + "::pushundefined");
			//			case AS3Opcodes.PUSHWITH: return AS3PushwithParser.parse(parser, fieldName + "::pushwith");
			//			case AS3Opcodes.RETURNVALUE: return AS3ReturnvalueParser.parse(parser, fieldName + "::returnvalue");
			//			case AS3Opcodes.RETURNVOID: return AS3ReturnvoidParser.parse(parser, fieldName + "::returnvoid");
			//			case AS3Opcodes.RSHIFT: return AS3RshiftParser.parse(parser, fieldName + "::rshift");
			//			case AS3Opcodes.SETLOCAL: return AS3SetlocalParser.parse(parser, fieldName + "::setlocal");
			//			case AS3Opcodes.SETLOCAL0: return AS3Setlocal0Parser.parse(parser, fieldName + "::setlocal_0");
			//			case AS3Opcodes.SETLOCAL1: return AS3Setlocal1Parser.parse(parser, fieldName + "::setlocal_1");
			//			case AS3Opcodes.SETLOCAL2: return AS3Setlocal2Parser.parse(parser, fieldName + "::setlocal_2");
			//			case AS3Opcodes.SETLOCAL3: return AS3Setlocal3Parser.parse(parser, fieldName + "::setlocal_3");
			//			case AS3Opcodes.SETGLOBALSLOT: return AS3SetglobalslotParser.parse(parser, fieldName + "::setglobalslot");
			//			case AS3Opcodes.SETPROPERTY: return AS3SetpropertyParser.parse(parser, fieldName + "::setproperty");
			//			case AS3Opcodes.SETSLOT: return AS3SetslotParser.parse(parser, fieldName + "::setslot");
			//			case AS3Opcodes.SETSUPER: return AS3SetsuperParser.parse(parser, fieldName + "::setsuper");
			//			case AS3Opcodes.STRICTEQUALS: return AS3StrictequalsParser.parse(parser, fieldName + "::strictequals");
			//			case AS3Opcodes.SUBTRACT: return AS3SubtractParser.parse(parser, fieldName + "::subtract");
			//			case AS3Opcodes.SUBTRACTI: return AS3SubtractiParser.parse(parser, fieldName + "::subtract_i");
			//			case AS3Opcodes.SWAP: return AS3SwapParser.parse(parser, fieldName + "::swap");
			//			case AS3Opcodes.THROW: return AS3ThrowParser.parse(parser, fieldName + "::throw");
			//			case AS3Opcodes.TYPEOF: return AS3TypeofParser.parse(parser, fieldName + "::typeof");
			//			case AS3Opcodes.URSHIFT: return AS3UrshiftParser.parse(parser, fieldName + "::urshift");
			//			default: return AS3UnknownInstructionParser.parse(parser, fieldName + "::unknown");
			//			}
		}
	}

	public JPanel getExtraPanel() {

		if (panel == null) {
			panel = new AS3CodePanel(getUserObject());
		}

		return panel;
	}

	@Override
	public String toString() {
		return String.format("%s : code", getName());
	}
}
