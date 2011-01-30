package tv.porst.swfretools.parser.tags;

import tv.porst.splib.binaryparser.UBits;
import tv.porst.splib.binaryparser.Flag;
import tv.porst.swfretools.parser.structures.RecordHeader;

/**
 * Represents a FileAttributes tag.
 * 
 * @author sp
 *
 */
public final class FileAttributesTag extends Tag {

	/**
	 * First reserved bits.
	 */
	private final UBits reserved;

	/**
	 * Hardware acceleration flag.
	 */
	private final Flag useDirectBit;

	/**
	 * GPU flag.
	 */
	private final Flag useGPU;

	/**
	 * Metadata flag.
	 */
	private final Flag hasMetadata;

	/**
	 * ActionScript 3 flag.
	 */
	private final Flag actionScript3;

	/**
	 * Second reserved bits.
	 */
	private final UBits reserved2;

	/**
	 * Network access flags.
	 */
	private final Flag useNetwork;

	/**
	 * Third reserved bits.
	 */
	private final UBits reserved3;

	/**
	 * Creates a new FileAttributes tag object.
	 * 
	 * @param header Tag header.
	 * @param reserved First reserved bits.
	 * @param useDirectBit Hardware acceleration flag.
	 * @param useGPU GPU flag.
	 * @param hasMetadata Metadata flag.
	 * @param actionScript3 ActionScript 3 flag.
	 * @param reserved2 Second reserved bits.
	 * @param useNetwork Network access flags.
	 * @param reserved3 Third reserved bits.
	 */
	public FileAttributesTag(final RecordHeader header, final UBits reserved,
			final Flag useDirectBit, final Flag useGPU, final Flag hasMetadata,
			final Flag actionScript3, final UBits reserved2, final Flag useNetwork,
			final UBits reserved3) {
		super(header);

		this.reserved = reserved;
		this.useDirectBit = useDirectBit;
		this.useGPU = useGPU;
		this.hasMetadata = hasMetadata;
		this.actionScript3 = actionScript3;
		this.reserved2 = reserved2;
		this.useNetwork = useNetwork;
		this.reserved3 = reserved3;
	}

	/**
	 * Returns the ActionScript 3 flag.
	 * 
	 * @return The ActionScript 3 flag.
	 */
	public Flag getActionScript3() {
		return actionScript3;
	}

	/**
	 * Returns the metadata flag.
	 * 
	 * @return The metadata flag.
	 */
	public Flag getHasMetadata() {
		return hasMetadata;
	}

	/**
	 * Returns the first reserved bits.
	 * 
	 * @return The first reserved bits.
	 */
	public UBits getReserved() {
		return reserved;
	}

	/**
	 * Returns the second reserved bits.
	 * 
	 * @return The second reserved bits.
	 */
	public UBits getReserved2() {
		return reserved2;
	}

	/**
	 * Returns the third reserved bits.
	 * 
	 * @return The third reserved bits.
	 */
	public UBits getReserved3() {
		return reserved3;
	}

	/**
	 * Returns the hardware acceleration flag.
	 * 
	 * @return The hardware acceleration flag.
	 */
	public Flag getUseDirectBit() {
		return useDirectBit;
	}

	/**
	 * Returns the GPU flag.
	 * 
	 * @return The GPU flag.
	 */
	public Flag getUseGPU() {
		return useGPU;
	}

	/**
	 * Returns the network access flag.
	 * 
	 * @return The network access flag.
	 */
	public Flag getUseNetwork() {
		return useNetwork;
	}
}