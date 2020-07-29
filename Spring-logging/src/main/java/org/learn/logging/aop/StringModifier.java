package org.learn.logging.aop;

import org.learn.logging.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class StringModifier {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public String replaceAll(String A){
        logger.info("Given string is being replaced..");
        return A.replace('a', 'A');
    }
}
