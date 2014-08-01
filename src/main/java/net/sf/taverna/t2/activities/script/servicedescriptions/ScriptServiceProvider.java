package net.sf.taverna.t2.activities.script.servicedescriptions;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;

import net.sf.taverna.t2.activities.script.ScriptEngineUtils;
import net.sf.taverna.t2.lang.beans.PropertyAnnotation;
import net.sf.taverna.t2.servicedescriptions.ServiceDescriptionProvider;

public class ScriptServiceProvider implements ServiceDescriptionProvider {
	
	private static final URI providerId = URI
	.create("http://taverna.sf.net/2010/service-provider/script");

	@Override
	public void findServiceDescriptionsAsync(
			FindServiceDescriptionsCallBack callBack) {
		final List<ScriptServiceDesc> result = new ArrayList<ScriptServiceDesc>();
		
		for (String engineName : ScriptEngineUtils.getApplicableFactoryNames()) {
			ScriptServiceDesc newDesc = new ScriptServiceDesc();
			newDesc.setEngineName(engineName);
			result.add(newDesc);
		}
		
		callBack.partialResults(result);
		callBack.finished();
	}

	@Override
	public String getName() {
		return "Script";
	}

	@Override
	@PropertyAnnotation(expert = true)
	public Icon getIcon() {
		return ScriptActivityIcon.getScriptIcon();
	}

	@Override
	public String getId() {
		return providerId.toASCIIString();
	}

}
