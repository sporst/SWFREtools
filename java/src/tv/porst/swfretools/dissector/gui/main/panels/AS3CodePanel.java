package tv.porst.swfretools.dissector.gui.main.panels;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import tv.porst.splib.gui.GuiHelpers;
import tv.porst.swfretools.parser.structures.AS3Code;
import tv.porst.swfretools.parser.tags.DoABCTag;

public class AS3CodePanel extends JPanel {

	public AS3CodePanel(final AS3Code code) {
		super(new BorderLayout());

		final JTextArea area = new JTextArea(AS3CodePrinter.getCodeText(code));
		area.setEditable(false);
		area.setFont(new Font(GuiHelpers.getMonospaceFont(), 0, 12));

		add(new JScrollPane(area));
	}

	public AS3CodePanel(final DoABCTag tag) {
		super(new BorderLayout());

		final JTextArea area = new JTextArea(AS3CodePrinter.getCodeText(tag));
		area.setEditable(false);
		area.setFont(new Font(GuiHelpers.getMonospaceFont(), 0, 12));

		add(new JScrollPane(area));
	}

}
