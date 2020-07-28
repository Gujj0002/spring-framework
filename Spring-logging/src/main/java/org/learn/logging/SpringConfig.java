package org.learn.logging;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("org.learn.*")
@EnableAspectJAutoProxy
public class SpringConfig {

}
