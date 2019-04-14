package com.spring.annotations;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {

    private String[] serviceMessages = {
            "Random Fornue One",
            "Random Fornue Two",
            "Random Fornue Three"
    };

    private Random rnd = new Random();

    @Override
    public String getFortune() {

        int index = rnd.nextInt(serviceMessages.length);
        return serviceMessages[index];
    }
}
