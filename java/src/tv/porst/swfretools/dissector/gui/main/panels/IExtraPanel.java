package tv.porst.swfretools.dissector.gui.main.panels;

import javax.swing.JPanel;

/**
 * Interface to be implemented by classes that want to be displayed next
 * to the hex views in the main window.
 */
public interface IExtraPanel {

	/**
	 * Returns itself as a panel object.
	 * 
	 * @return Itself.
	 */
	public JPanel getPanel();

	/**
	 * String to be shown in the tabbed pane tab where the panel is shown.
	 * 
	 * @return Tab panel header string.
	 */
	public String getTabName();
}
