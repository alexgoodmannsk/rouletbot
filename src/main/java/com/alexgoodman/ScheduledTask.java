package com.alexgoodman;

import java.util.TimerTask;

public class ScheduledTask extends TimerTask {

    private RouletBot bot;

    ScheduledTask(RouletBot bot){
        this.bot = bot;
    }

    @Override
    public void run() {
        String field = "36";
        String bet = "2000";
        bot.updatePage();
        if(!field.equals(bot.getLastSpin())){
            bot.bet(field, bet);
        }
    }
}
