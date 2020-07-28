package org.learn.spring.aop;

import org.springframework.stereotype.Component;

@Component
public class SpringModifier {

    public String replaceAll(String A){
        System.out.println("Given string is being replaced..");
        return A.replace('a', 'A');
    }
}
