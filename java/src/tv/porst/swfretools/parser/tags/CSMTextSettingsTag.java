package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.Bits;
import tv.porst.splib.io.Float32;
import tv.porst.splib.io.UINT16;
import tv.porst.splib.io.UINT8;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class CSMTextSettingsTag extends Tag {

	public CSMTextSettingsTag(final RecordHeader header, final UINT16 textID,
			final Bits useFlashType, final Bits gridFit, final Bits reserved, final Float32 thickness,
			final Float32 sharpness, final UINT8 reserved2) {
		super(header);
	}

}
