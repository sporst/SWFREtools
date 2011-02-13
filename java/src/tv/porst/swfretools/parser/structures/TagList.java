package tv.porst.swfretools.parser.structures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import tv.porst.swfretools.parser.tags.Tag;

public class TagList implements Iterable<Tag> {

	private final List<Tag> tags;

	public TagList(final List<Tag> tags) {
		this.tags = new ArrayList<Tag>(tags);
	}

	public int getBytePosition() {
		return tags.get(0).getHeader().getPosition();
	}

	@Override
	public Iterator<Tag> iterator() {
		return new ArrayList<Tag>(tags).iterator();
	}

	public int size() {
		return tags.size();
	}
}