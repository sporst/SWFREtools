package tv.porst.swfretools.parser.structures;

public class ClipEventFlags {

	private final int clipEventKeyPress;

	public ClipEventFlags(final int clipEventKeyUp, final int clipEventKeyDown,
			final int clipEventMouseUp, final int clipEventMouseDown,
			final int clipEventMouseMove, final int clipEventUnload,
			final int clipEventEnterFrame, final int clipEventLoad, final int clipEventDragOver,
			final int clipEventRollOut, final int clipEventRollOver,
			final int clipEventReleaseOutside, final int clipEventRelease,
			final int clipEventPress, final int clipEventInitialize, final int clipEventData,
			final int reserved, final int clipEventConstruct, final int clipEventKeyPress,
			final int clipEventDragOut, final int reserved2) {

		this.clipEventKeyPress = clipEventKeyPress;
	}

	public int getClipEventKeyPress() {
		return clipEventKeyPress;
	}

}
