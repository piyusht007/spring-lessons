package org.piyush.springlessons.objectfactory;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.stereotype.Component;

@Component
public class SingleBean {
    private final ObjectFactory<ProtoBean> protoBeanObjectFactory;

    public SingleBean(ObjectFactory<ProtoBean> protoBeanObjectFactory) {
        this.protoBeanObjectFactory = protoBeanObjectFactory;
    }

    public ProtoBean getPrototypeBean(){
        return protoBeanObjectFactory.getObject();
    }
}
