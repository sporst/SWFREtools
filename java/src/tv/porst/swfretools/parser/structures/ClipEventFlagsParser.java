package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.Bits;
import tv.porst.splib.io.Flag;

public class ClipEventFlagsParser {

	public static ClipEventFlags parse(final BinaryParser parser, final int version) {

		final Flag clipEventKeyUp = parser.readFlag();
		final Flag clipEventKeyDown = parser.readFlag();
		final Flag clipEventMouseUp = parser.readFlag();
		final Flag clipEventMouseDown = parser.readFlag();
		final Flag clipEventMouseMove = parser.readFlag();
		final Flag clipEventUnload = parser.readFlag();
		final Flag clipEventEnterFrame = parser.readFlag();
		final Flag clipEventLoad = parser.readFlag();
		final Flag clipEventDragOver = parser.readFlag();
		final Flag clipEventRollOut = parser.readFlag();
		final Flag clipEventRollOver = parser.readFlag();
		final Flag clipEventReleaseOutside = parser.readFlag();
		final Flag clipEventRelease = parser.readFlag();
		final Flag clipEventPress = parser.readFlag();
		final Flag clipEventInitialize = parser.readFlag();
		final Flag clipEventData = parser.readFlag();

		final Bits reserved = version >= 6 ? parser.readBits(5) : null;
		final Flag clipEventConstruct = version >= 6 ? parser.readFlag() : null;
		final Flag clipEventKeyPress = version >= 6 ? parser.readFlag() : null;
		final Flag clipEventDragOut = version >= 6 ? parser.readFlag() : null;
		final Bits reserved2 = version >= 6 ? parser.readBits(8) : null;

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
