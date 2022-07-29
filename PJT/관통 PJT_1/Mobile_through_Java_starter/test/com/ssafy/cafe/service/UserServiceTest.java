package com.ssafy.cafe.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Ignore;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.ssafy.cafe.model.dto.User;

class UserServiceTest extends AbstractServiceTest {
    private User testUser = new User("test", "test", "test", 0);


    @Test
    @Order(1)
    void loginTest() {
        User selected = userService.login(user.getId(), user.getPass());
        assertEquals("name 01", selected.getName() );

    }
    
    @Test
    @Order(2)
    void joinTest() {
        // 회원 가입은 예외만 없으면 진행
        userService.join(testUser);

        // 동일 사용자 회원 가입 시 예외 발생할것
        assertThrows(Exception.class, () -> {
            userService.join(testUser);
        });

    }

    @Test
    @Order(3)
    void loginSuccessAndFailTest() {
        User selected = userService.login(testUser.getId(), testUser.getPass());
        assertEquals(testUser.getName(), selected.getName());
        
        selected = userService.login("some", "some");
        assertNull(selected);
    }

    @Test
    @Order(4)
    void leaveTest() {
        userService.leave(testUser.getId());
        User selected = userService.login(testUser.getId(), testUser.getPass());
        assertNull(selected);
    }

    @Test
    @Order(5)
    void isUsedTest() {
        assertEquals(userService.isUsedId(user.getId()), true) ;
        assertEquals(userService.isUsedId(testUser.getId()), false);
    }

}
