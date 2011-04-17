package tv.porst.swfretools.stats;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import tv.porst.splib.file.DirectoryTraverser;
import tv.porst.splib.file.IDirectoryTraversalVisitor;
import tv.porst.splib.maps.MapHelpers;
import tv.porst.swfretools.parser.SWFParser;
import tv.porst.swfretools.parser.SWFParserException;
import tv.porst.swfretools.parser.structures.SWFFile;
import tv.porst.swfretools.parser.tags.Tag;
import tv.porst.swfretools.utils.TagNames;

/**
 * This program can be used to generate statistics across a number of SWF files.
 */
public final class StatsGenerator {

	/**
	 * Generates statistics for all SWF files in the given directory.
	 * 
	 * @param directory The directory for which statistics are generated.
	 * 
	 * @return The generated statistics.
	 */
	private static StatsResult generateStats(final File directory) {

		final Map<Integer, Integer> tagCounts = new TreeMap<Integer, Integer>();

		DirectoryTraverser.traverse(directory, new IDirectoryTraversalVisitor() {

			@Override
			public void visit(final File file) {

				if (!file.getAbsolutePath().endsWith("swf")) {
					return;
				}

				System.out.println("Parsing " + file.getAbsolutePath());

				try {
					final SWFFile parsedFile = SWFParser.parse(file);

					for (final Tag tag : parsedFile.getTags()) {

						final int tagCode = tag.getHeader().getTagCode();

						if (!tagCounts.containsKey(tagCode)) {
							tagCounts.put(tagCode, 1);
						}
						else {
							tagCounts.put(tagCode, tagCounts.get(tagCode) + 1);
						}
					}

				} catch (final IOException e) {
					System.out.printf("Error: Can not open file %s\n", file.getAbsolutePath());
				} catch (final SWFParserException e) {
					System.out.printf("Error: Can not parse file %s\n", file.getAbsolutePath());
				}
			}
		});

		return new StatsResult(tagCounts);
	}

	/**
	 * Prints generated SWF file statistics.
	 * 
	 * @param stats The statistics to print.
	 */
	private static void printStats(final StatsResult stats) {

		final Map<Integer, Integer> sortedMap = MapHelpers.sortByValue(stats.getTagCounts());

		for (final Map.Entry<Integer, Integer> element : sortedMap.entrySet()) {
			System.out.println(TagNames.getPrintableTagName(element.getKey()) + ": " + element.getValue());
		}
	}

	/**
	 * The stats generator program takes a directory as its command line
	 * argument and prints statistics for all SWF files in that directory
	 * to stdout.
	 * 
	 * @param args The command line arguments passed to the stats generator.
	 */
	public static void main(final String[] args) {

		if (args.length != 1) {
			System.out.println("usage: StatsGenerator path");
			return;
		}

		final File statsDirectory = new File(args[0]);

		if (!statsDirectory.isDirectory()) {
			System.out.println("Error: The given path is not a valid directory.");
			return;
		}

		printStats(generateStats(statsDirectory));
	}
}