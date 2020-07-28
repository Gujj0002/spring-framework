package org.learn.logging;

import org.learn.logging.aop.StringModifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        Logger logger = LoggerFactory.getLogger(Application.class);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        StringModifier modifier = context.getBean(StringModifier.class);
        String string = "There was a boy in the park who was climbing on the tree.";
        String modifierString = modifier.replaceAll(string);

        logger.debug("Message from main:{}",modifierString);
        context.close();
    }
}
