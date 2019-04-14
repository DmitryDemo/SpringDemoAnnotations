package com.spring.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    @Value("${prop.email}")
    private String coachEmail;

    @Value("${prop.phone}")
    private String coachPhoneNumber;

    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    public TennisCoach() {
        System.out.println("> > > Inside default TennisCoach constructor.");
    }

    @Override
    public String getDailyWorkout() {
        return "Do some Tennis practice today!";
    }

    public String getCoachContacts() {
        return String.format("Coach's phone is %s and email '%s'", coachPhoneNumber, coachEmail);
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

//    @Autowired
//    public void doSomeCrazyStuff(FortuneService fortuneService) {
//        System.out.println("> > > Inside doSomeCrazyStuff method.");
//        this.fortuneService = fortuneService;
//    }

//    @Autowired
//    public TennisCoach(FortuneService fortuneService) {
//        this.fortuneService = fortuneService;
//    }
}
