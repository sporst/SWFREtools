package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.INT32;

public class RecordHeader {

	private final int tagCode;
	private final int length;
	private final INT32 extraLength;

	public RecordHeader(final int tagCode, final int length, final INT32 extraLength) {
		this.tagCode = tagCode;
		this.length = length;
		this.extraLength = extraLength;
	}

	public int getNormalizedLength() {
		return length == 0x3F ? extraLength.value() : length;
	}

	public int getTagCode() {
		return tagCode;
	}

}
