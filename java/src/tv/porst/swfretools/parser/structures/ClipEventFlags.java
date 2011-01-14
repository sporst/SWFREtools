package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.Bits;
import tv.porst.splib.io.Flag;

public class ClipEventFlags {

	private final Flag clipEventKeyPress;

	public ClipEventFlags(final Flag clipEventKeyUp, final Flag clipEventKeyDown,
			final Flag clipEventMouseUp, final Flag clipEventMouseDown,
			final Flag clipEventMouseMove, final Flag clipEventUnload,
			final Flag clipEventEnterFrame, final Flag clipEventLoad, final Flag clipEventDragOver,
			final Flag clipEventRollOut, final Flag clipEventRollOver,
			final Flag clipEventReleaseOutside, final Flag clipEventRelease,
			final Flag clipEventPress, final Flag clipEventInitialize, final Flag clipEventData,
			final Bits reserved, final Flag clipEventConstruct, final Flag clipEventKeyPress,
			final Flag clipEventDragOut, final Bits reserved2) {

		this.clipEventKeyPress = clipEventKeyPress;
	}

	public Flag getClipEventKeyPress() {
		return clipEventKeyPress;
	}

}
