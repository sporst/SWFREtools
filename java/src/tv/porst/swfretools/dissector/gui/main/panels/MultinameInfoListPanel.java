package tv.porst.swfretools.dissector.gui.main.panels;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import tv.porst.swfretools.parser.structures.MultinameInfo;
import tv.porst.swfretools.parser.structures.MultinameInfoList;
import tv.porst.swfretools.parser.structures.NamespaceInfoList;
import tv.porst.swfretools.parser.structures.StringInfoList;
import tv.porst.swfretools.utils.ActionScript3Helpers;
import tv.porst.swfretools.utils.ResolverException;

/**
 * Panel class for displaying the multinames info list in the GUI.
 */
public final class MultinameInfoListPanel extends JPanel implements IExtraPanel {

	/**
	 * Creates a new panel object.
	 * 
	 * @param multinameInfoList The multinames to display in the GUI.
	 * @param constantPool Constant pool used to look up names.
	 * @param namespaceList Provides namespace information.
	 */
	public MultinameInfoListPanel(final MultinameInfoList multinameInfoList, final StringInfoList constantPool, final NamespaceInfoList namespaceList) {
		super(new BorderLayout());

		if (multinameInfoList == null) {
			throw new IllegalArgumentException("MultinameInfoList argument must not be null.");
		}

		add(new JScrollPane(new JTable(new MultinameInfoListModel(multinameInfoList, constantPool, namespaceList))));
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
	private static class MultinameInfoListModel extends AbstractTableModel {

		/**
		 * Names of the table columns.
		 */
		private static final String[] COLUMN_NAMES = { "Index", "Namespace" };

		/**
		 * Provides the namespaces to display in the table.
		 */
		private final MultinameInfoList multinameInfoList;

		/**
		 * Constant pool used to look up names.
		 */
		private final StringInfoList constantPool;

		/**
		 * Provides namespace information.
		 */
		private final NamespaceInfoList namespaceList;

		/**
		 * Creates a new table model object.
		 * 
		 * @param multinameInfoList Provides the multinames to display in the table.
		 * @param constantPool Constant pool used to look up names.
		 * @param namespaceList Provides namespace information.
		 */
		private MultinameInfoListModel(final MultinameInfoList multinameInfoList, final StringInfoList constantPool, final NamespaceInfoList namespaceList) {
			this.multinameInfoList = multinameInfoList;
			this.constantPool = constantPool;
			this.namespaceList = namespaceList;
		}

		/**
		 * Tries to resolve the string representation of a multiname object.
		 * 
		 * @param multinameInfo The multiname object.
		 * 
		 * @return The name representation of the multiname object or "???".
		 */
		private String lookupString(final MultinameInfo multinameInfo) {
			try {
				final String[] namespaceParts = ActionScript3Helpers.resolveMultiname(multinameInfo, constantPool, namespaceList);

				return ActionScript3Helpers.flattenNamespaceName(namespaceParts);
			} catch (final ResolverException e) {
				return "???";
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
			return multinameInfoList.size();
		}

		@Override
		public Object getValueAt(final int row, final int col) {
			switch (col) {
			case 0: return row;
			case 1: return lookupString(multinameInfoList.get(row));
			default: throw new IllegalStateException("Unknown column");
			}
		}
	}
}