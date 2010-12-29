package tv.porst.swfretools.parser.structures;

public class RecordHeader {

	private final int tagCode;
	private final int length;
	private final int extraLength;

	public RecordHeader(final int tagCode, final int length, final int extraLength) {
		this.tagCode = tagCode;
		this.length = length;
		this.extraLength = extraLength;
	}

	public int getNormalizedLength() {
		return length == 0x3F ? extraLength : length;
	}

	public int getTagCode() {
		return tagCode;
	}

}
