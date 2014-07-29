package net.sf.taverna.t2.activities.script.servicedescriptions;

import java.net.URI;

import javax.swing.Icon;

import net.sf.taverna.t2.activities.script.ScriptActivity;
import net.sf.taverna.t2.activities.script.ScriptActivityConfigurationBean;
import net.sf.taverna.t2.servicedescriptions.AbstractTemplateService;
import net.sf.taverna.t2.servicedescriptions.ServiceDescription;

public class ScriptTemplateService extends
		AbstractTemplateService<ScriptActivityConfigurationBean> {

	private static final String SCRIPT = "Script";
	
	private static final URI providerId = URI
	.create("http://taverna.sf.net/2010/service-provider/script");

	public String getName() {
		return SCRIPT;
	}

	@Override
	public Class<ScriptActivity> getActivityClass() {
		return ScriptActivity.class;
	}

	@Override
	public ScriptActivityConfigurationBean getActivityConfiguration() {
		return new ScriptActivityConfigurationBean();
	}

	@Override
	public Icon getIcon() {
		return ScriptActivityIcon.getScriptIcon();
	}
	
	@Override
	public String getDescription() {
		return "A service that allows scripts, with dependencies on libraries";	
	}
	
	@SuppressWarnings("unchecked")
	public static ServiceDescription getServiceDescription() {
		ScriptTemplateService bts = new ScriptTemplateService();
		return bts.templateService;
	}

	public String getId() {
		return providerId.toString();
	}
}
