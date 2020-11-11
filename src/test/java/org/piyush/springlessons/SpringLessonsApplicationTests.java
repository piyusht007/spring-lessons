package org.piyush.springlessons;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.piyush.springlessons.lookupmethodinjection.MySingletonBean;
import org.piyush.springlessons.objectfactory.SingleBean;
import org.piyush.springlessons.provider.SBean;
import org.piyush.springlessons.scopedproxy.PrototypeBean;
import org.piyush.springlessons.scopedproxy.SingletonBean;
import org.springframework.aop.framework.Advised;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringLessonsApplicationTests {
    @Autowired
    MySingletonBean mySingletonBean;

    @Autowired
    SingletonBean singletonBean;

    @Autowired
    SingleBean singleBean;

    @Autowired
    SBean sBean;

    @Test
    void contextLoads() throws Exception {
        validateLookupMethodInjection();
        validateScopedProxy();
        validateObjectFactory();
        validateJSR330Provider();
    }

    private void validateJSR330Provider() {
        Assertions.assertFalse(sBean.getPrototypeBean() == sBean.getPrototypeBean());
    }

    private void validateObjectFactory() {
        // Check for objectFactory based prototype injection
        Assertions.assertFalse(singleBean.getPrototypeBean() == singleBean.getPrototypeBean());
    }

    private void validateScopedProxy() throws Exception {
        // Note: As scoped proxy is being injected in place of prototype bean, we have to obtain
        // the real object being proxied.
        // Then checking if obtained prototype bean objects are different.
        // Ref: https://stackoverflow.com/questions/32295987/using-aop-scoped-proxy-to-autowire-prototype-bean-in-a-singleton-bean
        final PrototypeBean firstPrototypeBean = (PrototypeBean) ((Advised) singletonBean.getPrototypeBean()).getTargetSource().getTarget();
        final PrototypeBean secondPrototypeBean = (PrototypeBean) ((Advised) singletonBean.getPrototypeBean()).getTargetSource().getTarget();
        Assertions.assertFalse(firstPrototypeBean == secondPrototypeBean);
    }

    private void validateLookupMethodInjection() {
        Assertions.assertFalse(mySingletonBean.getMyPrototypeBean() ==
                mySingletonBean.getMyPrototypeBean());
    }

}
