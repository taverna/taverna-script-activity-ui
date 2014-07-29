package net.sf.taverna.t2.activities.script.menu;

import net.sf.taverna.t2.workbench.activitytools.AbstractConfigureActivityMenuAction;
import net.sf.taverna.t2.workflowmodel.processor.activity.Activity;

import javax.swing.Action;

import net.sf.taverna.t2.activities.script.ScriptActivity;
import net.sf.taverna.t2.activities.script.actions.ScriptActivityConfigurationAction;

public class ConfigureScriptMenuAction extends
		AbstractConfigureActivityMenuAction<ScriptActivity> {

	public ConfigureScriptMenuAction() {
		super(ScriptActivity.class);
	}
	
	@Override
	protected Action createAction() {
		Activity a = findActivity();
		Action result = null;
			result = new ScriptActivityConfigurationAction(
					findActivity(), getParentFrame());
			result.putValue(Action.NAME, ScriptActivityConfigurationAction.EDIT_SCRIPT);
			addMenuDots(result);
		return result;
	}


}
