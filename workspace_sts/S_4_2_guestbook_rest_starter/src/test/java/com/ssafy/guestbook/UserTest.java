package com.ssafy.guestbook;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssafy.guestbook.model.MemberDto;
import com.ssafy.guestbook.model.service.UserService;

public class UserTest extends UnitTestConfig {
    
    private static final Logger logger = LoggerFactory.getLogger(UserTest.class);

    @Autowired
    private UserService userService;
    
    @BeforeClass
    public static void testClassStart() {
        logger.info("Test Class Start!!!!");
    }
    
    @AfterClass
    public static void testClassEnd() {
        logger.info("Test Class End!!!!");
    }
    
    @Before
    public void testStart() {
        logger.info("Test Start!!!!");
    }
    
    @After
    public void testEnd() {
        logger.info("Test End!!!!");
    }
    
    @Test
//    @Ignore
    public void nullTest() {
//        if(userService != null) {
//            logger.debug("userService : {}", userService);
//        }
        assertNotNull(userService);
        logger.debug("userService : {}", userService);
    }
    
    @Test
//    @Ignore
    public void login() throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        map.put("userid", "ssafy");
        map.put("userpwd", "ssafy");
        MemberDto memberDto = userService.login(map);
        assertNotNull(memberDto);
        logger.debug("memberDto : {}", memberDto);
    }
    
}
