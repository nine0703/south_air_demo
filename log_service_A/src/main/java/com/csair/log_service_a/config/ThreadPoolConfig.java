package com.csair.log_service_a.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class ThreadPoolConfig {

    @Bean
    public ThreadPoolExecutor customThreadPool() {
        int corePoolSize = 0;
        int maximumPoolSize = 5;
        long keepAliveTime = 5000;
        TimeUnit unit = TimeUnit.MILLISECONDS;
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>();
        return new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @EventListener(ContextClosedEvent.class)
    public void shutdownThreadPool(ContextClosedEvent event) {
        ThreadPoolExecutor threadPool = event.getApplicationContext().getBean(ThreadPoolExecutor.class);
        try {
            threadPool.shutdown();
            if (! threadPool.awaitTermination(8000, TimeUnit.MILLISECONDS)) {
                threadPool.shutdownNow();
            }
        } catch (InterruptedException e) {
            threadPool.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

}