package com.csair.log_service_a;

import cn.hutool.core.lang.generator.SnowflakeGenerator;
import org.junit.jupiter.api.Test;

public class BaseTest {
    @Test
    void contextLoads() {
        SnowflakeGenerator snowflakeGenerator = new SnowflakeGenerator(1, 1);
        for (int i = 0; i < 10; i++) {

            System.out.println(snowflakeGenerator.next());
        }

    }

}   // Class end.
