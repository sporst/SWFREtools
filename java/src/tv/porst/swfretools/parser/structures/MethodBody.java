package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.IFileElement;
import tv.porst.swfretools.parser.SWFParserHelpers;

public class MethodBody implements IFileElement {

	private final EncodedU30 method;
	private final EncodedU30 maxStack;
	private final EncodedU30 localCount;
	private final EncodedU30 initScopeDepth;
	private final EncodedU30 maxScopeDepth;
	private final EncodedU30 codeLength;
	private final AS3Code code;
	private final EncodedU30 exceptionCount;
	private final ExceptionInfoList exceptions;
	private final EncodedU30 traitCount;
	private final TraitsInfoList traits;

	public MethodBody(final EncodedU30 method, final EncodedU30 maxStack,
			final EncodedU30 localCount, final EncodedU30 initScopeDepth,
			final EncodedU30 maxScopeDepth, final EncodedU30 codeLength, final AS3Code code,
			final EncodedU30 exceptionCount, final ExceptionInfoList exceptions,
			final EncodedU30 traitCount, final TraitsInfoList traits) {

		this.method = method;
		this.maxStack = maxStack;
		this.localCount = localCount;
		this.initScopeDepth = initScopeDepth;
		this.maxScopeDepth = maxScopeDepth;
		this.codeLength = codeLength;
		this.code = code;
		this.exceptionCount = exceptionCount;
		this.exceptions = exceptions;
		this.traitCount = traitCount;
		this.traits = traits;
	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(method, maxStack, localCount, initScopeDepth, maxScopeDepth,
				codeLength, code, exceptionCount, exceptions, traitCount, traits);
	}

	@Override
	public int getBitPosition() {
		return method.getBitPosition();
	}

}
