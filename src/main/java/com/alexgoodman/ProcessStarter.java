package com.alexgoodman;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Timer;

public class ProcessStarter {
    static private boolean shutdownFlag;
    static private WebDriver driver;

    static private void init(){
        FirefoxDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
        driver = new FirefoxDriver();
        shutdownFlag = false;
    }

    public static void main(String[] args){
        try
        {
            daemonize();
        }
        catch (Throwable e)
        {
            System.err.println("Startup failed. " + e.getMessage());
        }

        registerShutdownHook();

        doProcessing();
    }

    static public void setShutdownFlag() {shutdownFlag = true;}

    private static void registerShutdownHook()
    {
        Runtime.getRuntime().addShutdownHook(
                new Thread() {
                    public void run() {
                        ProcessStarter.setShutdownFlag();
                    }
                }
        );
    }

    static private void doProcessing()
    {
        init();
        RouletBot bot = new RouletBot();
        bot.login();
        Timer timer = new Timer();
        ScheduledTask st = new ScheduledTask();
        timer.schedule(st, 0, 15000);
        while (false == shutdownFlag)
        {
           if(driver == null){
               break;
           }
        }
    }

    static private void daemonize() throws Exception
    {
        System.in.close();
        System.out.close();
    }

    public static WebDriver getDriver(){
        return driver;
    }
}
