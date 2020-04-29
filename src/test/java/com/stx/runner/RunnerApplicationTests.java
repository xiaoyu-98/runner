package com.stx.runner;

import com.stx.runner.dao.ExpressDao;
import com.stx.runner.dao.UserDao;
import com.stx.runner.entity.Express;
import com.stx.runner.entity.User;
import com.stx.runner.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.awt.print.Pageable;
import java.util.Date;

@SpringBootTest
class RunnerApplicationTests {

    @Autowired
    UserDao userDao;
    @Autowired
    ExpressDao expressDao;

    @Test
    void test() {
        Express express = new Express();
        express.setCreateTime(new Date());
        express.setNumber(222);
        express.setName("2222");
        express.setOrderStatus(1);
        express.setPaddress("223");
        express.setRaddress("222");
        express.setPhone("22222");
        express.setRprice(22);
        express.setType("yuan");
        int id =1;
        expressDao.insertExpress(express,id);
    }

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
