package tv.porst.swfretools.utils;

import tv.porst.swfretools.parser.tags.TagCodes;

public class TagNames {

	public static String getTagName(final int code) {

		switch(code) {
		case TagCodes.End: return "End";
		case TagCodes.ShowFrame: return "ShowFrame";
		case TagCodes.DefineShape: return "DefineShape";
		case TagCodes.PlaceObject: return "PlaceObject";
		case TagCodes.RemoveObject: return "RemoveObject";
		case TagCodes.DefineBits: return "DefineBits";
		case TagCodes.DefineButton: return "DefineButton";
		case TagCodes.JPEGTables: return "JPEGTables";
		case TagCodes.SetBackgroundColor: return "SetBackgroundColor";
		case TagCodes.DefineFont: return "DefineFont";
		case TagCodes.DefineText: return "DefineText";
		case TagCodes.DoAction: return "DoAction";
		case TagCodes.DefineFontInfo: return "DefineFontInfo";
		case TagCodes.DefineSound: return "DefineSound";
		case TagCodes.StartSound: return "StartSound";
		case TagCodes.DefineButtonSound: return "DefineButtonSound";
		case TagCodes.SoundStreamHead: return "SoundStreamHead";
		case TagCodes.SoundStreamBlock: return "SoundStreamBlock";
		case TagCodes.DefineBitsLossless: return "DefineBitsLossless";
		case TagCodes.DefineBitsJPEG2: return "DefineBitsJPEG2";
		case TagCodes.DefineShape2: return "DefineShape2";
		case TagCodes.DefineButtonCxform: return "DefineButtonCxform";
		case TagCodes.Protect: return "Protect";
		case TagCodes.PlaceObject2: return "PlaceObject2";
		case TagCodes.RemoveObject2: return "RemoveObject2";
		case TagCodes.DefineShape3: return "DefineShape3";
		case TagCodes.DefineText2: return "DefineText2";
		case TagCodes.DefineButton2: return "DefineButton2";
		case TagCodes.DefineBitsJPEG3: return "DefineBitsJPEG3";
		case TagCodes.DefineBitsLossless2: return "DefineBitsLossless2";
		case TagCodes.DefineEditText: return "DefineEditText";
		case TagCodes.DefineSprite: return "DefineSprite";
		case TagCodes.FrameLabel: return "FrameLabel";
		case TagCodes.SoundStreamHead2: return "SoundStreamHead2";
		case TagCodes.DefineMorphShape: return "DefineMorphShape";
		case TagCodes.DefineFont2: return "DefineFont2";
		case TagCodes.ExportAssets: return "ExportAssets";
		case TagCodes.ImportAssets: return "ImportAssets";
		case TagCodes.EnableDebugger: return "EnableDebugger";
		case TagCodes.DoInitAction: return "DoInitAction";
		case TagCodes.DefineVideoStream: return "DefineVideoStream";
		case TagCodes.VideoFrame: return "VideoFrame";
		case TagCodes.DefineFontInfo2: return "DefineFontInfo2";
		case TagCodes.EnableDebugger2: return "EnableDebugger2";
		case TagCodes.ScriptLimits: return "ScriptLimits";
		case TagCodes.SetTabIndex: return "SetTabIndex";
		case TagCodes.FileAttributes: return "FileAttributes";
		case TagCodes.PlaceObject3: return "PlaceObject3";
		case TagCodes.ImportAssets2: return "ImportAssets2";
		case TagCodes.DefineFontAlignZones: return "DefineFontAlignZones";
		case TagCodes.CSMTextSettings: return "CSMTextSettings";
		case TagCodes.DefineFont3: return "DefineFont3";
		case TagCodes.SymbolClass: return "SymbolClass";
		case TagCodes.Metadata: return "Metadata";
		case TagCodes.DefineScalingGrid: return "DefineScalingGrid";
		case TagCodes.DefineShape4: return "DefineShape4";
		case TagCodes.DefineMorphShape2: return "DefineMorphShape2";
		case TagCodes.DefineSceneAndFrameLabelData: return "DefineSceneAndFrameLabelData";
		case TagCodes.DefineBinaryData: return "DefineBinaryData";
		case TagCodes.DefineFontName: return "DefineFontName";
		case TagCodes.StartSound2: return "StartSound2";
		case TagCodes.DefineBitsJPEG4: return "DefineBitsJPEG4";
		case TagCodes.DefineFont4: return "DefineFont4";
		case TagCodes.DoABC: return "DoABC";
		default: return "Unknown Tag";
		}
	}
}