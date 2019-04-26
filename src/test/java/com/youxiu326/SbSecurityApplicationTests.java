package com.youxiu326;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SbSecurityApplicationTests {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void contextLoads() {

        String password = passwordEncoder.encode("111111");
        System.out.println(password);
        System.out.println(password);
        System.out.println(password);

    }

}
