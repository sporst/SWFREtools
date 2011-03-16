package tv.porst.swfretools.dissector.gui.main.hexview;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import tv.porst.jhexview.JHexView;
import tv.porst.jhexview.JHexView.DefinitionStatus;
import tv.porst.jhexview.SimpleDataProvider;
import tv.porst.swfretools.dissector.gui.main.models.LoadedFile;

public class FlashHexView extends JPanel {

	private final JHexView hexView;

	private LoadedFile loadedFile = null;

	public FlashHexView() {
		super(new BorderLayout());

		hexView = new JHexView();

		add(hexView);
	}

	public JHexView getHexView() {
		return hexView;
	}

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
