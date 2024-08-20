package com.csair.log_service_a;

import cn.hutool.core.lang.generator.SnowflakeGenerator;
import com.csair.log_service_a.config.SnowflakeConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class LogServiceAApplicationTests {
    @Autowired
    private SnowflakeGenerator snowflakeGenerator;

    @Test
    void contextLoads() {
        for (int i = 0; i < 10; i++) {
            System.out.println(snowflakeGenerator.next());
        }
    }

}
