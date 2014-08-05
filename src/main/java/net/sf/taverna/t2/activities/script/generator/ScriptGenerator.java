/**
 * 
 */
package net.sf.taverna.t2.activities.script.generator;

import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.JMenuItem;

import net.sf.taverna.t2.activities.script.ScriptActivityConfigurationBean;
import net.sf.taverna.t2.spi.SPIRegistry;

/**
 * @author alanrw
 *
 */
public abstract class ScriptGenerator {
	
	
	private static final SPIRegistry<ScriptGenerator> generatorRegistry = new SPIRegistry<ScriptGenerator>(ScriptGenerator.class);
	
	public abstract boolean canGenerateFrom(ScriptActivityConfigurationBean bean);
	
	public abstract String generateFrom(ScriptActivityConfigurationBean bean);
	
	public static List<ScriptGenerator> getGeneratorsFor(ScriptActivityConfigurationBean bean) {
		List<ScriptGenerator> result = new ArrayList<ScriptGenerator>();
		for (ScriptGenerator sg : generatorRegistry.getInstances()) {
			if (sg.canGenerateFrom(bean)) {
				result.add(sg);
			}
		}
		return result;
	}

	public abstract String getName();
	
	public Icon getIcon() {
		return null;
	}

}
