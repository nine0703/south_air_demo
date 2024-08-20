package com.csair.log_service_a.config;

import cn.hutool.core.lang.generator.SnowflakeGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SnowflakeConfig {

    /**
     * 返回雪花算法生成器
     * @return
     */
    @Bean
    public static SnowflakeGenerator snowflakeGenerator() {
        return new SnowflakeGenerator(1, 1);
    }


}   // Class end.
