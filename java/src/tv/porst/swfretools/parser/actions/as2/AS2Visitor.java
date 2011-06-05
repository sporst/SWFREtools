package tv.porst.swfretools.parser.actions.as2;

public abstract class AS2Visitor {

	protected abstract void visit(final ActionAdd instruction);

	protected abstract void visit(final ActionAdd2 instruction);

	protected abstract void visit(final ActionAnd instruction);

	protected abstract void visit(final ActionAsciiToChar instruction);

	protected abstract void visit(final ActionBitAnd instruction);

	protected abstract void visit(final ActionBitLShift instruction);

	protected abstract void visit(final ActionBitOr instruction);

	protected abstract void visit(final ActionBitRShift instruction);

	protected abstract void visit(final ActionBitURShift instruction);

	protected abstract void visit(final ActionBitXor instruction);

	protected abstract void visit(final ActionCall instruction);

	protected abstract void visit(final ActionCallFunction instruction);

	protected abstract void visit(final ActionCallMethod instruction);

	protected abstract void visit(final ActionCastOp instruction);

	protected abstract void visit(final ActionCharToAscii instruction);

	protected abstract void visit(final ActionCloneSprite instruction);

	protected abstract void visit(final ActionConstantPool instruction);

	protected abstract void visit(final ActionDecrement instruction);

	protected abstract void visit(final ActionDefineFunction instruction);

	protected abstract void visit(final ActionDefineFunction2 instruction);

	protected abstract void visit(final ActionDefineLocal instruction);

	protected abstract void visit(final ActionDefineLocal2 instruction);

	protected abstract void visit(final ActionDelete instruction);

	protected abstract void visit(final ActionDelete2 instruction);

	protected abstract void visit(final ActionDivide instruction);

	protected abstract void visit(final ActionEndDrag instruction);

	protected abstract void visit(final ActionEnumerate instruction);

	protected abstract void visit(final ActionEnumerate2 instruction);

	protected abstract void visit(final ActionEquals instruction);

	protected abstract void visit(final ActionEquals2 instruction);

	protected abstract void visit(final ActionExtends instruction);

	protected abstract void visit(final ActionGetMember instruction);

	protected abstract void visit(final ActionGetProperty instruction);

	protected abstract void visit(final ActionGetTime instruction);

	protected abstract void visit(final ActionGetURL instruction);

	protected abstract void visit(final ActionGetURL2 instruction);

	protected abstract void visit(final ActionGetVariable instruction);

	protected abstract void visit(final ActionGotoFrame instruction);

	protected abstract void visit(final ActionGotoFrame2 instruction);

	protected abstract void visit(final ActionGotoLabel instruction);

	protected abstract void visit(final ActionGreater instruction);

	protected abstract void visit(final ActionIf instruction);

	protected abstract void visit(final ActionImplementsOp instruction);

	protected abstract void visit(final ActionIncrement instruction);

	protected abstract void visit(final ActionInitArray instruction);

	protected abstract void visit(final ActionInitObject instruction);

	protected abstract void visit(final ActionInstanceOf instruction);

	protected abstract void visit(final ActionJump instruction);

	protected abstract void visit(final ActionLess instruction);

	protected abstract void visit(final ActionLess2 instruction);

	protected abstract void visit(final ActionMBAsciiToChar instruction);

	protected abstract void visit(final ActionMBCharToAscii instruction);

	protected abstract void visit(final ActionMBStringExtract instruction);

	protected abstract void visit(final ActionMBStringLength instruction);

	protected abstract void visit(final ActionModulo instruction);

	protected abstract void visit(final ActionMultiply instruction);

	protected abstract void visit(final ActionNewMethod instruction);

	protected abstract void visit(final ActionNewObject instruction);

	protected abstract void visit(final ActionNextFrame instruction);

	protected abstract void visit(final ActionNot instruction);

	protected abstract void visit(final ActionOr instruction);

	protected abstract void visit(final ActionPlay instruction);

	protected abstract void visit(final ActionPop instruction);

	protected abstract void visit(final ActionPush instruction);

	protected abstract void visit(final ActionPushDuplicate instruction);

	protected abstract void visit(final ActionSetMember instruction);

	protected abstract void visit(final ActionSetProperty instruction);

	protected abstract void visit(final ActionSetTarget instruction);

	protected abstract void visit(final ActionSetTarget2 instruction);

	protected abstract void visit(final ActionSetVariable instruction);

	protected abstract void visit(final ActionStackSwap instruction);

	protected abstract void visit(final ActionStartDrag instruction);

	protected abstract void visit(final ActionStop instruction);

	protected abstract void visit(final ActionStopSounds instruction);

	protected abstract void visit(final ActionStoreRegister instruction);

	protected abstract void visit(final ActionStrictEquals instruction);

	protected abstract void visit(final ActionStringAdd instruction);

	protected abstract void visit(final ActionStringEquals instruction);

	protected abstract void visit(final ActionStringExtract instruction);

	protected abstract void visit(final ActionStringGreater instruction);

	protected abstract void visit(final ActionStringLength instruction);

	protected abstract void visit(final ActionStringLess instruction);

	protected abstract void visit(final ActionSubtract instruction);

	protected abstract void visit(final ActionTargetPath instruction);

	protected abstract void visit(final ActionThrow instruction);

	protected abstract void visit(final ActionToggleQuality instruction);

	protected abstract void visit(final ActionToInteger instruction);

	protected abstract void visit(final ActionToNumbers instruction);

	protected abstract void visit(final ActionToString instruction);

	protected abstract void visit(final ActionTrace instruction);

	protected abstract void visit(final ActionTry instruction);

	protected abstract void visit(final ActionTypeOf instruction);

	protected abstract void visit(final ActionUnknown instruction);

	protected abstract void visit(final ActionWaitForFrame instruction);

	protected abstract void visit(final ActionWaitForFrame2 instruction);

	protected abstract void visit(final ActionWith instruction);

	public void visit(final Action instruction) {
		if (instruction instanceof ActionAdd) {
			visit((ActionAdd) instruction);
		}
		else if (instruction instanceof ActionAdd2) {
			visit((ActionAdd2) instruction);
		}
		if (instruction instanceof ActionAnd) {
			visit((ActionAnd) instruction);
		}
		else if (instruction instanceof ActionAsciiToChar) {
			visit((ActionAsciiToChar) instruction);
		}
		else if (instruction instanceof ActionBitAnd) {
			visit((ActionBitAnd) instruction);
		}
		else if (instruction instanceof ActionBitLShift) {
			visit((ActionBitLShift) instruction);
		}
		else if (instruction instanceof ActionBitOr) {
			visit((ActionBitOr) instruction);
		}
		else if (instruction instanceof ActionBitRShift) {
			visit((ActionBitRShift) instruction);
		}
		else if (instruction instanceof ActionBitURShift) {
			visit((ActionBitURShift) instruction);
		}
		else if (instruction instanceof ActionBitXor) {
			visit((ActionBitXor) instruction);
		}
		else if (instruction instanceof ActionCall) {
			visit((ActionCall) instruction);
		}
		else if (instruction instanceof ActionCallFunction) {
			visit((ActionCallFunction) instruction);
		}
		else if (instruction instanceof ActionCallMethod) {
			visit((ActionCallMethod) instruction);
		}
		else if (instruction instanceof ActionCastOp) {
			visit((ActionCastOp) instruction);
		}
		else if (instruction instanceof ActionCharToAscii) {
			visit((ActionCharToAscii) instruction);
		}
		else if (instruction instanceof ActionCloneSprite) {
			visit((ActionCloneSprite) instruction);
		}
		else if (instruction instanceof ActionConstantPool) {
			visit((ActionConstantPool) instruction);
		}
		else if (instruction instanceof ActionDecrement) {
			visit((ActionDecrement) instruction);
		}
		else if (instruction instanceof ActionDefineFunction) {
			visit((ActionDefineFunction) instruction);
		}
		else if (instruction instanceof ActionDefineFunction2) {
			visit((ActionDefineFunction2) instruction);
		}
		else if (instruction instanceof ActionDefineLocal) {
			visit((ActionDefineLocal) instruction);
		}
		else if (instruction instanceof ActionDefineLocal2) {
			visit((ActionDefineLocal2) instruction);
		}
		else if (instruction instanceof ActionDelete) {
			visit((ActionDelete) instruction);
		}
		else if (instruction instanceof ActionDelete2) {
			visit((ActionDelete2) instruction);
		}
		else if (instruction instanceof ActionDivide) {
			visit((ActionDivide) instruction);
		}
		else if (instruction instanceof ActionEndDrag) {
			visit((ActionEndDrag) instruction);
		}
		else if (instruction instanceof ActionEnumerate) {
			visit((ActionEnumerate) instruction);
		}
		else if (instruction instanceof ActionEnumerate2) {
			visit((ActionEnumerate2) instruction);
		}
		else if (instruction instanceof ActionEquals) {
			visit((ActionEquals) instruction);
		}
		else if (instruction instanceof ActionEquals2) {
			visit((ActionEquals2) instruction);
		}
		else if (instruction instanceof ActionExtends) {
			visit((ActionExtends) instruction);
		}
		else if (instruction instanceof ActionGetMember) {
			visit((ActionGetMember) instruction);
		}
		else if (instruction instanceof ActionGetProperty) {
			visit((ActionGetProperty) instruction);
		}
		else if (instruction instanceof ActionGetTime) {
			visit((ActionGetTime) instruction);
		}
		else if (instruction instanceof ActionGetURL) {
			visit((ActionGetURL) instruction);
		}
		else if (instruction instanceof ActionGetURL2) {
			visit((ActionGetURL2) instruction);
		}
		else if (instruction instanceof ActionGetVariable) {
			visit((ActionGetVariable) instruction);
		}
		else if (instruction instanceof ActionGotoFrame) {
			visit((ActionGotoFrame) instruction);
		}
		else if (instruction instanceof ActionGotoFrame2) {
			visit((ActionGotoFrame2) instruction);
		}
		else if (instruction instanceof ActionGotoLabel) {
			visit((ActionGotoLabel) instruction);
		}
		else if (instruction instanceof ActionGreater) {
			visit((ActionGreater) instruction);
		}
		else if (instruction instanceof ActionIf) {
			visit((ActionIf) instruction);
		}
		else if (instruction instanceof ActionImplementsOp) {
			visit((ActionImplementsOp) instruction);
		}
		else if (instruction instanceof ActionIncrement) {
			visit((ActionIncrement) instruction);
		}
		else if (instruction instanceof ActionInitArray) {
			visit((ActionInitArray) instruction);
		}
		else if (instruction instanceof ActionInitObject) {
			visit((ActionInitObject) instruction);
		}
		else if (instruction instanceof ActionInstanceOf) {
			visit((ActionInstanceOf) instruction);
		}
		else if (instruction instanceof ActionJump) {
			visit((ActionJump) instruction);
		}
		else if (instruction instanceof ActionLess) {
			visit((ActionLess) instruction);
		}
		else if (instruction instanceof ActionLess2) {
			visit((ActionLess2) instruction);
		}
		else if (instruction instanceof ActionMBAsciiToChar) {
			visit((ActionMBAsciiToChar) instruction);
		}
		else if (instruction instanceof ActionMBCharToAscii) {
			visit((ActionMBCharToAscii) instruction);
		}
		else if (instruction instanceof ActionMBStringExtract) {
			visit((ActionMBStringExtract) instruction);
		}
		else if (instruction instanceof ActionMBStringLength) {
			visit((ActionMBStringLength) instruction);
		}
		else if (instruction instanceof ActionModulo) {
			visit((ActionModulo) instruction);
		}
		else if (instruction instanceof ActionMultiply) {
			visit((ActionMultiply) instruction);
		}
		else if (instruction instanceof ActionNewMethod) {
			visit((ActionNewMethod) instruction);
		}
		else if (instruction instanceof ActionNewObject) {
			visit((ActionNewObject) instruction);
		}
		else if (instruction instanceof ActionNextFrame) {
			visit((ActionNextFrame) instruction);
		}
		else if (instruction instanceof ActionNot) {
			visit((ActionNot) instruction);
		}
		else if (instruction instanceof ActionOr) {
			visit((ActionOr) instruction);
		}
		else if (instruction instanceof ActionPlay) {
			visit((ActionPlay) instruction);
		}
		else if (instruction instanceof ActionPop) {
			visit((ActionPop) instruction);
		}
		else if (instruction instanceof ActionPush) {
			visit((ActionPush) instruction);
		}
		else if (instruction instanceof ActionPushDuplicate) {
			visit((ActionPushDuplicate) instruction);
		}
		else if (instruction instanceof ActionSetMember) {
			visit((ActionSetMember) instruction);
		}
		else if (instruction instanceof ActionSetProperty) {
			visit((ActionSetProperty) instruction);
		}
		else if (instruction instanceof ActionSetTarget) {
			visit((ActionSetTarget) instruction);
		}
		else if (instruction instanceof ActionSetTarget2) {
			visit((ActionSetTarget2) instruction);
		}
		else if (instruction instanceof ActionSetVariable) {
			visit((ActionSetVariable) instruction);
		}
		else if (instruction instanceof ActionStackSwap) {
			visit((ActionStackSwap) instruction);
		}
		else if (instruction instanceof ActionStartDrag) {
			visit((ActionStartDrag) instruction);
		}
		else if (instruction instanceof ActionStop) {
			visit((ActionStop) instruction);
		}
		else if (instruction instanceof ActionStopSounds) {
			visit((ActionStopSounds) instruction);
		}
		else if (instruction instanceof ActionStoreRegister) {
			visit((ActionStoreRegister) instruction);
		}
		else if (instruction instanceof ActionStrictEquals) {
			visit((ActionStrictEquals) instruction);
		}
		else if (instruction instanceof ActionStringAdd) {
			visit((ActionStringAdd) instruction);
		}
		else if (instruction instanceof ActionStringEquals) {
			visit((ActionStringEquals) instruction);
		}
		else if (instruction instanceof ActionStringExtract) {
			visit((ActionStringExtract) instruction);
		}
		else if (instruction instanceof ActionStringGreater) {
			visit((ActionStringGreater) instruction);
		}
		else if (instruction instanceof ActionStringLength) {
			visit((ActionStringLength) instruction);
		}
		else if (instruction instanceof ActionStringLess) {
			visit((ActionStringLess) instruction);
		}
		else if (instruction instanceof ActionSubtract) {
			visit((ActionSubtract) instruction);
		}
		else if (instruction instanceof ActionTargetPath) {
			visit((ActionTargetPath) instruction);
		}
		else if (instruction instanceof ActionThrow) {
			visit((ActionThrow) instruction);
		}
		else if (instruction instanceof ActionToggleQuality) {
			visit((ActionToggleQuality) instruction);
		}
		else if (instruction instanceof ActionToInteger) {
			visit((ActionToInteger) instruction);
		}
		else if (instruction instanceof ActionToNumbers) {
			visit((ActionToNumbers) instruction);
		}
		else if (instruction instanceof ActionToString) {
			visit((ActionToString) instruction);
		}
		else if (instruction instanceof ActionTrace) {
			visit((ActionTrace) instruction);
		}
		else if (instruction instanceof ActionTry) {
			visit((ActionTry) instruction);
		}
		else if (instruction instanceof ActionTypeOf) {
			visit((ActionTypeOf) instruction);
		}
		else if (instruction instanceof ActionWaitForFrame) {
			visit((ActionWaitForFrame) instruction);
		}
		else if (instruction instanceof ActionWaitForFrame2) {
			visit((ActionWaitForFrame2) instruction);
		}
		else if (instruction instanceof ActionWith) {
			visit((ActionWith) instruction);
		}
		else if (instruction instanceof ActionUnknown) {
			visit((ActionUnknown) instruction);
		}
	}
}
