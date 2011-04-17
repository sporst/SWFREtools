import sys
import struct
import buggery
from buggery import idebug
from optparse import OptionParser

# Some register definitions because I have problems retrieving registers
# by name
EAX = 9
EBX = 6
ECX = 8
EDX = 7
ESI = 5
EDI = 4
EBP = 10

# This map contains the locations where to set the interesting breakpoints
# for each version of Flash Player. Each interesting location is a triple
# that contains the location of the interesting breakpoint in the file on
# disk, the bytes expected at that location, and the location of the
# interesting breakpoint in memory relative to the base address of Flash
# Player.
interestingLocations = { 
	"Flash Player 10.1.85.3" : {
		"AS2_BYTECODE" : (0xB7655, (0x40, 0x88, 0x54, 0x24), 0xB8252),
		"PARSE_TAGCODE" : (0xEE71B, (0x8B, 0xF8, 0x83, 0xFF), 0xEF31B),
	}
}

# Mapping between tag IDs and tag names.
tagNames = {
	0 : "End",
	1 : "ShowFrame",
	2 : "DefineShape",
	4 : "PlaceObject",
	5 : "RemoveObject",
	6 : "DefineBits",
	7 : "DefineButton",
	8 : "JPEGTables",
	9 : "SetBackgroundColor",
	10 : "DefineFont",
	11 : "DefineText",
	12 : "DoAction",
	13 : "DefineFontInfo",
	14 : "DefineSound",
	15 : "StartSound",
	17 : "DefineButtonSound",
	18 : "SoundStreamHead",
	19 : "SoundStreamBlock",
	20 : "DefineBitsLossless",
	21 : "DefineBitsJPEG2",
	22 : "DefineShape2",
	23 : "DefineButtonCxform",
	24 : "Protect",
	26 : "PlaceObject2",
	28 : "RemoveObject2",
	32 : "DefineShape3",
	33 : "DefineText2",
	34 : "DefineButton2",
	35 : "DefineBitsJPEG3",
	36 : "DefineBitsLossless2",
	37 : "DefineEditText",
	39 : "DefineSprite",
	43 : "FrameLabel",
	45 : "SoundStreamHead2",
	46 : "DefineMorphShape",
	48 : "DefineFont2",
	56 : "ExportAssets",
	57 : "ImportAssets",
	58 : "EnableDebugger",
	59 : "DoInitAction",
	60 : "DefineVideoStream",
	61 : "VideoFrame",
	62 : "DefineFontInfo2",
	64 : "EnableDebugger2",
	65 : "ScriptLimits",
	66 : "SetTabIndex",
	69 : "FileAttributes",
	70 : "PlaceObject3",
	71 : "ImportAssets2",
	73 : "DefineFontAlignZones",
	74 : "CSMTextSettings",
	75 : "DefineFont3",
	76 : "SymbolClass",
	77 : "Metadata",
	78 : "DefineScalingGrid",
	82 : "DoABC",
	83 : "DefineShape4",
	84 : "DefineMorphShape2",
	86 : "DefineSceneAndFrameLabelData",
	87 : "DefineBinaryData",
	88 : "DefineFontName",
	89 : "StartSound2",
	90 : "DefineBitsJPEG4",
	91 : "DefineFont4"
}

as2names = {
	0x00 : "ActionEnd",
	0x04 : "ActionNextFrame",
	0x05 : "ActionPreviousFrame",
	0x06 : "ActionPlay",
	0x07 : "ActionStop",
	0x08 : "ActionToggleQuality",
	0x09 : "ActionStopSounds",
	0x0A : "ActionAdd",
	0x0B : "ActionSubtract",
	0x0C : "ActionMultiply",
	0x0D : "ActionDivide",
	0x0E : "ActionEquals",
	0x0F : "ActionLess",
	0x10 : "ActionAnd",
	0x11 : "ActionOr",
	0x12 : "ActionNot",
	0x13 : "ActionStringEquals",
	0x14 : "ActionStringLength",
	0x15 : "ActionStringExtract",
	0x17 : "ActionPop",
	0x18 : "ActionToInteger",
	0x1C : "ActionGetVariable",
	0x1D : "ActionSetVariable",
	0x21 : "ActionStringAdd",
	0x20 : "ActionSetTarget2",
	0x22 : "ActionGetProperty",
	0x23 : "ActionSetProperty",
	0x24 : "ActionCloneSprite",
	0x25 : "ActionRemoveSprite",
	0x26 : "ActionTrace",
	0x27 : "ActionStartDrag",
	0x28 : "ActionEndDrag",
	0x29 : "ActionStringLess",
	0x2A : "ActionThrow",
	0x2B : "ActionCastOp",
	0x2C : "ActionImplementsOp",
	0x30 : "ActionRandomNumber",
	0x31 : "ActionMBStringLength",
	0x32 : "ActionCharToAscii",
	0x33 : "ActionAsciiToChar",
	0x34 : "ActionGetTime",
	0x35 : "ActionMBStringExtract",
	0x36 : "ActionMBCharToAscii",
	0x37 : "ActionMBAsciiToChar",
	0x3A : "ActionDelete",
	0x3B : "ActionDelete2",
	0x3C : "ActionDefineLocal",
	0x3D : "ActionCallFunction",
	0x3E : "ActionReturn",
	0x3F : "ActionModulo",
	0x40 : "ActionNewObject",
	0x41 : "ActionDefineLocal2",
	0x42 : "ActionInitArray",
	0x43 : "ActionInitObject",
	0x44 : "ActionTypeOf",
	0x45 : "ActionTargetPath",
	0x46 : "ActionEnumerate",
	0x47 : "ActionAdd2",
	0x48 : "ActionLess2",
	0x49 : "ActionEquals2",
	0x4A : "ActionToNumbers",
	0x4B : "ActionToString",
	0x4C : "ActionPushDuplicate",
	0x4D : "ActionStackSwap",
	0x4E : "ActionGetMember",
	0x4F : "ActionSetMember",
	0x50 : "ActionIncrement",
	0x51 : "ActionDecrement",
	0x52 : "ActionCallMethod",
	0x53 : "ActionNewMethod",
	0x54 : "ActionInstanceOf",
	0x55 : "ActionEnumerate2",
	0x60 : "ActionBitAnd",
	0x61 : "ActionBitOr",
	0x62 : "ActionBitXor",
	0x63 : "ActionBitLShift",
	0x64 : "ActionBitRShift",
	0x65 : "ActionBitURShift",
	0x66 : "ActionStrictEquals",
	0x67 : "ActionGreater",
	0x68 : "ActionStringGreater",
	0x69 : "ActionExtends",
	0x81 : "ActionGotoFrame",
	0x83 : "ActionGetURL",
	0x87 : "ActionStoreRegister",
	0x88 : "ActionConstantPool",
	0x8A : "ActionWaitForFrame",
	0x8B : "ActionSetTarget",
	0x8C : "ActionGotoLabel",
	0x8D : "ActionWaitForFrame2",
	0x8E : "ActionDefineFunction2",
	0x8F : "ActionTry",
	0x94 : "ActionWith",
	0x96 : "ActionPush",
	0x99 : "ActionJump",
	0x9B : "ActionDefineFunction",
	0x9D : "ActionIf",
	0x9E : "ActionCall",
	0x9A : "ActionGetURL2",
	0x9F : "ActionGotoFrame2"
}

def matchesBytes(data, offset, pattern):
	"""
	This function takes the binary data of the Flash Player executable file, the offset
	of an interesting breakpoint and its expected byte pattern and verifies that the
	byte pattern at the offset in the Flash Player executable matches the expected byte
	pattern.
	"""
	return tuple(map(ord, data[offset:offset + len(pattern)])) == pattern

def extractBreakpoints(breakpoints):
	"""
	This function takes a breakpoint map from the interestingLocations array and creates
	a map { name -> offset in memory } by stripping all other information from the input
	map.
	"""
	extractedBreakpoints = { }
	
	for k, v in breakpoints.items():
		extractedBreakpoints[k] = v[2]
	
	return extractedBreakpoints
	
def getBreakpoints(file):
	"""
	This function takes the path to the Flash Player executable to be hooked
	and returns the interesting breakpoint locations for that specific version
	of Flash Player.
	"""

	# To find out where to set the breakpoints, we read the Flash Player file and check for values
	# at certain offsets to determine the Flash Player version.
	fh = open(file, 'rb')
	data = fh.read()
	fh.close()
	
	for k, v in interestingLocations.items():
		match = True
		for offset in v.values():
			if len(data) < offset[0] + len(offset[1]) or not matchesBytes(data, offset[0], offset[1]):
				match = False
				break
		if match:
			return extractBreakpoints(v)
			
	return None

class Tracer(object):
	def __init__(self, flashPlayer, breakpoints, debuggerOptions):
	
		self.flashPlayer = flashPlayer
		self.breakpoints = breakpoints
		self.debuggerOptions = debuggerOptions
	
		self.dbg = buggery.Debugger()
		self.dbg.set_event_handler("CREATEPROCESS", self.onCreateProcess)

	def onCreateProcess(self, event):
		self.insert_bps(event.baseOffset)

	def insert_bps(self, baseOffset):
		if self.debuggerOptions.as2:
			bp = self.dbg.breakpoint(baseOffset + self.breakpoints["AS2_BYTECODE"], self.onAS2Breakpoint)
		if self.debuggerOptions.tags:
			bp = self.dbg.breakpoint(baseOffset + self.breakpoints["PARSE_TAGCODE"], self.onTagBreakpoint)

	def readMemory(self, offset, length):
		return self.dbg.dataspaces.read(offset, length)
			
	def onAS2Breakpoint(self, bp):
		# At this point, the ActionScript opcode is in DL while ECX is the base address of
		# the code data and EAX is the instruction pointer.
		
		opCode = self.dbg.registers.get_value(EDX) & 0xFF
		instructionPointer = self.dbg.registers.get_value(EAX)
		
		print "%s: %s (%02X)" % ("%08X" % instructionPointer, as2names[opCode], opCode)

	def onTagBreakpoint(self, bp):
		# At this point, the processed tag code is in EAX, the base address of the tag data
		# is in [ebp] and the relative position into the tag data is in [ebp+4].
		
		tagCode = self.dbg.registers.get_value(EAX)
		dataPointer = self.dbg.registers.get_value(EBP)
		relativePosition = struct.unpack("I", self.readMemory(dataPointer + 4, 4))
		
		print "%s: %s (%02X)" % ("%08X" % relativePosition, tagNames[tagCode], tagCode)

	def run(self):
		self.dbg.spawn(self.flashPlayer)
		while True:
			self.dbg.wait_for_event()

def main(args):
	parser = OptionParser()
	parser.add_option("--tags", action="store_true", dest="tags", default=False, help="Dump information about parsed tags")
	parser.add_option("--as2", action="store_true", dest="as2", default=False, help="Dump information about ActionScript 2 code")

	(debuggerOptions, args) = parser.parse_args()
	
	if len(args) != 1:
		print "usage: flash_debug.py flash_player_executable"
		return
	
	flashPlayer = args[0]
	
	breakpoints = getBreakpoints(flashPlayer)
	
	if not breakpoints:
		print "Could not determine version of the Flash Player executable"
		return
	
	tracer = Tracer(flashPlayer, breakpoints, debuggerOptions)
	tracer.run()

if __name__ == "__main__":
	main(sys.argv)