package tv.porst.swfretools.parser.structures;

import java.util.List;

public class NamespaceSetInfo {

	private final EncodedU30 count;

	public NamespaceSetInfo(final EncodedU30 count, final List<EncodedU30> namespaces) {
		this.count = count;
	}

}
