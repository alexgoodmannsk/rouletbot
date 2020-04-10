package com.alexgoodman;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
@Log4j2
public class ScheduledTask  {

    private RouletteBot bot;

    @Autowired
    ScheduledTask(RouletteBot bot){
        this.bot = bot;
    }

    @Scheduled(fixedRate = 300000)
    public void run() {
        bot.login();
        bot.updatePage();
        if(bot.getCurrentGold()<2200000){
            bot.bet( "36", "100");
            bot.bet("15", "100");
        }
    }
}
