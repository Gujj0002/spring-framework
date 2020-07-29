package org.learn.spring;

import org.learn.spring.aop.SpringModifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        SpringModifier modifier = context.getBean(SpringModifier.class);
        String string = "There was a boy in the park who was climbing on the tree.";
        String modifierString = modifier.replaceAll(string);

        System.out.println(modifierString);
        context.close();
    }
}
