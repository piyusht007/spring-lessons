package org.piyush.springlessons.lookupmethodinjection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class MyPrototypeBean {
    @Value("${message:hello-world}")
    private String message;

    public String getMessage() {
        return message;
    }
}
