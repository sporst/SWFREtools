package tv.porst.swfretools.dissector.gui.main.panels;

import tv.porst.swfretools.parser.actions.as2.AS2Visitor;
import tv.porst.swfretools.parser.actions.as2.Action;
import tv.porst.swfretools.parser.actions.as2.ActionAdd;
import tv.porst.swfretools.parser.actions.as2.ActionAdd2;
import tv.porst.swfretools.parser.actions.as2.ActionAnd;
import tv.porst.swfretools.parser.actions.as2.ActionAsciiToChar;
import tv.porst.swfretools.parser.actions.as2.ActionBitAnd;
import tv.porst.swfretools.parser.actions.as2.ActionBitLShift;
import tv.porst.swfretools.parser.actions.as2.ActionBitOr;
import tv.porst.swfretools.parser.actions.as2.ActionBitRShift;
import tv.porst.swfretools.parser.actions.as2.ActionBitURShift;
import tv.porst.swfretools.parser.actions.as2.ActionBitXor;
import tv.porst.swfretools.parser.actions.as2.ActionCall;
import tv.porst.swfretools.parser.actions.as2.ActionCallFunction;
import tv.porst.swfretools.parser.actions.as2.ActionCallMethod;
import tv.porst.swfretools.parser.actions.as2.ActionCastOp;
import tv.porst.swfretools.parser.actions.as2.ActionCharToAscii;
import tv.porst.swfretools.parser.actions.as2.ActionCloneSprite;
import tv.porst.swfretools.parser.actions.as2.ActionConstantPool;
import tv.porst.swfretools.parser.actions.as2.ActionDecrement;
import tv.porst.swfretools.parser.actions.as2.ActionDefineFunction;
import tv.porst.swfretools.parser.actions.as2.ActionDefineFunction2;
import tv.porst.swfretools.parser.actions.as2.ActionDefineLocal;
import tv.porst.swfretools.parser.actions.as2.ActionDefineLocal2;
import tv.porst.swfretools.parser.actions.as2.ActionDelete;
import tv.porst.swfretools.parser.actions.as2.ActionDelete2;
import tv.porst.swfretools.parser.actions.as2.ActionDivide;
import tv.porst.swfretools.parser.actions.as2.ActionEndDrag;
import tv.porst.swfretools.parser.actions.as2.ActionEnumerate;
import tv.porst.swfretools.parser.actions.as2.ActionEnumerate2;
import tv.porst.swfretools.parser.actions.as2.ActionEquals;
import tv.porst.swfretools.parser.actions.as2.ActionEquals2;
import tv.porst.swfretools.parser.actions.as2.ActionExtends;
import tv.porst.swfretools.parser.actions.as2.ActionGetMember;
import tv.porst.swfretools.parser.actions.as2.ActionGetProperty;
import tv.porst.swfretools.parser.actions.as2.ActionGetTime;
import tv.porst.swfretools.parser.actions.as2.ActionGetURL;
import tv.porst.swfretools.parser.actions.as2.ActionGetURL2;
import tv.porst.swfretools.parser.actions.as2.ActionGetVariable;
import tv.porst.swfretools.parser.actions.as2.ActionGotoFrame;
import tv.porst.swfretools.parser.actions.as2.ActionGotoFrame2;
import tv.porst.swfretools.parser.actions.as2.ActionGotoLabel;
import tv.porst.swfretools.parser.actions.as2.ActionGreater;
import tv.porst.swfretools.parser.actions.as2.ActionIf;
import tv.porst.swfretools.parser.actions.as2.ActionImplementsOp;
import tv.porst.swfretools.parser.actions.as2.ActionIncrement;
import tv.porst.swfretools.parser.actions.as2.ActionInitArray;
import tv.porst.swfretools.parser.actions.as2.ActionInitObject;
import tv.porst.swfretools.parser.actions.as2.ActionInstanceOf;
import tv.porst.swfretools.parser.actions.as2.ActionJump;
import tv.porst.swfretools.parser.actions.as2.ActionLess;
import tv.porst.swfretools.parser.actions.as2.ActionLess2;
import tv.porst.swfretools.parser.actions.as2.ActionMBAsciiToChar;
import tv.porst.swfretools.parser.actions.as2.ActionMBCharToAscii;
import tv.porst.swfretools.parser.actions.as2.ActionMBStringExtract;
import tv.porst.swfretools.parser.actions.as2.ActionMBStringLength;
import tv.porst.swfretools.parser.actions.as2.ActionModulo;
import tv.porst.swfretools.parser.actions.as2.ActionMultiply;
import tv.porst.swfretools.parser.actions.as2.ActionNewMethod;
import tv.porst.swfretools.parser.actions.as2.ActionNewObject;
import tv.porst.swfretools.parser.actions.as2.ActionNextFrame;
import tv.porst.swfretools.parser.actions.as2.ActionNot;
import tv.porst.swfretools.parser.actions.as2.ActionOr;
import tv.porst.swfretools.parser.actions.as2.ActionSetMember;
import tv.porst.swfretools.parser.actions.as2.ActionSetProperty;
import tv.porst.swfretools.parser.actions.as2.ActionSetTarget;
import tv.porst.swfretools.parser.actions.as2.ActionSetTarget2;
import tv.porst.swfretools.parser.actions.as2.ActionSetVariable;
import tv.porst.swfretools.parser.actions.as2.ActionStackSwap;
import tv.porst.swfretools.parser.actions.as2.ActionStartDrag;
import tv.porst.swfretools.parser.actions.as2.ActionStop;
import tv.porst.swfretools.parser.actions.as2.ActionStopSounds;
import tv.porst.swfretools.parser.actions.as2.ActionStoreRegister;
import tv.porst.swfretools.parser.actions.as2.ActionStrictEquals;
import tv.porst.swfretools.parser.actions.as2.ActionStringAdd;
import tv.porst.swfretools.parser.actions.as2.ActionStringEquals;
import tv.porst.swfretools.parser.actions.as2.ActionStringExtract;
import tv.porst.swfretools.parser.actions.as2.ActionStringGreater;
import tv.porst.swfretools.parser.actions.as2.ActionStringLength;
import tv.porst.swfretools.parser.actions.as2.ActionStringLess;
import tv.porst.swfretools.parser.actions.as2.ActionSubtract;
import tv.porst.swfretools.parser.actions.as2.ActionTargetPath;
import tv.porst.swfretools.parser.actions.as2.ActionThrow;
import tv.porst.swfretools.parser.actions.as2.ActionToInteger;
import tv.porst.swfretools.parser.actions.as2.ActionToNumbers;
import tv.porst.swfretools.parser.actions.as2.ActionToString;
import tv.porst.swfretools.parser.actions.as2.ActionToggleQuality;
import tv.porst.swfretools.parser.actions.as2.ActionTrace;
import tv.porst.swfretools.parser.actions.as2.ActionTry;
import tv.porst.swfretools.parser.actions.as2.ActionTypeOf;
import tv.porst.swfretools.parser.actions.as2.ActionWaitForFrame;
import tv.porst.swfretools.parser.actions.as2.ActionWaitForFrame2;
import tv.porst.swfretools.parser.actions.as2.ActionWith;
import tv.porst.swfretools.parser.structures.ActionList;

public class AS2CodePrinter {

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

	private static void addInstructionText(final StringBuilder sb, final Action instruction) {

		new AS2Visitor() {

			@Override
			protected void visit(final ActionAdd instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionAdd2 instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionAnd instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionAsciiToChar instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionBitAnd instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionBitLShift instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionBitOr instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionBitRShift instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionBitURShift instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionBitXor instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionCall instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionCallFunction instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionCallMethod instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionCastOp instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionCharToAscii instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionCloneSprite instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionConstantPool instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionDecrement instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionDefineFunction instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionDefineFunction2 instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionDefineLocal instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionDefineLocal2 instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionDelete instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionDelete2 instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionDivide instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionEndDrag instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionEnumerate instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionEnumerate2 instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionEquals instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionEquals2 instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionExtends instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionGetMember instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionGetProperty instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionGetTime instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionGetURL instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionGetURL2 instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionGetVariable instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionGotoFrame instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionGotoFrame2 instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionGotoLabel instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionGreater instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionIf instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionImplementsOp instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionIncrement instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionInitArray instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionInitObject instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionInstanceOf instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionJump instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionLess instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionLess2 instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionMBAsciiToChar instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionMBCharToAscii instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionMBStringExtract instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionMBStringLength instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionModulo instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionMultiply instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionNewMethod instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionNewObject instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionNextFrame instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionNot instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionOr instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionSetMember instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionSetProperty instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionSetTarget instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionSetTarget2 instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionSetVariable instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionStackSwap instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionStartDrag instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionStop instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionStopSounds instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionStoreRegister instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionStrictEquals instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionStringAdd instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionStringEquals instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionStringExtract instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionStringGreater instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionStringLength instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionStringLess instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionSubtract instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionTargetPath instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionThrow instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionToggleQuality instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionToInteger instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionToNumbers instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionToString instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionTrace instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionTry instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionTypeOf instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionWaitForFrame instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionWaitForFrame2 instruction) {
				// TODO Auto-generated method stub

			}

			@Override
			protected void visit(final ActionWith instruction) {
				// TODO Auto-generated method stub

			}
		}.visit(instruction);
	}

	public static String getCodeText(final ActionList code) {

		if (code.size() == 0) {
			return "";
		}

		final StringBuilder sb = new StringBuilder();

		final Action firstInstruction = code.get(0);

		final int firstOffset = firstInstruction.getBitPosition();

		for (final Action instruction : code) {

			final int absoluteOffset = instruction.getBitPosition() / 8;
			final int relativeOffset = absoluteOffset - firstOffset  / 8;
			sb.append(String.format("%08X %08X  ", absoluteOffset, relativeOffset));

			addInstructionText(sb, instruction);

			sb.append('\n');
		}

		return sb.toString();
	}
}