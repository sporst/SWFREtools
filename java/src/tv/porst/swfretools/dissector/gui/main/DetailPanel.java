package tv.porst.swfretools.dissector.gui.main;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import tv.porst.swfretools.dissector.gui.main.hexview.FlashHexView;

public class DetailPanel extends JPanel {

	private final FlashHexView hexView = new FlashHexView();;

	private final JTabbedPane tabbedPane = new JTabbedPane();

	public DetailPanel() {
		super(new BorderLayout());

		tabbedPane.addTab("Hex", hexView);

		add(tabbedPane, BorderLayout.CENTER);
	}

	public void addPanel(final String title, final JPanel panel) {
		tabbedPane.addTab(title, panel);

		updateUI();
	}

	public void clear() {
		while (tabbedPane.getTabCount() > 1) {
			tabbedPane.removeTabAt(1);
		}
	}

	public FlashHexView getHexView() {
		return hexView;
	}
}
