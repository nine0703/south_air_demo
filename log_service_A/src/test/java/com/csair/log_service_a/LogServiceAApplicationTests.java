package com.csair.log_service_a;

import com.csair.log_service_a.config.RandomTagGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LogServiceAApplicationTests {
    @Autowired
    private RandomTagGenerator randomTagGenerator;

    @Test
    void contextLoads() {
        for (int i = 0; i < 10; i++) {
            System.out.println(randomTagGenerator.nextTag());
        }
    }

}
