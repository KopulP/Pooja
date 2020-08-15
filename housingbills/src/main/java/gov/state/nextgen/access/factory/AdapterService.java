package gov.state.nextgen.access.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import gov.state.nextgen.access.business.factory.EligibiltyScreenerInterface;

@Component
public class AdapterService{
    @Autowired
    private static ApplicationContext applicationContext;

    public static EligibiltyScreenerInterface getService(String name){
    	AnnotationConfigApplicationContext springContext = new AnnotationConfigApplicationContext(LogicWrapperBeanConfig.class);
        return (EligibiltyScreenerInterface) springContext.getBean(name);
    }
}
