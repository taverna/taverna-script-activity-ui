/**
 * 
 */
package net.sf.taverna.t2.activities.script.servicedescriptions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.Icon;

import net.sf.taverna.t2.activities.script.ScriptActivity;
import net.sf.taverna.t2.activities.script.ScriptActivityConfigurationBean;
import net.sf.taverna.t2.lang.beans.PropertyAnnotation;
import net.sf.taverna.t2.servicedescriptions.ServiceDescription;
import net.sf.taverna.t2.workflowmodel.processor.activity.Activity;

/**
 * @author alanrw
 *
 */
public class ScriptServiceDesc extends ServiceDescription<ScriptActivityConfigurationBean> {
	
	private String engineName;

	@Override
	@PropertyAnnotation(expert = true, displayName = "Service implementation class")
	public Class<? extends Activity<ScriptActivityConfigurationBean>> getActivityClass() {
		return ScriptActivity.class;
	}

	@Override
	@PropertyAnnotation(expert = true, displayName = "Service configuration")
	public ScriptActivityConfigurationBean getActivityConfiguration() {
		ScriptActivityConfigurationBean bean = new ScriptActivityConfigurationBean();
		bean.setEngineName(this.getEngineName());
		return bean;
	}

	@Override
	@PropertyAnnotation(expert = true)
	public Icon getIcon() {
		return ScriptActivityIcon.getScriptIcon();
	}

	@Override
	@PropertyAnnotation(displayName = "Name")
	public String getName() {
		if (getEngineName() == null) {
			return "Script";
		}
		return getEngineName();
	}

	@Override
	@PropertyAnnotation(expert = true)
	public List<? extends Comparable> getPath() {
		return Arrays.asList("Script");
	}

	@Override
	protected List<? extends Object> getIdentifyingData() {
		return Collections.singletonList(this.getEngineName());
	}
	
	public boolean isTemplateService() {
		return true;
	}

	/**
	 * @return the engineName
	 */
	public String getEngineName() {
		return engineName;
	}

	/**
	 * @param engineName the engineName to set
	 */
	public void setEngineName(String engineName) {
		this.engineName = engineName;
	}


}
