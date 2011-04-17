package tv.porst.swfretools.dissector.gui.main;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import tv.porst.swfretools.dissector.gui.main.hexview.FlashHexView;

/**
 * The DetailPanel is the panel that is shown on the right-hand side of the
 * main window. It contains the hex view and additional panels if certain
 * nodes in the Flash tree are selected.
 */
public final class DetailPanel extends JPanel {

	/**
	 * The hex view where selected Flash structures are highlighted.
	 */
	private final FlashHexView hexView = new FlashHexView();

	/**
	 * Tabbed pane that contains the hex view and optional additional panels.
	 */
	private final JTabbedPane tabbedPane = new JTabbedPane();

	/**
	 * Creates a new DetailPanel object.
	 */
	public DetailPanel() {
		super(new BorderLayout());

		tabbedPane.addTab("Hex", hexView);

		add(tabbedPane, BorderLayout.CENTER);
	}

	/**
	 * Adds an additional panel to the tabbed pane of the detail panel.
	 * 
	 * @param title Title of the new tab.
	 * @param panel Panel shown in the new tab.
	 */
	public void addPanel(final String title, final JPanel panel) {

		if (title == null) {
			throw new IllegalArgumentException("Title argument must not be null.");
		}

		if (panel == null) {
			throw new IllegalArgumentException("Panel argument must not be null.");
		}

		tabbedPane.addTab(title, panel);

		updateUI();
	}

	/**
	 * Returns the hex view shown in the detail panel.
	 * 
	 * @return The hex view shown in the detail panel.
	 */
	public FlashHexView getHexView() {
		return hexView;
	}

	/**
	 * Removes all optional panels from the tabbed pane.
	 */
	public void removeAllOptionalPanels() {
		while (tabbedPane.getTabCount() > 1) {
			tabbedPane.removeTabAt(1);
		}
	}
}