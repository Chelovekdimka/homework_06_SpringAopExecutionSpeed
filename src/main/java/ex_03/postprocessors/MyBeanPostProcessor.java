package ex_03.postprocessors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {


    public Object postProcessAfterInitialization(Object object, String name) throws BeansException {
        System.err.println(object + " - postProcessAfterInitialization()");
        return object;
    }


    public Object postProcessBeforeInitialization(Object object, String name) throws BeansException {
        return object;
    }

}