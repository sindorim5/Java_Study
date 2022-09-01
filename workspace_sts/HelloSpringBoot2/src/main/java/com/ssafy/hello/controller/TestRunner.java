package com.ssafy.hello.controller;

import java.util.Enumeration;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class TestRunner implements ApplicationRunner {

    private static final Logger log = LoggerFactory.getLogger(TestRunner.class);

    @Value("${user.username}")
    String name;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("user.username: {}", name);
        log.debug("user.username: {}", name);
        log.error("user.username: {}", name);
//        Properties props = System.getProperties(); // 시스템 properties
//        Enumeration e = props.propertyNames();
//        while (e.hasMoreElements()) {
//            String key = (String) e.nextElement();
//            String value = System.getProperty(key);
//
//            log.info("properties key:{}, value:{}", key, value);
//
//        }
    }

}
