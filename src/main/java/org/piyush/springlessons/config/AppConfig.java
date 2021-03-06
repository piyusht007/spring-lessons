package org.piyush.springlessons.config;

import org.piyush.springlessons.beanlifecycle.MySpringBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    // This can be replaced by annotating MySpringBean with @Component
    // But to define custom init and destroy methods we've to use @Bean
    @Bean(initMethod = "init", destroyMethod = "destroy")
    MySpringBean mySpringBean(){
        return new MySpringBean();
    }
}
