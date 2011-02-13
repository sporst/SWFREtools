package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.Flag;
import tv.porst.splib.binaryparser.UBits;

/**
 * Represents a ClipEventFlags structure.
 * 
 * @author sp
 *
 */
public final class ClipEventFlags implements IFileElement {

	/**
	 * Key up event flag.
	 */
	private final Flag clipEventKeyUp;

	/**
	 * Key down event flag.
	 */
	private final Flag clipEventKeyDown;

	/**
	 * Mouse up event flag.
	 */
	private final Flag clipEventMouseUp;

	/**
	 * Mouse down event flag.
	 */
	private final Flag clipEventMouseDown;

	/**
	 * Mouse move event flag.
	 */
	private final Flag clipEventMouseMove;

	/**
	 * Unload event flag.
	 */
	private final Flag clipEventUnload;

	/**
	 * Enter frame event flag.
	 */
	private final Flag clipEventEnterFrame;

	/**
	 * Load event flag.
	 */
	private final Flag clipEventLoad;

	/**
	 * Drag over event flag.
	 */
	private final Flag clipEventDragOver;

	/**
	 * Roll out flag event flag.
	 */
	private final Flag clipEventRollOut;

	/**
	 * Roll over event flag.
	 */
	private final Flag clipEventRollOver;

	/**
	 * Release outside event flag.
	 */
	private final Flag clipEventReleaseOutside;

	/**
	 * Mouse release event flag.
	 */
	private final Flag clipEventRelease;

	/**
	 * Mouse press event flag.
	 */
	private final Flag clipEventPress;

	/**
	 * Initialize event flag.
	 */
	private final Flag clipEventInitialize;

	/**
	 * Data received event flag.
	 */
	private final Flag clipEventData;

	/**
	 * Reserved bits.
	 */
	private final UBits reserved;

	/**
	 * Construct event flag.
	 */
	private final Flag clipEventConstruct;

	/**
	 * Key press event flag.
	 */
	private final Flag clipEventKeyPress;

	/**
	 * Mouse drag out event flag.
	 */
	private final Flag clipEventDragOut;

	/**
	 * Reserved bits.
	 */
	private final UBits reserved2;

	/**
	 * Creates a new ClipEventFlags object.
	 * 
	 * @param clipEventKeyUp Key up event flag.
	 * @param clipEventKeyDown Key down event flag.
	 * @param clipEventMouseUp Mouse up event flag.
	 * @param clipEventMouseDown Mouse down event flag.
	 * @param clipEventMouseMove Mouse move event flag.
	 * @param clipEventUnload Unload event flag.
	 * @param clipEventEnterFrame Enter frame flag.
	 * @param clipEventLoad Load flag.
	 * @param clipEventDragOver Drag over flag.
	 * @param clipEventRollOut Roll out flag.
	 * @param clipEventRollOver Roll over flag.
	 * @param clipEventReleaseOutside Release outside flag.
	 * @param clipEventRelease Mouse release flag.
	 * @param clipEventPress Mouse press flag.
	 * @param clipEventInitialize Initialize event flag.
	 * @param clipEventData Data received event flag.
	 * @param reserved Reserved bits.
	 * @param clipEventConstruct Construct event flag.
	 * @param clipEventKeyPress Key press event flag.
	 * @param clipEventDragOut Mouse drag out event flag.
	 * @param reserved2 Reserved bits.
	 */
	public ClipEventFlags(final Flag clipEventKeyUp, final Flag clipEventKeyDown,
			final Flag clipEventMouseUp, final Flag clipEventMouseDown,
			final Flag clipEventMouseMove, final Flag clipEventUnload,
			final Flag clipEventEnterFrame, final Flag clipEventLoad, final Flag clipEventDragOver,
			final Flag clipEventRollOut, final Flag clipEventRollOver,
			final Flag clipEventReleaseOutside, final Flag clipEventRelease,
			final Flag clipEventPress, final Flag clipEventInitialize, final Flag clipEventData,
			final UBits reserved, final Flag clipEventConstruct, final Flag clipEventKeyPress,
			final Flag clipEventDragOut, final UBits reserved2) {

		this.clipEventKeyUp = clipEventKeyUp;
		this.clipEventKeyDown = clipEventKeyDown;
		this.clipEventMouseUp = clipEventMouseUp;
		this.clipEventMouseDown = clipEventMouseDown;
		this.clipEventMouseMove = clipEventMouseMove;
		this.clipEventUnload = clipEventUnload;
		this.clipEventEnterFrame = clipEventEnterFrame;
		this.clipEventLoad = clipEventLoad;
		this.clipEventDragOver = clipEventDragOver;
		this.clipEventRollOut = clipEventRollOut;
		this.clipEventRollOver = clipEventRollOver;
		this.clipEventReleaseOutside = clipEventReleaseOutside;
		this.clipEventRelease = clipEventRelease;
		this.clipEventPress = clipEventPress;
		this.clipEventInitialize = clipEventInitialize;
		this.clipEventData = clipEventData;
		this.reserved = reserved;
		this.clipEventConstruct = clipEventConstruct;
		this.clipEventKeyPress = clipEventKeyPress;
		this.clipEventDragOut = clipEventDragOut;
		this.reserved2 = reserved2;
	}

	@Override
	public int getBytePosition() {
		return clipEventKeyUp.getBytePosition();
	}

	/**
	 * Returns the construct event flag.
	 *
	 * @return The construct event flag.
	 */
	public Flag getClipEventConstruct() {
		return clipEventConstruct;
	}

	/**
	 * Returns the data received event flag.
	 *
	 * @return The data received event flag.
	 */
	public Flag getClipEventData() {
		return clipEventData;
	}

	/**
	 * Returns the mouse drag out event flag.
	 *
	 * @return The mouse drag out event flag.
	 */
	public Flag getClipEventDragOut() {
		return clipEventDragOut;
	}

	/**
	 * Returns the drag over event flag.
	 *
	 * @return The drag over event flag.
	 */
	public Flag getClipEventDragOver() {
		return clipEventDragOver;
	}

	/**
	 * Returns the Enter frame event flag.
	 *
	 * @return The Enter frame event flag.
	 */
	public Flag getClipEventEnterFrame() {
		return clipEventEnterFrame;
	}

	/**
	 * Returns the Initialize event flag.
	 *
	 * @return The Initialize event flag.
	 */
	public Flag getClipEventInitialize() {
		return clipEventInitialize;
	}

	/**
	 * Returns the Key down event flag.
	 *
	 * @return The Key down event flag.
	 */
	public Flag getClipEventKeyDown() {
		return clipEventKeyDown;
	}

	/**
	 * Returns the Key press event flag.
	 * 
	 * @return The Key press event flag.
	 */
	public Flag getClipEventKeyPress() {
		return clipEventKeyPress;
	}

	/**
	 * Returns the Key up event flag.
	 *
	 * @return The Key up event flag.
	 */
	public Flag getClipEventKeyUp() {
		return clipEventKeyUp;
	}

	/**
	 * Returns the Load event flag.
	 *
	 * @return The Load event flag.
	 */
	public Flag getClipEventLoad() {
		return clipEventLoad;
	}

	/**
	 * Returns the Mouse down event flag.
	 *
	 * @return The Mouse down event flag.
	 */
	public Flag getClipEventMouseDown() {
		return clipEventMouseDown;
	}

	/**
	 * Returns the Mouse move event flag.
	 *
	 * @return The Mouse move event flag.
	 */
	public Flag getClipEventMouseMove() {
		return clipEventMouseMove;
	}

	/**
	 * Returns the Mouse up event flag.
	 *
	 * @return The Mouse up event flag.
	 */
	public Flag getClipEventMouseUp() {
		return clipEventMouseUp;
	}

	/**
	 * Returns the Mouse press event flag.
	 *
	 * @return The Mouse press event flag.
	 */
	public Flag getClipEventPress() {
		return clipEventPress;
	}

	/**
	 * Returns the Mouse release event flag.
	 *
	 * @return The Mouse release event flag.
	 */
	public Flag getClipEventRelease() {
		return clipEventRelease;
	}

	/**
	 * Returns the Release outside event flag.
	 *
	 * @return The Release outside event flag.
	 */
	public Flag getClipEventReleaseOutside() {
		return clipEventReleaseOutside;
	}

	/**
	 * Returns the Roll out flag event flag.
	 *
	 * @return The Roll out flag event flag.
	 */
	public Flag getClipEventRollOut() {
		return clipEventRollOut;
	}

	/**
	 * Returns the Roll over event flag.
	 *
	 * @return The Roll over event flag.
	 */
	public Flag getClipEventRollOver() {
		return clipEventRollOver;
	}

	/**
	 * Returns the Unload event flag.
	 *
	 * @return The Unload event flag.
	 */
	public Flag getClipEventUnload() {
		return clipEventUnload;
	}

	/**
	 * Returns the Reserved bits.
	 *
	 * @return The Reserved bits.
	 */
	public UBits getReserved() {
		return reserved;
	}

	/**
	 * Returns the Reserved bits.
	 *
	 * @return The Reserved bits.
	 */
	public UBits getReserved2() {
		return reserved2;
	}
}