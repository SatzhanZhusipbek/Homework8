package org.example;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class ConfigProperty implements InitializingBean {

    @Value("${button}")
    private String buttonValue;

    public void afterPropertiesSet() {
        if (!this.buttonValue.equals("ON") ) {
            throw new IllegalArgumentException("button must be on");
        }
    }
}
