package com.csair.log_service_a.config;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component("randomTagGenerator")
public class RandomTagGenerator {

    private final Random random = new Random();


    public String nextTag() {
        return random.nextBoolean() ? "A" : "B";
    }


}