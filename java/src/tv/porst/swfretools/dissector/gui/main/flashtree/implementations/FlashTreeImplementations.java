package tv.porst.swfretools.dissector.gui.main.flashtree.implementations;

import java.awt.Window;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;

import tv.porst.splib.arrays.ArrayHelpers;
import tv.porst.splib.binaryparser.IFileElement;
import tv.porst.splib.file.FileHelpers;
import tv.porst.swfretools.dissector.gui.main.MessageBox;
import tv.porst.swfretools.dissector.gui.main.implementations.FileActions.BinFileFilter;
import tv.porst.swfretools.dissector.gui.main.implementations.FileActions.SWFFileFilter;
import tv.porst.swfretools.dissector.gui.main.models.LoadedFile;

/**
 * Contains the implementations of actions available in the Flash tree.
 */
public final class FlashTreeImplementations {

	/**
	 * Dumps the decompressed data of a SWF file to a file.
	 * 
	 * @param parent Parent window used for dialogs.
	 * @param loadedFile The loaded file whose decompressed data is dumped to disk.
	 */
	public static void dumpDecompressedFile(final Window parent, final LoadedFile loadedFile) {

		if (parent == null) {
			throw new IllegalArgumentException("Parent argument must not be null.");
		}

		if (loadedFile == null) {
			throw new IllegalArgumentException("Loaded file argument must not be null.");
		}

		final JFileChooser fc = new JFileChooser();
		fc.setFileFilter(new SWFFileFilter());

		final File parentFile = loadedFile.getFile().getParentFile();

		if (parent != null) {
			fc.setCurrentDirectory(parentFile);
		}

		if (JFileChooser.APPROVE_OPTION == fc.showSaveDialog(parent)) {
			final File outputFile = fc.getSelectedFile();

			try {
				FileHelpers.writeFile(outputFile, loadedFile.getSWFFile().getDecompressedData());
			} catch (final IOException e) {
				MessageBox.showError(parent, "File could not be saved");
			}
		}
	}

	/**
	 * Dumps the binary representation of a SWF file element to disk.
	 * 
	 * @param parent Parent window used for dialogs.
	 * @param loadedFile The SWF file the element belongs to.
	 * @param element The element that is dumped to disk.
	 */
	public static void dumpElement(final Window parent, final LoadedFile loadedFile, final IFileElement element) {

		if (parent == null) {
			throw new IllegalArgumentException("Parent argument must not be null.");
		}

		if (element == null) {
			throw new IllegalArgumentException("Element argument must not be null.");
		}

		final JFileChooser fc = new JFileChooser();
		fc.setFileFilter(new BinFileFilter());

		final File parentFile = loadedFile.getFile().getParentFile();

		if (parent != null) {
			fc.setCurrentDirectory(parentFile);
		}

		if (JFileChooser.APPROVE_OPTION == fc.showSaveDialog(parent)) {
			final File outputFile = fc.getSelectedFile();

			try {

				final byte[] data = loadedFile.getSWFFile().getDecompressedData();

				final byte[] elementData = ArrayHelpers.getSubArray(data, element.getBitPosition() / 8, element.getBitLength() / 8);

				FileHelpers.writeFile(outputFile, elementData);
			} catch (final IOException e) {
				MessageBox.showError(parent, "Element could not be saved");
			}
		}
	}
}