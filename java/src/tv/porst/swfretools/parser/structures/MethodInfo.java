package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.IFileElement;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFParserHelpers;

public class MethodInfo implements IFileElement {

	private final EncodedU30 paramCount;
	private final EncodedU30 returnType;
	private final EncodedU30List paramTypes;
	private final EncodedU30 name;
	private final UINT8 flags;
	private final OptionInfo optionInfo;
	private final ParamInfo paramInfo;

	public MethodInfo(final EncodedU30 paramCount, final EncodedU30 returnType,
			final EncodedU30List paramTypes, final EncodedU30 name, final UINT8 flags,
			final OptionInfo optionInfo, final ParamInfo paramInfo) {

		this.paramCount = paramCount;
		this.returnType = returnType;
		this.paramTypes = paramTypes;
		this.name = name;
		this.flags = flags;
		this.optionInfo = optionInfo;
		this.paramInfo = paramInfo;
	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(paramCount, returnType, paramTypes, name,
				flags, optionInfo, paramInfo);
	}

	@Override
	public int getBitPosition() {
		return paramCount.getBitPosition();
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public UINT8 getFlags() {
		return flags;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public EncodedU30 getName() {
		return name;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public OptionInfo getOptionInfo() {
		return optionInfo;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public EncodedU30 getParamCount() {
		return paramCount;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public ParamInfo getParamInfo() {
		return paramInfo;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public EncodedU30List getParamTypes() {
		return paramTypes;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public EncodedU30 getReturnType() {
		return returnType;
	}

}
