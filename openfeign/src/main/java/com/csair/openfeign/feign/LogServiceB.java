package com.csair.openfeign.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "log-service-b", path = "/api/log")
public interface LogServiceB {

}   // Class end.
