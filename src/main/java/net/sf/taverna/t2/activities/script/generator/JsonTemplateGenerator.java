/**
 * 
 */
package net.sf.taverna.t2.activities.script.generator;

import java.util.List;

import net.sf.taverna.t2.activities.script.ScriptActivityConfigurationBean;
import net.sf.taverna.t2.workflowmodel.processor.activity.config.ActivityInputPortDefinitionBean;

/**
 * @author alanrw
 *
 */
public class JsonTemplateGenerator extends ScriptGenerator {
	
	private static final String lineSeparator = System.getProperty("line.separator");

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
		
		final StringBuffer sb = new StringBuffer();
		
		List<ActivityInputPortDefinitionBean> inputPorts = bean.getInputPortDefinitions();
		
		sb.append("## Auto-generated template");
		sb.append(lineSeparator);
		sb.append("{");
		
			String separator = "";
			for (final ActivityInputPortDefinitionBean port : inputPorts) {
				String portName = port.getName();
				sb.append(separator);
				separator = ",";
				
				sb.append(String.format("%s    \"", lineSeparator));

				sb.append(portName);
				sb.append("\": $");
				sb.append(portName);
			}
		sb.append(String.format("%s}", lineSeparator));
		
		return sb.toString();
	}

	/* (non-Javadoc)
	 * @see net.sf.taverna.t2.activities.script.generator.ScriptGenerator#getName()
	 */
	@Override
	public String getName() {
		return "JSON";
	}

}
