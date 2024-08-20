package com.csair.log_service_a.controller;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.lang.generator.SnowflakeGenerator;
import com.csair.log_service_a.bean.LogBean;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;

@Slf4j
@RestController
@RequestMapping("/api/log")
@RequiredArgsConstructor
public class BaseController {

    private final SnowflakeGenerator snowflakeGenerator;        // 雪花算法生成器
    private final ExecutorService threadPool;                   // 自定义线程池
    private final Logger rootLogger;
//    private final Logger fileA;
//    private final Logger fileB;

    @GetMapping("/test")
    public String test() {
        log.info("启动");
        rootLogger.info("test");
        LogBean logBean = new LogBean(snowflakeGenerator.next(), "A", DateTime.now());
        log.info("{}", logBean);
        return logBean.toString();
    }

    public void test2() {
        threadPool.execute(() -> {
            log.info("log_service_A test2");
        });
    }

    @GetMapping("/handlerLog")
    public void handlerLog() {
        log.info("handlerLog");
    }

}   // Class end.
