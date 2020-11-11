package org.piyush.springlessons.provider;

import org.springframework.stereotype.Component;

import javax.inject.Provider;


@Component
public class SBean {
    private final Provider<PBean> pBeanProvider;

    public SBean(Provider<PBean> pBeanProvider) {
        this.pBeanProvider = pBeanProvider;
    }

    public PBean getPrototypeBean(){
        return pBeanProvider.get();
    }
}
