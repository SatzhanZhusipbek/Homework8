package org.example;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class MyConfiguration {

    @Bean
    @ConditionalOnProperty(name="button", havingValue = "true", matchIfMissing = true)
    public BeanMessage ThisIsMyFirstConditionalBean() {
        return new BeanMessage("The bean has been created.");
    }
}
