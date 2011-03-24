package tv.porst.swfretools.parser.actions.as2;

import tv.porst.splib.binaryparser.UINT16;
import tv.porst.splib.binaryparser.UINT8;

public abstract class ExtendedAction extends Action {

	private final UINT16 length;

	public ExtendedAction(final UINT8 actionCode, final UINT16 length) {
		super(actionCode);

		this.length = length;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public UINT16 getLength() {
		return length;
	}

}
