package tv.porst.swfretools.dissector.gui.main.hexview;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import tv.porst.jhexview.JHexView;
import tv.porst.jhexview.JHexView.DefinitionStatus;
import tv.porst.jhexview.SimpleDataProvider;
import tv.porst.swfretools.dissector.gui.main.models.LoadedFile;

/**
 * Panel that contains the hex view component where Flash structures
 * are highlighted.
 */
public final class FlashHexView extends JPanel {

	/**
	 * Shows the selected Flash structure.
	 */
	private final JHexView hexView;

	/**
	 * The file shown in the hex view.
	 */
	private LoadedFile loadedFile = null;

	/**
	 * Creates a new hex view object.
	 */
	public FlashHexView() {
		super(new BorderLayout());

		hexView = new JHexView();

		add(hexView);
	}

	/**
	 * Returns the hex view component.
	 * 
	 * @return The hex view component.
	 */
	public JHexView getHexView() {
		return hexView;
	}

	/**
	 * Sets the file shown in the hex view.
	 * 
	 * @param file The new file shown in the hex view.
	 */
	public void setFile(final LoadedFile file) {

		if (file == loadedFile) {
			return;
		}

		hexView.setData(new SimpleDataProvider(file.getSWFFile().getDecompressedData()));

		if (loadedFile == null) {
			hexView.setDefinitionStatus(DefinitionStatus.DEFINED);
			hexView.setEnabled(true);
		}

		loadedFile = file;
	}
}