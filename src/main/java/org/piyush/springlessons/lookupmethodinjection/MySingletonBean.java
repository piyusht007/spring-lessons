package org.piyush.springlessons.lookupmethodinjection;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class MySingletonBean {
    final MyPrototypeBean myPrototypeBean;

    public MySingletonBean(MyPrototypeBean myPrototypeBean) {
        this.myPrototypeBean = myPrototypeBean;
    }

    public int getPrototypeBeanHashcode() {
        return getMyPrototypeBean().hashCode();
    }

    @Lookup
    public MyPrototypeBean getMyPrototypeBean() {
        return null;
    }
}
