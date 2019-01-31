package ltrc.CustomIdentityService.bpm.engine.idservice;

import java.util.List;

import org.camunda.bpm.engine.impl.GroupQueryImpl;
import org.camunda.bpm.engine.impl.Page;
import org.camunda.bpm.engine.impl.interceptor.CommandContext;
import org.camunda.bpm.engine.impl.interceptor.CommandExecutor;

import ltrc.CustomIdentityService.domain.Group;

/**
 * Created by ashlah on 28/07/17.
 */
public class CustomGroupQuery extends GroupQueryImpl {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomGroupQuery() {
        super();
    }

    public CustomGroupQuery(CommandExecutor commandExecutor) {
        super(commandExecutor);
    }

    @Override
    public long executeCount(CommandContext commandContext) {
        final CustomIdentityProvider provider = getCustomIdentityProvider(commandContext);
        return provider.findGroupCountByQueryCriteria(this);
    }

    @Override
    public List<org.camunda.bpm.engine.identity.Group> executeList(CommandContext commandContext, Page page) {
        final CustomIdentityProvider provider = getCustomIdentityProvider(commandContext);
        return provider.findGroupByQueryCriteria(this);
    }

    protected CustomIdentityProvider getCustomIdentityProvider(CommandContext commandContext) {
        return (CustomIdentityProvider) commandContext.getReadOnlyIdentityProvider();
    }
}
