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
        User user1 = new User();
        user1.setAddress("C2-534");
        user1.setEmail("12@qq.com");
        user1.setUsername("user");
        user1.setPassword("123");
        user1.setEnabled(true);
        int insert = userDao.insert(user1);
        System.out.println(insert);
    }

    @Test
    void testEn() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode("123");
        System.out.println(encode);
    }

}
