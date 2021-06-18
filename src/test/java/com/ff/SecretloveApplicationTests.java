package com.ff;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class SecretloveApplicationTests {

    @Test
    void contextLoads() {

        int a=0;
        try {
            a=1;
            System.out.println("try");
            throw new RuntimeException();

        }catch (Exception e){
            a=2;
            System.out.println("进来了catch");
            e.printStackTrace();
        }
        System.out.println(a);
    }

}
