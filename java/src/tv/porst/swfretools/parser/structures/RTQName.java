package tv.porst.swfretools.parser.structures;

public class RTQName implements IMultiname {

	private final EncodedU30 name;

	public RTQName(final EncodedU30 name) {
		this.name = name;
	}

	@Override
	public int getBitLength() {
		return name.getBitLength();
	}

	@Override
	public int getBitPosition() {
		return name.getBitPosition();
	}

}
