package com.csair.openfeign.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "log-service-a", path = "/api/log")
public interface LogServiceA {

    @RequestMapping("/test")
    String test();

    @RequestMapping("/handlerLog")
    void handlerLog();

}   // Class end.
