package tv.porst.swfretools.parser.actions.as2;

import static tv.porst.swfretools.parser.SWFParserHelpers.parseUINT8;

import java.util.ArrayList;
import java.util.List;

import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFBinaryParser;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Class responsible for parsing actions.
 * 
 * @author sp
 *
 */
public final class ActionRecordParser {

	/**
	 * Parses a list of actions.
	 * 
	 * @param parser The parser that provides the input stream.
	 * @param actionRecordSize Number of bytes to parse into action objects.
	 * 
	 * @return The parsed actions.
	 * 
	 * @throws SWFParserException Thrown if the list of actions could not be parsed.
	 */
	public static List<Action> parse(final SWFBinaryParser parser, final long actionRecordSize, final String fieldName) throws SWFParserException {

		final List<Action> actions = new ArrayList<Action>();
		final int startOffset = parser.getBytePosition();

		while (parser.getBytePosition() - startOffset < actionRecordSize) {

			final UINT8 actionCode = parseUINT8(parser, 0x00006, fieldName + "::ActionCode");

			switch (actionCode.value()) {
			case ActionCodes.ActionEnd: actions.add(new ActionEnd(actionCode)); break;
			case ActionCodes.ActionNextFrame: actions.add(new ActionNextFrame(actionCode)); break;
			case ActionCodes.ActionPreviousFrame: actions.add(new ActionPreviousFrame(actionCode)); break;
			case ActionCodes.ActionPlay: actions.add(new ActionPlay(actionCode)); break;
			case ActionCodes.ActionStop: actions.add(new ActionStop(actionCode)); break;
			case ActionCodes.ActionToggleQuality: actions.add(new ActionToggleQuality(actionCode)); break;
			case ActionCodes.ActionStopSounds: actions.add(new ActionStopSounds(actionCode)); break;
			case ActionCodes.ActionAnd: actions.add(new ActionAnd(actionCode)); break;
			case ActionCodes.ActionAdd: actions.add(new ActionAdd(actionCode)); break;
			case ActionCodes.ActionSubtract: actions.add(new ActionSubtract(actionCode)); break;
			case ActionCodes.ActionMultiply: actions.add(new ActionMultiply(actionCode)); break;
			case ActionCodes.ActionDivide: actions.add(new ActionDivide(actionCode)); break;
			case ActionCodes.ActionEquals: actions.add(new ActionEquals(actionCode)); break;
			case ActionCodes.ActionLess: actions.add(new ActionLess(actionCode)); break;
			case ActionCodes.ActionOr: actions.add(new ActionOr(actionCode)); break;
			case ActionCodes.ActionNot: actions.add(new ActionNot(actionCode)); break;
			case ActionCodes.ActionStringEquals: actions.add(new ActionStringEquals(actionCode)); break;
			case ActionCodes.ActionStringLength: actions.add(new ActionStringLength(actionCode)); break;
			case ActionCodes.ActionStringExtract: actions.add(new ActionStringExtract(actionCode)); break;
			case ActionCodes.ActionPop: actions.add(new ActionPop(actionCode)); break;
			case ActionCodes.ActionToInteger: actions.add(new ActionToInteger(actionCode)); break;
			case ActionCodes.ActionGetVariable: actions.add(new ActionGetVariable(actionCode)); break;
			case ActionCodes.ActionSetVariable: actions.add(new ActionSetVariable(actionCode)); break;
			case ActionCodes.ActionStringAdd: actions.add(new ActionStringAdd(actionCode)); break;
			case ActionCodes.ActionSetTarget2: actions.add(new ActionSetTarget2(actionCode)); break;
			case ActionCodes.ActionGetProperty: actions.add(new ActionGetProperty(actionCode)); break;
			case ActionCodes.ActionSetProperty: actions.add(new ActionSetProperty(actionCode)); break;
			case ActionCodes.ActionCloneSprite: actions.add(new ActionCloneSprite(actionCode)); break;
			case ActionCodes.ActionRemoveSprite: actions.add(new ActionRemoveSprite(actionCode)); break;
			case ActionCodes.ActionTrace: actions.add(new ActionTrace(actionCode)); break;
			case ActionCodes.ActionStartDrag: actions.add(new ActionStartDrag(actionCode)); break;
			case ActionCodes.ActionEndDrag: actions.add(new ActionEndDrag(actionCode)); break;
			case ActionCodes.ActionStringLess: actions.add(new ActionStringLess(actionCode)); break;
			case ActionCodes.ActionThrow: actions.add(new ActionThrow(actionCode)); break;
			case ActionCodes.ActionCastOp: actions.add(new ActionCastOp(actionCode)); break;
			case ActionCodes.ActionImplementsOp: actions.add(new ActionImplementsOp(actionCode)); break;
			case ActionCodes.ActionRandomNumber: actions.add(new ActionRandomNumber(actionCode)); break;
			case ActionCodes.ActionMBStringLength: actions.add(new ActionMBStringLength(actionCode)); break;
			case ActionCodes.ActionCharToAscii: actions.add(new ActionCharToAscii(actionCode)); break;
			case ActionCodes.ActionAsciiToChar: actions.add(new ActionAsciiToChar(actionCode)); break;
			case ActionCodes.ActionGetTime: actions.add(new ActionGetTime(actionCode)); break;
			case ActionCodes.ActionMBStringExtract: actions.add(new ActionMBStringExtract(actionCode)); break;
			case ActionCodes.ActionMBCharToAscii: actions.add(new ActionMBCharToAscii(actionCode)); break;
			case ActionCodes.ActionMBAsciiToChar: actions.add(new ActionMBAsciiToChar(actionCode)); break;
			case ActionCodes.ActionDelete: actions.add(new ActionDelete(actionCode)); break;
			case ActionCodes.ActionDelete2: actions.add(new ActionDelete2(actionCode)); break;
			case ActionCodes.ActionDefineLocal: actions.add(new ActionDefineLocal(actionCode)); break;
			case ActionCodes.ActionCallFunction: actions.add(new ActionCallFunction(actionCode)); break;
			case ActionCodes.ActionReturn: actions.add(new ActionReturn(actionCode)); break;
			case ActionCodes.ActionModulo: actions.add(new ActionModulo(actionCode)); break;
			case ActionCodes.ActionNewObject: actions.add(new ActionNewObject(actionCode)); break;
			case ActionCodes.ActionDefineLocal2: actions.add(new ActionDefineLocal2(actionCode)); break;
			case ActionCodes.ActionInitArray: actions.add(new ActionInitArray(actionCode)); break;
			case ActionCodes.ActionInitObject: actions.add(new ActionInitObject(actionCode)); break;
			case ActionCodes.ActionTypeOf: actions.add(new ActionTypeOf(actionCode)); break;
			case ActionCodes.ActionTargetPath: actions.add(new ActionTargetPath(actionCode)); break;
			case ActionCodes.ActionEnumerate: actions.add(new ActionEnumerate(actionCode)); break;
			case ActionCodes.ActionAdd2: actions.add(new ActionAdd2(actionCode)); break;
			case ActionCodes.ActionLess2: actions.add(new ActionLess2(actionCode)); break;
			case ActionCodes.ActionEquals2: actions.add(new ActionEquals2(actionCode)); break;
			case ActionCodes.ActionToNumbers: actions.add(new ActionToNumbers(actionCode)); break;
			case ActionCodes.ActionToString: actions.add(new ActionToString(actionCode)); break;
			case ActionCodes.ActionPushDuplicate: actions.add(new ActionPushDuplicate(actionCode)); break;
			case ActionCodes.ActionStackSwap: actions.add(new ActionStackSwap(actionCode)); break;
			case ActionCodes.ActionGetMember: actions.add(new ActionGetMember(actionCode)); break;
			case ActionCodes.ActionSetMember: actions.add(new ActionSetMember(actionCode)); break;
			case ActionCodes.ActionIncrement: actions.add(new ActionIncrement(actionCode)); break;
			case ActionCodes.ActionDecrement: actions.add(new ActionDecrement(actionCode)); break;
			case ActionCodes.ActionNewMethod: actions.add(new ActionNewMethod(actionCode)); break;
			case ActionCodes.ActionCallMethod: actions.add(new ActionCallMethod(actionCode)); break;
			case ActionCodes.ActionInstanceOf: actions.add(new ActionInstanceOf(actionCode)); break;
			case ActionCodes.ActionEnumerate2: actions.add(new ActionEnumerate2(actionCode)); break;
			case ActionCodes.ActionBitAnd: actions.add(new ActionBitAnd(actionCode)); break;
			case ActionCodes.ActionBitOr: actions.add(new ActionBitOr(actionCode)); break;
			case ActionCodes.ActionBitXor: actions.add(new ActionBitXor(actionCode)); break;
			case ActionCodes.ActionBitLShift: actions.add(new ActionBitLShift(actionCode)); break;
			case ActionCodes.ActionBitRShift: actions.add(new ActionBitRShift(actionCode)); break;
			case ActionCodes.ActionBitURShift: actions.add(new ActionBitURShift(actionCode)); break;
			case ActionCodes.ActionStrictEquals: actions.add(new ActionStrictEquals(actionCode)); break;
			case ActionCodes.ActionGreater: actions.add(new ActionGreater(actionCode)); break;
			case ActionCodes.ActionStringGreater: actions.add(new ActionStringGreater(actionCode)); break;
			case ActionCodes.ActionExtends: actions.add(new ActionExtends(actionCode)); break;
			case ActionCodes.ActionCall: actions.add(new ActionCall(actionCode)); break;
			// ---
			case ActionCodes.ActionGotoFrame: actions.add(ActionGotoFrameParser.parse(parser, actionCode, fieldName)); break;
			case ActionCodes.ActionGetURL: actions.add(ActionGetURLParser.parse(parser, actionCode, fieldName)); break;
			case ActionCodes.ActionStoreRegister: actions.add(ActionStoreRegisterParser.parse(parser, actionCode, fieldName)); break;
			case ActionCodes.ActionConstantPool: actions.add(ActionConstantPoolParser.parse(parser, actionCode, fieldName)); break;
			case ActionCodes.ActionWaitForFrame: actions.add(ActionWaitForFrameParser.parse(parser, actionCode, fieldName)); break;
			case ActionCodes.ActionSetTarget: actions.add(ActionSetTargetParser.parse(parser, actionCode, fieldName)); break;
			case ActionCodes.ActionGotoLabel: actions.add(ActionGotoLabelParser.parse(parser, actionCode, fieldName)); break;
			case ActionCodes.ActionWaitForFrame2: actions.add(ActionWaitForFrame2Parser.parse(parser, actionCode, fieldName)); break;
			case ActionCodes.ActionDefineFunction2: actions.add(ActionDefineFunction2Parser.parse(parser, actionCode, fieldName)); break;
			case ActionCodes.ActionTry: actions.add(ActionTryParser.parse(parser, actionCode, fieldName)); break;
			case ActionCodes.ActionWith: actions.add(ActionWithParser.parse(parser, actionCode, fieldName)); break;
			case ActionCodes.ActionPush: actions.add(ActionPushParser.parse(parser, actionCode, fieldName)); break;
			case ActionCodes.ActionJump: actions.add(ActionJumpParser.parse(parser, actionCode, fieldName)); break;
			case ActionCodes.ActionDefineFunction: actions.add(ActionDefineFunctionParser.parse(parser, actionCode, fieldName)); break;
			case ActionCodes.ActionIf: actions.add(ActionIfParser.parse(parser, actionCode, fieldName)); break;
			case ActionCodes.ActionGetURL2: actions.add(ActionGetURL2Parser.parse(parser, actionCode, fieldName)); break;
			case ActionCodes.ActionGotoFrame2: actions.add(ActionGotoFrame2Parser.parse(parser, actionCode, fieldName)); break;

			default:
				throw new IllegalStateException("Invalid action code");
			}
		}

		return actions;
	}

}
