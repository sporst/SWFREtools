package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.IFileElement;
import tv.porst.splib.binaryparser.UINT8;
import tv.porst.swfretools.parser.SWFParserHelpers;

public class InstanceInfo implements IFileElement {

	private final EncodedU30 name;

	private final EncodedU30 superName;

	private final UINT8 flags;

	private final EncodedU30 protectedNs;

	private final EncodedU30 interfaceCount;

	private final EncodedU30List interfaces;

	private final EncodedU30 iinit;

	private final EncodedU30 traitCount;

	private final TraitsInfoList traits;

	public InstanceInfo(final EncodedU30 name, final EncodedU30 superName, final UINT8 flags,
			final EncodedU30 protectedNs, final EncodedU30 interfaceCount,
			final EncodedU30List interfaces, final EncodedU30 iinit,
			final EncodedU30 traitCount, final TraitsInfoList traits) {

		this.name = name;
		this.superName = superName;
		this.flags = flags;
		this.protectedNs = protectedNs;
		this.interfaceCount = interfaceCount;
		this.interfaces = interfaces;
		this.iinit = iinit;
		this.traitCount = traitCount;
		this.traits = traits;
	}

	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(name, superName, flags, protectedNs, interfaceCount,
				interfaces, iinit, traitCount, traits);
	}
	@Override
	public int getBitPosition() {
		return name.getBitPosition();
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
	public EncodedU30 getIinit() {
		return iinit;
	}
	/**
	 * Returns the
	 *
	 * @return The
	 */
	public EncodedU30 getInterfaceCount() {
		return interfaceCount;
	}
	/**
	 * Returns the
	 *
	 * @return The
	 */
	public EncodedU30List getInterfaces() {
		return interfaces;
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
	public EncodedU30 getProtectedNs() {
		return protectedNs;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public EncodedU30 getSuperName() {
		return superName;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public EncodedU30 getTraitCount() {
		return traitCount;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public TraitsInfoList getTraits() {
		return traits;
	}

}
