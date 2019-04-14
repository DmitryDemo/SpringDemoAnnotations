package com.spring.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class HockeyCoach implements Coach {

    @Autowired
    @Qualifier("fileReaderFortuneService")
    private FortuneService fs;

    public HockeyCoach() {
    }

    @Override
    public String getDailyWorkout() {
        return "Do some hockey today!";
    }

    @Override
    public String getDailyFortune() {
        return fs.getFortune();
    }
}
