package com.stx.runner;

import com.stx.runner.dao.UserDao;
import com.stx.runner.entity.User;
import com.stx.runner.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.awt.print.Pageable;

@SpringBootTest
class RunnerApplicationTests {

    @Autowired
    UserDao userDao;
    @Test
    void contextLoads() {
        User user = userDao.queryById(1);
        System.out.println(user);
    }

    @Test
    void testEn() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode("123");
        System.out.println(encode);
    }


}
