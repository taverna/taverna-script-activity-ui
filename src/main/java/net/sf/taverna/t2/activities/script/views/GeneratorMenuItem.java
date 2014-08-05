package net.sf.taverna.t2.activities.script.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.text.JTextComponent;

import net.sf.taverna.t2.activities.script.ScriptActivityConfigurationBean;
import net.sf.taverna.t2.activities.script.generator.ScriptGenerator;

public class GeneratorMenuItem extends JMenuItem {
	
	public GeneratorMenuItem(final ScriptGenerator sg, final ScriptActivityConfigurationBean bean, final JTextComponent scriptArea) {
		super(sg.getName(), sg.getIcon());
		
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				scriptArea.setText(sg.generateFrom(bean));
				scriptArea.setCaretPosition(0);
			}});
	}

}
