package org.piyush.springlessons.beanlifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class MySpringBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("--- MySpringBeanFactoryPostProcessor#postProcessBeanFactory ---");

        final BeanDefinition mySpringBean = configurableListableBeanFactory.getBeanDefinition("mySpringBean");

        System.out.println(mySpringBean.getFactoryBeanName());
        System.out.println(mySpringBean.getInitMethodName());
    }
}
