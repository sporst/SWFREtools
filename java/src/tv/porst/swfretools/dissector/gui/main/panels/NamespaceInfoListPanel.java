package tv.porst.swfretools.dissector.gui.main.panels;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import tv.porst.swfretools.parser.structures.NamespaceInfoList;
import tv.porst.swfretools.parser.structures.StringInfoList;

/**
 * Panel class for displaying the strings of a namespace info list in the GUI.
 */
public final class NamespaceInfoListPanel extends JPanel implements IExtraPanel {

	/**
	 * Creates a new panel object.
	 * 
	 * @param namespaceInfoList The namespaces to display in the GUI.\
	 * @param constantPool Constant pool used to look up namespace names.
	 */
	public NamespaceInfoListPanel(final NamespaceInfoList namespaceInfoList, final StringInfoList constantPool) {
		super(new BorderLayout());

		if (namespaceInfoList == null) {
			throw new IllegalArgumentException("NamespaceInfoList argument must not be null.");
		}

		add(new JScrollPane(new JTable(new NamespaceInfoListModel(namespaceInfoList, constantPool))));
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
	private static class NamespaceInfoListModel extends AbstractTableModel {

		/**
		 * Names of the table columns.
		 */
		private static final String[] COLUMN_NAMES = { "Index", "Namespace" };

		/**
		 * Provides the namespaces to display in the table.
		 */
		private final NamespaceInfoList namespaceInfoList;

		/**
		 * Constant pool used to look up namespace names.
		 */
		private final StringInfoList constantPool;

		/**
		 * Creates a new table model object.
		 * 
		 * @param namespaceInfoList Provides the strings to display in the table.
		 * @param constantPool Constant pool used to look up namespace names.
		 */
		private NamespaceInfoListModel(final NamespaceInfoList namespaceInfoList, final StringInfoList constantPool) {
			this.namespaceInfoList = namespaceInfoList;
			this.constantPool = constantPool;
		}

		/**
		 * Tries to resolve the string representation of a namespace.
		 * 
		 * @param stringIndex Index of the namespace string.
		 * 
		 * @return The resolved string representation or the string "???".
		 */
		private String lookupString(final int stringIndex) {
			if (stringIndex >= constantPool.size() + 1) {
				return "???";
			}
			else {
				return constantPool.get(stringIndex + 1).getName().value();
			}
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
			return namespaceInfoList.size();
		}

		@Override
		public Object getValueAt(final int row, final int col) {
			switch (col) {
			case 0: return row;
			case 1: return lookupString(namespaceInfoList.get(row).getName().value());
			default: throw new IllegalStateException("Unknown column");
			}
		}
	}
}