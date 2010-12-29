package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;

public class ClipEventFlagsParser {

	public static ClipEventFlags parse(final BinaryParser parser, final int version) {

		final int clipEventKeyUp = parser.readBits(1);
		final int clipEventKeyDown = parser.readBits(1);
		final int clipEventMouseUp = parser.readBits(1);
		final int clipEventMouseDown = parser.readBits(1);
		final int clipEventMouseMove = parser.readBits(1);
		final int clipEventUnload = parser.readBits(1);
		final int clipEventEnterFrame = parser.readBits(1);
		final int clipEventLoad = parser.readBits(1);
		final int clipEventDragOver = parser.readBits(1);
		final int clipEventRollOut = parser.readBits(1);
		final int clipEventRollOver = parser.readBits(1);
		final int clipEventReleaseOutside = parser.readBits(1);
		final int clipEventRelease = parser.readBits(1);
		final int clipEventPress = parser.readBits(1);
		final int clipEventInitialize = parser.readBits(1);
		final int clipEventData = parser.readBits(1);

		final int reserved = version >= 6 ? parser.readBits(5) : 0;
		final int clipEventConstruct = version >= 6 ? parser.readBits(1) : 0;
		final int clipEventKeyPress = version >= 6 ? parser.readBits(1) : 0;
		final int clipEventDragOut = version >= 6 ? parser.readBits(1) : 0;
		final int reserved2 = version >= 6 ? parser.readBits(8) : 0;

		return new ClipEventFlags(clipEventKeyUp, clipEventKeyDown,
				clipEventMouseUp, clipEventMouseDown, clipEventMouseMove,
				clipEventUnload, clipEventEnterFrame, clipEventLoad,
				clipEventDragOver, clipEventRollOut, clipEventRollOver,
				clipEventReleaseOutside, clipEventRelease, clipEventPress,
				clipEventInitialize, clipEventData, reserved,
				clipEventConstruct, clipEventKeyPress, clipEventDragOut,
				reserved2);
	}
}
