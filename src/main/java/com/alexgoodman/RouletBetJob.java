package com.alexgoodman;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class RouletBetJob implements Job {
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        RouletBot bot = new RouletBot();
        bot.updatePage();
    }
}
