/**
 * 
 */
package net.sf.taverna.t2.activities.script.generator;

import net.sf.taverna.t2.activities.script.ScriptActivityConfigurationBean;

/**
 * @author alanrw
 *
 */
public class JsonTemplateGenerator extends ScriptGenerator {

	/* (non-Javadoc)
	 * @see net.sf.taverna.t2.activities.script.generator.ScriptGenerator#canGenerateFrom(net.sf.taverna.t2.activities.script.ScriptActivityConfigurationBean)
	 */
	@Override
	public boolean canGenerateFrom(ScriptActivityConfigurationBean bean) {
		return bean.getEngineName().equals("velocity");
	}

	/* (non-Javadoc)
	 * @see net.sf.taverna.t2.activities.script.generator.ScriptGenerator#generateFrom(net.sf.taverna.t2.activities.script.ScriptActivityConfigurationBean)
	 */
	@Override
	public String generateFrom(ScriptActivityConfigurationBean bean) {
		return "Hello Mister Snoop";
	}

	/* (non-Javadoc)
	 * @see net.sf.taverna.t2.activities.script.generator.ScriptGenerator#getName()
	 */
	@Override
	public String getName() {
		return "JSON";
	}

}
