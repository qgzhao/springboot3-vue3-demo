package com.cdvtc.demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private  PasswordEncoder passwordEncoder;

    @Test
    public  void testPasswordEncoder() {
        String password = "123456";
        String encodedPassword = passwordEncoder.encode(password);
        System.out.println("原始密码: " + password);
        System.out.println("加密后密码: " + encodedPassword);

        boolean isPasswordMatch = passwordEncoder.matches(password, encodedPassword);
        System.out.println("密码匹配结果: " + isPasswordMatch);
        assertTrue(isPasswordMatch);
    }

}