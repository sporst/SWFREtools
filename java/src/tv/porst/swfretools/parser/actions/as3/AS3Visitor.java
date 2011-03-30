package tv.porst.swfretools.parser.actions.as3;

public abstract class AS3Visitor {

	protected abstract void visit(final AS3Add instruction);

	protected abstract void visit(final AS3Addi instruction);

	protected abstract void visit(final AS3Astype instruction);

	protected abstract void visit(final AS3Astypelate instruction);

	protected abstract void visit(final AS3Bitand instruction);

	protected abstract void visit(final AS3Bitnot instruction);

	protected abstract void visit(final AS3Bitor instruction);

	protected abstract void visit(final AS3Bitxor instruction);

	protected abstract void visit(final AS3Call instruction);

	protected abstract void visit(final AS3Callmethod instruction);

	protected abstract void visit(final AS3Callproperty instruction);

	protected abstract void visit(final AS3Callproplex instruction);

	protected abstract void visit(final AS3Callpropvoid instruction);

	protected abstract void visit(final AS3Callstatic instruction);

	protected abstract void visit(final AS3Callsuper instruction);

	protected abstract void visit(final AS3Callsupervoid instruction);

	protected abstract void visit(final AS3Checkfilter instruction);

	protected abstract void visit(final AS3Coerce instruction);

	protected abstract void visit(final AS3Coercea instruction);

	protected abstract void visit(final AS3Coerces instruction);

	protected abstract void visit(final AS3Construct instruction);

	protected abstract void visit(final AS3Constructprop instruction);

	protected abstract void visit(final AS3Constructsuper instruction);

	protected abstract void visit(final AS3Convertb instruction);

	protected abstract void visit(final AS3Convertd instruction);

	protected abstract void visit(final AS3Converti instruction);

	protected abstract void visit(final AS3Converto instruction);

	protected abstract void visit(final AS3Converts instruction);

	protected abstract void visit(final AS3Convertu instruction);

	protected abstract void visit(final AS3Debug instruction);

	protected abstract void visit(final AS3Debugfile instruction);

	protected abstract void visit(final AS3Debugline instruction);

	protected abstract void visit(final AS3Declocal instruction);

	protected abstract void visit(final AS3Declocali instruction);

	protected abstract void visit(final AS3Decrement instruction);

	protected abstract void visit(final AS3Decrementi instruction);

	protected abstract void visit(final AS3Deleteproperty instruction);

	protected abstract void visit(final AS3Divide instruction);

	protected abstract void visit(final AS3Dup instruction);

	protected abstract void visit(final AS3Dxns instruction);

	protected abstract void visit(final AS3Dxnslate instruction);

	protected abstract void visit(final AS3Equals instruction);

	protected abstract void visit(final AS3Escxattr instruction);

	protected abstract void visit(final AS3Escxelem instruction);

	protected abstract void visit(final AS3Findproperty instruction);

	protected abstract void visit(final AS3Findpropstrict instruction);

	protected abstract void visit(final AS3Getdescendants instruction);

	protected abstract void visit(final AS3Getglobalscope instruction);

	protected abstract void visit(final AS3Getglobalslot instruction);

	protected abstract void visit(final AS3Getlex instruction);

	protected abstract void visit(final AS3Getlocal instruction);

	protected abstract void visit(final AS3Getlocal0 instruction);

	protected abstract void visit(final AS3Getlocal1 instruction);

	protected abstract void visit(final AS3Getlocal2 instruction);

	protected abstract void visit(final AS3Getlocal3 instruction);

	protected abstract void visit(final AS3Getproperty instruction);

	protected abstract void visit(final AS3Getscopeobject instruction);

	protected abstract void visit(final AS3Getslot instruction);

	protected abstract void visit(final AS3Getsuper instruction);

	protected abstract void visit(final AS3Greaterthan instruction);

	protected abstract void visit(final AS3Hasnext instruction);

	protected abstract void visit(final AS3Hasnext2 instruction);

	protected abstract void visit(final AS3Ifeq instruction);

	protected abstract void visit(final AS3Iffalse instruction);

	protected abstract void visit(final AS3Ifge instruction);

	protected abstract void visit(final AS3Ifgt instruction);

	protected abstract void visit(final AS3Ifle instruction);

	protected abstract void visit(final AS3Iflt instruction);

	protected abstract void visit(final AS3Ifne instruction);

	protected abstract void visit(final AS3Ifnge instruction);

	protected abstract void visit(final AS3Ifngt instruction);

	protected abstract void visit(final AS3Ifnle instruction);

	protected abstract void visit(final AS3Ifnlt instruction);

	protected abstract void visit(final AS3Ifstricteq instruction);

	protected abstract void visit(final AS3Ifstrictne instruction);

	protected abstract void visit(final AS3Iftrue instruction);

	protected abstract void visit(final AS3In instruction);

	protected abstract void visit(final AS3Increment instruction);

	protected abstract void visit(final AS3Incrementi instruction);

	protected abstract void visit(final AS3Initproperty instruction);

	protected abstract void visit(final AS3Inlocal instruction);

	protected abstract void visit(final AS3Inlocali instruction);

	protected abstract void visit(final AS3Instanceof instruction);

	protected abstract void visit(final AS3Istype instruction);

	protected abstract void visit(final AS3Istypelate instruction);

	protected abstract void visit(final AS3Jump instruction);

	protected abstract void visit(final AS3Kill instruction);

	protected abstract void visit(final AS3Label instruction);

	protected abstract void visit(final AS3Lessequals instruction);

	protected abstract void visit(final AS3Lessthan instruction);

	protected abstract void visit(final AS3Lookupswitch instruction);

	protected abstract void visit(final AS3Lshift instruction);

	protected abstract void visit(final AS3Modulo instruction);

	protected abstract void visit(final AS3Multiply instruction);

	protected abstract void visit(final AS3Multiplyi instruction);

	protected abstract void visit(final AS3Negate instruction);

	protected abstract void visit(final AS3Negatei instruction);

	protected abstract void visit(final AS3Newactivation instruction);

	protected abstract void visit(final AS3Newarray instruction);

	protected abstract void visit(final AS3Newcatch instruction);

	protected abstract void visit(final AS3Newclass instruction);

	protected abstract void visit(final AS3Newfunction instruction);

	protected abstract void visit(final AS3Newobject instruction);

	protected abstract void visit(final AS3Nextname instruction);

	protected abstract void visit(final AS3Nextvalue instruction);

	protected abstract void visit(final AS3Nop instruction);

	protected abstract void visit(final AS3Not instruction);

	protected abstract void visit(final AS3Pop instruction);

	protected abstract void visit(final AS3Popscope instruction);

	protected abstract void visit(final AS3Pushbyte instruction);

	protected abstract void visit(final AS3Pushdouble instruction);

	protected abstract void visit(final AS3Pushfalse instruction);

	protected abstract void visit(final AS3Pushint instruction);

	protected abstract void visit(final AS3Pushnamespace instruction);

	protected abstract void visit(final AS3Pushnan instruction);

	protected abstract void visit(final AS3Pushnull instruction);

	protected abstract void visit(final AS3Pushscope instruction);

	protected abstract void visit(final AS3Pushshort instruction);

	protected abstract void visit(final AS3Pushstring instruction);

	protected abstract void visit(final AS3Pushtrue instruction);

	protected abstract void visit(final AS3Pushuint instruction);

	protected abstract void visit(final AS3Pushundefined instruction);

	protected abstract void visit(final AS3Pushwith instruction);

	protected abstract void visit(final AS3Returnvalue instruction);

	protected abstract void visit(final AS3Returnvoid instruction);

	protected abstract void visit(final AS3Rshift instruction);

	protected abstract void visit(final AS3Setglobalslot instruction);

	protected abstract void visit(final AS3Setlocal instruction);

	protected abstract void visit(final AS3Setlocal0 instruction);

	protected abstract void visit(final AS3Setlocal1 instruction);

	protected abstract void visit(final AS3Setlocal2 instruction);

	protected abstract void visit(final AS3Setlocal3 instruction);

	protected abstract void visit(final AS3Setproperty instruction);

	protected abstract void visit(final AS3Setslot instruction);

	protected abstract void visit(final AS3Setsuper instruction);

	protected abstract void visit(final AS3Strictequals instruction);

	protected abstract void visit(final AS3Subtract instruction);

	protected abstract void visit(final AS3Subtracti instruction);

	protected abstract void visit(final AS3Swap instruction);

	protected abstract void visit(final AS3Throw instruction);

	protected abstract void visit(final AS3Typeof instruction);

	protected abstract void visit(final AS3UnknownInstruction instruction);

	protected abstract void visit(final AS3Urshift instruction);

	public void visit(final AS3Instruction instruction) {
		if (instruction instanceof AS3Add) {
			visit((AS3Add) instruction);
		}
		else if (instruction instanceof AS3Addi) {
			visit((AS3Addi) instruction);
		}
		else if (instruction instanceof AS3Astype) {
			visit((AS3Astype) instruction);
		}
		else if (instruction instanceof AS3Astypelate) {
			visit((AS3Astypelate) instruction);
		}
		else if (instruction instanceof AS3Bitand) {
			visit((AS3Bitand) instruction);
		}
		else if (instruction instanceof AS3Bitnot) {
			visit((AS3Bitnot) instruction);
		}
		else if (instruction instanceof AS3Bitor) {
			visit((AS3Bitor) instruction);
		}
		else if (instruction instanceof AS3Bitxor) {
			visit((AS3Bitxor) instruction);
		}
		else if (instruction instanceof AS3Call) {
			visit((AS3Call) instruction);
		}
		else if (instruction instanceof AS3Callmethod) {
			visit((AS3Callmethod) instruction);
		}
		else if (instruction instanceof AS3Callproperty) {
			visit((AS3Callproperty) instruction);
		}
		else if (instruction instanceof AS3Callproplex) {
			visit((AS3Callproplex) instruction);
		}
		else if (instruction instanceof AS3Callpropvoid) {
			visit((AS3Callpropvoid) instruction);
		}
		else if (instruction instanceof AS3Callstatic) {
			visit((AS3Callstatic) instruction);
		}
		else if (instruction instanceof AS3Callsuper) {
			visit((AS3Callsuper) instruction);
		}
		else if (instruction instanceof AS3Callsupervoid) {
			visit((AS3Callsupervoid) instruction);
		}
		else if (instruction instanceof AS3Checkfilter) {
			visit((AS3Checkfilter) instruction);
		}
		else if (instruction instanceof AS3Coerce) {
			visit((AS3Coerce) instruction);
		}
		else if (instruction instanceof AS3Coercea) {
			visit((AS3Coercea) instruction);
		}
		else if (instruction instanceof AS3Coerces) {
			visit((AS3Coerces) instruction);
		}
		else if (instruction instanceof AS3Construct) {
			visit((AS3Construct) instruction);
		}
		else if (instruction instanceof AS3Constructprop) {
			visit((AS3Constructprop) instruction);
		}
		else if (instruction instanceof AS3Constructsuper) {
			visit((AS3Constructsuper) instruction);
		}
		else if (instruction instanceof AS3Convertb) {
			visit((AS3Convertb) instruction);
		}
		else if (instruction instanceof AS3Convertd) {
			visit((AS3Convertd) instruction);
		}
		else if (instruction instanceof AS3Converti) {
			visit((AS3Converti) instruction);
		}
		else if (instruction instanceof AS3Converto) {
			visit((AS3Converto) instruction);
		}
		else if (instruction instanceof AS3Converts) {
			visit((AS3Converts) instruction);
		}
		else if (instruction instanceof AS3Convertu) {
			visit((AS3Convertu) instruction);
		}
		else if (instruction instanceof AS3Debug) {
			visit((AS3Debug) instruction);
		}
		else if (instruction instanceof AS3Debugfile) {
			visit((AS3Debugfile) instruction);
		}
		else if (instruction instanceof AS3Debugline) {
			visit((AS3Debugline) instruction);
		}
		else if (instruction instanceof AS3Declocal) {
			visit((AS3Declocal) instruction);
		}
		else if (instruction instanceof AS3Declocali) {
			visit((AS3Declocali) instruction);
		}
		else if (instruction instanceof AS3Decrement) {
			visit((AS3Decrement) instruction);
		}
		else if (instruction instanceof AS3Decrementi) {
			visit((AS3Decrementi) instruction);
		}
		else if (instruction instanceof AS3Deleteproperty) {
			visit((AS3Deleteproperty) instruction);
		}
		else if (instruction instanceof AS3Divide) {
			visit((AS3Divide) instruction);
		}
		else if (instruction instanceof AS3Dup) {
			visit((AS3Dup) instruction);
		}
		else if (instruction instanceof AS3Dxns) {
			visit((AS3Dxns) instruction);
		}
		else if (instruction instanceof AS3Dxnslate) {
			visit((AS3Dxnslate) instruction);
		}
		else if (instruction instanceof AS3Equals) {
			visit((AS3Equals) instruction);
		}
		else if (instruction instanceof AS3Escxattr) {
			visit((AS3Escxattr) instruction);
		}
		else if (instruction instanceof AS3Escxelem) {
			visit((AS3Escxelem) instruction);
		}
		else if (instruction instanceof AS3Findproperty) {
			visit((AS3Findproperty) instruction);
		}
		else if (instruction instanceof AS3Findpropstrict) {
			visit((AS3Findpropstrict) instruction);
		}
		else if (instruction instanceof AS3Getdescendants) {
			visit((AS3Getdescendants) instruction);
		}
		else if (instruction instanceof AS3Getglobalscope) {
			visit((AS3Getglobalscope) instruction);
		}
		else if (instruction instanceof AS3Getglobalslot) {
			visit((AS3Getglobalslot) instruction);
		}
		else if (instruction instanceof AS3Getlex) {
			visit((AS3Getlex) instruction);
		}
		else if (instruction instanceof AS3Getlocal) {
			visit((AS3Getlocal) instruction);
		}
		else if (instruction instanceof AS3Getlocal0) {
			visit((AS3Getlocal0) instruction);
		}
		else if (instruction instanceof AS3Getlocal1) {
			visit((AS3Getlocal1) instruction);
		}
		else if (instruction instanceof AS3Getlocal2) {
			visit((AS3Getlocal2) instruction);
		}
		else if (instruction instanceof AS3Getlocal3) {
			visit((AS3Getlocal3) instruction);
		}
		else if (instruction instanceof AS3Getproperty) {
			visit((AS3Getproperty) instruction);
		}
		else if (instruction instanceof AS3Getscopeobject) {
			visit((AS3Getscopeobject) instruction);
		}
		else if (instruction instanceof AS3Getslot) {
			visit((AS3Getslot) instruction);
		}
		else if (instruction instanceof AS3Getsuper) {
			visit((AS3Getsuper) instruction);
		}
		else if (instruction instanceof AS3Greaterthan) {
			visit((AS3Greaterthan) instruction);
		}
		else if (instruction instanceof AS3Hasnext) {
			visit((AS3Hasnext) instruction);
		}
		else if (instruction instanceof AS3Hasnext2) {
			visit((AS3Hasnext2) instruction);
		}
		else if (instruction instanceof AS3Ifeq) {
			visit((AS3Ifeq) instruction);
		}
		else if (instruction instanceof AS3Iffalse) {
			visit((AS3Iffalse) instruction);
		}
		else if (instruction instanceof AS3Ifge) {
			visit((AS3Ifge) instruction);
		}
		else if (instruction instanceof AS3Ifgt) {
			visit((AS3Ifgt) instruction);
		}
		else if (instruction instanceof AS3Ifle) {
			visit((AS3Ifle) instruction);
		}
		else if (instruction instanceof AS3Iflt) {
			visit((AS3Iflt) instruction);
		}
		else if (instruction instanceof AS3Ifne) {
			visit((AS3Ifne) instruction);
		}
		else if (instruction instanceof AS3Ifnge) {
			visit((AS3Ifnge) instruction);
		}
		else if (instruction instanceof AS3Ifngt) {
			visit((AS3Ifngt) instruction);
		}
		else if (instruction instanceof AS3Ifnle) {
			visit((AS3Ifnle) instruction);
		}
		else if (instruction instanceof AS3Ifnlt) {
			visit((AS3Ifnlt) instruction);
		}
		else if (instruction instanceof AS3Ifstricteq) {
			visit((AS3Ifstricteq) instruction);
		}
		else if (instruction instanceof AS3Ifstrictne) {
			visit((AS3Ifstrictne) instruction);
		}
		else if (instruction instanceof AS3Iftrue) {
			visit((AS3Iftrue) instruction);
		}
		else if (instruction instanceof AS3In) {
			visit((AS3In) instruction);
		}
		else if (instruction instanceof AS3Increment) {
			visit((AS3Increment) instruction);
		}
		else if (instruction instanceof AS3Incrementi) {
			visit((AS3Incrementi) instruction);
		}
		else if (instruction instanceof AS3Initproperty) {
			visit((AS3Initproperty) instruction);
		}
		else if (instruction instanceof AS3Inlocal) {
			visit((AS3Inlocal) instruction);
		}
		else if (instruction instanceof AS3Inlocal) {
			visit((AS3Inlocali) instruction);
		}
		else if (instruction instanceof AS3Instanceof) {
			visit((AS3Instanceof) instruction);
		}
		else if (instruction instanceof AS3Istype) {
			visit((AS3Istype) instruction);
		}
		else if (instruction instanceof AS3Istypelate) {
			visit((AS3Istypelate) instruction);
		}
		else if (instruction instanceof AS3Jump) {
			visit((AS3Jump) instruction);
		}
		else if (instruction instanceof AS3Kill) {
			visit((AS3Kill) instruction);
		}
		else if (instruction instanceof AS3Label) {
			visit((AS3Label) instruction);
		}
		else if (instruction instanceof AS3Lessequals) {
			visit((AS3Lessequals) instruction);
		}
		else if (instruction instanceof AS3Lessthan) {
			visit((AS3Lessthan) instruction);
		}
		else if (instruction instanceof AS3Lookupswitch) {
			visit((AS3Lookupswitch) instruction);
		}
		else if (instruction instanceof AS3Lshift) {
			visit((AS3Lshift) instruction);
		}
		else if (instruction instanceof AS3Modulo) {
			visit((AS3Modulo) instruction);
		}
		else if (instruction instanceof AS3Multiply) {
			visit((AS3Multiply) instruction);
		}
		else if (instruction instanceof AS3Multiplyi) {
			visit((AS3Multiplyi) instruction);
		}
		else if (instruction instanceof AS3Negate) {
			visit((AS3Negate) instruction);
		}
		else if (instruction instanceof AS3Negatei) {
			visit((AS3Negatei) instruction);
		}
		else if (instruction instanceof AS3Newactivation) {
			visit((AS3Newactivation) instruction);
		}
		else if (instruction instanceof AS3Newarray) {
			visit((AS3Newarray) instruction);
		}
		else if (instruction instanceof AS3Newcatch) {
			visit((AS3Newcatch) instruction);
		}
		else if (instruction instanceof AS3Newclass) {
			visit((AS3Newclass) instruction);
		}
		else if (instruction instanceof AS3Newfunction) {
			visit((AS3Newfunction) instruction);
		}
		else if (instruction instanceof AS3Newobject) {
			visit((AS3Newobject) instruction);
		}
		else if (instruction instanceof AS3Nextname) {
			visit((AS3Nextname) instruction);
		}
		else if (instruction instanceof AS3Nextvalue) {
			visit((AS3Nextvalue) instruction);
		}
		else if (instruction instanceof AS3Nop) {
			visit((AS3Nop) instruction);
		}
		else if (instruction instanceof AS3Not) {
			visit((AS3Not) instruction);
		}
		else if (instruction instanceof AS3Pop) {
			visit((AS3Pop) instruction);
		}
		else if (instruction instanceof AS3Popscope) {
			visit((AS3Popscope) instruction);
		}
		else if (instruction instanceof AS3Pushbyte) {
			visit((AS3Pushbyte) instruction);
		}
		else if (instruction instanceof AS3Pushdouble) {
			visit((AS3Pushdouble) instruction);
		}
		else if (instruction instanceof AS3Pushfalse) {
			visit((AS3Pushfalse) instruction);
		}
		else if (instruction instanceof AS3Pushint) {
			visit((AS3Pushint) instruction);
		}
		else if (instruction instanceof AS3Pushnamespace) {
			visit((AS3Pushnamespace) instruction);
		}
		else if (instruction instanceof AS3Pushnan) {
			visit((AS3Pushnan) instruction);
		}
		else if (instruction instanceof AS3Pushnull) {
			visit((AS3Pushnull) instruction);
		}
		else if (instruction instanceof AS3Pushscope) {
			visit((AS3Pushscope) instruction);
		}
		else if (instruction instanceof AS3Pushshort) {
			visit((AS3Pushshort) instruction);
		}
		else if (instruction instanceof AS3Pushstring) {
			visit((AS3Pushstring) instruction);
		}
		else if (instruction instanceof AS3Pushtrue) {
			visit((AS3Pushtrue) instruction);
		}
		else if (instruction instanceof AS3Pushuint) {
			visit((AS3Pushuint) instruction);
		}
		else if (instruction instanceof AS3Pushundefined) {
			visit((AS3Pushundefined) instruction);
		}
		else if (instruction instanceof AS3Pushwith) {
			visit((AS3Pushwith) instruction);
		}
		else if (instruction instanceof AS3Returnvalue) {
			visit((AS3Returnvalue) instruction);
		}
		else if (instruction instanceof AS3Returnvoid) {
			visit((AS3Returnvoid) instruction);
		}
		else if (instruction instanceof AS3Rshift) {
			visit((AS3Rshift) instruction);
		}
		else if (instruction instanceof AS3Setglobalslot) {
			visit((AS3Setglobalslot) instruction);
		}
		else if (instruction instanceof AS3Setlocal) {
			visit((AS3Setlocal) instruction);
		}
		else if (instruction instanceof AS3Setlocal0) {
			visit((AS3Setlocal0) instruction);
		}
		else if (instruction instanceof AS3Setlocal1) {
			visit((AS3Setlocal1) instruction);
		}
		else if (instruction instanceof AS3Setlocal2) {
			visit((AS3Setlocal2) instruction);
		}
		else if (instruction instanceof AS3Setlocal3) {
			visit((AS3Setlocal3) instruction);
		}
		else if (instruction instanceof AS3Setproperty) {
			visit((AS3Setproperty) instruction);
		}
		else if (instruction instanceof AS3Setslot) {
			visit((AS3Setslot) instruction);
		}
		else if (instruction instanceof AS3Setsuper) {
			visit((AS3Setsuper) instruction);
		}
		else if (instruction instanceof AS3Strictequals) {
			visit((AS3Strictequals) instruction);
		}
		else if (instruction instanceof AS3Subtract) {
			visit((AS3Subtract) instruction);
		}
		else if (instruction instanceof AS3Subtracti) {
			visit((AS3Subtracti) instruction);
		}
		else if (instruction instanceof AS3Swap) {
			visit((AS3Swap) instruction);
		}
		else if (instruction instanceof AS3Throw) {
			visit((AS3Throw) instruction);
		}
		else if (instruction instanceof AS3Typeof) {
			visit((AS3Typeof) instruction);
		}
		else if (instruction instanceof AS3UnknownInstruction) {
			visit((AS3UnknownInstruction) instruction);
		}
		else if (instruction instanceof AS3Urshift) {
			visit((AS3Urshift) instruction);
		}
	}
}
