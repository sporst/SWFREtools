SWFRETools - A collection of tools for reverse engineering Flash files
======================================================================

Overview
--------

The SWFRETools are a collection of tools built for vulnerability analysis
of the Adobe Flash player and for malware analysis of malicious SWF files.
The tools are partly written in Java and partly in Python and are licensed
under the GPL 2.0 license.

The following tools are part of the SWFRETools:

* Flash Dissector: Binary viewer for SWF files
* SWF Parser: Build your own tools using this parser
* Minimizer: Automatically minimize crashing SWF files
* FP Debugger: Trace the Flash Player dynamically
* StatsGenerator: Generate stats over SWF files

### Flash Dissector

Flash Dissector is a GUI tool that allows you to inspect SWF files on a binary
level. When you open a SWF file in Flash Dissector you have the ability to
look through the structures defined in the SWF file in a hex editor and in a 
structure viewer. This makes it easy to understand what bytes of a SWF file
hold what functionality.

For more information about using Flash Dissector, please check out the readme
file in the Flash Dissector directory.

### SWF Parser

The SWF Parser is an open-source SWF file parser implemented in Java that you
can build upon when you want to create your own Flash reverse engineering
tools.

For more information about using SWF Parser, please check out the readme
file in the SWF Parser directory.

### Minimizer

The Minimizer program takes a SWF input that makes Flash Player crash and
automatically removes the parts of the SWF file that are not related to the
crash. This makes it easier to determine what the root cause of a crash is.

For more information about using Minimizer, please check out the readme
file in the Minimizer directory.

### FP Debugger

This Flash Player hooking script hooks important functionality in Flash Player
at runtime and dumps information about what Flash Player is parsing and
executing. This is very useful in situations where Flash Player trips up and
static analysis are out of sync with what Flash Player is doing.

For more information about using FP Debugger, please check out the readme
file in the FP Debugger directory.

### StatsGenerator

The StatsGenerator program can create statistics from an input set of SWF
files.

For more information about using StatsGenerator, please check out the readme
file in the StatsGenerator directory.

Contributors
------------

[Sebastian Porst](http://github.com/sporst) (sp@porst.tv)

External Software
-----------------

The SWFRETools use the following external components and libraries.

The [Java FileDrop](http://www.iharder.net/current/java/filedrop/) component (Public Domain) to allow users to open Flash
files via Drag & Drop.