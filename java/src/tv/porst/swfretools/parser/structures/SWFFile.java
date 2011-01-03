package tv.porst.swfretools.parser.structures;

import java.util.List;

import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT32;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.tags.Tag;

public class SWFFile {

	public SWFFile(final UINT8 signature1, final UINT8 signature2, final UINT8 signature3,
			final UINT8 version, final UINT32 fileLength, final Rect frameSize, final UINT16 frameRate,
			final UINT16 frameCount, final List<Tag> tags) {
		// TODO Auto-generated constructor stub
	}

}
