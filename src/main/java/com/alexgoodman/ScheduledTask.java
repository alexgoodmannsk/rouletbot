package com.alexgoodman;

import java.util.TimerTask;

public class ScheduledTask extends TimerTask {
    @Override
    public void run() {
        RouletBot bot = new RouletBot();
        bot.updatePage();
    }
}
