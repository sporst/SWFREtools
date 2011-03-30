package tv.porst.swfretools.dissector.gui.main.panels;

import tv.porst.swfretools.parser.actions.as3.*;
import tv.porst.swfretools.parser.structures.AS3Code;
import tv.porst.swfretools.parser.structures.MethodBody;
import tv.porst.swfretools.parser.tags.DoABCTag;

public class AS3CodePrinter {

	private static void add(final StringBuilder sb, final String mnemonic) {
		sb.append(mnemonic);
	}

	private static void add(final StringBuilder sb, final String mnemonic, final long value) {
		sb.append(String.format("%s %d", mnemonic, value));
	}

	private static void add(final StringBuilder sb, final String mnemonic, final long value1, final long value2) {
		sb.append(String.format("%s %d, %d", mnemonic, value1, value2));
	}

	private static void add(final StringBuilder sb, final String mnemonic, final long value1, final long value2, final long  value3, final long value4) {
		sb.append(String.format("%s %d, %d, %d, %d", mnemonic, value1, value2, value3, value4));
	}

	private static void addInstructionText(final StringBuilder sb, final AS3Instruction instruction) {

		new AS3Visitor() {

			@Override
			protected void visit(final AS3Add instruction) {
				add(sb, "add");
			}

			@Override
			protected void visit(final AS3Addi instruction) {
				add(sb, "addi");
			}

			@Override
			protected void visit(final AS3Astype instruction) {
				add(sb, "add", instruction.getIndex().value());
			}

			@Override
			protected void visit(final AS3Astypelate instruction) {
				add(sb, "typelate");
			}

			@Override
			protected void visit(final AS3Bitand instruction) {
				add(sb, "bitand");
			}

			@Override
			protected void visit(final AS3Bitnot instruction) {
				add(sb, "bitnot");
			}

			@Override
			protected void visit(final AS3Bitor instruction) {
				add(sb, "bitor");
			}

			@Override
			protected void visit(final AS3Bitxor instruction) {
				add(sb, "bitxor");
			}

			@Override
			protected void visit(final AS3Call instruction) {
				add(sb, "call", instruction.getArgCount().value());
			}

			@Override
			protected void visit(final AS3Callmethod instruction) {
				add(sb, "callmethod", instruction.getIndex().value(), instruction.getArgCount().value());
			}

			@Override
			protected void visit(final AS3Callproperty instruction) {
				add(sb, "callproperty", instruction.getIndex().value(), instruction.getArgCount().value());
			}

			@Override
			protected void visit(final AS3Callproplex instruction) {
				add(sb, "callproplex", instruction.getIndex().value(), instruction.getArgCount().value());
			}

			@Override
			protected void visit(final AS3Callpropvoid instruction) {
				add(sb, "callpropvoid", instruction.getIndex().value(), instruction.getArgCount().value());
			}

			@Override
			protected void visit(final AS3Callstatic instruction) {
				add(sb, "callstatic", instruction.getIndex().value(), instruction.getArgCount().value());
			}

			@Override
			protected void visit(final AS3Callsuper instruction) {
				add(sb, "callsuper", instruction.getIndex().value(), instruction.getArgCount().value());
			}

			@Override
			protected void visit(final AS3Callsupervoid instruction) {
				add(sb, "callsupervoid", instruction.getIndex().value(), instruction.getArgCount().value());
			}

			@Override
			protected void visit(final AS3Checkfilter instruction) {
				add(sb, "checkfilter");
			}

			@Override
			protected void visit(final AS3Coerce instruction) {
				add(sb, "coerce", instruction.getIndex().value());
			}

			@Override
			protected void visit(final AS3Coercea instruction) {
				add(sb, "coerce_a");
			}

			@Override
			protected void visit(final AS3Coerces instruction) {
				add(sb, "coerce_s");
			}

			@Override
			protected void visit(final AS3Construct instruction) {
				add(sb, "construct", instruction.getIndex().value());
			}

			@Override
			protected void visit(final AS3Constructprop instruction) {
				add(sb, "constructprop", instruction.getIndex().value(), instruction.getArgCount().value());
			}

			@Override
			protected void visit(final AS3Constructsuper instruction) {
				add(sb, "constructsuper", instruction.getIndex().value());
			}

			@Override
			protected void visit(final AS3Convertb instruction) {
				add(sb, "convert_b");
			}

			@Override
			protected void visit(final AS3Convertd instruction) {
				add(sb, "convert_d");
			}

			@Override
			protected void visit(final AS3Converti instruction) {
				add(sb, "convert_i");
			}

			@Override
			protected void visit(final AS3Converto instruction) {
				add(sb, "convert_o");
			}

			@Override
			protected void visit(final AS3Converts instruction) {
				add(sb, "convert_s");
			}

			@Override
			protected void visit(final AS3Convertu instruction) {
				add(sb, "convert_u");
			}

			@Override
			protected void visit(final AS3Debug instruction) {
				add(sb, "debug", instruction.getDebugType().value(), instruction.getIndex().value(), instruction.getReg().value(), instruction.getExtra().value());
			}

			@Override
			protected void visit(final AS3Debugfile instruction) {
				add(sb, "debugfile", instruction.getIndex().value());
			}

			@Override
			protected void visit(final AS3Debugline instruction) {
				add(sb, "debugline", instruction.getLineNum().value());
			}

			@Override
			protected void visit(final AS3Declocal instruction) {
				add(sb, "declocal", instruction.getIndex().value());
			}

			@Override
			protected void visit(final AS3Declocali instruction) {
				add(sb, "declocal_i", instruction.getIndex().value());
			}

			@Override
			protected void visit(final AS3Decrement instruction) {
				add(sb, "decrement");
			}

			@Override
			protected void visit(final AS3Decrementi instruction) {
				add(sb, "decrement_i");
			}

			@Override
			protected void visit(final AS3Deleteproperty instruction) {
				add(sb, "deletproperty", instruction.getIndex().value());
			}

			@Override
			protected void visit(final AS3Divide instruction) {
				add(sb, "divide");
			}

			@Override
			protected void visit(final AS3Dup instruction) {
				add(sb, "dup");
			}

			@Override
			protected void visit(final AS3Dxns instruction) {
				add(sb, "dxns", instruction.getIndex().value());
			}

			@Override
			protected void visit(final AS3Dxnslate instruction) {
				add(sb, "dxns_late");
			}

			@Override
			protected void visit(final AS3Equals instruction) {
				add(sb, "equals");
			}

			@Override
			protected void visit(final AS3Escxattr instruction) {
				add(sb, "escx_attr");
			}

			@Override
			protected void visit(final AS3Escxelem instruction) {
				add(sb, "escx_elem");
			}

			@Override
			protected void visit(final AS3Findproperty instruction) {
				add(sb, "findproperty", instruction.getIndex().value());
			}

			@Override
			protected void visit(final AS3Findpropstrict instruction) {
				add(sb, "findpropstrict", instruction.getIndex().value());
			}

			@Override
			protected void visit(final AS3Getdescendants instruction) {
				add(sb, "getdescendants", instruction.getIndex().value());
			}

			@Override
			protected void visit(final AS3Getglobalscope instruction) {
				add(sb, "getglobalscope");
			}

			@Override
			protected void visit(final AS3Getglobalslot instruction) {
				add(sb, "getglobalslot");
			}

			@Override
			protected void visit(final AS3Getlex instruction) {
				add(sb, "getlex", instruction.getIndex().value());
			}

			@Override
			protected void visit(final AS3Getlocal instruction) {
				add(sb, "getlocal", instruction.getIndex().value());
			}

			@Override
			protected void visit(final AS3Getlocal0 instruction) {
				add(sb, "getlocal_0");
			}

			@Override
			protected void visit(final AS3Getlocal1 instruction) {
				add(sb, "getlocal_1");
			}

			@Override
			protected void visit(final AS3Getlocal2 instruction) {
				add(sb, "getlocal_2");
			}

			@Override
			protected void visit(final AS3Getlocal3 instruction) {
				add(sb, "getlocal_3");
			}

			@Override
			protected void visit(final AS3Getproperty instruction) {
				add(sb, "getproperty", instruction.getIndex().value());
			}

			@Override
			protected void visit(final AS3Getscopeobject instruction) {
				add(sb, "getscopeobject", instruction.getIndex().value());
			}

			@Override
			protected void visit(final AS3Getslot instruction) {
				add(sb, "getslot", instruction.getSlotIndex().value());
			}

			@Override
			protected void visit(final AS3Getsuper instruction) {
				add(sb, "getsuper", instruction.getIndex().value());
			}

			@Override
			protected void visit(final AS3Greaterthan instruction) {
				add(sb, "greaterthan");
			}

			@Override
			protected void visit(final AS3Hasnext instruction) {
				add(sb, "hasnext");
			}

			@Override
			protected void visit(final AS3Hasnext2 instruction) {
				add(sb, "hasnext", instruction.getObjectReg().value(), instruction.getIndexReg().value());
			}

			@Override
			protected void visit(final AS3Ifeq instruction) {
				add(sb, "ifeq", instruction.getOffset().value());
			}

			@Override
			protected void visit(final AS3Iffalse instruction) {
				add(sb, "iffalse", instruction.getOffset().value());
			}

			@Override
			protected void visit(final AS3Ifge instruction) {
				add(sb, "ifge", instruction.getOffset().value());
			}

			@Override
			protected void visit(final AS3Ifgt instruction) {
				add(sb, "ifgt", instruction.getOffset().value());
			}

			@Override
			protected void visit(final AS3Ifle instruction) {
				add(sb, "ifle", instruction.getOffset().value());
			}

			@Override
			protected void visit(final AS3Iflt instruction) {
				add(sb, "iflt", instruction.getOffset().value());
			}

			@Override
			protected void visit(final AS3Ifne instruction) {
				add(sb, "ifne", instruction.getOffset().value());
			}

			@Override
			protected void visit(final AS3Ifnge instruction) {
				add(sb, "ifnge", instruction.getOffset().value());
			}

			@Override
			protected void visit(final AS3Ifngt instruction) {
				add(sb, "ifngt", instruction.getOffset().value());
			}

			@Override
			protected void visit(final AS3Ifnle instruction) {
				add(sb, "ifnle", instruction.getOffset().value());
			}

			@Override
			protected void visit(final AS3Ifnlt instruction) {
				add(sb, "ifnlt", instruction.getOffset().value());
			}

			@Override
			protected void visit(final AS3Ifstricteq instruction) {
				add(sb, "ifstricteq", instruction.getOffset().value());
			}

			@Override
			protected void visit(final AS3Ifstrictne instruction) {
				add(sb, "ifstrictne", instruction.getOffset().value());
			}

			@Override
			protected void visit(final AS3Iftrue instruction) {
				add(sb, "iftrue", instruction.getOffset().value());
			}

			@Override
			protected void visit(final AS3In instruction) {
				add(sb, "in");
			}

			@Override
			protected void visit(final AS3Increment instruction) {
				add(sb, "increment");
			}

			@Override
			protected void visit(final AS3Incrementi instruction) {
				add(sb, "increment_i");
			}

			@Override
			protected void visit(final AS3Initproperty instruction) {
				add(sb, "initproperty", instruction.getIndex().value());

			}

			@Override
			protected void visit(final AS3Inlocal instruction) {
				add(sb, "inlocal", instruction.getIndex().value());
			}

			@Override
			protected void visit(final AS3Inlocali instruction) {
				add(sb, "inlocal_i", instruction.getIndex().value());
			}

			@Override
			protected void visit(final AS3Instanceof instruction) {
				add(sb, "instanceof");
			}

			@Override
			protected void visit(final AS3Istype instruction) {
				add(sb, "istype", instruction.getIndex().value());
			}

			@Override
			protected void visit(final AS3Istypelate instruction) {
				add(sb, "istypelate");
			}

			@Override
			protected void visit(final AS3Jump instruction) {
				add(sb, "jump", instruction.getOffset().value());
			}

			@Override
			protected void visit(final AS3Kill instruction) {
				add(sb, "kill", instruction.getIndex().value());
			}

			@Override
			protected void visit(final AS3Label instruction) {
				add(sb, "label");
			}

			@Override
			protected void visit(final AS3Lessequals instruction) {
				add(sb, "lessequals");
			}

			@Override
			protected void visit(final AS3Lessthan instruction) {
				add(sb, "lessthan");
			}

			@Override
			protected void visit(final AS3Lookupswitch instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final AS3Lshift instruction) {
				add(sb, "lshift");
			}

			@Override
			protected void visit(final AS3Modulo instruction) {
				add(sb, "modulo");
			}

			@Override
			protected void visit(final AS3Multiply instruction) {
				add(sb, "multiply");
			}

			@Override
			protected void visit(final AS3Multiplyi instruction) {
				add(sb, "multiply_i");
			}

			@Override
			protected void visit(final AS3Negate instruction) {
				add(sb, "negate");
			}

			@Override
			protected void visit(final AS3Negatei instruction) {
				add(sb, "negate_i");
			}

			@Override
			protected void visit(final AS3Newactivation instruction) {
				add(sb, "newactivation");
			}

			@Override
			protected void visit(final AS3Newarray instruction) {
				add(sb, "newarray", instruction.getArgCount().value());
			}

			@Override
			protected void visit(final AS3Newcatch instruction) {
				add(sb, "newcatch", instruction.getIndex().value());
			}

			@Override
			protected void visit(final AS3Newclass instruction) {
				add(sb, "newclass", instruction.getIndex().value());
			}

			@Override
			protected void visit(final AS3Newfunction instruction) {
				add(sb, "newfunction", instruction.getIndex().value());
			}

			@Override
			protected void visit(final AS3Newobject instruction) {
				add(sb, "newcatch", instruction.getIndex().value());
			}

			@Override
			protected void visit(final AS3Nextname instruction) {
				add(sb, "nextname");
			}

			@Override
			protected void visit(final AS3Nextvalue instruction) {
				add(sb, "nextvalue");
			}

			@Override
			protected void visit(final AS3Nop instruction) {
				add(sb, "nop");
			}

			@Override
			protected void visit(final AS3Not instruction) {
				add(sb, "not");
			}

			@Override
			protected void visit(final AS3Pop instruction) {
				add(sb, "pop");
			}

			@Override
			protected void visit(final AS3Popscope instruction) {
				add(sb, "popscope");
			}

			@Override
			protected void visit(final AS3Pushbyte instruction) {
				add(sb, "pushbyte", instruction.getByteValue().value());
			}

			@Override
			protected void visit(final AS3Pushdouble instruction) {
				add(sb, "pushdouble", instruction.getIndex().value());
			}

			@Override
			protected void visit(final AS3Pushfalse instruction) {
				add(sb, "pushfalse");
			}

			@Override
			protected void visit(final AS3Pushint instruction) {
				add(sb, "pushint", instruction.getIndex().value());
			}

			@Override
			protected void visit(final AS3Pushnamespace instruction) {
				add(sb, "pushnamespace", instruction.getIndex().value());
			}

			@Override
			protected void visit(final AS3Pushnan instruction) {
				add(sb, "pushnan");
			}

			@Override
			protected void visit(final AS3Pushnull instruction) {
				add(sb, "pushnull");
			}

			@Override
			protected void visit(final AS3Pushscope instruction) {
				add(sb, "pushscope");
			}

			@Override
			protected void visit(final AS3Pushshort instruction) {
				add(sb, "pushshort", instruction.getIndex().value());
			}

			@Override
			protected void visit(final AS3Pushstring instruction) {
				add(sb, "pushstring", instruction.getIndex().value());
			}

			@Override
			protected void visit(final AS3Pushtrue instruction) {
				add(sb, "pushtrue");
			}

			@Override
			protected void visit(final AS3Pushuint instruction) {
				add(sb, "pushuint", instruction.getIndex().value());
			}

			@Override
			protected void visit(final AS3Pushundefined instruction) {
				add(sb, "pushundefined");
			}

			@Override
			protected void visit(final AS3Pushwith instruction) {
				add(sb, "pushwith");
			}

			@Override
			protected void visit(final AS3Returnvalue instruction) {
				add(sb, "returnvalue");
			}

			@Override
			protected void visit(final AS3Returnvoid instruction) {
				add(sb, "returnvoid");
			}

			@Override
			protected void visit(final AS3Rshift instruction) {
				add(sb, "rshift");
			}

			@Override
			protected void visit(final AS3Setglobalslot instruction) {
				add(sb, "setglobalslot", instruction.getSlotIndex().value());
			}

			@Override
			protected void visit(final AS3Setlocal instruction) {
				add(sb, "setlocal", instruction.getIndex().value());
			}

			@Override
			protected void visit(final AS3Setlocal0 instruction) {
				add(sb, "setlocal_0");
			}

			@Override
			protected void visit(final AS3Setlocal1 instruction) {
				add(sb, "setlocal_1");
			}

			@Override
			protected void visit(final AS3Setlocal2 instruction) {
				add(sb, "setlocal_2");
			}

			@Override
			protected void visit(final AS3Setlocal3 instruction) {
				add(sb, "setlocal_3");
			}

			@Override
			protected void visit(final AS3Setproperty instruction) {
				add(sb, "setproperty", instruction.getIndex().value());
			}

			@Override
			protected void visit(final AS3Setslot instruction) {
				add(sb, "setslot", instruction.getSlotIndex().value());
			}

			@Override
			protected void visit(final AS3Setsuper instruction) {
				add(sb, "setsuper", instruction.getIndex().value());
			}

			@Override
			protected void visit(final AS3Strictequals instruction) {
				add(sb, "strictequals");
			}

			@Override
			protected void visit(final AS3Subtract instruction) {
				add(sb, "subtract");
			}

			@Override
			protected void visit(final AS3Subtracti instruction) {
				add(sb, "subtract_i");
			}

			@Override
			protected void visit(final AS3Swap instruction) {
				add(sb, "swap");
			}

			@Override
			protected void visit(final AS3Throw instruction) {
				add(sb, "throw");
			}

			@Override
			protected void visit(final AS3Typeof instruction) {
				add(sb, "typeof");
			}

			@Override
			protected void visit(final AS3UnknownInstruction instruction) {
				add(sb, "unknown");
			}

			@Override
			protected void visit(final AS3Urshift instruction) {
				add(sb, "urshift");
			}
		}.visit(instruction);
	}

	public static String getCodeText(final AS3Code code) {

		if (code.getInstructions().size() == 0) {
			return "";
		}

		final StringBuilder sb = new StringBuilder();

		final AS3Instruction firstInstruction = code.getInstructions().get(0);

		final int firstOffset = firstInstruction.getBitPosition();

		for (final AS3Instruction instruction : code.getInstructions()) {

			final int absoluteOffset = instruction.getBitPosition() / 8;
			final int relativeOffset = absoluteOffset - firstOffset  / 8;
			sb.append(String.format("%08X %08X  ", absoluteOffset, relativeOffset));

			addInstructionText(sb, instruction);

			sb.append('\n');
		}

		return sb.toString();
	}

	public static String getCodeText(final DoABCTag tag) {
		final StringBuilder sb = new StringBuilder();

		for (final MethodBody body : tag.getAbcData().getMethodBodies()) {
			sb.append(getCodeText(body.getCode()));
			sb.append("---------------------------------------------------------------\n");
		}

		return sb.toString();
	}
}