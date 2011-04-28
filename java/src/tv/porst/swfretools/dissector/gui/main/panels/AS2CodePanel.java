package tv.porst.swfretools.dissector.gui.main.panels;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import tv.porst.splib.gui.GuiHelpers;
import tv.porst.swfretools.parser.structures.ActionList;

/**
 * Panel to display ActionScript 2 code.
 */
public final class AS2CodePanel extends JPanel implements IExtraPanel {

	/**
	 * Creates a new panel object.
	 * 
	 * @param code The code to display in the panel.
	 */
	public AS2CodePanel(final ActionList code) {
		super(new BorderLayout());

		final JTextArea area = new JTextArea(AS2CodePrinter.getCodeText(code));
		area.setEditable(false);
		area.setFont(new Font(GuiHelpers.getMonospaceFont(), 0, 12));

		add(new JScrollPane(area));
	}

	@Override
	public JPanel getPanel() {
		return this;
	}

	@Override
	public String getTabName() {
		return "Code";
	}
}
