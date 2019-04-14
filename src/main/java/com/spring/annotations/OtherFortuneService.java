package com.spring.annotations;

import org.springframework.stereotype.Component;

@Component
public class OtherFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "This is other Fortune service!";
    }
}
