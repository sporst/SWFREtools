package tv.porst.swfretools.dissector.gui.main.panels;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import tv.porst.splib.gui.GuiHelpers;
import tv.porst.swfretools.parser.structures.ActionList;

public class AS2CodePanel extends JPanel {

	public AS2CodePanel(final ActionList code) {
		super(new BorderLayout());

		final JTextArea area = new JTextArea(AS2CodePrinter.getCodeText(code));
		area.setEditable(false);
		area.setFont(new Font(GuiHelpers.getMonospaceFont(), 0, 12));

		add(new JScrollPane(area));
	}
}
