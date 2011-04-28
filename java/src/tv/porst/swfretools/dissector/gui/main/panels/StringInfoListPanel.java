package tv.porst.swfretools.dissector.gui.main.panels;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import tv.porst.swfretools.parser.structures.StringInfoList;

/**
 * Panel class for displaying the strings of a list in the GUI.
 */
public final class StringInfoListPanel extends JPanel implements IExtraPanel {

	/**
	 * Creates a new panel object.
	 * 
	 * @param stringInfoList The strings to display in the GUI.
	 */
	public StringInfoListPanel(final StringInfoList stringInfoList) {
		super(new BorderLayout());

		if (stringInfoList == null) {
			throw new IllegalArgumentException("StringInfoList argument must not be null.");
		}

		add(new JScrollPane(new JTable(new StringInfoListModel(stringInfoList))));
	}

	@Override
	public JPanel getPanel() {
		return this;
	}

	@Override
	public String getTabName() {
		return "Strings";
	}

	/**
	 * Table model for the table that displays the strings.
	 */
	private static class StringInfoListModel extends AbstractTableModel {

		/**
		 * Names of the table columns.
		 */
		private static final String[] COLUMN_NAMES = { "Index", "Value" };

		/**
		 * Provides the strings to display in the table.
		 */
		private final StringInfoList stringInfoList;

		/**
		 * Creates a new table model object.
		 * 
		 * @param stringInfoList Provides the strings to display in the table.
		 */
		private StringInfoListModel(final StringInfoList stringInfoList) {
			this.stringInfoList = stringInfoList;
		}

		@Override
		public int getColumnCount() {
			return COLUMN_NAMES.length;
		}

		@Override
		public String getColumnName(final int index) {
			return COLUMN_NAMES[index];
		}

		@Override
		public int getRowCount() {
			return stringInfoList.size();
		}

		@Override
		public Object getValueAt(final int row, final int col) {
			switch (col) {
			case 0: return row;
			case 1: return stringInfoList.get(row).getName().value();
			default: throw new IllegalStateException("Unknown column");
			}
		}
	}
}