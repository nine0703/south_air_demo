package com.csair.log_service_a.controller;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.lang.generator.SnowflakeGenerator;
import com.csair.log_service_a.bean.LogBean;
import com.csair.log_service_a.config.RandomTagGenerator;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

@RestController
@RequestMapping("/api/log")
@RequiredArgsConstructor
public class BaseController {

    private final SnowflakeGenerator snowflakeGenerator;        // 雪花算法生成器
    private final ExecutorService threadPool;                   // 自定义线程池
    private final RandomTagGenerator randomTagGenerator;        // 随机tag生成器
    //    private static final Logger logger = LogManager.getLogger(BaseController.class);
    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

//    private final Logger rootLogger;
//    private final Logger fileA;
//    private final Logger fileB;

    @GetMapping("/test")
    public String test() {
        LogBean logBean1 = new LogBean(
                snowflakeGenerator.next(),
                randomTagGenerator.nextTag(),
                null,
                DateTime.now());
        LogBean logBean2 = new LogBean(
                snowflakeGenerator.next(),
                randomTagGenerator.nextTag(),
                null,
                DateTime.now());

        threadPool.submit(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                logBean1.setThreadInfo(Thread.currentThread().getName());
                logBean2.setThreadInfo(Thread.currentThread().getName());
                logger.info(logBean1.toString());
                logger.info(logBean2.toString());
                return null;
            }
        });

        return null;
    }

    @GetMapping("/test2")
    public void test2() {
//        threadPool.execute(() -> {
//            String threadName = Thread.currentThread().getName();
//            logger.info("{}", threadName);
//        });

        for (int i = 0; i < 20000; i++) {
            Long id = snowflakeGenerator.next();
            LogBean logBean1 = new LogBean(
                    id,
                    randomTagGenerator.nextTag(),
                    null,
                    DateTime.now());
            LogBean logBean2 = new LogBean(
                    id,
                    randomTagGenerator.nextTag(),
                    null,
                    DateTime.now());
            threadPool.submit(new Callable<Void>() {
                @Override
                public Void call() throws Exception {
                    logger.info(logBean1.toString());
                    logger.info(logBean2.toString());
                    return null;
                }
            });
        }
    }

    @GetMapping("/handlerLog")
    public void handlerLog() {
        logger.info("handlerLog");
    }

}   // Class end.
