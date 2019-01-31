package ltrc.CustomIdentityService.bpm.engine;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.camunda.bpm.engine.impl.cfg.ProcessEnginePlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ltrc.CustomIdentityService.bpm.engine.idservice.CustomIdentityProviderFactory;
import ltrc.CustomIdentityService.service.GroupService;
import ltrc.CustomIdentityService.service.UserService;

/**
 * Created by ashlah on 28/07/17.
 */
@Component
public class CustomIdentityProviderPlugin implements ProcessEnginePlugin {

    private final UserService userService;

    private final GroupService groupService;

    @Autowired
    public CustomIdentityProviderPlugin(UserService userService, GroupService groupService) {
        this.userService = userService;
        this.groupService = groupService;
    }

    @Override
    public void preInit(ProcessEngineConfigurationImpl processEngineConfiguration) {
    	processEngineConfiguration.setHistory("audit");
    	
    	CustomIdentityProviderFactory identityProviderFactory = new CustomIdentityProviderFactory(userService, groupService);
        processEngineConfiguration.setIdentityProviderSessionFactory(identityProviderFactory);
        
    	System.out.println("preInit..........................");
    }

    @Override
    public void postInit(ProcessEngineConfigurationImpl processEngineConfiguration) {

    }

    @Override
    public void postProcessEngineBuild(ProcessEngine processEngine) {
    	System.out.println("Users:................. = " + processEngine.getIdentityService().createUserQuery().count());
    	processEngine.getIdentityService().createUserQuery().list().forEach(System.out::println);
    	System.out.println("By Service.... = " + userService.findAll().size());
    	userService.findAll().forEach(System.out::println);
    }
    

}
